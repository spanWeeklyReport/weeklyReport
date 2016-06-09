package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.model.Department;

public class DepartmentMapper {

	/**
	 * @param department
	 * @return
	 */
	public DepartmentView getMappedView(Department department) {

		DepartmentView departmentView = new DepartmentView();
		departmentView.setOid(department.getOid());
		departmentView.setDepartmentName(department.getDepartmentName());
		departmentView.setLogo(department.getLogo());

		return departmentView;
	}

	/**
	 * @param departmentView
	 * @return
	 */
	public Department getMappedEntity(DepartmentView departmentView) {

		Department department = new Department();
		department.setOid(departmentView.getOid());
		department.setDepartmentName(departmentView.getDepartmentName());
		department.setLogo(departmentView.getLogo());
		return department;
	}

}
