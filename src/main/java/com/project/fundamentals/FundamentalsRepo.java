package com.project.fundamentals;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
interface FundamentalsRepo extends JpaRepository<Fundamentalssetvouchercard,Integer > {

//	Fundamentalssetvouchercard findByCARD_GROUP_SET_ID(int id);
	
	Fundamentalssetvouchercard findByCardGroupSetName(String cardGroupSetName);

	List<Fundamentalssetvouchercard> findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion(String serialType, String subService,String cardGroupSetName,String moduleCode,String networkCode,String lastVersion);
	  
	Fundamentalssetvouchercard findByStatus(String status);
}
