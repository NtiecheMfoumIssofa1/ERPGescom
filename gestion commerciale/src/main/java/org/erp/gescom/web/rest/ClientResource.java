package org.erp.gescom.web.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Client;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.ClientService;
import org.erp.gescom.service.dto.ClientDTO;
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
public class ClientResource {
	
	private final Logger log = LoggerFactory.getLogger(ClientResource.class);
	
	private static final String ENTITY_NAME = "customer";
	
	private final ClientService clientService;

	
	public ClientResource(ClientService clientService){
		this.clientService = clientService;
	}
	@PostMapping("/customer")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Client> createCustomer(@Valid @RequestBody ClientDTO clientDTO) throws URISyntaxException{
		
		log.debug("REST request to save Customer :{}",clientDTO);
		if(clientDTO.getIdClient() != null){
			throw new BadRequestAlertException("a new Customer cannot already have a ID", ENTITY_NAME, "idexists");
		}
		Client newClient = clientService.createClient(clientDTO);
		return ResponseEntity.created(new URI("/api/customer/"+newClient.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newClient.getId().toString()))
				.body(newClient);
	}
	@PutMapping("/customer")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<ClientDTO> updateCustomer(@Valid @RequestBody ClientDTO clientDTO) throws URISyntaxException{
		
		log.debug("REST request to update Customer :{}",clientDTO);
		if(clientDTO.getIdClient() ==null){
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		Optional<ClientDTO> updatedClient = clientService.updateClient(clientDTO);
		return ResponseUtil.wrapOrNotFound(updatedClient,
				HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, clientDTO.getIdClient()));
	}
	@DeleteMapping("/customer/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
		log.debug("REST request to delete Customer : {}",id);
		clientService.deleteClient(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/customer")
	@Timed
	public ResponseEntity<List<ClientDTO>> getAllCustomer(Pageable pageable){
		
		final Page<ClientDTO> page = clientService.getAllClientMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/customer");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	@GetMapping("/customer/id")
	@Timed
	public ResponseEntity<ClientDTO> getCustomer(@PathVariable String id){
		log.debug("REST request to get Customer : {}",id);
		return ResponseUtil.wrapOrNotFound(clientService.getById(id).map(ClientDTO::new));
	}
}
