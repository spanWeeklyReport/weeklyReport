package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.RiskDetails;
import com.evry.dashboard.model.TaskDetails;

/**
 * @author Mehak.Sapra
 * DAO Interface for Risk Details
 *
 */
public interface RiskDetailsDAO {
	
	Long addRisks(RiskDetails riskDetails);
	RiskDetails getRisks(RiskDetails riskDetails);
	RiskDetails checkRisks(RiskDetails riskDetails);

}
