package com.lti.paysmart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.paysmart.entities.EMI;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.enums.EMITypes;
import com.lti.paysmart.interfaces.ProductDao;
import com.lti.paysmart.utilities.CardNumberGenerator;
import com.lti.paysmart.utilities.EMIUtility;

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
		/*
		 * Product product = new Product(); product.setName("name");
		 * product.setDescription("description");
		 * product.setImagefilename("name_filename"); product.setPrice(30000);
		 * product.setStock(999); product = pdao.addProduct(product);
		 * 
		 * EMI emi = new EMI(); emi.setEmi_type(EMITypes.THREEMONTHS);
		 * emi.setEmi_value(3); emi.setZero_emi(true); emi.setProduct(product);
		 * pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.SIXMONTHS); emi.setEmi_value(3.5);
		 * emi.setZero_emi(true); emi.setProduct(product); pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.NINEMONTHS); emi.setEmi_value(4);
		 * emi.setZero_emi(true); emi.setProduct(product); pdao.add(emi);
		 * 
		 * emi.setEmi_type(EMITypes.TWELVEMONTHS); emi.setEmi_value(3.9);
		 * emi.setZero_emi(true); emi.setProduct(product); pdao.add(emi);
		 */
		
		/*
		 * CardNumberGenerator cng = new CardNumberGenerator();
		 * System.out.println((cng.generate("2847", 16)));
		 */
		
		/*
		 * EMIUtility eu = new EMIUtility();
		 * System.out.println(eu.calculateInstallmnet(30000, 0.01, 0.25));
		 */
		
		/*
		 * Calendar cal = Calendar.getInstance(); Displaying current date in the desired
		 * format System.out.println("Current Date: "+sdf.format(cal.getTime())); Number
		 * of Days to add eu.EMIDateCalculate(cal, 2);
		 */
		/*
		 * Date date = new Date(); Calendar calendar = Calendar.getInstance();
		 * calendar.setTime(date); System.out.println(calendar.getTime());
		 */
		
		/*
		 * Calendar cal = Calendar.getInstance(); // Printing the calendar object
		 * System.out.println(cal.getTime().toString()); // Creating a date time format
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Creating a
		 * string that changes the calendar instance to a string String newDate =
		 * sdf.format(cal.getTime()); // Parsing the string into a date try { Date
		 * date1=new SimpleDateFormat("dd-MM-yyyy").parse(newDate);
		 * System.out.println(date1); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println(sdf.parse(date.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

