package com.smi.allone.bean;

import java.util.List;

import com.smi.allone.domain.Cart;
import com.smi.allone.domain.Product;

public class CartPro {
	
//	List<Product> pro;
//	List<Cart> car;
	
//	product variables 
	private int id;
	private String productName;
	private String brand;
	private String size;
	private String color;
	private String warranty;
	private String price;
	private String description;
	private String stockLevel;
	private String stockSold;
	private String image;

	

//	cart variables 
	private int cartId;
	private int userId;
	private int productId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(String stockLevel) {
		this.stockLevel = stockLevel;
	}
	public String getStockSold() {
		return stockSold;
	}
	public void setStockSold(String stockSold) {
		this.stockSold = stockSold;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
	
	
	
	

}
