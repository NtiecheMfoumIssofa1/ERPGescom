package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends MongoRepository<Fournisseur, String>{
	
	Page<Fournisseur> findAll(Pageable pageable);
	Optional<Fournisseur> findOneById(String id);

}
