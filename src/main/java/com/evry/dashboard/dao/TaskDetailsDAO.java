package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

public interface TaskDetailsDAO {
	
	void addTasks(TaskDetails taskDetails);
	TaskDetails getTasks(TaskDetails taskDetails);
	TaskDetails checkTasks(TaskDetails taskDetails);
	
	
}
