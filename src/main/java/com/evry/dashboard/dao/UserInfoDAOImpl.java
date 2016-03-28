package com.evry.dashboard.dao;

import java.util.List;

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

	@Transactional
	public void add(UserInfo userInfo) 
	{
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(userInfo);
	}

	@Transactional
	public List<UserInfo> getUsers()
	{
		Session session = this.sessionFactory.getCurrentSession();
        List<UserInfo> personsList = session.createQuery("from USER_DETAILS").list();
        return personsList;
	}

	@Transactional
	public boolean isValid(UserInfo userInfo) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		return true;
	}

}
