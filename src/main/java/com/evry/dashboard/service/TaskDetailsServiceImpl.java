package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omg.CORBA.PRIVATE_MEMBER;

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
	private TaskDetailsView taskDetailsView;
		
	public void setTaskDetailsDAO(TaskDetailsDAO taskDetailsDAO) 
	{
		this.taskDetailsDAO = taskDetailsDAO;
	}	

	public void setTaskDetailsMapper(TaskDetailsMapper mapper) 
	{
		this.taskDetailsMapper = mapper;
	}

	public void addTasks(TaskDetailsView taskDetailsView) 
	{
		TaskDetails obj = taskDetailsMapper.getMappedEntity(taskDetailsView);
		taskDetailsDAO.addTasks(obj);
	}
	
	public void setRiskDetailsMapper(RiskDetailsMapper riskDeatilsMapper) {
		this.riskDetailsMapper = riskDeatilsMapper;
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
	}

	public boolean renderScreen() {
		
		
	//System.out.println("hiieee");
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
		 		 
		 RiskDetailsView risk = riskDetailsMapper.getMappedView(riskDetailsView);
		 taskDetailsView.getRiskDetailsList().add(risk);
		 return null;
		 
		}  
	 
	 public String deleteRisks(TaskDetailsView taskDetailsView, RiskDetailsView riskDetailsView) {
		    
		 taskDetailsView.getRiskDetailsList().remove(riskDetailsView);
		 return null;
		}

	 

}
