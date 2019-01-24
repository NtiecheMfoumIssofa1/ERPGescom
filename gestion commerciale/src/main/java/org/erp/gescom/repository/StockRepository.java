package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String>{
	
	Page<Stock> findAll(Pageable pageable);
	Optional<Stock> findOneByRef(String id);

}
