package org.erp.gescom.service;



import java.util.List;
import java.util.Optional;

import org.erp.gescom.domain.Depence;
import org.erp.gescom.repository.DepenceRepository;
import org.erp.gescom.service.dto.DepenceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DepencesService {
	
	public final Logger log = LoggerFactory.getLogger(DepencesService.class);
	public final DepenceRepository depenceRepository;
	
	public DepencesService(DepenceRepository depenceRepository) {
		this.depenceRepository = depenceRepository;
	}
	
	//create Depence
	public Depence createDepence(DepenceDTO depenceDTO){
		
		Depence depence = new Depence();
		
		depence.setDateDepence(depenceDTO.getDateDepence());
		depence.setDestinataire(depenceDTO.getDestinataire());
		depence.setEtat(depenceDTO.isEtat());
		depence.setLibelleDepence(depenceDTO.getLibelleDepence());
		depence.setMontant(depenceDTO.getMontant());
		depence.setNumeroDepence(depenceDTO.getNumeroDepence());
		
		depenceRepository.save(depence);
		log.debug("created Information for Depence {}",depence);
		return depence;
		
	}
	//update Depence
	public Optional<DepenceDTO> updateDepence(DepenceDTO depenceDTO){
		return Optional.of(depenceRepository
							.findById(depenceDTO.getNumeroDepence()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(depence ->{
								
								depence.setDateDepence(depenceDTO.getDateDepence());
								depence.setDestinataire(depenceDTO.getDestinataire());
								depence.setEtat(depenceDTO.isEtat());
								depence.setLibelleDepence(depenceDTO.getLibelleDepence());
								depence.setMontant(depenceDTO.getMontant());
								depence.setNumeroDepence(depenceDTO.getNumeroDepence());
								
								depenceRepository.save(depence);
								log.debug("Changed Ilformation for Depence {}",depence);
								return depence;
							}).map(DepenceDTO::new);
	}
	
	//delete Depence
	public void deleteDepence(String id){
		depenceRepository.findById(id).ifPresent(depence ->{
			depenceRepository.delete(depence);
			log.debug("Delete Depence {}",depence);
		});
	}
	
	//getAll
	public List<Depence> getAllDepence(){
		 return depenceRepository.findAll();
	}
	
	//getById
	public Optional<Depence> getById(String id){
		return depenceRepository.findOneByNumero(id);
	}
	
	//getByKeyWord
	public Page<DepenceDTO> getAllByMc(Pageable pageable){
		return depenceRepository.findAll(pageable).map(DepenceDTO::new);
	}

}
