package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.evry.dashboard.dao.DepartmentDAO;
import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.dto.mapper.DepartmentMapper;
import com.evry.dashboard.model.Department;

@ManagedBean(name = "departmentService")
@SessionScoped
public class DepartmentServiceImpl {
	
	private DepartmentDAO departmentDAO;
	private DepartmentMapper departmentMapper;
	
	public DepartmentServiceImpl(){
		
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	
	public  List<DepartmentView> getDepartment(){
		
		List<Department> departmentName = departmentDAO.fetchDepartment();
		
		List<DepartmentView> departmentView = new ArrayList();
	        
	        for(Department department: departmentName)
	        	departmentView.add(departmentMapper.getMappedView(department));
	        		return departmentView;
	}
}
