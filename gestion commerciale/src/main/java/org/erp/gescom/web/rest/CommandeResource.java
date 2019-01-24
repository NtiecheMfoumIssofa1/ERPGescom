package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.CommandeService;
import org.erp.gescom.service.dto.CommandeDTO;
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
public class CommandeResource {
	
	private final Logger log = LoggerFactory.getLogger(CommandeResource.class);
	
	private static final String ENTITY_NAME = "order";
	
	private final CommandeService service;
	
	public CommandeResource(CommandeService commandeService){
		this.service = commandeService;
	}
	@PostMapping("/order")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Commande> createOrder(@Valid @RequestBody CommandeDTO commandeDTO) throws URISyntaxException{
		log.debug("REST request to save Order : {}",commandeDTO);
		if(commandeDTO.getNumCommande() != null){
			throw new BadRequestAlertException("A new Order cannot already have an ID", ENTITY_NAME, "idexists");
		}
		Commande newOrder = service.createCommande(commandeDTO);
		return ResponseEntity.created(new URI("/api/order/"+newOrder.getNumCommande()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newOrder.getNumCommande().toString()))
				.body(newOrder);
	}
	@PutMapping("/order")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<CommandeDTO> updateOrder(@Valid @RequestBody CommandeDTO commandeDTO) throws URISyntaxException{
		log.debug("REST request to update Order : {}",commandeDTO);
		if(commandeDTO.getNumCommande() == null){
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		Optional<CommandeDTO> updatedOrder = service.updateCommande(commandeDTO);
		return ResponseUtil.wrapOrNotFound(updatedOrder,
				HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, commandeDTO.getNumCommande()));
	}
	@DeleteMapping("/order/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteOrder(@PathVariable String id){
		log.debug("REST request to delete  Order : {}",id);
		service.deleteCommande(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/order")
	@Timed
	public ResponseEntity<List<CommandeDTO>> getAllOrder(Pageable pageable){
		
		final Page<CommandeDTO> page = service.getAllByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/order");
		return new ResponseEntity<>(page.getContent(),headers,HttpStatus.OK);
	}
	@GetMapping("/order/{id}")
	@Timed
	public ResponseEntity<CommandeDTO> getById(@PathVariable String id){
		log.debug("REST request to get Order : {}",id);
		return ResponseUtil.wrapOrNotFound(service.getById(id).map(CommandeDTO::new));
	}
}
