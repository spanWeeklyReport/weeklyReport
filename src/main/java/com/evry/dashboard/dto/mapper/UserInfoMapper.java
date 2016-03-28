package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.UserInfo;

public class UserInfoMapper 
{
	
	public UserInfoView getMappedView(UserInfo userInfo)
	{
		UserInfoView userInfoView = new UserInfoView();
		userInfoView.setUserName(userInfo.getUserName());
		userInfoView.setPassword(userInfo.getPassword());
		return userInfoView;
	}

	public UserInfo getMappedEntity(UserInfoView userInfoView)
	{
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userInfoView.getUserName());
		userInfo.setPassword(userInfoView.getPassword());
		return userInfo;
	}

}
