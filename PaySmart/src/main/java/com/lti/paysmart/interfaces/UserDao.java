package com.lti.paysmart.interfaces;

import java.util.List;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.entities.User;

public interface UserDao extends GenericDao {

	/*
	 * All the methods that UserDao should have are declared here.
	 */
	
	public String performLogin(UserLoginDTO userLoginDTO);
	public String performRegister(UserRegisterDTO userRegisterDTO);
	public List<User> viewAllUser();
}
