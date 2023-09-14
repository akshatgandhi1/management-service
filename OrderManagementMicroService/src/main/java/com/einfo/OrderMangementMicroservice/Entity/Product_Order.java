package com.einfo.OrderMangementMicroservice.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product_Order {

	@Id
	Long id;
	String status;
	Integer orderdate; 
	Integer deliverydate;
	Long cid;
	@ManyToMany
	List<Product> product =new ArrayList<>();
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Integer orderdate) {
		this.orderdate = orderdate;
	}
	public Integer getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Integer deliverydate) {
		this.deliverydate = deliverydate;
	}
	
	
	
	
	
}
