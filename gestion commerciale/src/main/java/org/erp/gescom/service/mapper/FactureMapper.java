package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.ModeReglement;
import org.erp.gescom.service.dto.FactureDTO;
import org.springframework.stereotype.Service;

@Service
public class FactureMapper {

	public FactureDTO factureToFactureDTO(Facture facture){
		return new FactureDTO(facture);
	}
	
	public List<FactureDTO> facturesToFactureDTOs(List<Facture> factures){
		return factures.stream()
				.filter(Objects::nonNull)
				.map(this::factureToFactureDTO)
				.collect(Collectors.toList());
	}
	
	public Facture factureDTOToFacture(FactureDTO factureDTO){
		if(factureDTO == null){
			return null;
		}else{
			Facture facture = new Facture();
			facture.setIdFacture(factureDTO.getIdFacture());
			facture.setMontantTTC(factureDTO.getMontantTTC());
			facture.setDateEcheanceFacture(factureDTO.getDateEcheanceFacture());
			facture.setDateDebutFacture(factureDTO.getDateDebutFacture());
			facture.setEtat(factureDTO.isEtat());
			List<Etat> etats = this.etatFromStrings(factureDTO.getEtatFacture());
						if(etats != null){
							facture.setEtatFacture(etats);
						}
			/*Set<ModeReglement> reglements = this.reglementFromStrings(factureDTO.getModeReglements());
						if(reglements != null){
							facture.setModeReglements(reglements);
						}*/
			List<Commande> commandes = this.commandeFromStrings(factureDTO.getCommandes());
						if(commandes != null){
							facture.setCommandes(commandes);;
						}
			return facture;			
		}
	}
	
	public List<Facture> factureDTOsToFactures(List<FactureDTO> factureDTOs){
		return factureDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::factureDTOToFacture)
				.collect(Collectors.toList());
	}
	
	public List<Etat> etatFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			Etat etat = new Etat();
			etat.setLibelleEtat(string);
			return etat;
		}).collect(Collectors.toList());
		
	}
	
	public List<Commande> commandeFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			Commande commande = new Commande();
			commande.setNumCommande(string);
			return commande;
		}).collect(Collectors.toList());
		
	}
	/*
	public Set<ModeReglement> reglementFromStrings(Set<String> strings){
		return strings.stream().map(string ->{
			ModeReglement reglement = new ModeReglement();
			reglement.setLibelleReglement(string);
			return reglement;
		}).collect(Collectors.toSet());
	}*/
}
