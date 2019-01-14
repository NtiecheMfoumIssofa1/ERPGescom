package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.service.dto.AgenceDTO;
import org.springframework.stereotype.Service;
@Service
public class AgenceMapper {
	
	public AgenceDTO agenceToAgenceDTO(Agence agence){
		return new AgenceDTO(agence);
	}
	
	public List<AgenceDTO> agencesTOAgenceDTOs(List<Agence> agences){
		
		return agences.stream()
				.filter(Objects::nonNull)
				.map(this::agenceToAgenceDTO)
				.collect(Collectors.toList());
	}
	
	public Agence agenceDTOToAgence(AgenceDTO agenceDTO){
		
		if(agenceDTO == null){
			return null;
		}else{
			Agence agence = new Agence();
			agence.setId(agenceDTO.getId());
			agence.setAddress(agenceDTO.getAddress());
			agence.setDescription(agenceDTO.getDescription());
			agence.setEmail(agenceDTO.getEmail());
			agence.setTelephone(agenceDTO.getTelephone());
			//agence.setVille(agenceDTO.getVille());
			Set<Facture> factures = this.facturesFromStrings(agenceDTO.getFactures());
			if(factures != null){
				agence.setFactures(factures);
			}
			return agence;
		}
	}
	
	public List<Agence> agenceDTOsToAgences(List<AgenceDTO> agenceDTOs){
		return agenceDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::agenceDTOToAgence)
				.collect(Collectors.toList());
		
	}
	public Set<Facture> facturesFromStrings(Set<String> strings){
		return strings.stream().map(string ->{
			Facture facture = new Facture();
			facture.setIdFacture(string);
			return facture;
		}).collect(Collectors.toSet());
		
	}
	

}
