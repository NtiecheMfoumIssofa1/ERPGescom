package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Agence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AgenceRepository extends MongoRepository<Agence, String>{
	
	Page<Agence> findAll(Pageable pageable);
	
	Optional<Agence> findOneById(String id);
	
	

}
