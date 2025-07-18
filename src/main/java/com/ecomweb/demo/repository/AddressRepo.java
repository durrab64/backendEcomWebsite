package com.ecomweb.demo.repository;

import com.ecomweb.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
