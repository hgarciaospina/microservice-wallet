package com.digitalwallet.walletservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WalletMongoRepository extends MongoRepository<WalletDocument, String> {
    Boolean existsByCustomerDocumentNumberOrCustomerPhoneNumber(String documentNumber,
                                                                String phoneNumber);
    Optional<WalletDocument> findByCustomerPhoneNumber(String phoneNumber);
}