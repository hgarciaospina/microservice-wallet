package com.digitalwallet.walletservice.domain.exceptions;

import lombok.Getter;

@Getter
public class WalletGenericClientException extends RuntimeException{
   private final HttpStatus httpStatus;

   private final String code;

   public WalletGenericClientException(String message, HttpStatus httpStatus){
       super(message);
       this.httpStatus = httpStatus;
       code = "";
   }

    public WalletGenericClientException(String message, String code, HttpStatus httpStatus){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}