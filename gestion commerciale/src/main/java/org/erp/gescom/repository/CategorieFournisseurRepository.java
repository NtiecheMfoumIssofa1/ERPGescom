package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.CategorieFournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategorieFournisseurRepository extends MongoRepository<CategorieFournisseur, String>{
	
	Page<CategorieFournisseur> findAll(Pageable pageable);
	Optional<CategorieFournisseur> findOneById(String id);

}
