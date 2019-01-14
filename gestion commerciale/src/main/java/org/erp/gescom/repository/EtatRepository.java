package org.erp.gescom.repository;

import org.erp.gescom.domain.Etat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface EtatRepository extends MongoRepository<Etat, String>{

}
