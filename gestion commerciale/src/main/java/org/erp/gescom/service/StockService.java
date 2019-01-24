package org.erp.gescom.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.EntrerStock;
import org.erp.gescom.domain.SortieStock;
import org.erp.gescom.domain.Stock;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.StockRepository;
import org.erp.gescom.service.dto.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	
	private final Logger log = LoggerFactory.getLogger(StockService.class);
	private final StockRepository stockRepository;
	private final ArticleRepository articleRepository;
	
	public StockService(StockRepository stockRepository, ArticleRepository articleRepository) {
		super();
		this.stockRepository = stockRepository;
		this.articleRepository = articleRepository;
	}
	
	/**CRUD Stock Entree*/
	public Stock creataEntree(EntrerStock stock){
		return stockRepository.save(
							new EntrerStock(
									stock.getRefStock(), 
									stock.getDesignationStock(), 
									stock.getQuantiteStock(), 
									stock.getArticles(), 
									stock.isEtat(), 
									stock.getDateEntree())
							);
	}
	
	public Optional<StockDTO> updateEntrerStock(EntrerStock entrer){
		return Optional.of(stockRepository
								.findById(entrer.getRefStock()))
								.filter(Optional::isPresent)
								.map(Optional::get)
								.map(stock ->{
									stock.setRefStock(entrer.getRefStock());
									stock.setDesignationStock(entrer.getDesignationStock());
									stock.setQuantiteStock(entrer.getQuantiteStock());
									stock.setEtat(entrer.isEtat());
									stock.setArticles(entrer.getArticles());
									entrer.setDateEntree(Instant.now());
									stockRepository.save(stock);
									log.debug("Changed Information Stock Entree {}",stock);
									return stock;
								}).map(StockDTO::new);
	}
	
	public void deleteEntrerStock(String id){
		stockRepository.findById(id).ifPresent(stock ->{
			stockRepository.delete(stock);
			log.debug("Delete Entrer Stock {}",stock);
		});
	}
	/**end CRUD Stock Entree */
	
	/**CRUD Stock Sortie*/
	public Stock createSortieStock(SortieStock stock){
		return stockRepository.save(
									new SortieStock(
											stock.getRefStock(),
											stock.getDesignationStock(), 
											stock.getQuantiteStock(), 
											stock.getArticles(), 
											stock.isEtat(), 
											stock.getDateSortie()));
	}
	
	public Optional<StockDTO> updateSortieStock(SortieStock sortie){
		return Optional.of(stockRepository
								.findById(sortie.getRefStock()))
								.filter(Optional::isPresent)
								.map(Optional::get)
								.map(stock ->{
									stock.setRefStock(sortie.getRefStock());
									stock.setDesignationStock(sortie.getDesignationStock());
									stock.setQuantiteStock(sortie.getQuantiteStock());
									stock.setEtat(sortie.isEtat());
									stock.setArticles(sortie.getArticles());
									sortie.setDateSortie(Instant.now());
									stockRepository.save(stock);
									log.debug("Changed Information Stock Entree {}",stock);
									return stock;
								}).map(StockDTO::new);
	}
	
	public void deleteSortieStock(String id){
		stockRepository.findById(id).ifPresent(stock ->{
			stockRepository.delete(stock);
			log.debug("Delete Sortie Stock {}",stock);
		});
	}
	
	/**end CRUD Stock Entree */
	
	public List<Stock> getAllStock(){
		return stockRepository.findAll();
	}
	public Optional<Stock> getById(String id){
		return stockRepository.findById(id);
	}
	public Page<Stock> getAllByMc(String mc,Pageable pageable){
		return null;
	}

}
