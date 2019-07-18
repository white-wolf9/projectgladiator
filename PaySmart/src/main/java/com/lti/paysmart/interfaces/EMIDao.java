package com.lti.paysmart.interfaces;

import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;

public interface EMIDao extends GenericDao {
	
	public void addEMIToProduct(Product product, EMI emi);

}
