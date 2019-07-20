package com.lti.paysmart.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
import com.lti.paysmart.entities.Product;

public interface UserService {
	
	public String performLogin(UserLoginDTO userLoginDTO);
	public String performRegister(UserRegisterDTO userRegisterDTO);
	public CardDetailsResponseDTO fetchCardUser(CardDetailsRequestDTO cardDetailsRequestDTO);
	public List<Product> fetchAllProduct();
	public ViewProductDetailedDTO fetchSingleProduct(long product_id);
	public ProductOrderResponseDTO placeOrder(ProductOrderRequestDTO productOrderRequestDTO);

}
