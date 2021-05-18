package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createProduct(Product product) {
		getSession().saveOrUpdate(product);
		System.out.println("Employee Stored in DB Successfully !!!");
	}

	@Override
	public List<Product> getProductList() {
		Query query = getSession().createQuery("select me from Product me");
		List<Product> prodList = query.list();
		return prodList;
	}

	@Override
	public Product getProduct(Product product) {
		Criteria c = getSession().createCriteria(Product.class);
		c.add(Restrictions.eq("productid", product.getProductId()));
		Product prod = (Product) c.uniqueResult();
		return prod;
		
	}

	/*@Override
	public List<Product> updateProduct(Product employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> deleteProduct(int eid) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
	
