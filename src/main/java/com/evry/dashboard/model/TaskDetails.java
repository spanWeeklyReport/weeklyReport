package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "TASK_DETAILS")

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findProject",  
	        query = "select o from TaskDetails o where o.projectDetails = :projectDetails and o.WeekNo = :weekNo "  
	        )  
	    }  
	)  
public class TaskDetails {
	@Id
	@Column(name = "OID")
	private long oid;
	
		
	
	@ManyToOne()
	@JoinColumn(name = "PROJECT_ID")
	private ProjectDetails projectDetails;
	
	@Column(name = "WEEK_NO")
	private String WeekNo;
	
	@Column(name = "PLANNED_TASK")
	private String PlannedTask;
	
	@Column(name = "COMPLETED_TASK")
	private String CompletedTask;
	
	@Column(name = "HOLD_TASK")
	private String HoldTask;
	
	@Column(name = "INPROGRESS_TASK")
	private String InprogressTask;

	@Column(name = "RISK_DESC")
	private String riskDisc;
	
	@Column(name = "RISK_RESP")
	private String RiskResp;
	
	@Column(name = "SHARED_RESOURCES")
	private String SharedResources;
	
	@Column(name = "BILLED_RESOURCES")
	private String BilledResources;
	
	@Column(name = "PROJECT_INC")
	private String ProjectInc;

	@Column(name = "PROJECT_DEC")
	private String ProjectDec;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
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

	public String getRiskDisc() {
		return riskDisc;
	}

	public void setRiskDec(String riskDec) {
		this.riskDisc = riskDec;
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
