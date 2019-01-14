package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Devis;
import org.erp.gescom.service.dto.DevisDTO;
import org.springframework.stereotype.Service;

@Service
public class DevisMapper {
	
	public DevisDTO devisToDevisDTO(Devis devis){
		
		return new DevisDTO(devis);
	}
	
	public List<DevisDTO> devisToDevisDTOs(List<Devis> devis){
		
		return devis.stream()
					.filter(Objects::nonNull)
					.map(this::devisToDevisDTO)
					.collect(Collectors.toList());
	}
	
	public Devis devisDTOToDevis(DevisDTO devisDTO){
		if(devisDTO == null){
			return null;
		}else{
			Devis devis = new Devis();
			devis.setClient(devisDTO.getClient());
			devis.setDateDebutDebit(devisDTO.getDateDebutDebit());
			devis.setDateEcheanceDevis(devisDTO.getDateEcheanceDevis());
			devis.setEtat(devisDTO.isEtat());
			devis.setMontantTTC(devisDTO.getMontantTTC());
			devis.setNombre(devisDTO.getNombre());
			devis.setNumeroDevis(devisDTO.getNumeroDevis());
			
			return devis;
		}
	}
	
	public List<Devis> devisDTOsToDevis(List<DevisDTO> devisDTOs){
		return devisDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::devisDTOToDevis)
				.collect(Collectors.toList());
	}

}
