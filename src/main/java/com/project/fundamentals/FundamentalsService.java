package com.project.fundamentals;

import java.util.List;

public interface FundamentalsService {

	
	public void updateFundamentalssetvouchercardbyid(int noteid,Fundamentalssetvouchercard fundamentalsupdatevouchercard);
	
	
	public void deleteVoucher(Fundamentalssetvouchercard fundamentalssetvouchercard);
	
	public void deletebyid(int id);
	public Fundamentalssetvouchercard addFundamentalssetvouchercard(Fundamentalssetvouchercard fundamentalssetvouchercard);
	List<Fundamentalssetvouchercard> getall();
	
	List<viewvouchercardgroup> viewVersionGroup(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode);
	
	public void updateByCardName(String name, Fundamentalssetvouchercard fundamentalssetvouchercard);

}
