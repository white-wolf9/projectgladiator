package com.lti.paysmart.interfaces;

import com.lti.paysmart.entities.User;

public interface UserDao extends GenericDao {

	/*
	 * All the methods that UserDao should have are declared here.
	 */
	
	public String performLogin(User user);
}
