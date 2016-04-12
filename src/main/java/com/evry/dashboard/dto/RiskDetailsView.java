package com.evry.dashboard.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.evry.dashboard.model.RiskDetails;

@ManagedBean(name="riskDetails")

public class RiskDetailsView {
	
	private long oid;
	
	private String RiskType;
	private String RiskDescription;
	private String RiskResponsible;
	private ArrayList<RiskDetailsView> riskDetailsList = new ArrayList(){{add(new RiskDetails()); add(new RiskDetails());}};
	

	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
		
	public ArrayList<RiskDetailsView> getRiskDetailsList() {
		return riskDetailsList;
	}

	public void setRiskDetailsList(ArrayList<RiskDetailsView> riskDetailsList) {
		this.riskDetailsList = riskDetailsList;
	}

	public String getRiskType() {
		return RiskType;
	}
	
	public void setRiskType(String riskType) {
		RiskType = riskType;
	}
	
	public String getRiskDescription() {
		return RiskDescription;
	}
	
	public void setRiskDescription(String riskDescription) {
		RiskDescription = riskDescription;
	}
	
	public String getRiskResponsible() {
		return RiskResponsible;
	}
	
	public void setRiskResponsible(String riskResponsible) {
		RiskResponsible = riskResponsible;
	}
	
}
