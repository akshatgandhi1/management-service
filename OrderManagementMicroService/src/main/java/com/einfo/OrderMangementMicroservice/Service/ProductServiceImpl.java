package com.einfo.OrderMangementMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfo.OrderMangementMicroservice.Entity.Product;
import com.einfo.OrderMangementMicroservice.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product AddNewproduct(Product product) {
		return productRepository.save(product);
	}
}
