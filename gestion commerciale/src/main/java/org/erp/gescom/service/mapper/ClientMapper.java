package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.domain.Statut;
import org.erp.gescom.service.dto.ClientDTO;
import org.springframework.stereotype.Service;
@Service
public class ClientMapper {
	
	public ClientDTO clientToClientDTO(Client client){
		return new ClientDTO(client);
	}
	
	public List<ClientDTO> clientsTOClientDTOs(List<Client> clients){
		return clients.stream()
				.filter(Objects::nonNull)
				.map(this::clientToClientDTO)
				.collect(Collectors.toList());
	}
	
	public Client clientDTOToClient(ClientDTO clientDTO){
		if(clientDTO == null){
			return null;
		}else{
			Client client = new Client();
			client.setAdrress(clientDTO.getAdrress());
			client.setBoitePostale(clientDTO.getBoitePostale());
			client.setEmail(clientDTO.getEmail());
			client.setId(clientDTO.getIdClient());
			client.setNomComplet(clientDTO.getNomComplet());
			List<Commande> commandes = this.commandeFromStrings(clientDTO.getCommandes());
				if( commandes != null){
					client.setCommandes(commandes);
				}
			List<Devis> devis = this.devisFromStrings(clientDTO.getDevis());
				if( devis != null){
					client.setDevis(devis);
				}
			List<Statut> statuts = this.statutFromStrings(clientDTO.getStatuts());
				if( statuts != null){
					client.setStatuts(statuts);
				}
			return client;	
		}
	}
	
	public List<Client>  clientDTOsToClients(List<ClientDTO> clientDTOs){
		return clientDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::clientDTOToClient)
				.collect(Collectors.toList());
	}
	
	
	
	
	public List<Commande> commandeFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			 Commande commande = new Commande();
			commande.setLibelleCommande(string);
			 return commande;
		}).collect(Collectors.toList());
	}
	
	public List<Devis> devisFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			 Devis devis = new Devis();
			devis.setNumeroDevis(string);
			 return devis;
		}).collect(Collectors.toList());
	}
	
	public List<Statut> statutFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			 Statut statut = new Statut();
			statut.setLibelleStatut(string);
			 return statut;
		}).collect(Collectors.toList());
	}

}
