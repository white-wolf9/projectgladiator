package com.lti.paysmart.interfaces;

import java.util.List;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.User;

public interface AdminService {
	
	public String performLogin(AdminLoginDTO adminLoginDTO);
	public String addProduct(AddProductDTO addProductDTO);
	public List<User> viewAllUser();
	public String toggleCard(long user_id);
}
