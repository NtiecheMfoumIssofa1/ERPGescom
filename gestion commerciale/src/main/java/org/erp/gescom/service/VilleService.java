package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Ville;
import org.erp.gescom.repository.AgenceRepository;
import org.erp.gescom.repository.VilleRepository;
import org.erp.gescom.service.dto.VilleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
	
	private final Logger log = LoggerFactory.getLogger(VilleService.class);
	private final VilleRepository villeRepository;
	private final AgenceRepository agenceRepository;
	public VilleService(VilleRepository villeRepository, AgenceRepository agenceRepository) {
		super();
		this.villeRepository = villeRepository;
		this.agenceRepository = agenceRepository;
	}
	
	public Ville createVille(VilleDTO villeDTO){
		Ville ville = new Ville();
		ville.setId(villeDTO.getId());
		ville.setLibelle(villeDTO.getLibelle());
		List<Agence> agences = villeDTO.getAgences().stream()
										.map(agenceRepository::findById)
										.filter(Optional::isPresent)
										.map(Optional::get)
										.collect(Collectors.toList());
		ville.setAgences(agences);
		villeRepository.save(ville);
		log.debug("Created Information for Ville {}",ville);
		return ville;
	}
	
	public Optional<VilleDTO> updateVille(VilleDTO villeDTO){
		return Optional.of(villeRepository
								.findById(villeDTO.getId()))
								.filter(Optional::isPresent)
								.map(Optional::get)
								.map(ville ->{
									ville.setId(villeDTO.getId());
									ville.setLibelle(villeDTO.getLibelle());
									List<Agence> agences = ville.getAgences();
									agences.clear();
									villeDTO.getAgences().stream()
															.map(agenceRepository::findById)
															.filter(Optional::isPresent)
															.map(Optional::get)
															.forEach(agences::add);
									villeRepository.save(ville);
									log.debug("Changed Information for Ville {}", ville);
									return ville;
								}).map(VilleDTO::new);
	}
	
	public void deleteVille(String id){
		villeRepository.findById(id).ifPresent(ville ->{
			villeRepository.delete(ville);
			log.debug("Delete Ville {}",ville);
		});
	}
	
	public List<Ville> getAllVille(){
		return villeRepository.findAll();
	}
	
	public Optional<Ville> getById(String id){
		return villeRepository.findById(id);
	}
	
	public Page<Ville> getAllByMc(String mc,Pageable pageable){
		return null;
	}

}
