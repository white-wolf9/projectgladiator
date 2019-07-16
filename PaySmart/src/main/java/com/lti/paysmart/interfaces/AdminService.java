package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;

public interface AdminService {
	
	public String performLogin(AdminLoginDTO adminLoginDTO);
	public String addProduct(AddProductDTO addProductDTO);

}
