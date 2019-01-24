package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depence;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.repository.CategorieFournisseurRepository;
import org.erp.gescom.repository.DepenceRepository;
import org.erp.gescom.repository.FournisseurRepository;
import org.erp.gescom.service.dto.CategorieFournisseurDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class CategorieFounisseurService {
	
	private final Logger log = LoggerFactory.getLogger(CategorieFounisseurService.class);
	
	private final CategorieFournisseurRepository categorieRepository;
	private final FournisseurRepository fournisseurRepository;
	private final DepenceRepository depenceRepository;
	
	public CategorieFounisseurService(
								CategorieFournisseurRepository categorier,
								FournisseurRepository fournisseurRepository,
								DepenceRepository depenseRepository)
							{
								this.categorieRepository = categorier;
								this.fournisseurRepository = fournisseurRepository;
								this.depenceRepository = depenseRepository;
							}
	
	//create Categorie 
	
	public CategorieFournisseur createCategorie(CategorieFournisseurDTO categorieDTO){
		
		CategorieFournisseur categorie = new CategorieFournisseur();
		categorie.setEtat(categorieDTO.isEtat());
		categorie.setIdCategorie(categorieDTO.getIdCategorie());
		categorie.setLibelleCategorie(categorieDTO.getLibelleCategorie());
		 
		 if( categorieDTO.getFournisseurs() != null){
			 List<Fournisseur> fournisseurs = categorieDTO.getFournisseurs().stream()
					 							.map(fournisseurRepository::findById)
					 							.filter(Optional::isPresent)
					 							.map(Optional::get)
					 							.collect(Collectors.toList());
			 categorie.setFournisseurs(fournisseurs);		 							
		 }
		 if( categorieDTO.getDepenses() != null){
			 List<Depence> depences = categorieDTO.getDepenses().stream()
					 					.map(depenceRepository::findById)
					 					.filter(Optional::isPresent)
					 					.map(Optional::get)
					 					.collect(Collectors.toList());
			 categorie.setDepenses(depences);
		 }
		 categorieRepository.save(categorie);
		 log.debug("Created Information for Category: {}", categorie);
		 return categorie;
	}
	
	//update CategorieF
	public Optional<CategorieFournisseurDTO> updateCategorie(CategorieFournisseurDTO categorieDTO){
		return Optional.of(categorieRepository
							.findById(categorieDTO.getIdCategorie()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(categorie ->{
								
								categorie.setEtat(categorieDTO.isEtat());
								categorie.setIdCategorie(categorieDTO.getIdCategorie());
								categorie.setLibelleCategorie(categorieDTO.getLibelleCategorie());
								 
								//update Fournisseur
								List<Fournisseur> fournisseurs = categorie.getFournisseurs();
								 fournisseurs.clear();
								 categorieDTO.getFournisseurs().stream()
								 	.map(fournisseurRepository::findById)
								 	.filter(Optional::isPresent)
								 	.map(Optional::get)
								 	.forEach(fournisseurs::add);
								//update Depences
								 List<Depence> depences = categorie.getDepenses();
								 	depences.clear();
								 	categorieDTO.getDepenses().stream()
								 		.map(depenceRepository::findById)
								 		.filter(Optional::isPresent)
								 		.map(Optional::get)
								 		.forEach(depences::add);
								 	
							categorieRepository.save(categorie);
							log.debug("Changed Information for Category : {}", categorie);
							return categorie;
								
							}).map(CategorieFournisseurDTO::new);
	}
	
	//delete Category
	public void deleteCategory(String id){
		categorieRepository.findById(id).ifPresent(categorie ->{
			categorieRepository.delete(categorie);
			log.debug("Deleted Category: {}", categorie);
		});
	}
	
	//getAll
	public List<String> getAllCategory(){
		return categorieRepository.findAll().stream()
					.map(CategorieFournisseur::getLibelleCategorie)
					.collect(Collectors.toList());
	}
	//getById
	public Optional<CategorieFournisseur> getById(String id){
		return categorieRepository.findOneById(id);
	}
	//getAllByKeyWord
		public Page<CategorieFournisseurDTO> getAllCategorieByMc(Pageable pageable){
			return categorieRepository.findAll(pageable).map(CategorieFournisseurDTO::new);
		}
}
