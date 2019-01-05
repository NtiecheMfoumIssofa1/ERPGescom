package org.erp.gescom.web.rest.errors;

public class ArticleAlreadyExitException extends BadRequestAlertException{

	public ArticleAlreadyExitException() {
		super(ErrorConstants.ARTICLE_NOT_FOUND,"Article is already use in","articleDTO","idexists");
		// TODO Auto-generated constructor stub
	}
	

}
