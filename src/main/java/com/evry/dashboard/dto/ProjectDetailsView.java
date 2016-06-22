package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "projectDetails")
@ViewScoped
@SessionScoped
public class ProjectDetailsView {
	private long oid;
	private String projectName;
	private String projectStatus;
	private String projectDepartment;
	private String managerName;

	/**
	 * @Getters and setters
	 */
	
	
	
	public long getOid() {
		return oid;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDepartment() {
		return projectDepartment;
	}

	public void setProjectDepartment(String projectDepartment) {
		this.projectDepartment = projectDepartment;
	}

}
