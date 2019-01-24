package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Fonction;
import org.erp.gescom.domain.User;
import org.erp.gescom.repository.FonctionRepository;
import org.erp.gescom.repository.UserRepository;
import org.erp.gescom.service.dto.FonctionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FonctionService {
	
	private final Logger log= LoggerFactory.getLogger(FonctionService.class);
	
	private final FonctionRepository fonctionRepository;
	private final UserRepository userrepository;
	public FonctionService(FonctionRepository fonctionRepository, UserRepository userrepository) {
		super();
		this.fonctionRepository = fonctionRepository;
		this.userrepository = userrepository;
	}
	
	public Fonction createFunction(FonctionDTO fonctionDTO){
		Fonction fonction = new Fonction();
		fonction.setIdFonction(fonctionDTO.getIdFonction());
		fonction.setLibelleFonction(fonctionDTO.getLibelleFonction());
		fonction.setAction(fonctionDTO.getAction());
		if(fonctionDTO.getAppUsers() != null){
			List<User> users = fonctionDTO.getAppUsers().stream()
																.map(userrepository::findOneByLogin)
																.filter(Optional::isPresent)
																.map(Optional::get)
																.collect(Collectors.toList());
			fonction.setAppUsers(users);
		}
		fonctionRepository.save(fonction);
		log.debug("Created Information Fonction for {}",fonction);
		return fonction;
	}
	
	public Optional<FonctionDTO> updateFonction(FonctionDTO fonctionDTO){
		return Optional.of(fonctionRepository
							.findById(fonctionDTO.getIdFonction()))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.map(fonction ->{
								fonction.setIdFonction(fonctionDTO.getIdFonction());
								fonction.setLibelleFonction(fonctionDTO.getLibelleFonction());
								fonction.setAction(fonctionDTO.getAction());
								
								List<User> users = fonction.getAppUsers();
								users.clear();
								fonctionDTO.getAppUsers().stream()
															.map(userrepository::findOneByLogin)
															.filter(Optional::isPresent)
															.map(Optional::get)
															.forEach(users::add);
								fonctionRepository.save(fonction);
								log.debug("Changed Information Fonction for {}",fonction);
								return fonction;
							}).map(FonctionDTO::new);
	}
	
	public void deleteFonction(String id){
		fonctionRepository.findById(id).ifPresent(fonction ->{
			fonctionRepository.delete(fonction);
			log.debug("Delete Fonction {}",fonction);
		});
	}
	
	public List<Fonction> getAllFonction(){
		return fonctionRepository.findAll();
	}
	
	public Optional<Object> getById(String id){
		return fonctionRepository.findById(id).map(FonctionDTO::new);
	}
	
	public Page<Fonction> getAllByMc(String mc, Pageable pageable){
		return null;
	}

}
