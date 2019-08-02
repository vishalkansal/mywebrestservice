package com.project.fundamentals;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface FundamentalsRepo extends JpaRepository<Fundamentalssetvouchercard,Integer > {
	
	Fundamentalssetvouchercard findByCardGroupSetName(String cardGroupSetName);

	List<Fundamentalssetvouchercard> findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);
	  
	Fundamentalssetvouchercard findByStatus(String status);
//@Query("SELECT last_version,CARD_GROUP_SET_ID FROM CARD_GROUP_SET WHERE service_type=serviceType AND sub_service=subService AND card_group_set_name=cardGroupSetName AND module_code=moduleCode AND network_code=networkCode")
//List<Fundamentalssetvouchercard> viewcardgroupversion(@Param("serviceType")String serviceType,@Param("subService")String subService,@Param("cardGroupSetName")String cardGroupSetName,@Param("moduleCode")String moduleCode,@Param("networkCode")String networkCode);

	List<Fundamentalssetvouchercard> findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCode(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode); 
//	List<Fundamentalssetvouchercard> getLastVersionAndCardGroupSetIdOnly();

	
//List<Fundamentalssetvouchercard> getLastVersionAndCardGroupSetNameOnly(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode); 
	
}
