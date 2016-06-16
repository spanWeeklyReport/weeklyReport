package com.evry.dashboard.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

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

import com.evry.dashboard.dao.DepartmentDAO;
import com.evry.dashboard.dao.DepartmentDAOImpl;
import com.evry.dashboard.dto.DepartmentView;
import com.evry.dashboard.dto.Manager;
import com.evry.dashboard.dto.mapper.DepartmentMapper;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.Department;

@ManagedBean(name = "uploadFilesBean")
@SessionScoped
public class UploadFilesBean {

	// Primitives
	private static final int BUFFER_SIZE = 6124;

	private SessionFactory sessionFactory;

	private DepartmentMapper departmentMapper;
	
	private DepartmentDAO departmentDAO;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}
	
	
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}


	/** Creates a new instance of UploadBean */

	@Transactional
	public void upload(DepartmentView departmentView) {
		Session session = this.sessionFactory.getCurrentSession();
		
	 String fileName = departmentView.getUploadedFile().getFileName(); 
		String contentType = departmentView.getUploadedFile().getContentType();
		 
		byte[] contents = departmentView.getUploadedFile().getContents(); // Or
																	// getInputStream()
		 
		ExternalContext extContext = FacesContext.getCurrentInstance()
				.getExternalContext();
    
		
		String filePathPrefix="C://Users//mehak.sapra//git//weeklyReport//src//main//webapp";
		String filePath="//images//"+fileName; 
		String fileLocaltion=filePathPrefix+filePath;
		File result = new File(fileLocaltion);
		String location ="../images/"+fileName;

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(result);

			byte[] buffer = new byte[BUFFER_SIZE];

			int bulk;
			InputStream inputStream = departmentView.getUploadedFile().getInputstream();
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
			
			
			 
			departmentView.setLocaltion(location);
			departmentView.setImageData(contents);
			Department obj = departmentMapper.getMappedEntity(departmentView);
			departmentDAO.add(obj);
			
			 
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,	"file name: " + fileName + " was uploaded.", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// session.persist(departmentView);

		} catch (IOException e) {
			e.printStackTrace();

			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"The files were not uploaded!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);

		}
	}
}