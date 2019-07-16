package com.lti.paysmart.dao;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.ProductDao;


public class ProductDaoImpl extends GenericDaoImpl implements ProductDao{

	@Override
	public void addProduct(AddProductDTO addProductDTO) {
		
		Product product = new Product();
		product.setName(addProductDTO.getName());
		product.setDescription(addProductDTO.getDescription());
		product.setPrice(addProductDTO.getPrice());
		product.setStock(addProductDTO.getStock());
		
		String path = "D:/uploads/";
		String filename = addProductDTO.getName()+"_"+addProductDTO.getImagefilename().getOriginalFilename();
		String imagefinalpath = path + filename;
		try {
			addProductDTO.getImagefilename().transferTo(new File(imagefinalpath));	
		} catch(IOException e) {
			e.printStackTrace();
		}
		product.setImagefilename(imagefinalpath);
		
		EMI emi = new EMI();
		Set<EMI> set = new HashSet<EMI>();
		
		emi.setEmi_type(EMITypes.THREEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_three());
		emi.setZero_emi(addProductDTO.isEmi_three_zero());
		set.add(emi);
		
		emi.setEmi_type(EMITypes.SIXMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_six());
		emi.setZero_emi(addProductDTO.isEmi_six_zero());
		set.add(emi);
		
		emi.setEmi_type(EMITypes.NINEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_nine());
		emi.setZero_emi(addProductDTO.isEmi_nine_zero());
		set.add(emi);
		
		emi.setEmi_type(EMITypes.TWELVEMONTHS);
		emi.setEmi_value(addProductDTO.getEmi_twelve());
		emi.setZero_emi(addProductDTO.isEmi_twelve_zero());
		set.add(emi);
		
		for(EMI emi_iterator: set) {
			if(emi_iterator.isZero_emi()){
				emi_iterator.setEmi_value(0.01);
			}
		}
		
		product.setEmi(set);
		
		entityManager.merge(product);
	}
	
}
