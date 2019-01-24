package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Etat;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.EtatService;
import org.erp.gescom.service.dto.EtatDTO;
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
public class EtatResource {
	
	private final Logger log = LoggerFactory.getLogger(EtatResource.class);
	
	private static final String ENTITY_NAME = "etat";
	
	private final EtatService etatService;
	
	public EtatResource(EtatService etatService){
		this.etatService = etatService;
	}
	@PostMapping("/etat")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Etat> createEtat(@Valid @RequestBody EtatDTO etatDTO) throws URISyntaxException{
		log.debug("REST request to save Etat : {}",etatDTO);
			if(etatDTO.getIdEtat() != null){
				throw new BadRequestAlertException("A new Etat cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Etat etat = etatService.createEtat(etatDTO);
			return ResponseEntity.created(new URI("/api/etat/"+etat.getIdEtat()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, etat.getIdEtat().toString()))
					.body(etat);
	}
	@PutMapping("/etat")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<EtatDTO> updateEtat( @Valid @RequestBody EtatDTO etatDTO) throws URISyntaxException{
		log.debug("REST request to update Etat : {}",etatDTO);
			if(etatDTO.getIdEtat() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<EtatDTO> updatedEtat = etatService.updateEtat(etatDTO);
			return ResponseUtil.wrapOrNotFound(updatedEtat,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, etatDTO.getIdEtat()));
	}
	@DeleteMapping("/etat/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteEtat(@PathVariable String id){
		log.debug("REST request to delete Etat : {}",id);
		etatService.deleteEtat(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/etat")
	@Timed
	public ResponseEntity<List<EtatDTO>> getAllEtat(Pageable pageable){
		
		final Page<EtatDTO> page = etatService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/etat");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
		
	}
	@GetMapping("/etat/{id}")
	@Timed
	public ResponseEntity<EtatDTO> getById(@PathVariable String id){
		log.debug("REST request to get Etat {}",id);
		return ResponseUtil.wrapOrNotFound(
				etatService.getById(id).map(EtatDTO::new));
	}

}
