package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.erp.gescom.domain.Cheque;
import org.erp.gescom.domain.Livraison;
import org.erp.gescom.domain.ModeReglement;
import org.erp.gescom.domain.MtnMobileMoney;
import org.erp.gescom.domain.OrangeMoney;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.ModeReglementService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/api")
public class ModeReglementResource {
	
	private final Logger log = LoggerFactory.getLogger(ModeReglementResource.class);
	private static final String ENTITY_NAME = "Mode_Reglement";
	private final ModeReglementService reglementService;
	
	public ModeReglementResource(ModeReglementService reglementService) {
		super();
		this.reglementService = reglementService;
	}
	@PostMapping("/cheque")
	@Timed
	public ResponseEntity<ModeReglement> createCheque(Cheque cheque) throws URISyntaxException{
		log.debug("REST request to save  transaction by cheque {}",cheque);
		 if(cheque.getId() != null){
			 throw new BadRequestAlertException("A new cheque cannot already have an ID", ENTITY_NAME, "idexists");
		 }
		 ModeReglement newCheque = reglementService.reglementParCheque(cheque);
		 return ResponseEntity.created(new URI("/api/cheque/"+newCheque.getId()))
				 .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newCheque.getId().toString()))
				 .body(newCheque);
	}
	
	@PostMapping("/mtn")
	@Timed
	public ResponseEntity<ModeReglement> createMtnMobileMoney(MtnMobileMoney money) throws URISyntaxException{
		log.debug("REST request to save  transaction by Mtn Mobile Money {}",money);
		 if(money.getId() != null){
			 throw new BadRequestAlertException("A new Mtn Mobile Money cannot already have an ID", ENTITY_NAME, "idexists");
		 }
		 ModeReglement newMtn = reglementService.reglementParMtn(money);
		 return ResponseEntity.created(new URI("/api/mtn/"+newMtn.getId()))
				 .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newMtn.getId().toString()))
				 .body(newMtn);
	}
	
	@PostMapping("/orange")
	@Timed
	public ResponseEntity<ModeReglement> createOrangeMoney(OrangeMoney money) throws URISyntaxException{
		log.debug("REST request to save  transaction by Orange Money {}",money);
		 if(money.getId() != null){
			 throw new BadRequestAlertException("A new Orange Money cannot already have an ID", ENTITY_NAME, "idexists");
		 }
		 ModeReglement newOrange = reglementService.reglementParOrange(money);
		 return ResponseEntity.created(new URI("/api/orange/"+newOrange.getId()))
				 .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newOrange.getId().toString()))
				 .body(newOrange);
	}
	@PostMapping("/livraison")
	@Timed
	public ResponseEntity<ModeReglement> createLivraison(Livraison livraison) throws URISyntaxException{
		log.debug("REST request to save  Livraison {}",livraison);
		 if(livraison.getId() != null){
			 throw new BadRequestAlertException("A new Mtn Mobile Money cannot already have an ID", ENTITY_NAME, "idexists");
		 }
		 ModeReglement newLivraison = reglementService.reglementParLivraison(livraison);
		 return ResponseEntity.created(new URI("/api/livraison/"+newLivraison.getId()))
				 .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newLivraison.getId().toString()))
				 .body(newLivraison);
	}
	@GetMapping("/mode")
	@Timed
	public ResponseEntity<List<ModeReglement>> getAllMode(Pageable pageable){
		final Page<ModeReglement> page = reglementService.getAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/mode");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	@GetMapping("/mode/{id}")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteMode(@PathVariable String id){
		log.debug("REST request to delete Mode_reglement {}",id);
		reglementService.deleteReglement(id);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}

}
