package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StockRepository;
import com.example.entities.Stock;

@RestController
public class StockController {

	@Autowired
	private StockRepository stockRepository;
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/save")
	public Stock saveStock(Stock shareToSave){
		stockRepository.save(shareToSave);
		return shareToSave;
	}
	
	@RequestMapping("/all")
	public List<Stock> getStock(){
		return stockRepository.findAll();
	}
	
	@RequestMapping("stocks")
	public Page<Stock> getStock(int page){
		return stockRepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("stocksByKeywordPerso")
	public Page<Stock> getStocksByKeyword(String kw, int page){
		return stockRepository.findStocksByKey("%" + kw + "%", new PageRequest(page, 5));
	}
	
	@RequestMapping("stocksByKeyword")
	public Page<Stock> getStocksByKeywordLike(String kw, int page){
		return stockRepository.findStocksByNameContaining(kw, new PageRequest(page, 5));
	}
	
}
