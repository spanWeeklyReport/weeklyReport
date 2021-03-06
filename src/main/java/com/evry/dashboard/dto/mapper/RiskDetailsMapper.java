package com.evry.dashboard.dto.mapper;

import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.model.RiskDetails;

public class RiskDetailsMapper {

	/**
	 * @param riskDetails
	 * @return
	 */
	public RiskDetailsView getMappedView(RiskDetails riskDetails) {
		RiskDetailsView riskDetailsView = new RiskDetailsView();
		riskDetailsView.setRiskId(riskDetails.getRiskId());
		riskDetailsView.setRiskType(riskDetails.getRiskType());
		riskDetailsView.setRiskDescription(riskDetails.getRiskDescription());
		riskDetailsView.setRiskResponsible(riskDetails.getRiskResponsible());
		return riskDetailsView;
	}

	/**
	 * @param riskDetails
	 * @return
	 */
	public RiskDetailsView getMappedView(RiskDetailsView riskDetails) {
		RiskDetailsView riskDetailsView = new RiskDetailsView();
		riskDetailsView.setRiskId(riskDetails.getRiskId());
		riskDetailsView.setRiskType(riskDetails.getRiskType());
		riskDetailsView.setRiskDescription(riskDetails.getRiskDescription());
		riskDetailsView.setRiskResponsible(riskDetails.getRiskResponsible());
		return riskDetailsView;
	}

	/**
	 * @param riskDetailsView
	 * @return
	 */
	public RiskDetails getMappedEntity(RiskDetailsView riskDetailsView) {
		RiskDetails riskDetails = new RiskDetails();
		riskDetails.setRiskId(riskDetailsView.getRiskId());
		riskDetails.setRiskType(riskDetailsView.getRiskType());
		riskDetails.setRiskDescription(riskDetailsView.getRiskDescription());
		riskDetails.setRiskResponsible(riskDetailsView.getRiskResponsible());
		return riskDetails;
	}

}
