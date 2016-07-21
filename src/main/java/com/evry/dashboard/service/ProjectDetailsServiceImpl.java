package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import com.evry.dashboard.dao.ProjectDetailsDAO;
import com.evry.dashboard.dto.ProjectDetailsView;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.ProjectDetailsMapper;
import com.evry.dashboard.model.ProjectDetails;
import com.evry.dashboard.util.HttpSessionFactory;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.ProjectTechnology;

@ManagedBean(name = "projectDetailsService")
@SessionScoped
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	private ProjectDetailsMapper projectDetailsmapper;
	private ProjectDetailsDAO projectDetailsDAO;
	private ProjectDetailsView projDetailsView;

	public ProjectDetailsServiceImpl() {

	}

	public void setProjectDetailsDAO(ProjectDetailsDAO projectDetailsDAO) {
		this.projectDetailsDAO = projectDetailsDAO;
	}

	public void setMapper(ProjectDetailsMapper mapper) {
		this.projectDetailsmapper = mapper;
	}
	
	public ProjectDetailsView getProjDetailsView() {
		return projDetailsView;
	}

	public void setProjDetailsView(ProjectDetailsView projDetailsView) {
		this.projDetailsView = projDetailsView;
	}

	public List<String> getProjectNames() {

		List<String> projectDetails = projectDetailsDAO.getProjectNames();
		return projectDetails;
	}

	/*  To add new project
	 * (non-Javadoc)
	 * @see com.evry.dashboard.service.ProjectDetailsService#addProject(com.evry.dashboard.dto.ProjectDetailsView)
	 */
	public void addProject(ProjectDetailsView projectDetailsView) {
		

		ProjectDetails obj = projectDetailsmapper.getMappedEntity(projectDetailsView);
		projectDetailsDAO.checkProject(obj);
		projectDetailsView.setProjectName(null);
		projectDetailsView.setProjectStatus(null);
		projectDetailsView.setProjectDepartment(null);
		projectDetailsView.setStartDate(null);
		projectDetailsView.setEndDate(null);
		

	}
	
	public List<ProjectDetailsView> getProjectList() {
		List<ProjectDetails> proDetails = (List<ProjectDetails>) projectDetailsDAO.getProjectList();
		List<ProjectDetailsView> projectDeatilViews = new ArrayList<ProjectDetailsView>();
		for (ProjectDetails projectDetails : proDetails)
			projectDeatilViews.add(projectDetailsmapper.getMappedView(projectDetails));
		return projectDeatilViews;
	}

	
	public void projectDepartment(){
		String tech = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("tech");
		System.out.println("#####"+ tech);
		
		
		
	}
	
	public String deleteProjects(ProjectDetailsView projectDetailsView) { 
			
			ProjectDetails projDetails = projectDetailsmapper.getMappedEntity(projectDetailsView);
			projectDetailsDAO.deleteProjects(projDetails);
			
			FacesContext.getCurrentInstance().addMessage(
					"projectForm:Delete",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Project has been deleted", "Please Try Again!"));
	
			return null;
			
		}
	
   public String editProjects(ProjectDetailsView projectDetailsView){
		
		System.out.println("inside edit projects function"); 
        ProjectDetails pDetails = projectDetailsDAO.editProjects(projectDetailsmapper.getMappedEntity(projectDetailsView));
		setProjDetailsView(projectDetailsmapper.getMappedView(pDetails));
       return "editProjects";
		
		
	}
   
   public String modifyProjects(ProjectDetailsView projectDetailsView) {
	   
	   ProjectDetails projectDetails = projectDetailsmapper.getMappedEntity(projectDetailsView);
	   projectDetailsDAO.modifyProjects(projectDetails);
	   
	   FacesContext.getCurrentInstance().addMessage(
				"projectEditForm:editProject",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Project has been modified", "Please Try Again!"));
	   return "add_projects";
   }

	
	

}
