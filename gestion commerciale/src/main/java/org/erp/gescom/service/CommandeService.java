package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.LigneCommande;
import org.erp.gescom.repository.CommandeRepository;
import org.erp.gescom.repository.EtatRepository;
import org.erp.gescom.repository.LigneCommandeRepository;
import org.erp.gescom.service.dto.CommandeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
	
	private final Logger log = LoggerFactory.getLogger(CommandeService.class);
	
	private final CommandeRepository commandeRepository;
	private final EtatRepository etatRepository;
	private final LigneCommandeRepository ligneRepository;
	
	public CommandeService(CommandeRepository commandeRepository, EtatRepository etatRepository,
			LigneCommandeRepository ligneCommandeRepository) {
		
		this.commandeRepository = commandeRepository;
		this.etatRepository = etatRepository;
		this.ligneRepository = ligneCommandeRepository;
	}
	
	//create Commande
	public Commande createCommande (CommandeDTO commandeDTO){
		
		Commande commande = new Commande();
		 commande.setDate(commandeDTO.getDate());
		 commande.setEtat(commandeDTO.isEtat());
		 commande.setLibelleCommande(commandeDTO.getLibelleCommande());
		 commande.setNumCommande(commandeDTO.getNumCommande());
		 
		 	if(commandeDTO.getLigneCommandes() != null){
		 		Set<LigneCommande> ligneCommandes = commandeDTO.getLigneCommandes().stream()
		 											.map(ligneRepository::findById)
		 											.filter(Optional::isPresent)
		 											.map(Optional::get)
		 											.collect(Collectors.toSet());
		 		commande.setItems(ligneCommandes);
		 	}
		 	if(commandeDTO.getEtatCommandes() != null){
		 		List<Etat> etats = commandeDTO.getEtatCommandes().stream()
		 								.map(etatRepository::findById)
		 								.filter(Optional::isPresent)
		 								.map(Optional::get)
		 								.collect(Collectors.toList());
		 		commande.setEtatCommandes(etats);
		 		
		 	}
		 return commande;	
	}
	
	//update Commande
	public Optional<CommandeDTO> updateCommande(CommandeDTO commandeDTO){
		return Optional.of(commandeRepository
							.findById(commandeDTO.getNumCommande()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(commande ->{
								
								commande.setDate(commandeDTO.getDate());
								 commande.setEtat(commandeDTO.isEtat());
								 commande.setLibelleCommande(commandeDTO.getLibelleCommande());
								 commande.setNumCommande(commandeDTO.getNumCommande());
								 
								 //update LigneCommande
								 Set<LigneCommande> ligneCommandes = commande.getItems();
								 ligneCommandes.clear();
								 commandeDTO.getLigneCommandes().stream()
								 		.map(ligneRepository::findById)
								 		.filter(Optional::isPresent)
								 		.map(Optional::get)
								 		.forEach(ligneCommandes::add);
								 
								//update Etat
								 List<Etat> etats = commande.getEtatCommandes();
								 etats.clear();
								 commandeDTO.getEtatCommandes().stream()
								 		.map(etatRepository::findById)
								 		.filter(Optional::isPresent)
								 		.map(Optional::get)
								 		.forEach(etats::add);
								 
								commandeRepository.save(commande);
								log.debug("Changed Information for Order: {}", commande);
								return commande;
								 		
							}).map(CommandeDTO::new);
	}
	
	//delete Commande
	public void deleteCommande(String id){
		commandeRepository.findById(id).ifPresent(commande ->{
			commandeRepository.delete(commande);
		});
	}
	
    //getAll
	public List<Commande> getAllCommande(){
		return commandeRepository.findAll();
	}
	//getById
	public Optional<Commande> getById(String id){
		return commandeRepository.findOneByNumero(id);
	}
	
	//getAllByKeyWord
	
	public Page<CommandeDTO> getAllByMc(Pageable pageable){
		return commandeRepository.findAll(pageable).map(CommandeDTO::new);
	}
}
