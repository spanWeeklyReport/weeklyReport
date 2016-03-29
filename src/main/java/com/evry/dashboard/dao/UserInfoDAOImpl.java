package com.evry.dashboard.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO 
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	//@Transactional
	//public void add(UserInfo userInfo) 
	//{
	
      //  session.persist(userInfo);
	//}

	@Transactional
	private boolean getUsers(String username,String password)
	{
		
		Session session = this.sessionFactory.getCurrentSession();
        boolean result=false;

        List<UserInfo> rs = session.getNamedQuery("Users.findByUsername").setParameter("username", username)
                .setParameter("password", password).list();
        	
        boolean userFound = false;
		
      //  System.out.println("hi");
      //  System.out.println(rs);

		if (!rs.isEmpty()) {
			userFound= true;
			System.out.println("Login Successful");
			return true;
		}
		
			 FacesMessage message = new FacesMessage("Invalid username or password ");
	            FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage(null, message);
		
	          return result;
	
        }

	@Transactional
	public boolean isValid(UserInfo userInfo) 
	{
		String username= userInfo.getUserName();
		String password=userInfo.getPassword();
		

 

        if((username.equals("") || password.equals("")) )
        {
        	if(username.equals("") && password.equals(""))
            {
           	 FacesMessage message = new FacesMessage("username and password missing ");
   	         FacesContext context = FacesContext.getCurrentInstance();
   	         context.addMessage(null, message);
               }
        	else if(username.equals(""))
            {
        	 FacesMessage message = new FacesMessage(" username missing ");
	         FacesContext context = FacesContext.getCurrentInstance();
	         context.addMessage(null, message);
            }
              else if(password.equals(""))
            {
        	 FacesMessage message = new FacesMessage("password missing ");
	         FacesContext context = FacesContext.getCurrentInstance();
	         context.addMessage(null, message);
            }
        	
        }
        	
        
        else
          {
        	return getUsers(username,password);  
             
         }
        
       


       

          
return false;
	}

	public Query getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
