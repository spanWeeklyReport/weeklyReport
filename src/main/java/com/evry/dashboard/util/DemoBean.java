package com.evry.dashboard.util;

import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.dto.DepartmentView;
 
@ManagedBean(name="demoBean")
public class DemoBean {
     
    private UploadedFile uploadedfile;
    private SessionFactory sessionFactory;
 
    public UploadedFile getFile() {
        return uploadedfile;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
}

 
    public void setFile(UploadedFile file) {
        this.uploadedfile = uploadedfile;
    }
     
    @Transactional
    public void upload(DepartmentView departmentView) throws IOException {
       
    	Session session = this.sessionFactory.getCurrentSession();   	
    	
        	 String name = uploadedfile.getFileName();
        	    System.out.println("File name: " + name);

        	    String type = uploadedfile.getContentType();
        	    System.out.println("File type: " + type);

        	    long size = uploadedfile.getSize();
        	    System.out.println("File size: " + size);  

        	    InputStream stream = uploadedfile.getInputstream();
        	    byte[] buffer = new byte[(int) size];  
        	    stream.read(buffer, 0, (int) size);  
        	    stream.close();  
        	    
        	    InputStream input = uploadedfile.getInputstream();
        	
            FacesMessage message = new FacesMessage("Succesful", uploadedfile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
}