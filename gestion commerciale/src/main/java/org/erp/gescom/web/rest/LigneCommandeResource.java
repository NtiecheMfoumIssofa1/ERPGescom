package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.LigneCommande;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.LigneCommandeService;

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
public class LigneCommandeResource {
	
	private final Logger log = LoggerFactory.getLogger(LigneCommandeResource.class);
	private static final String ENTITY_NAME = "ligne_commande";
	private final LigneCommandeService service;
	
	public LigneCommandeResource(LigneCommandeService service) {
		this.service = service;
	}
	
	@PostMapping("/ligne")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<LigneCommande> createLigne(@Valid @RequestBody LigneCommande ligneCommande) throws URISyntaxException{
		log.debug("REST request to save Ligne {}",ligneCommande);
			if(ligneCommande.getId() != null){
				throw new BadRequestAlertException("A new ligne cannot already have an ID", ENTITY_NAME, "idexists");
			}
			LigneCommande commande = service.createLigne(ligneCommande);
			return ResponseEntity.created(new URI("/api/ligne/"+commande.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, commande.getId().toString()))
					.body(commande);
	}
	@PutMapping("/ligne/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public LigneCommande updateFunction(@Valid @RequestBody LigneCommande ligneCommande, @PathVariable String id) throws URISyntaxException{
		log.debug("REST request to update Ligne {}",ligneCommande);
			if(ligneCommande.getId() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			return  service.updateligne(ligneCommande, id);
	}
	@DeleteMapping("/ligne/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFunction(@PathVariable String id){
		log.debug("REST request to delete Ligne {}",id);
		service.deleteligne(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/ligne")
	@Timed
	public ResponseEntity<List<LigneCommande>> getAllFunction(Pageable pageable){
		final Page<LigneCommande> page = service.getAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/ligne");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/ligne/{id}")
	@Timed
	public ResponseEntity<LigneCommande> getById(String id){
		log.debug("REST request to get Function");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id));
	}

}
