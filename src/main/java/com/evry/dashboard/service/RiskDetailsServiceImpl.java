package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.mapper.RiskDetailsMapper;
import com.evry.dashboard.model.RiskDetails;


@ManagedBean(name = "riskDetailsService")
@SessionScoped
public class RiskDetailsServiceImpl implements RiskDetailsService {

    private RiskDetailsMapper mapper;
    private RiskDetailsDAO riskDetailsDAO;
    private RiskDetailsView riskDetailsView;
    private static ArrayList < RiskDetails > riskDetailsList;

    public void setRiskDetailsDAO(RiskDetailsDAO riskDetailsDAO) {
        this.riskDetailsDAO = riskDetailsDAO;
    }

    public void setMapper(RiskDetailsMapper mapper) {
        this.mapper = mapper;
    }




}