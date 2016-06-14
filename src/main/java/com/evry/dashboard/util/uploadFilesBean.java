package com.evry.dashboard.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.evry.dashboard.dto.DepartmentView;

@ManagedBean(name = "fileUploadController")
@SessionScoped
public class uploadFilesBean {
   
    //Primitives
    private static final int BUFFER_SIZE = 6124;    
    private String folderToUpload;
    private SessionFactory sessionFactory;
    private UploadedFile uploadedFile;
   
    public void setFolderToUpload(String folderToUpload) {
                                this.folderToUpload = folderToUpload;
                }

                public void setSessionFactory(SessionFactory sessionFactory) {
                                this.sessionFactory = sessionFactory;
                }

                public UploadedFile getUploadedFile() {
                                return uploadedFile;
                }

                public void setUploadedFile(UploadedFile uploadedFile) {
                                this.uploadedFile = uploadedFile;
                }

                /** Creates a new instance of UploadBean */
    public uploadFilesBean() {
    }
    
     @Transactional 
    public void upload( DepartmentView departmentView) {
                   
                   System.out.println("session ===== " + sessionFactory);
                   
//            Session session = this.sessionFactory.getCurrentSession();
       String fileName = uploadedFile.getFileName();
       System.out.println(fileName);
      
       String contentType = uploadedFile.getContentType();
       System.out.println(contentType);
       byte[] contents = uploadedFile.getContents(); // Or getInputStream()
       ExternalContext extContext = 
            FacesContext.getCurrentInstance().getExternalContext();
       
       File result = new File(extContext.getRealPath
            ("//webapp//images//" + fileName));
       
       try {
           FileOutputStream fileOutputStream = new FileOutputStream(result);

           byte[] buffer = new byte[BUFFER_SIZE];

           int bulk;
           InputStream inputStream = uploadedFile.getInputstream();
           while (true) {
               bulk = inputStream.read(buffer);
               if (bulk < 0) {
                   break;
               }
               fileOutputStream.write(buffer, 0, bulk);
               fileOutputStream.flush();
           }

           fileOutputStream.close();
           inputStream.close();

           FacesMessage msg = 
                       new FacesMessage("File Description", "file name: " +
                       fileName + "<br/>file size: " + 
                       uploadedFile.getSize() / 1024 + 
                       " Kb<br/>content type: " + 
                       uploadedFile.getContentType() + 
                               "<br/><br/>The file was uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, msg);
//             session.persist(departmentView);

       } catch (IOException e) {
           e.printStackTrace();

           FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                          "The files were not uploaded!", "");
           FacesContext.getCurrentInstance().addMessage(null, error);
       
    }
}
    }
