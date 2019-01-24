package org.erp.gescom.service;

import java.util.Optional;

import org.erp.gescom.domain.LigneCommande;
import org.erp.gescom.repository.LigneCommandeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService {
	
	private final Logger log = LoggerFactory.getLogger(LigneCommandeService.class);
	
	private final LigneCommandeRepository ligneCommandeRepository;

	public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
		super();
		this.ligneCommandeRepository = ligneCommandeRepository;
	}
	
	public LigneCommande createLigne(LigneCommande  lc){
		return ligneCommandeRepository.save(lc);
	}
	
	public LigneCommande updateligne(LigneCommande lc, String id){
		if ((id != null) && (ligneCommandeRepository.findById(id).isPresent())){
			lc.setId(id);
			return ligneCommandeRepository.save(lc);
		}else{
			return null;
		}
	}
	
	public void deleteligne(String id){
		ligneCommandeRepository.findById(id).ifPresent(ligne ->{
			ligneCommandeRepository.delete(ligne);
			log.debug("Delete Ligne : {}",ligne);
		});
	}
	
	public Page<LigneCommande> getAll(Pageable pageable){
		return ligneCommandeRepository.findAll(pageable);
	}
	
	public Optional<LigneCommande> getById(String id){
		return ligneCommandeRepository.findById(id);
	}

}
