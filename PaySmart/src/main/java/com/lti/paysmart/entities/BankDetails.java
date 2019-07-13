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

}
