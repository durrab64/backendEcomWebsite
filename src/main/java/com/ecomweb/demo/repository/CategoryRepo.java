package com.ecomweb.demo.repository;

import com.ecomweb.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
