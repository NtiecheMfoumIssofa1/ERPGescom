package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.FamilleArticle;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.FamilleArticleService;
import org.erp.gescom.service.dto.FamilleArticleDTO;
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
public class FamilleArticleResource {
	
	private final Logger log = LoggerFactory.getLogger(FamilleArticleResource.class);
	private static final String ENTITY_NAME = "famille_Article";
	private final FamilleArticleService familleArticleService;
	
	public FamilleArticleResource(FamilleArticleService familleArticleService) {
		super();
		this.familleArticleService = familleArticleService;
	}
	@PostMapping("/familly")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<FamilleArticle> createFamille(@Valid @RequestBody FamilleArticleDTO familleArticleDTO) throws URISyntaxException{
		log.debug("REST request to save Famille_Article {}",familleArticleDTO);
			if(familleArticleDTO.getIdFamille() != null){
				throw new BadRequestAlertException("A new Famille_Article cannot already have an ID", ENTITY_NAME, "idexists");
			}
			FamilleArticle newFamille = familleArticleService.createFamille(familleArticleDTO);
			return ResponseEntity.created(new URI("/api/familly/"+newFamille.getIdFamille()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newFamille.getIdFamille().toString()))
					.body(newFamille);
	}
	@PutMapping("/familly")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<FamilleArticleDTO> updateFamille(@Valid @RequestBody FamilleArticleDTO familleArticleDTO) throws URISyntaxException{
		log.debug("REST request to update Famille_Article {}",familleArticleDTO);
			if(familleArticleDTO.getIdFamille() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<FamilleArticleDTO> updatedFamille = familleArticleService.updateFamille(familleArticleDTO);
			return ResponseUtil.wrapOrNotFound(updatedFamille,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, familleArticleDTO.getIdFamille()));
	
	}
	@DeleteMapping("/familly/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFamille(@PathVariable String id){
		log.debug("REST request to delete Famille_Article : {}",id);
		familleArticleService.deleteFamille(id);
		return ResponseEntity.ok()
						.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/familly")
	@Timed
	public ResponseEntity<List<FamilleArticleDTO>> getAllFamille(Pageable pageable){
		
		final Page<FamilleArticleDTO> page = familleArticleService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/familly");
		return new ResponseEntity<>(page.getContent(),headers,HttpStatus.OK);
	}
	@GetMapping("/familly/{id}")
	@Timed
	public ResponseEntity<FamilleArticleDTO> getById(@PathVariable String id){
		log.debug("REST request to get Famille_Article: {}",id);
		return ResponseUtil.wrapOrNotFound(
				familleArticleService.getById(id).map(FamilleArticleDTO::new));
	}

}
