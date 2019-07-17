package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;

public interface UserService {
	
	public String performLogin(UserLoginDTO userLoginDTO);
	public String performRegister(UserRegisterDTO userRegisterDTO);

}
