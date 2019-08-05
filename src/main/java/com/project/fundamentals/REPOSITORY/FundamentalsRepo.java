package com.project.fundamentals.REPOSITORY;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fundamentals.ENTITY.Fundamentalssetvouchercard;

@Repository
public interface FundamentalsRepo extends JpaRepository<Fundamentalssetvouchercard,Integer > {
	
	Fundamentalssetvouchercard findByCardGroupSetName(String cardGroupSetName);
	Fundamentalssetvouchercard findByCardGroupSetId(int cardGroupSetName);
	Fundamentalssetvouchercard findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCodeAndLastVersion(String serialType, String subService,String cardGroupSetName, String moduleCode, String networkCode, String lastVersion);
	  
	Fundamentalssetvouchercard findByStatus(String status);

	List<Fundamentalssetvouchercard> findByServiceTypeAndSubServiceAndCardGroupSetNameAndModuleCodeAndNetworkCode(String serialType, String subService,String cardGroupSetName, String moduleCode, String networkCode); 
	
}
