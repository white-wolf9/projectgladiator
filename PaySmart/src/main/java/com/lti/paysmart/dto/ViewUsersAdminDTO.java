package com.lti.paysmart.dto;

public class ViewUsersAdminDTO {
	
	private String fname;
	private String lname;
	private String email;
	private long phone_no;
	private String address;
	private String aadharfile;
	private String panfile;
	private long userid;
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadharfile() {
		return aadharfile;
	}
	public void setAadharfile(String aadharfile) {
		this.aadharfile = aadharfile;
	}
	public String getPanfile() {
		return panfile;
	}
	public void setPanfile(String panfile) {
		this.panfile = panfile;
	}
	@Override
	public String toString() {
		return "ViewUsersAdminDTO [fname=" + fname + ", lname=" + lname + ", email=" + email + ", phone_no=" + phone_no
				+ ", address=" + address + ", aadharfile=" + aadharfile + ", panfile=" + panfile + ", userid=" + userid
				+ "]";
	}
	
	

}
