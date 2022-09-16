package com.example.curd.operation.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.operation.model.CategoryModel;
import com.example.curd.operation.repository.CategoryRepo;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo;
	
	@PostMapping("/categories")
	public CategoryModel createNewCategory(@RequestBody CategoryModel categoryModel)
	{
	return	categoryRepo.save(categoryModel);
	}
	@GetMapping("/categoriess")
	public Optional<CategoryModel> getCategoryById(@RequestParam("di") int id)
	{
		
	return categoryRepo.findById(id);
	}
	
	@GetMapping("/categories")
	public List<CategoryModel> getAllCategories()
	{
		return  categoryRepo.findAll();
	}
	
	@PutMapping("update/category")
	public CategoryModel updateCategoryById(@RequestParam("id") int id,@RequestParam("newCategory") String  Category)
	{
	Optional<CategoryModel> categoryModel=	categoryRepo.findById(id);
	categoryModel.get().setCategory(Category);
	return categoryRepo.save(categoryModel.get());
	
	}
	
	@DeleteMapping("delete/category")
	public String deleteCategoryById(@RequestParam ("id")int id)
	{
		try
		{
			categoryRepo.deleteById(id);
			return "Category deleted successfully";
		}
		catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	

}
