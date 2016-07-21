package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.util.CollectionUtils;

import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.HttpSessionFactory;
import com.evry.dashboard.service.TaskDetailsService;

@ManagedBean(name = "userInfoService")
@SessionScoped
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoMapper mapper;
	private UserInfoDAO userInfoDAO;
	private boolean renderer;
	private boolean logout;
	private TaskDetailsService taskDetailsService;
	private List<UserInfoView> userInfoViews;
	private List<UserInfoView> userInfoList;
	private UserInfoView useInfoView;
 
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

			FacesContext.getCurrentInstance().addMessage(
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
	
	public void employeeReportStatus(TaskDetailsView taskDetailsView, UserInfoView userView) { 
		
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


			
  }
