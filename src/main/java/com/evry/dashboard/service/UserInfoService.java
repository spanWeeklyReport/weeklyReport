package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.UserInfo;

public interface UserInfoService 
{
	void addUser(UserInfoView userInfo);
	public List<UserInfoView> getUsers();
	String isValid(UserInfoView userInfo);
	String logout();
	public void addUserDetails(UserInfoView userInfoView);
	String deleteUsers (UserInfoView userInfoView);
	public String editUsers(UserInfoView userInfoView);
	public String modifyUser(UserInfoView userInfoView);
	public void sendEmail(UserInfoView userInfoView);
	public void sendEmailAll (UserInfoView userInfoView);
	 public void sendMail(UserInfoView userInfoView);
	 public boolean renderScreen();
	 public String renderHome(TaskDetailsView taskDetailsView);
	 public void sendHRMail();
	 public List<String> getfirstName();
	
	
}
