package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;

/**
 * @author Mehak.Sapra
 *DAO Interface for task Details
 *
 */
public interface TaskDetailsDAO {
	
	void addTasks(TaskDetails taskDetails);
	TaskDetails getTasks(TaskDetails taskDetails);
	TaskDetails checkTasks(TaskDetails taskDetails);
    void updateLastWeekTasks(TaskDetails taskDetails);
    List<TaskDetails> viewReport(TaskDetails taskDetails);
    public TaskDetails checkReport(TaskDetails taskDetails);
    List<TaskDetails> employeeReportStatus(TaskDetails taskDetails);
}
