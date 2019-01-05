package org.erp.gescom.repository;

import org.erp.gescom.domain.Ville;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends MongoRepository<Ville, String>{

}
