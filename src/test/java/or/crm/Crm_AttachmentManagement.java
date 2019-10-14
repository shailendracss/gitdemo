package or.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.Constant;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

/**
 * @author Archana Oct 1, 2019 7:53:20 PM This is used for all Attachment
 *         Management.
 */
public class Crm_AttachmentManagement {

	@FindBy(xpath = "//div[contains(text(),'Participant Details - Manage Attachments')]")
	private WebElement title_ParticipantDetails_ManageAttachments;

	@FindBy(xpath = "//div[(text()='Participant Details')]")
	private WebElement titel_ParticipantDetails;

	@FindBy(xpath = "//div[contains(text(),'Current Documents')]")
	private WebElement dropdown_Documenttype;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement button_Uploaddocs;
	

	private SeleniumMethods com;
	HCMCommon comm;
	Participant_Detail pd = new Participant_Detail();

	public Crm_AttachmentManagement() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();

	}

	public void select_Doc_Catogary() {
		com.click(pd.button_manageAttachments, "manage Attachments button");
		com.isElementPresent(title_ParticipantDetails_ManageAttachments,"ParticipantDetails_ManageAttachments is present");
		com.isElementPresent(titel_ParticipantDetails, "Participant Details is present");
		comm.selectByVisibleText(dropdown_Documenttype, "NDIS Plan");
 
		
		comm.uploadFile(button_Uploaddocs, Constant.getTestDataFolderPath()+"/fileUploadTest.PNG");
	}

}