package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.ProductCategory;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createProductCategory(ProductCategoryDao productCategory) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(productCategory);
		System.out.println("Employee Stored in DB Successfully !!!");
	}

	@Override
	public List<ProductCategory> productCategoryList() {
		Query query = getSession().createQuery("select me from Employee me");
		List<ProductCategory> categoryList = query.list();
		return categoryList;
	}

	@Override
	public List<ProductCategory> deleteProductCategory(int pcId) {
		Query query = getSession().createQuery("delete product_category me where pcId =:pcId");
		query.setParameter("pcId", pcId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return productCategoryList();
	}

	@Override
	public ProductCategory searchProductCategory(String categoryName) {
		return (ProductCategory)getSession().get(ProductCategory.class,categoryName);
		// TODO Auto-generated method stub
		
	}

	
}
