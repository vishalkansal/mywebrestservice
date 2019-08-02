package com.project.fundamentals.REPOSITORY;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.fundamentals.ENTITY.CardGroupDetails;

@Repository	
public interface RepoCardGroupDetails extends JpaRepository<CardGroupDetails,Integer>{
	

	
	
}
