package com.ghx.auto.cm.regression.ui.smoke.production;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.page.NBDHomePage;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDRepDetailsPage;
import com.ghx.auto.cm.ui.page.NBDRepsPage;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.cm.ui.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.page.NBDSupportCenterPage;
import com.ghx.auto.cm.ui.page.NBDVendorMateHomePage;
import com.ghx.auto.cm.ui.page.NBDVendorsPage;
import com.ghx.auto.cm.ui.page.NBDWebinarPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;
import com.ghx.auto.cm.ui.page.NBDManageUsersPage;

public class ST_NBD_Navigation_Test extends AbstractAutoUITest {
	
// Test Data for Appointment Test Cases
	String appointment_subject = "AD - Long Appointment (23 May 2015)";
	String appointment_search_result = "AD - Long Appointment (23 May 2015)";
	String enter_createdby_id = "sachin.pathak@vendormate.com";
	String verify_createdby_id = "sachin.pathak@vendormate.com";
	String enter_location = "Tenth Floor";
	String verify_location = "Tenth Floor";
	String enter_department = "Accounting";
	String verify_department = "Accounting";
	String enter_staff = "sac'hin path'ak";
	String verify_staff = "sac'hin path'ak";
	String enter_email_id = "sachin.pathak@bizsense.in";
	String verify_email_id = "sachin.pathak@bizsense.in";
	String enter_username = "sachin pathak";
	String verify_username = "sachin pathak";
	String enter_companyname = "BizSense Test 2";
	String verify_companyname = "BizSense Test 2";
	String vendor_name = "BizSense Test 2";
	String repdetails_username = "sachin pathak";
	
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test(priority=1, groups = {"functional"})
	public void verifyUnpaidVendors() { 
		
		get(NBDLogin.class)
		.invoke_loginurl("baseUrl")
	    	.enter_username("sachin.pathak@vendormate.com")
	    	.enter_password("gltd@123")
	    	.click_login_button();
	    	//.click_continue_button();
	    	
        
	    get(NBDHomePage.class)
	    	.click_unpaid_vendors()
       	 	.verify_unpaid_vendors_header_text("Reps of Unpaid Vendors")
       	 	.back_to_home_unpaid_vendors();
     
	}  
	
	@Test(priority=2, groups = {"functional"})                                   //recent visitors
	 public void verifyRecentVisitors() {
	  
	    get(NBDHomePage.class)
	       .click_recent_visitors_link()
	       .verify_signin_history_header_text("Sign In History")
	       .click_signinhistory_backtohome();
	 }
	
	@Test(priority=3, groups = {"functional"})                                   //vendors registered
	public void verifyVendorsRegistered() {
		
	   get(NBDHomePage.class)
	     	.click_vendors_reg_link()
	     	.verify_vendors_registered_header_text("Vendors")
	     	.back_to_home_vendors_reg_link();
	}
	
	@Test(priority=4, groups = {"functional"})                                   //Reps registered
	public void verifyRepsRegistered() {
		
	  get(NBDHomePage.class)
	  		.click_reps_reg_link()
	  		.verify_reps_registered_header_text("Reps")
	  		.back_to_home_reps_reg_link();
	}
	
	@Test(priority=5, groups = {"functional"})                                   //Visit in last 30 Days
	public void verifyLastVisitIn30Days() {
		
	  get(NBDHomePage.class)
	  		.click_visitinlast30days()
	  		.verify_visit_in_last30days_header_text("Sign In History")
	  		.click_visitinlast30Days_backtohome();
	}
	
		
	@Test(priority=6, groups = {"functional"})                                   //Support Center
	public void verifySupportCenter() {
		
	  get(NBDSupportCenterPage.class, focus_on_parent_window())
	  		.click_support_center_link();
	  
	  get(NBDSupportCenterPage.class, focus_on_popup_window())
	    	.verify_support_center_text("how can we help?");
	  		focus_on_popup_window().close();
	}
	
	@Test(priority=7, groups = {"functional"})                                   //Vendormate Home
	public void verifyVendorMateHome() {
		
	  get(NBDVendorMateHomePage.class, focus_on_parent_window())
	  		.click_vendormate_home_link();
	  
	 get(NBDVendorMateHomePage.class, focus_on_popup_window())
	    	.verify_total_vendors_text_prod("Total Active Vendors");
	 		focus_on_popup_window().close();
	
	}
	
