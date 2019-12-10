package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDNewKioskPage;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.cm.ui.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.page.NBDSignInVendorPage;
import com.ghx.auto.cm.ui.page.NBDWebinarPage;
import com.ghx.auto.cm.ui.page.NBDHomePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_SignIn_Tests extends AbstractAutoUITest  {
	
	String pass_repstatus_id = "rep.hab@auto.vm";
	String fail_repstatus_id = "rep1.hab@auto.vm";
	String alert_repstatus_id = "rep2.hab@auto.vm";
	String appt_rep_id = "appt.hab@autoappt.vm";
	String first_name = "automation";
	String last_name = "rep";
	String phone_number = "56789";
	String company_name = "Habersham AVendor";
	String visiting_contact = "Rep";
	String contact_title = "Contact";
	String purpose = "To Check Rep Status";
	String location = "Location";
	String poe = "POE";
	String department = "Accounting";
	String pass_msg = "Compliant Rep with PASS Status Alert";
	String fail_msg = "Non-Compliant Rep with FAIL Status Alert";
	String alert_msg = "Non-Compliant Rep with ALERT Status Alert";
	String appt_msg = "You have an appointment. Please proceed to your destination department";
	
	/**
	* Log Into NBD and click on Sign-In Vendor Tab  
	* Print manual badge for pass status rep
	* and verify drools message
	*/
	@Test(priority=1, groups = {"functional"})	                                       
	public void verifyPassRepBadgePrint(){
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("buyer.hab@automation.vdm")
			.enter_password("gltd@123")
			.click_login_button()
			.click_continue_button()
			.wait_until(10);

		get(NBDSignInVendorPage.class)
			.click_signinvendor_tab()
			.wait_until(3)
			.enter_mail_id(pass_repstatus_id)
			.enter_rep_first_name(first_name)
			.enter_rep_last_name (last_name)
			.enter_phone_number (phone_number)
			.enter_rep_company_name(company_name)
			.enter_visiting_contact(visiting_contact)
			.enter_contact_title(contact_title)
			.enter_purpose_of_visit(purpose)
			.select_location(location)
			.wait_until(4)
			.select_poe(poe)
			.select_department(department)
			.click_print_badge()
			.wait_until(7)		
			.verify_compliant_msg(pass_msg)
			.click_return_to_signin_page()
			.wait_until(4);
	}		
	
	/***  
	* Print badge for fail status rep using Find your Vendor Information
	* and verify drools message
	*/

	@Test(priority=2, groups = {"functional"})	                                       
	public void verifyFailRepBadgePrint(){
		
		get(NBDSignInVendorPage.class)
			.click_signinvendor_tab()
			.wait_until(7)
			.enter_mail_id(fail_repstatus_id)
			.click_find_vendor_information()
			.wait_until(7)
			.enter_visiting_contact(visiting_contact)
			.enter_contact_title(contact_title)
			.enter_purpose_of_visit(purpose)
			.select_department(department)
			.click_print_badge()
			.wait_until(7)
			.verify_noncompliant_msg(fail_msg);
		
		get(NBDHomePage.class)
			.click_home_tab()
			.wait_until(4);
			
	}		
	
	/***  
	* Print badge for alert status rep using Find your Vendor Information
	* and verify drools message
	*/

	@Test(priority=3, groups = {"functional"})	                                       
	public void verifyAlertRepBadgePrint(){
		
		get(NBDSignInVendorPage.class)
			.click_signinvendor_tab()
			.wait_until(7)
			.enter_mail_id(alert_repstatus_id)
			.click_find_vendor_information()
			.wait_until(7)
			.enter_visiting_contact(visiting_contact)
			.enter_contact_title(contact_title)
			.enter_purpose_of_visit(purpose)
			.select_department(department)
			.click_print_badge()
			.wait_until(7)
			.verify_compliant_msg(alert_msg)
			.click_return_to_signin_page()
			.wait_until(4);
	}		

	/***  
	* Print badge for rep with appointment using Find your Vendor Information
	* and verify drools message
	*/

	@Test(priority=4, groups = {"functional"})	                                       
	public void verifyApptRepBadgePrint(){
		
		get(NBDSignInVendorPage.class)
			.enter_mail_id(appt_rep_id)
			.click_find_vendor_information()
			.wait_until(7)
			.click_print_badge()
			.wait_until(7)	
			.verify_compliant_msg(appt_msg)
			.click_return_to_signin_page()
			.wait_until(4);
	}		

	/***  
	* Verify badges printed for Appt Rep and Alert Status Rep in 
	* Sign-In History Tab
	*/

	@Test(priority=5, groups = {"functional"})	                                       
	public void verifyBadgesInSigninHistory(){
		
		get(NBDSignInHistoryPage.class)
			.click_signinhistory_tab()
			.wait_until(3)
			.select_current_date_for_from_date();
			
		
		get(NBDSignInVendorPage.class)
			.enter_rep_id(pass_repstatus_id)
			.click_signin_filter_button()
			.wait_until(3)
			.verify_rep_id(pass_repstatus_id)
			.click_signin_clear_link()
			.wait_until(3);
		
		get(NBDSignInHistoryPage.class)	
			.select_current_date_for_from_date();
		
		get(NBDSignInVendorPage.class)
			.enter_rep_id(fail_repstatus_id)
			.click_signin_filter_button()
			.wait_until(3)
			.verify_rep_id(fail_repstatus_id)
			.click_signin_clear_link()
			.wait_until(3);
		
		get(NBDSignInHistoryPage.class)
			.select_current_date_for_from_date();
		
		get(NBDSignInVendorPage.class)
			.enter_rep_id(alert_repstatus_id)
			.click_signin_filter_button()
			.wait_until(3)
			.verify_rep_id(alert_repstatus_id)
			.click_signin_clear_link()
			.wait_until(3);
		
		get(NBDSignInHistoryPage.class)	
			.select_current_date_for_from_date();
			
		get(NBDSignInVendorPage.class)	
			.enter_rep_id(appt_rep_id)
			.click_signin_filter_button()
			.wait_until(3)
			.verify_rep_id(appt_rep_id)
			.click_signin_clear_link()
			.wait_until(3);
			
		get(CommonUtilities.class)
    		.do_log_out_from_NBD();
	}
	
	/***
	 * New Kiosk Sign In Test cases
	 */
	@Test(priority=6, groups = {"functional"})	                                       
	public void verifyPassRepNewKioskSignIn(){
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                              // Log in to NBD      
			.enter_username("auto_buyer5@beverly.vdm")
			.enter_password("test1234!")
			.click_login_button()
			.click_continue_button()
			.wait_until(5);		
		
		get(NBDRootPage.class)	                                                     // print badge for Pass Rep using new kiosk
		 	                                              
			.click_action_menu();
		
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link();
			
			  
	  get(NBDNewKioskPage.class, focus_on_popup_window())
	    	.wait_until(10)
			.select_location_from_dropdown("Location 1")
			.select_poe_from_dropdown("POE1")
			.click_goto_signup_page_button()
			.click_signin_button()
			.enter_emailid_in_email_field("indu@vendorone.vm")
			.click_find_your_information_button()
			.verify_first_name("indu")
			.verify_last_name("Test")
			.verify_phone_number("543543545")
			.verify_visiting_contact_name("Gary OldMan")
			.verify_company_name("777 Hospital")
			.verify_purpose_of_visit("Long Appointment One")
			.select_department_from_dropdown("Administration")
			.click_print_badge_button()
	        .wait_until(10);
	       focus_on_popup_window().close();
	  
	       
		get(NBDSignInHistoryPage.class, focus_on_parent_window())                                              // verify badge sign in entry on sign in history page
			.click_signinhistory_tab();
		
		get(NBDSignInHistoryPage.class)
			.select_current_date_for_from_date();
		
		get(NBDSignInHistoryPage.class) 
		  	.click_filter_button()
		 	.enter_dept_in_filter_field("Administration")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("Administration")
		 	.verify_repname_text_in_user_information_column("indu Test")
		 	.verify_signin_loc_text_in_signin_loc_column("Location 1")
		 	.verify_signin_poe_in_poe_column("POE1")
		 	.verify_contactname_in_contact_column("Gary OldMan")
		 	.verify_purposeofvisit_in_purposeofvisit_column("Long Appointment One")
		 	.click_clear_link();
		 	
		get(NBDRootPage.class)	                                                  // print badge for Pass Rep using new kiosk
			.click_action_menu();
	
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link()
			.wait_until(5);
		get(NBDNewKioskPage.class, focus_on_popup_window())
			.click_unconfigure_button();
		
		focus_on_popup_window().close();
		
}

	@Test(priority=7, groups = {"functional"})	                                       
	public void verifyManualNewKioskSignIn(){
		
					                                                  
		get(NBDRootPage.class, focus_on_parent_window())	                                                     // print badge for Pass Rep using new kiosk
		 	                                             
			.click_action_menu();
		
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link();
			
			  
	  get(NBDNewKioskPage.class, focus_on_popup_window())
	    	.wait_until(10)
			.select_location_from_dropdown("Location 1")
			.select_poe_from_dropdown("POE1")
			.click_goto_signup_page_button()
			.click_signin_button()
			.enter_emailid_in_email_field("indu@vendorone.vm")
			.click_find_your_information_button()
			.enter_first_name("Niti")
			.enter_last_name("Singh")
			.enter_phone_number("54355435")
			.enter_company_name("Test Hospital")
			.enter_visiting_contact_name("Jing Yan")
			.enter_purpose_of_visit("Promote medical products")
			.enter_contact_title("Miss")
			.select_department_from_dropdown("Administration")
			.click_print_badge_button()
	        .wait_until(10);
	       focus_on_popup_window().close();
	  
	       
	    get(NBDSignInHistoryPage.class, focus_on_parent_window())                                              // verify badge sign in entry on sign in history page
			.click_signinhistory_tab();
	    
		
		get(NBDSignInHistoryPage.class) 
		  	.click_filter_button()
		 	.enter_purpose_of_visit_in_filter_field("Promote medical products")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("Administration")
		 	.verify_repname_text_in_user_information_column("Niti")
		 	.verify_signin_loc_text_in_signin_loc_column("Location 1")
		 	.verify_signin_poe_in_poe_column("POE1")
		 	.verify_contactname_in_contact_column("Jing Yan")
		 	.verify_purposeofvisit_in_purposeofvisit_column("Promote medical products")
		 	.click_clear_link();
		 	
		get(NBDRootPage.class)	                                                  // print badge for Pass Rep using new kiosk
			.click_action_menu();
	
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link()
			.wait_until(5);
		get(NBDNewKioskPage.class, focus_on_popup_window())
			.click_unconfigure_button();
		
		focus_on_popup_window().close();
		
		get(CommonUtilities.class, focus_on_parent_window())
			.do_log_out_from_NBD();
}
}