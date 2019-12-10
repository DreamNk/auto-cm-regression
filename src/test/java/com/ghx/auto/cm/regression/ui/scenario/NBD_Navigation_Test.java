package com.ghx.auto.cm.regression.ui.scenario;


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

public class NBD_Navigation_Test extends AbstractAutoUITest {
	
// Test Data for Appointment Test Cases
    String appointment_subject = "Aut'omation-Appointme'nt";
	String appointment_search_result = "Aut'omation-Appointme'nt";
	String enter_createdby_id = "auto_buyer2@beverly.vdm";
	String verify_createdby_id = "auto_buyer2@beverly.vdm";
	String enter_location = "Location 1";
	String verify_location = "Location 1";
	String enter_department = "Accounting";
	String verify_department = "Accounting";
	String enter_staff = "Au'tomation Bu'yer";
	String verify_staff = "Au'tomation Bu'yer";
	String enter_email_id = "bev'erly.rep@bvendor.vm";
	String verify_email_id = "bev'erly.rep@bvendor.vm";
	String enter_username = "Bev'erly Ad'min";
	String verify_username = "Bev'erly Ad'min";
	String enter_companyname = "Auto'mation BVendor";
	String verify_companyname = "Auto'mation BVendor";
	String vendor_name = "Auto'mation BVendor";
	String repdetails_username = "Bev'erly Ad'min";
	
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test(priority=1, groups = {"functional"})
	public void verifyUnpaidVendors() { 
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
	    	.enter_username("auto_buyer1@beverly.vdm")
	    	.enter_password("gltd@123")
	    	.click_login_button()
	    	.click_continue_button(); 
        
	    get(NBDHomePage.class)
	    	.click_unpaid_vendors()
       	 	.verify_unpaid_vendors_header_text("Reps of Unpaid Vendors")
       	 	.back_to_home_unpaid_vendors();
     
	}  
	
	@Test(priority=2, groups = {"functional"})                                   //vendors registered
	public void verifyVendorsRegistered() {
		
	   get(NBDHomePage.class)
	     	.click_vendors_reg_link()
	     	.verify_vendors_registered_header_text("Vendors")
	     	.back_to_home_vendors_reg_link();
	}
	
	@Test(priority=3, groups = {"functional"})                                   //Reps registered
	public void verifyRepsRegistered() {
		
	  get(NBDHomePage.class)
	  		.click_reps_reg_link()
	  		.verify_reps_registered_header_text("Reps")
	  		.back_to_home_reps_reg_link();
	}
	
	@Test(priority=4, groups = {"functional"})                                   //Visit in last 30 Days
	public void verifyLastVisitIn30Days() {
		
	  get(NBDHomePage.class)
	  		.click_visitinlast30days()
	  		.verify_visit_in_last30days_header_text("Sign In History")
	  		.click_visitinlast30Days_backtohome();
	}
	
		
	@Test(priority=5, groups = {"functional"})                                   //Support Center
	public void verifySupportCenter() {
		
	  get(NBDSupportCenterPage.class, focus_on_parent_window())
	  		.click_support_center_link();
	  
	  get(NBDSupportCenterPage.class, focus_on_popup_window())
	    	.verify_support_center_text("how can we help?");
	  		focus_on_popup_window().close();
	}
	
	@Test(priority=6, groups = {"functional"})                                   //Vendormate Home
	public void verifyVendorMateHome() {
		
	  get(NBDVendorMateHomePage.class, focus_on_parent_window())
	  		.click_vendormate_home_link();
	  
	 get(NBDVendorMateHomePage.class, focus_on_popup_window())
	    	.click_cross_sign_of_popup();
	 		focus_on_popup_window().close();
	
	}
	@Test(priority=7, groups = {"functional"})                                   //Live Webinar
	public void verifyLiveWebinarImageLink() {
		
	  get(NBDWebinarPage.class, focus_on_parent_window())
	  		.click_live_webinar_image_link();
	  
	  get(NBDWebinarPage.class, focus_on_popup_window())
	    	.verify_vendormate_credential_manager_training_text("Vendormate Credential Manager Training");
	  		focus_on_popup_window().close();
	}
	
	@Test(priority=8, groups = {"functional"})                                   //help
	public void verifyHelp() {
		
		get(NBDVendorsPage.class, focus_on_parent_window())
	  		.click_vendors_tab()
	  		.click_help_link()
	  		.close_help_popup();
		
	}
	
