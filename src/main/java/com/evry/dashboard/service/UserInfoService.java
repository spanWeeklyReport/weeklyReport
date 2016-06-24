package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.UserInfo;

public interface UserInfoService 
{
	void addUser(UserInfoView userInfo);
	List<UserInfoView> getUsers();
	String isValid(UserInfoView userInfo);
	String logout();
	public void addUserDetails(UserInfoView userInfoView);
	String deleteUsers (UserInfoView userInfoView);
<<<<<<< HEAD
	void editUsers (UserInfoView userInfoView);
=======
>>>>>>> branch 'master' of https://github.com/spanWeeklyReport/weeklyReport.git
	
}
