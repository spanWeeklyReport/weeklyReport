package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dao.ProjectDetailsDAO;
import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;

public class TaskDetailsMapper 
{
	
	private ProjectDetailsDAO projectDetailsDAO;
	private RiskDetailsDAO riskDetailsDAO;
	
	
	
	public void setProjectDetailsDAO(ProjectDetailsDAO projectDetailsDAO) 
	{
		this.projectDetailsDAO = projectDetailsDAO;
	}
	
	public void setRiskDetailsDAO(RiskDetailsDAO riskDetailsDAO) 
	{
		this.riskDetailsDAO = riskDetailsDAO;
	}

	public void mapView(TaskDetailsView taskDetailsView, TaskDetails taskDetails)
	{
		taskDetailsView.setOid(taskDetails.getOid());
		//taskDetailsView.set(taskDetails.getUid());
			try
			{
				taskDetailsView.setProjectDetailsName(taskDetails.getProjectDetails().getProjectName());
			}
			catch(Exception e)
			{
				taskDetailsView.setProjectDetailsName("");
			}
		taskDetailsView.setWeekNo(taskDetails.getWeekNo());
		taskDetailsView.setPlannedTask(taskDetails.getPlannedTask());
		taskDetailsView.setCompletedTask(taskDetails.getCompletedTask());
		taskDetailsView.setHoldTask(taskDetails.getHoldTask());
		taskDetailsView.setInprogressTask(taskDetails.getInprogressTask());
		taskDetailsView.setSharedResources(taskDetails.getSharedResources());
		taskDetailsView.setBilledResources(taskDetails.getBilledResources());
		taskDetailsView.setProjectIncB(taskDetails.getProjectIncB());
		taskDetailsView.setProjectDecB(taskDetails.getProjectDecB());
		taskDetailsView.setProjectIncSh(taskDetails.getProjectIncSh());
		taskDetailsView.setProjectDecSh(taskDetails.getProjectDecSh());
		taskDetailsView.setProjectUpdates(taskDetails.getProjectUpdates());
		taskDetailsView.setResourceLoadingB(taskDetails.getResourceLoadingB());
		taskDetailsView.setResourceLoadingSh(taskDetails.getResourceLoadingSh());
		//taskDetailsView.setRiskDetailsList(taskDetails.getRiskDetails());
		
	}

	public TaskDetails getMappedEntity(TaskDetailsView taskDetailsView)
	{
		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setOid(taskDetailsView.getOid());
		taskDetails.setProjectDetails(projectDetailsDAO.findByName(taskDetailsView.getProjectDetailsName()));
		taskDetails.setWeekNo(taskDetailsView.getWeekNo());
		taskDetails.setPlannedTask(taskDetailsView.getPlannedTask());
		taskDetails.setCompletedTask(taskDetailsView.getCompletedTask());
		taskDetails.setHoldTask(taskDetailsView.getHoldTask());
		taskDetails.setInprogressTask(taskDetailsView.getInprogressTask());
		taskDetails.setSharedResources(taskDetailsView.getSharedResources());
		taskDetails.setBilledResources(taskDetailsView.getBilledResources());
		taskDetails.setProjectIncB(taskDetailsView.getProjectIncB());
		taskDetails.setProjectDecB(taskDetailsView.getProjectDecB());
		taskDetails.setProjectIncSh(taskDetailsView.getProjectIncSh());
		taskDetails.setProjectDecSh(taskDetailsView.getProjectDecSh());
		taskDetails.setProjectUpdates(taskDetailsView.getProjectUpdates());
		taskDetails.setResourceLoadingB(taskDetailsView.getResourceLoadingB());
		taskDetails.setResourceLoadingSh(taskDetailsView.getResourceLoadingSh());	
//		taskDetails.setRiskDetails(riskDetailsDAO.(taskDetailsView.getRiskDetailsList()));
	    return taskDetails;
	}

}
