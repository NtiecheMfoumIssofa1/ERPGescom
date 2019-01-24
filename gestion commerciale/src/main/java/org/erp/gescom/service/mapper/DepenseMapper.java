package org.erp.gescom.service.mapper;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Depence;
import org.erp.gescom.service.dto.DepenceDTO;
import org.springframework.stereotype.Service;

@Service
public class DepenseMapper {
	
	public DepenceDTO depenseToDepenseDTO(Depence depense){
		return new DepenceDTO(depense);
	}

	public List<DepenceDTO> depenseToDepenseDTO(List<Depence>depenses){
		return depenses.stream()
				.filter(Objects::nonNull)
				.map(this::depenseToDepenseDTO)
				.collect(Collectors.toList());
	}
	
	public Depence depenseDTOToDepense(DepenceDTO depenseDTO){
		if( depenseDTO == null){
			return null;
		}else{
			Depence depense = new Depence();
			depense.setNumeroDepence(depenseDTO.getNumeroDepence());
			//depense.setCategorieFournisseur(depenseDTO.getCategorieFournisseur());
			depense.setDateDepence(depenseDTO.getDateDepence());
			depense.setDestinataire(depenseDTO.getDestinataire());
			depense.setLibelleDepence(depenseDTO.getLibelleDepence());
			depense.setMontant(depenseDTO.getMontant());
			depense.setEtat(depenseDTO.isEtat());
			
			return depense;
		}
	}
	
	public List<Depence> depenceDTOsToDepences(List<DepenceDTO> depenseDTOs){
		return depenseDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::depenseDTOToDepense)
				.collect(Collectors.toList());
		
	}
}
