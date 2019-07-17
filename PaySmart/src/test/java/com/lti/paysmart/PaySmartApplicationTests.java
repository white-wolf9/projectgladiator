package com.lti.paysmart;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.paysmart.dao.ProductDaoImpl;
import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.ProductDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PaySmartApplicationTests {


	@Autowired
	ProductDao pdao;
	
	@Test
	public void contextLoads() {
		/*
		 * Create a new product object, and push it into the database using the addProduct
		 * Since the addProduct function returns the same object assign it to the product
		 * variable
		 */
		Product product = new Product();
		product.setName("name");
		product.setDescription("description");
		product.setImagefilename("name_filename");
		product.setPrice(30000);
		product.setStock(999);
		product = pdao.addProduct(product);
		
		EMI emi = new EMI();
		emi.setEmi_type(EMITypes.THREEMONTHS);
		emi.setEmi_value(3);
		emi.setZero_emi(true);
		emi.setProduct(product);
		pdao.add(emi);
		
		emi.setEmi_type(EMITypes.SIXMONTHS);
		emi.setEmi_value(3.5);
		emi.setZero_emi(true);
		emi.setProduct(product);
		pdao.add(emi);
		
		emi.setEmi_type(EMITypes.NINEMONTHS);
		emi.setEmi_value(4);
		emi.setZero_emi(true);
		emi.setProduct(product);
		pdao.add(emi);
		
		emi.setEmi_type(EMITypes.TWELVEMONTHS); 
		emi.setEmi_value(3.9);
		emi.setZero_emi(true);
		emi.setProduct(product);
		pdao.add(emi);
	}

}
