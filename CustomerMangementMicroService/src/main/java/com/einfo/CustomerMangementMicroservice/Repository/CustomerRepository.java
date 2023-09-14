package com.einfo.CustomerMangementMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einfo.CustomerMangementMicroservice.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
