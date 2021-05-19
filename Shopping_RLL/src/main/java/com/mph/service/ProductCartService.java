package com.mph.service;

import java.util.List;

import com.mph.entity.ProductCart;
/**
 * 
 * @author Prasanna_Palanivel
 *
 */
public interface ProductCartService {
	public List<ProductCart> getCartList();
	public List<ProductCart> addProduct2Cart(int pid);
	public List<ProductCart> deleteProductFromCart(int pid);
}
