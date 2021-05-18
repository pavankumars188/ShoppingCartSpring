package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mph.entity.ProductCart;

@Repository
public class ProductCartDaoImplementation implements ProductCartDao {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ProductCart> addProduct2Cart(int pid) {
		Query query = getSession().createQuery(
				"INSERT INTO Product_Cart(product_id, quantity, unit_price,image_url) SELECT product_id, quantity, unit_price,image_url FROM Product WHERE product_id =:pid");
		query.setParameter("pid", pid);
		List<ProductCart> cartList = query.list();
	

		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Inserted " + noofrows + "rows. ");
		}
		return cartList;

	}

	@Override
	public List<ProductCart> deleteProductFromCart(int pid) {
		Query query = getSession().createQuery("delete ProductCart pc where pid =:pid");
		query.setParameter("pid", pid);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getCartList();
	}

	@Override
	public List<ProductCart> getCartList() {
		Query query = getSession().createQuery("select me from ProductCart me");
		List<ProductCart> productList = query.list();
		return productList;
	}
	
}
