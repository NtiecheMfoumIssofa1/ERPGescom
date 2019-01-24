package org.erp.gescom.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.TypeClient;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.TypeclientService;
import org.erp.gescom.service.dto.TypeClientDTO;
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
public class TypeClientResource {
	
	private final Logger log = LoggerFactory.getLogger(TypeClientResource.class);
	private static final String ENTITY_NAME ="type_Client";
	private final TypeclientService service;
	public TypeClientResource(TypeclientService service) {
		super();
		this.service = service;
	}
	@PostMapping("/type")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<TypeClient> createTaxes(@Valid @RequestBody TypeClientDTO typeClientDTO) throws URISyntaxException{
		log.debug("REST request to save Type client {}",typeClientDTO);
			if(typeClientDTO.getIdType() != null){
				throw new BadRequestAlertException("A new Taxes cannot already have an ID", ENTITY_NAME, "idexists");
			}
			TypeClient typeClient = service.createType(typeClientDTO);
			return ResponseEntity.created(new URI("/api/type/"+typeClient.getIdType()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, typeClient.getIdType().toString()))
					.body(typeClient);
	}
	@PutMapping("/type")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<TypeClientDTO> updateTaxes(@Valid @RequestBody TypeClientDTO typeClientDTO) throws URISyntaxException{
		log.debug("REST request to update Type client {}",typeClientDTO);
			if(typeClientDTO.getIdType() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<TypeClientDTO> updatedtype = service.updateType(typeClientDTO);
			return ResponseUtil.wrapOrNotFound(updatedtype,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME,typeClientDTO.getIdType()));
	}
	@DeleteMapping("/type/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteTaxes(@PathVariable String id){
		log.debug("REST request to delete Type client {}",id);
		service.deleteType(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/type")
	@Timed
	public ResponseEntity<List<TypeClientDTO>> getAllEntrer(Pageable pageable){
		final Page<TypeClientDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/type");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/type/{id}")
	@Timed
	public ResponseEntity<TypeClientDTO> getById(String id){
		log.debug("REST request to get Type client");
		return ResponseUtil.wrapOrNotFound(
				service.getById(id).map(TypeClientDTO::new));
	}

}
