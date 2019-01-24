package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Fonction;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.FonctionService;
import org.erp.gescom.service.dto.FonctionDTO;
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
public class FonctionResource {
	
	private final Logger log = LoggerFactory.getLogger(FonctionResource.class);
	
	private static final String ENTITY_NAME = "function";
	
	private final FonctionService fonctionService;

	public FonctionResource(FonctionService fonctionService) {
		super();
		this.fonctionService = fonctionService;
	}
	@PostMapping("/function")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Fonction> createFunction(@Valid @RequestBody FonctionDTO fonctionDTO) throws URISyntaxException{
		log.debug("REST request to save Function {}",fonctionDTO);
			if(fonctionDTO.getIdFonction() != null){
				throw new BadRequestAlertException("A new Function cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Fonction fonction = fonctionService.createFunction(fonctionDTO);
			return ResponseEntity.created(new URI("/api/function/"+fonction.getIdFonction()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, fonction.getIdFonction().toString()))
					.body(fonction);
	}
	@PutMapping("/function")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<FonctionDTO> updateFunction(@Valid @RequestBody FonctionDTO fonctionDTO) throws URISyntaxException{
		log.debug("REST request to update Function {}",fonctionDTO);
			if(fonctionDTO.getIdFonction() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<FonctionDTO> updatedFunction = fonctionService.updateFonction(fonctionDTO);
			return ResponseUtil.wrapOrNotFound(updatedFunction,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, fonctionDTO.getIdFonction()));
	}
	@DeleteMapping("/function/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFunction(@PathVariable String id){
		log.debug("REST request to delete Function {}",id);
		fonctionService.deleteFonction(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/function")
	@Timed
	public ResponseEntity<List<FonctionDTO>> getAllFunction(Pageable pageable){
		final Page<FonctionDTO> page = fonctionService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/function");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/function/{id}")
	@Timed
	public ResponseEntity<FonctionDTO> getById(String id){
		log.debug("REST request to get Function");
		return ResponseUtil.wrapOrNotFound(
				fonctionService.getById(id).map(FonctionDTO::new));
	}

}
