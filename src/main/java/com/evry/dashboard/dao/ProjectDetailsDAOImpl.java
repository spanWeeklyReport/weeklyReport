package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;

public class ProjectDetailsDAOImpl implements ProjectDetailsDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void add(TaskDetails projectDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(projectDetails);
	}
	
	@Transactional
	public ProjectDetails findByName(String projectName)
	{
		
		 Session session = this.sessionFactory.getCurrentSession();
		 
		 Query query = session.getNamedQuery("findByName").setParameter("projectName", projectName);
		 List<ProjectDetails> rs=query.list();
		 ProjectDetails details = null;
				if(!rs.isEmpty())				
					details = rs.get(0);
				else
				{
					details = new ProjectDetails();
					details.setProjectName(projectName);
				}
			return details;
}
}
