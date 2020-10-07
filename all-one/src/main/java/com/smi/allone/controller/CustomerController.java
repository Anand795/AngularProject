package com.smi.allone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.bean.CartPro;
import com.smi.allone.domain.Address;
import com.smi.allone.domain.Cart;
import com.smi.allone.domain.Category;
import com.smi.allone.domain.Product;
import com.smi.allone.repository.AddressRepository;
import com.smi.allone.repository.CartRepository;
import com.smi.allone.repository.ProductRepository;
import com.smi.allone.service.ServiceDB;

@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired 
	private AddressRepository addressRepository;

	@Autowired
	private ServiceDB ser;

	@RequestMapping(value = "/addtocart/{id}")
	public String addToCart(@PathVariable int id, @RequestBody int pid) {

		Cart cart = new Cart();
		List<Cart> cart1 = cartRepository.findByProductUserId(id, pid);
		int size = cart1.size();
		System.out.println(cart1);
		int qty = 0;
		if (size > 0) {
			for (Cart c : cart1) {
				qty = c.getQuantity();
			}
			qty++;
			if (cartRepository.upadteQty(id, pid, qty) >= 1) {
				return "Product Updated";
			} else {
				return "Product Failed to update";
			}

		} 
		else {
			if (ser.addToCart(id, pid) != null) {
				return "Product added";
			} else {
				return "Product Failed to Add";
			}
		}

	}

//	to display products in cart session 
	@RequestMapping(value = "/getCartBasedOnUser/{id}", produces = "application/json")
	public List<Product> getCartByUser(@PathVariable Integer id) {
		List<Integer> l = cartRepository.getProductId(id);
		Product product = new Product();
		List<Product> productList = new ArrayList<Product>();
		for (Integer p : l) {
			product = productRepository.findById(p).get();
			productList.add(product);
		}
		return productList;

	}

//	test//	to display products in cart session 
//	@RequestMapping(value = "/getCartBasedOnUserTEST/{id}", produces = "application/json")
//	public List<Product> getCartByUserTest(@PathVariable Integer id) {
//		List<Integer> l = cartRepository.getProductId(id);
//		Product product = new Product();
//		List<Product> productList = new ArrayList<Product>();
//		for (Integer p : l) {
//			product = productRepository.findById(p).get();
//			productList.add(product);
//		}
//
//		Cart car = new Cart();
////		Product p = new Product();
//		List<Integer> l1 = cartRepository.getCartId(id);
//		List<Cart> cartList = new ArrayList<Cart>();
//		for (Integer p2 : l1) {
//			car = cartRepository.findById(p2).get();
//			cartList.add(car);
//		}
//		CartPro cap = new CartPro();
//		System.out.println("cart List--------- " + cartList);
//		System.out.println("product list ------------" + productList);
////		ser.setValueCartPro(productList , cartList);
//		return productList;
//	}
//	
	
//	get Product Quantity
	@RequestMapping(value = "/getQuantity/{id}", produces = "application/json")
	public List<Integer> getQuantity(@PathVariable Integer id) {
		List<Integer> list = cartRepository.getQuantity(id);
		Cart cart = new Cart();
		for(int c : list) {
			cart.setQuantity(c);
		}
		return list;
	}

//	get badge
	@RequestMapping(value = "/getBadge/{id}", produces = "application/json")
	public int getBadge(@PathVariable Integer id) {
		List<Integer> l = cartRepository.getProductId(id);
		int badgeValue = l.size();
		return badgeValue;
	}

//	to delete product from the cart 
	@GetMapping("/deleteCartProduct/{id}")
	public String deleteCartPro(@PathVariable Integer id) {
		cartRepository.deleteByProductId(id);
		return "Product Deleted";
	}
	
//	return address
	@RequestMapping(value = "/getaddress/{id}", produces = "application/json")
	public List<Address> getAddress(@PathVariable String id) {
		return addressRepository.findByUserId(id);
	}
	
//	Add new Address 
	@RequestMapping(value = "/addAddress/{id}",method = RequestMethod.POST ,  produces = "application/json")
	public String getAddress(@PathVariable String id , @RequestBody Address address) {
		address.setUserId(id);
		addressRepository.save(address);
		return "Addedd New Address";
	}
	
//	get address by id for update 
	@RequestMapping(value = "/getaddressbyid/{id}",  produces = "application/json")
	public  Address getAddressById(@PathVariable int id ) {
		return addressRepository.findById(id).get();
	}

//	update Address
	@PutMapping(value = "/updateAddress/{id}", produces = "application/json")
	public String updateAddress(@PathVariable Integer id, @RequestBody Address address) {
		System.out.println(address+"///****************///");
		Address add = addressRepository.findById(id).get();
		add.setName(address.getName());
		add.setHouseNo(address.getHouseNo());
		add.setArea(address.getArea());
		add.setCity(address.getCity());
		add.setState(address.getState());
		add.setPincode(address.getPincode());
		add.setMobile(address.getMobile());
		
		addressRepository.save(add);
		return "Updated";
	}
	
	

}
