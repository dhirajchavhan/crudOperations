package com.example.curd.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.operation.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Integer> {

}
