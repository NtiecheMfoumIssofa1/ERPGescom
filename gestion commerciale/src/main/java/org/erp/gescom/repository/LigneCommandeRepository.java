package org.erp.gescom.repository;

import org.erp.gescom.domain.LigneCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends MongoRepository<LigneCommande, String>{
	
	Page<LigneCommande> findAll(Pageable pageable);

}
