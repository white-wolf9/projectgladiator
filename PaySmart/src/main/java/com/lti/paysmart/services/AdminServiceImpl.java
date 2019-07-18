package com.lti.paysmart.services;

import java.io.File;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
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
		System.out.println(1);
		pdao.addProduct(addProductDTO);
		System.out.println(2);
		return "Success";
	}
	
	
}
