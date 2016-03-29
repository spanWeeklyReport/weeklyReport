package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.UserInfo;

@ManagedBean(name = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService 
{

	private UserInfoMapper mapper;
	private UserInfoDAO userInfoDAO;
		
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) 
	{
		this.userInfoDAO = userInfoDAO;
	}	

	public void setMapper(UserInfoMapper mapper) 
	{
		this.mapper = mapper;
	}

	public void addUser(UserInfoView userInfoView) 
	{
		UserInfo obj = mapper.getMappedEntity(userInfoView);
	//	userInfoDAO.add(obj);
	}

	public List<UserInfoView> getUsers() 
	{
		List<UserInfo> userInfos = (List<UserInfo>) userInfoDAO.getUsers();
		List<UserInfoView> userInfoViews = new ArrayList();
			for(UserInfo userInfo : userInfos)			
				userInfoViews.add(mapper.getMappedView(userInfo));			
		return userInfoViews;
	}

	public boolean isValid(UserInfoView userInfoView) 
	{
		return userInfoDAO.isValid(mapper.getMappedEntity(userInfoView));
	}
}
