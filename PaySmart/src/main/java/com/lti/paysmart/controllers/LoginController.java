package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.dto.LoginResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class LoginController {

	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	@RequestMapping(value = "/login.user", method = RequestMethod.POST)
	public LoginResponseDTO login(@RequestBody UserLoginDTO userLoginDTO) {
		
		LoginResponseDTO response = new LoginResponseDTO();
		String result = userServ.performLogin(userLoginDTO);
		if(result.equals("User account does not exist!")) {
			response.setMessage("User account does not exist!");
			return response;
		}
		else if(result.equals("Success")) {
			response.setPassword(userLoginDTO.getPassword());
			response.setUsername(userLoginDTO.getUsername());
			response.setMessage("Success");
			return response;
		}
		else {
			response.setMessage("Incorrect Password");
			return response;
		}
	}
	
	@RequestMapping(value = "/login.admin", method = RequestMethod.POST)
	public LoginResponseDTO login(@RequestBody AdminLoginDTO adminLoginDTO) {
		
		LoginResponseDTO response = new LoginResponseDTO();
		String result = admServ.performLogin(adminLoginDTO);
		if(result.equals("Administrator account does not exist!")) {
			response.setMessage("User does not exist");
			return response;
		}
		else if(result.equals("Success")) {
			response.setPassword(adminLoginDTO.getPassword());
			response.setUsername(adminLoginDTO.getUsername());
			response.setMessage("Success");
			return response;
		}
		else {
			response.setMessage("Incorrect Password");
			return response;
		}
		
	}
}
