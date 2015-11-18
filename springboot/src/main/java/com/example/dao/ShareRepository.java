package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Share;

public interface ShareRepository extends JpaRepository<Share,Long>{

	public List<Share> findByName(String name);
	
	public Page<Share> findByName(String name, Pageable p);	 
}
