package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Etat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRepository extends MongoRepository<Etat, String>{
	
	Page<Etat> findAll(Pageable pageable);
	Optional<Etat> findOneById( String id);

}
