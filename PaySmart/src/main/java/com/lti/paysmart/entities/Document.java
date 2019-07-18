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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_PROJ_DOC")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "DOCUMENT_ID")
	private long document_id;
	private String aadharcardfilename;
	private String pancardfilename;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
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
