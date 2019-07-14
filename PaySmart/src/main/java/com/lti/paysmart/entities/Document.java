package com.lti.paysmart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_DOC")
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name = "DOCUMENT_ID")
	private long document_id;
	private String aadharcardfilename;
	private String pancardfilename;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public long getDocument_id() {
		return document_id;
	}

	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}

	public String getAadharcardfilename() {
		return aadharcardfilename;
	}

	public void setAadharcardfilename(String aadharcardfilename) {
		this.aadharcardfilename = aadharcardfilename;
	}

	public String getPancardfilename() {
		return pancardfilename;
	}

	public void setPancardfilename(String pancardfilename) {
		this.pancardfilename = pancardfilename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
