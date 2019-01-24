package org.erp.gescom.repository;

import java.util.Optional;


import org.erp.gescom.domain.TypeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeClientRepository extends MongoRepository<TypeClient, String>{

	Page<TypeClient> findAll(Pageable pageable);
	Optional<TypeClient> findOneById(String id);
}
