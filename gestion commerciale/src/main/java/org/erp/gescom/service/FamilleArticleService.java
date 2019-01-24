package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.FamilleArticle;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.FamilleAricleRepository;
import org.erp.gescom.service.dto.FamilleArticleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FamilleArticleService {
	
	private final Logger log = LoggerFactory.getLogger(FamilleArticleService.class);
	
	private final FamilleAricleRepository familleAricleRepository;
	private final ArticleRepository articleRepository;
	public FamilleArticleService(FamilleAricleRepository familleAricleRepository, ArticleRepository articleRepository) {
		super();
		this.familleAricleRepository = familleAricleRepository;
		this.articleRepository = articleRepository;
	}
	
	public FamilleArticle createFamille(FamilleArticleDTO familleArticleDTO){
		
		FamilleArticle familleArticle = new FamilleArticle();
		
		familleArticle.setIdFamille(familleArticleDTO.getIdFamille());
		familleArticle.setLibelleFamille(familleArticleDTO.getLibelleFamille());
		familleArticle.setEtat(familleArticleDTO.isEtat());
		if (familleArticleDTO.getArticles() != null){
			List<Article> articles = familleArticleDTO.getArticles().stream()
																			.map(articleRepository::findById)
																			.filter(Optional::isPresent)
																			.map(Optional::get)
																			.collect(Collectors.toList());
			familleArticle.setArticles(articles);
		}
		
		familleAricleRepository.save(familleArticle);
		log.debug("Created Information Famille Article for {}",familleArticle);
		return familleArticle;
	}
	
	public Optional<FamilleArticleDTO> updateFamille(FamilleArticleDTO familleArticleDTO){
		return Optional.of(familleAricleRepository
							.findById(familleArticleDTO.getIdFamille()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(familleArticle ->{
								familleArticle.setIdFamille(familleArticleDTO.getIdFamille());
								familleArticle.setLibelleFamille(familleArticleDTO.getLibelleFamille());
								familleArticle.setEtat(familleArticleDTO.isEtat());
								
								List<Article> articles = familleArticle.getArticles();
								articles.clear();
								familleArticleDTO.getArticles().stream()
																	.map(articleRepository::findById)
																	.filter(Optional::isPresent)
																	.map(Optional::get)
																	.forEach(articles::add);
								familleAricleRepository.save(familleArticle);
								return familleArticle;
							}).map(FamilleArticleDTO::new);
	}
	
	public void deleteFamille(String id){
		familleAricleRepository.findById(id).ifPresent(famille ->{
			familleAricleRepository.delete(famille);
			log.debug("Delete Famille Article {}", famille);
		});
	}
	
	public List<FamilleArticle> getAllFamille(){
		return familleAricleRepository.findAll();
	}
	
	public Optional<FamilleArticle> getById(String id){
		return familleAricleRepository.findOneById(id);
	}
	
	public Page<FamilleArticleDTO> getAllByMc( Pageable pageable){
		return familleAricleRepository.findAll(pageable).map(FamilleArticleDTO::new);
	}

}
