package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ShareRepository;
import com.example.entities.Share;

@RestController
public class ShareController {

	@Autowired
	private ShareRepository shareRepository;
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/save")
	public Share saveShare(Share shareToSave){
		shareRepository.save(shareToSave);
		return shareToSave;
	}
	
	@RequestMapping("/all")
	public List<Share> getShares(){
		return shareRepository.findAll();
	}
	
	public Page<Share> getShares(int page){
		return shareRepository.findAll(new PageRequest(page, 5));
	}
	
}
