package com.project.fundamentals.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.ServiceTypeTable;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.States;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;

@Service
public interface FundamentalsService {

	
	public boolean updateFundamentalssetvouchercardbyid(int noteid,Fundamentalssetvouchercard fundamentalsupdatevouchercard);
	
	
	public boolean deleteVoucher(String serialType,String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);
	
	public boolean deletebyid(int id);
	public Fundamentalssetvouchercard addFundamentalssetvouchercard(Fundamentalssetvouchercard fundamentalssetvouchercard);
	List<Fundamentalssetvouchercard> getall();
	
	List<ServiceTypeTable> getSubServiceall();
	public ServiceTypeTable getbyid(int id);
	
	/*
	 * List<viewvouchercardgroup> viewVersionGroup(String serialType, String
	 * subService,String cardGroupSetName, String moduleCode, String networkCode);
	 */
	public boolean updateByCardName(String name, Fundamentalssetvouchercard fundamentalssetvouchercard);

	Optional<CardGroupDetails> viewrequired(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);


	public List<States> getstates(String fetch);


	public List<viewvouchercardgroup> viewVersionGroup(String serialType, String subService, String cardGroupSetName,
			String moduleCode, String networkCode);
	
	
	
}
