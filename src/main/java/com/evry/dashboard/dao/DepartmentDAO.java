package com.evry.dashboard.dao;

import java.util.List;

import com.evry.dashboard.model.Department;

public interface DepartmentDAO {
	
	public List<Department> fetchDepartment();
	List<String> getDepartmentNames();
    public boolean add(Department department) ;
}
