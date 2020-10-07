package com.smi.allone.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.bean.CategoryPro;
import com.smi.allone.domain.Category;
import com.smi.allone.domain.Product;
import com.smi.allone.repository.CategoryRepository;
import com.smi.allone.repository.ProductRepository;
import com.smi.allone.service.ServiceDB;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ServiceDB serviceDb;

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
	public String addProduct(@RequestBody CategoryPro catPro) {
		System.out.println("7777777777777777777"+catPro.getCid());
		System.out.println("8888888888888888888"+catPro.getStockLevel());
//		Role roles = new Role();
//		roles.setRoleName("USER")
//		Set<Role> s = new HashSet<Role>();
//		s.add(roles);
//		user.setRoles(s);
//		userRepo.save(user);
		
		Product product = new Product();
		product.setProductName(catPro.getProductName());
		product.setBrand(catPro.getBrand());
		product.setSize(catPro.getSize());
		product.setColor(catPro.getColor());
		product.setWarranty(catPro.getWarranty());
		product.setPrice(catPro.getPrice());
		product.setDescription(catPro.getDescription());
		product.setStockLevel(catPro.getStockLevel());
		product.setStockSold("0");
		
		
		
		Category cate = new Category();
		cate.setId(catPro.getCid());
		Set<Category> s = new HashSet<Category>();
		s.add(cate);
		product.setCategory(s);
		productRepository.save(product);
		
		return "Done";
		
		
	}
	
//	get product by ID
	@RequestMapping( value="/getproductbyid/{id}" , produces = "application/json")
	public Product getProductById(@PathVariable Integer id) {
		System.out.println(productRepository.findById(id).get());
		return productRepository.findById(id).get(); 
	}
	
//	update products 
	@PutMapping(value = "/updateproducts/{id}", produces = "application/json")
	public String updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
		
		Product product = productRepository.findById(id).get();
		
		product.setProductName(productDetails.getProductName());
		product.setBrand(productDetails.getBrand());
		product.setSize(productDetails.getSize());
		product.setColor(productDetails.getColor());
		product.setWarranty(productDetails.getWarranty());
		product.setPrice(productDetails.getPrice());
		product.setDescription(productDetails.getDescription());
		product.setStockLevel(productDetails.getStockLevel());
		product.setStockSold(productDetails.getStockSold());
		
		productRepository.save(product);
		return "UPDAATED";
	}
	
//	delete products
	@DeleteMapping("/deleteproducts/{id}")
	public String deleteProduct(@PathVariable(value = "id") Integer id) {
//		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this"));
		productRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	
//	Add Category
	@RequestMapping(value = "/addcategory" , method = RequestMethod.POST)
	public String addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
		return "Category Added Successfully";
	}
}
