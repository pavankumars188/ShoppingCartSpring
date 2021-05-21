package com.mph.entity;

import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
public class Product {

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int productId;

    @Column(name="name")
    private String productName;

    @Column(name="description")
    private String productDescription;

    @Column(name="unit_price")
    private long productPrice;

    @Column(name="image_url")
    private String imageUrl;
    
    @Column
    private String category;

	public Product(int productId, String productName, String productDescription, long productPrice, String imageUrl,
			String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imageUrl = imageUrl;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", imageUrl=" + imageUrl + ", category="
				+ category + "]";
	}

	
}
