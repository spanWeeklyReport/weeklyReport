package com.evry.dashboard.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

public class UserInfoMapper {

	
	public void MapView(UserInfoView userInfoView, UserInfo userInfo) {
		
		userInfoView.setFirstName(userInfo.getFirstName());
		userInfoView.setLastName(userInfo.getLastName());
		userInfoView.setUserName(userInfo.getUserName());
		// userInfoView.setLoginUsername(userInfo.getUserName());
		userInfoView.setPassword(userInfo.getPassword());
		userInfoView.setUserRole(userInfo.getUserRole());
		
	}

	
	public UserInfo getMappedEntity(UserInfoView userInfoView) {
		UserInfo userInfo = new UserInfo();
		userInfo.setOid(userInfoView.getuId());
		userInfo.setFirstName(userInfoView.getFirstName());
		userInfo.setLastName(userInfoView.getLastName());
		userInfo.setUserName(userInfoView.getUserName());
		userInfo.setPassword(userInfoView.getPassword());
		// userInfo.setUserName(userInfoView.getLoginUsername());
		userInfo.setUserRole(userInfoView.getUserRole());
		return userInfo;
	}
	
	
	public List<UserInfoView> getMappedView(List<UserInfo> userInfo2) {
		List<UserInfoView> userInfoViews = new ArrayList<UserInfoView>();
		for (UserInfo userInfo : userInfo2) {
			UserInfoView userInfoView = new UserInfoView();

			MapView(userInfoView, userInfo);
			userInfoViews.add(userInfoView);
		}

		return userInfoViews;
	}
	
	public UserInfoView getMapView(UserInfo userInfo) {
		
		UserInfoView userInfoView = new UserInfoView();
		userInfoView.setuId(userInfo.getOid());
		userInfoView.setFirstName(userInfo.getFirstName());
		userInfoView.setLastName(userInfo.getLastName());
		userInfoView.setUserName(userInfo.getUserName());
		// userInfoView.setLoginUsername(userInfo.getUserName());
		userInfoView.setPassword(userInfo.getPassword());
		userInfoView.setUserRole(userInfo.getUserRole());
		return userInfoView;
		
		
	}

	

}
