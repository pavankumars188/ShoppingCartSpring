package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ProductCartDao;
import com.mph.dao.ProductCategoryDao;
import com.mph.entity.ProductCategory;

/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	ProductCategoryDao productCategory ;

	@Override
	public void createProductCategory(ProductCategoryDao productCategory) {
		// TODO Auto-generated method stub
		productCategory.createProductCategory(productCategory);;
	}

	@Override
	public List<ProductCategory> productCategoryList() {
		// TODO Auto-generated method stub
		return productCategory.productCategoryList();
	}

	@Override
	public List<ProductCategory> deleteProductCategory(int pcid) {
		// TODO Auto-generated method stub
		return productCategory.deleteProductCategory(pcid);
	}

	@Override
	public List<ProductCategory> searchCategory(String category) {
		// TODO Auto-generated method stub
		return productCategory.searchCategory(category);
	}

	
	

}
