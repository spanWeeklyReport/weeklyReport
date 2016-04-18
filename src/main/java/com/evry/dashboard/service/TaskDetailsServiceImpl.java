package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dao.TaskDetailsDAO;
import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.mapper.RiskDetailsMapper;
import com.evry.dashboard.dto.mapper.TaskDetailsMapper;
import com.evry.dashboard.model.RiskDetails;
import com.evry.dashboard.model.TaskDetails;

@ManagedBean(name = "taskDetailsService")
@SessionScoped
public class TaskDetailsServiceImpl implements TaskDetailsService 
{

	private boolean renderer;
	private TaskDetailsMapper taskDetailsMapper;
	private RiskDetailsMapper riskDetailsMapper;
	private TaskDetailsDAO taskDetailsDAO;
	private RiskDetailsDAO riskDetailsDAO;
	private TaskDetailsView taskDetailsView;
	private long riskId;
		
	public void setTaskDetailsDAO(TaskDetailsDAO taskDetailsDAO) 
	{
		this.taskDetailsDAO = taskDetailsDAO;
	}	

	public void setTaskDetailsMapper(TaskDetailsMapper mapper) 
	{
		this.taskDetailsMapper = mapper;
	}
	
	public void setRiskDetailsDAO(RiskDetailsDAO riskDetailsDAO) 
	{
		this.riskDetailsDAO = riskDetailsDAO;
	}	
    
	public void setRiskDetailsMapper(RiskDetailsMapper riskDeatilsMapper) {
		this.riskDetailsMapper = riskDeatilsMapper;
	}


	public void addTasks(TaskDetailsView taskDetailsView) 
	{
//		taskDetailsView.getRiskDetailsList().forEach(
//				detailsView ->
//				{			    	  
//					 RiskDetails details = riskDetailsMapper.getMappedEntity(detailsView);
//					 riskId = riskDetailsDAO.addRisks(details);
//					 detailsView.setRiskId(details.getRiskId());
//				}
//			);
		
		TaskDetails obj = taskDetailsMapper.getMappedEntity(taskDetailsView);
		taskDetailsDAO.addTasks(obj);	
	
	}
		
	public List<TaskDetailsView> getUsers()
	{
		List<TaskDetailsView> taskDetailsViews = new ArrayList();
		return taskDetailsViews;
	}

	public void checkTasks(TaskDetailsView taskDetailsView) 
	{

		renderer = true;
		TaskDetails taskDetails =  taskDetailsDAO.checkTasks(taskDetailsMapper.getMappedEntity(taskDetailsView));
		taskDetailsMapper.mapView(taskDetailsView, taskDetails);
		
        int lastWeek = taskDetails.getWeekNo() - 1;
        
        TaskDetails taskDetailsLastWeek = new TaskDetails();
        taskDetailsLastWeek.setProjectDetails(taskDetails.getProjectDetails());
        taskDetailsLastWeek.setWeekNo(lastWeek);
        
        taskDetails =  taskDetailsDAO.checkTasks(taskDetailsLastWeek);
        taskDetailsView.setLastPlanned(taskDetails.getPlannedTask());
        taskDetailsView.setLastCompleted(taskDetails.getCompletedTask());
        taskDetailsView.setLastHold(taskDetails.getHoldTask());
        taskDetailsView.setLastInProgress(taskDetails.getInprogressTask());

		
	}

	public boolean renderScreen() {
		
		return renderer;
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();		
        return "index.xhtml";
    }
	
	public String showResult(TaskDetailsView taskDetailsView){
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	      fc.getExternalContext().getRequestParameterMap();
	      String data = taskDetailsView.getData();
	      data =  params.get("username"); 
	      return "result";
	   }
	
	 public String addRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView) {
		 		 
		// RiskDetailsView risk = riskDetailsMapper.getMappedView(riskDetailsView);
		 taskDetailsView.getRiskDetailsList().add(riskDetailsView);
		 return null;
		 
		}  
	 
	 public String deleteRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView) {
		    
		 taskDetailsView.getRiskDetailsList().remove(riskDetailsView);
		 return null;
		}

	 

}
