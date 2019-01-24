package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Statut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StatutRepository extends MongoRepository<Statut, String>{
	
	Page<Statut> findAll(Pageable pageable);
	Optional<Statut> findOneById(String id);

}
