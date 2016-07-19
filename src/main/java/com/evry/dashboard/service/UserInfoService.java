package com.evry.dashboard.service;

import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.UserInfo;

public interface UserInfoService 
{
	void addUser(UserInfoView userInfo);
	void getUsers();
	String isValid(UserInfoView userInfo);
	String logout();
	public void addUserDetails(UserInfoView userInfoView);
	String deleteUsers (UserInfoView userInfoView);
	//public String editUsers(UserInfoView userInfoView);
}
