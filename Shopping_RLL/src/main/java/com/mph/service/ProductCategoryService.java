package com.mph.service;
/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
import java.util.List;

import com.mph.dao.ProductCategoryDao;
import com.mph.entity.ProductCategory;

public interface ProductCategoryService {
	public void createProductCategory(ProductCategoryDao productCategory);
	public List<ProductCategory> productCategoryList();
	public List<ProductCategory> deleteProductCategory(int pcid);
	public List<ProductCategory> searchCategory(String category);

}
