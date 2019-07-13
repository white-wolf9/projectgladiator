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


	public long getCredential_id() {
		return credential_id;
	}


	public void setCredential_id(long credential_id) {
		this.credential_id = credential_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
