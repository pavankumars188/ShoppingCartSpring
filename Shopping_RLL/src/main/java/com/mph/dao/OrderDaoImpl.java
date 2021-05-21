package com.mph.dao;

import java.util.UUID;

public class OrderDaoImpl implements OrderDao {

	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	 private String generateOrderTrackingNumber() {
	        String uuid = UUID.randomUUID().toString();
	        System.out.println(uuid);
	        return  uuid;

	    }
}
