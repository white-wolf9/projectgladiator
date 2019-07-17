package com.lti.paysmart.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.interfaces.AdminDao;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.ProductDao;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adao;
	
	@Autowired
	ProductDao pdao;
	
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		return adao.performLogin(adminLoginDTO);
	}

	@Override
	@Transactional
	public String addProduct(AddProductDTO addProductDTO) {
		pdao.addProduct(addProductDTO);
		return "Success";
	}
	
	
}
