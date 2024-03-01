package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepository {
    private final WalletMongoRepository walletMongoRepository;
    private final WalletPersistenceMapper walletPersistenceMapper;

    @Override
    public void save(Wallet wallet) {

        Boolean existsByCustomerDocumentNumberOrCustomerPhoneNumber = walletMongoRepository
                .existsByCustomerDocumentNumberOrCustomerPhoneNumber(wallet.getCustomer().getDocumentNumber()
                        , wallet.getCustomer().getPhoneNumber());

        if (Boolean.TRUE.equals(existsByCustomerDocumentNumberOrCustomerPhoneNumber)) {
            throw new WalletGenericClientException("Wallet already exist", HttpStatus.CONFLICT);
        }

        WalletDocument walletDocumentCreated = walletMongoRepository.save(
                walletPersistenceMapper.toDocument(wallet)
        );
        walletPersistenceMapper.toDomain(walletDocumentCreated);
    }

    @Override
    public void update(Wallet wallet) {
        WalletDocument walletDocumentCreated = walletMongoRepository.save(
                walletPersistenceMapper.toDocument(wallet)
        );
        walletPersistenceMapper.toDomain(walletDocumentCreated);
    }

    @Override
    public Wallet findByPhoneNumber(String phoneNumber) {
        WalletDocument walletDocumentFound = walletMongoRepository
                .findByCustomerPhoneNumber(phoneNumber)
                .orElseThrow(() -> new WalletGenericClientException("Wallet not found", HttpStatus.NOT_FOUND));
        return walletPersistenceMapper.toDomain(walletDocumentFound);
    }

    @Override
    public Wallet findById(String walletId) {
        WalletDocument walletDocument = walletMongoRepository
                .findById(walletId)
                .orElseThrow(() -> new WalletGenericClientException("Wallet not found", HttpStatus.NOT_FOUND));
        return walletPersistenceMapper.toDomain(walletDocument);
    }
}