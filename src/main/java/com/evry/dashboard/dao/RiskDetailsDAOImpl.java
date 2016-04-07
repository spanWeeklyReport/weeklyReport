package com.evry.dashboard.dao;

import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.RiskDetails;
import com.evry.dashboard.model.TaskDetails;

public class RiskDetailsDAOImpl implements RiskDetailsDAO {
	
private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addRisks(RiskDetails riskDetails) 
	{
		
	}
	
	@Transactional
	public RiskDetails getRisks(RiskDetails riskDetails)
	{
		return riskDetails;
	}
	
	@Transactional
	public RiskDetails checkRisks(RiskDetails riskDetails) 
	{
		 return riskDetails;
	}
	

}
