package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.SessionFactory;

import com.evry.dashboard.dao.DepartmentDAO;
import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.mapper.DepartmentMapper;
import com.evry.dashboard.model.Department;
import com.evry.dashboard.model.ProjectDetails;

@ManagedBean(name = "departmentService")
@SessionScoped
public class DepartmentServiceImpl {

	private DepartmentDAO departmentDAO;
	private DepartmentMapper departmentMapper;
	private static final int BUFFER_SIZE = 6124;
	
	private SessionFactory sessionFactory;

	private DepartmentMapper mapper;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setMapper(DepartmentMapper mapper) {
		this.mapper = mapper;
	}
	
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	/**
	 * Populates the department names in the drop down
	 */
	public List<String> getdepartmentName() {

		List<String> department = departmentDAO.getDepartmentNames();
		return department;
	}

	/**
	 * Fetch department names on their respective icons
	 */
	public List<DepartmentView> getDepartment() {

		List<Department> departmentName = departmentDAO.fetchDepartment();

		List<DepartmentView> departmentView = new ArrayList();

		for (Department department : departmentName)
			departmentView.add(departmentMapper.getMappedView(department));
		return departmentView;
	}

	/**
	 * To add a new department
	 * 
	 * @param departmentView
	 */
	public void addDepartment(DepartmentView departmentView) {
		//Department obj = departmentMapper.getMappedEntity(departmentView);
		//departmentDAO.add(obj);

	}
}
