package com.evry.dashboard.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.util.CollectionUtils;

import com.evry.dashboard.dao.RiskDetailsDAO;
import com.evry.dashboard.dao.TaskDetailsDAO;
import com.evry.dashboard.dto.RiskDetailsView;
import com.evry.dashboard.dto.TaskDetailsView;
import com.evry.dashboard.dto.mapper.RiskDetailsMapper;
import com.evry.dashboard.dto.mapper.TaskDetailsMapper;
import com.evry.dashboard.model.TaskDetails;
import com.evry.dashboard.util.HttpSessionFactory;

@ManagedBean(name = "taskDetailsService")
@SessionScoped
public class TaskDetailsServiceImpl implements TaskDetailsService {

	private boolean renderer = false;
	private boolean logout;
	private TaskDetailsMapper taskDetailsMapper;
	private RiskDetailsMapper riskDetailsMapper;
	private TaskDetailsDAO taskDetailsDAO;
	private RiskDetailsDAO riskDetailsDAO;

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
	
	public List<TaskDetailsView> getTaskDetailsViews() {
		return taskDetailsViews;
	}

	public void setTaskDetailsViews(List<TaskDetailsView> taskDetailsViews) {
		this.taskDetailsViews = taskDetailsViews;
	}

	/*
	 * Add/Update task details for current as well as last week (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#addTasks(com.evry.dashboard
	 * .dto.TaskDetailsView)
	 */
	public void addTasks(TaskDetailsView taskDetailsView) {
		
		HttpSession session = HttpSessionFactory.getSession();
		   long userId=(Long)session.getAttribute("userID");
			
			taskDetailsView.setUserId(userId);
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

	/*
	 * Fetch task details corresponding to project name and week selected
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#checkTasks(com.evry.dashboard
	 * .dto.TaskDetailsView)
	 */
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

		if (taskDetailsView.getTaskId() != 0) {

			FacesContext.getCurrentInstance().addMessage(
					"taskform:fetch",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Report for the selected week:", null));
		}

		else {

			FacesContext
					.getCurrentInstance()
					.addMessage(
							"taskform:fetch",
							new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"No report was found for the selected week. Create a new report:",
									null));

		}

	}

	/*
	 * Generates a web report for the selected as well as previous week
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#checkReport(com.evry.dashboard
	 * .dto.TaskDetailsView)
	 */
	public String checkReport(TaskDetailsView taskDetailsView) {
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

		return "report";
	}

	/*
	 * Fetches the risks and project updates as per report type (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#viewReport(com.evry.dashboard
	 * .dto.TaskDetailsView)
	 */
	public void viewReport(TaskDetailsView taskDetailsView) {
		if (taskDetailsView.getwNo().equals("true")) {
			taskDetailsView.setWeekNo(0);
		}
		try {
			List<TaskDetails> taskDetails2 = (List<TaskDetails>) taskDetailsDAO
					.viewReport(taskDetailsMapper
							.getMappedEntity(taskDetailsView));
			if (!CollectionUtils.isEmpty(taskDetails2)) {
				renderer = true;
				System.out.println("data found");
				setTaskDetailsViews(taskDetailsMapper
						.getMappedView(taskDetails2));
			} else {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evry.dashboard.service.TaskDetailsService#renderScreen()
	 */
	public boolean renderScreen() {

		return renderer;
	}

	/*
	 * Add risks to UI (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#addRisks(com.evry.dashboard
	 * .dto.TaskDetailsView, com.evry.dashboard.dto.RiskDetailsView)
	 */
	public String addRisks(TaskDetailsView taskDetailsView,
			RiskDetailsView riskDetailsView) {

		RiskDetailsView detailsView = new RiskDetailsView();
		if (riskDetailsView.getRiskType() != ""
				|| riskDetailsView.getRiskDescription() != ""
				|| riskDetailsView.getRiskResponsible() != "") {

			detailsView
					.setRiskDescription(riskDetailsView.getRiskDescription());
			detailsView
					.setRiskDetailsList(riskDetailsView.getRiskDetailsList());
			detailsView.setRiskId(riskDetailsView.getRiskId());
			detailsView
					.setRiskResponsible(riskDetailsView.getRiskResponsible());
			detailsView.setRiskType(riskDetailsView.getRiskType());

			taskDetailsView.getRiskDetailsList().add(detailsView);

			detailsView = new RiskDetailsView();

		}

		else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please enter all the fields in risk details !!",
							null));

		}

		return null;

	}

	/*
	 * Deletes risks (non-Javadoc)
	 * 
	 * @see
	 * com.evry.dashboard.service.TaskDetailsService#deleteRisks(com.evry.dashboard
	 * .dto.TaskDetailsView, com.evry.dashboard.dto.RiskDetailsView)
	 */
	public String deleteRisks(TaskDetailsView taskDetailsView,
			RiskDetailsView riskDetailsView) {

		taskDetailsView.getRiskDetailsList().remove(riskDetailsView);

		return null;
	}

	

	public String setRender() {

		renderer = false;

		return "dashboard.xhtml";

	}

	public String setWeek(TaskDetailsView taskDetailsView) {

		renderer = false;
		taskDetailsView.setWeekNo(0);
		return "dashboard";

	}
	
	public void employeeReportStatus(TaskDetailsView taskDetailsView) { 
		
	   int weekNo = taskDetailsView.getWeekNo();
	   System.out.println(weekNo);
	   
	   List<TaskDetails> taskDetailsobj = (List<TaskDetails>) taskDetailsDAO
				.employeeReportStatus(taskDetailsMapper
						.getMappedEntity(taskDetailsView));
		if (!CollectionUtils.isEmpty(taskDetailsobj)) {
			
			System.out.println("data found");
			setTaskDetailsViews(taskDetailsMapper
					.getMappedView(taskDetailsobj));
		} else {

			System.out.println("no data found");
			setTaskDetailsViews(null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"No data found for the selected week", null));
		}

		
	
		
	}
	

}