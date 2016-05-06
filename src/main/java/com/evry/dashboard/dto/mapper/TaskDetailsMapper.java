package com.evry.dashboard.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.evry.dashboard.dao.ProjectDetailsDAO;
import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.RiskDetails;

public class TaskDetailsMapper 
{
	
	private ProjectDetailsDAO projectDetailsDAO;
	private RiskDetailsDAO riskDetailsDAO;
	private RiskDetailsMapper riskDetailsMapper;
	
	
	
	public void setProjectDetailsDAO(ProjectDetailsDAO projectDetailsDAO) 
	{
		this.projectDetailsDAO = projectDetailsDAO;
	}
	
	public void setRiskDetailsDAO(RiskDetailsDAO riskDetailsDAO) 
	{
		this.riskDetailsDAO = riskDetailsDAO;
	}
	
	public void setRiskDetailsMapper(RiskDetailsMapper riskDetailsMapper) 
	{
		this.riskDetailsMapper = riskDetailsMapper;
	}

	
	//Get Map View
	public void mapView(TaskDetailsView taskDetailsView, TaskDetails taskDetails)
	{
		taskDetailsView.setTaskId(taskDetails.getTaskId());
			try
			{
				taskDetailsView.setProjectDetailsName(taskDetails.getProjectDetails().getProjectName());
			}
			catch(Exception e)
			{
				taskDetailsView.setProjectDetailsName("");
			}
		taskDetailsView.setWeekNo(taskDetails.getWeekNo());
		//taskDetailsView.setYearNo(taskDetails.getYearNo());
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
		//taskDetailsView.setRiskDetailsList(taskDetails.getRiskDetailsList());
		
		List<RiskDetailsView> list2 = taskDetailsView.getRiskDetailsList();
		list2.clear();
				 
		ListIterator litr = taskDetails.getRiskDetails().listIterator();
	      while(litr.hasNext()) {
  
	         
	    	      list2.add(riskDetailsMapper.getMappedView((RiskDetails)litr.next()));
	      }
		
    	
		
		
	}
    
	
	//Get Entity
	public TaskDetails getMappedEntity(TaskDetailsView taskDetailsView)
	{
		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setTaskId(taskDetailsView.getTaskId());
		taskDetails.setProjectDetails(projectDetailsDAO.findByName(taskDetailsView.getProjectDetailsName()));
		taskDetails.setWeekNo(taskDetailsView.getWeekNo());
		//taskDetails.setYearNo(taskDetailsView.getYearNo());
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
		List<RiskDetails> list = new ArrayList<RiskDetails>();
		
		 RiskDetailsView riskDetailsView = new RiskDetailsView();
		 
		ListIterator litr = taskDetailsView.getRiskDetailsList().listIterator();
	      while(litr.hasNext()) {
   
	         
	    	 //Object element = litr.next();
	        list.add(riskDetailsMapper.getMappedEntity((RiskDetailsView)litr.next()));
	      }
		
     	taskDetails.setRiskDetails(list);
	    return taskDetails;
	}
	
	  public TaskDetails getLastWeekMappedEntity(TaskDetailsView taskDetailsView)
      {
                      TaskDetails taskDetails = new TaskDetails();
                      taskDetails.setTaskId(taskDetailsView.getLastTaskId());  
                      taskDetails.setPlannedTask(taskDetailsView.getLastPlanned());
                      taskDetails.setCompletedTask(taskDetailsView.getLastCompleted());
                      taskDetails.setHoldTask(taskDetailsView.getLastHold());
                      taskDetails.setInprogressTask(taskDetailsView.getLastInProgress());
                       
          return taskDetails;
      }


}
