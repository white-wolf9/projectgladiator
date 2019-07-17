package com.lti.paysmart.dao;

import java.io.File;
import java.io.IOException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.entities.Address;
import com.lti.paysmart.entities.BankDetails;
import com.lti.paysmart.entities.Card;
import com.lti.paysmart.entities.Credential;
import com.lti.paysmart.entities.Document;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.UserDao;

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
			return "User does not exist!";
		else if(user_temp.getCredential().getPassword().equals(userLoginDTO.getPassword().toString()))
			return "Success";
		else
			return "Incorrect Password";
	}

	@Override
	public String performRegister(UserRegisterDTO userRegisterDTO) {
		
		Card card = new Card();
		card.setCard_status(false);
		card.setType(userRegisterDTO.getCardtype());
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
		Document document = new Document();
		String path = "D:/uploads/";
		String filename = userRegisterDTO.getEmail()+"_"+userRegisterDTO.getAadharcard().getOriginalFilename();
		String aadharfinalpath = path + filename;
		try {
			userRegisterDTO.getAadharcard().transferTo(new File(aadharfinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		document.setAadharcardfilename(aadharfinalpath);
		filename = userRegisterDTO.getEmail()+"_"+userRegisterDTO.getPancard().getOriginalFilename();
		String panfinalpath = path + filename;
		try {
			userRegisterDTO.getAadharcard().transferTo(new File(panfinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		document.setPancardfilename(panfinalpath);
		/*
		 * All the details of the documents entered by the user is stored in this
		 * object of type Document and is assigned to the User Entity
		 */
		User user = new User();
		
		user.setFname(userRegisterDTO.getFname());
		user.setLname(userRegisterDTO.getLname());
		user.setEmail(userRegisterDTO.getEmail());
		user.setPhone_no(userRegisterDTO.getPhone_no());
		user.setDob(userRegisterDTO.getDob());
		
		user.setCard(card);
		user.setBank(bankdetails);
		user.setCredential(credential);
		user.setAddress(address);
		user.setDocument(document);
		
		entityManager.merge(user);
		
		return "Success";
	}
	
	

}
