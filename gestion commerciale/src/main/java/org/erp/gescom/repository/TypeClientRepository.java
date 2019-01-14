package org.erp.gescom.repository;

import org.erp.gescom.domain.TypeClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TypeClientRepository extends MongoRepository<TypeClient, String>{

}
