package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


	
@Entity()
@Table(name = "TASK_RISK_MAPPING")

public class TaskRiskMapping {
	
		
	@Column(name = "TASK_ID")
	private String taskId;

	@Column(name = "RISK_ID")
	private String riskId;

	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getRiskId() {
		return riskId;
	}

	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}
	
	

}
