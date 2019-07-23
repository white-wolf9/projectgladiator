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
	
}
