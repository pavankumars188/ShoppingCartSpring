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
    private Long productId;


    @ManyToOne()
    @JoinColumn(name="category_id", nullable = false)
    private ProductCategory category;

    @Column(name="name")
    private String productName;

    @Column(name="description")
    private String productDescription;

    @Column(name="unit_price")
    private long productPrice;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Product(Long productId, ProductCategory category, String productName, String productDescription,
			long productPrice, String imageUrl, Date dateCreated) {
		super();
		this.productId = productId;
		this.category = category;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imageUrl = imageUrl;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", productPrice=" + productPrice + ", imageUrl="
				+ imageUrl + ", dateCreated=" + dateCreated + "]";
	}

	
    
    
}
