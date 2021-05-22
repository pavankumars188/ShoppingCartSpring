package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.AddressDao;

import com.mph.entity.Address;


@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public void addAddress(Address address) {
		addressDao.addAddress(address);
		
	}

	@Override
	public List<Address> getAddressList() {
		
		return addressDao.getAddressList();
	}

	@Override
	public Address getAddress(Address address) {
		
		return addressDao.getAddress(address);
	}
	
	@Override
	public List<Address> updateAddress(Address address) {
	
		return addressDao.updateAddress(address);
	}

	/*@Override
	public List<Address> deleteAddress(int aid) {
		
		return addressDao.deleteAddress(aid);
	}*/



}