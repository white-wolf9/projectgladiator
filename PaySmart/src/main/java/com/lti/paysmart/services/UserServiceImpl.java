package com.lti.paysmart.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
import com.lti.paysmart.entities.Card;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.interfaces.GenericDao;
import com.lti.paysmart.interfaces.ProductDao;
import com.lti.paysmart.interfaces.UserDao;
import com.lti.paysmart.interfaces.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao udao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	GenericDao gdao;
	
	public String performLogin(UserLoginDTO userLoginDTO) {
		return udao.performLogin(userLoginDTO);
	}

	@Override
	@Transactional
	public String performRegister(UserRegisterDTO userRegisterDTO) {
		return udao.performRegister(userRegisterDTO);
	}
	
	@Override
	public CardDetailsResponseDTO fetchCardUser(CardDetailsRequestDTO cardDetailsRequestDTO) {
		return udao.fetchCardUser(cardDetailsRequestDTO);
	}

	@Override
	public List<Product> fetchAllProduct() {
		return pdao.fetchAllProduct();
	}

	@Override
	public ViewProductDetailedDTO fetchSingleProduct(long product_id) {
		return pdao.fetchSingleProduct(product_id);
	}

	@Override
	public ProductOrderResponseDTO placeOrder(ProductOrderRequestDTO productOrderRequestDTO) {
		
		ProductOrderResponseDTO orderResponse = new ProductOrderResponseDTO();
		/*
		 * Testing
		 */
		User user = (User) udao.fetchByUsername(productOrderRequestDTO.getUser_name());
		/*
		 * Testing
		 */
		Card card = user.getCard();
		if(card.getCard_status().equals(CardStatus.INACTIVE)) {
			orderResponse.setResponse("Card is inactive, please wait for it to be activated");
			return orderResponse;
		}
		else {
			orderResponse.setResponse("Card is active, Code is not written");
			return orderResponse;
		}
	}
	
	
	
}
