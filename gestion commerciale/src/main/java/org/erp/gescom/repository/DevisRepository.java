package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Devis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends MongoRepository<Devis, String>{
	
	public Page<Devis> findAll(Pageable pageable);
	public Optional<Devis> findOneByNumero(String numero);

}
