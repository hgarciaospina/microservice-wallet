package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record LastName(String value){
    public LastName{
        if (value == null) {
            throw new WalletGenericClientException("You must enter a last name.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        this.ensureIsValidLastName(value);
    }
    private void ensureIsValidLastName(String value){
        if(!value.matches( "^[A-Za-záéíóúñ'\\s]+(?:[A-Za-záéíóúñ'\\s]+)*$"))
            throw new WalletGenericClientException("Last name is invalid",
                    "404",
                    HttpStatus.BAD_REQUEST);
    }
}