package com.einfo.OrderMangementMicroservice.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.einfo.OrderMangementMicroservice.Entity.Product_Order;

public interface OrderService {

	Product_Order AddnewOrder(Product_Order order);

	Page<Product_Order> getAllOrder(int page, int size);

	Optional<Product_Order> findByOrderid(Long id);

	Product_Order UpdateStatus(Long id, Product_Order order);

}
