package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.ProjectDetailsView;

public interface ProjectDetailsService 
{
	
	List<String> getProjectNames();
	public void addProject(ProjectDetailsView projectDetailsView);
	public List<ProjectDetailsView> getProjectList();
	public String deleteProjects(ProjectDetailsView projectDetailsView);
	public void projectDepartment();
	public String editProjects(ProjectDetailsView projectDetailsView);
	public String modifyProjects(ProjectDetailsView projectDetailsView);
}
