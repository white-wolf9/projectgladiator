package com.lti.paysmart.dao;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
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
		product.setImagefilename(filename);
		
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

	@Override
	public List<ViewProductDTO> fetchAllProduct() {
		
		List<Product> list = (List<Product>) entityManager.createQuery("select p from Product as p").getResultList();
		List<ViewProductDTO> responseList = new ArrayList<ViewProductDTO>();
		
		for(Product product_iterator : list) {
			ViewProductDTO object = new ViewProductDTO();
			object.setName(product_iterator.getName());
			object.setProduct_id(product_iterator.getProduct_id());
			object.setDescription(product_iterator.getDescription());
			
			object.setPrice(product_iterator.getPrice());
			
			Path sourceProductFile = Paths.get("D:/uploads/"+product_iterator.getImagefilename());
			Path destProductFile = Paths.get("src/main/resources/static/uploads/"+product_iterator.getImagefilename());
			try {
				Files.copy(sourceProductFile, destProductFile, StandardCopyOption.REPLACE_EXISTING);
			}catch (Exception e) {
				// TODO: handle exception
			}
			object.setImagefilename(product_iterator.getImagefilename());
			
			responseList.add(object);
		}
		return responseList;
	}

	@Override
	public ViewProductDetailedDTO fetchSingleProduct(long product_id) {
		
		Product product = (Product) entityManager.find(Product.class, product_id);
		EMI emi_obj_three = (EMI) entityManager.createQuery("select e from EMI as e where e.product.product_id = :product_id and e.emi_type='THREEMONTHS'").setParameter("product_id", product_id).getSingleResult();
		EMI emi_obj_six = (EMI) entityManager.createQuery("select e from EMI as e where e.product.product_id = :product_id and e.emi_type='SIXMONTHS'").setParameter("product_id", product_id).getSingleResult();
		EMI emi_obj_nine = (EMI) entityManager.createQuery("select e from EMI as e where e.product.product_id = :product_id and e.emi_type='NINEMONTHS'").setParameter("product_id", product_id).getSingleResult();
		EMI emi_obj_twelve = (EMI) entityManager.createQuery("select e from EMI as e where e.product.product_id = :product_id and e.emi_type='TWELVEMONTHS'").setParameter("product_id", product_id).getSingleResult();

		ViewProductDetailedDTO object = new ViewProductDetailedDTO();
		
		object.setName(product.getName());
		object.setProduct_id(product.getProduct_id());
		object.setDescription(product.getDescription());
		object.setPrice(product.getPrice());
		object.setImagefilename(product.getImagefilename());
		object.setThree_emi_value_gold(emi_obj_three.getEmi_value_gold());
		object.setThree_emi_value_titanium(emi_obj_three.getEmi_value_titanium());
		object.setSix_emi_value_gold(emi_obj_six.getEmi_value_gold());
		object.setSix_emi_value_titanium(emi_obj_six.getEmi_value_titanium());
		object.setNine_emi_value_gold(emi_obj_nine.getEmi_value_gold());
		object.setNine_emi_value_titanium(emi_obj_nine.getEmi_value_titanium());
		object.setTwelve_emi_value_gold(emi_obj_twelve.getEmi_value_gold());
		object.setTwelve_emi_value_titanium(emi_obj_twelve.getEmi_value_titanium());
		
		return object;
	}

	
}
