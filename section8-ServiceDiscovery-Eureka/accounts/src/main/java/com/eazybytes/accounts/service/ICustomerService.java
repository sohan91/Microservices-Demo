package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerService{
    CustomerDetailsDto findByNumber(String number);
}
