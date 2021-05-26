package com.mph.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int productId;

  
    private String productName;

    private int unitPrice;

    private String imageUrl;
    
    @Column
    private String category;

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

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", imageUrl=" + imageUrl + ", category=" + category + "]";
	}

	public Product(int productId, String productName, int unitPrice, String imageUrl, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.category = category;
	}

	
}
