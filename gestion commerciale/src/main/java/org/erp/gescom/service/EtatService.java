package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.repository.CommandeRepository;
import org.erp.gescom.repository.EtatRepository;
import org.erp.gescom.repository.FactureRepository;
import org.erp.gescom.service.dto.EtatDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EtatService {
	
	private final Logger log = LoggerFactory.getLogger(EtatService.class);
	
	private final EtatRepository etatRepository;
	private final CommandeRepository commandeRepository;
	private final FactureRepository factureRepository;
	
	public EtatService(EtatRepository etatRepository, CommandeRepository commandeRepository,
			FactureRepository factureRepository) {
		super();
		this.etatRepository = etatRepository;
		this.commandeRepository = commandeRepository;
		this.factureRepository = factureRepository;
	}
	
	public Etat createEtat(EtatDTO etatDTO){
		
		Etat etat = new Etat();
		etat.setIdEtat(etatDTO.getIdEtat());
		etat.setLibelleEtat(etatDTO.getLibelleEtat());
		etat.setEtat(etatDTO.isEtat());
			if(etatDTO.getCommandes() != null){
				Set<Commande> commandes = etatDTO.getCommandes().stream()
						.map(commandeRepository::findById)
						.filter(Optional::isPresent)
						.map(Optional::get)
						.collect(Collectors.toSet());
				etat.setCommandes(commandes);
			}
		if(etatDTO.getFactures() != null){
			Set<Facture> factures = etatDTO.getFactures().stream()
									.map(factureRepository::findById)
									.filter(Optional::isPresent)
									.map(Optional::get)
									.collect(Collectors.toSet());
			etat.setFactures(factures);
		}
		etatRepository.save(etat);
		log.debug("Created Information for {}",etat);
		return etat;
	}
	
	public Optional<EtatDTO> updateEtat(EtatDTO etatDTO){
		
		return Optional.of(etatRepository
							.findById(etatDTO.getIdEtat()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(etat ->{
								etat.setIdEtat(etatDTO.getIdEtat());
								etat.setLibelleEtat(etatDTO.getLibelleEtat());
								etat.setEtat(etatDTO.isEtat());
								//update Oder
								Set<Commande> commandes = etat.getCommandes();
								commandes.clear();
								etatDTO.getCommandes().stream()
																.map(commandeRepository::findById)
																.filter(Optional::isPresent)
																.map(Optional::get)
																.forEach(commandes::add);
								//update Bills
								Set<Facture> factures = etat.getFactures();
								factures.clear();
								etatDTO.getFactures().stream()
																.map(factureRepository::findById)
																.filter(Optional::isPresent)
																.map(Optional::get)
																.forEach(factures::add);
								etatRepository.save(etat);
								log.debug("Changed Information for Etat : {}",etat);
								return etat;
							}).map(EtatDTO::new);
		
	}
	
	public void deleteEtat(String id){
		etatRepository.findById(id).ifPresent(etat ->{
			etatRepository.delete(etat);
			log.debug("Delete Etat for {}",etat);
		});
	}
	
	public List<Etat> getAllEtat(){
		return etatRepository.findAll();
	}
	
	public Optional<Etat> getById(String id){
		return etatRepository.findOneById(id);
	}
	
	public Page<EtatDTO> getAllByMc(Pageable pageable){
		return etatRepository.findAll(pageable).map(EtatDTO::new);
	}
}
