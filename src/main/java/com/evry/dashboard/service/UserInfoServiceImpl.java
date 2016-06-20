package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.HttpSessionFactory;

@ManagedBean(name = "userInfoService")
@SessionScoped
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoMapper mapper;
	private UserInfoDAO userInfoDAO;
	private boolean renderer;
	private boolean logout;

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public void setMapper(UserInfoMapper mapper) {
		this.mapper = mapper;
	}

	public void addUser(UserInfoView userInfoView) {
		UserInfo obj = mapper.getMappedEntity(userInfoView);
		// userInfoDAO.add(obj);
	}

	public List<UserInfoView> getUsers() {
		List<UserInfo> userInfos = (List<UserInfo>) userInfoDAO.getUsersList();
		List<UserInfoView> userInfoViews = new ArrayList();
		for (UserInfo userInfo : userInfos)
			userInfoViews.add(mapper.getMappedView(userInfo));
		return userInfoViews;
	}

	public String isValid(UserInfoView userInfoView) {
		boolean result = userInfoDAO.isValid(mapper
				.getMappedEntity(userInfoView));

		if (result) {
			
			String uRoll = userInfoDAO.getUserRole(mapper
						.getMappedEntity(userInfoView));
			String uName = userInfoDAO.getUserName(mapper
					.getMappedEntity(userInfoView));
			System.out.println("*******"+uRoll);
			System.out.println("*******"+uName);
			// get Http Session and store username
			HttpSession session = HttpSessionFactory.getSession();
			session.setAttribute("email", userInfoView.getUserName());
			session.setAttribute("userRole", uRoll);
			session.setAttribute("userName", uName);

			
			

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
		
		HttpSessionFactory.getSession().invalidate();
		System.out.println("successfully logout");
		;
		return "index.xhtml";

	}
}
