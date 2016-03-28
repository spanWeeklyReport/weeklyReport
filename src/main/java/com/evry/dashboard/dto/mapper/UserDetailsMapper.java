package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.UserDetailsView;
import com.evry.dashboard.model.UserDetails;

public class UserDetailsMapper 
{
	
	public UserDetailsView getMappedView(UserDetails userDetails)
	{
		UserDetailsView userDetailsView = new UserDetailsView();
		userDetailsView.setUserName(userDetails.getUserName());
		userDetailsView.setPassword(userDetails.getPassword());
		return userDetailsView;
	}

	public UserDetails getMappedEntity(UserDetailsView userDetailsView)
	{
		UserDetails UserDetails = new UserDetails();
		UserDetails.setUserName(userDetailsView.getUserName());
		UserDetails.setPassword(userDetailsView.getPassword());
		return UserDetails;
	}

}
