package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.evry.dashboard.dao.UserDetailsDAO;
import com.evry.dashboard.dto.UserDetailsView;
import com.evry.dashboard.dto.mapper.UserDetailsMapper;
import com.evry.dashboard.model.UserDetails;

@ManagedBean(name = "UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService 
{

	private UserDetailsMapper mapper;
	private UserDetailsDAO userDetailsDAO;
		
	public void setUserDetailsDAO(UserDetailsDAO UserDetailsDAO) 
	{
		this.userDetailsDAO = userDetailsDAO;
	}	

	public void setMapper(UserDetailsMapper mapper) 
	{
		this.mapper = mapper;
	}

	public void addUser(UserDetailsView UserDetailsView) 
	{
		userDetailsDAO.add(mapper.getMappedEntity(UserDetailsView));
	}

	public List<UserDetailsView> getUsers() 
	{
		List<UserDetails> userDetailss = userDetailsDAO.getUsers();
		List<UserDetailsView> userDetailsViews = new ArrayList();
			for(UserDetails userDetails : userDetailss)			
				userDetailsViews.add(mapper.getMappedView(userDetails));			
		return userDetailsViews;
	}

	public boolean isValid(UserDetailsView userDetailsView) 
	{
		return userDetailsDAO.isValid(mapper.getMappedEntity(userDetailsView));
	}
}
