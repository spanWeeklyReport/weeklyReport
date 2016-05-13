package com.evry.dashboard.service;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.TaskDetails;

public interface TaskDetailsService {
	
	void addTasks(TaskDetailsView taskDetails);
	void checkTasks(TaskDetailsView taskDetails);
	boolean renderScreen();
	String addRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView);
    String deleteRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView);
    void viewReport(TaskDetailsView taskDetailsView);
    void DataListener(ValueChangeEvent e);
    public String checkReport(TaskDetailsView taskDetailsView);
	
	
    
}
