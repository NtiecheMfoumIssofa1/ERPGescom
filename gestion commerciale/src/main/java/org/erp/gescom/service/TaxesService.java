package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.TaxesRepository;
import org.erp.gescom.service.dto.TaxesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxesService {
	
	private final Logger log = LoggerFactory.getLogger(TaxesService.class);
	private final TaxesRepository taxesRepository;
	private final ArticleRepository articleRepository;
	public TaxesService(TaxesRepository taxesRepository, ArticleRepository articleRepository) {
		super();
		this.taxesRepository = taxesRepository;
		this.articleRepository = articleRepository;
	}
	
	public Taxes createTaxe(TaxesDTO taxesDTO){
		
		Taxes taxes = new Taxes();
		taxes.setIdTaxe(taxesDTO.getIdTaxe());
		taxes.setTauxtaxe(taxesDTO.getTauxtaxe());
		taxes.setEtat(taxesDTO.isEtat());
		List<Article> articles = taxesDTO.getArticles().stream()
										.map(articleRepository::findById)
										.filter(Optional::isPresent)
										.map(Optional::get)
										.collect(Collectors.toList());
		taxes.setArticles(articles);
		taxesRepository.save(taxes);
		log.debug("Created Information Taxe for {}",taxes);
		return taxes;
	}
	
	public Optional<TaxesDTO> updateTaxes(TaxesDTO taxesDTO){
		return Optional.of(taxesRepository
								.findById(taxesDTO.getIdTaxe()))
								.filter(Optional::isPresent)
								.map(Optional::get)
								.map(taxes ->{
									taxes.setIdTaxe(taxesDTO.getIdTaxe());
									taxes.setTauxtaxe(taxesDTO.getTauxtaxe());
									taxes.setEtat(taxesDTO.isEtat());
									List<Article> articles = taxes.getArticles();
									articles.clear();
									taxesDTO.getArticles().stream()
																.map(articleRepository::findById)
																.filter(Optional::isPresent)
																.map(Optional::get)
																.forEach(articles::add);
									taxesRepository.save(taxes);
									log.debug("Changed Information Taxe {}",taxes);
									return taxes;
								}).map(TaxesDTO::new);
	}
	
	public void deleteTaxe(String id){
		taxesRepository.findById(id).ifPresent(taxe ->{
			taxesRepository.delete(taxe);
			log.debug("Delete Taxe {}",taxe);
		});
	}
	
	public List<Taxes> getAllTaxes(){
		return taxesRepository.findAll();
	}
	public Optional<Taxes> getById(String id){
		return taxesRepository.findById(id);
	}
	public Page<Taxes> getAllByMc(String mc, Pageable  pageable){
		return null;
	}
	
}
