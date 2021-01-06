package com.wct.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wct.springdemo.entity.Customer;
//why this
@Repository  
public class CustomerDAOImpl implements CustomerDAO {
	
//	 need to inject hibernate session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		
//		get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
//		create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
//		execute the query and create result set 
		List<Customer> customers = query.getResultList();
		
		
//		return the result 
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
//		get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
	
//		create the query to save the customer
//		currentSession.save(theCustomer);
		
//		the above method is used for save only. spring provides a better way so that we can save/update the database without writing the extra code
//		extra code: check weather the customer id is not null save the object into database else insert a new record into database 
		
//		create a query to save/update the customer object 
		currentSession.saveOrUpdate(theCustomer);
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
//		get the current session 
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
//		create query to get the customer details from database 
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
	
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
//		get the current session 
		
		Session currentSession = sessionFactory.getCurrentSession();
		
//		delete object with primarykey
		
		Query query =
		currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId",theId);
	
		query.executeUpdate();
		
	}

}





