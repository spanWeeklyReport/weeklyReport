package com.evry.dashboard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

public class ProjectDetailsDAOImpl implements ProjectDetailsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void add(ProjectDetails projectDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(projectDetails);
	}

	@Transactional
	public ProjectDetails findByName(String projectName) {

		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.getNamedQuery("findByName").setParameter(
				"projectName", projectName);
		List<ProjectDetails> rs = query.list();
		ProjectDetails details = null;
		if (!rs.isEmpty())
			details = rs.get(0);
		else {
			details = new ProjectDetails();
			details.setProjectName(projectName);
		}
		return details;
	}

	@Transactional
	public List<String> getProjectNames() {

		String tech = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("tech");
		System.out.println("----------" + tech);

		Session session = this.sessionFactory.getCurrentSession();
		if (tech.equalsIgnoreCase("All")) {
			System.out.println("---inside 1");
			List<ProjectDetails> projectList = session.createQuery(
					"from ProjectDetails").list();
			// System.out.println(projectList);
			ArrayList projectNames = new ArrayList();

			for (ProjectDetails details : projectList)
				projectNames.add(details.getProjectName());
			return projectNames;

		}

		else {
			System.out.println("--inside 2");
			List<ProjectDetails> projectList2 = session.createQuery(
					"from ProjectDetails where projectDepartment='" + tech+ "'").list();
			// System.out.println(projectList);
			ArrayList projectNames2 = new ArrayList();

			for (ProjectDetails details2 : projectList2)
				projectNames2.add(details2.getProjectName());
			return projectNames2;

		}

	}

	@Transactional
	public boolean checkProject(ProjectDetails projectDetails) {

		Session session = this.sessionFactory.getCurrentSession();
		String projectExists = projectDetails.getProjectName();
		List<ProjectDetails> rst = session.getNamedQuery("Projects.projectExists")
				.setParameter("projectName", projectExists).list();

		boolean projectCheck = false;

		if (!rst.isEmpty()) {
			projectCheck = true;
			System.out.println("Project Already Exists");

			FacesContext.getCurrentInstance().addMessage(
					"projectForm:submit4",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"This Project already exists!", null));

			return true;
		} else {

			session.persist(projectDetails);
			FacesContext.getCurrentInstance().addMessage(
					"projectForm:submit4",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Project Added Successfully!", null));
		}

		return false;

	}

}
