package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.UserInfo;

public interface UserInfoDAO
{
	//void add(UserInfo userInfo);
	Query getUsers();
	boolean isValid(UserInfo userInfo);
	 public void addUsers(UserInfo userInfo);
}
