package com.einfo.CustomerMangementMicroservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.CustomerMangementMicroservice.Entity.Customer;
import com.einfo.CustomerMangementMicroservice.Repository.CustomerRepository;
import com.einfo.CustomerMangementMicroservice.Service.CustomerService;

@RestController()

public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/AddCustomer")
	public ResponseEntity<?> AddNewCustomer(@RequestBody Customer newCustomer){
		if(customerRepository.findById(newCustomer.getId()).isPresent() ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Already registered");
		}
		else {
			customerService.AddNewCustomer(newCustomer);
			return ResponseEntity.status(HttpStatus.OK).body("new customer added");
		}		
	}
	
	@GetMapping("/getAllData")
	public ResponseEntity<?> GetAllData(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "5") int size){
		Page<Customer> customer=customerService.GetAllData(page,size);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	@GetMapping("/getData/{id}")
	public ResponseEntity<?> getDataByID(@PathVariable Long id){
		Customer customer=customerService.getDataById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(customer);		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteItem(@PathVariable Long id){
		customerService.Delete(id);
		 return ResponseEntity.status(HttpStatus.OK).body("deleted");
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<?> UpdateItem(@RequestBody Customer customer,@PathVariable Long id){
		customerService.update(customer,id);
		return ResponseEntity.status(HttpStatus.OK).body("update Successfully");
		
	}
}
