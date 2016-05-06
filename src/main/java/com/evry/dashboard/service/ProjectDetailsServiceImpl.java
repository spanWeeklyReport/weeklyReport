package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.evry.dashboard.dao.ProjectDetailsDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.mapper.ProjectDetailsMapper;
import com.evry.dashboard.model.ProjectDetails;

@ManagedBean(name = "projectDetailsService")
@SessionScoped
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

    private ProjectDetailsMapper mapper;
    private ProjectDetailsDAO projectDetailsDAO;

    public void setProjectDetailsDAO(ProjectDetailsDAO projectDetailsDAO) {
        this.projectDetailsDAO = projectDetailsDAO;
    }

    public void setMapper(ProjectDetailsMapper mapper) {
        this.mapper = mapper;
    }



    public List < String > getProjectNames() {
        List < String > projectDetails = projectDetailsDAO.getProjectNames();
        return projectDetails;
    }


}