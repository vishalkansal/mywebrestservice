package com.project.fundamentals;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FundamentalsServiceimp implements FundamentalsService{

	@Autowired
	private FundamentalsRepo fundamentalsRepo;
	
	
	
	public FundamentalsServiceimp(FundamentalsRepo fundamentalsRepo)
	{
	this.fundamentalsRepo=fundamentalsRepo;
	}
	
	
	@Override
	public Fundamentalssetvouchercard addFundamentalssetvouchercard(Fundamentalssetvouchercard fundamentalssetvouchercard) {
		//System.out.println(fundamentalssetvouchercard);
		return fundamentalsRepo.save(fundamentalssetvouchercard);
	}

/*
	@Override
	public void updateFundamentalssetvouchercard(String card_group_set_name,Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
	Fundamentalssetvouchercard update=	 fundamentalsRepo.findByCard_group_set_name(card_group_set_name);
		   //Optional<Fundamentalssetvouchercard> update=fundamentalsService.updateFundamentalssetvouchercard( CARD_GROUP_SET_ID);
	int i=0;
	i=update.getCARD_GROUP_SET_ID();	    
	if(i!=0)
		     {
		    	 fundamentalsupdatevouchercard.setCARD_GROUP_SET_ID(i);
		    	 fundamentalsRepo.save(fundamentalsupdatevouchercard);
		     }    
	}
	*/
	
	@Override
	public void updateFundamentalssetvouchercardbyid(int card_group_set_id,Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
//	Fundamentalssetvouchercard update=	 fundamentalsRepo.findById(card_group_set_id);
		   Optional<Fundamentalssetvouchercard> update=fundamentalsRepo.findById( card_group_set_id);
    
	if(update!=null)
		     {
		    	 fundamentalsupdatevouchercard.setCARD_GROUP_SET_ID(card_group_set_id);
		    	 fundamentalsRepo.save(fundamentalsupdatevouchercard);
		     }    
	}


	@Override
	public List<Fundamentalssetvouchercard> getall() {
		
		return fundamentalsRepo.findAll();
	}


	@Override
	public void deletebyid(int id) {
		
		fundamentalsRepo.deleteById(id);
		
	}
		
	
}