package com.mph.entity;


import javax.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private int orderID;

    private String productName;
    private String imageUrl;

    
    private int unitPrice;


 //   private int quantity;

    
  //  private int productId;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;


	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(int orderID, String productName, String imageUrl, int unitPrice, 
			Orders order) {
		super();
		this.orderID = orderID;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.unitPrice = unitPrice;
		//this.quantity = quantity;
	//	this.productId = productId;
		this.order = order;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	/*
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}

*/
	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	



}
