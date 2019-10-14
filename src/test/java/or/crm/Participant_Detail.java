/**
 * 
 */
package or.crm;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.ReactTable;
import com.seleniumExceptionHandling.SeleniumMethods;

import or.common.HCMCommon;

/**
 * @author Archana Oct 2, 2019 11:55:57 AM
 *
 */
public class Participant_Detail {
	@FindBy(xpath = "//a[@title='View']")
	private WebElement btn_more_view;

	@FindBy(xpath = "//div[contains(@class,'h-h1')]")
	private WebElement title_participantDetails;

	@FindBy(xpath = "//strong[contains(text(),'Assigned to:')]")
	private WebElement link_Assignedto;

	@FindBy(xpath = "//a[contains(@class,'btn-1 s2 px-4 ml-3')][contains(text(),'Change')]")
	private WebElement button_changeAssigneduser;

	@FindBy(xpath = "//div[contains(@class,'Lates_up_btn')]//i")
	private WebElement button_viewall;

	@FindBy(xpath = "//a[contains(text(),'Edit Participants Info')]")
	private WebElement button_editparticipants;

	@FindBy(xpath = "//i[contains(@class,'more-less glyphicon glyphicon-plus')]")
	private WebElement icon_FMSexpand;;

	@FindBy(xpath = " //a[contains(@class,'btn-1')][contains(text(),'Manage  Attachments')]")
	public WebElement button_manageAttachments;

	@FindBy(xpath = "//strong[contains(text(),'Intake Progress:')]")
	private WebElement text_intakeProgress;

	@FindBy(xpath = "//h1[(text()='Edit Prospective Participant')]")
	private WebElement text_Edit_prospectiveParticipant;;

	@FindBy(xpath = "//a[(text()='Referer Details')]")
	private WebElement link_RefererDetails;

	@FindBy(xpath = "//div[(text()='Referer Details')]")
	private WebElement title_RefererDetails;

	@FindBy(xpath = "//a[(text()='Participant Details')]")
	private WebElement link_ParticipantDetails;

	@FindBy(xpath = "//li[contains(.,'Participant Details')]")
	private WebElement title_ParticipantDetails;

	@FindBy(xpath = "//a[(text()='Participant Ability')]")
	private WebElement link_ParticipantAbility;

	@FindBy(xpath = "//div[(text()='Participant Ability')]")
	private WebElement title_ParticipantAbility;

	@FindBy(xpath = "//form[@id='referral_details']//a[@class='btn-1'][contains(text(),'Save And Continue')]")
	private WebElement button_referralDetailsavebtn;

	@FindBy(xpath = "//input[@name='ndisno']")
	private WebElement input_NDISNumber;

	@FindBy(xpath = "//a[contains(text(),'Save And Create Participant')]")
	private WebElement button_SaveAndCreateParticipant;

	@FindBy(xpath = "//p[contains(text(),'Participant updated successfully')]")
	private WebElement popup_updatedsuccessfully;

	@FindBy(xpath = "//span[contains(text(),'Stage 1')]")
	private WebElement text_Stage1;

	@FindBy(xpath = "//span[contains(text(),'Stage 2')]")
	private WebElement text_Stage2;

	@FindBy(xpath = "//span[contains(text(),'Stage 3')]")
	private WebElement text_Stage3;

	@FindBy(xpath = " //div[@class='timeline_h'][contains(text(),'Intake Participant Submission')]")
	private WebElement title_Stage1;

	@FindBy(xpath = "//div[@id='accordion-controlled-example-heading-2']//div[@class='timeline_h'][contains(text(),'Intake')]")
	private WebElement title_Stage2;

	@FindBy(xpath = "//div[@class='timeline_h pt-3'][contains(text(),'Plan Delegation')]")
	private WebElement title_Stage3;

	@FindBy(xpath = "//div[@id='accordion-controlled-example-heading-1']//i[@class='more-less glyphicon glyphicon-plus']")
	private WebElement icon_FNSexpand;

	@FindBy(xpath = "//div[@id='accordion-controlled-example-heading-2']//i[@class='icon icon-arrow-down']")
	private WebElement icon_Stage2Expand;

