package com.example.Section1_MicroServices.mapper;

import com.example.Section1_MicroServices.dto.AccountDto;
import com.example.Section1_MicroServices.dto.CustomerDto;
import com.example.Section1_MicroServices.entity.Account;
import com.example.Section1_MicroServices.entity.Customer;

import java.time.LocalDate;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto)
    {
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setName(customer.getCustomerName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public static Customer mapToCustomer(Customer customer, CustomerDto customerDto)
    {
        customer.setCustomerName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
