package com.evry.dashboard.service;

import java.util.List;
import com.evry.dashboard.dto.UserInfoView;

public interface UserInfoService 
{
	void addUser(UserInfoView userInfo);
	List<UserInfoView> getUsers();
	boolean isValid(UserInfoView userInfo);
}
