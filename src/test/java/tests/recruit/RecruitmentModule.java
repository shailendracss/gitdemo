package tests.recruit;

import org.testng.annotations.Test;

import or.common.Dashboard;
import or.common.Navigator;
import or.common.SideBar_Recruitment;
import or.recruit.ApplicantListing;
import or.recruit.CreateJob;
import or.recruit.CreateNewTask;
import or.recruit.JobListing;
import or.recruit.RecruitmentDashboard;
import or.recruit.TaskList;

public class RecruitmentModule {

	private void navigateToApplicantListing() {
		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(ApplicantListing.title, rctDsh.link_ApplicantList);
	}

	/**
	 *where is proper comments?
	 *
	 * @author user
	 * 
	 *         Covered:
	 * 
	 * 
	 *         Pending:
	 * 
	 * 
	 *         Depends on:
	 * 
	 */
	@Test(description = "HCM196_Recruit_TC01_RAdmin_ApplicantListingColumnHeader")
	private void HCM196_Recruit_TC01_RAdmin_ApplicantListingColumnHeader() {
		//

		/*
		 * what is this?
		 * 
		 * 
		
		 * */

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();
		appList.verifyColumnHeader();

	}

	/**
	 * @author user
	 * 
	 *         Covered:
	 * 
	 * 
	 *         Pending:
	 * 
	 * 
	 *         Depends on:
	 * 
	 */
	@Test(description = "HCM196_Recruit_TC02_RAdmin_QuickView")
	private void HCM196_Recruit_TC02_RAdmin_QuickView() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

