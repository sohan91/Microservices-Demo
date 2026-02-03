package com.example.Section1_MicroServices.mapper;


import com.example.Section1_MicroServices.dto.AccountDto;
import com.example.Section1_MicroServices.dto.CustomerDto;
import com.example.Section1_MicroServices.entity.Account;
import com.example.Section1_MicroServices.entity.Customer;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account,AccountDto accountDto)
    {
            accountDto.setAccountNumber(account.getAccountNumber());
            accountDto.setAccountType(account.getAccountType());
            accountDto.setBranchAddress(account.getBranchAddress());
            return accountDto;
    }

    public static Account mapToAccount(Account account,AccountDto accountDto)
    {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
