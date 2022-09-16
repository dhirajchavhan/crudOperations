package com.example.curd.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.operation.model.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Integer>{
	
}
