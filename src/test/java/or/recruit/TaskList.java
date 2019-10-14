package or.recruit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.ReactTable;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

/**
 * 
 * @author Adarsh 01-Oct-2019
 */

public class TaskList {
	public static final String title = "recruitment/action/task";
	SeleniumMethods com;
	HCMCommon comm;

	public TaskList() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();
	}

	@FindBy(xpath = "//h1[contains(.,'Tasks')]")
	private WebElement label_Task;

	@FindBy(xpath = "//a[contains(.,'Create New Task')]")
	private WebElement button_CreateNewTask;

	@FindBy(xpath = "//input[contains(@class,'srch-inp')]")
	private WebElement input_SearchBox;

	/**
	 * */
	public void createNewTask() {
		com.click(button_CreateNewTask, "button_Create New Task");
	}

	/**
	 * Verify CreTask UI
	 * 
	 * @author Adarsh 01-Oct-2019
	 */
	public void verifyTaskUI() {

		com.isElementPresent(label_Task, "Task");
		com.isElementPresent(input_SearchBox, "Search");
		com.isElementPresent(button_CreateNewTask, "button_CreateNewTask");

		ReactTable tab = new ReactTable(comm.reactTableLocator);
		tab.verifyColumnHeaders(1, "Task Name", "Stage", "Date", "Primary Recruiter", "Available Slots:", "Status",
				"Action");

		com.isElementPresent(tab.getChildObject(2, 7, "a", 0), "Complete");
		com.isElementPresent(tab.getChildObject(2, 7, "a", 1), "Edit/View");
		com.isElementPresent(tab.getChildObject(2, 7, "a", 2), "Archive");

	}

}
