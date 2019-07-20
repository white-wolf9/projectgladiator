package com.lti.paysmart.interfaces;

import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;

public interface EMIDao extends GenericDao {
	
	public void addEMIToProduct(Product product, EMI emi);
	public EMI fetchSpecificEMISchemeByProduct(long product_id, EMITypes emi_type);

}
