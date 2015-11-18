package com.example.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Share implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reference;
	
	private String name;
	
	private BigDecimal price;
	
	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Share(Long reference, String name, BigDecimal price) {
		super();
		this.reference = reference;
		this.name = name;
		this.price = price;
	}
	
	public Share(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Share(){
		super();
	}
		
}