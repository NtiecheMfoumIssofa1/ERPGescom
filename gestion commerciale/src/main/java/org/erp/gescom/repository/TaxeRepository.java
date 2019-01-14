package org.erp.gescom.repository;

import org.erp.gescom.domain.Taxes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface TaxeRepository extends MongoRepository<Taxes, String>{

}
