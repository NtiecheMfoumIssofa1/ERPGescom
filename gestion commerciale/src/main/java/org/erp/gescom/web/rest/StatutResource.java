package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Statut;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.StatutService;
import org.erp.gescom.service.dto.StatutDTO;
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
public class StatutResource {
	
	private final Logger log = LoggerFactory.getLogger(StatutResource.class);
	
	private static final String ENTITY_NAME = "statuts";
	private final StatutService service;
	
	public StatutResource(StatutService service) {
		this.service = service;
	}
	
	
	@PostMapping("/statut")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Statut> createFunction(@Valid @RequestBody StatutDTO statutDTO) throws URISyntaxException{
		log.debug("REST request to save Statuts {}",statutDTO);
			if(statutDTO.getIdStatut() != null){
				throw new BadRequestAlertException("A new Statuts cannot already have an ID", ENTITY_NAME, "idexists");
			}
			Statut statut = service.createStatut(statutDTO);
			return ResponseEntity.created(new URI("/api/statut/"+statut.getIdStatut()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, statut.getIdStatut().toString()))
					.body(statut);
	}
	@PutMapping("/statut")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<StatutDTO> updateFunction(@Valid @RequestBody StatutDTO statutDTO) throws URISyntaxException{
		log.debug("REST request to update Statuts {}",statutDTO);
			if(statutDTO.getIdStatut() == null){
				throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
			}
			Optional<StatutDTO> updatedstatut= service.updateStatut(statutDTO);
			return ResponseUtil.wrapOrNotFound(updatedstatut,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, statutDTO.getIdStatut()));
	}
	@DeleteMapping("/statut/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteFunction(@PathVariable String id){
		log.debug("REST request to delete Statut {}",id);
		service.deleteStatut(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/statut")
	@Timed
	public ResponseEntity<List<StatutDTO>> getAllFunction(Pageable pageable){
		final Page<StatutDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/statut");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/statut/{id}")
	@Timed
	public ResponseEntity<StatutDTO> getById(String id){
		log.debug("REST request to get Statut");
		return ResponseUtil.wrapOrNotFound(
				service.getByid(id).map(StatutDTO::new));
	}

}
