package or.recruit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

public class CreateNewTask {
	SeleniumMethods com;
	HCMCommon comm;

	public CreateNewTask() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();
	}

	@FindBy(name = "task_name")
	private WebElement text_TaskName;

	@FindBy(xpath = "//label[.='Stage:']/..//span[contains(@id,'react-select')]/div")
	private WebElement select_Stage;

	@FindBy(name = "PostDate")
	private WebElement text_Date;

	@FindBy(name = "from_time")
	private WebElement text_FromTime;

	@FindBy(name = "to_time")
	private WebElement text_ToTime;

	@FindBy(xpath = "//label[.='Location:']/..//span[contains(@id,'react-select')]/div")
	private WebElement select_Location;

	@FindBy(name = "max_applicant")
	private WebElement text_MaxApplicant;

	@FindBy(xpath = "//span[.='Search Recruiter'][contains(@class,'multi')]//input")
	private WebElement text_SearchRecruiter;

	@FindBy(name = "relevant_task_note")
	private WebElement text_TaskNotes;

	@FindBy(xpath = "//span[.='Search for Applicants'][contains(@class,'multi')]//input")
	private WebElement text_SearchForApplicants;

	@FindBy(xpath = "//button[.='Create Task']")
	private WebElement button_CreateTask;

	@FindBy(xpath = "//label[contains(.,'Task Name:')]")
	private WebElement label_TaskName;

	@FindBy(xpath = "//label[contains(.,'Stage:')]")
	private WebElement label_Stage;

	@FindBy(xpath = "//label[contains(.,'Date:')]")
	private WebElement label_Date;

	@FindBy(xpath = "//label[contains(.,'Time/Duration:')]")
	private WebElement label_TimeDuration;

	@FindBy(xpath = "//label[contains(.,'Location:')]")
	private WebElement label_Location;

	@FindBy(xpath = "//label[contains(.,'Max Applicants:')]")
	private WebElement label_MaxApplicant;

	@FindBy(xpath = "//label[contains(.,'Assigned to Recruiter/s:')]")
	private WebElement label_AssignRecruiter;

	@FindBy(xpath = "//label[contains(.,'Relevant Task Notes:')]")
	private WebElement label_RelevantTaskNotes;

	@FindBy(xpath = "//b[contains(.,'Attach Applicant')]")
	private WebElement label_AttachApplicant;

	/**
	 * Will fill the Task Form
	 * 
	 * @author shailendra Sep 18, 2019
	 */
	private void fillTaskDetails(String taskName, String stage, String date, String fromTime, String toTime,
			String location, String maxApplicant, String commaSeparatedMultipleRecruiter, String primaryRecruiter,
			String taskNotes, String commaSeparatedMultipleApplicants) {

		if (taskName != null) {
			com.sendKeys("Task Name", text_TaskName, taskName);
		}

		if (stage != null) {
			comm.selectByVisibleText(select_Stage, stage);
		}

		if (date != null) {
			com.sendKeys("Task Date", text_Date, Keys.ENTER);
		}

		if (fromTime == null) {
			com.sendKeys("From Time", text_FromTime, Keys.ENTER);
		}else {
			com.click(text_FromTime);
			com.wait(.5);
			com.click(By.xpath("//li[contains(@class,'date')][.='"+fromTime+"']"), "From Time: "+fromTime);
		}

		if (toTime == null) {
			com.sendKeys("To Time", text_ToTime, Keys.ENTER);
		}else {
			com.click(text_ToTime);
			com.wait(.5);
			com.click(By.xpath("//li[contains(@class,'date')][.='"+toTime+"']"), "To Time: "+toTime);
		}

		if (location != null) {
			comm.selectByVisibleText(select_Location, location);
		}

		if (maxApplicant != null) {
			com.click(text_MaxApplicant);
			com.sendKeys("Max Applicant", text_MaxApplicant, maxApplicant);
		}

		if (commaSeparatedMultipleRecruiter != null) {
			searchAndAddRecruiter(commaSeparatedMultipleRecruiter);
		}

		if (primaryRecruiter != null) {
			com.javaScript_Click(By.xpath("//div[@class='nme_assi'][contains(.,'" + primaryRecruiter
					+ "')]//following-sibling::label//input"), "Primary Recruiter [" + primaryRecruiter + "]");
		}

		if (taskNotes != null) {
			com.sendKeys("Task Notes", text_TaskNotes, taskNotes);
		}

		if (commaSeparatedMultipleApplicants != null) {
			searchAndAddApplicants(commaSeparatedMultipleApplicants);
		}

	}

	/**
	 * Search and Add a multiple Applicants
	 * 
	 * @author shailendra Sep 18, 2019
	 */
	private void searchAndAddApplicants(String commaSeparatedMultipleApplicants) {
		String[] applicantArr = null;

		if (commaSeparatedMultipleApplicants.contains(",")) {
			applicantArr = commaSeparatedMultipleApplicants.split(",");
		} else {
			applicantArr = new String[1];
			applicantArr[0] = commaSeparatedMultipleApplicants;
		}

		for (String singleApplicant : applicantArr) {
			com.sendKeys(text_SearchForApplicants, singleApplicant);
			com.wait(1);
			com.waitForElementTobe_NotVisible(comm.spinnerLocator);
			com.click(By.xpath("//div[@role='option'][contains(.,'" + singleApplicant + "')]"),
					"Selecting Applicant [" + singleApplicant + "]");
		}

	}

	/**
	 * Search and Add a Recruiter
	 * 
	 * @author shailendra Sep 18, 2019
	 */
	private void searchAndAddRecruiter(String commaSeparatedMultipleRecruiter) {

		String[] recruiterArr = null;

		if (commaSeparatedMultipleRecruiter.contains(",")) {
			recruiterArr = commaSeparatedMultipleRecruiter.split(",");
		} else {
			recruiterArr = new String[1];
			recruiterArr[0] = commaSeparatedMultipleRecruiter;
		}

		for (String singleRecruiter : recruiterArr) {
			com.sendKeys(text_SearchRecruiter, singleRecruiter);
			com.wait(1);
			com.waitForElementTobe_NotVisible(comm.spinnerLocator);
			com.click(By.xpath("//div[@role='option'][contains(.,'" + singleRecruiter + "')]"),
					"Selecting Recruiter [" + singleRecruiter + "]");
		}

	}

	/**
	 * Creates a new Task
	 * 
	 * @author shailendra Sep 18, 2019
	 * @param string6
	 * @param string5
	 * @param string4
	 * @param string3
	 * @param i
	 * @param string2
	 * @param object2
	 * @param fromTime
	 * @param todayDate
	 * @param string
	 * @param taskName
	 */
	public void createTask(String taskName, String stage, String date, String fromTime, String toTime, String location,
			String maxApplicant, String addRecruiter, String primaryRecruiter, String taskNotes,
			String commaSeparatedMultipleApplicants) {

		CustomReporter.createNode("Creating a New Task");

		fillTaskDetails(taskName, stage, date, fromTime, toTime, location, maxApplicant, addRecruiter, primaryRecruiter,
				taskNotes, commaSeparatedMultipleApplicants);

		com.click(button_CreateTask, "button_Create Task");

		com.waitForElementsTobe_Present(By.xpath("//p[contains(.,'Task created successfully')]"),
				"Task created successfully Message");

	}

	/**
	 * Check Max applicant validation 1.Select 1 on max applicant box 2.Search
	 * another applicant after select one applicant 3.search box disable after
	 * select 1 applicant
	 * 
	 * @author Adarsh 23-Sep-2019
	 **/
	public void checkMaxApplicantValidation() {

		fillTaskDetails(null, "None", null, null, null, null, "1", null, null, null, "Jose");

		if (com.waitForElementTobe_NotVisible(text_SearchForApplicants, 1)) {
			CustomReporter.report(STATUS.PASS,
					"not able to select after select one applicant, seacrh input is disabled");
		} else {
			CustomReporter.report(STATUS.FAIL, "If search box is enable");
		}
	}

	public void createTaskVerifyUI() {

		com.isElementPresent(label_TaskName, "Task Name");
		com.isElementPresent(label_Stage, "Stage");
		com.isElementPresent(label_TimeDuration, "Time/Duration");
		com.isElementPresent(label_Location, "Location");
		com.isElementPresent(label_MaxApplicant, "Select Maximum Applicant");
		com.isElementPresent(label_AssignRecruiter, "Assign Rescruiter");
		com.isElementPresent(label_RelevantTaskNotes, "Relevent Notes");
		com.isElementPresent(label_AttachApplicant, "Attach Applicant");
		
		

	}
	
	/**
	 *
	 * -This method create to search recruiter
	 * -Go to task pop up
	 * -search recruiter on recruiter search box 
	 *  @author Adarsh 01-Oct-2019
	 * */

	public void createTaskSearchRecruiter(String commaSeparatedMultipleRecruiter) {
		searchAndAddRecruiter(commaSeparatedMultipleRecruiter);
		
	}

	

	
	
	

}
