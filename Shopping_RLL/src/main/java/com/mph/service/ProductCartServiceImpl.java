package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mph.dao.ProductCartDao;
import com.mph.entity.ProductCart;

@Service
@Transactional
public class ProductCartServiceImpl implements ProductCartService {
	@Autowired
	ProductCartDao productCartDao ;
	@Override
	public List<ProductCart> getCartList() {
		// TODO Auto-generated method stub
		return productCartDao.getCartList();
	}

	@Override
	public List<ProductCart> addProduct2Cart(int pid) {
		// TODO Auto-generated method stub
		return productCartDao.addProduct2Cart(pid);
	}

	@Override
	public List<ProductCart> deleteProductFromCart(int pid) {
		// TODO Auto-generated method stub
		return productCartDao.deleteProductFromCart(pid);
	}

	

}
