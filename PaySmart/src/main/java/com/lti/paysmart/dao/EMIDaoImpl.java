package com.lti.paysmart.dao;

import org.springframework.stereotype.Component;

import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.interfaces.EMIDao;

@Component
public class EMIDaoImpl extends GenericDaoImpl implements EMIDao{

	@Override
	public void addEMIToProduct(Product product, EMI emi) {
		emi.setProduct(product);
		entityManager.merge(emi);
	}

	
}
