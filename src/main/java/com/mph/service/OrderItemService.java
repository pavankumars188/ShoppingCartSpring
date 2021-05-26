package com.mph.service;

import java.util.List;

import com.mph.entity.OrderItem;
import com.mph.entity.Product;

public interface OrderItemService {
	public List<OrderItem> getCartList();
	public List<OrderItem> addProduct2Cart(int pid);
	public List<OrderItem> deleteProductFromCart(int pid);
	public int getNumberofRowsInCart();
	public Product getName(String name);
	public void saveCart(Product product);
}