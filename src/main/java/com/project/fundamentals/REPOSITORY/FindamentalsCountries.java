package com.project.fundamentals.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fundamentals.ENTITY.ServiceTypeTable;

@Repository
public interface FindamentalsCountries extends JpaRepository<ServiceTypeTable,Integer>{


}
