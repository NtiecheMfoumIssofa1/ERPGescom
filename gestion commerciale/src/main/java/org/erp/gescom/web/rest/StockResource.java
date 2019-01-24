package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.EntrerStock;
import org.erp.gescom.domain.SortieStock;
import org.erp.gescom.domain.Stock;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.StockService;
import org.erp.gescom.service.dto.StockDTO;
import org.erp.gescom.web.rest.errors.BadRequestAlertException;
import org.erp.gescom.web.rest.util.HeaderUtil;
import org.erp.gescom.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class StockResource {
	
	private final Logger log = LoggerFactory.getLogger(StockResource.class);
	private static final String ENTITY_NAME ="stock";
	
	private final StockService service;

	public StockResource(StockService service) {
		super();
		this.service = service;
	}
	//entrer stock
	@PostMapping("/entrer")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Stock> createEntrer(@Valid @RequestBody EntrerStock stock) throws URISyntaxException{
		log.debug("REST request to save Stock {}",stock);
			if(stock.getRefStock() != null){
				throw new BadRequestAlertException("A new Stock cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Stock entrer = service.creataEntree(stock);
			return ResponseEntity.created(new URI("/api/entrer/"+stock.getRefStock()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, stock.getRefStock().toString()))
					.body(entrer);
	}
	@PutMapping("/entre")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<StockDTO> updateEntrer(@Valid @RequestBody EntrerStock stockDTO) throws URISyntaxException{
		log.debug("REST request to update Entrer {}",stockDTO);
			if(stockDTO.getRefStock() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<StockDTO> updatedStock = service.updateEntrerStock(stockDTO);
			return ResponseUtil.wrapOrNotFound(updatedStock,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stockDTO.getRefStock()));
	}
	@DeleteMapping("/entrer/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteEntrer(@PathVariable String id){
		log.debug("REST request to delete Entrer {}",id);
		service.deleteEntrerStock(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/entrer")
	@Timed
	public ResponseEntity<List<StockDTO>> getAllEntrer(Pageable pageable){
		final Page<StockDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/entre");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/entrer/{id}")
	@Timed
	public ResponseEntity<StockDTO> getByIdEntrer(String id){
		log.debug("REST request to get Stock");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(StockDTO::new));
	}
	
	//fin entrer stock
	
	//debut sortie Stock
	@PostMapping("/sortie")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Stock> createSortie(@Valid @RequestBody SortieStock stock) throws URISyntaxException{
		log.debug("REST request to save Stock {}",stock);
			if(stock.getRefStock() != null){
				throw new BadRequestAlertException("A new Stock cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Stock sortie = service.createSortieStock(stock);
			return ResponseEntity.created(new URI("/api/sortie/"+stock.getRefStock()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, stock.getRefStock().toString()))
					.body(sortie);
	}
	@PutMapping("/sortie")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<StockDTO> updateFunction(@Valid @RequestBody SortieStock stockDTO) throws URISyntaxException{
		log.debug("REST request to update Stock {}",stockDTO);
			if(stockDTO.getRefStock() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<StockDTO> updatedStock = service.updateSortieStock(stockDTO);
			return ResponseUtil.wrapOrNotFound(updatedStock,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stockDTO.getRefStock()));
	}
	@DeleteMapping("/sortie/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFunction(@PathVariable String id){
		log.debug("REST request to delete Stock {}",id);
		service.deleteEntrerStock(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/sortie")
	@Timed
	public ResponseEntity<List<StockDTO>> getAllSortie(Pageable pageable){
		final Page<StockDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sortie");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/sortie/{id}")
	@Timed
	public ResponseEntity<StockDTO> getById(String id){
		log.debug("REST request to get Stock");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(StockDTO::new));
	}


}
