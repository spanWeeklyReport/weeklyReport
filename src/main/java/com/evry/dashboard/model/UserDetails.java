package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER_DETAILS")
public class UserDetails 
{
	@Id
	@Column(name = "OID")
	private long oid;
	
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	public long getOid() 
	{
		return oid;
	}

	public void setOid(long oid) 
	{
		this.oid = oid;
	}

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
