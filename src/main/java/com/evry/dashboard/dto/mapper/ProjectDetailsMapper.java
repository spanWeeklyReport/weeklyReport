package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.model.ProjectDetails;

public class ProjectDetailsMapper 
{
	
	public ProjectDetailsView getMappedView(ProjectDetails projectDetails)
	{
		ProjectDetailsView projectDetailsView = new ProjectDetailsView();
		projectDetailsView.setOid(projectDetails.getOid());
		projectDetailsView.setProjectName(projectDetails.getProjectName());
		projectDetailsView.setProjectStatus(projectDetails.getProjectStatus());
		return projectDetailsView;
	}

	public ProjectDetails getMappedEntity(ProjectDetailsView projectDetailsView)
	{
		ProjectDetails projectDetails = new ProjectDetails();
//		projectDetails.setOid(projectDetailsView.getOid());
		projectDetails.setProjectName(projectDetailsView.getProjectName());
		projectDetails.setProjectStatus(projectDetailsView.getProjectStatus());
		return projectDetails;

}
}