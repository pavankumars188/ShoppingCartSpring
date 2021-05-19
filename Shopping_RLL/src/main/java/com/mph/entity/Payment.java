package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.ui.Model;

@Entity
public class Payment {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionID;

	
	
	@Column
	private String paymenttypes ;
	@Column
	private int totalamount;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int transactionID, String paymenttypes, int totalamount) {
		super();
		this.transactionID = transactionID;
		this.paymenttypes = paymenttypes;
		this.totalamount = totalamount;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionid) {
		this.transactionID = transactionid;
	}
	public String getPaymenttypes() {
		return paymenttypes;
	}
	public void setPaymenttypes(String paymenttypes) {
		this.paymenttypes = paymenttypes;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "Payment [transactionID=" + transactionID + ", paymenttypes=" + paymenttypes + ", totalamount="
				+ totalamount + "]";
	}
	
	}
	

	