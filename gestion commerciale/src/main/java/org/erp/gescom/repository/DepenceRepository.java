package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Depence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepenceRepository extends MongoRepository<Depence, String>{
	
	Page<Depence> findAll(Pageable pageable);
	Optional<Depence> findOneByNumero(String numero);

}
