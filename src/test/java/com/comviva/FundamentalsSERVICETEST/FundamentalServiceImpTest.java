package com.comviva.FundamentalsSERVICETEST;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.Mockito.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
//import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.mockito.Mockito.*;

import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;
import com.project.fundamentals.REPOSITORY.FundamentalsRepo;
import com.project.fundamentals.REPOSITORY.RepoCardGroupDetails;
import com.project.fundamentals.SERVICE.FundamentalsService;
import com.project.fundamentals.SERVICE.FundamentalsServiceimp;
import static com.project.Test.DummyObjectFactory.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FundamentalServiceImpTest {

	@Mock
    private FundamentalsRepo fundamentalsRepo;
	@Mock
	RepoCardGroupDetails repocardgroupdetails;
	
	@InjectMocks
	FundamentalsService fundamentalService = new FundamentalsServiceimp(fundamentalsRepo,repocardgroupdetails); 
	
	@Test
	public void test_viewVersionGroup()
	{
		
		List<viewvouchercardgroup> viewvouchercardgrouplist= getDummyviewvouchercardgroup();
		List<Fundamentalssetvouchercard> fundamentalssetvouchercardlist = getDummyfundamentalsSetVoucherCard();
		
		String serialType ="st1";
		String subService ="ss1";
		String cardGroupSetName="asd1";
		String moduleCode = "mc1";
		String networkCode ="nc1";
		
		when(fundamentalsRepo.findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCode(serialType,subService,cardGroupSetName,moduleCode,networkCode)).thenReturn(fundamentalssetvouchercardlist);
		List<viewvouchercardgroup> resultlist = fundamentalService.viewVersionGroup(serialType, subService, cardGroupSetName, moduleCode, networkCode);
	   
		
		viewvouchercardgroup viewvouchercardgroup1=viewvouchercardgrouplist.get(0);
		viewvouchercardgroup viewvouchercardgroup2=resultlist.get(0);
		
		assertThat(viewvouchercardgroup1.getLastVersion()).isEqualTo(viewvouchercardgroup2.getLastVersion());
		assertThat(viewvouchercardgroup1.getCardGroupSetId()).isEqualTo(viewvouchercardgroup2.getCardGroupSetId());
	
		viewvouchercardgroup viewvouchercardgroup3=viewvouchercardgrouplist.get(1);
		viewvouchercardgroup viewvouchercardgroup4=resultlist.get(1);
		
		assertThat(viewvouchercardgroup3.getLastVersion()).isEqualTo(viewvouchercardgroup4.getLastVersion());
		assertThat(viewvouchercardgroup3.getCardGroupSetId()).isEqualTo(viewvouchercardgroup4.getCardGroupSetId());
		
		
	}
	
	
	@Test
	public void createSetDefaultVoucher_pass(){
		
		List<Fundamentalssetvouchercard> check = getDummyfundamentalsSetVoucherCard();
		
		Fundamentalssetvouchercard check1=check.get(0);
		LocalDate localDate=LocalDate.now();
		   @SuppressWarnings("deprecation")
		   Date date=new Date(localDate.getYear()-1900, localDate.getMonthValue(), localDate.getDayOfMonth());
		check1.setCreatedOn(date);
		check1.setModifiedOn(date);
		when(fundamentalsRepo.save(check1)).thenReturn(check1);
		Fundamentalssetvouchercard result= fundamentalService.addFundamentalssetvouchercard(check1);
		assertThat(result.getCardGroupSetId()).isEqualTo(check1.getCardGroupSetId());
		assertThat(result.getCardGroupSetName()).isEqualTo(check1.getCardGroupSetName());
		assertThat(result.getCreatedBy()).isEqualTo(check1.getCreatedBy());
		assertThat(result.getLanguage1Message()).isEqualTo(check1.getLanguage1Message());
		assertThat(result.getLanguage2Mmessage()).isEqualTo(check1.getLanguage2Mmessage());
		assertThat(result.getLastVersion()).isEqualTo(check1.getLastVersion());
		assertThat(result.getIsDefault()).isEqualTo(check1.getIsDefault());
		assertThat(result.getModuleCode()).isEqualTo(check1.getModuleCode());
		assertThat(result.getNetworkCode()).isEqualTo(check1.getNetworkCode());
		assertThat(result.getServiceType()).isEqualTo(check1.getServiceType());
		assertThat(result.getSetType()).isEqualTo(check1.getSetType());
		assertThat(result.getStatus()).isEqualTo(check1.getStatus());
		assertThat(result.getSubService()).isEqualTo(check1.getSubService());
	}
	
	@Test
	public void updatevoucher_pass()
	{
	List<Fundamentalssetvouchercard> check = getDummyfundamentalsSetVoucherCard();
		
		Fundamentalssetvouchercard check1=check.get(0);
		LocalDate localDate=LocalDate.now();
		
	
	//	when(fundamentalsRepo.save(check1)).thenReturn(check1);
		boolean result= fundamentalService.updateByCardName(check1.getCardGroupSetName(),check1);
		assertThat(result).isFalse();
	
	}
	@Test
	public void updatevoucher_fail()
	{
	List<Fundamentalssetvouchercard> check = getDummyfundamentalsSetVoucherCard();
		
		Fundamentalssetvouchercard check1=check.get(0);
	
		check1.setCardGroupSetId(0);
		boolean result= fundamentalService.updateByCardName(check1.getCardGroupSetName(),check1);
		assertThat(result).isFalse();
	}
	
	
	
	@Test
	public void deletevoucher()
	{
	List<Fundamentalssetvouchercard> check = getDummyfundamentalsSetVoucherCard();
		
		Fundamentalssetvouchercard check1=check.get(0);
		check1.setIsDefault("Y");
		boolean result= fundamentalService.deleteVoucher(check1.getServiceType(),check1.getSubService(),
	    		  check1.getCardGroupSetName(),check1.getModuleCode(),check1.getNetworkCode(),check1.getLastVersion());
		

		System.out.print(check1.getIsDefault());
		assertThat(result).isEqualTo(false);
	}
	
	
	
	
	
	
	
	
	
}
