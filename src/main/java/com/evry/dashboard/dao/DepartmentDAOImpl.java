package com.evry.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.dto.mapper.DepartmentMapper;
import com.evry.dashboard.model.Department;
import com.evry.dashboard.model.ProjectDetails;

public class DepartmentDAOImpl implements DepartmentDAO {
	private SessionFactory sessionFactory;
	private DepartmentMapper departmentMapper;

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param departmentMapper
	 */
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evry.dashboard.dao.DepartmentDAO#fetchDepartment()
	 */
	@Transactional
	public List<Department> fetchDepartment() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Department> departmentList = session.createQuery(
				"from Department ").list();
		
		return departmentList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evry.dashboard.dao.DepartmentDAO#getDepartmentNames()
	 */
	@Transactional
	public List<String> getDepartmentNames() {

		Session session = this.sessionFactory.getCurrentSession();
		session.createQuery("from Department").list();
		List<Department> departmentList = session
				.createQuery("from Department").list();

		ArrayList departmentNames = new ArrayList();

		for (Department details : departmentList)
			departmentNames.add(details.getDepartmentName());
		return departmentNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.dao.DepartmentDAO#add(com.evry.dashboard.model.Department
	 * ) Function to add departments
	 */
	@Transactional
	public boolean add(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
		String checkDepartment = department.getDepartmentName();

		List<DepartmentDAO> rsl = session
				.getNamedQuery("Department.departmentExists")
				.setParameter("departmentName", checkDepartment).list();

		boolean departCheck = false;

		if (!rsl.isEmpty()) {
			departCheck = true;
			System.out.println("Department already Exists");

			FacesContext.getCurrentInstance().addMessage(
					"addDepartmentForm:submit6",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Department already exists", null));

			return true;
		} else {

			session.persist(department);
			FacesContext.getCurrentInstance().addMessage(
					"addDepartmentForm:submit6",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Department Added Successfully!", null));

		}

		return false;

	}

}
