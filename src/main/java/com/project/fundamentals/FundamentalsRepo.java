package com.project.fundamentals;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
interface FundamentalsRepo extends JpaRepository<Fundamentalssetvouchercard,Integer > {

//	Fundamentalssetvouchercard findByCARD_GROUP_SET_ID(int id);
//	Fundamentalssetvouchercard findByCard_group_set_name(String card_group_set_name);

	Fundamentalssetvouchercard findByStatus(String status);
}
