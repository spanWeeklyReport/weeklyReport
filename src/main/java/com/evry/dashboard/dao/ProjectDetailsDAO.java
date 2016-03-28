package com.evry.dashboard.dao;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;

public interface ProjectDetailsDAO {
	
	ProjectDetails findByName(String projectName);

}
