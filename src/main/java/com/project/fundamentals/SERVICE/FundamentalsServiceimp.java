package com.project.fundamentals.SERVICE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.ServiceTypeTable;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.States;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;
import com.project.fundamentals.REPOSITORY.*;






@Service
public class FundamentalsServiceimp implements FundamentalsService{


	private FundamentalsRepo fundamentalsRepo;
	
	RepoCardGroupDetails repocardgroupdetails;
	
	
	@Autowired
	FindamentalsCountries fundamentalscountries;
	@Autowired
	Fundamentalstates fundamentalstates;
	
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

	
	
	public boolean updateFundamentalssetvouchercardbyid(int card_group_set_id,Fundamentalssetvouchercard fundamentalsupdatevouchercard) {

		   Optional<Fundamentalssetvouchercard> update=fundamentalsRepo.findById( card_group_set_id);
			LocalDate localDate=LocalDate.now();
			   @SuppressWarnings("deprecation")
			   Date date=new Date(localDate.getYear()-1900, localDate.getMonthValue(), localDate.getDayOfMonth());
			
			update.get().setModifiedOn(date);
		
	if(update!=null )
		     {
		
		if(fundamentalsupdatevouchercard.getLanguage1Message() ==null ||fundamentalsupdatevouchercard.getLanguage2Mmessage() ==null ) return false;
		   if(update.get().getIsDefault()!=null)
			if(update.get().getIsDefault().equals("Y") && fundamentalsupdatevouchercard.getIsDefault().equals("Y"))  return false;
			
			fundamentalsupdatevouchercard.setCardGroupSetId(card_group_set_id);
			fundamentalsupdatevouchercard.setCreatedOn(update.get().getCreatedOn());
			fundamentalsupdatevouchercard.setCreatedBy(update.get().getCreatedBy());
			fundamentalsupdatevouchercard.setModifiedOn(date);
				fundamentalsRepo.save(fundamentalsupdatevouchercard);
		return true;	
		
		
		
		}    
	return false;
	
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
		
		System.out.print(fundamentalsRepo.findByCardGroupSetName(name));
		
		if(fundamentalsRepo.findByCardGroupSetName(name)!=null)
		{	
			//System.out.print("inside the if");
			Fundamentalssetvouchercard fundamentalssetvouchercard2 = fundamentalsRepo.findByCardGroupSetName(name);
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
		String subService, String cardGroupSetName ,String moduleCode, String networkCode) {


	List<Fundamentalssetvouchercard> view = fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCode
			(serialType,subService,cardGroupSetName, moduleCode, networkCode);
	
	
	
	List<viewvouchercardgroup> viewneed=new ArrayList<viewvouchercardgroup>();
	for(int i=0;i<view.size();i++)
	{
		int id=view.get(i).getCardGroupSetId();
		String ver=view.get(i).getLastVersion();
		viewvouchercardgroup v=new viewvouchercardgroup(id,ver);
		viewneed.add(v);
		
		System.out.print(id);
		
		System.out.print(ver);
	}
	
	System.out.print(viewneed);
	
	return viewneed;
	
}





public Optional<CardGroupDetails> viewrequired(String serviceType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion){
	
	Fundamentalssetvouchercard view=fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion(serviceType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion);
	
	int id=view.getCardGroupSetId();
	
System.out.println(id);
	return	repocardgroupdetails.findById(id);	
}

@Override
public List<ServiceTypeTable> getSubServiceall() {
	
	
	 return fundamentalscountries.findAll();
}

public List<States> getstates(String id){
	
	return fundamentalstates.findByCountryId(id);
}

public ServiceTypeTable getbyid(int id)
{
	return fundamentalscountries.findById(id).get();
}
/*public List<States> getstates() {
	// TODO Auto-generated method stub
	return null;
}*/
	
}