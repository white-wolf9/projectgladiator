package com.lti.paysmart.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.interfaces.UserDao;
import com.lti.paysmart.interfaces.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao udao;
	
	public String performLogin(UserLoginDTO userLoginDTO) {
		return udao.performLogin(userLoginDTO);
	}

	@Override
	public String performRegister(UserRegisterDTO userRegisterDTO) {
		return udao.performRegister(userRegisterDTO);
	}

}
