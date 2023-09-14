package com.einfo.CustomerMangementMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.einfo.CustomerMangementMicroservice.Entity.Customer;

public interface CustomerService {

	Customer AddNewCustomer(Customer newCustomer);

	Page<Customer> GetAllData(int page, int size);

	Optional<Customer>  getDataById(Long id);

	void Delete(Long id);

	Customer update(Customer customer, Long id);

}
