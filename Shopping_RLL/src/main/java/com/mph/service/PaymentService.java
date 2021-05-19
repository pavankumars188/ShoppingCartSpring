package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Payment;


public interface PaymentService {
	public void createPayment(Payment payment);
	public List<Payment> getPaymentList();
	public Payment getPayment(Payment payment);
	//public List<Employee> updateEmployee(Employee employee);
	//public List<Employee> deleteEmployee(int eid);
	//public PaymentService getPaymentById(int transactionid);
	//public Employee search(String name);
	
	
	
}