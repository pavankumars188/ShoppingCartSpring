package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.entity.Payment;
import com.mph.service.PaymentService;

@Controller
@RequestMapping("/payment")

public class PaymentController {

	Payment payment;

	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("login");
	}*/

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public  ModelAndView sigup (@RequestParam("txtpaymenttypes") String paymenttypes,
			@RequestParam("txttotalamount") int totalamount) {

		System.out.println(paymenttypes + totalamount);
		payment= new Payment();
	//	payment.setTransactionID(transactionID);
		payment.setPaymenttypes(paymenttypes);
		payment.setTotalamount(totalamount);
		paymentService.createPayment(payment);

		return new ModelAndView("Payment Successfull");
	}



	
	


	
	/*@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Employee employee) {
		Employee emp = employeeService.search(employee.getFname());
		
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", emplist);
		return mv;

	}*/
}