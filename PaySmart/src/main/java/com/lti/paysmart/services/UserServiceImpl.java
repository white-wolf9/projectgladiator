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
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.enums.CardTypes;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.EMIDao;
import com.lti.paysmart.interfaces.GenericDao;
import com.lti.paysmart.interfaces.ProductDao;
import com.lti.paysmart.interfaces.UserDao;
import com.lti.paysmart.interfaces.UserService;
import com.lti.paysmart.utilities.EMIUtility;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao udao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	GenericDao gdao;
	
	@Autowired
	EMIDao edao;
	
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
		User user = (User) udao.fetchByUsername(productOrderRequestDTO.getUser_name());
		Card card = user.getCard();
		
		if(card.getCard_status().equals(CardStatus.INACTIVE)) {
			orderResponse.setResponse("Card is inactive, please wait for it to be activated");
			return orderResponse;
		}
		else {
			Product product = (Product) gdao.fetchById(Product.class, productOrderRequestDTO.getProduct_id());
			EMI emi = new EMI();
			EMIUtility emiUtility = new EMIUtility();
			
			if((productOrderRequestDTO.getEmi_scheme()).equals((EMITypes.THREEMONTHS).toString())) {
				emi = edao.fetchSpecificEMISchemeByProduct(productOrderRequestDTO.getProduct_id(), EMITypes.THREEMONTHS);
				
				if(card.getType().equals(CardTypes.GOLD)) {
					//Calculating the installment value
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_gold(), 0.25);
					double totalAmtToPay = installment_value*3;
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						return udao.placeOrderFresh(installment_value, totalAmtToPay, user, productOrderRequestDTO, product);
						//orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
					
				}else {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_titanium(), 0.25);
					double totalAmtToPay = installment_value*3;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						return udao.placeOrderFresh(installment_value, totalAmtToPay, user, productOrderRequestDTO, product);
					}
					
				}
				
			}
			
			if((productOrderRequestDTO.getEmi_scheme()).equals((EMITypes.SIXMONTHS).toString())) {
				emi = edao.fetchSpecificEMISchemeByProduct(productOrderRequestDTO.getProduct_id(), EMITypes.SIXMONTHS);

				if(card.getType().equals(CardTypes.GOLD)) {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_gold(), 0.50);
					double totalAmtToPay = installment_value*6;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
					
					
				}else {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_titanium(), 0.50);
					double totalAmtToPay = installment_value*6;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
						
				}
				
			}
			
			
			if((productOrderRequestDTO.getEmi_scheme()).equals((EMITypes.NINEMONTHS).toString())) {
				emi = edao.fetchSpecificEMISchemeByProduct(productOrderRequestDTO.getProduct_id(), EMITypes.NINEMONTHS);
				
				if(card.getType().equals(CardTypes.GOLD)) {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_gold(), 0.75);
					double totalAmtToPay = installment_value*9;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
					
				}else {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_titanium(), 0.75);
					double totalAmtToPay = installment_value*9;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
					
				}
				
			}
			
			
			if((productOrderRequestDTO.getEmi_scheme()).equals((EMITypes.TWELVEMONTHS).toString())) {
				emi = edao.fetchSpecificEMISchemeByProduct(productOrderRequestDTO.getProduct_id(), EMITypes.TWELVEMONTHS);
				
				if(card.getType().equals(CardTypes.GOLD)) {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_gold(), 1);
					double totalAmtToPay = installment_value*12;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}
					
				}else {
					double installment_value = emiUtility.calculateInstallmnet(product.getPrice(), emi.getEmi_value_titanium(), 1);
					double totalAmtToPay = installment_value*12;
					
					if(totalAmtToPay>user.getCard().getCard_balance()) {
						orderResponse.setResponse("Card is active, but no money sorry"); 
					}
					else {
						orderResponse.setResponse("Card is active, Product is yet to be purchased"); 
					}

				}

			}
			
			return orderResponse;
		}
	}
	
	
	
}
