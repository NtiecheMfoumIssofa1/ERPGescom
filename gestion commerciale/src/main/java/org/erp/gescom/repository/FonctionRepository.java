package org.erp.gescom.repository;



import java.util.Optional;

import org.erp.gescom.domain.Fonction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends MongoRepository<Fonction, String>{
	
	Page<Fonction> findAll(Pageable pageable);
	Optional<Fonction> findOneById(String id);
	

}
