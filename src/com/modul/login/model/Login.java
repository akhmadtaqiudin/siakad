package com.modul.login.model;

public class Login {

	private String userName;
	private String password;
	private String hakAkses;
	
	public Login() {
		super();
	}
	
	public Login(String userName, String password, String hakAkses) {
		super();
		this.userName = userName;
		this.password = password;
		this.hakAkses = hakAkses;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHakAkses() {
		return hakAkses;
	}
	public void setHakAkses(String hakAkses) {
		this.hakAkses = hakAkses;
	}
}
