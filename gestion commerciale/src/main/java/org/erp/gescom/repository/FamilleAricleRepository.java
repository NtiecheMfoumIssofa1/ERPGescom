package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.FamilleArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilleAricleRepository extends MongoRepository<FamilleArticle, String>{
	
	Page<FamilleArticle> findAll(Pageable pageable);
	Optional<FamilleArticle> findOneById(String id);

}
