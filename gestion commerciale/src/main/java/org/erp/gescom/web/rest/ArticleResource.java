package org.erp.gescom.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.erp.gescom.domain.Article;
import org.erp.gescom.security.AuthoritiesConstants;
import org.erp.gescom.service.ArticleService;
import org.erp.gescom.service.dto.ArticleDTO;
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
public class ArticleResource {
	
	private final Logger log = LoggerFactory.getLogger(ArticleResource.class);
	
	private static final String ENTITY_NAME = "article";
	
	private final ArticleService articleService;

	public ArticleResource(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	@PostMapping("/article")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Article> createArticle(@Valid @RequestBody ArticleDTO articleDTO) throws URISyntaxException{
		
		log.debug("REST request to save Article : {}", articleDTO.getRefArticle());
		if(articleDTO.getRefArticle() != null){
			throw new BadRequestAlertException( "A new Article cannot already have an ID", ENTITY_NAME, "idexists");
		}
		Article newArticle = articleService.createArticle(articleDTO);
		return ResponseEntity.created(new URI("/api/article/"+newArticle.getRefArticle()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, newArticle.getRefArticle().toString()))
				.body(newArticle);
	}
	@PutMapping("/article")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<ArticleDTO> updateArticle(ArticleDTO articleDTO) throws URISyntaxException{
		
		log.debug("REST request to update Article : {}",articleDTO);
		if(articleDTO.getRefArticle() == null){
			throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idnull");
		}
		log.debug(" ID : {}",articleDTO.getRefArticle());
		Optional<ArticleDTO> updatedArticle = articleService.updateArticle(articleDTO);
		return ResponseUtil.wrapOrNotFound(updatedArticle,
					HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, articleDTO.getRefArticle()));
	}
	@DeleteMapping("/article/id")
	@Timed
	@Secured(AuthoritiesConstants.ADMIN)
	public ResponseEntity<Void> deleteArticle(@PathVariable String id){
		log.debug("REST request to delete Article : {}", id);
		articleService.deteleArticle(id);
		return ResponseEntity.ok()
					.headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
	}
	@GetMapping("/article")
	@Timed
	public ResponseEntity<List<ArticleDTO>> getAllArticle(Pageable pageable){
		
		final Page<ArticleDTO> page = articleService.getArticleByMc(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/article");
		return new ResponseEntity<>(page.getContent(), headers , HttpStatus.OK);
	}
	public ResponseEntity<ArticleDTO> getArticle(String ref){
		log.debug("REST request to get Article : {}",ref);
		return ResponseUtil.wrapOrNotFound(
				articleService.getByRef(ref).map(ArticleDTO::new));
	}

}
