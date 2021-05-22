package com.mph.dao;

import java.util.List;

import com.mph.entity.Address;



/**
 * 
 * @author Prasanna_Palanivel
 *
 */
public interface AddressDao {
	public void addAddress(Address address);
	public List<Address> getAddressList();
	public Address getAddress(Address address);
	public List<Address> updateAddress(Address address);
	//public List<Address> deleteAdress(int addressID);

}
