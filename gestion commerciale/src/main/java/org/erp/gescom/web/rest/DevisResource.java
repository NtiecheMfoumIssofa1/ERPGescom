package org.erp.gescom.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Devis;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.DevisService;
import org.erp.gescom.service.dto.DevisDTO;
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
public class DevisResource {
	
	private final Logger log = LoggerFactory.getLogger(DevisResource.class);
	
	private static final String ENTITY_NAME = "devis";
	private final DevisService  devisService;
	
	public DevisResource(DevisService devisService){
		this.devisService = devisService;
	}
	@PostMapping("/devis")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Devis> createDevis(@Valid @RequestBody DevisDTO  devisDTO) throws URISyntaxException{
		log.debug("REST request to save Devis: {}", devisDTO);
		if(devisDTO.getNumeroDevis() != null){
			throw new BadRequestAlertException("A new Devis cannot already have an ID", ENTITY_NAME, "idexists");
		}
		Devis newDevis = devisService.createDevis(devisDTO);
		return ResponseEntity.created(new URI("/api/devis/"+newDevis.getNumeroDevis().toString()))
				.body(newDevis);
	}
	@PutMapping("/devis")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<DevisDTO> updateDevis(DevisDTO devisDTO) throws URISyntaxException{
		log.debug("REST request to update Devis: {}",devisDTO);
		if(devisDTO.getNumeroDevis() == null){
			throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idnull");
		}
		Optional<DevisDTO> updatedDevis = devisService.updateDevis(devisDTO);
		return ResponseUtil.wrapOrNotFound(updatedDevis,
				HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, devisDTO.getNumeroDevis()));
	}
	@DeleteMapping("/devis/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteDevis(@PathVariable String id){
		log.debug("REST request to delete Devis");
		devisService.deleteDevis(id);
		return ResponseEntity.ok()
						.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/devis")
	@Timed
	public ResponseEntity<List<DevisDTO>> getAllDevis(Pageable pageable){
		
		final Page<DevisDTO> page = devisService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/devis");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	@GetMapping("/devis/{id}")
	@Timed
	public ResponseEntity<DevisDTO> getById(@PathVariable String id){
		log.debug("REST request to get Devis :{}",id);
		return ResponseUtil.wrapOrNotFound(devisService.getById(id).map(DevisDTO::new));
	}

}
