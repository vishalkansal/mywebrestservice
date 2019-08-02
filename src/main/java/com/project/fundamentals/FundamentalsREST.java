package com.project.fundamentals;

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



@RestController
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
	@ResponseBody
    public List<Fundamentalssetvouchercard> getall()
    {
	return	fundamentalsService.getall();
     }
	
	@RequestMapping(value = "/updatevouchercardbyid/{CARD_GROUP_SET_ID}", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercardbyid(@PathVariable(value="CARD_GROUP_SET_ID") int id, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		fundamentalsService.updateFundamentalssetvouchercardbyid(id,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated successfully");
         return new ResponseEntity<String>("status:200 Voucher Card Group updated successfully",ht,HttpStatus.OK);
    }
	
	
	
	
	
	@RequestMapping(value = "/deleteById/{card_group_set_id}", method = RequestMethod.DELETE)
	@ResponseBody
    public ResponseEntity<String> deletebyid(@PathVariable(value="card_group_set_id") int id)
    {
		fundamentalsService.deletebyid(id);
		 return new ResponseEntity<String>("status:200 Voucher Card Group deleted successfully",HttpStatus.OK);
   }
	
	/*@RequestMapping(value = "/updatevouchercardbyid/{CARD_GROUP_SET_ID}", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercardbyid(@PathVariable(value="CARD_GROUP_SET_ID") int id, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		fundamentalsService.updateFundamentalssetvouchercardbyid(id,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated successfully");
         return new ResponseEntity<String>("status:200 Voucher Card Group updated successfully",ht,HttpStatus.OK);
    }
	
	
	
	*/
	
	@RequestMapping(value = "/deleteVoucherGroup", method = RequestMethod.DELETE)
	@ResponseBody
    public ResponseEntity<String> deletebyid(@RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard)
    {
		
		fundamentalsService.deleteVoucher(fundamentalsupdatevouchercard);
		
		 return new ResponseEntity<String>("status:200 Voucher Card Group deleted successfully",HttpStatus.OK);
   }
	
	
	
	@RequestMapping(value = "/updatevouchercardbyname/{cardGroupSetName}", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseEntity<String> updateNewFundamentalssetvouchercardbyname(@PathVariable(value="cardGroupSetName") String  cardGroupSetName, @RequestBody Fundamentalssetvouchercard fundamentalsupdatevouchercard) {
		
		fundamentalsService.updateByCardName(cardGroupSetName,fundamentalsupdatevouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Voucher Card Group updated by name successfully");
         return new ResponseEntity<String>("status:200 Voucher Card Group updated by name successfully",ht,HttpStatus.OK);
    }	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/setdefaultvouchercard", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<String> addNewFundamentalssetvouchercard(@RequestBody Fundamentalssetvouchercard fundamentalssetvouchercard) {
		
         fundamentalsService.addFundamentalssetvouchercard(fundamentalssetvouchercard);
     
         HttpHeaders ht=new HttpHeaders();
         ht.add("status", "200");
         ht.add("msg", "Default Voucher Card Group status set successfully");
         return new ResponseEntity<String>("status:200 Default Voucher Card Group status set successfully",ht,HttpStatus.OK);
    }
	

	@RequestMapping(value = "/viewgroupversion", method = RequestMethod.GET)
	public List<viewvouchercardgroup> getversiongroup(@RequestParam("serialType")String serialType,
			@RequestParam("subService")String subService,@RequestParam("cardGroupSetName")String cardGroupSetName,
			@RequestParam("moduleCode")String moduleCode,@RequestParam("networkCode")String networkCode)
	{
		
		
		
	
		List<Fundamentalssetvouchercard> view= fundamentalsService.viewVersionGroup(serialType,subService,cardGroupSetName,moduleCode,networkCode);
		List<viewvouchercardgroup> viewneed=new ArrayList<viewvouchercardgroup>();;
		for(int i=0;i<view.size();i++)
		{
			int id=view.get(i).getCardGroupSetId();
			String ver=view.get(i).getLastVersion();
			viewvouchercardgroup v=new viewvouchercardgroup(id,ver);
			viewneed.add(v);
		}
		
		
		return viewneed;
	}
	
	
}
