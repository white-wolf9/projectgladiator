package com.lti.paysmart.dao;

import org.springframework.stereotype.Component;

import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.UserDao;

/*
 * All the methods that are unique to the Class User go here and are exposed via the interface UserDao
 */

@Component
public class UserDaoImpl extends GenericDaoImpl implements UserDao  {

	@Override
	public String performLogin(User user) {
		User user_temp = (User) entityManager.createQuery("select u from User as u where u.Credential.username = :username").setParameter("username", user.getCredential().getUsername()).getSingleResult();
		if(user_temp == null)
			return "User does not exist!";
		else {
			if(user_temp.getCredential().getPassword()==user.getCredential().getPassword())
				return "Success";
			else
				return "Incorrect Password";
		}
		
	}

	
	
}
