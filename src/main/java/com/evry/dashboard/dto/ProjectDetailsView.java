package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="projectDetails")
public class ProjectDetailsView 
{
	private long oid;
	private String projectName;
	private String projectStatus;
	
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
}