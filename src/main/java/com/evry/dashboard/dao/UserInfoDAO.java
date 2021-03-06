package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

/**
 * @author Mehak.Sapra
 * DAO Interface for UserInfo
 *
 */
public interface UserInfoDAO
{
		
	boolean isValid(UserInfo userInfo);
    public void addUsers(UserInfo userInfo);
	 public boolean userExists (UserInfo userInfo);
	 public List<UserInfo> getUsersList();
	 public String deleteUsers(UserInfo userInfo);
	 public UserInfo editUsers(UserInfo userInfo);
	 public long getUserID(UserInfo userInfo);
	 public UserInfo getUserByID(Long id);
	 public List<UserInfo> employeeReportStatus(UserInfo userInfo, int weekNo);
	 public void modifyUser(UserInfo userInfo);
	 public List<String> firstNameList();
	 public UserInfo findFirstName(String firstName);

}
