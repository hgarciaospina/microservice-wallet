package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record LastName(String value){
    public LastName(String value){
        this.value = value;
        this.ensureIsValidLastName(value);
    }
    private void ensureIsValidLastName(String value){
        if(!value.matches( "^[A-Za-záéíóúñ'\\s]+(?:[A-Za-záéíóúñ'\\s]+)*$"))
            throw new WalletGenericClientException("Last name is invalid",
                    "404",
                    HttpStatus.BAD_REQUEST);
    }
}