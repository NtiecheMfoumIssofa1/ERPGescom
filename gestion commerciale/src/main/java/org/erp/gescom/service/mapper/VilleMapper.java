package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Ville;
import org.erp.gescom.service.dto.AgenceDTO;
import org.erp.gescom.service.dto.VilleDTO;
import org.springframework.stereotype.Service;

@Service
public class VilleMapper {
	
	public VilleDTO villeTOVilleDTO(Ville ville){
		return new VilleDTO(ville);
	}
	
	public List<VilleDTO> villesTOVilleDTOs(List<Ville> villes){
		return villes.stream()
					.filter(Objects::nonNull)
					.map(this::villeTOVilleDTO)
					.collect(Collectors.toList());
	}
	
	public Ville villeDTOToVille(VilleDTO villeDTO){
		if(villeDTO == null){
			return null;
		}else{
			Ville ville = new Ville();
			ville.setId(villeDTO.getId());
			ville.setLibelle(villeDTO.getLibelle());
			List<Agence> agences = this.agenceFromString(villeDTO.getAgences());
				if(agences != null){
					ville.setAgences(agences);
				}
			return ville;	
		}
	}
	
	public List<Ville> villeDTOsToVilles(List<VilleDTO> villeDTOs){
		return villeDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::villeDTOToVille)
					.collect(Collectors.toList());
	}

	public List<Agence> agenceFromString(List<String> strings){
		return strings.stream().map(string ->{
			Agence agence = new Agence();
			agence.setDescription(string);
			return agence;
		}).collect(Collectors.toList());
	}
}
