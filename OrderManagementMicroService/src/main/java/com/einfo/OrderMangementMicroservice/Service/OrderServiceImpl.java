package com.einfo.OrderMangementMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.einfo.OrderMangementMicroservice.Entity.Customer;
import com.einfo.OrderMangementMicroservice.Entity.Product_Order;
import com.einfo.OrderMangementMicroservice.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Product_Order AddnewOrder(Product_Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Page<Product_Order> getAllOrder(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return orderRepository.findAll(pageable);
	}

	@Override
	public Optional<Product_Order> findByOrderid(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public Product_Order UpdateStatus(Long id, Product_Order order) {
		
		return orderRepository.save(order);
	}
}
