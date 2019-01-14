package org.erp.gescom.repository;

import org.erp.gescom.domain.Devis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface DevisRepository extends MongoRepository<Devis, String>{

}
