package com.lti.paysmart.dao;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.EMIDao;
import com.lti.paysmart.interfaces.ProductDao;

@Component
public class ProductDaoImpl extends GenericDaoImpl implements ProductDao{
	
	@Autowired
	EMIDao edao;

	@Override
	public void addProduct(AddProductDTO addProductDTO) {
		
		Product product = new Product();
		product.setName(addProductDTO.getProduct_name());
		product.setDescription(addProductDTO.getProduct_description());
		product.setPrice(addProductDTO.getProduct_price());
		product.setStock(addProductDTO.getProduct_stock());
		
		String path = "D:/uploads/";
		String filename = addProductDTO.getProduct_name()+"_"+addProductDTO.getProduct_image().getOriginalFilename();
		String imagefinalpath = path + filename;
		try {
			addProductDTO.getProduct_image().transferTo(new File(imagefinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		product.setImagefilename(imagefinalpath);
		
		product = entityManager.merge(product);
		
		EMI emi = new EMI();
		  
		emi.setEmi_type(EMITypes.THREEMONTHS);
		emi.setEmi_value_gold(addProductDTO.getEmi_three_gold());
		emi.setEmi_value_titanium(addProductDTO.getEmi_three_titanium());
		edao.addEMIToProduct(product, emi);
		  
		emi.setEmi_type(EMITypes.SIXMONTHS);
		emi.setEmi_value_gold(addProductDTO.getEmi_six_gold());
		emi.setEmi_value_titanium(addProductDTO.getEmi_six_titanium());
		edao.addEMIToProduct(product, emi);
		  
		emi.setEmi_type(EMITypes.NINEMONTHS);
		emi.setEmi_value_gold(addProductDTO.getEmi_nine_gold());
		emi.setEmi_value_titanium(addProductDTO.getEmi_nine_titanium());
		edao.addEMIToProduct(product, emi);
		  
		emi.setEmi_type(EMITypes.TWELVEMONTHS);
		emi.setEmi_value_gold(addProductDTO.getEmi_twelve_gold());
		emi.setEmi_value_titanium(addProductDTO.getEmi_twelve_titanium());
		edao.addEMIToProduct(product, emi);
		
	}

	@Override
	public Product viewProduct(String name) {
		return (Product) entityManager.createQuery("select p from Product as p where p.name = :name").setParameter("name", name).getSingleResult();
	}

	@Override
	public Product viewProduct(long product_id) {
		return entityManager.find(Product.class, product_id); 
	}
	
}
