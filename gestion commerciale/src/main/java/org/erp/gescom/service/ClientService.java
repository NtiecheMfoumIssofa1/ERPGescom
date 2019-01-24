package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.domain.Statut;
import org.erp.gescom.repository.ClientRepository;
import org.erp.gescom.repository.CommandeRepository;
import org.erp.gescom.repository.DevisRepository;
import org.erp.gescom.repository.StatutRepository;
import org.erp.gescom.service.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	private final Logger log = LoggerFactory.getLogger(ClientService.class);
	
	private final ClientRepository clientRepository;
	private final CommandeRepository commandeRepository;
	private final DevisRepository devisRepository;
	private final StatutRepository statutRepository;
	
	public ClientService(ClientRepository clientRepository, CommandeRepository commandeRepository,
			DevisRepository devisRepository, StatutRepository statutRepository) {
		this.clientRepository = clientRepository;
		this.commandeRepository = commandeRepository;
		this.devisRepository = devisRepository;
		this.statutRepository = statutRepository;
	}
	
	//create Client
	public Client createClient(ClientDTO clientDTO){
		
		Client client = new Client();
		client.setAdrress(clientDTO.getAdrress());
		client.setBoitePostale(clientDTO.getBoitePostale());
		client.setEmail(clientDTO.getEmail());
		client.setEtat(clientDTO.isEtat());
		client.setId(clientDTO.getIdClient());
		client.setNomComplet(clientDTO.getNomComplet());
		client.setTelephone(clientDTO.getTelephone());
		client.setVille(clientDTO.getVille());
		
		if(clientDTO.getCommandes() != null){
			List<Commande> commandes = clientDTO.getCommandes().stream()
								.map(commandeRepository::findById)
								.filter(Optional::isPresent)
								.map(Optional::get)
								.collect(Collectors.toList());
			client.setCommandes(commandes);
		}
		if(clientDTO.getDevis() != null){
			List<Devis> devis = clientDTO.getDevis().stream()
									.map(devisRepository::findById)
									.filter(Optional::isPresent)
									.map(Optional::get)
									.collect(Collectors.toList());
			client.setDevis(devis);
		}
		if(clientDTO.getStatuts() != null){
			
			List<Statut> statuts = clientDTO.getStatuts().stream()
									.map(statutRepository::findById)
									.filter(Optional::isPresent)
									.map(Optional::get)
									.collect(Collectors.toList());
			client .setStatuts(statuts);
			
		}
		
		clientRepository.save(client);
		log.debug("Created Information for Customer: {}", client);
		return client;
	}
	
	//update Client
	public Optional<ClientDTO> updateClient(ClientDTO clientDTO){
		return Optional.of(clientRepository
							.findById(clientDTO.getIdClient()))
							.map(Optional::get)
							.map(client -> {
								client.setAdrress(clientDTO.getAdrress());
								client.setBoitePostale(clientDTO.getBoitePostale());
								client.setEmail(clientDTO.getEmail());
								client.setEtat(clientDTO.isEtat());
								client.setId(clientDTO.getIdClient());
								client.setNomComplet(clientDTO.getNomComplet());
								client.setTelephone(clientDTO.getTelephone());
								client.setVille(clientDTO.getVille());
								
								//update Commande
								List<Commande> commandes = client.getCommandes();
								commandes.clear();
								 clientDTO.getCommandes().stream()
								 	.map(commandeRepository::findById)
								 	.filter(Optional::isPresent)
								 	.map(Optional::get)
								 	.forEach(commandes::add);
								 //update Devis
								 List<Devis> devis = client.getDevis();
								 devis.clear();
								 clientDTO.getDevis().stream()
								 	.map(devisRepository::findById)
								 	.filter(Optional::isPresent)
								 	.map(Optional::get)
								 	.forEach(devis::add);
								 //update Status
								 List<Statut> statuts = client.getStatuts();
								 statuts.clear();
								 clientDTO.getStatuts().stream()
								 		.map(statutRepository::findById)
								 		.filter(Optional::isPresent)
								 		.map(Optional::get)
								 		.forEach(statuts::add);
								 
						clientRepository.save(client);	
						log.debug("Changed Information for Custumer: {}", client);
						return client;
							}).map(ClientDTO::new);
	}
	
	//delete Client
	public void deleteClient(String id){
		clientRepository.findById(id).ifPresent(client ->{
			clientRepository.delete(client);
			log.debug("Deleted Client: {}", client);
		});
	}
	
	//getAll
	public List<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	//getById
	public Optional<Client> getById(String id){
		return clientRepository.findOneById(id);
	}
	
	//getAllByKeyWord
	public Page<ClientDTO> getAllClientMc(Pageable pageable){
		return clientRepository.findAll(pageable).map(ClientDTO::new);
	}

}
