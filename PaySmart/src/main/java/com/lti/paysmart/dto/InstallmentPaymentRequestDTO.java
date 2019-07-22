package com.lti.paysmart.dto;

public class InstallmentPaymentRequestDTO {
	
	private String username;
	private long payment_id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}
	
	

}
