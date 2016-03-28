package com.evry.dashboard.dao;

import java.util.List;

import com.evry.dashboard.model.UserInfo;

public interface UserInfoDAO
{
	void add(UserInfo userInfo);
	List<UserInfo> getUsers();
	boolean isValid(UserInfo userInfo);
}
