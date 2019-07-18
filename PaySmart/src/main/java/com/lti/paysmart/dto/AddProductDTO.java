package com.lti.paysmart.dto;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDTO {
	
	private String product_name;
	private String product_description;
	private double product_price;
	private int product_stock;
	private MultipartFile product_image;
	private double emi_three;
	private double emi_six;
	private double emi_nine;
	private double emi_twelve;
	/*
	 * private boolean emi_three_zero; private boolean emi_six_zero; private boolean
	 * emi_nine_zero; private boolean emi_twelve_zero;
	 */
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public MultipartFile getProduct_image() {
		return product_image;
	}
	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}
	public double getEmi_three() {
		return emi_three;
	}
	public void setEmi_three(double emi_three) {
		this.emi_three = emi_three;
	}
	public double getEmi_six() {
		return emi_six;
	}
	public void setEmi_six(double emi_six) {
		this.emi_six = emi_six;
	}
	public double getEmi_nine() {
		return emi_nine;
	}
	public void setEmi_nine(double emi_nine) {
		this.emi_nine = emi_nine;
	}
	public double getEmi_twelve() {
		return emi_twelve;
	}
	public void setEmi_twelve(double emi_twelve) {
		this.emi_twelve = emi_twelve;
	}
	/*
	 * public boolean isEmi_three_zero() { return emi_three_zero; } public void
	 * setEmi_three_zero(boolean emi_three_zero) { this.emi_three_zero =
	 * emi_three_zero; } public boolean isEmi_six_zero() { return emi_six_zero; }
	 * public void setEmi_six_zero(boolean emi_six_zero) { this.emi_six_zero =
	 * emi_six_zero; } public boolean isEmi_nine_zero() { return emi_nine_zero; }
	 * public void setEmi_nine_zero(boolean emi_nine_zero) { this.emi_nine_zero =
	 * emi_nine_zero; } public boolean isEmi_twelve_zero() { return emi_twelve_zero;
	 * } public void setEmi_twelve_zero(boolean emi_twelve_zero) {
	 * this.emi_twelve_zero = emi_twelve_zero; }
	 */
	
	

}
