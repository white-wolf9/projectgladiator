package com.lti.paysmart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_BANK")
public class BankDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "bank_details_id")
	private long bank_details_id;
	private String bank_name;
	private long acc_no;
	private String ifsc_code;
	

	@OneToOne
	@JoinColumn(name = "U_ID")
	private User user;


	public long getBank_details_id() {
		return bank_details_id;
	}


	public void setBank_details_id(long bank_details_id) {
		this.bank_details_id = bank_details_id;
	}


	public String getBank_name() {
		return bank_name;
	}


	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}


	public long getAcc_no() {
		return acc_no;
	}


	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}


	public String getIfsc_code() {
		return ifsc_code;
	}


	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
