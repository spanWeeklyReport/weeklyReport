package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.ProjectDetailsView;

public interface ProjectDetailsService 
{
	
	List<String> getProjectNames();
	public void addProject(ProjectDetailsView projectDetailsView);
	public List<ProjectDetailsView> getProjectList();
<<<<<<< HEAD
	public void projectDepartment();
=======
>>>>>>> branch 'master' of https://github.com/spanWeeklyReport/weeklyReport.git
	
}
