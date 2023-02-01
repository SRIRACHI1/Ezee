package com.example.userservice.securityconfig;

import java.util.Date;

public class AuthenticationRequest {
	private String email;
	private String password;
	private String username;
	private String phone;
	private Date insertDate;
	private Date ExpireDate;

	public AuthenticationRequest()
	{
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getExpireDate() {
		return ExpireDate;
	}

	public void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	
}
