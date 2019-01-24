package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Depence;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.DepencesService;
import org.erp.gescom.service.dto.DepenceDTO;
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
public class DepenceResource {
	
	private final Logger log = LoggerFactory.getLogger(DepenceResource.class);
	
	private static final String ENTITY_NAME = "expense";
	
	private final DepencesService  depencesService;
	
	public DepenceResource(DepencesService service){
		this.depencesService = service;
	}
	@PostMapping("/expense")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Depence> createExpense(@Valid @RequestBody DepenceDTO depenceDTO) throws URISyntaxException{
		log.debug("REST request to save Expense : {}", depenceDTO);
		if(depenceDTO.getNumeroDepence() != null){
			throw new BadRequestAlertException("A new Expense cannot already have an ID", ENTITY_NAME, "idexists");
		}
		Depence depence = depencesService.createDepence(depenceDTO);
		return ResponseEntity.created(new URI("/api/expense/"+depence.getNumeroDepence()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, depence.getNumeroDepence().toString()))
				.body(depence);	
	}
	@PutMapping("/expense")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<DepenceDTO> updateExpense(@Valid @RequestBody DepenceDTO depenceDTO) throws URISyntaxException{
		log.debug("REST request to update Expense : {}", depenceDTO);
		if(depenceDTO.getNumeroDepence() == null){
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		Optional<DepenceDTO> updatedExpense = depencesService.updateDepence(depenceDTO);
		return ResponseUtil.wrapOrNotFound(updatedExpense,
						HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, depenceDTO.getNumeroDepence()));
	}
	@DeleteMapping("/expense/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteExpense(@PathVariable String id){
		log.debug("REST request to delete Expense : {}",id);
		depencesService.deleteDepence(id);
		return ResponseEntity.ok()
						.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/expense")
	@Timed
	public ResponseEntity<List<DepenceDTO>> getAllExpence(Pageable pageable){
		
		final Page<DepenceDTO> page = depencesService.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/expense");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	@GetMapping("/expense/{id}")
	@Timed
	public ResponseEntity<DepenceDTO> getbyId(@PathVariable String id){
		log.debug("REST request to get Expense :{}",id);
		return ResponseUtil.wrapOrNotFound(depencesService.getById(id).map(DepenceDTO::new));
	}

}
