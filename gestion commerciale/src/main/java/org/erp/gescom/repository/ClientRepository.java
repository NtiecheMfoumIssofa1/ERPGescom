package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends MongoRepository<Client, String>{
	
	public Page<Client> findAll(Pageable pageable);
	
	public Optional<Client> findOneByIdClient(String idClient);

}
