package com.ecomweb.demo.repository;

import com.ecomweb.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
