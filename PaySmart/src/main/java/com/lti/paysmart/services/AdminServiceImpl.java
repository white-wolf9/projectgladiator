package com.lti.paysmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.interfaces.AdminDao;
import com.lti.paysmart.interfaces.AdminService;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adao;
	
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		System.out.println(adminLoginDTO.getUsername());
		return adao.performLogin(adminLoginDTO);
	}
}
