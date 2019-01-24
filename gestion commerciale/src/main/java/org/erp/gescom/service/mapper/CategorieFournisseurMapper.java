package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depence;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.service.dto.CategorieFournisseurDTO;
import org.springframework.stereotype.Service;
@Service
public class CategorieFournisseurMapper {
	
	public CategorieFournisseurDTO catFToCatFDTO(CategorieFournisseur categorieFournisseur){
		return new CategorieFournisseurDTO(categorieFournisseur);
	}
  
	public List<CategorieFournisseurDTO> catFsToCatFDTOs(List<CategorieFournisseur> categorieFournisseurs){
		return categorieFournisseurs.stream()
				.filter(Objects::nonNull)
				.map(this::catFToCatFDTO)
				.collect(Collectors.toList());
	}
	
	public CategorieFournisseur catFDTOToCatF(CategorieFournisseurDTO categorieFournisseurDTO){
		
		if (categorieFournisseurDTO == null){
			return null;
		}else{
			CategorieFournisseur categorie = new CategorieFournisseur();
			 categorie.setIdCategorie(categorieFournisseurDTO.getIdCategorie());
			 categorie.setLibelleCategorie(categorieFournisseurDTO.getLibelleCategorie());
			 List<Fournisseur> fournisseurs = this.fournisseurFromStrings(categorieFournisseurDTO.getFournisseurs());
			 	if( fournisseurs != null){
			 		categorie.setFournisseurs(fournisseurs);
			 	}
			List<Depence> depenses = this.depenseFromStrings(categorieFournisseurDTO.getDepenses());
			if( depenses != null){
				categorie.setDepenses(depenses);
			}
			return categorie;
		}
	}
	
	public List<Fournisseur> fournisseurFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			 Fournisseur fournisseur = new Fournisseur();
			 fournisseur.setNomComplet(string);
			 return fournisseur;
		}).collect(Collectors.toList());
	}
	
	public List<Depence> depenseFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			 Depence depense = new Depence();
			 depense.setLibelleDepence(string);
			 return depense;
		}).collect(Collectors.toList());
	}
}
