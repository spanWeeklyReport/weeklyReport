package com.evry.dashboard.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "departmentView")
@SessionScoped
public class DepartmentView {

	    private long Oid;
	   private UploadedFile uploadedFile;
	    
	    private String departmentName;
	   
	    private String localtion;
	    
	    public long getOid() {
			return Oid;
		}
	    
	    private Byte[] imageData;
	    
	    

		public Byte[] getImageData() {
			return imageData;
		}

		public void setImageData(Byte[] imageData) {
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
