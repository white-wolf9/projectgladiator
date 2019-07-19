package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;

public interface UserService {
	
	public String performLogin(UserLoginDTO userLoginDTO);
	public String performRegister(UserRegisterDTO userRegisterDTO);
	public CardDetailsResponseDTO fetchCardUser(CardDetailsRequestDTO cardDetailsRequestDTO);

}
