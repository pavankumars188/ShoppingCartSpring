package com.mph.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "status")
    private String status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order" )
    private Set<ProductCart> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;



    public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(Long id, String orderTrackingNumber, int totalPrice, int totalQuantity, String status,
			Date dateCreated, Date lastUpdated, Set<ProductCart> orderItems, Customer customer,
			Address shippingAddress) {
		super();
		this.id = id;
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.orderItems = orderItems;
		this.customer = customer;
		this.shippingAddress = shippingAddress;
	}



	public void add(ProductCart item) {
        if(item != null) {
            if(orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

  
    public Set<ProductCart> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<ProductCart> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTrackingNumber=" + orderTrackingNumber + ", totalPrice=" + totalPrice
				+ ", totalQuantity=" + totalQuantity + ", status=" + status + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + ", orderItems=" + orderItems + ", customer=" + customer
				+ ", shippingAddress=" + shippingAddress + "]";
	}
    
}
