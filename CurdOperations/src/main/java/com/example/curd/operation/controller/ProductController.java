package com.example.curd.operation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.operation.model.ProductModel;
import com.example.curd.operation.repository.ProductRepo;

@RestController
@RequestMapping("api")
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("products")
	public ProductModel saveNewProduct(@RequestBody ProductModel productModel)
	{
		return productRepo.save(productModel);
	}
	@GetMapping("all/products")
	public List<ProductModel> getAllProducts()
	{
		return productRepo.findAll();
	}
	@GetMapping("product/id")
	public Optional<ProductModel> productById(@RequestParam("id") int id)
	{
		return productRepo.findById(id);
	}
	@PutMapping("update/id")
	public ProductModel updateProductById(@RequestParam("id") int id,@RequestParam("product") String product)
	{
	Optional<ProductModel> productModel= productRepo.findById(id);
	productModel.get().setpName(product);
	return productRepo.save(productModel.get());
		
	}
	
	@DeleteMapping("delete/id")
	public String deleteProductById(@RequestParam("id")int id)
	{
		try
		{
		productRepo.deleteById(id);
		return "Product deleted successfullyy";
		}
		catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	
	
}
