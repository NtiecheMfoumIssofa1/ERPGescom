package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Facture;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.FactureService;
import org.erp.gescom.service.dto.FactureDTO;
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
public class FactureResource {
	
	private final Logger log = LoggerFactory.getLogger(FactureResource.class);
	private static final String ENTITY_NAME = "Bills";
	private final FactureService factureService;
	
	public FactureResource(FactureService factureService){
		this.factureService = factureService;
	}
	@PostMapping("/bill")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Facture> createBill(@Valid @RequestBody FactureDTO factureDTO) throws URISyntaxException{
		log.debug("REST request to save bill {}",factureDTO);
			if(factureDTO.getIdFacture() != null){
				new BadRequestAlertException("A new Bill cannot already have an ID ", ENTITY_NAME, "idexists");
			}
			Facture facture = factureService.createFacture(factureDTO);
			return ResponseEntity.created(new URI("/api/bill/"+facture.getIdFacture()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, facture.getIdFacture().toString()))
					.body(facture);
	}
	@PutMapping("/bill")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<FactureDTO> updateBill(@Valid @RequestBody FactureDTO factureDTO) throws URISyntaxException{
		log.debug("REST request to update bill {}",factureDTO);
			if(factureDTO.getIdFacture() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<FactureDTO> updatedBill = factureService.updateFacture(factureDTO);
			return ResponseUtil.wrapOrNotFound(updatedBill,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, factureDTO.getIdFacture()));
	}
	@DeleteMapping("/bill/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteBill(@PathVariable String id){
		log.debug("REST request to delete bill {}",id);
		factureService.deleteFacture(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/bill")
	@Timed
	public ResponseEntity<List<FactureDTO>> getAllBill(Pageable pageable){
		
		final Page<FactureDTO> page = factureService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/bill");
		return new ResponseEntity<>(page.getContent(),headers,HttpStatus.OK);
	}
	@GetMapping("/bill/{id}")
	@Timed
	public ResponseEntity<FactureDTO> getById(@PathVariable String id){
		log.debug("REST request to get Bill");
		return ResponseUtil.wrapOrNotFound(
				factureService.getById(id).map(FactureDTO::new));
	}
	
}
