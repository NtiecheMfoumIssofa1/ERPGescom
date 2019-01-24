package org.erp.gescom.service;

import java.util.List;

import org.erp.gescom.domain.Cheque;
import org.erp.gescom.domain.Livraison;
import org.erp.gescom.domain.ModeReglement;
import org.erp.gescom.domain.MtnMobileMoney;
import org.erp.gescom.domain.OrangeMoney;
import org.erp.gescom.repository.ModeReglementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ModeReglementService {
	
	private final Logger log = LoggerFactory.getLogger(ModeReglementService.class);
	
	private final ModeReglementRepository modeReglementRepository;

	public ModeReglementService(ModeReglementRepository modeReglementRepository) {
		super();
		this.modeReglementRepository = modeReglementRepository;
	}
	
	//create cheque
	public ModeReglement reglementParCheque(Cheque cheque){
		return modeReglementRepository.save(
					new Cheque(
						 cheque.getId(), 
						 cheque.getLibelleReglement(), 
						 cheque.getFactures(), 
						 cheque.getNumero(), 
						 cheque.getDateValidite(), 
						 cheque.getTypeCheque())); 
	}
	//create Livraison
	public ModeReglement reglementParLivraison(Livraison livraison){
		return modeReglementRepository.save(
						new Livraison(
								livraison.getId(), 
								livraison.getLibelleReglement(), 
								livraison.getFactures(), 
								livraison.getDateLivraison(), 
								livraison.getAddress()));
	}
	//create mtn_mobile_money
	public ModeReglement reglementParMtn(MtnMobileMoney money){
		return modeReglementRepository.save(
				  new MtnMobileMoney(
						  money.getId(), 
						  money.getLibelleReglement(), 
						  money.getFactures(), 
						  money.getTelephone(), 
						  money.getDatePaiement()
						  ) 
				);
	}
	//create orangeMoney
	public ModeReglement reglementParOrange(OrangeMoney money){
		return modeReglementRepository.save(
				new OrangeMoney(
						money.getId(),
						money.getLibelleReglement(), 
						money.getFactures(), 
						money.getTelephone(), 
						money.getDatePaiement()
						)
				);
	}
	
	/** find All transaction*/
	
	public List<ModeReglement> getAllCheque(){
		return modeReglementRepository.findAll();
	}
	
	

}