		appList.verifyQuickView();

	}

	/** I am not able to test this Point beacuse this point not implement */
	@Test(description = "HCM196_Recruit_TC03_RAdmin_SubStage")
	private void HCM196_Recruit_TC03_RAdmin_SubStage() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

		appList.checkSubStageOnQuickView();

	}

	/*
	 * Not able to test beacuse stages not working
	 */
	@Test(description = "HCM196_Recruit_TC04_RAdmin_Stage1ShowSeekAns")
	public void HCM196_Recruit_TC04_RAdmin_Stage1ShowSeekAns() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

		appList.Stage1ShowSeekAns();
	}

	@Test(description = "HCM196_Recruit_TC05_RAdmin_ListingDropdown")

	private void HCM196_Recruit_TC05_RAdmin_ListingDropdown() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

		appList.checkFilterByDropdownFunctionality();

	}

	@Test(description = "HCM198_Recruit_TC01_Recruit_ApplicantListing")
	private void HCM198_Recruit_TC01_Recruit_ApplicantListing() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

		appList.verifyColumnHeader();
	}

	@Test(description = "HCM198_Recruit_TC02_Recruit_FlagedoOrDuplicantAppNot")
	private void HCM198_Recruit_TC02_Recruit_FlagedoOrDuplicantAppNot() {

		navigateToApplicantListing();

		ApplicantListing appList = new ApplicantListing();

	}

	@Test(description = "HCM198_Recruit_TC03_Recruit_QuickView")
	private void HCM198_Recruit_TC06_Recruit_QuickView() {

		navigateToApplicantListing();

		ApplicantListing applist = new ApplicantListing();

		applist.verifyQuickView();
	}

	@Test(description = "HCM198_Recruit_TC05_Recruit_PendingSubStage")
	private void HCM198_Recruit_TC08_Recruit_PendingSubStage() {

		navigateToApplicantListing();

		ApplicantListing applist = new ApplicantListing();

		applist.checkSubStageOnQuickView();
	}

	@Test(description = "HCM198_Recruit_TC07_Recruiter_FilterListingDropdown")
	private void HCM198_Recruit_TC010_Recruiter_FilterListingDropdown() {

		navigateToApplicantListing();

		ApplicantListing applist = new ApplicantListing();

		applist.checkFilterByDropdownFunctionality();

	}

	/* Start scripting on jira 188 */

	@Test(description = "HCM188_Recruit_TC01_RecruiterAdmin_The admin is able to select the job type, "
			+ "job category, job sub category,employment type and salary range from a list of predefined values on the create job screen")
	private void HCM188_Recruit_TC01_RecruiterAdmin_CreateJobSelectDataOnDropdown() {
		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();
		createJob.fillJobDetails();

	}

	@Test(description = "HCM188_Recruit_TC02_RecruiterAdmin_The list of pre-defined values in the drop-downs will be as follows,")
	private void HCM188_Recruit_TC02_RecruiterAdmin_VerifyJobTypeJobCategoryJobSubCategoryEmploymentTypeSalaryRange() {
		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();
		createJob.verify_DropdownValues();

	}

	@Test(description = "HCM188_Recruit_TC03_RecruiterAdmin_CheckSalaryCheckBoxFunction")
	private void HCM188_Recruit_TC03_RecruiterAdmin_CheckSalaryCheckBoxFunction() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.checkBox_SalaryPublish();
	}

	@Test(description = "HCM188_Recruit_TC04_RecruiterAdmin_VerifyJobDetailsOnPreviewpost")
	private void HCM188_Recruit_TC04_RecruiterAdmin_VerifyJobDetailsOnPreviewpost() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.verifyJobDetailsOnPreviewpost();
	}

	@Test(description = "HCM188_Recruit_TC07_RecruiterAdminCreateJob_CheckALlRequiredValidation")
	private void HCM188_Recruit_TC07_RecruiterAdminCreateJob_CheckALlRequiredValidation() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.verify_ClickCheckAllValidation();
	}

	@Test(description = "HCM188_Recruit_TC14_RecruiterAdminJob_ResetFunctionality")
	private void HCM188_Recruit_TC14_RecruiterAdminJob_ResetFunctionality() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.job_ResetFunctionality();

	}

	@Test(description = "HCM188_Recruit_TC15_RecruiterAdminJob_SaveAsDraftFunctionality")
	private void HCM188_Recruit_TC15_RecruiterAdminJob_SaveAsDraftFunctionality() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.job_SaveAsDraft();
	}

	@Test(description = "HCM188_Recruit_TC16_RecruiterJobVerify_JobDetailsOnPreviewAndJobPost")
	private void HCM188_Recruit_TC16_RecruiterJobVerify_JobDetailsOnPreviewAndJobPost() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.job_PreviewJobPost();

	}

	@Test(description = "HCM188_Recruit_TC09_RecruiterJobVerify_DateRecurringCheckBox")
	private void HCM188_Recruit_TC09_RecruiterJobVerify_DateRecurringCheckBox() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.job_RecurringCheckBox();
	}

	@Test(description = "HCM188_Recruit_TC013_RecruiterJobVerify_TextLayOutSection")
	private void HCM188_Recruit_TC013_RecruiterJobVerify_TextLayOutSection() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.verify_JobTextLayoutContent();

	}

	@Test(description = "HCM188_Recruit_TC08_RecruiterJobVerify_ValidationStartDateOrEndDate")
	private void HCM188_Recruit_TC08_RecruiterJobVerify_ValidationStartDateOrEndDate() {

		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		RecruitmentDashboard rctDsh = new RecruitmentDashboard();
		JobListing JobList = new JobListing();

		nav.traverseMenu_VerifyPageTitle(RecruitmentDashboard.title, d.link_Recruitment);
		nav.traverseMenu_VerifyPageTitle(JobListing.title, rctDsh.link_Job);
		nav.traverseMenu_VerifyPageTitle(CreateJob.title, JobList.link_CreateJob);

		CreateJob createJob = new CreateJob();

		createJob.verifyValidation_StartDateOrEnddate();

	}

	/**
	 * This test will navigate to Recruitment >> Recruiter Management Page >>
	 * Disable Recruiter popup UI
	 * 
	 * @author shailendra Sep 18, 2019
	 */

	//@Test=Annotation for testng
	@Test(description = "HCM_Recruit_TC01_RecruiterCreateTask_CheckMaxApplicantValidation")
	private void HCM_Recruit_TC01_RecruiterCreateTask_CheckMaxApplicantValidation() {

		//Create navigator class object
		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.createNewTask();

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.checkMaxApplicantValidation();

	}

	@Test(description = "HCM_Recruit_TC02_RecruiterCreateTask_VerifyUI")
	private void HCM_Recruit_TC02_RecruiterCreateTask_VerifyUI() {

		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.createNewTask();

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.createTaskVerifyUI();

	}

	@Test(description = "HCM_Recruit_TC03_RecruiterCreateTask_SearchRecruiter")
	private void HCM_Recruit_TC03_RecruiterCreateTask_SearchRecruiter() {

		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.createNewTask();

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.createTaskSearchRecruiter("Gourav2,shailendra_R4");

	}

	@Test(description = "HCM_Recruit_TC04_RecruiterCreateTask_CreateNewTask")
	private void HCM_Recruit_TC04_RecruiterCreateTask_CreateNewTask() {

		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.createNewTask();

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.createTask("2 Oct Automate Task", "Review Online Application", "02/10/2019", "09:30 PM",
				"10:30 PM", "HCM Training Facility - Training Room", "10", "Gourav2", "gourav3",
				"This task created bu automate", "Vanny");

	}
	
	@Test(description = "HCM_Recruit_TC05_RecruiterCreateTask_DateTimeDuration")
	private void HCM_Recruit_TC05_RecruiterCreateTask_DateTimeDuration() {

		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.createNewTask();

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.createTask("2 Oct Automate Task", "Review Online Application", null, null,
				null, "HCM Training Facility - Training Room", "10", "gourav3", "gourav3",
				"This task created bu automate", "Vanny");
	}

	@Test(description = "HCM_Recruit_TC06_RecruiteTask_VerifyUI")
	private void HCM_Recruit_TC06_RecruiteTask_VerifyUI() {

		Navigator nav = new Navigator();

		// Creating Object
		Dashboard d = new Dashboard();

		// Creating Object
		SideBar_Recruitment sr = new SideBar_Recruitment();

		nav.traverseMenu_VerifyPageTitle(TaskList.title, d.link_Recruitment, sr.link_TasksList);

		TaskList taskList = new TaskList();

		taskList.verifyTaskUI();

		

		
	}
	/*
	 * @Test(description = "It Will Come In Report") private void abcd() { //
	 * Creating Object Navigator nav= new Navigator();
	 * 
	 * // Creating Object Dashboard d = new Dashboard();
	 * 
	 * // Creating Object SideBar_Recruitment sr=new SideBar_Recruitment();
	 * 
	 * // Normal way
	 * 
	 * // Calling method and page objects
	 * nav.traverseMenu_VerifyPageTitle("/recruitment/dashboard",
	 * d.link_Recruitment);
	 * 
	 * 
	 * // Calling method and page objects
	 * nav.traverseMenu_VerifyPageTitle("/recruitment/action/task",
	 * sr.link_TasksList);
	 * 
	 * 
	 * // Alternate way nav.traverseMenu_VerifyPageTitle("/recruitment/action/task",
	 * d.link_Recruitment, sr.link_TasksList);
	 */

}
