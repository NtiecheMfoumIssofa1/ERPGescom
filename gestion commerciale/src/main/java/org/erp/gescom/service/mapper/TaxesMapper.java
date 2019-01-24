package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.erp.gescom.service.dto.TaxesDTO;
import org.springframework.stereotype.Service;

@Service
public class TaxesMapper {
	
	public TaxesDTO taxeTOTaxeDTO(Taxes taxes){
		return new TaxesDTO(taxes);
	}
	
	public List<TaxesDTO> taxesToTaxeDTOs(List<Taxes> taxes){
		return taxes.stream()
					.filter(Objects::nonNull)
					.map(this::taxeTOTaxeDTO)
					.collect(Collectors.toList());
	}
	public Taxes taxeDTOToTaxe(TaxesDTO taxesDTO){
		if(taxesDTO == null){
			return null;
		}else{
			Taxes taxes = new Taxes();
			taxes.setEtat(taxesDTO.isEtat());
			taxes.setIdTaxe(taxesDTO.getIdTaxe());
			taxes.setTauxtaxe(taxesDTO.getTauxtaxe());
			List<Article> articles =this.articleFromString(taxesDTO.getArticles());
				if(articles != null){
					taxes.setArticles(articles);
				}
			return taxes;	
		}
	}
	
	public List<Taxes> taxeDTOsToTaxes(List<TaxesDTO> taxesDTOs){
		return taxesDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::taxeDTOToTaxe)
					.collect(Collectors.toList());
	}
	
	public List<Article> articleFromString(List<String> strings){
		return strings.stream().map(string ->{
			Article article = new Article();
			article.setRefArticle(string);
			return article;
		}).collect(Collectors.toList());
	}
}
