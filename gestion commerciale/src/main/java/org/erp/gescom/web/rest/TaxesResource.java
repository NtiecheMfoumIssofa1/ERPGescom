package org.erp.gescom.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Taxes;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.TaxesService;
import org.erp.gescom.service.dto.TaxesDTO;
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
public class TaxesResource {
	
	private final Logger log = LoggerFactory.getLogger(TaxesResource.class);
	
	private static final String ENTITY_NAME ="taxes";
	
	private final TaxesService service;

	public TaxesResource(TaxesService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/taxes")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Taxes> createTaxes(@Valid @RequestBody TaxesDTO taxesDTO) throws URISyntaxException{
		log.debug("REST request to save Taxes {}",taxesDTO);
			if(taxesDTO.getIdTaxe() != null){
				throw new BadRequestAlertException("A new Taxes cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Taxes taxes = service.createTaxe(taxesDTO);
			return ResponseEntity.created(new URI("/api/taxes/"+taxes.getIdTaxe()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, taxes.getIdTaxe().toString()))
					.body(taxes);
	}
	@PutMapping("/taxes")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<TaxesDTO> updateTaxes(@Valid @RequestBody TaxesDTO taxesDTO) throws URISyntaxException{
		log.debug("REST request to update Taxes {}",taxesDTO);
			if(taxesDTO.getIdTaxe() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<TaxesDTO> updatedtaxes = service.updateTaxes(taxesDTO);
			return ResponseUtil.wrapOrNotFound(updatedtaxes,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, taxesDTO.getIdTaxe()));
	}
	@DeleteMapping("/taxes/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteTaxes(@PathVariable String id){
		log.debug("REST request to delete Taxes {}",id);
		service.deleteTaxe(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/taxes")
	@Timed
	public ResponseEntity<List<TaxesDTO>> getAllEntrer(Pageable pageable){
		final Page<TaxesDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/taxes");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/taxes/{id}")
	@Timed
	public ResponseEntity<TaxesDTO> getById(String id){
		log.debug("REST request to get taxes");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(TaxesDTO::new));
	}
	

}
