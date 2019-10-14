package tests.crm;

import org.testng.annotations.Test;

import or.common.Dashboard;
import or.common.Navigator;
import or.common.SideBar_CRM;
import or.crm.Crm_AttachmentManagement;
import or.crm.Crm_Dashboard;
import or.crm.Participant_Detail;
import or.crm.Prospective_Participants;

public class CRM_Tests {

	private Navigator navigateToCRM_Admin() {
		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		nav.traverseMenu_VerifyPageTitle("/admin/crm/participantadmin", d.link_CRM_Admin);
		return nav;
	}

	private void navigateToCRM_User() {
		Navigator nav = new Navigator();
		Dashboard d = new Dashboard();
		nav.traverseMenu_VerifyPageTitle("/admin/crm/participantuser", d.link_CRM_User);
	}

	/**
	 * Covered:HCM-90(1,2)
	 * 
	 * Pending:(3,4)
	 * 
	 * Depends on:create participants
	 * 
	 */
	@Test(description = "HCM89_TC01_UI Verification of CRMPage_CrmAdmin")
	private void HCM89_TC01_UIVerification_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.verify_CRMAdmin_UI();
	}

	/**
	 * Covered:
	 * 
	 * Pending:
	 * 
	 * Depends on:
	 * 
	 */
	@Test(description = "HCM90_TC01_UIVerification_CRMPage_CrmUser")
	private void HCM90_TC01_UIVerification_CRMPage_CrmUser() {
		navigateToCRM_User();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.verify_CRMUser_UI();

	}

	/*
	 * @Test(description = "HCM94_TC01_ParticipantDetails_CRMPage_CrmAdmin") private
	 * void HCM94_TC01_ParticipantDetails_CRMPage_CrmAdmin() {
	 * navigateToCRM_Admin(); Crm_Dashboard crm = new Crm_Dashboard();
	 * crm.Verify_ViewParticipantDetailsScreen();
	 * 
	 * }
	 * 
	 * @Test(description = "HCM94_TC01_ParticipantDetails_CRMPage_CrmUser") private
	 * void HCM94_TC01_ParticipantDetails_CRMPage_CrmUser() { navigateToCRM_User();
	 * Crm_Dashboard crm = new Crm_Dashboard();
	 * crm.Verify_ViewParticipantDetailsScreen();
	 * 
	 * }
	 */

	@Test(description = "HCM95_TC01_ParticipantintakeLatestactions_CRMPage_CrmAdmin")
	private void HCM95_TC01_ParticipantintakeLatestactions_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Verify_Latestactions();
	}

	@Test(description = "HCM96_TC01_ParticipantintakeDuetask_CRMPage_CrmAdmin")
	private void HCM96_TC01_ParticipantintakeDuetask_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Verify_DueTask();
	}

	@Test(description = "HCM97_TC01_ParticipantintakeLatestUpdates_CRMPage_CrmAdmin")
	private void HCM97_TC01_ParticipantintakeLatestUpdates_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.verify_LatestUpdates();
	}

	@Test(description = "HCM98_TC01_ParticipantDetails_CRMPage_CrmUser")
	private void HCM98_TC01_ParticipantDetails_CRMPage_CrmUser() {
		navigateToCRM_User();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Verify_NewAssignedParticipants();

	}

	@Test(description = "HCM107_TC01_ParticipantQuikeView_CRMPage_CrmAdmin")
	private void HCM107_TC01_ParticipantQuikeView_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Verify_QuickView();

	}

	@Test(description = "HCM107_TC01_ParticipantQuikeView_CRMPage_CrmUser")
	private void HCM107_TC01_ParticipantQuikeView_CRMPage_CrmUser() {
		navigateToCRM_User();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Verify_QuickView();

	}

	@Test(description = "HCM108_TC01_LatestUpdates_ParticipantsScreen_CRMPage_CrmAdmin")
	private void HCM108_TC01_LatestUpdates_ParticipantsScreen_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.LatestUpdates_ParticipantsScreen();

	}

	@Test(description = "HCM109_TC01_ParticipantsScreen_Intakeprogressbar_CRMPage_CrmAdmin")
	private void HCM109_TC01_ParticipantsScreen_Intakeprogressbar_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.Intakeprogressbar();

	}

	@Test(description = "HCM120_TC01_Participant_Shifts_CRMPage_CrmAdmin")
	private void HCM120_TC01_Participant_Shifts_CRMPage_CrmAdmin() {
		navigateToCRM_Admin();
		Crm_Dashboard crm = new Crm_Dashboard();
		crm.shift_UI_verify();

	}

	/*
	 * 
	 * This Method is use for React Table.
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test
	private void REACT_TABLE() {
		navigateToCRM_Admin();

		Crm_Dashboard crm = new Crm_Dashboard();
		crm.reactTableExample();

	}

	/*
	 * This Method is use for Validating Prospective Participant UI Elements
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC01_CRM_prospective_participants_UI_Elements_varify")
	private void TC01_CRM_prospective_participants_UI_Elements_varify() {
		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Prospective_Participants pp = new Prospective_Participants();
		pp.prospective_Participants_UI_Elements_Varify();

	}

	/*
	 * This Method is use for Validating Prospective Participant Detail.
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC02_CRM_prospective_participants_Details_Dashboard_UI_verification")
	private void TC02_CRM_prospective_participants_Details_Dashboard_UI_verification() {

		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		Participant_Detail pd = new Participant_Detail();
		pd.participant_Details_Dashboard_UI_Verification();

		/*
		 * This Method is use for Validating Edit Participant Detail.
		 * 
		 * @author Archana Oct 2 , 2019
		 */
	}

	@Test(description = "TC03_CRM_EditParticipant_info_varification")
	private void TC03_CRM_EditParticipant_info_varification() {

		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		Participant_Detail pd = new Participant_Detail();
		pd.editParticipant_Info_Varification();

	}

	/*
	 * This Method is use for Validating Assigned To User For a Participant Detail.
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC04_CRM_Assignedto_Functionalityvalidation")
	private void TC04_CRM_Assignedto_Functionalityvalidation() {
		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Participant_Detail pd = new Participant_Detail();
		pd.assignedto_Functionalityvalidation();

	}

	/*
	 * This Method is use for Validating Manage attcthmant in Participant Detail .
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC05_CRM_Manage attcthmant validation")
	private void TC05_CRM_Manage_Attcthmant_Validation() {
		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Prospective_Participants pp = new Prospective_Participants();
		pp.openQuickViewAndClickOnViewButton();
		Crm_AttachmentManagement ca = new Crm_AttachmentManagement();
		ca.select_Doc_Catogary();

	}

	/*
	 * This Method is use for Validating Intake Progress in Participant Detail .
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC06_CRM_Intake Progress validation")
	private void TC06_CRM_Intake_Progress_Validation() {
		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Participant_Detail pd = new Participant_Detail();
		pd.intake_Progress_Validation();
	}

	/*
	 * This Method is use for Validating FMS Case in Participant Detail .
	 * 
	 * @author Archana Oct 2 , 2019
	 */
	@Test(description = "TC07_CRM_FMS_Case_Validation")
	private void TC07_CRM_FMS_Case_Validation() {
		SideBar_CRM sc = new SideBar_CRM();
		navigateToCRM_Admin().traverseMenu_VerifyPageTitle(Prospective_Participants.title,
				sc.link_Prospective_Participants);
		Participant_Detail pd = new Participant_Detail();
		pd.fms_Case_validation();
	}
}