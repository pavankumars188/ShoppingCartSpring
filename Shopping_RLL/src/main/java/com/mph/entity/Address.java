package com.mph.entity;


import javax.persistence.*;

/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int addressID;

    @Column(name = "street")
    private String street;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Orders order;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressID, String street, String state, String country, String zipCode, Orders order) {
		super();
		this.addressID = addressID;
		this.street = street;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.order = order;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", street=" + street + ", state=" + state + ", country=" + country
				+ ", zipCode=" + zipCode + ", order=" + order + "]";
	}

  
}
