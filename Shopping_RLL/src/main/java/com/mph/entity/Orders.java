package com.mph.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int orderID;


    private String orderTrackingNumber;

    
    private int totalPrice;


   @OneToMany(cascade = CascadeType.ALL, mappedBy = "order",fetch = FetchType.EAGER )
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;



    
    
    
    public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Orders(int orderID, String orderTrackingNumber, int totalPrice,
			Set<OrderItem> orderItems, Customer customer, Address shippingAddress) {
		super();
		this.orderID = orderID;
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalPrice = totalPrice;
		
		this.orderItems = orderItems;
		this.customer = customer;
		this.shippingAddress = shippingAddress;
	}



	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
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


	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
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



	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderTrackingNumber=" + orderTrackingNumber + ", totalPrice="
				+ totalPrice + ", orderItems="
				+ orderItems + ", customer=" + customer + ", shippingAddress=" + shippingAddress + "]";
	}


/*	public void add(ProductCart item) {
        if(item != null) {
            if(orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
*/


	
}
