package com.mph.controller;

import java.sql.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;
import com.mph.service.CustomerService;


@Controller
@RequestMapping(value="/CustomerRegistration")
public class CustomerController {

	Customer customer;

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView sigup(@RequestParam("txtcustomerFirstname") String customerFirstname, @RequestParam("txtcustomerLastname") String customerLastname,
			@RequestParam("txtgender") String gender, @RequestParam("txtemail") String email,@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date){

		System.out.println(customerFirstname + " " + customerLastname + email + gender+date);
		customer = new Customer();
		customer.setCustomerFirstname(customerFirstname);
		customer.setCustomerLastname(customerLastname);
		customer.setGender(gender);
		customer.setEmail(email);
		customer.setDateOfBirth(date);
		customerService.createCustomer(customer);

		return new ModelAndView("login");
	}

	public ModelAndView allCustomer() {
		List<Customer> li = customerService.getCustomerList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("cus1list", li);
		return mv;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtemail") String email, @RequestParam("txtpassword") String password) {

		customer = new Customer();
		customer.setEmail(email);

		Customer cus1 = customerService.getCustomer(customer);
		if (cus1 == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("msg", "Customer Not Found !!!");
			return mv;
		} else {
			return allCustomer();
		}

	}

	/*@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Customer customer) {
		List<Customer> emplist = customerService.deleteCustomer(customer.getCustomerid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", emplist);
		return mv;

	}*/

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCus(Customer customer) {		
		return new ModelAndView("edit");		

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Customer customer) {
		customerService.updateCustomer(customer);
		return allCustomer();

	}
	
	
	
	/*@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Employee employee) {
		List<Employee> emplist = employeeService.searchEmployee(employee.getEid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", emplist);
		return mv;
}*/
}
