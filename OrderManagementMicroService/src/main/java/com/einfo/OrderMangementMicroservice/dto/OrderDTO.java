package com.einfo.OrderMangementMicroservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.einfo.OrderMangementMicroservice.Entity.Customer;
import com.einfo.OrderMangementMicroservice.Entity.Product;

public class OrderDTO {
	Long id;
	String status;
	Integer orderdate; 
	Integer deliverydate;
	List<Product> products;
	Customer customer;
	public OrderDTO(Long id, String status, Integer orderdate, Integer deliverydate, List<Product> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderdate = orderdate;
		this.deliverydate = deliverydate;
		this.products = products;
		this.customer = customer;
	}
	public OrderDTO() {
		super();
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
