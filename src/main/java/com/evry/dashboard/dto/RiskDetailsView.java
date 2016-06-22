package com.evry.dashboard.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.evry.dashboard.model.RiskDetails;

@ManagedBean(name="riskDetails")
@SessionScoped
public class RiskDetailsView {
	
	private long riskId;	
	private String RiskType;
	private String RiskDescription;
	private String RiskResponsible;
	private ArrayList<RiskDetailsView> riskDetailsList = new ArrayList(){{add(new RiskDetails());}};
	

	/**
	 * @Getters and setters
	 */
	public long getRiskId() {
		return riskId;
	}
	
	public void setRiskId(long oid) {
		this.riskId = oid;
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
		this.RiskType = riskType;
	}
	
	public String getRiskDescription() {
		return RiskDescription;
	}
	
	public void setRiskDescription(String riskDescription) {
		this.RiskDescription = riskDescription;
	}
	
	public String getRiskResponsible() {
		return RiskResponsible;
	}
	
	public void setRiskResponsible(String riskResponsible) {
		this.RiskResponsible = riskResponsible;
	}
	
}
