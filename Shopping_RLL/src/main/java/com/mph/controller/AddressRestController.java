package com.mph.controller;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Address;
import com.mph.service.AddressService;

@RestController
@RequestMapping("/Address")
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = { RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class AddressRestController {
	
	@Autowired
	AddressService addressService;
	
	private static final Logger logger = Logger.getLogger("AddressRestController.class");
	
	
	@GetMapping("/All")
	public  ResponseEntity<List<Address>> allAddress() {
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE LIST OF ADDRESS");
		System.out.println(logger.getName()+"   "+ logger.getLevel());
		
		
		PropertyConfigurator.configure(AddressRestController.class.getClassLoader().getResource("log4j.properties"));
		logger.info("Log4j appender configuration is successfull !!!!");
		List<Address> li = addressService.getAddressList();
		System.out.println("Addr List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
		
	}
	
	/*@GetMapping("/getAdd/{id}")
	public  ResponseEntity<Address> getAddressById(@PathVariable("id") int Aid) {
		
		Address add= addressService.getAddressById(Aid);
		System.out.println("Address retrieved : " + add);
		
		if(add == null)
		{
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Address>(add,HttpStatus.OK);
		
	}*/

	@PostMapping("/Add")
	public Address addAddress(@RequestBody Address address)
	{
		addressService.addAddress(address);
		return address;
	}
	
	/*@DeleteMapping("/delete/{id}")
	public  ResponseEntity<List<Address>> deleteAddress(@PathVariable("id") int Aid) {
		
		List<Address> li = AddressService.deleteAddress(Aid);
		System.out.println("Addr List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
		
	}*/
	
	@PutMapping("/Update")
	public  ResponseEntity<List<Address>> updateAddress(@RequestBody Address add) {
		
		List<Address> li = addressService.updateAddress(add);
		System.out.println("Addr List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
		
	}
	
}