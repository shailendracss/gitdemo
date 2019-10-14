package or.recruit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

public class RecruiterDetails {
	public static final String title = "recruitment/staff_details";
	SeleniumMethods com;
	HCMCommon comm;

	public RecruiterDetails() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();
	}

	@FindBy(xpath="//h4[not(@class)]/b")
	private WebElement label_RecruiterName;

	@FindBy(xpath="//h4[.='Task Detail']")
	private WebElement label_TaskDetail;

	@FindBy(xpath = "//a[.='New Task ']")
	private WebElement button_NewTask;

	@FindBy(xpath="//h4[.='Applicant Status:']")
	private WebElement label_ApplicantStatus;

	@FindBy(xpath="//h4[.='Successful Applicants:']")
	private WebElement label_SuccessfulApplicants;

	@FindBy(xpath="//b[.='Current Task Schedules']")
	private WebElement label_CurrentTaskSchedules;

	@FindBy(xpath="//b[.='Task Stage:']")
	private WebElement label_TaskStage;

	@FindBy(xpath="//button[.='View All Task']")
	private WebElement button_ViewAllTask;

	@FindBy(xpath="//span[.='Disable Recruiter']")
	private WebElement link_DisableRecruiter;

	@FindBy(xpath="//div[@class='row'][contains(.,'HCMGR-Id')]")
	private WebElement content_RecruiterDetails;

	@FindBy(xpath = "(//div[contains(@class,'calendar')]//button//div[contains(@class,'task')])[1]")
	private WebElement button_CalendarNumber;

	/**
	 * Verifies the page UI Objects
	 * 
	 * @author shailendra Sep 18, 2019
	 */
	public void verify_UI() {
		CustomReporter.createNode("Section verification");
		com.isElementPresent(label_RecruiterName, "label_RecruiterName");
		com.isElementPresent(label_TaskDetail, "label_TaskDetail");
		com.isElementPresent(button_NewTask, "button_NewTask");
		com.isElementPresent(label_ApplicantStatus, "label_ApplicantStatus");
		com.isElementPresent(label_SuccessfulApplicants, "label_SuccessfulApplicants");
		com.isElementPresent(label_CurrentTaskSchedules, "label_CurrentTaskSchedules");
		com.isElementPresent(label_TaskStage, "label_TaskStage");
		com.isElementPresent(button_ViewAllTask, "button_ViewAllTask");
		com.isElementPresent(link_DisableRecruiter, "link_DisableRecruiter");
		com.isElementPresent(content_RecruiterDetails, "content_RecruiterDetails");
	}

	/**
	 * Create a new Task, Click on Calendar number link and verify Task Page is
	 * getting displayed Then Verify that newly created task is displayed in the
	 * list without the need of searching.
	 * 
	 * @author shailendra Sep 18, 2019
	 * @param taskName
	 */
	public void verifyCalendarNumLinksFunc(String taskName) {

		CustomReporter.createNode("verify Calendar Num Links Func");

		com.navigateToAndVerifyPageUrl(button_CalendarNumber, TaskList.title);

		// First of all selecting 50 rows, so that pages count will become less
		com.click(comm.link_50, "50 Rows");

		CustomReporter.report(STATUS.INFO,
				"Verifying the created task [" + taskName + "] is displayed on Task List Page");
		while (true) {

			if (com.waitForElementsTobe_NotVisible(By.xpath("//span[.='" + taskName + "']"), 0)) {
				CustomReporter.report(STATUS.FAIL, "Task [" + taskName + "] is not getting displayed");
				break;
			}

			if (com.waitForElementsTobe_NotVisible(comm.icon_Next_Disabled, 1)) {
				com.click(comm.icon_Next, "Next Page icon");
			} else {
				break;
			}
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

		com.click(button_NewTask, "button_New Task");

		CreateNewTask createNewTask = new CreateNewTask();

		createNewTask.createTask(taskName, stage, date, fromTime, toTime, location, maxApplicant, addRecruiter,
				primaryRecruiter, taskNotes, commaSeparatedMultipleApplicants);

	}

	/**
	 * Will click on Disable Recruiter link to open the Disbale Recruiter Popup
	 * 
	 * All Objects and Methods of Disable Recruiter Popup are present on {@link RecruiterManagement} class
	 * 
	 *  @author shailendra Oct 3, 2019
	 */
	public void openDisableRecruiterPopup() {
		com.click(link_DisableRecruiter, "link_Disable Recruiter");
	}

}