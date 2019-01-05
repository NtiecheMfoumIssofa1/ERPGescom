package org.erp.gescom.repository;

import org.erp.gescom.domain.Agence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AgenceRepository extends MongoRepository<Agence, String>{

}
