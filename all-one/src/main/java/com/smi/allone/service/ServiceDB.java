package com.smi.allone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.allone.bean.CartPro;
import com.smi.allone.bean.CategoryPro;
import com.smi.allone.domain.Cart;
import com.smi.allone.domain.Category;
import com.smi.allone.domain.Product;
import com.smi.allone.domain.User;
import com.smi.allone.repository.CartRepository;
import com.smi.allone.repository.CategoryRepository;
import com.smi.allone.repository.UserRepository;



@Service
public class ServiceDB {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	
	
//	For User Login
//	public User findByEmail(String email) {
//		User emailDb = userRepository.findByEmail(email);
//		System.out.println("------------------"+emailDb+"--------------------");
//	return emailDb;
//	}
//	public User findByPassword(String password) {
//		User passwordDb = userRepository.findByPassword(password);
//		System.out.println("------------------"+passwordDb+"--------------------");
//		return passwordDb;
//	}
	
	public boolean checking(User user) {
		List<User> l= userRepository.check(user.getEmail(), user.getPassword());
		if(l ==  null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean forCategory(CategoryPro cat) {
		boolean b=false;
		
		Category category = new Category();
		category.setCategoryName(cat.getCategoryName());
//		if(catRepository.save(category) != null) {
//			b=true;
//		}
//		
		return b;
		
	}

	public Cart addToCart(int uid, int pid) {
		Cart cart = new Cart();
		cart.setUserId(uid);
		cart.setProductId(pid);
		cart.setQuantity(1);
		return cartRepository.save(cart);
	}
	public Cart addToCartIFExists(int uid, int pid , int qty) {
		Cart cart = new Cart();
		cart.setUserId(uid);
		cart.setProductId(pid);
		cart.setQuantity(qty);
		return cartRepository.save(cart);
	}

	public CartPro setValueCartPro(List<Product> productList, List<Cart> cartList) {
		return new CartPro();
	}


}
