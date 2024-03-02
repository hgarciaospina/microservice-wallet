package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.List;

public record Currency(String value) {
    public Currency {
        if (value == null) {
            throw new WalletGenericClientException("You must enter a type of currency.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        this.ensureIsValidCurrency(value);
    }
    private void ensureIsValidCurrency(String value){
        List<String> currencyList = List.of("USD");
        if(!currencyList.contains(value))
            throw new WalletGenericClientException("Currency is invalid",
                    "400",
                    HttpStatus.BAD_REQUEST);
    }
}