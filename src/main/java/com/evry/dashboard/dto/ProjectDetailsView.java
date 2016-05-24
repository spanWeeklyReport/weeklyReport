package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="projectDetails")
@SessionScoped
public class ProjectDetailsView 
{
	private long oid;
	private String projectName;
	private String projectStatus;
	private String projectTechnology;
	
	public long getOid() 
	{
		return oid;
	}
	
	public void setOid(long oid) 
	{
		this.oid = oid;
	}
	
	public String getProjectName() 
	{
		return projectName;
	}
	
	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}
	
	public String getProjectStatus() 
	{
		return projectStatus;
	}
	
	public void setProjectStatus(String projectStatus) 
	{
		this.projectStatus = projectStatus;
	}

	public String getProjectTechnology() {
		return projectTechnology;
	}

	public void setProjectTechnology(String projectTechnology) {
		this.projectTechnology = projectTechnology;
	}
	
}
