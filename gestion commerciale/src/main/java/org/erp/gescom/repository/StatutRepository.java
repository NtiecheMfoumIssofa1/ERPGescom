package org.erp.gescom.repository;

import org.erp.gescom.domain.Statut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StatutRepository extends MongoRepository<Statut, String>{

}
