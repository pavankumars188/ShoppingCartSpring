package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Address;



public interface AddressService {
	public void addAddress(Address address);
	public List<Address> getAddressList();
	public Address getAddress(Address address);
	public List<Address> updateAddress(Address address);
//	public List<Address> deleteAddress(int aid);
	
}