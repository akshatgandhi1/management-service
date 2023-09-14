package com.einfo.OrderMangementMicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Customer {
	
	Long id;
	String name;
	Integer tier;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	
	
}
