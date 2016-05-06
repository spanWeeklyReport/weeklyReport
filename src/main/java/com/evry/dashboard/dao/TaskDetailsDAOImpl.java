package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.TaskDetails;

public  class TaskDetailsDAOImpl implements TaskDetailsDAO {
	
private SessionFactory sessionFactory;
private static final String UPDATE_QUERY= 
"update TaskDetails o set o.PlannedTask = :plannedTask, o.CompletedTask = :completedTask, o.HoldTask = :holdTask, o.InprogressTask = :inprogressTask where o.taskId = :taskId";

	

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
    public void updateLastWeekTasks(TaskDetails lastWeekDetails) {

           Session session = this.sessionFactory.getCurrentSession();
           // TaskDetails task = getTasks(lastWeekDetails);
           //
           // task.setPlannedTask(lastWeekDetails.getPlannedTask());
           // task.setCompletedTask(lastWeekDetails.getCompletedTask());
           // task.setHoldTask(lastWeekDetails.getHoldTask());
           // task.setInprogressTask(lastWeekDetails.getInprogressTask());
           // addTasks(task);

           session.createQuery(UPDATE_QUERY)
                        .setParameter("taskId", lastWeekDetails.getTaskId())
                        .setParameter("plannedTask", lastWeekDetails.getPlannedTask())
                        .setParameter("completedTask",
                                      lastWeekDetails.getCompletedTask())
                        .setParameter("holdTask", lastWeekDetails.getHoldTask())
                        .setParameter("inprogressTask",
                                      lastWeekDetails.getInprogressTask()).executeUpdate();

    }


	@Transactional
	public TaskDetails getTasks(TaskDetails taskDetails)
	{
		int weekNo = taskDetails.getWeekNo(); 
		//int yearNo = taskDetails.getYearNo();
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
					//details.setYearNo(yearNo);
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
