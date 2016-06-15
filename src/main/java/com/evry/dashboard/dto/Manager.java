package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

/**
 * Class to handemanager functionaloty
 * @author Mehak.Sapra
 *
 */
@ManagedBean(name = "manager")
@SessionScoped
public class Manager {

	   private long Oid;
	   
	    /**
	 * @return the oid
	 */
	public long getOid() {
		return Oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(long oid) {
		Oid = oid;
	}
		/**
	     * File to upload image for Manager
	     */
	    private UploadedFile uploadedFile;
	    /**
	     * 
	     */
	    private String departmentName;
	    /**
	     * 
	     */
	    private String localtion;
	    
		/**
		 * 
		 * @return the uploadedFile
		 */
		public UploadedFile getUploadedFile() {
			return uploadedFile;
		}
		
		/**
		 * @param uploadedFile the uploadedFile to set
		 */
		public void setUploadedFile(UploadedFile uploadedFile) {
			this.uploadedFile = uploadedFile;
		}
		/**
		 * @return the departmentName
		 */
		public String getDepartmentName() {
			return departmentName;
		}
		/**
		 * @param departmentName the departmentName to set
		 */
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		/**
		 * @return the localtion
		 */
		public String getLocaltion() {
			return localtion;
		}
		/**
		 * @param localtion the localtion to set
		 */
		public void setLocaltion(String localtion) {
			this.localtion = localtion;
		}
	    
	    
	
}
