package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.AgenceService;
import org.erp.gescom.service.dto.AgenceDTO;
import org.erp.gescom.service.dto.UserDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class AgenceResource {
	
	private final Logger log = LoggerFactory.getLogger(AgenceResource.class);
	
	private static final String ENTITY_NAME = "agence";
	
	private final AgenceService agenceService;

	public AgenceResource( AgenceService agenceService) {
		this.agenceService = agenceService;
	}
	
	 /**
     * POST  /agence : Create a new agence.
     *
     * @param agence the agence to create
     * @return the ResponseEntity with status 201 (Created) and with body the new agence, or with status 400 (Bad Request) if the agence has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PostMapping("/agency")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Agence> createAgency(@Valid @RequestBody AgenceDTO agenceDTO) throws URISyntaxException{
		
		log.debug("REST request to save Agency :{}",agenceDTO);
		 if(agenceDTO.getId() != null){
			 throw new BadRequestAlertException("A new Agency cannot already have an ID", ENTITY_NAME, "idexists");
		 }
		 Agence newAgency = agenceService.createAgence(agenceDTO);
		 return ResponseEntity.created(new URI("/api/agence/"+ newAgency.getId()))
				 .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newAgency.getId().toString()))
				 .body(newAgency);
	}
	 /**
     * PUT  /agency : Updates an existing agency.
     *
     * @param agency the agency to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated agency,
     * or with status 400 (Bad Request) if the agency is not valid,
     * or with status 500 (Internal Server Error) if the agency couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PutMapping("/agency")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<AgenceDTO> updateAgency(@Valid @RequestBody AgenceDTO agenceDTO)throws URISyntaxException{
		log.debug("REST request to update Agency : {}", agenceDTO);
		if(agenceDTO.getId() == null){
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		Optional<AgenceDTO> updatedAgency= agenceService.updateAgence(agenceDTO);
		return ResponseUtil.wrapOrNotFound(updatedAgency,
				HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, agenceDTO.getId()));
	}
	
	 /**
	  * 
    * DELETE /agency/:id : delete the "id" Agency.
    *
    * @param id the id of the agency to delete
    * @return the ResponseEntity with status 200 (OK)
    */
	@Secured(AuthoritiesConstants.ADMIN)
	@DeleteMapping("/agency/{id}")
	@Timed
	public ResponseEntity<Void> deleteAgency(@PathVariable String id){
		log.debug("REST request to delete Agency : {}",id);
		agenceService.deleteAgence(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	 /**
     * GET  /agency : get all the agency.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of agency in body
     */
	@GetMapping("/agency")
	@Timed
	public ResponseEntity<List<AgenceDTO>> getAllAgency(Pageable pageable)
	{
		final Page<AgenceDTO> page = agenceService.getAllAgenceByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/agency");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	
	/**
     * GET  /agency/:id : get the "id" agency.
     *
     * @param id the id of the agency to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the agency, or with status 404 (Not Found)
     */
	@GetMapping("/agency/{id}")
	@Timed
	public ResponseEntity<AgenceDTO> getAgency(@PathVariable String id){
		log.debug("REST request to get Agency : {}", id);
		return ResponseUtil.wrapOrNotFound(
					agenceService.getAgenceById(id).map(AgenceDTO::new));
	}
	
}
