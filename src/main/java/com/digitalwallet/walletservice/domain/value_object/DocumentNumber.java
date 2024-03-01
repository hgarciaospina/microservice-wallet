package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record DocumentNumber(String value) {
    public DocumentNumber(String value) {
        this.value = value;
        this.ensureIsValidDocumentNumber(value);
    }
    private void ensureIsValidDocumentNumber(String value){
        if (!value.matches("^[1-9]\\d{7}$"))
            throw new WalletGenericClientException("Document number is invalid",
                    "404",
                    HttpStatus.BAD_REQUEST);
    }
}