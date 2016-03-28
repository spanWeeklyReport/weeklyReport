package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

public interface TaskDetailsDAO {
	
	void add(TaskDetails taskDetails);
	TaskDetails getUsers(TaskDetails taskDetails);
	TaskDetails isValid(TaskDetails taskDetails);
	
	
}
