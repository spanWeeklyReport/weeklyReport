package com.evry.dashboard.dao;

import java.util.List;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.util.ProjectTechnology;

public interface ProjectDetailsDAO {
	
	ProjectDetails findByName(String projectName);
	List<String> getProjectNames();

}
