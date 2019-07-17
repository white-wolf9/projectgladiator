package com.lti.paysmart.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.lti.paysmart.enums.CardTypes;

public class UserRegisterDTO {
	
	/*
	 * Basic details of the user.
	 */
	private String fname;
	private String lname;
	private String email;
	private long phone_no;
	private Date dob;
	/*
	 * Credentials of the user
	 */
	private String username;
	private String password;
	/*
	 * Bank details of the user
	 */
	private String bankname;
	private String acc_no;
	private String ifsc_code;
	/*
	 * Address of the user
	 */
	private String city;
	private String doorno; 
	private String street; 
	private long pincode;
	/*
	 * Documents of the user
	 */
	private MultipartFile aadharcard;
	private MultipartFile pancard;
	/*
	 * Card details of the user
	 */
	private CardTypes cardtype;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public MultipartFile getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(MultipartFile aadharcard) {
		this.aadharcard = aadharcard;
	}
	public MultipartFile getPancard() {
		return pancard;
	}
	public void setPancard(MultipartFile pancard) {
		this.pancard = pancard;
	}
	public CardTypes getCardtype() {
		return cardtype;
	}
	public void setCardtype(CardTypes cardtype) {
		this.cardtype = cardtype;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
