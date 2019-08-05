package com.project.fundamentals.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.fundamentals.ENTITY.States;
@Repository

public interface Fundamentalstates extends JpaRepository<States,Integer> {

	//public List<states> findByCountryId(int fetch);
	 
	 
public List<States> findAll();


@Query(value="select  * from states where countryId = :id",nativeQuery = true)
public List<States> findByCountryId(String id);
}
