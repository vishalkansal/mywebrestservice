package com.project.fundamentals.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.ServiceTypeTable;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.States;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;
import com.project.fundamentals.SERVICE.FundamentalsService;

import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/RestApi")
public class FundamentalsREST<viewVersionGroug, viewVersionGrougp, SubServices, Categories> {

	@Autowired
	FundamentalsService fundamentalsService;

	public FundamentalsREST(FundamentalsService fundamentalsService) {
		this.fundamentalsService = fundamentalsService;
	}

	@RequestMapping(value = "/")
	public ModelAndView getall1() {
		ModelAndView a = new ModelAndView("MainPage");

		return a;
	}

	@RequestMapping(value = "/SetCardGroup", method = RequestMethod.POST)
	public ModelAndView geta(@ModelAttribute Fundamentalssetvouchercard fundamental) {

		//System.out.print(fundamental.getLanguage1Message());
		// System.out.println(fundamental.getLastVersion());
		ModelAndView a = new ModelAndView("index");
		fundamentalsService.addFundamentalssetvouchercard(fundamental);

		return a;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ApiOperation(value = "View Voucher Card Group Version List")
	@ResponseBody
	public List<Fundamentalssetvouchercard> getall() {
		return fundamentalsService.getall();
	}
	
	

	@RequestMapping(value = "/updatevouchercardbyid", method = RequestMethod.POST)
//	@ApiOperation(value="Update voucher card by ID")
	//@ResponseBody
    public ModelAndView updateNewFundamentalssetvouchercardbyid( @ModelAttribute Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		int id=fundamentalsupdatevouchercard.getCardGroupSetId();
		
		
			boolean ab=fundamentalsService.updateFundamentalssetvouchercardbyid(id,fundamentalsupdatevouchercard);
     if(ab==true) {
			ModelAndView a=new ModelAndView("suceessfullyadded");
         return a;
		}
		else
		{
			ModelAndView a=new ModelAndView("deletefailure");
	         return a;
		}
    }
	
	

	@RequestMapping(value = "/deleteById/{card_group_set_id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Voucher Card Group by ID")
	@ResponseBody
	public ResponseEntity<String> deletebyid(@PathVariable(value = "card_group_set_id") int id) {
		boolean a = fundamentalsService.deletebyid(id);
		if (a == true)
			return new ResponseEntity<String>("status:200 Voucher Card Group deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("DEFAULT IS Y SO NO DELETION", HttpStatus.OK);
	}

	
	
	
	
	@RequestMapping(value = "/deleteVoucherGroup", method = RequestMethod.POST)
	@ApiOperation(value = "Delete Voucher Card Group")
	@ResponseBody
	public ModelAndView deletebygivenparameters(@RequestParam("serviceType") String serviceType,
			@RequestParam("subService") String subService, @RequestParam("cardGroupSetName") String cardGroupSetName,
			@RequestParam("moduleCode") String moduleCode, @RequestParam("networkCode") String networkCode,
			@RequestParam("lastVersion") String lastVersion)

	{
		ServiceTypeTable con=fundamentalsService.getbyid(Integer.parseInt(serviceType));
		serviceType=con.getCountry();

		boolean a = fundamentalsService.deleteVoucher(serviceType, subService, cardGroupSetName, moduleCode,
				networkCode, lastVersion);
		if (a == true)

		{
			ModelAndView delete = new ModelAndView("DeletePage");
			
			return delete;
		}

		else {
			ModelAndView delete = new ModelAndView("ErrorPgae");
			return delete;
		}
		// return new ResponseEntity<String>("DEFAULT IS Y SO NO
		// DELETION",HttpStatus.OK);
	}
	
	
	
	

	@RequestMapping(value = "/updatevouchercardbyname", method = RequestMethod.POST)
	@ApiOperation(value = "Update Voucher Card By Name")
	@ResponseBody
	public ModelAndView updateNewFundamentalssetvouchercardbyname(
			@ModelAttribute Fundamentalssetvouchercard fundamentalsupdatevouchercard) {

		System.out.print(fundamentalsupdatevouchercard.getCardGroupSetName());

		String cardGroupSetName1 = fundamentalsupdatevouchercard.getCardGroupSetName();

		boolean a = fundamentalsService.updateByCardName(cardGroupSetName1, fundamentalsupdatevouchercard);

		HttpHeaders ht = new HttpHeaders();
		ht.add("status", "200");
		ht.add("msg", "Voucher Card Group updated by name successfully");

		// System.out.print(a);

		// System.out.print(fundamentalsupdatevouchercard.getIsDefault());

		if (a == true) {
			ModelAndView up = new ModelAndView("Update");
			fundamentalsService.addFundamentalssetvouchercard(fundamentalsupdatevouchercard);
			// update.addObject("cardGroupSetName",fundamentalsupdatevouchercard.());

			return up;
		} else {// return new ResponseEntity<String>("status:200 Voucher Card Group updated by
				// name successfully",ht,HttpStatus.OK); else {

			ModelAndView update = new ModelAndView("Failure");

			return update;
		}

		// return new ResponseEntity<String>("NOT FOUND",HttpStatus.OK);

	}
	
	
	
	
	

	@RequestMapping(value = "/setdefaultvouchercard", method = RequestMethod.POST)
	@ApiOperation(value = "Set Default Voucher Card Group")
	@ResponseBody
	public ResponseEntity<String> addNewFundamentalssetvouchercard(
			@RequestBody Fundamentalssetvouchercard fundamentalssetvouchercard) {

		fundamentalsService.addFundamentalssetvouchercard(fundamentalssetvouchercard);

		HttpHeaders ht = new HttpHeaders();
		ht.add("status", "200");
		ht.add("msg", "Default Voucher Card Group status set successfully");
		return new ResponseEntity<String>("status:200 Default Voucher Card Group status set successfully", ht,
				HttpStatus.OK);
	}


	@RequestMapping(value = "/viewgroupversion", method = RequestMethod.POST)
	// @ApiOperation(value="View Voucher Card Group Version List")
	public ModelAndView getversiongroup(@RequestParam("serviceType") String serialType,
			@RequestParam("subService") String subService, @RequestParam("cardGroupSetName") String cardGroupSetName, @RequestParam("moduleCode") String moduleCode, @RequestParam("networkCode") String networkCode) {

		ServiceTypeTable con=fundamentalsService.getbyid(Integer.parseInt(serialType));
		serialType=con.getCountry();
		
		//System.out.println(serialType);
		//System.out.println(subService);
		
		List<viewvouchercardgroup> a = fundamentalsService.viewVersionGroup(serialType, subService, cardGroupSetName, moduleCode, networkCode);

		
		 //System.out.print(a);
		
		
		ModelAndView profile = new ModelAndView("VIew");
		profile.addObject("ListRequired", a);
		return profile;
	}
	
	

	@RequestMapping(value = "/viewrequiredthings", method = RequestMethod.GET)
	public ModelAndView vieww()
	{
		ModelAndView a=new ModelAndView("viewrequiredthings");
		
		return a;
	}
	
	
	@RequestMapping(value = "/viewrequired", method = RequestMethod.POST)
	//@ApiOperation(value="View Voucher Card Group")
	@ResponseBody
    public ModelAndView viewrequiredParameters(@RequestParam("serviceType")String serviceType,
			@RequestParam("subService")String subService,@RequestParam("cardGroupSetName")String cardGroupSetName,
			@RequestParam("moduleCode")String moduleCode,@RequestParam("networkCode")String networkCode,@RequestParam("lastVersion")String lastVersion) {
		
		ModelAndView profile=new ModelAndView("profileview");
		
		ServiceTypeTable con=fundamentalsService.getbyid(Integer.parseInt(serviceType));
		serviceType=con.getCountry();
		
		
		CardGroupDetails view= fundamentalsService.viewrequired(serviceType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion).get();
		profile.addObject("Required", view);
        
    return profile;
	}
	
	
	
	
	@RequestMapping(value = "/Categories", method = RequestMethod.GET)
	public List<ServiceTypeTable> ServiceCategory() {

		List<ServiceTypeTable> ServiceCate = fundamentalsService.getSubServiceall();

		return ServiceCate;
	}

	/*
	 * @RequestMapping(value = "/subCategories", method = RequestMethod.GET)
	 * 
	 * public List<States> state(){
	 * 
	 * 
	 * List<Countries> ServiceCate =fundamentalsService.getSubServiceall();
	 * 
	 * List<States> ServiceCate =fundamentalsService.getstates("2");
	 * 
	 * return ServiceCate; }
	 */
	
	
	
	@RequestMapping(value = "/subCategories", method = RequestMethod.POST)
	       public  List<States> state(@RequestParam("fetch") String fetch){
	                               
	                                
		/* List<Countries> ServiceCate =fundamentalsService.getSubServiceall(); */
	                                
		List<States> ServiceCate =fundamentalsService.getstates(fetch);
		/* request.getSession().setAttribute("subCategories", ServiceCate);*/
	 
	                    
	                               
 	                                return ServiceCate;
	                }

}
