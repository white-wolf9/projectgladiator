package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.AddProductDTO;

public interface ProductDao extends GenericDao {
	
	public void addProduct(AddProductDTO adminAddProductDTO);
}
