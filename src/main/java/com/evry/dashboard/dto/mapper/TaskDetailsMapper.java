package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.model.TaskDetails;

public class TaskDetailsMapper 
{
	
	public void mapView(TaskDetailsView taskDetailsView, TaskDetails taskDetails)
	{
		taskDetailsView.setOid(taskDetails.getOid());
		//taskDetailsView.set(taskDetails.getUid());
		taskDetailsView.setProject_Name(taskDetails.getProject_Name());
		taskDetailsView.setWeekNo(taskDetails.getWeekNo());
		taskDetailsView.setPlannedTask(taskDetails.getPlannedTask());
		taskDetailsView.setCompletedTask(taskDetails.getCompletedTask());
		taskDetailsView.setHoldTask(taskDetails.getHoldTask());
		taskDetailsView.setInprogressTask(taskDetails.getInprogressTask());
		taskDetailsView.setRiskDec(taskDetails.getRiskDec());
		taskDetailsView.setRiskResp(taskDetails.getRiskResp());
		taskDetailsView.setSharedResources(taskDetails.getSharedResources());
		taskDetailsView.setBilledResources(taskDetails.getBilledResources());
		taskDetailsView.setProjectInc(taskDetails.getProjectInc());
		taskDetailsView.setProjectDec(taskDetails.getProjectDec());
	}

	public TaskDetails getMappedEntity(TaskDetailsView taskDetailsView)
	{
		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setOid(taskDetailsView.getOid());
		taskDetails.setProject_Name(taskDetailsView.getProject_Name());
		taskDetails.setWeekNo(taskDetailsView.getWeekNo());
		taskDetails.setPlannedTask(taskDetailsView.getPlannedTask());
		taskDetails.setCompletedTask(taskDetailsView.getCompletedTask());
		taskDetails.setHoldTask(taskDetailsView.getHoldTask());
		taskDetails.setInprogressTask(taskDetailsView.getInprogressTask());
		taskDetails.setRiskDec(taskDetailsView.getRiskDec());
		taskDetails.setRiskResp(taskDetailsView.getRiskResp());
		taskDetails.setSharedResources(taskDetailsView.getSharedResources());
		taskDetails.setBilledResources(taskDetailsView.getBilledResources());
		taskDetails.setProjectInc(taskDetailsView.getProjectInc());
		taskDetails.setProjectDec(taskDetailsView.getProjectDec());
		return taskDetails;
	}

}
