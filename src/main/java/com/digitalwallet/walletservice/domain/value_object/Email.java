package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Email(String value) {
    public Email {
        if (value == null) {
            throw new WalletGenericClientException("You must enter an email.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        ensureIsValidEmail(value);
    }

    private void ensureIsValidEmail(String value){
        if (!value.matches("^[a-zA-Z0-9._%+-]+@(?:hotmail\\.com|gmail\\.com|outlook\\.com)$")) {
            throw new WalletGenericClientException("Email is invalid",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
    }
}