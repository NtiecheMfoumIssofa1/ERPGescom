package org.erp.gescom.repository;

import org.erp.gescom.domain.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends MongoRepository<Facture, String>{

}
