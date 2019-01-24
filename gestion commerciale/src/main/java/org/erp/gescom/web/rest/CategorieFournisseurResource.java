package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.repository.CategorieFournisseurRepository;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.CategorieFounisseurService;
import org.erp.gescom.service.dto.CategorieFournisseurDTO;
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
public class CategorieFournisseurResource {
	
	private final Logger log = LoggerFactory.getLogger(CategorieFournisseurResource.class);
	
	private static final String ENTITY_NAME = "categorieFournisseur";
	
	private final CategorieFounisseurService service;
	
	public CategorieFournisseurResource(CategorieFounisseurService founisseurService){
		this.service = founisseurService;
	}
	
	@PostMapping("/categorieFournisseur")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<CategorieFournisseur> createCategory(@Valid @RequestBody CategorieFournisseurDTO categorieFournisseurDTO) throws URISyntaxException{
		log.debug("REST request to save Category : {}",categorieFournisseurDTO);
		if(categorieFournisseurDTO !=null){
			throw new BadRequestAlertException("A new Category fournisseur cannot already have an ID", ENTITY_NAME, "idexists");
		}
		CategorieFournisseur newCategorie = service.createCategorie(categorieFournisseurDTO);
		return ResponseEntity.created(new URI("/api/categorieFournisseur/"+newCategorie.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newCategorie.getId().toString()))
				.body(newCategorie);
	}
	
	@PutMapping("/categorieFournisseur")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<CategorieFournisseurDTO> updateCategory(@Valid @RequestBody CategorieFournisseurDTO fournisseurDTO) throws URISyntaxException{
		log.debug("REST request to update Category : {}", fournisseurDTO);
		if(fournisseurDTO.getIdCategorie() == null){
			throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idnull");
		}
		Optional<CategorieFournisseurDTO> updatetCategorie = service.updateCategorie(fournisseurDTO);
		return ResponseUtil.wrapOrNotFound(updatetCategorie,
				HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, fournisseurDTO.getIdCategorie()));
	}
	@DeleteMapping("/categorieFournisseur/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteCategory(@PathVariable String id){
		log.debug("REST request to delete Categorie fournisseur : {}",id);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	
	@GetMapping("/categorieFournisseur")
	@Timed
	public ResponseEntity<List<CategorieFournisseurDTO>> getAllCategory(Pageable pageable){
		
		final Page<CategorieFournisseurDTO> page = service.getAllCategorieByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/categorieFournisseur");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	@GetMapping("/categorieFournisseur/{id}")
	public ResponseEntity<CategorieFournisseurDTO> getById(@PathVariable String id){
		log.debug("REST request to save category fournisseur : {}",id);
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(CategorieFournisseurDTO::new));
	}

}
