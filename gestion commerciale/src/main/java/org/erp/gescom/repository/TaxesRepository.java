package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Taxes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxesRepository extends MongoRepository<Taxes, String>{
	
	Page<Taxes> findAll(Pageable pageable);
	Optional<Taxes> findOneById(String id);

}
