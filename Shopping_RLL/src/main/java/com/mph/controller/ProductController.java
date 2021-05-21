package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.dao.ProductDao;
import com.mph.entity.Product;
import com.mph.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {

	Product product;

	@Autowired
	ProductService productservice;

	@RequestMapping(value = "/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("login");
	}*/

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView sigup(@RequestParam("txtid") int productId, @RequestParam("txtpname") String productName,
			@RequestParam("txtproductDesc") String productDescription, @RequestParam("txtProPrice") int productPrice) {

		System.out.println(productId + " " + productName + productDescription + productPrice);
		product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		productservice.createProduct(product);

		return new ModelAndView("login");
	}

	public ModelAndView allEmployee() {
		List<Product> li = productservice.getProductList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("productlist", li);
		return mv;
	}

	/*@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtemail") String email, @RequestParam("txtpassword") String password) {

		product = new Product();
		product.setEmail(email);

		Product emp = employeeService.getEmployee(employee);
		if (emp == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("msg", "Employee Not Found !!!");
			return mv;
		} else {
			return allEmployee();
		}

	}
   */
	/*@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Product employee) {
		List<Product> prodlist = productservice.deleteProduct(product.getProductid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("prodlist", prodlist);
		return mv;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmp(Product employee) {		
		return new ModelAndView("edit");		

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Product product) {
		productservice.updateProduct(product);
		return allEmployee();

	}
	
	
	
	/*@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Employee employee) {
		List<Employee> emplist = employeeService.searchEmployee(employee.getEid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", emplist);
		return mv;
}*/
}
