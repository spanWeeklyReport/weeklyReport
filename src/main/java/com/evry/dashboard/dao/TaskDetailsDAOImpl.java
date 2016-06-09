package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.TaskDetails;

public class TaskDetailsDAOImpl implements TaskDetailsDAO {

	private SessionFactory sessionFactory;
	private static final String UPDATE_QUERY = "update TaskDetails o set o.PlannedTask = :plannedTask, o.CompletedTask = :completedTask, o.HoldTask = :holdTask, o.InprogressTask = :inprogressTask where o.taskId = :taskId";

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#addTasks(com.evry.dashboard.model
	 * .TaskDetails)
	 */
	@Transactional
	public void addTasks(TaskDetails taskDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(taskDetails);
		// session.save(taskDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#updateLastWeekTasks(com.evry.dashboard
	 * .model.TaskDetails)
	 */
	@Transactional
	public void updateLastWeekTasks(TaskDetails lastWeekDetails) {

		Session session = this.sessionFactory.getCurrentSession();

		session.createQuery(UPDATE_QUERY)
				.setParameter("taskId", lastWeekDetails.getTaskId())
				.setParameter("plannedTask", lastWeekDetails.getPlannedTask())
				.setParameter("completedTask",
						lastWeekDetails.getCompletedTask())
				.setParameter("holdTask", lastWeekDetails.getHoldTask())
				.setParameter("inprogressTask",
						lastWeekDetails.getInprogressTask()).executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#getTasks(com.evry.dashboard.model
	 * .TaskDetails)
	 */
	@Transactional
	public TaskDetails getTasks(TaskDetails taskDetails) {
		int weekNo = taskDetails.getWeekNo();
		// int yearNo = taskDetails.getYearNo();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session
				.getNamedQuery("findProject")
				.setParameter("projectDetails", taskDetails.getProjectDetails())
				.setParameter("weekNo", weekNo);

		List<TaskDetails> rs = query.list();
		TaskDetails details = null;
		if (!rs.isEmpty())
			details = rs.get(0);
		else {
			details = new TaskDetails();
			details.setWeekNo(weekNo);
			details.setProjectDetails(taskDetails.getProjectDetails());
		}
		return details;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#checkTasks(com.evry.dashboard.model
	 * .TaskDetails)
	 */
	@Transactional
	public TaskDetails checkTasks(TaskDetails taskDetails) {
		return getTasks(taskDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#checkReport(com.evry.dashboard.
	 * model.TaskDetails)
	 */
	@Transactional
	public TaskDetails checkReport(TaskDetails taskDetails) {
		return getTasks(taskDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.TaskDetailsDAO#viewReport(com.evry.dashboard.model
	 * .TaskDetails)
	 */
	@Transactional
	public List<TaskDetails> viewReport(TaskDetails taskDetails) {
		String projectName = taskDetails.getProjectDetails().getProjectName();

		System.out.println(projectName);

		int wNo = taskDetails.getWeekNo();
		System.out.println(wNo);
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(TaskDetails.class);

		if (!projectName.equalsIgnoreCase("All") && wNo != 0) {
			System.out.println("condition1");
			cr.add(Restrictions.eq("projectDetails",
					taskDetails.getProjectDetails()));
			cr.add(Restrictions.eq("WeekNo", wNo));
			cr.addOrder(Order.asc("WeekNo"));
		}

		else if (!projectName.equalsIgnoreCase("All") && wNo == 0) {
			System.out.println("condition2");
			cr.add(Restrictions.eq("projectDetails",
					taskDetails.getProjectDetails()));
		}

		else if (projectName.equalsIgnoreCase("All") && wNo != 0) {
			System.out.println("condition3");
			cr.add(Restrictions.eq("WeekNo", wNo));
		}

		else if (projectName.equalsIgnoreCase("All") && wNo == 0) {
			System.out.println("condition4");
			cr.addOrder(Order.asc("WeekNo"));

		}

		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<TaskDetails> viewReport = cr.list();

		return viewReport;

	}

}
