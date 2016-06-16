package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")

@NamedQueries(  
	    {  
	        @NamedQuery(
	        name = "Department.departmentExists", 
	        query = "SELECT o FROM Department o WHERE o.departmentName = :departmentName")
	    } 
	  )

public class Department {
	
	    @Id
	    @Column(name = "O_ID")
	    private long oid;
	    
	    @Column(name = "DEPARTMENT_NAME")
	    private String departmentName;
	    
	    @Column(name = "LOGO")
	    private String logo;
	    
	    private Byte[] imageData;
	    

		/**
		 * @Getters and setters
		 */
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
