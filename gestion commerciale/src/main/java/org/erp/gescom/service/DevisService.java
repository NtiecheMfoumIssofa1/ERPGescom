package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.DevisRepository;
import org.erp.gescom.service.dto.ArticleDTO;
import org.erp.gescom.service.dto.DevisDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class DevisService {
	
	private final Logger log = LoggerFactory.getLogger(DevisService.class);
	
	private final DevisRepository devisRepository;
	private final ArticleRepository articleRepository;

	public DevisService(DevisRepository devisRepository,ArticleRepository articleRepository) {
		
		this.devisRepository = devisRepository;
		this.articleRepository = articleRepository;
	}
	
	public Devis createDevis(DevisDTO devisDTO){
		
		Devis devis = new Devis();
		devis.setDateDebutDebit(devisDTO.getDateDebutDebit());
		devis.setDateEcheanceDevis(devisDTO.getDateEcheanceDevis());
		devis.setEtat(devisDTO.isEtat());
		devis.setMontantTTC(devisDTO.getMontantTTC());
		devis.setNombre(devisDTO.getNombre());
		
		 if(devisDTO.getArticles() != null){
			 Set<Article> articles = devisDTO.getArticles().stream()
					 					.map(articleRepository::findById)
					 					.filter(Optional::isPresent)
					 					.map(Optional::get)
					 					.collect(Collectors.toSet());
			 devis.setArticles(articles);
		 }
		 devisRepository.save(devis);
		 log.debug("Created Information for {} ", devis);
		 return devis;
	}
	
	public Optional<DevisDTO> updateDevis(DevisDTO devisDTO){
		return Optional.of(devisRepository
							.findById(devisDTO.getNumeroDevis()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(devis ->{
								
								devis.setDateDebutDebit(devisDTO.getDateDebutDebit());
								devis.setDateEcheanceDevis(devisDTO.getDateEcheanceDevis());
								devis.setEtat(devisDTO.isEtat());
								devis.setMontantTTC(devisDTO.getMontantTTC());
								devis.setNombre(devisDTO.getNombre());
								
								Set<Article> articles = devis.getArticles();
								articles.clear();
								devisDTO.getArticles().stream()
										.map(articleRepository::findById)
										.filter(Optional::isPresent)
										.map(Optional::get)
										.forEach(articles::add);
								devis.setArticles(articles);
						devisRepository.save(devis);
						log.debug("Changed Information Devis for {}",devis);
						return devis;
							}).map(DevisDTO::new);
	}
	
	public void deleteDevis(String id){
		devisRepository.findById(id).ifPresent(devis ->{
			devisRepository.delete(devis);
			log.debug("Delete Devis {}",devis);
		});
	}
	
	public List<Devis> getAllDevis(){
		return devisRepository.findAll();
	}
		
	public Optional<Devis> getById(String id){
		return devisRepository.findOneByNumero(id);
	}
	
	public Page<DevisDTO> getAllByMc(Pageable pageable){
		return devisRepository.findAll(pageable).map(DevisDTO::new);
	}
}
