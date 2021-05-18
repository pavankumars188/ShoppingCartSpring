package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ProductDao;
import com.mph.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDao productDao;

	@Override
	public void createProduct(Product product) {
		productDao.createProduct(product);
		
	}

	@Override
	public List<Product> getProductList() {
		return productDao.getProductList();
		
	}

	@Override
	public Product getProduct(Product product) {
		return productDao.getProduct(product);
		
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
	}
	/*
	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		
	}

	@Override
	public List<Employee> getEmployeeList() {
		
		return employeeDao.getEmployeeList();
	}

	@Override
	public Employee getEmployee(Employee employee) {
		
		return employeeDao.getEmployee(employee);
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {
	
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		
		return employeeDao.deleteEmployee(eid);
	}

	 */
	
	
	

}