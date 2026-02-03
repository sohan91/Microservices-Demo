package com.example.Section1_MicroServices.service.impl;

import com.example.Section1_MicroServices.constants.AccountConstants;
import com.example.Section1_MicroServices.dto.AccountDto;
import com.example.Section1_MicroServices.dto.CustomerDto;
import com.example.Section1_MicroServices.entity.Account;
import com.example.Section1_MicroServices.entity.Customer;
import com.example.Section1_MicroServices.exception.CustomerAlreadyExistException;
import com.example.Section1_MicroServices.exception.ResourceNotFoundException;
import com.example.Section1_MicroServices.mapper.AccountMapper;
import com.example.Section1_MicroServices.mapper.CustomerMapper;
import com.example.Section1_MicroServices.repository.AccountRepository;
import com.example.Section1_MicroServices.repository.CustomerRepository;
import com.example.Section1_MicroServices.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Optional<Customer> optionalCustomer =
                customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException(
                    "Customer already exist with this mobile number: " + customerDto.getMobileNumber()
            );
        }

        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);

        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }


    @Transactional
    private Account createNewAccount(Customer customer) {

        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());

        long randomAcNumber = 100_000_00_0L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAcNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);

        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String phoneNumber) {

        Customer customer = customerRepository.findByMobileNumber(phoneNumber).orElseThrow(()->new ResourceNotFoundException("Customer","mobileNumber",phoneNumber));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString()));
      CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
      customerDto.setAccountDto(AccountMapper.mapToAccountDto(account,new AccountDto()));
      return customerDto;
    }

    @Transactional
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccountDto();
        if(accountDto != null)
        {
            Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    ()->new ResourceNotFoundException("Account","AccountNumber",accountDto.getAccountNumber().toString())
            );
            AccountMapper.mapToAccount(account,accountDto);
            account = accountRepository.save(account);

            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
            ()->new ResourceNotFoundException("Customer","CustomerID",customerId.toString())
            );

            CustomerMapper.mapToCustomer(customer,customerDto);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Transactional
    @Override
    public boolean deleteCustomer(String mobile) {
        Customer customer = customerRepository.findByMobileNumber(mobile).orElseThrow(
                ()->new ResourceNotFoundException("Customer","mobileNumber",mobile.toString())
        );
        accountRepository.deleteById(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

}
