package com.einfo.OrderMangementMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.einfo.OrderMangementMicroservice.Entity.Product_Order;

@Repository
public interface OrderRepository extends JpaRepository<Product_Order, Long>{

}
