package com.lti.paysmart.services;

import java.io.File;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.AdminDao;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.ProductDao;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adao;
	
	@Autowired
	ProductDao pdao;
	
	public String performLogin(AdminLoginDTO adminLoginDTO) {
		return adao.performLogin(adminLoginDTO);
	}

	@Override
	public String addProduct(AddProductDTO addProductDTO) {
		System.out.println(1);
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
		System.out.println(2);
		pdao.addProduct(product);
		System.out.println(3);
		/*
		 * EMI emi = new EMI(); emi.setEmi_type(EMITypes.THREEMONTHS);
		 * emi.setEmi_value(addProductDTO.getEmi_three());
		 * emi.setZero_emi(addProductDTO.isEmi_three_zero()); emi.setProduct(product);
		 * pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.SIXMONTHS);
		 * emi.setEmi_value(addProductDTO.getEmi_six());
		 * emi.setZero_emi(addProductDTO.isEmi_six_zero()); emi.setProduct(product);
		 * pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.NINEMONTHS);
		 * emi.setEmi_value(addProductDTO.getEmi_nine());
		 * emi.setZero_emi(addProductDTO.isEmi_nine_zero()); emi.setProduct(product);
		 * pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.TWELVEMONTHS);
		 * emi.setEmi_value(addProductDTO.getEmi_twelve());
		 * emi.setZero_emi(addProductDTO.isEmi_twelve_zero()); emi.setProduct(product);
		 * pdao.add(emi);
		 */
		
		return "Success";
	}
	
	
}
