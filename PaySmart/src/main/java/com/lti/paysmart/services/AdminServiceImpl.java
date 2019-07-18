package com.lti.paysmart.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.AdminDao;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.GenericDao;
import com.lti.paysmart.interfaces.ProductDao;
import com.lti.paysmart.interfaces.UserDao;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	UserDao udao;
	
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		return adao.performLogin(adminLoginDTO);
	}

	@Override
	@Transactional
	public String addProduct(AddProductDTO addProductDTO) {
		pdao.addProduct(addProductDTO);
		return "Success";
	}

	@Override
	public List<User> viewAllUser() {
		return udao.viewAllUser();
		
	}
	
	
}
