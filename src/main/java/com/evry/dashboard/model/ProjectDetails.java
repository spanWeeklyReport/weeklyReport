package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "PROJECT_DETAILS")

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findByName",  
	        query = "select o from ProjectDetails o where o.projectName = :projectName "  
	        )  ,
	        @NamedQuery(
	        name = "Projects.projectExists", 
	        query = "SELECT o FROM ProjectDetails o WHERE o.projectName = :projectName")
	    } 
	  )
public class ProjectDetails {
	
	@Id
	@Column(name = "OID")
	private long oid;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "PROJECT_STATUS")
	private String projectStatus;
	
	@Column(name = "PROJECT_DEPARTMENT")
	private String projectDepartment;

	public long getOid() {
		return oid;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return projectName;
	}

	public String getProjectDepartment() {
		return projectDepartment;
	}

	public void setProjectDepartment(String projectDepartment) {
		this.projectDepartment = projectDepartment;
	}

	
	
	
	

}
