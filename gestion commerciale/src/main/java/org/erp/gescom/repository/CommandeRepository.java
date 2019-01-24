package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommandeRepository extends MongoRepository<Commande, String>{
	
	Page<Commande> findAll(Pageable pageable);
	
	Optional<Commande> findOneByNumero(String numero);

}
