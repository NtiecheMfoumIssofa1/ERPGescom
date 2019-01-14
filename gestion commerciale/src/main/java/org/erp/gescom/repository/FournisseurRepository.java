package org.erp.gescom.repository;

import org.erp.gescom.domain.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface FournisseurRepository extends MongoRepository<Fournisseur, String>{

}
