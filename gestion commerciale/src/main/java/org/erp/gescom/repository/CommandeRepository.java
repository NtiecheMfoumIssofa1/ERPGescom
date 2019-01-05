package org.erp.gescom.repository;

import org.erp.gescom.domain.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommandeRepository extends MongoRepository<Commande, String>{

}
