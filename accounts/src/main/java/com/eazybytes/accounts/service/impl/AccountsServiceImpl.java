package com.eazybytes.accounts.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.AccountsMsgDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountsService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService{
	
    private static final Logger log = LoggerFactory.getLogger(AccountsServiceImpl.class);

	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	private final StreamBridge streamBridge;
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		if(customerRepository.findByMobileNumber(customerDto.getMobileNumber()).isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + customerDto.getMobileNumber());
		}
		Customer customer = CustomerMapper.mapToCustomer(customerDto);
		Customer savedCustomer = customerRepository.save(customer);
		Accounts savedAccounts = accountsRepository.save(createNewAccount(savedCustomer));
		sendCommunication(savedAccounts, savedCustomer);
	}
	
    private void sendCommunication(Accounts account, Customer customer) {
        var accountsMsgDto = new AccountsMsgDto(account.getAccountNumber(), customer.getName(),
                customer.getEmail(), customer.getMobileNumber());
        log.info("Sending Communication request for the details: {}", accountsMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", accountsMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }
	
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));
		
		Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Customer Id", customer.getCustomerId().toString()));
		
		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account));
		return customerDto;
	}

	@Transactional
	@Override
	public CustomerDto updateAccount(CustomerDto customerDto) {
		AccountsDto accountsDto = customerDto.getAccountsDto();

		Accounts account = accountsRepository.findById(accountsDto.getAccountNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Account", "Account Number", accountsDto.getAccountNumber().toString()));
		
		Customer customer = customerRepository.findById(account.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer ID", account.getCustomerId().toString()));
		
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		
		customerRepository.save(customer);
		
		account.setAccountNumber(account.getAccountNumber());
		account.setAccountType(customerDto.getAccountsDto().getAccountType());
		account.setBranchAddress(customerDto.getAccountsDto().getBranchAddress());
		
		accountsRepository.save(account);
		
		CustomerDto customerDto2 = CustomerMapper.mapToCustomerDto(customer);
		
		AccountsDto accountsDto2 = AccountsMapper.mapToAccountsDto(account);
		
		customerDto2.setAccountsDto(accountsDto2);
		
		return customerDto2;
	}

	@Transactional
	@Override
	public void deleteAccount(String mobileNumber) {
		Customer customer = customerRepository
				.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));
		
		customerRepository.delete(customer);
		accountsRepository.deleteByCustomerId(customer.getCustomerId());
	}
	
    @Override
    public boolean updateCommunicationStatus(Long accountNumber) {
        boolean isUpdated = false;
        if(accountNumber !=null ){
            Accounts accounts = accountsRepository.findById(accountNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountNumber.toString())
            );
            accounts.setCommunicationSw(true);
            accountsRepository.save(accounts);
            isUpdated = true;
        }
        return  isUpdated;
    }
}
