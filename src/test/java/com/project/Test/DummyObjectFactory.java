package com.project.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;

public class DummyObjectFactory {
	
	public static List<viewvouchercardgroup> getDummyviewvouchercardgroup()
	{
		List<viewvouchercardgroup> viewvouchercardlist=new ArrayList<>(2);
		for(int i=0;i<2;i++)
		{
			viewvouchercardgroup view=new viewvouchercardgroup();
			view.setCardGroupSetId(1+i);
			view.setLastVersion("asd"+i);
			viewvouchercardlist.add(view);
		}
		
		return viewvouchercardlist;
	}

	
	public static List<Fundamentalssetvouchercard> getDummyfundamentalsSetVoucherCard()
	{
		List<Fundamentalssetvouchercard> setvouchercardlist=new ArrayList<>(2);
		for(int i=0;i<2;i++)
		{
			Fundamentalssetvouchercard view=new Fundamentalssetvouchercard();
			view.setCardGroupSetId(1+i);
			view.setCardGroupSetName("asd1");
			view.setCreatedBy("SYSTEM"+i);
		//	view.setCreatedOn(L);
			view.setIsDefault("N");
			view.setLanguage1Message("english"+i);
			view.setLanguage2Mmessage("English"+i);
			view.setLastVersion("asd"+i);
			view.setModifiedBy("SYSTEM"+i);
		//	view.setModifiedOn("SYSTEM"+i);
			view.setModuleCode("mc"+1);
			view.setNetworkCode("1");
			view.setServiceType("st"+1);
			view.setSetType("type"+i);
			view.setStatus("y");
			view.setSubService("ss1");
			
			setvouchercardlist.add(view);
			
			
			
		}
		
		return setvouchercardlist;
	}
	}
