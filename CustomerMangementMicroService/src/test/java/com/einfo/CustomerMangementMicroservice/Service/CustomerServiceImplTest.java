package com.einfo.CustomerMangementMicroservice.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.einfo.CustomerMangementMicroservice.Entity.Customer;
import com.einfo.CustomerMangementMicroservice.Repository.CustomerRepository;

class CustomerServiceImplTest {

	@MockBean
	CustomerService customerService;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	Customer customer;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddNewCustomer() {
		customer=new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.AddNewCustomer(customer);
        assertEquals(customer, result);

	}

	@Test
	void testGetAllData() {
		 int page = 0;
	        int size = 5;
	        List<Customer> customers = createCustomerList();
	        Page<Customer> customerPage = new PageImpl<>(customers);
	        when(customerRepository.findAll(any(Pageable.class))).thenReturn(customerPage);

	        Page<Customer> result = customerService.GetAllData(page, size);

	        assertEquals(customerPage, result);
	}
	private List<Customer> createCustomerList() {
        List<Customer> customers = new ArrayList<>();
        return customers;
    }

	@Test
	void testGetDataById() {
		 Long id = 1L;
	     Customer customer = new Customer();
	     when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

		Optional<Customer> result = customerService.getDataById(id);

		
		assertTrue(result.isPresent());
        assertEquals(customer, result.get());
        verify(customerRepository).findById(id);
	}

	@Test
	void testDelete() {
        Long id = 1L;
        customerService.Delete(id);
		verify(customerRepository).deleteById(id);

	}

	@Test
	void testUpdate() {
		Long id = 1L;
        Customer existingCustomer = new Customer();
        existingCustomer.setId(id);
        existingCustomer.setName("Akshat");
        existingCustomer.setTier(1);

        Customer updatedCustomer = new Customer();
        updatedCustomer.setName("Divyesh");
        updatedCustomer.setTier(2);

        when(customerRepository.findById(id)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(updatedCustomer);

        Customer result = customerService.update(updatedCustomer, id);

        
        assertEquals(updatedCustomer, result);
        assertEquals("Jane Smith", result.getName());
        assertEquals("Silver", result.getTier());
        verify(customerRepository).findById(id);
        verify(customerRepository).save(existingCustomer);
	}

}
