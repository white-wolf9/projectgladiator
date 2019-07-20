package com.lti.paysmart.dto;

public class ProductOrderRequestDTO {
	
	private String user_name;
	private String product_id;
	private String emi_scheme;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_id(String user_name) {
		this.user_name = user_name;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getEmi_scheme() {
		return emi_scheme;
	}
	public void setEmi_scheme(String emi_scheme) {
		this.emi_scheme = emi_scheme;
	}
	
	
}
