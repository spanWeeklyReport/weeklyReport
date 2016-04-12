package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.model.TaskDetails;

public interface TaskDetailsService {
	
	void addTasks(TaskDetailsView taskDetails);
	void checkTasks(TaskDetailsView taskDetails);
	boolean renderScreen();
	String logout();
	public String showResult(TaskDetailsView taskDetailsView);
    String addRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView);
    String deleteRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView);
	
	
	
    
}
