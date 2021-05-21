package com.mph.entity;


import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int orderID;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "unit_price")
    private long unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_id")
    private Long productId;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(int orderID, String imageUrl, long unitPrice, int quantity, Long productId, Order order) {
		super();
		this.orderID = orderID;
		this.imageUrl = imageUrl;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productId = productId;
		this.order = order;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public long getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


}
