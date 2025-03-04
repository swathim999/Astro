package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetails {
	String userName;
	String dob;
	String bop;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBop() {
		return bop;
	}
	public void setBop(String bop) {
		this.bop = bop;
	}
}