	@Test(priority=9, groups = {"functional"})                                   //Global company name search
	public void verifyCompanyNameGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("555 Hospital")
	  		.click_search_button()
	  		.verify_search_results_text("555 Hospital")
	  		.click_cross_sign_on_global_search_field();
		
	}
	@Test(priority=10, groups = {"functional"})                                   //Global rep name search
	public void VerifyRepNameGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("Edward")
	  		.click_search_button()
	  		.verify_rep_name_search_results_text("Edward")
	  		.click_cross_sign_on_global_search_field();
	
	}
	@Test(priority=11, groups = {"functional"})                                   //Global rep mail id search
	public void verifyRepMailIdGlobalSearch() {
		
		get(NBDVendorsPage.class)
	  		.global_search_field("edward@vendorone.vm")
	  		.click_search_button()
	  		.verify_rep_mailid_search_results_text("edward@vendorone.vm")
	  		.click_cross_sign_on_global_search_field();
	
	}
	@Test(priority=12, groups = {"functional"})                                   //Vendor Details page
	public void verifyVendorDetailsPage() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("555 Hospital")
			.click_filter_button()
			.click_legal_name_link()
			.wait_until(5)
			.verify_vendor_details_header_text("555 Hospital")
			.switch_to_root_page();
		
	}
		
	@Test(priority=13, groups = {"functional"})                                   //Back to list
	public void verifyBackToList() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("555 Hospital")
			.click_filter_button()
			.click_legal_name_link()
			.wait_until(5)
			.click_back_to_list_link();
		
		get(NBDHomePage.class)
			.verify_vendors_registered_header_text("Vendors");
		 	
	}
	@Test(priority=14, groups = {"functional"})                                   //clear button
	public void verifyClearButtonFunctionality() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("555 Hospital")
			.click_filter_button()
			.click_clear_link();
	
	}
	@Test(priority=15, groups = {"functional"})                                   //doing business as
	public void verifyDoingBusinessAs() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_doing_business_as_in_filter_field("consulting")
			.click_filter_button()
			.click_doing_business_as_name_link()
			.wait_until(5)
			.verify_dba_on_vendor_details_page("consulting");
	}
	
	@Test(priority=16, groups = {"functional"})                                   //verify fail on vendors page	
	public void verifyFailOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.click_fail_option_from_documents_dropdown()
			.verify_fail_text_in_documents_column("FAIL");
	}
	
	@Test(priority=17, groups = {"functional"})                                   //verify pass on vendors page	
	public void verifyPassOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_pass_option_from_documents_dropdown()
			.verify_pass_text_in_documents_column("PASS");
	}
	
	@Test(priority=18, groups = {"functional"})                                   //verify na on vendors page	
	public void verifyNAOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_na_option_from_documents_dropdown()
			.verify_na_text_in_documents_column("N/A");
	}
	
	@Test(priority=19, groups = {"functional"})                                   //verify alert on vendors page	
	public void verifyAlertOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_alert_option_from_documents_dropdown()
			.verify_alert_text_in_documents_column("ALERT");
	}
	
	@Test(priority=20, groups = {"functional"})                                   //verify add appointment on vendors page	
	public void verifyAddAppointmentOptionFromDocumentsDropDown() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.click_add_appointment_option_from_action_dropdown()
			.verify_add_appointment_accordian_text("Add Appointment");
	}
	
	@Test(priority=21, groups = {"functional"})                                   //Info tab
	public void verifyInfoTab() {
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("555 Hospital")
			.click_filter_button()
			.click_legal_name_link()
			.switch_to_vendors_details_iframe_()
			.verify_info_tax_id_text("vendor123");
	}
	
	@Test(priority=22, groups = {"functional"})                                   //documents tab
	public void verifyDocumentsTab() {
		
		get(NBDVendorsPage.class)
			.click_documents_tab()
			.verify_docs_acknowledgements_req_for_text("Acknowledgments Required for 555 Hospital");
	}

	@Test(priority=23, groups = {"functional"})                                   //score card tab
	public void verifyScoreCardsTab() {
		
		get(NBDVendorsPage.class)
			.click_scorecard_tab()
			.verify_scorecard_text("Notes entered here");
	}
	
	@Test(priority=24, groups = {"functional"})                                   //principals tab
	public void verifyPrincipalsTab() {
		
		get(NBDVendorsPage.class)
			.click_principals_tab()
			.verify_principal_name_text("Principal Test");
	}
	
	@Test(priority=25, groups = {"functional"})                                   //contacts tab
	public void verifyContactsTab() {
		
		get(NBDVendorsPage.class)
			.click_contacts_tab()
			.verify_contacts_principal_name_text("Principal Test");
	}
	@Test(priority=26, groups = {"functional"})                                   //reps tab
	public void verifyRepsTab() {
		
		get(NBDVendorsPage.class)
			.click_reps_tab()
			.verify_rep_name_text("Louis, Edward")
			.wait_until(5);
		
	}
	@Test(priority=27, groups = {"functional"})                                   //GS1 keys tab
	public void verifyGS1KeysTab() {
		
		get(NBDVendorsPage.class)
			.click_gs1_keys_tab()
			.verify_gs1_key_name_text("GS! Test key")
			.switch_to_root_page();
		
	}
	
	@Test(priority=28, groups = {"functional"})                                   //Verify sign in column text
	public void verifySignInColumnText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("3")
		 	.click_filter_button()
		 	.enter_user_information_in_filter_field("0239021")
		 	.click_filter_button()
		 	.verify_signin_date_text_in_signin_column("Jul 06, 2015 04:29 PM")
		 	.click_clear_link();
	}
	
	/*@Test(priority=29, groups = {"functional"})                                   //verify 'printed on site' text
	public void verifyPrintedOnSite() {
		
		get(NBDSignInHistoryPage.class)
			.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.verify_all_text_in_eventtype_column("All")
		 	.select_eventtype_from_dropdown("Printed on site")
		 	.verify_printed_on_site_text_in_eventtype_column("Printed on site")
		 	.select_eventtype_from_dropdown("SignIn event")
		 	.verify_printed_remotely_text_in_eventtype_column("SignIn event")
		 	.click_clear_link();
	}*/
	
	

	@Test(priority=30, groups = {"functional"})                                   //verify clear functionality
	public void verifyClearFunctionality() {
		
		get(NBDSignInHistoryPage.class)
			.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_signin_from_date("1")
		  	.click_filter_button()
		 	.click_clear_link();
	}
	
	@Test(priority=31, groups = {"functional"})                                   //user information - rep name
	public void verifyUserInformation() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_rep_name_in_filter_field("Edward")
		 	.click_filter_button()
		 	.verify_repname_text_in_user_information_column("Edward Louis")
		 	.click_clear_link();
	}
	
	@Test(priority=32, groups = {"functional"})                                   //verify message text
	public void verifyMessageText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_message_in_filter_field("document missing")
		 	.click_filter_button()
		 	.verify_message_text_in_message_column("cus: document missing")
		 	.click_clear_link();
	}
	
	@Test(priority=33, groups = {"functional"})                                   //verify dept name
	public void verifyDeptNameText() {
		
		 get(NBDSignInHistoryPage.class)
		  	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_dept_in_filter_field("nursing")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("Nursing")
		 	.click_clear_link();
	}

	@Test(priority=34, groups = {"functional"})                                   //verify sign in loc text
	public void verifySignInLocText() {
		 
		get(NBDSignInHistoryPage.class)
			.enter_signin_loc_in_filter_field("loc")
		 	.click_filter_button()
		 	.verify_signin_loc_text_in_signin_loc_column("Location 1")
		 	.click_clear_link();
	}
	
	@Test(priority=35, groups = {"functional"})                                   //verify sign in poe text
	public void verifySignInPOEText() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("3")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("3")
		 	.click_filter_button()
		 	.enter_signin_poe_in_filter_field("Remote SignIn")
		 	.click_filter_button()
		 	.verify_signin_poe_in_poe_column("Remote SignIn")
		 	.click_clear_link();
	}
	
	@Test(priority=36, groups = {"functional"})                                   //verify contact text
	public void verifyContactText() {
		
		 get(NBDSignInHistoryPage.class)
		    .click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("25")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("25")
		 	.click_filter_button()
		 	.enter_contact_in_filter_field("MacDonald")
		 	.click_filter_button()
		 	.verify_contactname_in_contact_column("MacDonald")
		 	.click_clear_link();
	}	
	
	@Test(priority=37, groups = {"functional"})                                   //verify purpose of visit text
	public void verifyPurposeOfVisitText() {
		
		 get(NBDSignInHistoryPage.class)
		    .click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("July")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("1")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("12")
		 	.click_filter_button()
		 	.enter_purpose_of_visit_in_filter_field("For selling products")
		 	.click_filter_button()
		 	.verify_purposeofvisit_in_purposeofvisit_column("For selling products.")
		 	.click_clear_link();
	}
	
	@Test(priority=38, groups = {"functional"})                                   //verify 'All' in company status column
	public void verifyAllTextInCompanyStatusColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("25")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("25")
		 	.click_filter_button()
		 	.select_all_from_dropdown()
		 	.verify_unregistered_in_companystatus_column("UNREGISTERED")
		 	.verify_registered_in_companystatus_column("REGISTERED")
		 	.select_registered_from_dropdown()
		 	.verify_registered_in_companystatus_column("REGISTERED")
		 	.select_unregistered_from_dropdown()
		 	.verify_unregistered_in_companystatus_column("UNREGISTERED")
		 	.click_clear_link();
		
	}
	
		 
	
	@Test(priority=39, groups = {"functional"})                                   //verify Signed in by text in signed in by column
	public void verifySignedInByTextInSignedByColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("3")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("August")
		 	.select_signin_to_date("3")
		 	.click_filter_button()
		 	.enter_signed_in_by_in_filter_field("david@vendorone.vm")
		 	.click_filter_button()
		 	.verify_text_in_signedinby_column("david@vendorone.vm")
		 	.click_clear_link();
}	

	@Test(priority=40, groups = {"functional"})                                   //verify 'Rules enforced' drop down values in rules enforced column
	public void verifyAllTextInRulesEnforcedColumn() {
		
		 get(NBDSignInHistoryPage.class)
		 	.click_signinhistory_tab()
		 	.click_in_signin_from_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_year_from_dropdown() 
		 	.select_signin_from_date("25")
		 	.click_in_signin_to_date_field()
		 	.select_month_from_dropdown("September")
		 	.select_signin_to_date("25")
		 	.click_filter_button()
		  	.select_all_from_rules_enforced_dropdown()
		 	.verify_false_in_rulesenforced_column("False")
		 	.verify_true_in_rulesenforced_column("True")
		 	.select_false_from_rules_enforced_dropdown()
		 	.verify_false_in_rulesenforced_column("False")
		 	.select_true_from_rules_enforced_dropdown()
		 	.verify_true_in_rulesenforced_column("True")
		 	.click_clear_link();
		 
		 get(CommonUtilities.class)
			.do_log_out_from_NBD();	
		 
		
}		 	 
		 	
			/**
			* Log Into NBD and click on Appointments Tab  
			* Select Start and End Date Filters
			* Search and Verify Appointment Subject
			*/
	@Test(priority=41, groups = {"functional"})	                                       
	public void verifyApptSubject(){
				
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("auto_buyer2@beverly.vdm")
			.enter_password("gltd@123")
			.click_login_button()
			.click_continue_button()
			.wait_until(15);

		get(NBDAppointmentsPage.class)
			.click_appointment_tab()
			.wait_until(2)
			.select_start_date("August", "4", "2015")
			.select_end_date("August", "25", "2015")
			.click_filter_button()
			.wait_until(3)
			.enter_appointment_subject(appointment_subject)
			.click_filter_button()
			.wait_until(2)
			.verify_appointment_name_in_search(appointment_search_result)
			.click_clear_link()
			.wait_until(2);	
		}		
					

	/**
	* Verify CreatedBy ID in search and Result 
			*/
	@Test(priority=42, groups = {"functional"})	                                       
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
	@Test(priority=43, groups = {"functional"})	                                       
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
	@Test(priority=44, groups = {"functional"})	                                       
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
	@Test(priority=45, groups = {"functional"})	                                       
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
	@Test(priority=46, groups = {"functional"})	                                       
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
	@Test(priority=47, groups = {"functional"})	                                       
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
	@Test(priority=48, groups = {"functional"})	                                       
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
	@Test(priority=49, groups = {"functional"})	                                       
	public void verifyCompanyNameLink(){
				
		get(NBDAppointmentsPage.class)
			.enter_company_name(enter_companyname)
			.click_filter_button()
			.wait_until(2)
			.click_company_link("Auto'mation BVendor")
			.wait_until(7)
			.verify_apptdetails_vendorname(vendor_name)
			.click_appt_backtolist_link()
			.wait_until(2);
		}
			
	/**
	* Click User Name Link in search and verify name in Rep details page 
	*/
	@Test(priority=50, groups = {"functional"})	                                       
	public void verifyUserNameLink(){
				
		get(NBDAppointmentsPage.class)
			.enter_user_name(enter_username)
			.click_filter_button()
			.wait_until(2)
			.click_user_link("Bev'erly Ad'min")
			.wait_until(7)
			.verify_apptdetails_username(repdetails_username)
			.click_appt_backtolist_link()
			.wait_until(2);
		 	
}	
	
	/**
	* Log Into NBD and click First_Name_Check_in_Reps_Tab  
	* verify labels 'sanction list', 'individual' and 'doc alerts' label and then go back to reps tab
	*/
	@Test(priority=51, groups = {"functional"})	                                       
	public void VerifyInfoTabSection(){
			
		get(NBDRepsPage.class)
			.click_reps_tab()
			.wait_until(10)
			.enter_firstname("Bev'erly")
			.click_reps_tab_first_name_filter_transaction()
			.wait_until(2);
		
		get(NBDRepDetailsPage.class)
			.click_reps_tab_first_name_click()
			.verify_check_sanctionlist_label("Sanction Lists")
			.verify_check_individual_label("Individual")
			.verify_check_docalerts_label("Doc Alerts")
			.verify_check_reqddocs_label("Required Docs")
			.verify_check_reqddocs_status("PASS")
			.verify_check_effectivedate_label("Effective date")
			.verify_check_effectivedate_status("PASS")
			.verify_check_expirationdate_label("Expiration date")
			.verify_check_expirationdate_status("PASS");			
}	
	
	/**
	* Verify Employee label, Employee Name in RepDetails Page
	* Verify E-mail ID & Phone No in RepDetails Page 
	*/
	@Test(priority=52, groups = {"functional"})	                                      
	public void VerifyRepDetailsHeaderSection(){
		
		get(NBDRepsPage.class)
			.click_back_to_list_link()
			.wait_until(3);
		
		get(NBDRepDetailsPage.class)
			.click_reps_tab_last_name_click()
			.verify_check_employer_label("Employer")
			.verify_check_employer_name("Auto'mation BVendor")
			.verify_check_email_address_label("Email Address")
			.verify_check_email_ID("bev'erly.rep@bvendor.vm")
			.verify_check_phonenumber_label("Phone Number")
			.verify_check_phonenumber("765");
}
	
	/**
	* Verify Code label and Number in RepDetails - Products tab
	* Verify Description label and details in RepDetails - Products tab 
	*/	
	@Test(priority=53, groups = {"functional"})	                                      	
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
	@Test(priority=54, groups = {"functional"})	                                      	
	public void VerifyVendorName(){
		
		get(NBDRepsPage.class)
			.click_back_to_list_link();
		
		get(NBDRepDetailsPage.class)
			.click_reps_tab_company_name_click()
			.wait_until(2)
			.verify_check_vendorname("Auto'mation BVendor")
			.switch_to_root_page()
			.click_vendordetails_backtolist_link()
			.wait_until(2);
		 
	}
	
	
	@Test(priority=55, groups = {"functional"})	                                      //Log_Into_NBD & First_Name_Check_in_Reps_Tab 
	public void VerifyFirstNameCheck(){
		
		get(NBDRepsPage.class)
		.click_reps_tab()
		.wait_until(10)
		.enter_firstname("Bev'erly")
		.click_reps_tab_first_name_filter_transaction()
		.wait_until(2)
		.verify_reps_tab_first_name_in_result("Bev'erly")
		.click_reps_tab_first_name_clear_filter()
		.wait_until(2);
}
	
	@Test(priority=56, groups = {"functional"})	                                      //Last_Name_Check_in_Reps_Tab 
	public void VerifyLastNameCheck(){
		get(NBDRepsPage.class)
		.enter_lastname("Ad'min")
		.click_reps_tab_last_name_filter_transaction()
		.wait_until(2)
		.verify_reps_tab_last_name_in_result("Ad'min")
		.click_reps_tab_last_name_clear_filter()
		.wait_until(3);
}		
	
	@Test(priority=57, groups = {"functional"})	                                      //Company_Name_Check_in_Reps_Tab 
	public void VerifyCompanyNameCheck(){
		get(NBDRepsPage.class)
		.enter_companyname("Auto'mation BVendor")
		.click_reps_tab_company_name_filter_transaction()
		.wait_until(3)
		.verify_reps_tab_company_name_in_result("Auto'mation BVendor")
		.wait_until(2);
}		
	
	@Test(priority=58, groups = {"functional"})	                                      //IFrame_Check_Rep_Details_Accordion 
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
		get(CommonUtilities.class)
	    .do_log_out_from_NBD();
}
	

	@Test(priority=59, groups = {"functional"})                                         //valid_Username
	public void VerifyMyProfileSection(){
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("auto_buyer1@beverly.vdm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button()
			.wait_until(7);
		get(NBDRootPage.class)
		.click_username_dropdown()
		.click_my_profile()
		.wait_until(5)
		.verify_user_id_in_my_profile("auto_buyer1@beverly.vdm");
		get(CommonUtilities.class)
		.do_log_out_from_NBD();
}	
}
	
		
	


