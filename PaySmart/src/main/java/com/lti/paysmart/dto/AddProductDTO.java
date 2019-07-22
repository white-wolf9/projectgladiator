package com.lti.paysmart.dto;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDTO {
	
	private String product_name;
	private String product_description;
	private String product_keywords;
	private double product_price;
	private int product_stock;
	private MultipartFile product_image;
	private double emi_three_gold;
	private double emi_six_gold;
	private double emi_nine_gold;
	private double emi_twelve_gold;
	private double emi_three_titanium;
	private double emi_six_titanium;
	private double emi_nine_titanium;
	private double emi_twelve_titanium;
	
	
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
	public double getEmi_three_gold() {
		return emi_three_gold;
	}
	public void setEmi_three_gold(double emi_three_gold) {
		this.emi_three_gold = emi_three_gold;
	}
	public double getEmi_six_gold() {
		return emi_six_gold;
	}
	public void setEmi_six_gold(double emi_six_gold) {
		this.emi_six_gold = emi_six_gold;
	}
	public double getEmi_nine_gold() {
		return emi_nine_gold;
	}
	public void setEmi_nine_gold(double emi_nine_gold) {
		this.emi_nine_gold = emi_nine_gold;
	}
	public double getEmi_twelve_gold() {
		return emi_twelve_gold;
	}
	public void setEmi_twelve_gold(double emi_twelve_gold) {
		this.emi_twelve_gold = emi_twelve_gold;
	}
	public double getEmi_three_titanium() {
		return emi_three_titanium;
	}
	public void setEmi_three_titanium(double emi_three_titanium) {
		this.emi_three_titanium = emi_three_titanium;
	}
	public double getEmi_six_titanium() {
		return emi_six_titanium;
	}
	public void setEmi_six_titanium(double emi_six_titanium) {
		this.emi_six_titanium = emi_six_titanium;
	}
	public double getEmi_nine_titanium() {
		return emi_nine_titanium;
	}
	public void setEmi_nine_titanium(double emi_nine_titanium) {
		this.emi_nine_titanium = emi_nine_titanium;
	}
	public double getEmi_twelve_titanium() {
		return emi_twelve_titanium;
	}
	public void setEmi_twelve_titanium(double emi_twelve_titanium) {
		this.emi_twelve_titanium = emi_twelve_titanium;
	}
	public String getProduct_keywords() {
		return product_keywords;
	}
	public void setProduct_keywords(String product_keywords) {
		this.product_keywords = product_keywords;
	}
	

}
