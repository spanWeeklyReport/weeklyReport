package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.springframework.util.CollectionUtils;

import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dao.TaskDetailsDAO;
import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.mapper.RiskDetailsMapper;
import com.evry.dashboard.dto.mapper.TaskDetailsMapper;
import com.evry.dashboard.model.TaskDetails;

@ManagedBean(name = "taskDetailsService")
@SessionScoped
@ViewScoped
public class TaskDetailsServiceImpl implements TaskDetailsService {

	private boolean renderer;
	private boolean logout;
	private TaskDetailsMapper taskDetailsMapper;
	private RiskDetailsMapper riskDetailsMapper;
	private TaskDetailsDAO taskDetailsDAO;
	private RiskDetailsDAO riskDetailsDAO;
	private TaskDetailsView taskDetailsView;
	private long riskId;
	private List<TaskDetailsView> taskDetailsViews;

	public void setTaskDetailsDAO(TaskDetailsDAO taskDetailsDAO) {
		this.taskDetailsDAO = taskDetailsDAO;
	}

	public void setTaskDetailsMapper(TaskDetailsMapper mapper) {
		this.taskDetailsMapper = mapper;
	}

	public void setRiskDetailsDAO(RiskDetailsDAO riskDetailsDAO) {
		this.riskDetailsDAO = riskDetailsDAO;
	}

	public void setRiskDetailsMapper(RiskDetailsMapper riskDeatilsMapper) {
		this.riskDetailsMapper = riskDeatilsMapper;
	}

	public void addTasks(TaskDetailsView taskDetailsView) {

		TaskDetails obj = taskDetailsMapper.getMappedEntity(taskDetailsView);
		taskDetailsDAO.addTasks(obj);

		TaskDetails lastWeekobj = taskDetailsMapper
				.getLastWeekMappedEntity(taskDetailsView);
		int lastWeek = obj.getWeekNo() - 1;
		lastWeekobj.setWeekNo(lastWeek);

		taskDetailsDAO.updateLastWeekTasks(lastWeekobj);

		if (taskDetailsView.getPlannedTask() != "") {

			FacesContext.getCurrentInstance().addMessage(
					"taskform:submit3",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Your details have been submitted !!", null));

		}

	}

	public void checkTasks(TaskDetailsView taskDetailsView) {

		// Fetch selected week's data
		renderer = true;
		TaskDetails taskDetails = taskDetailsDAO.checkTasks(taskDetailsMapper
				.getMappedEntity(taskDetailsView));
		taskDetailsMapper.mapView(taskDetailsView, taskDetails);

		// Fetch last week's data
		int lastWeek = taskDetails.getWeekNo() - 1;

		TaskDetails taskDetailsLastWeek = new TaskDetails();
		taskDetailsLastWeek.setProjectDetails(taskDetails.getProjectDetails());
		taskDetailsLastWeek.setWeekNo(lastWeek);

		taskDetails = taskDetailsDAO.checkTasks(taskDetailsLastWeek);
		taskDetailsView.setLastTaskId(taskDetails.getTaskId());
		taskDetailsView.setLastPlanned(taskDetails.getPlannedTask());
		taskDetailsView.setLastCompleted(taskDetails.getCompletedTask());
		taskDetailsView.setLastHold(taskDetails.getHoldTask());
		taskDetailsView.setLastInProgress(taskDetails.getInprogressTask());

	}
	
			public String checkReport(TaskDetailsView taskDetailsView){
		        TaskDetails taskDetails = taskDetailsDAO.checkReport(taskDetailsMapper
		                     .getMappedEntity(taskDetailsView));
		             
		taskDetailsMapper.mapView(taskDetailsView, taskDetails);
		int lastWeek = taskDetails.getWeekNo() - 1;
		
		TaskDetails taskDetailsLastWeek = new TaskDetails();
		taskDetailsLastWeek.setProjectDetails(taskDetails.getProjectDetails());
		taskDetailsLastWeek.setWeekNo(lastWeek);
		
		taskDetails = taskDetailsDAO.checkTasks(taskDetailsLastWeek);
		taskDetailsView.setLastTaskId(taskDetails.getTaskId());
		taskDetailsView.setLastPlanned(taskDetails.getPlannedTask());
		taskDetailsView.setLastCompleted(taskDetails.getCompletedTask());
		taskDetailsView.setLastHold(taskDetails.getHoldTask());
		taskDetailsView.setLastInProgress(taskDetails.getInprogressTask());
		
		
		       
		             return"report.xhtml";
		  }



	public void viewReport(TaskDetailsView taskDetailsView) {
			if(taskDetailsView.getwNo().equals("true")) {
				taskDetailsView.setWeekNo(0);
			}
		try {
			List<TaskDetails> taskDetails2 = (List<TaskDetails>) taskDetailsDAO.viewReport(taskDetailsMapper.getMappedEntity(taskDetailsView));
			if (!CollectionUtils.isEmpty(taskDetails2)) {
				System.out.println("data found");
				setTaskDetailsViews(taskDetailsMapper.getMappedView(taskDetails2));
			}
			else {
				
				System.out.println("no data found");
				setTaskDetailsViews(null);
				FacesContext.getCurrentInstance().addMessage(
						"viewform:getResult",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"No data found for the selected week", null));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean renderScreen() {

		return renderer;
	}

	public String addRisks(TaskDetailsView taskDetailsView,
			RiskDetailsView riskDetailsView) {

		taskDetailsView.getRiskDetailsList().add(riskDetailsView);
		return null;

	}

	public String deleteRisks(TaskDetailsView taskDetailsView,
			RiskDetailsView riskDetailsView) {

		taskDetailsView.getRiskDetailsList().remove(riskDetailsView);

		return null;
	}

	public List<TaskDetailsView> getTaskDetailsViews() {
		return taskDetailsViews;
	}

	public void setTaskDetailsViews(List<TaskDetailsView> taskDetailsViews) {
		this.taskDetailsViews = taskDetailsViews;
	}
	
	public void DataListener(ValueChangeEvent e) {
		System.out.println("inside ajax func");
		TaskDetailsView taskDetails = new TaskDetailsView();
		taskDetails.setWeekNo(0);
	}

}