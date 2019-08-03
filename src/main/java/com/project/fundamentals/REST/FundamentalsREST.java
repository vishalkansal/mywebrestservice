package com.project.fundamentals.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.fundamentals.ENTITY.CardGroupDetails;
import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;
import com.project.fundamentals.ENTITY.viewvouchercardgroup;
import com.project.fundamentals.SERVICE.FundamentalsService;

import io.swagger.annotations.ApiOperation;





@RestController
@RequestMapping("/RestApi")
public class FundamentalsREST {

	@Autowired
	FundamentalsService fundamentalsService;
	
	public FundamentalsREST(FundamentalsService fundamentalsService)	
	{
		this.fundamentalsService=fundamentalsService;
	}
	
	
	/*@RequestMapping(value = "/updatevouchercard/{CARD_GROUP_SET_Name}", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercard(@PathVariable(value="CARD_GROUP_SET_Name") String CARD_GROUP_SET_NAME, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
	//	fundamentalsService.updateFundamentalssetvouchercard(CARD_GROUP_SET_NAME,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated successfully");
         return new ResponseEntity<String>("status:200 Voucher Card Group updated successfully",ht,HttpStatus.OK);
    }
	
	*/
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ApiOperation(value="View Voucher Card Group Version List")
	@ResponseBody
    public List<Fundamentalssetvouchercard> getall()
    {
	return	fundamentalsService.getall();
     }
	
	@RequestMapping(value = "/updatevouchercardbyid/{CARD_GROUP_SET_ID}", method = RequestMethod.PUT)
	@ApiOperation(value="Update voucher card by ID")
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercardbyid(@PathVariable(value="CARD_GROUP_SET_ID") int id, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		fundamentalsService.updateFundamentalssetvouchercardbyid(id,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated successfully");
         return new ResponseEntity<String>("status:200 Voucher Card Group updated successfully",ht,HttpStatus.OK);
    }
	
	
	
	
	
	@RequestMapping(value = "/deleteById/{card_group_set_id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Delete Voucher Card Group by ID")
	@ResponseBody
    public ResponseEntity<String> deletebyid(@PathVariable(value="card_group_set_id") int id)
    {
	boolean a=	fundamentalsService.deletebyid(id);
	if(a==true)
		 return new ResponseEntity<String>("status:200 Voucher Card Group deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("DEFAULT IS Y SO NO DELETION",HttpStatus.OK);
   }
	
	
	@RequestMapping(value = "/deleteVoucherGroup", method = RequestMethod.DELETE)
	@ApiOperation(value="Delete Voucher Card Group")
	@ResponseBody
    public ResponseEntity<String> deletebygivenparameters(@RequestParam("serviceType")String serviceType,
			@RequestParam("subService")String subService,@RequestParam("cardGroupSetName")String cardGroupSetName,
			@RequestParam("moduleCode")String moduleCode,@RequestParam("networkCode")String networkCode,@RequestParam("lastVersion")String lastVersion)
    {
		
	boolean a=	fundamentalsService.deleteVoucher(serviceType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion);
		if(a==true)
		 return new ResponseEntity<String>("status:200 Voucher Card Group deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("DEFAULT IS Y SO NO DELETION",HttpStatus.OK);
    }
	
	
	
	@RequestMapping(value = "/updatevouchercardbyname/{cardGroupSetName}", method = RequestMethod.PUT)
	@ApiOperation(value="Update Voucher Card By Name")
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercardbyname(@PathVariable(value="cardGroupSetName") String  cardGroupSetName, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		boolean a=fundamentalsService.updateByCardName(cardGroupSetName,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated by name successfully");
         if(a==true)
         return new ResponseEntity<String>("status:200 Voucher Card Group updated by name successfully",ht,HttpStatus.OK);
         else
        	 return new ResponseEntity<String>("NOT FOUND",HttpStatus.OK);
         	 
	}	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/setdefaultvouchercard", method = RequestMethod.POST)
	@ApiOperation(value="Set Default Voucher Card Group")
	@ResponseBody
    public ResponseEntity<String> addNewFundamentalssetvouchercard(@RequestBody Fundamentalssetvouchercard fundamentalssetvouchercard) {
		
         fundamentalsService.addFundamentalssetvouchercard(fundamentalssetvouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Default Voucher Card Group status set successfully");
         return new ResponseEntity<String>("status:200 Default Voucher Card Group status set successfully",ht,HttpStatus.OK);
    }
	

	@RequestMapping(value = "/viewgroupversion", method = RequestMethod.GET)
	@ApiOperation(value="View Voucher Card Group Version List")
	public List<viewvouchercardgroup> getversiongroup(@RequestParam("serviceType")String serialType,
			@RequestParam("subService")String subService,@RequestParam("cardGroupSetName")String cardGroupSetName,
			@RequestParam("moduleCode")String moduleCode,@RequestParam("networkCode")String networkCode)
	{
		
		return fundamentalsService.viewVersionGroup(serialType,subService,cardGroupSetName,moduleCode,networkCode);

	}
	
	@RequestMapping(value = "/viewrequired", method = RequestMethod.GET)
	@ApiOperation(value="View Voucher Card Group")
	@ResponseBody
    public Optional<CardGroupDetails> viewrequiredParameters(@RequestParam("serviceType")String serviceType,
			@RequestParam("subService")String subService,@RequestParam("cardGroupSetName")String cardGroupSetName,
			@RequestParam("moduleCode")String moduleCode,@RequestParam("networkCode")String networkCode,@RequestParam("lastVersion")String lastVersion) {
		
		return fundamentalsService.viewrequired(serviceType,subService,cardGroupSetName,moduleCode,networkCode,lastVersion);
     
        // HttpHeaders ht=new HttpHeaders();
        // ht.add("status", "200");
        // ht.add("msg", "Default Voucher Card Group status set successfully");
        // return new ResponseEntity<String>("status:200 Default Voucher Card Group status set successfully",ht,HttpStatus.OK);
    }
	
	
	
}
