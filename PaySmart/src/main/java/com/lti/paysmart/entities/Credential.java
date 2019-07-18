package com.lti.paysmart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_CREDENTIAL")
public class Credential {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "CREDENTIAL_ID")
	private long credential_id;
	private String username;
	private String password;
	

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "ADMIN_ID")
	Admin admin;


	public long getCredential_id() {
		return credential_id;
	}


	public void setCredential_id(long credential_id) {
		this.credential_id = credential_id;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
