package com.evry.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Subqueries;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.model.Department;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.HttpSessionFactory;

public class UserInfoDAOImpl implements UserInfoDAO {
	private SessionFactory sessionFactory;

	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param username
	 * @param password
	 * @param userInfo
	 * @return 
	 */
	@Transactional
	private boolean getUsers(String username, String password, UserInfo userInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean result = false;

		List<UserInfo> userList = session.getNamedQuery("Users.findByUsername")
				.setParameter("username", username)
				.setParameter("password", password).list();

		if (!userList.isEmpty()) { 
			 System.out.println("Login Successful");  
			
			 setSessionData((UserInfo)userList.get(0));  
			 result = true;
		}  
		return result;

	}

	/**
	 * Method to set session variable after user login success
	 * @param userInfo
	 */
	private void setSessionData(UserInfo userInfo) {
		HttpSession httpSession = 	HttpSessionFactory.getSession();		
		httpSession.setAttribute("userName", userInfo.getFirstName());
		httpSession.setAttribute("email", userInfo.getUserName());
		httpSession.setAttribute("userRole", userInfo.getUserRole());
		httpSession.setAttribute("userID", userInfo.getOid());
		
	}

	/* (non-Javadoc)
	 * @see com.evry.dashboard.dao.UserInfoDAO#addUsers(com.evry.dashboard.model.UserInfo)
	 */
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
			System.out.println("username or password missing");

		}

		else {
			return getUsers(username, password, userInfo);

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

			
			session.merge(userInfo);
			String useR = userInfo.getUserRole();
			FacesContext.getCurrentInstance().addMessage(
					"regform:submit5",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							useR +" Successfully added", null));
			
		}

		return false;
		
	}
	
	
	@Transactional
	public List<UserInfo> getUsersList()
	{
		Session session = this.sessionFactory.getCurrentSession();
        List<UserInfo> personsList = session.createQuery("from UserInfo").list();
        return personsList;
	}
	
	@Transactional
	public String deleteUsers(UserInfo userInfo) { 
		
		String email = userInfo.getUserName();

		System.out.println("++++"+email);
		
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("Delete from UserInfo where userName = '"+email +"' ");
		q.executeUpdate();
		return null;
		
		
	}
	@Transactional
	public UserInfo editUsers(UserInfo userInfo){ 
		
		return getUser(userInfo);
	}
	
	@Transactional
	public UserInfo getUser(UserInfo userInfo){ 
		String email = userInfo.getUserName();
		Session session = this.sessionFactory.getCurrentSession();
		Query qry = session.createQuery("FROM UserInfo where userName = '"+email +"' ");
		
		List<UserInfo> rs = qry.list();
		UserInfo user = null;
		if(!rs.isEmpty()){ 
			
			user = rs.get(0);
		}
		
		
		return user;
		
	}
	
	@Transactional
    public long getUserID(UserInfo userInfo) {
              
              Session session = this.sessionFactory.getCurrentSession();
              String username = userInfo.getUserName();
              
              Query query =  session.createQuery("select E.oid from UserInfo E where userName = '"+ username +"'" );
              List userNames = query.list();
              long uID = (long)userNames.get(0);
              return uID;
              
       }

	
	
	@Transactional
    public UserInfo getUserByID(Long id){
    Session session = this.sessionFactory.getCurrentSession();
    
    Query query = session.createQuery("from UserInfo where oid = '"+ id +"' " );
    List<UserInfo> rs = query.list();
    UserInfo user = null;
    if(!rs.isEmpty()){ 
           
           user = rs.get(0);
    }
           return user;
    }
     
	 @Transactional
	 public List<UserInfo> employeeReportStatus(UserInfo userInfo, int weekNo) {
		
		 System.out.println(weekNo);
		 Session session = this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from UserInfo where oid not in (select userInfo from TaskDetails where WeekNo = '"+weekNo + "' ) ");
		 List<UserInfo> result = query.list();
		
		  
		 return result;
	 }
	 
	 @Transactional
		public void modifyUser(UserInfo userInfo) {
			Session session = this.sessionFactory.getCurrentSession();
			session.merge(userInfo);
			
		}

		
	
}
