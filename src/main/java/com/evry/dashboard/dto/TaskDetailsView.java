package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Id;

@ManagedBean(name="taskDetails")
@SessionScoped
public class TaskDetailsView 
{
	
	private long oid;
	private String Project_Name;
	private String WeekNo;
	private String PlannedTask;	
	private String CompletedTask;
	private String HoldTask;
	private String InprogressTask;
	private String RiskDec;
	private String RiskResp;
	private String SharedResources;
	private String BilledResources;
	private String ProjectInc;
	private String ProjectDec;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getProject_Name() {
		return Project_Name;
	}

	public void setProject_Name(String project_Name) {
		this.Project_Name = project_Name;
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

	public String getRiskDec() {
		return RiskDec;
	}

	public void setRiskDec(String riskDec) {
		this.RiskDec = riskDec;
	}

	public String getRiskResp() {
		return RiskResp;
	}

	public void setRiskResp(String riskResp) {
		this.RiskResp = riskResp;
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

	public String getProjectInc() {
		return ProjectInc;
	}

	public void setProjectInc(String projectInc) {
		this.ProjectInc = projectInc;
	}

	public String getProjectDec() {
		return ProjectDec;
	}

	public void setProjectDec(String projectDec) {
		this.ProjectDec = projectDec;
	}
	
	
}
