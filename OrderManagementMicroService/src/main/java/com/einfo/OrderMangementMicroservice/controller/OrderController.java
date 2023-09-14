package com.einfo.OrderMangementMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.einfo.OrderMangementMicroservice.Entity.Customer;
import com.einfo.OrderMangementMicroservice.Entity.Product_Order;
import com.einfo.OrderMangementMicroservice.Repository.OrderRepository;
import com.einfo.OrderMangementMicroservice.Repository.ProductRepository;
import com.einfo.OrderMangementMicroservice.Service.OrderService;
import com.einfo.OrderMangementMicroservice.dto.OrderDTO;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired 
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/AddNewOrder")
	public ResponseEntity<?> AddNewOrder(@RequestBody Product_Order order){
		if(orderRepository.findById(order.getId()).isEmpty()) {
			orderService.AddnewOrder(order);
			return ResponseEntity.status(HttpStatus.OK).body("order successfully");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("order id present already");
	}
	
	@GetMapping("/Getorders")
	public ResponseEntity<?> getProduct(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
		Page<Product_Order> order=orderService.getAllOrder(page,size);
//		List customer=restTemplate.getForObject("http://CUSTOMERMANAGEMET/getAllData",List.class);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@GetMapping("/GetOrder/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long id){
		Product_Order order=orderService.findByOrderid(id).get();
		
		Customer customer=restTemplate.getForObject("http://CUSTOMERMANAGEMET/getData/"+order.getCid(), Customer.class);
				
		OrderDTO orderDTO = new OrderDTO(order.getId(), order.getStatus(), order.getOrderdate(), order.getDeliverydate(), order.getProduct(), customer);
		
		return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
	}
	
	@PutMapping("/UpdateStatus/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable Long id,@RequestBody Product_Order order){
		orderService.UpdateStatus(id,order);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}
}
