package com.evry.dashboard.dao;

import java.util.List;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.util.ProjectTechnology;

/**
 * @author Mehak.Sapra
 * DAO Interface for Project Details
 *
 */
public interface ProjectDetailsDAO {
	
	ProjectDetails findByName(String projectName);
	List<String> getProjectNames();
	public void add(ProjectDetails projectDetails);
	public boolean checkProject(ProjectDetails projectDetails);
	public List<ProjectDetails> getProjectList();
	public String deleteProjects(ProjectDetails projectDetails);
}
