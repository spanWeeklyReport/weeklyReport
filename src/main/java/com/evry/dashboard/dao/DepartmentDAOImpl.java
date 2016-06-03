package com.evry.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.dto.mapper.DepartmentMapper;
import com.evry.dashboard.model.Department;
import com.evry.dashboard.model.ProjectDetails;

public class DepartmentDAOImpl implements DepartmentDAO{
	private SessionFactory sessionFactory;
	private DepartmentMapper departmentMapper;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}


	@Transactional
	public List<Department> fetchDepartment(){
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> departmentList = session.createQuery("from Department ").list();
		 return departmentList;
		
		
		
	}
	
}
