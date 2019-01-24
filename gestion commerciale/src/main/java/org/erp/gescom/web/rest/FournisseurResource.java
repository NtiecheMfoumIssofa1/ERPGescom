package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.FournisseurService;
import org.erp.gescom.service.dto.FournisseurDTO;
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
public class FournisseurResource {
	
	private final Logger log = LoggerFactory.getLogger(FournisseurResource.class);
	private static final String ENTITY_NAME = "fournisseur";
	private final FournisseurService fournisseurService;
	
	public FournisseurResource(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	@PostMapping("/fournisseur")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Fournisseur> createFournisseur(@Valid @RequestBody FournisseurDTO fournisseurDTO) throws URISyntaxException{
		log.debug("REST request to save Fournisseur {}",fournisseurDTO);
			if(fournisseurDTO.getIdFournisseur() != null){
				throw new BadRequestAlertException("A new Fournisseur cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Fournisseur fournisseur = fournisseurService.createFournisseur(fournisseurDTO);
			return ResponseEntity.created(new URI("/api/fournisseur/"+fournisseur.getIdFournisseur()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, fournisseur.getIdFournisseur().toString()))
					.body(fournisseur);
	}
	@PutMapping("/fournisseur")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<FournisseurDTO> updateFournisseur(@Valid @RequestBody FournisseurDTO fournisseurDTO) throws URISyntaxException{
		log.debug("REST request to update Fournisseur {}",fournisseurDTO);
			if(fournisseurDTO.getIdFournisseur() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<FournisseurDTO> updatedFournisseur = fournisseurService.updateFournisseur(fournisseurDTO);
			return ResponseUtil.wrapOrNotFound(updatedFournisseur,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, fournisseurDTO.getIdFournisseur()));
	}
	@DeleteMapping("/fournisseur/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFournisseur(@PathVariable String id){
		log.debug("REST request to delete Function {}",id);
		fournisseurService.deleteFournisseur(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/fournisseur")
	@Timed
	public ResponseEntity<List<FournisseurDTO>> getAllFunction(Pageable pageable){
		final Page<FournisseurDTO> page = fournisseurService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/function");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/fournisseur/{id}")
	@Timed
	public ResponseEntity<FournisseurDTO> getById(String id){
		log.debug("REST request to get Function");
		return ResponseUtil.wrapOrNotFound(
				fournisseurService.getById(id).map(FournisseurDTO::new));
	}

}
