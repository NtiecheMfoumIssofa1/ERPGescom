package org.erp.gescom.repository;

import java.util.Optional;

import org.erp.gescom.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface ArticleRepository extends MongoRepository<Article, String>{

	Optional<Article> findByRefArticle(String refArticle);

}
