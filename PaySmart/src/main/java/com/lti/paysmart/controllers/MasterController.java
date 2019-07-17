package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.dto.AdminLoginResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class MasterController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	@RequestMapping(value = "/login.user", method = RequestMethod.POST)
	public String login(@RequestBody UserLoginDTO userLoginDTO) {
		return userServ.performLogin(userLoginDTO);
	}
	
	@RequestMapping(value = "/login.admin", method = RequestMethod.POST)
	public AdminLoginResponseDTO login(@RequestBody AdminLoginDTO adminLoginDTO) {
		
		AdminLoginResponseDTO response = new AdminLoginResponseDTO();
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
	
	@RequestMapping(value = "/register.user", method = RequestMethod.POST)
	public String register(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userServ.performRegister(userRegisterDTO);
	}
	
	@RequestMapping(value = "/add.product", method = RequestMethod.POST)
	public String addProduct(AddProductDTO addProductDTO) {
		String result = admServ.addProduct(addProductDTO);
		System.out.println("Working");
		return "Okay";
	}
}
