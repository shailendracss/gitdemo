package or.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.ReactTable;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

public class StaffMembers {

	public static final String title = "admin/user/list";

	private SeleniumMethods com;
	private HCMCommon comm;

	public StaffMembers() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();
	}

	@FindBy(xpath = "//a[contains(.,'Add CRM User')]")
	private WebElement button_AddCrmUser;

	@FindBy(xpath = "//label[contains(.,'Search for a user:')]//following-sibling::div//input")
	private WebElement text_Search;

	@FindBy(xpath = "//button[.='Save User']")
	private WebElement button_SaveUser;

	@FindBy(xpath = "//div[contains(text(),'Change Assigne')]")
	private WebElement title_ChangeAssigne;
	
	@FindBy(xpath = "//span[@id='react-select-13--value']//div[@class='Select-placeholder']")
	private WebElement text_SearchUser;
	
	@FindBy(xpath = "//a[@class='btn-1'][contains(text(),'Update')]")
	private WebElement button_Update;

	/**
	 * Add comments here
	 * @author Shwetha S Sep 13, 2019
	 * */
	public void addCrmUser(String userTxt) {
		com.click(button_AddCrmUser, "button Add CRM user");
		
		com.wait(1);
		
		com.sendKeys(text_Search, userTxt);
		
		com.wait(3);
		
		
		com.click(By.xpath(
				"//div[@class='Select-menu-outer']//div[contains(@class,'option')][contains(.,'" + userTxt + "')]"),
				userTxt + " option");
		
		com.wait(2);
		
		
		com.click(button_SaveUser, "button_SaveUser");
		
		
		ReactTable tab = new ReactTable(comm.reactTableLocator);
		
		int rowNum = tab.getRowWithCellText(userTxt); 
		if (rowNum > 1) {
			CustomReporter.report(STATUS.PASS, "User ["+userTxt+"] is succesfully added as a CRM user");
		} else {
			CustomReporter.report(STATUS.FAIL, "User ["+userTxt+"] failed to add as a CRM user");
		}
	}
	/**
	 *  @author Archana Oct 1, 2019 3:45:37 PM
	 *  
	 *  This method is used for Validating Change Assigne user.
	 *
	 */
	public void changeCrmUser(){
		com.isElementPresent(title_ChangeAssigne, "change assign title is present");
		com.click(text_SearchUser);
		com.sendKeys("User name entered", text_SearchUser, "Archana");
		
		com.click_UsingAction(button_Update, "Update button is clicked");
		
	}
	
		
		
		
		

}

