package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;

import org.erp.gescom.domain.Etat;
import org.erp.gescom.repository.CommandeRepository;
import org.erp.gescom.repository.EtatRepository;
import org.erp.gescom.repository.FactureRepository;
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
	
	public Etat createEtat(Etat etat){
		
		return etatRepository.save(etat);
	}
	
	public Etat updateEtat(Etat etat){
		etat.setIdEtat(etat.getIdEtat());
		return etatRepository.save(etat);
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
		return etatRepository.findById(id);
	}
	
	public Page<Etat> getAllByMc(String mc, Pageable pageable){
		return null;
	}
}
