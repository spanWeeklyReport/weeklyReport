package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO 
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void add(UserDetails userDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(userDetails);
	}

	@Transactional
	public List<UserDetails> getUsers()
	{
		Session session = this.sessionFactory.getCurrentSession();
        List<UserDetails> personsList = session.createQuery("from USER_DETAILS").list();
        return personsList;
	}

	@Transactional
	public boolean isValid(UserDetails userDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		return true;
	}
	
	

}
