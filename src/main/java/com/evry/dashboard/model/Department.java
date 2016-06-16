package com.evry.dashboard.model;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import sun.misc.BASE64Encoder;

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
	    
	    @Column(name = "IMAGE_DATA")
	    private byte[] imageData;
	    

		/**
		 * @Getters and setters
		 */
	    
	    
	    
		public long getOid() {
			return oid;
		}

		public byte[] getImageData() {
			return imageData;
		}
		
		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
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
			logo=new BASE64Encoder().encode(imageData);
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}
	    
}
