package com.evry.dashboard.service;

import java.util.List;

import com.evry.dashboard.dto.DepartmentView;

public interface DepartmentService {

	public  List<DepartmentView> getDepartment();
	List<String> getdepartmentName();
	void addDepartment(DepartmentView departmentView);
	public String createReport();
}
