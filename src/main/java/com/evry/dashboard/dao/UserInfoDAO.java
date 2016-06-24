package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.UserInfo;

/**
 * @author Mehak.Sapra
 * DAO Interface for UserInfo
 *
 */
public interface UserInfoDAO
{
	//void add(UserInfo userInfo);
	
	/**
	 * @param userInfo
	 * @return
	 */
	boolean isValid(UserInfo userInfo);
	
	 /**
	 * @param userInfo
	 */
	public void addUsers(UserInfo userInfo);
	 public boolean userExists (UserInfo userInfo);
	 /**
	 * @param userInfo
	 * @return 
	 */
	public String getUserRole(UserInfo userInfo);
	 public String getUserName(UserInfo userInfo);
	 public List<UserInfo> getUsersList();
	 public String deleteUsers(UserInfo userInfo);
	 public UserInfo editUsers(UserInfo userInfo);
}
