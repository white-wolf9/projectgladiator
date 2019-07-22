package com.lti.paysmart.interfaces;

import java.util.List;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
import com.lti.paysmart.entities.Product;

public interface ProductDao extends GenericDao {
	
	public void addProduct(AddProductDTO adminAddProductDTO);
	public Product viewProduct(String name);
	public Product viewProduct(long product_id);
	public List<ViewProductDTO> fetchAllProduct();
	public ViewProductDetailedDTO fetchSingleProduct(long product_id);
}
