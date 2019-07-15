package com.lti.paysmart.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.UserDao;

/*
 * All the methods that are unique to the Class User go here and are exposed via the interface UserDao
 */

@Component
public class UserDaoImpl extends GenericDaoImpl implements UserDao  {

	@Override
	public String performLogin(UserLoginDTO userLoginDTO) {
		User user_temp = null;
		try {
			user_temp = (User) entityManager.createQuery("select u from User as u where u.credential.username = :username").setParameter("username", userLoginDTO.getUsername()).getSingleResult();
		}catch(NoResultException noResultException) {
			
		}
		if(user_temp == null)
			return "User does not exist!";
		else if(user_temp.getCredential().getPassword().equals(userLoginDTO.getPassword().toString()))
			return "Success";
		else
			return "Incorrect Password";
		
	}

}
