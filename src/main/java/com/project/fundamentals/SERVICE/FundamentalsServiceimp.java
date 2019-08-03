package com.project.fundamentals.SERVICE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;
import com.project.fundamentals.REPOSITORY.*;
import com.project.fundamentals.REPOSITORY.RepoCardGroupDetails;






@Service
public class FundamentalsServiceimp implements FundamentalsService{


	private FundamentalsRepo fundamentalsRepo;
	
	RepoCardGroupDetails repocardgroupdetails;
	
	@Autowired
	public FundamentalsServiceimp(FundamentalsRepo fundamentalsRepo, RepoCardGroupDetails repocardgroupdetails)
	{
		this.fundamentalsRepo=fundamentalsRepo;
		this.repocardgroupdetails=repocardgroupdetails;
	}
	
	public FundamentalsServiceimp(FundamentalsRepo fundamentalsRepo)
	{
	this.fundamentalsRepo=fundamentalsRepo;
	}
	
	
	
	public Fundamentalssetvouchercard addFundamentalssetvouchercard(Fundamentalssetvouchercard fundamentalssetvouchercard) {
		
		LocalDate localDate=LocalDate.now();
		   @SuppressWarnings("deprecation")
		   Date date=new Date(localDate.getYear()-1900, localDate.getMonthValue(), localDate.getDayOfMonth());
		fundamentalssetvouchercard.setCreatedOn(date);
		fundamentalssetvouchercard.setModifiedOn(date);
	
		return fundamentalsRepo.save(fundamentalssetvouchercard);
	}

	
	
	public void updateFundamentalssetvouchercardbyid(int card_group_set_id,Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		   Optional<Fundamentalssetvouchercard> update=fundamentalsRepo.findById( card_group_set_id);
			LocalDate localDate=LocalDate.now();
			   @SuppressWarnings("deprecation")
			   Date date=new Date(localDate.getYear()-1900, localDate.getMonthValue(), localDate.getDayOfMonth());
			
			update.get().setModifiedOn(date);
		
	if(update!=null )
		     {
		if(fundamentalsupdatevouchercard.getIsDefault().equals("Y") && fundamentalsRepo.findByCardGroupSetId(card_group_set_id).getIsDefault().equals("Y")) {}
		else{
		    	 fundamentalsupdatevouchercard.setCardGroupSetId(card_group_set_id);
		    	 fundamentalsRepo.save(fundamentalsupdatevouchercard);
		}}    
	}


	
	public List<Fundamentalssetvouchercard> getall() {
		
		return fundamentalsRepo.findAll();
	}


	
	public boolean deletebyid(int id) {
		

		Optional<Fundamentalssetvouchercard> fundamentalssetvouchercard2=fundamentalsRepo.findById(id);
		
		if(fundamentalssetvouchercard2.get().getIsDefault().equals("Y") )
		{
			return false;
		}
		else{
		fundamentalsRepo.deleteById(id);
		return true;
		}
	}


	public boolean updateByCardName(String name, Fundamentalssetvouchercard fundamentalssetvouchercard) {
		
		if(fundamentalsRepo.findByCardGroupSetName(name)!=null)
		{	Fundamentalssetvouchercard fundamentalssetvouchercard2 = fundamentalsRepo.findByCardGroupSetName(name);
	int i=0;
	LocalDate localDate=LocalDate.now();
	   @SuppressWarnings("deprecation")
	   Date date=new Date(localDate.getYear()-1900, localDate.getMonthValue(), localDate.getDayOfMonth());
	   i=fundamentalssetvouchercard2.getCardGroupSetId();
		if(fundamentalssetvouchercard2.getIsDefault().equals("Y") && fundamentalssetvouchercard.getIsDefault().equals("Y"))  return false;
		i=fundamentalssetvouchercard2.getCardGroupSetId();
			fundamentalssetvouchercard.setCardGroupSetId(i);
			fundamentalssetvouchercard.setModifiedOn(date);
			fundamentalsRepo.save(fundamentalssetvouchercard);
			return true;
		}
		else
		return false;
		
	}



public boolean deleteVoucher(String serialType,String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion) {
	
Fundamentalssetvouchercard del=fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion
(serialType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion);
	

if(del!=null)
{

int a=del.getCardGroupSetId();


if(del.getIsDefault().equals("Y"))
{
	return false;
}
else{
fundamentalsRepo.deleteById(a);
return true;
}
}
return false;

}



public List<viewvouchercardgroup> viewVersionGroup(String serialType, 
		String subService, String cardGroupSetName,
		String moduleCode, String networkCode) {


	List<Fundamentalssetvouchercard> view = fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCode
			(serialType,subService,cardGroupSetName,moduleCode,networkCode);
	
	
	
	List<viewvouchercardgroup> viewneed=new ArrayList<viewvouchercardgroup>();
	for(int i=0;i<view.size();i++)
	{
		int id=view.get(i).getCardGroupSetId();
		String ver=view.get(i).getLastVersion();
		viewvouchercardgroup v=new viewvouchercardgroup(id,ver);
		viewneed.add(v);
	}
	
	
	
	return viewneed;
	
}
public Optional<CardGroupDetails> viewrequired(String serviceType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion){
	
	Fundamentalssetvouchercard view=fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion(serviceType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion);
	
	int id=view.getCardGroupSetId();
	
System.out.println(id);
	return	repocardgroupdetails.findById(id);	
}


	
}