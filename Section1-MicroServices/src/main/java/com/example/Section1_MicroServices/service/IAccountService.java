package com.example.Section1_MicroServices.service;

import com.example.Section1_MicroServices.dto.AccountDto;
import com.example.Section1_MicroServices.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String phoneNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteCustomer(String mobile);
}
