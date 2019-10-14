/**
 * 
 */
package or.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

/**
 * @author Archana Oct 1, 2019 3:45:37 PM
 *
 */
public class CRM_Create_Partcipant {

	
	
	  @FindBy(xpath = "//a[(text()='Referer Details')]") 
	  private WebElement link_RefererDetails;

	  @FindBy(xpath = "//div[(text()='Referer Details')]") 
	  private WebElement title_RefererDetails;
	
	  @FindBy(xpath = "//li[contains(.,'Participant Details')]") 
	  private  WebElement link_ParticipantDetails;
	 
	  @FindBy(xpath = "//div[(text()='Participant Details')]") 
	  private WebElement title_ParticipantDetails;
	 
	  @FindBy(xpath = "//a[(text()='Participant Ability')]") 
	  private WebElement link_ParticipantAbility;
	 
	  @FindBy(xpath = "//div[(text()='Participant Ability')]") 
	  private WebElement title_ParticipantAbility;
	 
	  @FindBy(xpath = "//a[(text()='Shift')]") 
	  private WebElement link_Shift;
	  
	  @FindBy(xpath = "//div[(text()='Shift')]") 
	  private WebElement title_Shift;
	 
	  @FindBy(xpath = "//input[@name='first_name']")
	  private WebElement inpurt_firstname;;
	 
	  @FindBy(xpath= "//form[@id='referral_details']//a[@class='btn-1'][contains(text(),'Save And Continue')]")
	  private WebElement button_referralDetailsavebtn;
	 
	  @FindBy(xpath= "//form[@id='partcipant_details']//a[@class='btn-1'][contains(text(),'Save And Continue')]")
	  private WebElement button_partcipantDetailsavebtn;
	  
	  @FindBy(xpath= "//form[@id='partcipant_ability']//a[@class='btn-1'][contains(text(),'Save And Continue')]")
	  private WebElement button_partcipantAbilitysavebtn;
	   
	  @FindBy(xpath = "//input[@name='ndisno']") 
	  private WebElement input_NDISNumber; 
	 
	  @FindBy(xpath = "//span[@id='react-select-5--value-item']")
	  private WebElement value_Maritalstatus;
	
      @FindBy(xpath = "//span[@id='react-select-8--value-item']")
	private WebElement value_CognitiveLevel;
	

	
     private SeleniumMethods com;
     HCMCommon comm;

public CRM_Create_Partcipant() {
	PageFactory.initElements(DriverFactory.getDriver(), this);
	com = new SeleniumMethods();
	comm = new HCMCommon();

	
}


/**
 * @author Archana Oct 1, 2019 3:45:37 PM
 *
 *This method is used for varify reffer detail of participants.
 */
public void CRM_Edit_Reffer_Details() {
	com.click_UsingAction(link_RefererDetails, "link_RefererDetails is clicked");
	com.isElementPresent(title_RefererDetails, "title_RefererDetails is Present");
	com.sendKeys("Firtst name", inpurt_firstname, "Archana");
	com.click_UsingAction(button_referralDetailsavebtn, "Save n continue clicked");
	String clsName = com.getAttribute(By.xpath("//li[contains(.,'Participant Details')]"), "class");

	if (clsName.toLowerCase().contains("active")) {
		CustomReporter.report(STATUS.PASS, "Participants Details Tab opened");
	} else {
		CustomReporter.report(STATUS.FAIL, "Participants Details Tab NOT opened");
	}
}
/**
 *  @author Archana Oct 1, 2019 3:45:37 PM
 *  
 *  This method is used for varify participants detail of partcipants.
 */
public void CRM_Edit_Participant_Details() {
	com.isElementPresent(input_NDISNumber, "NDISNumber is present");
	comm.selectByVisibleText(value_Maritalstatus, "Married");
	com.click_UsingAction(button_partcipantDetailsavebtn, "Save n continue clicked");
	
	String clsName =com.getAttribute(By.xpath("//li[contains(.,'Participant Ability')]"), "class");
	
	if (clsName.toLowerCase().contains("active")) {
		CustomReporter.report(STATUS.PASS, "Participants Ability Tab opened");
	} else {
		CustomReporter.report(STATUS.FAIL, "Participants Ability Tab NOT opened");
	}
		
}
/**
 *  @author Archana Oct 1, 2019 3:45:37 PM
 *  
 *  This method is used for varify participants Ability of partcipants.
 */
public void CRM_Edit_Participant_Ability() {
	comm.selectByVisibleText(value_CognitiveLevel, "Very Good");
	com.click_UsingAction(button_partcipantAbilitysavebtn, "Save n continue clicked");
	
    String clsName =com.getAttribute(By.xpath("//li[contains(.,'Shift')]"), "class");
	
	if (clsName.toLowerCase().contains("active")) {
		CustomReporter.report(STATUS.PASS, "Shift Tab opened");
	} else {
		CustomReporter.report(STATUS.FAIL, "Shift Tab NOT opened");
	}
	
	



}
		
}
	
	

