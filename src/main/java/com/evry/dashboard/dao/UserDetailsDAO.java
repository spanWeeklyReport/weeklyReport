package com.evry.dashboard.dao;

import java.util.List;

import com.evry.dashboard.model.UserDetails;

public interface UserDetailsDAO
{
	void add(UserDetails userInfo);
	List<UserDetails> getUsers();
	boolean isValid(UserDetails userDetails);
}
