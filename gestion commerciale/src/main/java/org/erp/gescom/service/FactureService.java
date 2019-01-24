package org.erp.gescom.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.ModeReglement;
import org.erp.gescom.repository.CommandeRepository;
import org.erp.gescom.repository.EtatRepository;
import org.erp.gescom.repository.FactureRepository;
import org.erp.gescom.repository.ModeReglementRepository;

import org.erp.gescom.service.dto.FactureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FactureService {
	
	private final Logger log = LoggerFactory.getLogger(FactureService.class);
	
	private final FactureRepository factureRepository;
	private final CommandeRepository commandeRepository;
	private final ModeReglementRepository modeReglementRepository;
	private final EtatRepository etatRepository;
	
	public FactureService(FactureRepository factureRepository, CommandeRepository commandeRepository,
			ModeReglementRepository modeReglementRepository,EtatRepository etatRepository) {
		this.factureRepository = factureRepository;
		this.commandeRepository = commandeRepository;
		this.modeReglementRepository = modeReglementRepository;
		this.etatRepository = etatRepository;
	}
	
	public Facture createFacture(FactureDTO factureDTO){
		
		Facture facture = new Facture();
		 facture.setDateDebutFacture(factureDTO.getDateDebutFacture());
		 facture.setDateEcheanceFacture(factureDTO.getDateEcheanceFacture());
		 facture.setEtat(factureDTO.isEtat());
		 facture.setIdFacture(factureDTO.getIdFacture());
		 facture.setMontantTTC(factureDTO.getMontantTTC());
		  
		 if(factureDTO.getCommandes() != null){
			  List<Commande> commandes = factureDTO.getCommandes().stream()
					  						.map(commandeRepository::findById)
					  						.filter(Optional::isPresent)
					  						.map(Optional::get)
					  						.collect(Collectors.toList());
			  facture.setCommandes(commandes);
		  }
		 if(factureDTO.getEtatFacture() != null){
			 List<Etat> etats = factureDTO.getEtatFacture().stream()
					 			.map(etatRepository::findById)
					 			.filter(Optional::isPresent)
					 			.map(Optional::get)
					 			.collect(Collectors.toList());
			 facture.setEtatFacture(etats);
		 }
		 if(factureDTO.getModeReglements() != null){
			 Set<ModeReglement> modeReglements = factureDTO.getModeReglements().stream()
					 								.map(modeReglementRepository::findById)
					 								.filter(Optional::isPresent)
					 								.map(Optional::get)
					 								.collect(Collectors.toSet());
			 facture.setModeReglements(modeReglements);
		 }
		 factureRepository.save(facture);
		 log.debug("Created Information for Facture {}",facture);
		 return facture;
	}
	
	public Optional<FactureDTO> updateFacture(FactureDTO factureDTO){
		return Optional.of(factureRepository
							.findById(factureDTO.getIdFacture()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(facture ->{
								facture.setDateDebutFacture(factureDTO.getDateDebutFacture());
								 facture.setDateEcheanceFacture(factureDTO.getDateEcheanceFacture());
								 facture.setEtat(factureDTO.isEtat());
								 facture.setIdFacture(factureDTO.getIdFacture());
								 facture.setMontantTTC(factureDTO.getMontantTTC());
								 
								 List<Commande> commandes = facture.getCommandes();
								  commandes.clear();
								  factureDTO.getCommandes().stream()
														  			.map(commandeRepository::findById)
														  			.filter(Optional::isPresent)
														  			.map(Optional::get)
														  			.forEach(commandes::add);
								  facture.setCommandes(commandes);
								  
								  List<Etat> etats = facture.getEtatFacture();
								  etats.clear();
								  factureDTO.getEtatFacture().stream()
														  			.map(etatRepository::findById)
														  			.filter(Optional::isPresent)
														  			.map(Optional::get)
														  			.forEach(etats::add);
								  facture.setEtatFacture(etats);
								  
								  Set<ModeReglement>modeReglements = facture.getModeReglements();
								  modeReglements.clear();
								  factureDTO.getModeReglements().stream()
								                                      .map(modeReglementRepository::findById)
								                                      .filter(Optional::isPresent)
								                                      .map(Optional::get)
								                                      .forEach(modeReglements::add);
								  facture.setModeReglements(modeReglements);
								  
								  factureRepository.save(facture);
								  log.debug("Changed Information for facture {}",facture);
								  return facture;	
							}).map(FactureDTO::new);
	}
	
	public void deleteFacture(String id){
		factureRepository.findById(id).ifPresent(facture ->{
			factureRepository.delete(facture);
			log.debug("Delete Facture for {}",facture);
		});;
	}
	public List<Facture> getAllFacture(){
		return factureRepository.findAll();
	}
	public Optional<Object> getById(String id){
		return factureRepository.findById(id).map(FactureDTO::new);
	}
	public Page<Facture> getAllByMc(String mc, Pageable pageable){
		return null;
	}

}
