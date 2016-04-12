package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "RISK_DETAILS")
public class RiskDetails {
	
	@Id
	@Column(name = "O_ID")
	private long Oid;
	
	@Column(name = "RISK_TYPE")
	private String riskType;
	
	@Column(name = "RISK_DESCRIPTION")
	private String riskDescription;
	
	@Column(name = "RISK_RESPONSIBLE")
	private String riskResponsible;
	
	public long getOid() {
		return Oid;
	}
	
	public void setOid(long oid) {
		Oid = oid;
	}
	
		
	public String getRiskType() {
		return riskType;
	}
	
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	
	public String getRiskDescription() {
		return riskDescription;
	}
	
	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}
	
	public String getRiskResponsible() {
		return riskResponsible;
	}
	
	public void setRiskResponsible(String riskResponsible) {
		this.riskResponsible = riskResponsible;
	}

}