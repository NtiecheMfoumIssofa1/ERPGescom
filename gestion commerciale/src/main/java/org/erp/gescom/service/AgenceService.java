package org.erp.gescom.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.config.Constants;
import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.repository.AgenceRepository;
import org.erp.gescom.repository.FactureRepository;

import org.erp.gescom.service.dto.AgenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenceService {
	
	private final Logger log = LoggerFactory.getLogger(AgenceService.class);
	private final AgenceRepository agenceRepository;
	private final FactureRepository factureRepository;
	
	public AgenceService(AgenceRepository agenceRepository, FactureRepository factureRepository) {
		this.factureRepository = factureRepository;
		this.agenceRepository = agenceRepository;
	}
	
//create Agence
	public Agence createAgence(AgenceDTO agenceDTO){
		
		Agence agence = new Agence();
		agence.setId(agenceDTO.getId());
		agence.setAddress(agenceDTO.getAddress());
		agence.setDescription(agenceDTO.getDescription());
		agence.setEmail(agenceDTO.getEmail());
		agence.setTelephone(agenceDTO.getTelephone());
		
		if(agenceDTO.getFactures() !=null){
			Set<Facture> factures = agenceDTO.getFactures().stream()
							.map(factureRepository::findById)
							.filter(Optional::isPresent)
							.map(Optional::get)
							.collect(Collectors.toSet());
		 	agence.setFactures(factures);
		}
		agenceRepository.save(agence);
		 log.debug("Created Information for Agence: {}", agence);
		 return agence;
	}
 //update Agence
	public Optional<AgenceDTO> updateAgence(AgenceDTO agenceDTO){
		return Optional.of(agenceRepository
							.findById(agenceDTO.getId()))
				     .filter(Optional::isPresent)
				     .map(Optional::get)
				     .map(agence ->{
				    	 agence.setAddress(agenceDTO.getAddress());
				    	 agence.setDescription(agenceDTO.getDescription());
				    	 agence.setEmail(agenceDTO.getEmail());
				    	 agence.setTelephone(agenceDTO.getTelephone());
				    	 agence.setId(agenceDTO.getId());
				    	 //update Facture
				    /*	 Set<Facture> managedFactures = agence.getFactures();
				    	 managedFactures.clear();
				    	 agenceDTO.getFactures().stream()
				    	 	.map(factureRepository::findById)
				    	 	.filter(Optional::isPresent)
				    	 	.map(Optional::get)
				    	 	.forEach(managedFactures::add);*/
				    	 agenceRepository.save(agence);
				    	 log.debug("Changed Information for agence: {}", agence);
				    	 return agence;
				    	 
				     })
				     .map(AgenceDTO::new);
	}
	//delete Agence
	public void deleteAgence(String id){
		agenceRepository.findById(id).ifPresent(agence ->{
			agenceRepository.delete(agence);
			  log.debug("Deleted Agence: {}", agence);
		});
	}
	
	//getAll
	public List<String> getAllAgence(){
		return agenceRepository.findAll().stream()
				.map(Agence::getDescription)
				.collect(Collectors.toList());
	}
	
	//getByID
	public Optional<Agence> getAgenceById(String id){
		return agenceRepository.findOneById(id);
	}
	
	//getAllByKeyWord
	public Page<AgenceDTO> getAllAgenceByMc(Pageable pageable){
		return agenceRepository.findAll(pageable).map(AgenceDTO::new);
	}
	

		
}
