package com.mph.dao;
import java.util.List;

import com.mph.entity.OrderItem;
import com.mph.entity.Product;
public interface OrderItemDao {
	public List<OrderItem> getCartList();
	public List<OrderItem> addProduct2Cart(int pid);
	public List<OrderItem> deleteProductFromCart(int pid);
	public int getNumberofRowsInCart();
	public Product getName(String name);
	public void saveCart(Product product);
	
}
