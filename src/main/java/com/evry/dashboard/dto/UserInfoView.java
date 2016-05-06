package com.evry.dashboard.dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="userInfo")
@SessionScoped
public class UserInfoView implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7016146540858290775L;
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
