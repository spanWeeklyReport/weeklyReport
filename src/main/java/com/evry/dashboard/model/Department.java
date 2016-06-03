package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")

public class Department {
	
	 @Id
	    @Column(name = "O_ID")
	    private long oid;
	    
	    @Column(name = "DEPARTMENT_NAME")
	    private String departmentName;
	    
	    @Column(name = "LOGO")
	    private String logo;

		public long getOid() {
			return oid;
		}

		public void setOid(long oid) {
			this.oid = oid;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}
	    
}
