package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{

	public List<Stock> findByName(String name);
	
	public Page<Stock> findByName(String name, Pageable p);	 
	
	@Query("select s from Stock s where s.name like :x")
	public Page<Stock> findStocksByKey(@Param("x")String key, Pageable p);
}
