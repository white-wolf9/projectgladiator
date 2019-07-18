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
		
		EMI emi = new EMI(); List<EMI> list = new ArrayList<EMI>();
		  
		emi.setEmi_type(EMITypes.THREEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_three());
		emi.setZero_emi(addProductDTO.isEmi_three_zero()); list.add(emi);
		  
		emi.setEmi_type(EMITypes.SIXMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_six());
		emi.setZero_emi(addProductDTO.isEmi_six_zero()); list.add(emi);
		  
		emi.setEmi_type(EMITypes.NINEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_nine());
		emi.setZero_emi(addProductDTO.isEmi_nine_zero()); list.add(emi);
		  
		emi.setEmi_type(EMITypes.TWELVEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_twelve());
		emi.setZero_emi(addProductDTO.isEmi_twelve_zero()); list.add(emi);
		  
		for(EMI emi_iterator : list) {
			edao.addEMIToProduct(product, emi_iterator);
		 }
		
	}

	@Override
	public Product viewProduct(String name) {
		return (Product) entityManager.createQuery("select p from Product as p where p.name = :name").setParameter("name", name).getSingleResult();
	}

	@Override
	public Product viewProduct(long product_id) {
		return entityManager.find(Product.class, product_id); 
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		return entityManager.merge(product);
	}
	
}
