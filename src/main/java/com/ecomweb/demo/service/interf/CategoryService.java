package com.ecomweb.demo.service.interf;

import com.ecomweb.demo.dto.CategoryDto;
import com.ecomweb.demo.dto.Response;

public interface CategoryService {

    Response createCategory(CategoryDto categoryRequest);
    Response updateCategory(Long categoryId, CategoryDto categoryRequest);
    Response getAllCategories();  // Updated method name
    Response getCategoryById(Long categoryId);
    Response deleteCategory(Long categoryId);
}
