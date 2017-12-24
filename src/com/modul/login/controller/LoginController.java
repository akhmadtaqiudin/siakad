package com.modul.login.controller;

import java.sql.SQLException;
import java.util.Map;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modul.login.services.LoginService;
import com.modul.login.model.Login;

public class LoginController extends CoreAction{

	private static final long serialVersionUID = 1L;private String userName;
	private String password;
	private String hakAkses;
	private Map<String, Object> session;
	private LoginService loginService = (LoginService) new ClassPathXmlApplicationContext("config-db.xml").getBean("loginService");
	
	public String Login(){
		System.out.println("Jalankan Method Login");
		
		try { 
			Login user = new Login(userName, password, hakAkses);
			int x=0;
			x = loginService.cekLogin(user);
			if(x>0){
				session.put("userName",user);
				if(hakAkses.equalsIgnoreCase("admin") && session != null){
					user =(Login) session.get("userName");
					return "admin";
				}else if(hakAkses.equalsIgnoreCase("guru") && session != null){
					user =(Login) session.get("userName");
					return "guru";
				}else if(hakAkses.equalsIgnoreCase("siswa") && session != null){
					user =(Login) session.get("userName");
					return "siswa";
				}else{
					return ERROR;
				}
			}else{
				addFieldError("invalid", "Username & Password Salah");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String LogOut(){
		System.out.println("Jalankan method LogOut");
		session.remove("userName");
		return SUCCESS;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
