package com.ecomweb.demo.service.impl;

import com.ecomweb.demo.dto.CategoryDto;
import com.ecomweb.demo.dto.Response;
import com.ecomweb.demo.entity.Category;
import com.ecomweb.demo.exception.NotFoundException;
import com.ecomweb.demo.mapper.EntityDtoMapper;
import com.ecomweb.demo.repository.CategoryRepo;
import com.ecomweb.demo.service.interf.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final EntityDtoMapper entityDtoMapper;

    @Override
    public Response createCategory(CategoryDto categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());  // Fixed: Use categoryRequest.getName() instead of category.getName()
        categoryRepo.save(category);
        return Response.builder()
                .status(200)
                .message("Category Created Successfully")
                .build();
    }

    @Override
    public Response updateCategory(Long categoryId, CategoryDto categoryRequest) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Not Found"));
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return Response.builder()
                .status(200)
                .message("Category updated Successfully")
                .build();
    }

    @Override
    public Response getAllCategories() {  // Updated method name
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream()
                .map(entityDtoMapper::mapCategoryToDtoBasic)
                .collect(Collectors.toList());
        return Response.builder()
                .status(200)
                .categoryList(categoryDtoList)
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Not Found"));
        CategoryDto categoryDto = entityDtoMapper.mapCategoryToDtoBasic(category);
        return Response.builder()
                .status(200)
                .category(categoryDto)
                .build();
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Not Found"));
        categoryRepo.delete(category);
        return Response.builder()
                .status(200)
                .message("Category was Successfully Deleted")
                .build();
    }
}
