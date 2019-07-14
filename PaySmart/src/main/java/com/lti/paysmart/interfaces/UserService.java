package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.UserLoginDTO;

public interface UserService {
	
	public String performLogin(UserLoginDTO userLoginDTO);

}
