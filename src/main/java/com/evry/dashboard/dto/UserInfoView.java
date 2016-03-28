package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="userInfo")
public class UserInfoView 
{
	private String userName;
	private String password;
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
}
