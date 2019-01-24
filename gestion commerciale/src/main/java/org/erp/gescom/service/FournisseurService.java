package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.FournisseurRepository;
import org.erp.gescom.service.dto.FournisseurDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FournisseurService {
	
	private final Logger log = LoggerFactory.getLogger(FournisseurService.class);
	
	private final FournisseurRepository fournisseurRepository;
	private final ArticleRepository articleRepository;
	public FournisseurService(FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
		super();
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
	}
	
	public Fournisseur createFournisseur(FournisseurDTO fournisseurDTO){
		
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setAdresse(fournisseurDTO.getAdresse());
		fournisseur.setBoitePostale(fournisseurDTO.getBoitePostale());
		fournisseur.setEmail(fournisseurDTO.getEmail());
		fournisseur.setEtat(fournisseurDTO.isEtat());
		fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
		fournisseur.setNomComplet(fournisseurDTO.getNomComplet());
		fournisseur.setTelephone(fournisseurDTO.getTelephone());
		fournisseur.setVille(fournisseurDTO.getVille());
		if(fournisseurDTO.getArticles() != null){
			List<Article> articles = fournisseurDTO.getArticles().stream()
																	.map(articleRepository::findById)
																	.filter(Optional::isPresent)
																	.map(Optional::get)
																	.collect(Collectors.toList());
			fournisseur.setArticles(articles);
		}
		fournisseurRepository.save(fournisseur);
		log.debug("Created Information Fournisseur for {}",fournisseur);
		return fournisseur;
	}
	
	public Optional<FournisseurDTO> updateFournisseur(FournisseurDTO fournisseurDTO){
		return Optional.of(fournisseurRepository
							.findById(fournisseurDTO.getIdFournisseur()))
							.filter(Optional::isPresent)
							 .map(Optional::get)
							 .map(fournisseur ->{
								 
								 fournisseur.setAdresse(fournisseurDTO.getAdresse());
									fournisseur.setBoitePostale(fournisseurDTO.getBoitePostale());
									fournisseur.setEmail(fournisseurDTO.getEmail());
									fournisseur.setEtat(fournisseurDTO.isEtat());
									fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
									fournisseur.setNomComplet(fournisseurDTO.getNomComplet());
									fournisseur.setTelephone(fournisseurDTO.getTelephone());
									fournisseur.setVille(fournisseurDTO.getVille());
									
									List<Article> articles = fournisseur.getArticles();
									articles.clear();
									fournisseurDTO.getArticles().stream()
																	.map(articleRepository::findById)
																	.filter(Optional::isPresent)
																	.map(Optional::get)
																	.forEach(articles::add);
									fournisseur.setArticles(articles);
									fournisseurRepository.save(fournisseur);
									log.debug("Changed Information Fournisseur {}",fournisseur);
									return fournisseur;
							 }).map(FournisseurDTO::new);
							
	}
	public void deleteFournisseur(String id){
		fournisseurRepository.findById(id).ifPresent(fournisseur ->{
			fournisseurRepository.delete(fournisseur);
			log.debug("Delete Fournisseur {}",fournisseur);
		});
	}
	public List<Fournisseur> getAllFournisseur(){
		return fournisseurRepository.findAll();
	}
	public Optional<Fournisseur> getById(String id){
		return fournisseurRepository.findOneById(id);
	} 
	public Page<FournisseurDTO> getAllByMc( Pageable pageable){
		return fournisseurRepository.findAll(pageable).map(FournisseurDTO::new);
	}
	

}
