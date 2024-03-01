package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Email(String value) {
    public Email(String value) {
        this.value = value;
        this.ensureIsValidEmail(value);
    }
    private void ensureIsValidEmail(String value){
        if(!value.matches("^[a-zA-Z._%+-]+@(?:hotmail\\.com|gmail\\.com|outlook\\.com)(?:\\.[a-zA-Z]{2,}){1,2}$")){
            throw new WalletGenericClientException("Email is invalid",
                    "404",
                    HttpStatus.BAD_REQUEST);
        }
    }
}