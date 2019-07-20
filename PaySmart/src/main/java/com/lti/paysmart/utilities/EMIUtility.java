package com.lti.paysmart.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EMIUtility {

	public double calculateInstallmnet(double product_price, double emi_value, double  monthinyears) {
		emi_value=emi_value/(12*100); 
		monthinyears=monthinyears*12; 
        double emi= (product_price*emi_value*Math.pow(1+emi_value,monthinyears))/(Math.pow(1+emi_value,monthinyears)-1);
        return emi;
	}
	
	public void EMIDateCalculate(Calendar cal, int tenure) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		for (int i = 0; i < tenure; i++) {
			cal.add(Calendar.DAY_OF_MONTH, 30);  
	    	String newDate = sdf.format(cal.getTime());  
	    	System.out.println("Date after Addition: "+newDate);	
		}
	}
}
