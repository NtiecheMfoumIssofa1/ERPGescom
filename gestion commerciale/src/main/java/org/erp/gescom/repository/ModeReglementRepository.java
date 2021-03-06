package org.erp.gescom.repository;

import org.erp.gescom.domain.ModeReglement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModeReglementRepository extends MongoRepository<ModeReglement, String>{
	
	Page<ModeReglement> findAll(Pageable pageable);

}
