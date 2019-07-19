package com.lti.paysmart.dto;

public class ViewProductDetailedDTO {

	private long product_id;
	private String name;
	private String description;
	private String imagefilename;
	private double price;

	private double three_emi_value_gold;
	private double three_emi_value_titanium;
	

	private double six_emi_value_gold;
	private double six_emi_value_titanium;
	

	private double nine_emi_value_gold;
	private double nine_emi_value_titanium;
	

	private double twelve_emi_value_gold;
	private double twelve_emi_value_titanium;
	
	
	public double getThree_emi_value_gold() {
		return three_emi_value_gold;
	}
	public void setThree_emi_value_gold(double three_emi_value_gold) {
		this.three_emi_value_gold = three_emi_value_gold;
	}
	public double getThree_emi_value_titanium() {
		return three_emi_value_titanium;
	}
	public void setThree_emi_value_titanium(double three_emi_value_titanium) {
		this.three_emi_value_titanium = three_emi_value_titanium;
	}
	public double getSix_emi_value_gold() {
		return six_emi_value_gold;
	}
	public void setSix_emi_value_gold(double six_emi_value_gold) {
		this.six_emi_value_gold = six_emi_value_gold;
	}
	public double getSix_emi_value_titanium() {
		return six_emi_value_titanium;
	}
	public void setSix_emi_value_titanium(double six_emi_value_titanium) {
		this.six_emi_value_titanium = six_emi_value_titanium;
	}
	public double getNine_emi_value_gold() {
		return nine_emi_value_gold;
	}
	public void setNine_emi_value_gold(double nine_emi_value_gold) {
		this.nine_emi_value_gold = nine_emi_value_gold;
	}
	public double getNine_emi_value_titanium() {
		return nine_emi_value_titanium;
	}
	public void setNine_emi_value_titanium(double nine_emi_value_titanium) {
		this.nine_emi_value_titanium = nine_emi_value_titanium;
	}
	public double getTwelve_emi_value_gold() {
		return twelve_emi_value_gold;
	}
	public void setTwelve_emi_value_gold(double twelve_emi_value_gold) {
		this.twelve_emi_value_gold = twelve_emi_value_gold;
	}
	public double getTwelve_emi_value_titanium() {
		return twelve_emi_value_titanium;
	}
	public void setTwelve_emi_value_titanium(double twelve_emi_value_titanium) {
		this.twelve_emi_value_titanium = twelve_emi_value_titanium;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagefilename() {
		return imagefilename;
	}
	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
