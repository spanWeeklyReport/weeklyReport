package com.evry.dashboard.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Id;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.RiskDetails;

@ManagedBean(name = "taskDetails")
@ViewScoped
public class TaskDetailsView implements Serializable {

	/**
	 * Current week variables
	 */
	private static final long serialVersionUID = -8796260672796259709L;
	private long taskId;
	private String reportType;
	private String projectDetailsName;
	private int WeekNo;
	private String wNo;
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

	/**
	 * Last week Variables
	 */
	private long lastTaskId;
	private String lastPlanned;
	private String lastCompleted;
	private String lastHold;
	private String lastInProgress;
	public String data = "1";
	private ArrayList<RiskDetailsView> riskDetailsList;

	/**
	 * @Getters and setters
	 */
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getProjectDetailsName() {
		return projectDetailsName;
	}

	public void setProjectDetailsName(String projectDetailsID) {
		this.projectDetailsName = projectDetailsID;
	}

	public int getWeekNo() {
		return WeekNo;
	}

	public void setWeekNo(int weekNo) {
		this.WeekNo = weekNo;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
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

	// For billed resources

	public String getProjectIncB() {
		return ProjectIncB;
	}

	public void setProjectIncB(String projectIncB) {
		ProjectIncB = projectIncB;
	}

	public String getProjectDecB() {
		return ProjectDecB;
	}

	public void setProjectDecB(String projectDecB) {
		ProjectDecB = projectDecB;
	}

	// For shadow resources

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLastPlanned() {
		return lastPlanned;
	}

	public void setLastPlanned(String lastPlanned) {
		this.lastPlanned = lastPlanned;
	}

	public String getLastCompleted() {
		return lastCompleted;
	}

	public void setLastCompleted(String lastCompleted) {
		this.lastCompleted = lastCompleted;
	}

	public String getLastHold() {
		return lastHold;
	}

	public void setLastHold(String lastHold) {
		this.lastHold = lastHold;
	}

	public String getLastInProgress() {
		return lastInProgress;
	}

	public void setLastInProgress(String lastInProgress) {
		this.lastInProgress = lastInProgress;
	}

	public long getLastTaskId() {
		return lastTaskId;
	}

	public void setLastTaskId(long lastTaskId) {
		this.lastTaskId = lastTaskId;
	}

	public String getwNo() {
		return wNo;
	}

	public void setwNo(String wNo) {
		this.wNo = wNo;
	}

	public ArrayList<RiskDetailsView> getRiskDetailsList() {
		return riskDetailsList;
	}

	public void setRiskDetailsList(ArrayList<RiskDetailsView> riskDetailsList) {
		this.riskDetailsList = riskDetailsList;
	}

}
