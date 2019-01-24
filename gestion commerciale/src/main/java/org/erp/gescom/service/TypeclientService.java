package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.TypeClient;
import org.erp.gescom.repository.ClientRepository;
import org.erp.gescom.repository.TypeClientRepository;
import org.erp.gescom.service.dto.TypeClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeclientService {
	
	private final Logger log = LoggerFactory.getLogger(TypeclientService.class);
	private final TypeClientRepository typeClientRepository;
	private final ClientRepository clientRepository;
	public TypeclientService(TypeClientRepository typeClientRepository, ClientRepository clientRepository) {
		super();
		this.typeClientRepository = typeClientRepository;
		this.clientRepository = clientRepository;
	}
	
	public TypeClient createType(TypeClientDTO typeClientDTO){
		
		TypeClient typeClient = new TypeClient();
		typeClient.setIdType(typeClientDTO.getIdType());
		typeClient.setLibelleType(typeClientDTO.getLibelleType());
		typeClient.setEtat(typeClientDTO.isEtat());
		List<Client> clients = typeClientDTO.getClients().stream()
											.map(clientRepository::findById)
											.filter(Optional::isPresent)
											.map(Optional::get)
											.collect(Collectors.toList());
		typeClient.setClients(clients);
		typeClientRepository.save(typeClient);
		log.debug("Created information Type Client for {}", typeClient);
		return typeClient;
	}
	
	public Optional<TypeClientDTO> updateType(TypeClientDTO typeClientDTO){
		return Optional.of(typeClientRepository
									.findById(typeClientDTO.getIdType()))
									.filter(Optional::isPresent)
									.map(Optional::get)
									.map(typeClient ->{
										typeClient.setIdType(typeClientDTO.getIdType());
										typeClient.setLibelleType(typeClientDTO.getLibelleType());
										typeClient.setEtat(typeClientDTO.isEtat());
										List<Client> clients = typeClient.getClients();
										clients.clear();
										typeClientDTO.getClients().stream()
																	.map(clientRepository::findById)
																	.filter(Optional::isPresent)
																	.map(Optional::get)
																	.forEach(clients::add);
								     typeClientRepository.save(typeClient);
								     log.debug("Changed Information for Type Client for {}",typeClient);
								     return typeClient;
									}).map(TypeClientDTO::new);
	}
	
	public void deleteType(String id){
		typeClientRepository.findById(id).ifPresent(type ->{
			typeClientRepository.delete(type);
			log.debug("Delete Type Client {}",type);
		});
	}
	
	public List<TypeClient> getAllClient(){
		return typeClientRepository.findAll();
	}
	
	public Optional<TypeClient> getById(String id){
		return typeClientRepository.findById(id);
	}
	
	public Page<TypeClient> geAllBymc(String mc, Pageable pageable){
		return null;
	}

}
