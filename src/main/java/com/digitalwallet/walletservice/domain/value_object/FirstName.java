package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record FirstName(String value){
    public FirstName{
        if (value == null) {
            throw new WalletGenericClientException("You must enter a first name.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        this.ensureIsValidFirstName(value);
    }
    private void ensureIsValidFirstName(String value){
        if(!value.matches("^[A-Za-záéíóúÁÉÍÓÚüÜñÑ'\\s]++([A-Za-záéíóúÁÉÍÓÚüÜñÑ'\\s]++)*+$"))
            throw new WalletGenericClientException("First name is invalid",
                    "400",
                    HttpStatus.BAD_REQUEST);
    }
}