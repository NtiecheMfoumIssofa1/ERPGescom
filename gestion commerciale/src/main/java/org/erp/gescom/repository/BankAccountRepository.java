package org.erp.gescom.repository;

import org.erp.gescom.domain.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the BankAccount entity.
 */

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {

}
