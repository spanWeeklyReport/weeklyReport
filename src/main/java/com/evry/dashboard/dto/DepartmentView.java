package com.evry.dashboard.dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "departmentView")
@SessionScoped
public class DepartmentView implements Serializable {

	    private long Oid;
	   private UploadedFile uploadedFile;
	    
	    private String departmentName;
	   
	    private String localtion;
	    
	    public long getOid() {
			return Oid;
		}
	    
	    private byte[] imageData;
	    
	    
	    

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		/**
		 * @param oid the oid to set
		 */
		public void setOid(long oid) {
			Oid = oid;
		}
	    
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
