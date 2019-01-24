package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.domain.Statut;
import org.erp.gescom.service.dto.StatutDTO;
import org.springframework.stereotype.Service;

@Service
public class StatutMapper {
	
	public StatutDTO statutToStatutDTO(Statut statut){
		return new StatutDTO(statut);
	}
	
	public Set<StatutDTO> statutsToStatutDTOs(Set<Statut> statuts){
		return statuts.stream()
					.filter(Objects::nonNull)
					.map(this::statutToStatutDTO)
					.collect(Collectors.toSet());
	}
	
	public Statut statutDTOToStatut(StatutDTO statutDTO){
		if(statutDTO == null){
			return null;
		}else{
			Statut statut = new Statut();
			statut.setIdStatut(statutDTO.getIdStatut());
			statut.setEtat(statutDTO.isEtat());
			statut.setLibelleStatut(statutDTO.getLibelleStatut());
			Set<Client> clients = this.clientFromString(statutDTO.getClient());
				if(clients != null){
					statut.setClients(clients);
				}
			return statut;
		}
	}
	
	public List<Statut> statutDTOsToStatuts(List<StatutDTO> statutDTOs){
		return statutDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::statutDTOToStatut)
				.collect(Collectors.toList());		
	}
	
	public Set<Client> clientFromString(Set<String> strings){
		return strings.stream().map(string ->{
			Client client = new Client();
			client.setNomComplet(string);
			return client;
		}).collect(Collectors.toSet());
	}

}
