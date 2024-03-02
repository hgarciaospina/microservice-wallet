package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record DocumentNumber(String value) {
    public DocumentNumber{
        if (value == null) {
            throw new WalletGenericClientException("You must enter a document number.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        this.ensureIsValidDocumentNumber(value);
    }
    private void ensureIsValidDocumentNumber(String value){
        if (!value.matches("^[1-9]\\d{7}$"))
            throw new WalletGenericClientException("Document number is invalid",
                    "400",
                    HttpStatus.BAD_REQUEST);
    }
}