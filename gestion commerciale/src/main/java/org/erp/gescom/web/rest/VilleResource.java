package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Ville;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.VilleService;
import org.erp.gescom.service.dto.VilleDTO;
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
public class VilleResource {

	private final Logger log = LoggerFactory.getLogger(VilleResource.class);
	
	private static final String ENTITY_NAME ="ville";
	
	private final VilleService service;

	public VilleResource(VilleService service) {
		super();
		this.service = service;
	}
	@PostMapping("/ville")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Ville> createTaxes(@Valid @RequestBody VilleDTO villeDTO) throws URISyntaxException{
		log.debug("REST request to save Ville {}",villeDTO);
			if(villeDTO.getId() != null){
				throw new BadRequestAlertException("A new ville cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Ville ville = service.createVille(villeDTO);
			return ResponseEntity.created(new URI("/api/ville/"+ville.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, ville.getId().toString()))
					.body(ville);
	}
	@PutMapping("/ville")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<VilleDTO> updateTaxes(@Valid @RequestBody VilleDTO villeDTO) throws URISyntaxException{
		log.debug("REST request to update Ville {}",villeDTO);
			if(villeDTO.getId() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<VilleDTO> updatedVille = service.updateVille(villeDTO);
			return ResponseUtil.wrapOrNotFound(updatedVille,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME,villeDTO.getId()));
	}
	@DeleteMapping("/ville/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteTaxes(@PathVariable String id){
		log.debug("REST request to delete Ville {}",id);
		service.deleteVille(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/ville")
	@Timed
	public ResponseEntity<List<VilleDTO>> getAllEntrer(Pageable pageable){
		final Page<VilleDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/ville");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/ville/{id}")
	@Timed
	public ResponseEntity<VilleDTO> getById(String id){
		log.debug("REST request to get Ville");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(VilleDTO::new));
	}
}
