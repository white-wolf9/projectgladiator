package com.lti.paysmart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_CREDENTIAL")
public class Credential {

	
	@Id
	@GeneratedValue
	@Column(name = "credential_id")
	private long credential_id;
	private String user_name;
	private String password;
	

	@OneToOne
	@JoinColumn(name = "U_ID")
	private User user;
}
