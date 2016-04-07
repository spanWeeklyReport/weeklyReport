package com.evry.dashboard.dto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Id;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.RiskDetails;

@ManagedBean(name="taskDetails")
@SessionScoped
public class TaskDetailsView 
{
	
	private long oid;
	private String projectDetailsName;
	private String WeekNo;
	private String PlannedTask;	
	private String CompletedTask;
	private String HoldTask;
	private String InprogressTask;
	private String SharedResources;
	private String BilledResources;
	private String ProjectIncB;
	private String ProjectDecB;
	private String ProjectIncSh;
	private String ProjectDecSh;
	private String ProjectUpdates;
	private String ResourceLoadingB;
	private String ResourceLoadingSh;
	private List <RiskDetails> riskDetails ;
	

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getProjectDetailsName() {
		return projectDetailsName;
	}

	public void setProjectDetailsName(String projectDetailsID) {
		this.projectDetailsName = projectDetailsID;
	}

	public String getWeekNo() {
		return WeekNo;
	}

	public void setWeekNo(String weekNo) {
		this.WeekNo = weekNo;
	}

	public String getPlannedTask() {
		return PlannedTask;
	}

	public void setPlannedTask(String plannedTask) {
		this.PlannedTask = plannedTask;
	}

	public String getCompletedTask() {
		return CompletedTask;
	}

	public void setCompletedTask(String completedTask) {
		this.CompletedTask = completedTask;
	}

	public String getHoldTask() {
		return HoldTask;
	}

	public void setHoldTask(String holdTask) {
		this.HoldTask = holdTask;
	}

	public String getInprogressTask() {
		return InprogressTask;
	}

	public void setInprogressTask(String inprogressTask) {
		this.InprogressTask = inprogressTask;
	}

	
	public String getSharedResources() {
		return SharedResources;
	}

	public void setSharedResources(String sharedResources) {
		this.SharedResources = sharedResources;
	}

	public String getBilledResources() {
		return BilledResources;
	}

	public void setBilledResources(String billedResources) {
		this.BilledResources = billedResources;
	}
    
	
	//For billable resources
	public String getProjectInc() {
		return ProjectIncB;
	}

	public void setProjectInc(String projectInc) {
		this.ProjectIncB = projectInc;
	}

	public String getProjectDec() {
		return ProjectDecB;
	}

	public void setProjectDec(String projectDec) {
		this.ProjectDecB = projectDec;
	}
	
	//For shadow resources
	
	public String getProjectIncSh() {
		return ProjectIncSh;
	}
	
	public void setProjectIncSh(String projectIncSh) {
		ProjectIncSh = projectIncSh;
	}
	
	public String getProjectDecSh() {
		return ProjectDecSh;
	}
	
	public void setProjectDecSh(String projectDecSh) {
		ProjectDecSh = projectDecSh;
	}
	
	public String getProjectUpdates() {
		return ProjectUpdates;
	}
	
	public void setProjectUpdates(String projectUpdates) {
		ProjectUpdates = projectUpdates;
	}
	
	public String getResourceLoadingB() {
		return ResourceLoadingB;
	}
	
	public void setResourceLoadingB(String resourceLoadingB) {
		ResourceLoadingB = resourceLoadingB;
	}
	
	public String getResourceLoadingSh() {
		return ResourceLoadingSh;
	}
	
	public void setResourceLoadingSh(String resourceLoadingSh) {
		ResourceLoadingSh = resourceLoadingSh;
	}
	
	public List<RiskDetails> getRiskDetails() {
		return riskDetails;
	}

	public void setRiskDetails(List<RiskDetails> riskDetails) {
		this.riskDetails = riskDetails;
	}
	
}
