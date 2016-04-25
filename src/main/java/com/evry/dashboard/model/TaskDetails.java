package com.evry.dashboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "TASK_DETAILS")

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findProject",  
	        query = "select o from TaskDetails o where o.projectDetails = :projectDetails and o.WeekNo = :weekNo and o.YearNo = :yearNo"  
	        )  
	    }  
	)  
public class TaskDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TASK_ID")
	private long taskId;
		
	@ManyToOne()
	@JoinColumn(name = "PROJECT_ID")
	private ProjectDetails projectDetails;
	
	@Column(name = "WEEK_NO")
	private int WeekNo;
	
	@Column(name = "YEAR_NO")
	private int YearNo;
	
	@Column(name = "PLANNED_TASK")
	private String PlannedTask;
	
	@Column(name = "COMPLETED_TASK")
	private String CompletedTask;
	
	@Column(name = "HOLD_TASK")
	private String HoldTask;
	
	@Column(name = "INPROGRESS_TASK")
	private String InprogressTask;
	
	@Column(name = "SHARED_RESOURCES")
	private String SharedResources;
	
	@Column(name = "BILLED_RESOURCES")
	private String BilledResources;
	
	@Column(name = "PROJECT_INC_B")
	private String ProjectIncB;

	@Column(name = "PROJECT_DEC_B")
	private String ProjectDecB;
	
	@Column(name = "PROJECT_INC_SH")
	private String ProjectIncSh;
	
	@Column(name = "PROJECT_DEC_SH")
	private String ProjectDecSh;
	
	@Column(name = "PROJECT_UPDATES")
	private String ProjectUpdates;
	
	@Column(name = "RESOURCE_LOADING_B")
	private String ResourceLoadingB;
	
	@Column(name = "RESOURCE_LOADING_SH")
	private String ResourceLoadingSh;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="TASK_RISK_MAPPING",
            joinColumns = @JoinColumn(name = "TASK_ID"),
            inverseJoinColumns = @JoinColumn(name = "RISK_ID"))
    private List <RiskDetails> riskDetails = new ArrayList<>();
	
	public TaskDetails(){
		
		
	}
	
	
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public List<RiskDetails> getRiskDetails() {
		return riskDetails;
	}
	
	public void setRiskDetails(List<RiskDetails> riskDetails) {
		this.riskDetails = riskDetails;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public int getWeekNo() {
		return WeekNo;
	}

	public void setWeekNo(int weekNo) {
		this.WeekNo = weekNo;
	}
	
	
	public int getYearNo() {
		return YearNo;
	}


	public void setYearNo(int yearNo) {
		YearNo = yearNo;
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

	public String getProjectIncB() {
		return ProjectIncB;
	}

	public void setProjectIncB(String projectInc) {
		this.ProjectIncB = projectInc;
	}

	public String getProjectDecB() {
		return ProjectDecB;
	}

	public void setProjectDecB(String projectDec) {
		this.ProjectDecB = projectDec;
	}
	
	public String getProjectUpdates() {
		return ProjectUpdates;
	}
	
	public void setProjectUpdates(String projectUpdates) {
		ProjectUpdates = projectUpdates;
	}
	
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
}
