package com.einfo.CustomerMangementMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.einfo.CustomerMangementMicroservice.Entity.Customer;
import com.einfo.CustomerMangementMicroservice.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Customer AddNewCustomer(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

	@Override
	public Page<Customer> GetAllData(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return customerRepository.findAll(pageable);
	}

	@Override
	public Optional<Customer> getDataById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public void Delete(Long id) {
		 customerRepository.deleteById(id);
	}

	@Override
	public Customer update(Customer customer, Long id) {
		Customer update=customerRepository.findById(id).get();
		update.setName(customer.getName());
		update.setTier(customer.getTier());
		return customerRepository.save(update);
	}
	

}
