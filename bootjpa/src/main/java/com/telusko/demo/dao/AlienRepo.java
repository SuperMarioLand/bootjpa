package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>
{
//	List<Alien> findByTech(String tech);
//
//	List<Alien> findByAidGreaterThan(int i);
//	
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien> findByTechSorted(String tech);
}
