package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.evry.dashboard.dao.ProjectDetailsDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.mapper.ProjectDetailsMapper;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.util.ProjectTechnology;

@ManagedBean(name = "projectDetailsService")
@SessionScoped
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	private ProjectDetailsMapper projectDetailsmapper;
	private ProjectDetailsDAO projectDetailsDAO;

	public ProjectDetailsServiceImpl() {

	}

	public void setProjectDetailsDAO(ProjectDetailsDAO projectDetailsDAO) {
		this.projectDetailsDAO = projectDetailsDAO;
	}

	public void setMapper(ProjectDetailsMapper mapper) {
		this.projectDetailsmapper = mapper;
	}

	public List<String> getProjectNames() {

		List<String> projectDetails = projectDetailsDAO.getProjectNames();
		return projectDetails;
	}

	/*  To add new project
	 * (non-Javadoc)
	 * @see com.evry.dashboard.service.ProjectDetailsService#addProject(com.evry.dashboard.dto.ProjectDetailsView)
	 */
	public void addProject(ProjectDetailsView projectDetailsView) {
		

		ProjectDetails obj = projectDetailsmapper.getMappedEntity(projectDetailsView);
		projectDetailsDAO.checkProject(obj);

	}

}
