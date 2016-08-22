package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.model.ProjectDetails;

public class ProjectDetailsMapper {
	
	
	private UserInfoDAO userInfoDAO;
	
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	/**
	 * @param projectDetails
	 * @return
	 */
	public ProjectDetailsView getMappedView(ProjectDetails projectDetails) {
		ProjectDetailsView projectDetailsView = new ProjectDetailsView();
		projectDetailsView.setOid(projectDetails.getOid());
		projectDetailsView.setProjectName(projectDetails.getProjectName());
		projectDetailsView.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsView.setProjectDepartment(projectDetails
				.getProjectDepartment());
		try {
            projectDetailsView.setTlName(projectDetails.getUserInfo().getFirstName());
            } catch (Exception e) {
                    projectDetailsView.setTlName("");
          }

		projectDetailsView.setStartDate(projectDetails.getStartDate());
		projectDetailsView.setEndDate(projectDetails.getEndDate());
		return projectDetailsView;
	}

	/**
	 * @param projectDetailsView
	 * @return
	 */
	public ProjectDetails getMappedEntity(ProjectDetailsView projectDetailsView) {
		ProjectDetails projectDetails = new ProjectDetails();
		projectDetails.setOid(projectDetailsView.getOid());
		projectDetails.setProjectName(projectDetailsView.getProjectName());
		projectDetails.setProjectStatus(projectDetailsView.getProjectStatus());
		projectDetails.setProjectDepartment(projectDetailsView
				.getProjectDepartment());
		projectDetails.setUserInfo(userInfoDAO.findFirstName(projectDetailsView.getTlName()));
		projectDetails.setStartDate(projectDetailsView.getStartDate());
		projectDetails.setEndDate(projectDetailsView.getEndDate());
		return projectDetails;

	}
	
	public void MapView(ProjectDetailsView projectDetailsView, ProjectDetails projectDetails) {
		
		projectDetailsView.setOid(projectDetails.getOid());
		projectDetailsView.setProjectName(projectDetails.getProjectName());
		projectDetailsView.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsView.setProjectDepartment(projectDetails.getProjectDepartment());
		projectDetailsView.setStartDate(projectDetails.getStartDate());
		projectDetailsView.setEndDate(projectDetails.getEndDate());
		
	}
	
	
}