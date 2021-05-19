package com.mph.dao;

import java.util.List;


import com.mph.entity.ProductCategory;


/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */

public interface ProductCategoryDao {
	public void createProductCategory(ProductCategoryDao productCategory);
	public List<ProductCategory> productCategoryList();
	public List<ProductCategory> deleteProductCategory(int pcid);
	public List<ProductCategory> searchCategory(String category);

}
