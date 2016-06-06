package com.evry.dashboard.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {
	private SessionFactory sessionFactory;

	// private String islogin;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	private boolean getUsers(String username, String password) {

		Session session = this.sessionFactory.getCurrentSession();
		boolean result = false;

		List<UserInfo> rs = session.getNamedQuery("Users.findByUsername")
				.setParameter("username", username)
				.setParameter("password", password).list();

		boolean userFound = false;

		if (!rs.isEmpty()) {
			userFound = true;
			System.out.println("Login Successful");
			return true;
		} else {

			return false;
		}

	}

	@Transactional
	public void addUsers(UserInfo userInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userInfo);
	}

	@Transactional
	public boolean isValid(UserInfo userInfo) {
		String username = userInfo.getUserName();
		String password = userInfo.getPassword();

		if ((username.equals("") || password.equals(""))) {
			if (username.equals("") && password.equals("")) {
				System.out.println("username and password missing");
			} else if (username.equals("")) {
				System.out.println("username  missing");
			} else if (password.equals("")) {
				System.out.println("password missing");
				;
			}

		}

		else {
			return getUsers(username, password);

		}

		return false;

	}
	
	@Transactional
	public boolean userExists(UserInfo userInfo) {
		
		Session session = this.sessionFactory.getCurrentSession();
		String usernameExists = userInfo.getUserName();
		List<UserInfo> rst = session.getNamedQuery("Users.userExists")
				.setParameter("username", usernameExists).list();
				

		boolean userCheck = false;

		if (!rst.isEmpty()) {
			userCheck = true;
			System.out.println("User Already Exists");
			
			FacesContext.getCurrentInstance().addMessage(
					"regform:submit5",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"This email has already been registered", null));
			
			return true;
		} else {

			session.persist(userInfo);
			FacesContext.getCurrentInstance().addMessage(
					"regform:submit5",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"User Successfully added", null));
		}

		return false;
		
	}
	

	public Query getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
