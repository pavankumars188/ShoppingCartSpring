package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Payment;



@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	   * This method is used to insert employees in database. 
	   * @param employee This is the first paramter to createEmployee method
	   * 
	   * @return void This will not return anything
	   */

	@Override
	public void createPayment(Payment payment) {
		getSession().saveOrUpdate(payment);
		System.out.println("Employee Stored in DB Successfully !!!");
	}

	/**
	   * This method is used to insert employees in database. 
	   * @param No parameter
	   * 
	   * @return List<Employee> list of employees
	   */
	@Override
	public List<Payment> getPaymentList() {
		Query query = getSession().createQuery("select me from Payment me");
		List<Payment> empList = query.list();
		return empList;
	}

	@Override
	public Payment getPayment(Payment payment) {
		Criteria c = getSession().createCriteria(Payment.class);
		c.add(Restrictions.eq("transactionID", payment.getTransactionID()));
		Payment pay = (Payment) c.uniqueResult();
		return pay;
	}

}