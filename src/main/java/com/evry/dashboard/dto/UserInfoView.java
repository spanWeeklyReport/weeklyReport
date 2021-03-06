package com.evry.dashboard.dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "userInfo")
@SessionScoped
public class UserInfoView implements Serializable {
	private static final long serialVersionUID = 7016146540858290775L;
	private long uId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String userRole;
	boolean editable;
	
	
	/**
	 * @Getters and setters
	 */
	
	
	
	public boolean isEditable() {
		return editable;
	}
	public long getuId() {
		return uId;
	}
	public void setuId(long uId) {
		this.uId = uId;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	

}