	@Test(priority=8, groups = {"functional"})                                   //Live Webinar
	public void verifyLiveWebinarImageLink() {
		
	  get(NBDWebinarPage.class, focus_on_parent_window())
	  		.click_live_webinar_image_link();
	  
	  get(NBDWebinarPage.class, focus_on_popup_window())
	    	.verify_vendormate_credential_manager_training_text("Vendormate Credential Manager Training");
	  		focus_on_popup_window().close();
	}
	
	@Test(priority=9, groups = {"functional"})                                   //help
	public void verifyHelp() {
		
		get(NBDVendorsPage.class, focus_on_parent_window())
	  		.click_vendors_tab()
	  		.click_help_link()
	  		.wait_until(5)
	  		.close_help_popup();
		
	}
	
	@Test(priority=10, groups = {"functional"})                                   //Global company name search
	public void verifyCompanyNameGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("ABC")
	  		.click_search_button()
	  		.verify_search_results_text("ABC Medical")
	  		.click_cross_sign_on_global_search_field();
		
	}
	@Test(priority=11, groups = {"functional"})                                   //Global rep name search
	public void VerifyRepNameGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("Bruce")
	  		.click_search_button()
	  		.verify_rep_name_search_results_text("Bruce")
	  		.click_cross_sign_on_global_search_field();
	
	}
	@Test(priority=12, groups = {"functional"})                                   //Global rep mail id search
	public void verifyRepMailIdGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("anamika.dutta@vendormate.com")
	  		.click_search_button()
	  		.verify_rep_mailid_search_results_text("anamika.dutta@vendormate.com")
	  		.click_cross_sign_on_global_search_field();
	
	}
	@Test(priority=13, groups = {"functional"})                                   //Vendor Details page
	public void verifyVendorDetailsPage() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("BizSense Test 2")
			.click_filter_button()
			.click_legal_name_link()
			.wait_until(5)
			.verify_vendor_details_header_text("BizSense Test 2")
			.switch_to_root_page();
		
	}
		
	@Test(priority=14, groups = {"functional"})                                   //Back to list
	public void verifyBackToList() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("BizSense Test 2")
			.click_filter_button()
			.click_legal_name_link()
			.wait_until(5)
			.click_back_to_list_link();
		
		get(NBDHomePage.class)
			.verify_vendors_registered_header_text("Vendors");
		 	
	}
	@Test(priority=15, groups = {"functional"})                                   //clear button
	public void verifyClearButtonFunctionality() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("BizSense Test 2")
			.click_filter_button()
			.click_clear_link();
	
	}
	@Test(priority=16, groups = {"functional"})                                   //doing business as
	public void verifyDoingBusinessAs() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_doing_business_as_in_filter_field("Compucharts")
			.click_filter_button()
			.click_doing_business_as_name_link_prod()
			.wait_until(5)
			.verify_dba_on_vendor_details_page("Compucharts");
	}
	
	@Test(priority=17, groups = {"functional"})                                   //verify fail on vendors page	
	public void verifyFailOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.click_fail_option_from_documents_dropdown()
			.verify_fail_text_in_documents_column("FAIL");
	}
	
	@Test(priority=18, groups = {"functional"})                                   //verify pass on vendors page	
	public void verifyPassOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_pass_option_from_documents_dropdown()
			.verify_pass_text_in_documents_column("PASS");
	}
	
		
	@Test(priority=19, groups = {"functional"})                                   //verify add appointment on vendors page	
	public void verifyAddAppointmentOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.click_add_appointment_option_from_action_dropdown()
			.verify_add_appointment_accordian_text("Add Appointment");
	}
	
	@Test(priority=20, groups = {"functional"})                                   //Info tab
	public void verifyInfoTab() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("BizSense Test 2")
			.click_filter_button()
			.click_legal_name_link()
			.switch_to_vendors_details_iframe_()
			.verify_info_tax_id_text("BizSense12");
	}
	
	@Test(priority=21, groups = {"functional"})                                   //documents tab
	public void verifyDocumentsTab() {
		
		get(NBDVendorsPage.class)
			.click_documents_tab()
			.verify_docs_acknowledgements_req_for_text("Acknowledgments Required for BizSense Test 2");
	}

	@Test(priority=22, groups = {"functional"})                                   //score card tab
	public void verifyScoreCardsTab() {
		
		get(NBDVendorsPage.class)
			.click_scorecard_tab()
			.verify_scorecard_text("Notes entered here");
	}
	
	@Test(priority=23, groups = {"functional"})                                   //principals tab
	public void verifyPrincipalsTab() {
		
		get(NBDVendorsPage.class)
			.click_principals_tab()
			.verify_principal_name_text("Rubal Bagade");
	}
	
	@Test(priority=24, groups = {"functional"})                                   //contacts tab
	public void verifyContactsTab() {
		
		get(NBDVendorsPage.class)
			.click_contacts_tab()
			.verify_contacts_principal_name_text("Rubal Bagade");
	}
	@Test(priority=25, groups = {"functional"})                                   //reps tab
	public void verifyRepsTab() {
		
		get(NBDVendorsPage.class)
			.click_reps_tab()
			.verify_rep_name_text("Ranade, Abhijit")
			.wait_until(5);
		
	}
	@Test(priority=26, groups = {"functional"})                                   //GS1 keys tab
	public void verifyGS1KeysTab() {
		
		get(NBDVendorsPage.class)
			.click_gs1_keys_tab()
			.verify_gs1_key_name_text("Test Key")
			.switch_to_root_page();
		
	}
	
	@Test(priority=27, groups = {"functional"})                                   //Verify sign in column text
	public void verifySignInColumnText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("25")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("28")
		 	.click_filter_button()
		 	.enter_user_information_in_filter_field("5210300656")
		 	.click_filter_button()
		 	.verify_signin_date_text_in_signin_column("Sep 26, 2015 08:54 PM")
		 	.click_clear_link();
	}
	
		
	@Test(priority=28, groups = {"functional"})                                   //user information - rep name
	public void verifyUserInformation() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("April")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("April")
		 	.select_signin_to_date("2")
		 	.click_filter_button()
		 	.enter_rep_name_in_filter_field("Rubal")
		 	.click_filter_button()
		 	.verify_repname_text_in_user_information_column("Rubal Bagade")
		 	.click_clear_link();
	}
	
	@Test(priority=29, groups = {"functional"})                                   //verify message text
	public void verifyMessageText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("June")
		 	.select_signin_from_date("14")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("June")
		 	.select_signin_to_date("18")
		 	.click_filter_button()
		 	.enter_message_in_filter_field("Overall Doc Alerts is PASS")
		 	.click_filter_button()
		 	.verify_message_text_in_message_column("Overall Doc Alerts is PASS")
			.click_clear_link();
	}
	
	@Test(priority=30, groups = {"functional"})                                   //verify dept name
	public void verifyDeptNameText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		  	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_dept_in_filter_field("test")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("test")
		 	.click_clear_link();
	}

	@Test(priority=31, groups = {"functional"})                                   //verify sign in loc text
	public void verifySignInLocText() {
		 
		get(NBDSignInHistoryPage.class)
			.click_signinhistory_tab()
			.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
			.click_filter_button()
		 	.enter_signin_loc_in_filter_field("Third Floor")
		 	.click_filter_button()
		 	.verify_signin_loc_text_in_signin_loc_column("Third Floor")
		 	.click_clear_link();
	}
	
	@Test(priority=32, groups = {"functional"})                                   //verify sign in poe text
	public void verifySignInPOEText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_signin_poe_in_filter_field("Third POE")
		 	.click_filter_button()
		 	.verify_signin_poe_in_poe_column("Third POE")
		 	.click_clear_link();
	}
	
	@Test(priority=33, groups = {"functional"})                                   //verify contact text
	public void verifyContactText() {
		
		 get(NBDSignInHistoryPage.class)
		   	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_contact_in_filter_field("Test Customer")
		 	.click_filter_button()
		 	.verify_contactname_in_contact_column("Test Customer")
		 	.click_clear_link();
	}	
	
	@Test(priority=34, groups = {"functional"})                                   //verify purpose of visit text
	public void verifyPurposeOfVisitText() {
		
		 get(NBDSignInHistoryPage.class)
		    .click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_purpose_of_visit_in_filter_field("Daily, Starts on Aug 20, 2014, Until Aug 19, 2015")
		 	.click_filter_button()
		 	.verify_purposeofvisit_in_purposeofvisit_column("Daily, Starts on Aug 20, 2014, Until Aug 19, 2015")
		 	.click_clear_link();
	}
	
	
	
		 
	
	@Test(priority=35, groups = {"functional"})                                   //verify Signed in by text in signed in by column
	public void verifySignedInByTextInSignedByColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.enter_signin_poe_in_filter_field("Third POE")
		 	.click_filter_button()
		 	.enter_signed_in_by_in_filter_field("abhijit.ranade@vendormate.com")
		 	.click_filter_button()
		 	.verify_text_in_signedinby_column("abhijit.ranade@vendormate.com")
		 	.click_clear_link();
		 
}

	@Test(priority=36, groups = {"functional"})                                   //verify Badge Rule Exception  text in Badge rule exception column
	public void verifyBadgeExceptionTextInBadgeRuleExceptionColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("January")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("30")
		 	.click_filter_button()
		 	.enter_badge_exception_text_in_filter_field("Just saying hello.")
		 	.click_filter_button()
		 	.verify_badgeruleexceptiontext_in_badgeruleexception_column("Just saying hello.")
		 	.click_clear_link();
		 
		
}	
	@Test(priority=37, groups = {"functional"})                                   //verify Sign out loc text in Sign out loc column
	public void verifySignOutLocInSignOutLocColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_signout_loc_in_filter_field("Third Floor")
		 	.click_filter_button()
		 	.verify_signedoutloc_in_signedoutloc_column("Third Floor")
		 	.click_clear_link();
		 
}	
	@Test(priority=38, groups = {"functional"})                                   //verify Sign out POE text in Sign out POE column
	public void verifySignOutPOEInSignOutPOEColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_signout_poe_in_filter_field("Third POE")
		 	.click_filter_button()
		 	.verify_signedoutpoe_in_signedoutpoe_column("Third POE")
		 	.click_clear_link();
		 
}	
	@Test(priority=39, groups = {"functional"})                                   //verify Sign out by text in Sign out by column
	public void verifySignOutByInSignOutByColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.wait_until(2)
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_signed_out_by_in_filter_field("abhijit.ranade@vendormate.com")
		 	.click_filter_button()
		 	.verify_signedoutbytext_in_signedoutby_column("abhijit.ranade@vendormate.com")
		 	.click_clear_link();
		 
		
}
	@Test(priority=40, groups = {"functional"})                                   //verify group text in group column
	public void verifyGroupNameInGroupColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_signout_poe_in_filter_field("Third POE")
		 	.enter_group_in_filter_field("Main Office")
		 	.click_filter_button()
		 	.verify_groupnametext_in_group_column("Main Office")
		 	.click_clear_link();
		 
		
}
	@Test(priority=41, groups = {"functional"})                                   //verify remote badge print date text and expected arrival text in remote badge print column
	public void verifyRemoteBadgePrintDateTextInRemoteColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("May")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_year_from_dropdown() 
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("30")
		 	.click_filter_button()
		 	.click_in_remotebadgeprint_from_date_field()
		 	.wait_until(2)
		 	.click_in_remotebadgeprint_from_date_field()
		 	.select_year_from_dropdown() 
		  	.select_month_from_dropdown("May")
		 	.select_signin_from_date("7")
		 	.click_in_remotebadgeprint_to_date_field()
		 	.wait_until(2)
		 	.click_in_remotebadgeprint_to_date_field()
		 	.select_year_from_dropdown() 
		 	.wait_until(5)
		 	.select_month_from_dropdown("May")
		 	.select_signin_to_date("7")
		 	.click_filter_button()
		 	.verify_remotebadgeprint_date_text_in_remotebadgeprint_column("May 07, 2015 04:33 AM")
		 	.verify_expectedarrival_date_text_in_expectedarrival_column("May 07, 2015 05:00 AM")
		 	.click_clear_link();
		 	
		 
}
	@Test(priority=42, groups = {"functional"})                                   //verify first name in first name column
	public void verifyFirstNameInFirstNameColumn() {
		
		 get(NBDManageUsersPage.class)	
		 	.click_manageusers_tab()
		 	.wait_until(10)
		 	.enter_first_name_in_filter_field("AmeetUL")
		 	.click_filter_button()
		 	.verify_first_name_text_in_firstname_column("AmeetUL")
		 	.click_clear_link()
		 	.wait_until(10);
}	 
	@Test(priority=43, groups = {"functional"})                                   //verify last name in last name column
	public void verifyLastNameInLastNameColumn() {
		
		 get(NBDManageUsersPage.class)	
		 	.enter_last_name_in_filter_field("IngaleUL")
		 	.click_filter_button()
		 	.verify_last_name_text_in_lastname_column("IngaleUL")
		 	.click_clear_link()
		 	.wait_until(5);
}	 	
	 
	@Test(priority=44, groups = {"functional"})                                   //verify email id in email column
	public void verifyEmailIdInEmailColumn() {
			
		get(NBDManageUsersPage.class)	
			 .enter_emailid_in_filter_field("ingale.ameet7009@gmail.com")
			 .click_filter_button()
			 .verify_email_id_in_email_column("ingale.ameet7009@gmail.com")
			 .click_clear_link()
			 .wait_until(5);
}	
	
	@Test(priority=45, groups = {"functional"})                                   //verify phone number in work phone column
	public void verifyPhoneNumberInWorkPhoneColumn() {
			
		get(NBDManageUsersPage.class)	 
			 . enter_work_phone_in_filter_field("8600156635")
			 .click_filter_button()
			 .verify_work_phone_in_workphone_column("8600156635")
			 .click_clear_link();
		
 
}
	@Test(priority=46, groups = {"functional"})                                   //verify inactivate user pop up text
	public void verifyInactivateUserPopUpText() {
			
		get(NBDManageUsersPage.class)
			 .click_manageusers_tab()
			 .wait_until(10)
			 .enter_first_name_in_filter_field("AmeetUL")
		 	 .click_filter_button()
		 	 .wait_until(10)
			 .select_from_action_dropdown("Inactivate User")
			 .verify_inactivateusers_popup_text("The selected user will be inactivated, and will no longer be able to gain access to the Vendormate system. Would you like to continue with this user inactivation?")
			 .close_inactivateuser_popup();
		
		
	}
	
	@Test(priority=47, groups = {"functional"})                                   //verify header text on 'Create New User' form
	public void verifyHeaderTextonCreateNewUserForm() {
			
		get(NBDManageUsersPage.class)
			 .click_create_new_user_button()
			 .verify_header_text_on_create_new_user_form("Create New User")
		 	 .close_create_new_user_form();
		
	}

	@Test(priority=48, groups = {"functional"})                                   //verify header text on 'Edit User' form
	public void verifyHeaderTextonEditUserUserForm() {
			
		get(NBDManageUsersPage.class)
			 .select_from_action_dropdown("Edit User")
		 	 .verify_header_text_on_edit_user_form("Edit User")
			 .close_edit_user_form();
			
	}
	
	@Test(priority=49, groups = {"functional"})                                    //verify activate user pop up text
	public void verifyActivateUserPopUpText() {
		
		get(NBDManageUsersPage.class)
		 .user_status_dropdown("Inactive Users")
		 .wait_until(5)
		 .enter_first_name_in_filter_field("ameya")
	 	 .click_inactiveusers_filter_button()
	 	 .wait_until(5)
		 .select_from_action_dropdown("Activate User")
		 .verify_inactivateusers_popup_text("Are you sure you want to activate this user?")
		 .close_inactivateuser_popup()
		 .click_clear_link_oninactive_users_page();
	
			
		get(CommonUtilities.class)
		.do_log_out_from_NBD();	
	}
						
			/**
			* Log Into NBD and click on Appointments Tab  
			* Select Start and End Date Filters
			* Search and Verify Appointment Subject
			*/
	@Test(priority=52, groups = {"functional"})	                                       
	public void verifyApptSubject(){
				
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("sachin.pathak@vendormate.com")
			.enter_password("gltd@123")
			.click_login_button()
			//.click_continue_button()
			.wait_until(15);

		get(NBDAppointmentsPage.class)
			.click_appointment_tab()
			.wait_until(2)
			.select_start_date("May", "23", "2015")
			.select_end_date("May", "22", "2016")
			.enter_appointment_subject(appointment_subject)
			.click_filter_button()
			.wait_until(5)
			.verify_appointment_name_in_search(appointment_search_result)
			.click_clear_link()
			.wait_until(2);	
	}		
					

	/**
	* Verify CreatedBy ID in search and Result 
			*/
	@Test(priority=53, groups = {"functional"})	                                       
	public void verifyCreatedById(){
				
		get(NBDAppointmentsPage.class)
			.enter_createdby_id(enter_createdby_id)
			.click_filter_button()
			.wait_until(2)
			.verify_createdby_id_in_result(verify_createdby_id)
			.click_clear_link()
			.wait_until(2);			
		}
			
	/**
	* Verify Location Name in search and Result 
	*/
	@Test(priority=54, groups = {"functional"})	                                       
	public void verifyLocationName(){
				
		get(NBDAppointmentsPage.class)
			.enter_location_name(enter_location)
			.click_filter_button()
			.wait_until(2)
			.verify_location_name_in_result(verify_location)
			.click_clear_link()
			.wait_until(2);			
		}	

	/**
	* Verify Department Name in search and Result 
	*/
	@Test(priority=55, groups = {"functional"})	                                       
	public void verifyDepartmentName(){
				
		get(NBDAppointmentsPage.class)
			.enter_department_name(enter_department)
			.click_filter_button()
			.wait_until(2)
			.verify_department_name_in_result(verify_department)
			.click_clear_link()
			.wait_until(2);			
		}	
			
	/**
	* Verify Staff Name in search and Result 
	*/
	@Test(priority=56, groups = {"functional"})	                                       
	public void verifyStaffName(){
				
		get(NBDAppointmentsPage.class)
			.enter_staff_name(enter_staff)
			.click_filter_button()
			.wait_until(2)
			.verify_staff_name_in_result(verify_staff)
			.click_clear_link()
		    .wait_until(2);			
		}	

	/**
	* Verify Email ID in search and Result 
	*/
	@Test(priority=57, groups = {"functional"})	                                       
	public void verifyEmailId(){
				
		get(NBDAppointmentsPage.class)
			.enter_email_ID(enter_email_id)
			.click_filter_button()
			.wait_until(2)
			.verify_email_ID(verify_email_id)
			.click_clear_link()
			.wait_until(2);			
		}

	/**
	* Verify User Name in search and Result 
	*/
	@Test(priority=58, groups = {"functional"})	                                       
	public void verifyUserName(){
				
		get(NBDAppointmentsPage.class)
			.enter_user_name(enter_username)
			.click_filter_button()
			.wait_until(2)
			.verify_user_name(verify_username)
			.click_clear_link()
			.wait_until(2);			
		}
			
	/**
	* Verify Company Name in search and Result 
	*/
	@Test(priority=59, groups = {"functional"})	                                       
	public void verifyCompanyName(){
				
		get(NBDAppointmentsPage.class)
			.enter_company_name(enter_companyname)
			.click_filter_button()
			.wait_until(2)
			.verify_company_name(verify_companyname)
			.click_clear_link()
			.wait_until(2);			
		}

	/**
	* Click Company Name Link in search and verify name in Vendor details page 
	*/
	@Test(priority=60, groups = {"functional"})	                                       
	public void verifyCompanyNameLink(){
				
		get(NBDAppointmentsPage.class)
			.enter_company_name(enter_companyname)
			.click_filter_button()
			.wait_until(2)
			.click_company_link(" BizSense Test 2")
			.wait_until(7)
			.verify_apptdetails_vendorname(vendor_name)
			.click_appt_backtolist_link()
			.wait_until(2);
		}
			
	/**
	* Click User Name Link in search and verify name in Rep details page 
	*/
	@Test(priority=61, groups = {"functional"})	                                       
	public void verifyUserNameLink(){
				
		get(NBDAppointmentsPage.class)
			.enter_user_name(enter_username)
			.click_filter_button()
			.wait_until(2)
			.click_user_link("sachin pathak")
			.wait_until(7)
			.verify_apptdetails_username(repdetails_username)
			.click_appt_backtolist_link()
			.wait_until(2);
		 	
}	
	
	/**
	* Log Into NBD and click First_Name_Check_in_Reps_Tab  
	* verify labels 'sanction list', 'individual' and 'doc alerts' label and then go back to reps tab
	*/
	@Test(priority=62, groups = {"functional"})	                                       
	public void VerifyInfoTabSection(){
			
		get(NBDRepsPage.class)
			.click_reps_tab()
			.wait_until(10)
			.enter_firstname("sachin")
			.click_reps_tab_first_name_filter_transaction()
			.wait_until(2);
	
		get(NBDRepDetailsPage.class)
			.click_reps_tab_first_name_click()
			.verify_check_sanctionlist_label("Sanction Lists")
			.verify_check_individual_label("Individual")
			.verify_check_docalerts_label("Doc Alerts")
			.verify_check_reqddocs_label("Required Docs")
			.verify_check_reqddocs_status("FAIL")
			.verify_check_effectivedate_label("Effective date")
			.verify_check_effectivedate_status("NA")
			.verify_check_expirationdate_label("Expiration date")
			.verify_check_expirationdate_status("PASS");			
}	
	
	/**
	* Verify Employee label, Employee Name in RepDetails Page
	* Verify E-mail ID & Phone No in RepDetails Page 
	*/
	@Test(priority=63, groups = {"functional"})	                                      
	public void VerifyRepDetailsHeaderSection(){
		
		get(NBDRepsPage.class)
			.click_back_to_list_link()
			.wait_until(3);
	
		get(NBDRepDetailsPage.class)
			.click_reps_tab_last_name_click()
			.verify_check_employer_label("Employer")
			.verify_check_employer_name("BizSense Test 2")
			.verify_check_email_address_label("Email Address")
			.verify_check_email_ID("sachin.pathak@bizsense.in")
			.verify_check_phonenumber_label("Phone Number")
			.verify_check_phonenumber("8956236589");
}
	
	/**
	* Verify Code label and Number in RepDetails - Products tab
	* Verify Description label and details in RepDetails - Products tab 
	*/	
	@Test(priority=64, groups = {"functional"})	                                      	
	public void VerifyProductsTab(){
		
		get(NBDRepDetailsPage.class)	
			.click_product_tab()
			.verify_check_code_label("Code")
			.verify_check_codeone_ID("73110000")
			.verify_check_codetwo_ID("14111500")
			.verify_check_description_label("Description")
			.verify_check_description_one_details("Wood and paper industries")
			.verify_check_description_two_details("Printing and writing paper");
}

	/**
	* Verify Vendor Name in VendorDetails Page
	* click on back-to-list link and logging out of NBD to complete test case flow
	*/	
	@Test(priority=65, groups = {"functional"})	                                      	
	public void VerifyVendorName(){
		
		get(NBDRepsPage.class)
			.click_back_to_list_link();
	
		get(NBDRepDetailsPage.class)
			.click_reps_tab_company_name_click()
			.wait_until(2)
			.verify_check_vendorname("BizSense Test 2")
			.switch_to_root_page()
			.click_vendordetails_backtolist_link()
			.wait_until(2);
		 
	}
	
	
	@Test(priority=66, groups = {"functional"})	                                      //Log_Into_NBD & First_Name_Check_in_Reps_Tab 
	public void VerifyFirstNameCheck(){
		
		get(NBDRepsPage.class)
			.click_reps_tab()
			.wait_until(10)
			.enter_firstname("sachin")
			.click_reps_tab_first_name_filter_transaction()
			.wait_until(2)
			.verify_reps_tab_first_name_in_result("sachin")
			.click_reps_tab_first_name_clear_filter()
			.wait_until(2);
}
	
	@Test(priority=67, groups = {"functional"})	                                      //Last_Name_Check_in_Reps_Tab 
	public void VerifyLastNameCheck(){
		get(NBDRepsPage.class)
			.enter_lastname("pathak")
			.click_reps_tab_last_name_filter_transaction()
			.wait_until(2)
			.verify_reps_tab_last_name_in_result("pathak")
			.click_reps_tab_last_name_clear_filter()
			.wait_until(3);
}		
	
	@Test(priority=68, groups = {"functional"})	                                      //Company_Name_Check_in_Reps_Tab 
	public void VerifyCompanyNameCheck(){
		get(NBDRepsPage.class)
			.enter_companyname("BizSense Test 2")
			.click_reps_tab_company_name_filter_transaction()
			.wait_until(3)
			.verify_reps_tab_company_name_in_result("BizSense Test 2")
			.wait_until(2);
		
		get(CommonUtilities.class)
    		.do_log_out_from_NBD();
}		
	
	/* @Test(priority=69, groups = {"functional"})	                                      //IFrame_Check_Rep_Details_Accordion 
	public void VerifyDocIframe(){
		get(NBDRepsPage.class)
			.click_reps_tab_rep_document_status()
			.wait_until(7)
			.verify_badgephoto_label_in_repdetails_accordion("Badge Photo")
			.verify_badgephoto_doc_status_in_repdetails_accordion("Complete")
			.verify_orprotocol_label_in_repdetails_accordion("OR_Protocol_Training")
			.verify_orprotocol_doc_status_in_repdetails_accordion("Complete")
			.click_back_to_list_link()
			.wait_until(2);
			
}*/
	

	@Test(priority=70, groups = {"functional"})                                         //valid_Username
	public void VerifyMyProfileSection(){
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("sachin.pathak@vendormate.com")
			.enter_password("gltd@123")
			.click_login_button()
			.click_continue_button()
			.wait_until(7);
		
		get(NBDRootPage.class)
			.click_username_dropdown()
			.click_my_profile()
			.wait_until(5)
			.verify_user_id_in_my_profile("sachin.pathak@vendormate.com");
		
		get(CommonUtilities.class)
			.do_log_out_from_NBD();
		
	}	
	
	/**
	 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
	 * It will create folder based on your suite file name present in the .xml file
	 * Copy paste this method at the bottom of your each class.
	 * @param project_name = provide name of your project 
	 */
	@AfterMethod(groups = "functional")
	public void takeScreenShotForFailedTests (ITestResult result, ITestContext ctx) {
		
		String project_name = "cm";
			
		boolean current_status = result.isSuccess();
		if(current_status == false)
			{try {	
					Date date = new Date();
					String DATE_FORMAT = "MM-dd-yyyy";
					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
					String current_date = sdf.format(date);
					 String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
					
					String location_1 = "D:\\AutomationFiles\\";
					String location_2 = location_1 + project_name +"\\";
					String location_3 = location_2 + "screenshots\\";
					String file_location = location_3 + suiteName +" " +current_date +"\\";
					
					File main_f = new File(location_1);
					boolean f_1 = main_f.exists();
					if(f_1 == false)
					main_f.mkdir();
					
					File project_f = new File(location_2);
					boolean f_2 = project_f.exists();
					if(f_2 == false)
					project_f.mkdir();
					
					File screenshot_f = new File(location_3);
					boolean f_3 = screenshot_f.exists();
					if(f_3 == false)
					screenshot_f.mkdir();
					
					File dir = new File(file_location);
				    dir.mkdir();
				    
					String testParameter = ctx.getCurrentXmlTest().getParameter("env");
					
					boolean x = testParameter.contains("FF");
					boolean y = testParameter.contains("IE");
					boolean z = testParameter.contains("CR");
					
					String browser = null;
					if(x == true)
					browser  = "-FF";
					
					else if(y == true)
					browser  = "-IE";
					
					else if(z == true)
					browser  = "-CR";
					
				    String file_name = result.getName() + browser;
					Thread.sleep(3000);
					BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "jpg", new File(file_location + file_name + ".jpg"));
				}   catch (Throwable e) {e.printStackTrace();}
		}	
	}
	
}
	
		
	



