package com.digitalwallet.walletservice.domain;

import com.digitalwallet.walletservice.domain.value_object.Balance;
import com.digitalwallet.walletservice.domain.value_object.Currency;

import java.math.BigDecimal;

public class Wallet {
    private String walletId;
    private final Balance balance;
    private final Currency currency;
    private final Customer customer;

    public Wallet(String walletId, BigDecimal balance, String currency, Customer customer) {
        this.walletId = walletId;
        this.balance = new Balance(balance);
        this.currency = new Currency(currency);
        this.customer = new Customer(
                  customer.getFirstName()
                , customer.getLastName()
                , customer.getDocumentNumber()
                , customer.getPhoneNumber()
                , customer.getDocumentType(),
                  customer.getEmail());
    }
    public Wallet(BigDecimal balance, String currency, Customer customer) {
        this.balance = new Balance(balance);
        this.currency = new Currency(currency);
        this.customer = new Customer(
                  customer.getFirstName()
                , customer.getLastName()
                , customer.getDocumentNumber()
                , customer.getPhoneNumber()
                , customer.getDocumentType()
                , customer.getEmail());
    }
    public String getWalletId() {
        return this.walletId;
    }

    public BigDecimal getBalance() {
        return this.balance.value();
    }

    public String getCurrency() {
        return this.currency.value();
    }

    public Customer getCustomer() {
        return this.customer;
    }

}