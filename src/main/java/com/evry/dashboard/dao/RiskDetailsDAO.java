package com.evry.dashboard.dao;

import java.util.List;

import org.hibernate.Query;

import com.evry.dashboard.model.RiskDetails;
import com.evry.dashboard.model.TaskDetails;

public interface RiskDetailsDAO {
	
	void addRisks(RiskDetails riskDetails);
	RiskDetails getRisks(RiskDetails riskDetails);
	RiskDetails checkRisks(RiskDetails riskDetails);

}
