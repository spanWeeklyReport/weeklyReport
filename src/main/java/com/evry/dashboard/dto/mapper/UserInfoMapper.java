package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.UserInfo;

public class UserInfoMapper {

	/**
	 * @param userInfo
	 * @return
	 */
	public UserInfoView getMappedView(UserInfo userInfo) {
		UserInfoView userInfoView = new UserInfoView();
		userInfoView.setFirstName(userInfo.getFirstName());
		userInfoView.setLastName(userInfo.getLastName());
		userInfoView.setUserName(userInfo.getUserName());
		// userInfoView.setLoginUsername(userInfo.getUserName());
		userInfoView.setPassword(userInfo.getPassword());
		userInfoView.setUserRole(userInfo.getUserRole());
		return userInfoView;
	}

	/**
	 * @param userInfoView
	 * @return
	 */
	public UserInfo getMappedEntity(UserInfoView userInfoView) {
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName(userInfoView.getFirstName());
		userInfo.setLastName(userInfoView.getLastName());
		userInfo.setUserName(userInfoView.getUserName());
		userInfo.setPassword(userInfoView.getPassword());
		// userInfo.setUserName(userInfoView.getLoginUsername());
		userInfo.setUserRole(userInfoView.getUserRole());
		return userInfo;
	}

}
