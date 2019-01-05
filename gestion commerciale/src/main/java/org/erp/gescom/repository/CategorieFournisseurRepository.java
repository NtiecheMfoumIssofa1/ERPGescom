package org.erp.gescom.repository;

import org.erp.gescom.domain.CategorieFournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategorieFournisseurRepository extends MongoRepository<CategorieFournisseur, String>{

}
