package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.ICustomerService;
import com.eazybytes.accounts.service.clients.CardsOpenFeignClient;
import com.eazybytes.accounts.service.clients.LoansOpenFeign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsOpenFeignClient cardsOpenFeignClient;
    private LoansOpenFeign loansOpenFeign;

    @Override
    public CustomerDetailsDto findByNumber(String number) {

    }
}
