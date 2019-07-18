package com.lti.paysmart.interfaces;

import com.lti.paysmart.dto.AddProductDTO;

import com.lti.paysmart.entities.Product;

public interface ProductDao extends GenericDao {
	
	public void addProduct(AddProductDTO adminAddProductDTO);
	public Product viewProduct(String name);
	public Product viewProduct(long product_id);
	
}
