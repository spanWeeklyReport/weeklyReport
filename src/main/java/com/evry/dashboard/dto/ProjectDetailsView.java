package com.evry.dashboard.dto;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "projectDetails")
@SessionScoped
public class ProjectDetailsView implements Serializable {
	
	private static final long serialVersionUID = -8764367898656L;
	private long oid;
	private String projectName;
	private String projectStatus;
	private String projectDepartment;
	private String managerName;
	private Date startDate;
	private Date endDate;
	private String tlName;
	

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTlName() {
		return tlName;
	}

	public void setTlName(String tlName) {
		this.tlName = tlName;
	}
    
	
	
	
	
}
