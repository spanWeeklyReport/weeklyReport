package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.evry.dashboard.dao.TaskDetailsDAO;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.mapper.TaskDetailsMapper;
import com.evry.dashboard.model.TaskDetails;

@ManagedBean(name = "taskDetailsService")
@SessionScoped
public class TaskDetailsServiceImpl implements TaskDetailsService 
{

	private boolean renderer;
	private TaskDetailsMapper mapper;
	private TaskDetailsDAO taskDetailsDAO;
	private TaskDetailsView taskDetailsView;
		
	public void setTaskDetailsDAO(TaskDetailsDAO taskDetailsDAO) 
	{
		this.taskDetailsDAO = taskDetailsDAO;
	}	

	public void setMapper(TaskDetailsMapper mapper) 
	{
		this.mapper = mapper;
	}

	public void addTasks(TaskDetailsView taskDetailsView) 
	{
		TaskDetails obj = mapper.getMappedEntity(taskDetailsView);
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
		TaskDetails taskDetails =  taskDetailsDAO.checkTasks(mapper.getMappedEntity(taskDetailsView));
		mapper.mapView(taskDetailsView, taskDetails);
	}

	public boolean renderScreen() {
		
		
	//System.out.println("hiieee");
	return renderer;
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }

}
