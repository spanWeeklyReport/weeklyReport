package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.evry.dashboard.dao.TaskDetailsDAO;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.mapper.TaskDetailsMapper;
import com.evry.dashboard.model.TaskDetails;

@ManagedBean(name = "taskDetailsService")
@SessionScoped
public class TaskDetailsServiceImpl implements TaskDetailsService 
{

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
		//comment
	}

	public void addUser(TaskDetailsView taskDetailsView) 
	{
		TaskDetails obj = mapper.getMappedEntity(taskDetailsView);
		taskDetailsDAO.add(obj);
	}
	
	public List<TaskDetailsView> getUsers()
	{
		//List<TaskDetails> taskDetailss = taskDetailsDAO.getUsers(taskDetails);
		List<TaskDetailsView> taskDetailsViews = new ArrayList();
			/*for(TaskDetails taskDetails :taskDetailss)			
			{
				taskDetailsViews.add(mapper.getMappedView(taskDetails));	
				
			}*/
		return taskDetailsViews;
	}

	public void isValid(TaskDetailsView taskDetailsView) 
	{

		System.out.println("-------------dfefef---");
		TaskDetails taskDetails =  taskDetailsDAO.isValid(mapper.getMappedEntity(taskDetailsView));
		System.out.println("----------------");
		mapper.mapView(taskDetailsView, taskDetails);
	}
}
