package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.AdminLoginDTO;

public interface AdminDao {
	
	public String performLogin(AdminLoginDTO adminLoginDTO);

}
