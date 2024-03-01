package com.digitalwallet.walletservice.domain;

import com.digitalwallet.walletservice.domain.value_object.*;
public class Customer {
    private final FirstName firstName;
    private final LastName lastName;
    private final DocumentNumber documentNumber;
    private final PhoneNumber phoneNumber;
    private final DocumentType documentType;
    private final Email email;

    public Customer(String firstName, String lastName, String documentNumber,
                    String phoneNumber, String documentType, String email) {
        this.firstName = new FirstName(firstName);
        this.lastName =  new LastName(lastName);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.documentType = new DocumentType(documentType);
        this.email = new Email(email);
    }

    public String getFirstName() {
        return this.firstName.value();
    }

    public String getLastName() {
        return this.lastName.value();
    }

    public String getDocumentNumber() {
        return this.documentNumber.value();
    }

    public String getPhoneNumber() {
        return this.phoneNumber.value();
    }

    public String getDocumentType() {
        return this.documentType.value();
    }

    public String getEmail() {
        return this.email.value();
    }
}