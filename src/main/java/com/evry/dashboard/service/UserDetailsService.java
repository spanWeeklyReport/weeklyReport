package com.evry.dashboard.service;

import java.util.List;
import com.evry.dashboard.dto.UserDetailsView;

public interface UserDetailsService 
{
	void addUser(UserDetailsView userDetails);
	List<UserDetailsView> getUsers();
	boolean isValid(UserDetailsView userInfo);
}
