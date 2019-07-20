package com.lti.paysmart.dao;

import org.springframework.stereotype.Component;

import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.EMIDao;

@Component
public class EMIDaoImpl extends GenericDaoImpl implements EMIDao{

	@Override
	public void addEMIToProduct(Product product, EMI emi) {
		emi.setProduct(product);
		entityManager.merge(emi);
	}

	@Override
	public EMI fetchSpecificEMISchemeByProduct(long product_id, EMITypes emi_type) {
		
		return (EMI) entityManager.createQuery("select e from EMI as e where e.product.product_id = :product_id and emi_type = :emi_type")
				.setParameter("product_id", product_id)
				.setParameter("emi_type", emi_type).getSingleResult();
		
	}
	
	
	
}
