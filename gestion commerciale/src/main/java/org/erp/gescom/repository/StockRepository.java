package org.erp.gescom.repository;

import org.erp.gescom.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StockRepository extends MongoRepository<Stock, String>{

}
