package com.evry.dashboard.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.evry.dashboard.model.RiskDetails;

public class RiskDetailsDAOImpl implements RiskDetailsDAO {
	
private SessionFactory sessionFactory;
	

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.evry.dashboard.dao.RiskDetailsDAO#addRisks(com.evry.dashboard.model.RiskDetails)
	 */
	@Transactional
	public Long addRisks(RiskDetails riskDetails) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(riskDetails);
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.evry.dashboard.dao.RiskDetailsDAO#getRisks(com.evry.dashboard.model.RiskDetails)
	 */
	@Transactional
	public RiskDetails getRisks(RiskDetails riskDetails)
	{
		return riskDetails;
	}
	
	/* (non-Javadoc)
	 * @see com.evry.dashboard.dao.RiskDetailsDAO#checkRisks(com.evry.dashboard.model.RiskDetails)
	 */
	@Transactional
	public RiskDetails checkRisks(RiskDetails riskDetails) 
	{
		 return riskDetails;
	}
	

}
