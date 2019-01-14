package org.erp.gescom.service.mapper;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Depence;
import org.erp.gescom.service.dto.DepenseDTO;
import org.springframework.stereotype.Service;

@Service
public class DepenseMapper {
	
	public DepenseDTO depenseToDepenseDTO(Depence depense){
		return new DepenseDTO(depense);
	}

	public List<DepenseDTO> depenseToDepenseDTO(List<Depence>depenses){
		return depenses.stream()
				.filter(Objects::nonNull)
				.map(this::depenseToDepenseDTO)
				.collect(Collectors.toList());
	}
	
	public Depence depenseDTOToDepense(DepenseDTO depenseDTO){
		if( depenseDTO == null){
			return null;
		}else{
			Depence depense = new Depence();
			depense.setNumeroDepense(depenseDTO.getNumeroDepense());
			//depense.setCategorieFournisseur(depenseDTO.getCategorieFournisseur());
			depense.setDateDepanse(depenseDTO.getDateDepanse());
			depense.setDestinataire(depenseDTO.getDestinataire());
			depense.setLibelleDepnse(depenseDTO.getLibelleDepnse());
			depense.setMontant(depenseDTO.getMontant());
			depense.setEtat(depenseDTO.isEtat());
			
			return depense;
		}
	}
	
	public List<Depence> depenceDTOsToDepences(List<DepenseDTO> depenseDTOs){
		return depenseDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::depenseDTOToDepense)
				.collect(Collectors.toList());
		
	}
}
