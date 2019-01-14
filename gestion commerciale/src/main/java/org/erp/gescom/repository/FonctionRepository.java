package org.erp.gescom.repository;



import org.erp.gescom.domain.Fonction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface FonctionRepository extends MongoRepository<Fonction, String>{
	

}
