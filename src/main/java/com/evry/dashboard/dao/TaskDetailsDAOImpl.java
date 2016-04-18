package com.evry.dashboard.dao;

import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.TaskDetails;

public  class TaskDetailsDAOImpl implements TaskDetailsDAO {
	
private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addTasks(TaskDetails taskDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
       session.merge(taskDetails);
		//session.save(taskDetails);
	}

	@Transactional
	public TaskDetails getTasks(TaskDetails taskDetails)
	{
		String weekNo = taskDetails.getWeekNo(); 
		Session session = this.sessionFactory.getCurrentSession();     
		Query query = session.getNamedQuery("findProject")
				.setParameter("projectDetails", taskDetails.getProjectDetails())
				.setParameter("weekNo", weekNo);
		List<TaskDetails> rs=query.list();
		TaskDetails details = null;
			if(!rs.isEmpty())			
				details = rs.get(0);			
			else
				{
					details = new TaskDetails();	
					details.setWeekNo(weekNo);
					details.setProjectDetails(taskDetails.getProjectDetails());
				}
		return details;			
	}

	

	@Transactional
	public TaskDetails checkTasks(TaskDetails taskDetails) 
	{
		 return getTasks(taskDetails);
	}
	
	
}
