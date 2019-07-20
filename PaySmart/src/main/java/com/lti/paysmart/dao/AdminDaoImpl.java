package com.lti.paysmart.dao;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.Admin;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.interfaces.AdminDao;
import com.lti.paysmart.interfaces.GenericDao;

@Component
public class AdminDaoImpl extends GenericDaoImpl implements AdminDao{
	
	@Autowired
	GenericDao gdao;

	@Override
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		Admin admin_temp = null;
		try {
			admin_temp = (Admin) entityManager.createQuery("select a from Admin as a where a.credential.username = :username").setParameter("username", adminLoginDTO.getUsername()).getSingleResult();
		}catch(NoResultException noResultException) {
			
		}
		if(admin_temp == null)
			return "Administrator account does not exist!";
		else if(admin_temp.getCredential().getPassword().equals(adminLoginDTO.getPassword().toString()))
			return "Success";
		else
			return "Incorrect password entered";
	}

	@Override
	public String toggleCard(long user_id) {
		User user_temp = (User) gdao.fetchById(User.class, user_id);
		if(user_temp.getCard().getCard_status().equals(CardStatus.ACTIVE)) {
			user_temp.getCard().setCard_status(CardStatus.INACTIVE);
			entityManager.merge(user_temp);
			return "CARD IS NOW INACTIVE"; 
		}
		else { 
			user_temp.getCard().setCard_status(CardStatus.ACTIVE);
			entityManager.merge(user_temp);
			return "CARD IS NOW ACTIVE"; 
		}
	}

	
}
