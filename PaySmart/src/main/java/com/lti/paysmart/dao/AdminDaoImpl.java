package com.lti.paysmart.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.Admin;
import com.lti.paysmart.interfaces.AdminDao;

@Component
public class AdminDaoImpl extends GenericDaoImpl implements AdminDao{

	@Override
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		Admin admin_temp = null;
		try {
			admin_temp = (Admin) entityManager.createQuery("select a from Admin as a where a.credential.username = :username").setParameter("username", adminLoginDTO.getUsername()).getSingleResult();
		}catch(NoResultException noResultException) {
			
		}
		if(admin_temp == null)
			return "User does not exist!";
		else if(admin_temp.getCredential().getPassword().equals(adminLoginDTO.getPassword().toString()))
			return "Success";
		else
			return "Incorrect Password";
	}


}
