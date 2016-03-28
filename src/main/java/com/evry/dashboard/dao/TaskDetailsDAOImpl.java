package com.evry.dashboard.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.evry.dashboard.model.TaskDetails;

public class TaskDetailsDAOImpl implements TaskDetailsDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void add(TaskDetails taskDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(taskDetails);
	}

	@Transactional
	public TaskDetails getUsers(TaskDetails taskDetails)
	{
		
		  String ProjectName = taskDetails.getProject_Name();
		  String WeekNo = taskDetails.getWeekNo(); 
		  System.out.println(ProjectName);
		Session session = this.sessionFactory.getCurrentSession();
     
		Query query = session.getNamedQuery("findProject").setParameter("projectName", ProjectName).setParameter("weekNo", WeekNo);
		List<TaskDetails> rs=query.list();
		TaskDetails details = null;
			if(!rs.isEmpty())
			{
				details = rs.get(0);
			}
				 System.out.println(details.getProject_Name());
					
		return details;
//			return r;
		
			
	}

	

	@Transactional
	public TaskDetails isValid(TaskDetails taskDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		 return getUsers(taskDetails);
	}

}
