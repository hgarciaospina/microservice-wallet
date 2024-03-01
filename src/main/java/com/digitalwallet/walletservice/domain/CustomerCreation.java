package com.digitalwallet.walletservice.domain;
public record CustomerCreation(
        String firstName,
        String lastName,
        String documentNumber,
        String phoneNumber,
        String documentType,
        String email){}