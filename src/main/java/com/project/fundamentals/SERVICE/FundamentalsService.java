package com.project.fundamentals.SERVICE;

import java.util.List;
import java.util.Optional;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;


public interface FundamentalsService {

	
	public void updateFundamentalssetvouchercardbyid(int noteid,Fundamentalssetvouchercard fundamentalsupdatevouchercard);
	
	
	public boolean deleteVoucher(String serialType,String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);
	
	public boolean deletebyid(int id);
	public Fundamentalssetvouchercard addFundamentalssetvouchercard(Fundamentalssetvouchercard fundamentalssetvouchercard);
	List<Fundamentalssetvouchercard> getall();
	
	List<viewvouchercardgroup> viewVersionGroup(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode);
	
	public boolean updateByCardName(String name, Fundamentalssetvouchercard fundamentalssetvouchercard);

	Optional<CardGroupDetails> viewrequired(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);
}
