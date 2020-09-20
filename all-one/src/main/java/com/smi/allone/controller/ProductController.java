package com.smi.allone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.domain.Category;
import com.smi.allone.domain.Product;
import com.smi.allone.repository.CategoryRepository;
import com.smi.allone.repository.ProductRepository;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

//	get all products
	
	@RequestMapping("/getproducts")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
//	Get Category
	@RequestMapping("/getcategory")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
//	Add products 
	@RequestMapping(value = "/addproducts" , method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product Added Successfully";
	}
	
//	Add Category
	@RequestMapping(value = "/addcategory" , method = RequestMethod.POST)
	public String addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
		return "Category Added Successfully";
	}
}
