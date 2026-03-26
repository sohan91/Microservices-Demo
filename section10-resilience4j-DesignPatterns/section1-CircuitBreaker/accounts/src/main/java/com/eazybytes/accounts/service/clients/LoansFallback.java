package com.eazybytes.accounts.service.clients;

import com.eazybytes.accounts.dto.CardsDto;
import com.eazybytes.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansOpenFeign{



    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
