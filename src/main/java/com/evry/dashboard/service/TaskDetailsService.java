package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.model.TaskDetails;

public interface TaskDetailsService {
	
	void addTasks(TaskDetailsView taskDetails);
	void checkTasks(TaskDetailsView taskDetails);
	boolean renderScreen();
	public String logout();
	
	
    
}