	private SeleniumMethods com;
	HCMCommon comm;

	public Participant_Detail() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
		comm = new HCMCommon();
	}

	/*
	 * @author Archana Sept 20 , 2019
	 * 
	 * This Method is use for verify the Prospective Participants Dashboard UI
	 * 
	 */
	public void participant_Details_Dashboard_UI_Verification() {
		com.isElementPresent(title_participantDetails, "Participants detail heading is showing");
		com.isElementPresent(link_Assignedto, "Assigned to is present");
		com.isElementPresent(button_changeAssigneduser, "change Assigned user button is showing");
		com.isElementPresent(button_viewall, "Latest update View all button is present");
		com.isElementPresent(button_editparticipants, "button_editparticipants button is present");
		com.isElementPresent(icon_FMSexpand, "FMS expand icon is present");
		com.isElementPresent(button_manageAttachments, "manageAttachments button");
		com.isElementPresent(text_intakeProgress, "Intake progress is present");

	}

	/*
	 * @author Archana Oct 1 , 2019
	 * 
	 * This Method is use for Validate the Edit Prospective Participants.
	 * 
	 * 
	 * 
	 * 
	 */

	public void editParticipant_Info_Varification() {
		com.click(button_editparticipants, "button_editparticipants button is clicked");
		com.isElementPresent(text_Edit_prospectiveParticipant, "Edit Prospective Participant");
		
		CRM_Create_Partcipant cp = new CRM_Create_Partcipant();
		cp.CRM_Edit_Reffer_Details();
		cp.CRM_Edit_Participant_Details();
		cp.CRM_Edit_Participant_Ability();
		com.click_UsingAction(button_SaveAndCreateParticipant, "Save n CreateParticipant clicked");
		com.wait(5);
		com.isElementPresent(popup_updatedsuccessfully, "updatedsuccessfully is present");

	}

	/*
	 * @author Archana Oct 1 , 2019
	 * 
	 * This Method is use for Validate the Assigned to Participants.
	 * 
	 * 
	 * 
	 * 
	 */
	public void assignedto_Functionalityvalidation() {
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		com.click_UsingAction(button_changeAssigneduser, "change Assigned user button s clicked"); // Incorrect PAGE OBJECT MODEL??
		StaffMembers sm = new StaffMembers();
		sm.changeCrmUser();

	}
	/*
	 * @author Archana Oct 2 , 2019
	 * 
	 * This Method is use for Validate the Intake type stages.
	 * 
	 */

	public void intake_Progress_Validation() {
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		com.isElementPresent(text_intakeProgress, "Intake progress is present");
		com.isElementPresent(text_Stage1);

		if (com.isElementPresent(text_Stage1)) {
			String stage1 = com.getText(title_Stage1);
			System.out.println(stage1);

			if (stage1.matches("Intake Participant Submission")) {
				CustomReporter.report(STATUS.PASS, "Intake Participant Submission is present");
			} else {
				CustomReporter.report(STATUS.FAIL, "Intake Participant Submission isnot present");
			}
		}

		if (com.isElementPresent(text_Stage2)) {
			String stage2 = com.getText(title_Stage2);
			System.out.println(stage2);
			if (stage2.matches("Intake")) {
				CustomReporter.report(STATUS.PASS, "Intake is present");
			} else {
				CustomReporter.report(STATUS.FAIL, "Intake isnot present");
			}
		}
		if (com.isElementPresent(text_Stage3)) {
			String stage3 = com.getText(title_Stage3);
			System.out.println(stage3);
			if (stage3.matches("Plan Delegation")) {
				CustomReporter.report(STATUS.PASS, "Plan Delegatione is present");
			} else {
				CustomReporter.report(STATUS.FAIL, "Plan Delegation isnot present");
			}

		}

	}

	public void fms_Case_validation() {
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		com.click_UsingAction(icon_FMSexpand, "FMS expand icon clicked");
		ReactTable rct = new ReactTable(comm.reactTableLocator);
		rct.verifyColumnHeaders(1, "Case ID:", "Category:", "Event Date", "Description");

	}

}
