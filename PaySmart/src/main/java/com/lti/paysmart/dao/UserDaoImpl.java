package com.lti.paysmart.dao;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.entities.Address;
import com.lti.paysmart.entities.BankDetails;
import com.lti.paysmart.entities.Card;
import com.lti.paysmart.entities.Credential;
import com.lti.paysmart.entities.Document;
import com.lti.paysmart.entities.Order;
import com.lti.paysmart.entities.Payment;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.UserDao;
import com.lti.paysmart.utilities.CardNumberGenerator;

/*
 * All the methods that are unique to the Class User go here and are exposed via the interface UserDao
 */

@Component
public class UserDaoImpl extends GenericDaoImpl implements UserDao  {

	@Override
	public String performLogin(UserLoginDTO userLoginDTO) {
		User user_temp = null;
		try {
			user_temp = (User) entityManager.createQuery("select u from User as u where u.credential.username = :username").setParameter("username", userLoginDTO.getUsername()).getSingleResult();
		}catch(NoResultException noResultException) {
			
		}
		if(user_temp == null)
			return "User account does not exist!";
		else if(user_temp.getCredential().getPassword().equals(userLoginDTO.getPassword().toString()))
			return "Success";
		else
			return "Incorrect Password";
	}

	@Override
	public String performRegister(UserRegisterDTO userRegisterDTO) {
		
		Card card = new Card();
		card.setCard_status(CardStatus.INACTIVE);
		card.setType(userRegisterDTO.getCardtype());
		card.setName(userRegisterDTO.getFname()+" "+userRegisterDTO.getLname());
		CardNumberGenerator cnd = new CardNumberGenerator();
		card.setCard_no(Long.parseLong(cnd.generate("4121", 16)));
		card.setCard_balance(0);
		card.setLifetime_credits(card.getCard_balance());
		/*
		 * The user has only control of what type of card they require.
		 * By default the status of the card is set to false
		 */
		BankDetails bankdetails = new BankDetails();
		bankdetails.setBank_name(userRegisterDTO.getBankname());
		bankdetails.setAcc_no(userRegisterDTO.getAcc_no());
		bankdetails.setIfsc_code(userRegisterDTO.getIfsc_code());
		/*
		 * All the details of the bank account entered by the user are stored in
		 * object of type BankDetails to be assigned to the User Entity
		 */
		Address address = new Address();
		address.setCity(userRegisterDTO.getCity());
		address.setDoorNo(userRegisterDTO.getDoorno());
		address.setStreet(userRegisterDTO.getStreet());
		address.setPincode(userRegisterDTO.getPincode());
		address.setCity(userRegisterDTO.getCity());
		address.setState(userRegisterDTO.getState());
		address.setCountry(userRegisterDTO.getCountry());
		/*
		 * All the details of the address entered by the user is stored in this
		 * object of type Address and is to be assigned to User Entity
		 */
		Credential credential = new Credential();
		credential.setUsername(userRegisterDTO.getUsername());
		credential.setPassword(userRegisterDTO.getPassword());
		/*
		 * All the details of the credentials entered by the user is stored in this
		 * object of type Credential and is assigned to the User Entity
		 */
		
		String path = "D:/uploads/";
		
		Document document = new Document();
		String filename = userRegisterDTO.getEmail()+"_"+userRegisterDTO.getAadharcard().getOriginalFilename();
		String aadharfinalpath = path + filename;
		try {
			userRegisterDTO.getAadharcard().transferTo(new File(aadharfinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		document.setAadharcardfilename(filename);
		
		filename = userRegisterDTO.getEmail()+"_"+userRegisterDTO.getPancard().getOriginalFilename();
		String panfinalpath = path + filename;
		try {
			userRegisterDTO.getPancard().transferTo(new File(panfinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		document.setPancardfilename(filename);
		/*
		 * All the details of the documents entered by the user is stored in this
		 * object of type Document and is assigned to the User Entity
		 */
		User user = new User();
		
		user.setFname(userRegisterDTO.getFname());
		user.setLname(userRegisterDTO.getLname());
		user.setEmail(userRegisterDTO.getEmail());
		user.setPhone_no(userRegisterDTO.getPhone_no());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			user.setDob(sdf.parse(userRegisterDTO.getDob()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = entityManager.merge(user);
		
		card.setUser(user);
		entityManager.merge(card);
		bankdetails.setUser(user);
		entityManager.merge(bankdetails);
		credential.setUser(user);
		entityManager.merge(credential);
		address.setUser(user);
		entityManager.merge(address);
		document.setUser(user);
		entityManager.merge(document);

		return "Success";
	}

	
	/*
	 * Shift the viewAllUser() to the administrator DAO because this is a functionality of the administrator
	 */
	
	@Override
	public List<User> viewAllUser() {
		return entityManager.createQuery("select u from User as u").getResultList();
		 
	}

	@Override
	public CardDetailsResponseDTO fetchCardUser(CardDetailsRequestDTO cardDetailsRequestDTO) {
		User user_temp = new User();
		try {
			user_temp = (User) entityManager.createQuery("select u from User as u where u.credential.username = :username").setParameter("username", cardDetailsRequestDTO.getUsername()).getSingleResult();
		}catch(NoResultException noResultException) {
			
		}
		
		CardDetailsResponseDTO response = new CardDetailsResponseDTO();
		response.setCardbalance(user_temp.getCard().getCard_balance());
		response.setCardstatus(user_temp.getCard().getCard_status().toString());
		response.setName(user_temp.getCard().getName());
		response.setType(user_temp.getCard().getType().toString());
		response.setCardno(user_temp.getCard().getCard_no());
		
		return response;
	}

	
	@Override
	public User fetchByUsername(String username) {
		return (User) entityManager.createQuery("select u from User as u where u.credential.username = :username").setParameter("username", username).getSingleResult();
	}

	@Override
	@Transactional
	public ProductOrderResponseDTO placeOrderFresh(double installment_value, double totalAmtToPay, User user,ProductOrderRequestDTO productOrderRequestDTO, Product product) {
		Order order = new Order();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		order.setOrder_date(date);
		String emi_scheme = productOrderRequestDTO.getEmi_scheme();
		EMITypes toPass = EMITypes.valueOf(emi_scheme);
		order.setEmi_scheme(toPass);
		order.setUser(user);
		order.setProduct(product);	
		order = entityManager.merge(order);
		
		ProductOrderResponseDTO orderResponse = new ProductOrderResponseDTO();
		orderResponse.setResponse("Well");
		return orderResponse;
	}
	
	

}
