package com.einfo.OrderMangementMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.OrderMangementMicroservice.Entity.Product;
import com.einfo.OrderMangementMicroservice.Repository.ProductRepository;
import com.einfo.OrderMangementMicroservice.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/AddProduct")
	public ResponseEntity<?> AddProduct(@RequestBody Product product){
		if(productRepository.findById(product.getId()).isEmpty() && productRepository.findByName(product.getName()).isEmpty()) {
			productService.AddNewproduct(product);
			return ResponseEntity.status(HttpStatus.OK).body("product added");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("already present");
	}
}
