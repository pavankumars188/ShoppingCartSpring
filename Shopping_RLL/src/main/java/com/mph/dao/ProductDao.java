package com.mph.dao;

import java.util.List;

import com.mph.entity.Product;

public interface ProductDao {
	public void createProduct(Product product);
	public List<Product> getProductList();
	public Product getProduct(Product product);
}
