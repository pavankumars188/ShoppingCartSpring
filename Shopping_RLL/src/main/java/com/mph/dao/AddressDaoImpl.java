package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Address;



@Repository
public class AddressDaoImpl implements AddressDao {

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
	public void addAddress(Address address) {
		getSession().saveOrUpdate(address);
		System.out.println("Address Stored in DB Successfully !!!");
	}

	
	@Override
	public List<Address> getAddressList() {
		Query query = getSession().createQuery("select me from Address me");
		List<Address> addList = query.list();
		return addList;
	}

	@Override
	public Address getAddress(Address address) {
		Criteria c = getSession().createCriteria(Address.class);
		c.add(Restrictions.eq("addressID", address.getAddressID()));
		Address add = (Address) c.uniqueResult();
		return add;
	}

	
	@Override
	public List<Address> updateAddress(Address address) {
		Query query = getSession().createQuery("update Address me set street=:street,state=:state,country=:country,zipCode=:zipCode where id =:id");
		query.setParameter("street",address.getStreet());
		query.setParameter("state",address.getState());
		query.setParameter("country",address.getCountry());
		query.setParameter("id",address.getAddressID());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getAddressList();
	}

	/*@Override
	public List<Address> deleteAddress(int id) {
		Query query = getSession().createQuery("delete Address me where id =:id");
		query.setParameter("id", id);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getAddressList();
	}*/

	

}