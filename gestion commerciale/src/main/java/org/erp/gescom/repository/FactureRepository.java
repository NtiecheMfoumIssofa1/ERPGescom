package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends MongoRepository<Facture, String>{
	
	Page<Facture> findAll(Pageable pageable);
	Optional<Facture> findOneById(String id);

}
