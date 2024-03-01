package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record FirstName(String value){
    public FirstName(String value){
        this.value = value;
        this.ensureIsValidFirstName(value);
    }
    private void ensureIsValidFirstName(String value){
        if(!value.matches("^[A-Za-záéíóúñ'\\s]+(?:[A-Za-záéíóúñ'\\s]+)*$"))
            throw new WalletGenericClientException("First name is invalid",
                    "404",
                    HttpStatus.BAD_REQUEST);
    }
}
