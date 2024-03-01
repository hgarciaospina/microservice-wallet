package com.digitalwallet.walletservice.domain;

public interface WalletRepository {
    void save(Wallet wallet);
    void update(Wallet wallet);
    Wallet findByPhoneNumber(String phoneNumber);
    Wallet findById(String walletId);
}