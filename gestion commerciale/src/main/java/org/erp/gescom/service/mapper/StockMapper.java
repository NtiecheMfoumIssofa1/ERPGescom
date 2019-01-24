package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Stock;
import org.erp.gescom.service.dto.ArticleDTO;
import org.erp.gescom.service.dto.StockDTO;
import org.springframework.stereotype.Service;

@Service
public class StockMapper {
	
	public StockDTO stockToStockDTO(Stock stock){
		return new StockDTO(stock);
	}
	
	public List<StockDTO> stocksToStockDTOs(List<Stock> stocks){
		return stocks.stream()
							.filter(Objects::nonNull)
							.map(this::stockToStockDTO)
							.collect(Collectors.toList());
	}
	
	public Stock stockDTOToStock(StockDTO stockDTO){
		if(stockDTO== null){
			return null;
		}else{
			Stock stock = new Stock();
			stock.setRefStock(stockDTO.getRefStock());
			stock.setDesignationStock(stockDTO.getDesignationStock());
			stock.setQuantiteStock(stockDTO.getQuantiteStock());
			stock.setEtat(stockDTO.isEtat());
			Set<Article> articles = this.articleFromString(stockDTO.getArticles());
			if(articles != null){
				stock.setArticles(articles);
			}
			return stock;
		}
	}
	public List<Stock> stockDTOsToStocks(List<StockDTO> stockDTOs){
		return stockDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::stockDTOToStock)
					.collect(Collectors.toList());
	}
		public Set<Article> articleFromString(Set<String> strings){
		
		return strings.stream().map(string ->{
			Article article = new Article();
			article.setRefArticle(string);
			return article;
		}).collect(Collectors.toSet());
	}

}
