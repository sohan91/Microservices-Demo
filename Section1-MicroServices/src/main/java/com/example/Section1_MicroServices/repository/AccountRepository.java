package com.example.Section1_MicroServices.repository;

import com.example.Section1_MicroServices.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByCustomerId(Long aLong);
}
