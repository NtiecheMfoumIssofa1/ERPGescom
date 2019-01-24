package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Statut;
import org.erp.gescom.repository.ClientRepository;
import org.erp.gescom.repository.StatutRepository;
import org.erp.gescom.service.dto.StatutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StatutService {
	
	private final Logger log = LoggerFactory.getLogger(StatutService.class);
	private final StatutRepository statutRepository;
	private final ClientRepository clientRepository;
	public StatutService(StatutRepository statutRepository, ClientRepository clientRepository) {
		super();
		this.statutRepository = statutRepository;
		this.clientRepository = clientRepository;
	}
	
	//create Statut
	
	public Statut createStatut(StatutDTO statutDTO){
		
		Statut statut = new Statut();
		statut.setIdStatut(statutDTO.getIdStatut());
		statut.setEtat(statutDTO.isEtat());
		statut.setLibelleStatut(statutDTO.getLibelleStatut());
		if(statutDTO.getClient() != null){
			Set<Client> clients = statutDTO.getClient().stream()
									.map(clientRepository::findById)
									.filter(Optional::isPresent)
									.map(Optional::get)
									.collect(Collectors.toSet());
			statut.setClients(clients);
		}
		statutRepository.save(statut);
		log.debug("Created Information Statut for {}",statut);
		return statut;
	}
	
	//update Statut
	public Optional<StatutDTO> updateStatut(StatutDTO statutDTO){
		return Optional.of(statutRepository
								.findById(statutDTO.getIdStatut()))
								.filter(Optional::isPresent)
								.map(Optional::get)
								.map(statut ->{
									statut.setIdStatut(statutDTO.getIdStatut());
									statut.setEtat(statutDTO.isEtat());
									statut.setLibelleStatut(statutDTO.getLibelleStatut());
									Set<Client> clients = statut.getClients();
									clients.clear();
									statutDTO.getClient().stream()
																.map(clientRepository::findById)
																.filter(Optional::isPresent)
																.map(Optional::get)
																.forEach(clients::add);
									statut.setClients(clients);
									statutRepository.save(statut);
									log.debug("Changed Information Statut for {}",statut);
									return statut;
								}).map(StatutDTO::new);
	}
	
	//delete Statut
	public void deleteStatut(String id){
		statutRepository.findById(id).ifPresent(statut ->{
			statutRepository.delete(statut);
			log.debug("Delete Statut {]",statut);
		});
	}
	//getAll
	public List<Statut> getAllStatut(){
		return statutRepository.findAll();
	}
	
	//getByid
	public Optional<Object> getByid(String id){
		return statutRepository.findById(id).map(StatutDTO::new);
	}
	//getAllByKeyWord
	public Page<Statut> getAllByMc(String mc,Pageable pageable){
		return null;
	}

}
