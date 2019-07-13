package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.services.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserService userServ;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody UserLoginDTO userLoginDTO) {
		return userServ.performLogin(userLoginDTO);
	}
}
