package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Fonction;
import org.erp.gescom.domain.User;
import org.erp.gescom.service.dto.FonctionDTO;
import org.springframework.stereotype.Service;

@Service
public class FonctionMapper {
	
	public FonctionDTO fonctionToFonctionDTO(Fonction fonction){
		return new FonctionDTO(fonction);
	}
	
	public List<FonctionDTO> fonctionsToFonctionDTOs(List<Fonction> fonctions){
		return fonctions.stream()
				.filter(Objects::nonNull)
				.map(this::fonctionToFonctionDTO)
				.collect(Collectors.toList());
	}
	
	public Fonction fonctionDTOToFonction(FonctionDTO fonctionDTO){
		if(fonctionDTO == null){
			return null;
		}else{
			Fonction fonction = new Fonction();
			fonction.setAction(fonctionDTO.getAction());
			fonction.setIdFonction(fonctionDTO.getIdFonction());
			fonction.setLibelleFonction(fonctionDTO.getLibelleFonction());
			List<User> user = this.fonctionFromString(fonctionDTO.getAppUsers());
					if( user != null){
						fonction.setAppUsers(user);
					}
			return fonction;
		}
	}
	
	public List<Fonction> fonctionDTOsToFonctions(List<FonctionDTO> fonctionDTOs){
		return fonctionDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::fonctionDTOToFonction)
				.collect(Collectors.toList());
	}
	
	public List<User> fonctionFromString(List<String> strings){
		return strings.stream().map(string ->{
			User user = new User();
			user.setEmail(string);
			return user;
		}).collect(Collectors.toList());
	}

}
