package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public record DocumentType(String value) {
    public DocumentType{
        if (value == null) {
            throw new WalletGenericClientException("You must enter a document type.",
                    "400",
                    HttpStatus.BAD_REQUEST);
        }
        this.ensureIsValidTypeDocument(value);
    }

    private void ensureIsValidTypeDocument(String value){
        List<String> typeDocumentList = Arrays.asList("DNI", "RUC");
        if(!typeDocumentList.contains(value))
            throw new WalletGenericClientException("Document type is invalid.",
                    "400",
                    HttpStatus.BAD_REQUEST);
    }
}