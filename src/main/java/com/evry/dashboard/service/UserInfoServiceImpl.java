package com.evry.dashboard.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.ApplicationMailer;
import com.evry.dashboard.util.HttpSessionFactory;
import com.evry.dashboard.service.TaskDetailsService;

@ManagedBean(name = "userInfoService")
@SessionScoped
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoMapper mapper;
	private UserInfoDAO userInfoDAO;
	//private boolean renderer;
	private boolean logout;
	private TaskDetailsService taskDetailsService;
	private List<UserInfoView> userInfoViews;
	private List<UserInfoView> userInfoList;
	private UserInfoView useInfoView;
	private String hostname;
	private boolean renderer = false;
	
	
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public void setMapper(UserInfoMapper mapper) {
		this.mapper = mapper;
	}

	public List<UserInfoView> getUserInfoViews() {
		return userInfoViews;
	}

	public void setUserInfoViews(List<UserInfoView> userInfoViews) {
		this.userInfoViews = userInfoViews;
	}

	public void addUser(UserInfoView userInfoView) {
		UserInfo obj = mapper.getMappedEntity(userInfoView);
		// userInfoDAO.add(obj);
	}
	
	
	public void setTaskDetailsService(TaskDetailsService taskDetailsService) {
		this.taskDetailsService = taskDetailsService;
	}
	
	

	public List<UserInfoView> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfoView> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public UserInfoView getUseInfoView() {
		return useInfoView;
	}

	public void setUseInfoView(UserInfoView useInfoView) {
		this.useInfoView = useInfoView;
	}

	public List<UserInfoView> getUsers() {
		
		
			List<UserInfo> userInfos = (List<UserInfo>) userInfoDAO.getUsersList();
			List<UserInfoView> userViews = new ArrayList<UserInfoView>();
			if (!CollectionUtils.isEmpty(userInfos)) {
				System.out.println("user list found");
				for (UserInfo userInfo : userInfos)
					userViews.add(mapper.getMapView(userInfo));
				return userViews;
			
			}
			
			else {
				System.out.println("user list not found");
				return null;
			}
			
				
	}

	public String isValid(UserInfoView userInfoView) {
		boolean result = userInfoDAO.isValid(mapper
				.getMappedEntity(userInfoView));

		if (result) {
			
			return "dashboard.xhtml";
		} else {
            
			FacesContext context = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = context.getExternalContext(); 
	        context.addMessage(
					"signupform:signupbtn",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please enter valid login details!", "Please Try Again!"));

			return "index.xhtml";
		}

	}

	public void addUserDetails(UserInfoView userInfoView) {

		UserInfo obj = mapper.getMappedEntity(userInfoView);
		userInfoDAO.userExists(obj);

	}

	public String logout() {
		renderer = false;
		logout = true;
		
		taskDetailsService.setRender();
		
		HttpSessionFactory.getSession().invalidate();
		
		System.out.println("successfully logout");
		;
		return "index.xhtml?faces-config=true";

	}
	
	public String deleteUsers(UserInfoView userInfoView) { 
		
		UserInfo userView = mapper.getMappedEntity(userInfoView);
		userInfoDAO.deleteUsers(userView);
		
		FacesContext.getCurrentInstance().addMessage(
				"form_signup_frm:Delete",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"User has been deleted", "Please Try Again!"));

		return null;
		
	}
	
	public String editUsers(UserInfoView userInfoView){
		
		System.out.println("inside edit function"); 
		UserInfo uInfo = mapper.getMappedEntity(userInfoView);
		userInfoDAO.editUsers(uInfo);
		  setUseInfoView(mapper.getMapView(uInfo));    
		return "edit-user";
		
		
	}
	
	public boolean renderScreen() {

		return renderer;
	}
	
	public String renderHome(TaskDetailsView taskDetailsView) {
		
		taskDetailsView.setWeekNo(0);
		 renderer = false;
		return "dashboard.xhtml";
	}
	
	
	
	
	public void employeeReportStatus(TaskDetailsView taskDetailsView, UserInfoView userView) { 
		
		   renderer = true;
		
		   int weekNo = taskDetailsView.getWeekNo();
		   System.out.println(weekNo);
		   
		   List<UserInfo> userObj = (List<UserInfo>) userInfoDAO.employeeReportStatus(mapper.getMappedEntity(userView), weekNo);
			if (!CollectionUtils.isEmpty(userObj)) {
				
				System.out.println("users with no report found");
				setUserInfoViews(mapper.getMappedView(userObj));
			} else {

				System.out.println("nothing returned");
				setUserInfoViews(null);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"No data found for the selected week", null));
			}
			
			
	}
	
	
	 public String modifyUser(UserInfoView userInfoView) {
		   
		   UserInfo userInfo = mapper.getMappedEntity(userInfoView);
		   userInfoDAO.modifyUser(userInfo);
		   
		   FacesContext.getCurrentInstance().addMessage(
					"projectEditForm:editProject",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"User details have been edited", "Please Try Again!"));
		   return "user_reg";
	   }
	 
	 public void sendEmail(UserInfoView userInfoView) 
	    {
		 
		 sendMail(userInfoView);
		   
	        FacesContext.getCurrentInstance().addMessage(
					"sendEmail:smail",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Mail sent", "Please Try Again!"));
	        
	        
	    }
	 
	 public void sendEmailAll (UserInfoView userInfoView){
		 
		 List<UserInfoView> userView = getUserInfoViews();
		
		 if (!CollectionUtils.isEmpty(userView)) {
				
				for (UserInfoView userInfoView2 : userView)
			                 sendMail(userInfoView2);
			
			
			}
		 
		 FacesContext.getCurrentInstance().addMessage(
					"employee-report:remind-all",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Mail has been sent to multiple recepients", "Please Try Again!"));
	        
		
		 
		 
	 }
	 
	 public void sendMail(UserInfoView userInfoView){
		 
		 String email = userInfoView.getUserName();
		 
	        //Create the application context
	        ApplicationContext context = new FileSystemXmlApplicationContext("C://Users//mehak.sapra//git//weeklyReport//src//main//webapp//WEB-INF//applicationContext.xml");
	       // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	         
	        //Get the mailer instance
	        ApplicationMailer mailer = (ApplicationMailer) context.getBean("mailService");
	        
	        String from = "admin@WeekyReport.com";
	        String to = email;
	        String subject = "Reminder from Weekly Report!";
	        String msg = "message from weekly report";
	        
	        
	        //Send a composed mail
	        try {
				mailer.sendMimeMessage(from, to, subject, msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	 
	        //Send a pre-configured mail
	        mailer.sendPreConfiguredMail("Mail has been sent to the recipient " + email );
		 
	 }
	 
     public void sendHRMail(){
		 		
	        //Create the application context
	        ApplicationContext context = new FileSystemXmlApplicationContext("C://Users//mehak.sapra//git//weeklyReport//src//main//webapp//WEB-INF//applicationContext.xml");
	       // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	         
	        //Get the mailer instance
	        ApplicationMailer mailer = (ApplicationMailer) context.getBean("mailService");
	        
	        String from = "admin@WeekyReport.com";
	        String to[] = {"mehak.sapra@spanservices.com","bhanu.rattan@spanservices.com"};
	        String subject = "Fill In HR Trends!";
	        String msg = "Fill in HR Trends";
	        
	        
	        //Send a composed mail
	        try {
				mailer.remindHr(from, to, subject, msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	 
	        //Send a pre-configured mail
	        mailer.sendPreConfiguredMail("Mail has been sent to the recipient " + to );
	        FacesContext.getCurrentInstance().addMessage(
					"mailHr:remindHr",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Reminder Sent", "Please Try Again!"));
		 
	 }
     
     
     public List<String> getfirstName() {

         List<String> userNames = userInfoDAO.firstNameList();
         return userNames;
     }

	 
	    


			
  }
