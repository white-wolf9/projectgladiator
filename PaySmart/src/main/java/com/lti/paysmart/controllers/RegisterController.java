package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class RegisterController {

	@Autowired
	UserService userServ;
	
	@RequestMapping(value = "/register.user", method = RequestMethod.POST)
	public String login(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userServ.performRegister(userRegisterDTO);
	}
}
