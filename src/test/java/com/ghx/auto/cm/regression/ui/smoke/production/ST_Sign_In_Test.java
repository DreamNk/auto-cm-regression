package com.ghx.auto.cm.regression.ui.smoke.production;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDNewKioskPage;
import com.ghx.auto.cm.ui.page.NBDOldKioskPage;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.cm.ui.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.page.NBDSignInVendorPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.cm.ui.page.RMNavigationPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class ST_Sign_In_Test extends AbstractAutoUITest {
	
	String corporate_id = "sachin.pathak@bizsense.in";
	String first_name = "sachin";
	String last_name = "pathak";
	String phone_no = "8956236589";
	String company = "BizSense Test 2";
	String visiting_contact = "Manual badge Print";
	String contact_title = "Manual";
	String purpose_of_visit = "Manual badge Print";
	String department = "NICU";
	
	// RM Dash Navigation Data //
	String customer_name = "testcustomer";
	String username = "automation.rm@vendormate.com";
	String password = "gltd@123";
	
	// Sign-in Data for rep with appointment //
	String appt_rep_id = "sachin.pathak@bizsense.in";
	String appt_msg = "APPOINTMENT FOUND -  Our system shows that you have an appointment.";
	
	@Test(priority=1, groups = {"functional"})	                                       
	public void verifyApptRepBadgePrint(){
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
    	    .enter_username("sachin.pathak@vendormate.com")
    	    .enter_password("gltd@123")
    	    .click_login_button()
    	    .wait_until(7);
		
		get(NBDSignInVendorPage.class)
			.click_signinvendor_tab()
			.wait_until(3)
			.enter_mail_id(appt_rep_id)
			.click_find_vendor_information()
			.wait_until(7)
			.select_department("Pharmacy")
			.click_print_badge()
			.wait_until(7)	
			.verify_compliant_msg(appt_msg)
			.click_return_to_signin_page()
			.wait_until(4)
			
			
		    .click_signinhistory_tab();
		   
           
        get(NBDSignInHistoryPage.class)  
           .select_current_date_for_from_date()
           .enter_dept_in_filter_field("Pharmacy")
           .click_filter_button()
           .wait_until(7)
           .verify_repname_text_in_user_information_column("sachin pathak")
           .verify_deptname_in_dept_column("Pharmacy");
                           
		get(CommonUtilities.class)
			.do_log_out_from_NBD();
	}
	
	
	@Test(priority=2, groups = {"functional"})
	public void VerifyFindYourInformationIsFetchingDataCorrectly() {
		
		get(NBDLogin.class)
	       .invoke_loginurl("baseUrl")
    	   .enter_username("sachin.pathak@vendormate.com")
    	   .enter_password("gltd@123")
    	   .click_login_button()
    	   .wait_until(7);
		
	    get(NBDRootPage.class)
    	   .click_action_menu()
    	   .click_configure_signin_machine()
    	   .select_location_for_old_kiosk("Tenth Floor")
    	   .select_entry_point_for_old_kiosk("Tenth POE")
    	   .wait_until(3)
    	   .click_vendormate_sign_in_link()
    	   .wait_until(15);
	    
	    get(NBDOldKioskPage.class)
	       .click_click_here_button()
	       .enter_corporate_email(corporate_id)
	       .click_find_your_information()
	       .wait_until(15)
	       .verify_first_name(first_name)
	       .verify_last_name(last_name)
	       .verify_phone_no(phone_no)
	       .verify_company(company)
	       .verify_visiting_contact_field("sac'hin path'ak")
	       .verify_contact_title_field("BUYR")
	       .verify_purpose_of_visit("AD - Long Appointment (23 May 2015)")
	       .click_print_badge_button();
	    
	    get(NBDLogin.class)
           .invoke_loginurl("baseUrl")
	       .enter_username("sachin.pathak@vendormate.com")
	       .enter_password("gltd@123")
	       .click_login_button();
	    
	    get(NBDSignInHistoryPage.class)
           .click_signinhistory_tab()
           .select_current_date_for_from_date()
           .select_eventtype_from_dropdown("Printed on site")
           .enter_dept_in_filter_field("Accounting")
           .enter_purpose_of_visit_in_filter_field("AD - Long Appointment (23 May 2015)")
           .click_filter_button()
           .wait_until(7)
           .verify_repname_text_in_user_information_column("sachin pathak")
           .verify_deptname_in_dept_column("Accounting")
           .verify_contactname_in_contact_column("sac'hin path'ak")
           .verify_purposeofvisit_in_purposeofvisit_column("AD - Long Appointment (23 May 2015)");
	    
	    get(NBDRootPage.class)
	       .click_action_menu()
	       .click_unconfigure_signin_machine()
	       .click_unconfigure_button()
	       .wait_until(8);
	    
		
	}
	
	@Test(priority=3, groups = {"functional"})
	public void configure_old_kiosk() { 
		
		get(NBDLogin.class)
	       .invoke_loginurl("baseUrl")
 	       .enter_username("sachin.pathak@vendormate.com")
 	       .enter_password("gltd@123")
 	       .click_login_button()
 	       .wait_until(7);
		
		
		get(NBDRootPage.class)
 	       .click_action_menu()
 	       .click_configure_signin_machine()
 	       .select_location_for_old_kiosk("Tenth Floor")
 	       .select_entry_point_for_old_kiosk("Tenth POE")
 	       .wait_until(3)
 	       .click_vendormate_sign_in_link()
 	       .wait_until(15);
		
		get(NBDOldKioskPage.class)
	        .click_click_here_button()
	        .enter_corporate_email(corporate_id)
	        .enter_first_name("Manual"+first_name)
	        .enter_last_name("Manual"+last_name)
	        .enter_phone_no(phone_no)
	        .enter_company(company)
	        .enter_visiting_contact_field(visiting_contact)
	        .enter_contact_title_field(contact_title)
	        .enter_purpose_of_visit(purpose_of_visit)
	        .select_department_to_be_visit(department)
	        .click_print_badge_button()
	        .wait_until(15);
	    get(NBDLogin.class)
	        .invoke_loginurl("baseUrl")
    	    .enter_username("sachin.pathak@vendormate.com")
    	    .enter_password("gltd@123")
    	    .click_login_button();
	    get(NBDSignInHistoryPage.class)
	        .wait_until(7)
	        .click_signinhistory_tab()
            .select_current_date_for_from_date()
	        .select_eventtype_from_dropdown("Printed on site")
	        .enter_dept_in_filter_field(department)
	        .enter_purpose_of_visit_in_filter_field(purpose_of_visit)
	        .click_filter_button()
	        .wait_until(5)
	        .verify_repname_text_in_user_information_column("sachin pathak")
	        .verify_deptname_in_dept_column(department)
	        .verify_contactname_in_contact_column("Manual badge Print")
	        .verify_purposeofvisit_in_purposeofvisit_column(purpose_of_visit);
	    
	    get(NBDRootPage.class)
	       .click_action_menu()
	       .click_unconfigure_signin_machine()
	       .click_unconfigure_button()
	       .wait_until(8);
	    
	}
	
	@Test(priority=4, groups = {"functional"})	                                       
	public void verifyPassRepNewKioskSignIn(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")                                                 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(7);

		get(RMNavigationPage.class)	                                                  // This TC will check kiosk beta flag at customer level
			.click_edit_customer_link()
			.enter_customer_name(customer_name)
			.click_search_button()
			.wait_until(2)
			.click_edit_button()
			.wait_until(4)
			.enable_kiosk_check_box()
			.click_complete_button()
			.wait_until(3)
			.click_logout_link()
			.wait_until(3);
	
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                              // Log in to NBD      
			.enter_username("sachin.pathak@vendormate.com")
			.enter_password("gltd@123")
			.click_login_button()
			.wait_until(5);		
		
		get(NBDRootPage.class)	                                                     // print badge for Pass Rep using new kiosk
		 	                                              
			.click_action_menu();
		
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link();
			
			  
	  get(NBDNewKioskPage.class, focus_on_popup_window())
	    	.wait_until(10)
			.select_location_from_dropdown("Tenth Floor")
			.select_poe_from_dropdown("Tenth POE")
			.click_goto_signup_page_button()
			.click_signin_button()
			.enter_emailid_in_email_field("sachin.pathak@bizsense.in")
			.click_find_your_information_button()
			.verify_first_name("sachin")
			.verify_last_name("pathak")
			.verify_phone_number("8956236589")
			.verify_visiting_contact_name("sac'hin path'ak")
			.verify_company_name("BizSense Test 2")
			.verify_purpose_of_visit("AD - Long Appointment (23 May 2015)")
			.select_department_from_dropdown("Administration")
			.click_print_badge_button()
	        .wait_until(10);
	       focus_on_popup_window().close();
	  
	       
		get(NBDSignInHistoryPage.class, focus_on_parent_window())                                              // verify badge sign in entry on sign in history page
			.click_signinhistory_tab()
			.select_current_date_for_from_date();
		
		get(NBDSignInHistoryPage.class) 
		  	.click_filter_button()
		 	.enter_dept_in_filter_field("Administration")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("Administration")
		 	.verify_repname_text_in_user_information_column("sachin pathak")
		 	.verify_signin_loc_text_in_signin_loc_column("Tenth Floor")
		 	.verify_signin_poe_in_poe_column("Tenth POE")
		 	.verify_contactname_in_contact_column("sac'hin path'ak")
		 	.verify_purposeofvisit_in_purposeofvisit_column("AD - Long Appointment (23 May 2015)")
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

	@Test(priority=5, groups = {"functional"})	                                       
	public void verifyManualNewKioskSignIn(){
		
					                                                  
		get(NBDRootPage.class, focus_on_parent_window())	                                                     // print badge for Pass Rep using new kiosk
		 	                                             
			.click_action_menu();
		
		get(NBDNewKioskPage.class)
			.click_configure_signin_machine()
			.wait_until(3)
			.click_clickhere_link();
			
			  
	  get(NBDNewKioskPage.class, focus_on_popup_window())
	    	.wait_until(10)
			.select_location_from_dropdown("Tenth Floor")
			.select_poe_from_dropdown("Tenth POE")
			.click_goto_signup_page_button()
			.click_signin_button()
			.enter_emailid_in_email_field("sachin.pathak@bizsense.in")
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
			.click_signinhistory_tab()
			.select_current_date_for_from_date();
		
		get(NBDSignInHistoryPage.class) 
		  	.click_filter_button()
		 	.enter_purpose_of_visit_in_filter_field("Promote medical products")
		 	.click_filter_button()
		 	.verify_deptname_in_dept_column("Administration")
		 	.verify_repname_text_in_user_information_column("Niti")
		 	.verify_signin_loc_text_in_signin_loc_column("Tenth Floor")
		 	.verify_signin_poe_in_poe_column("Tenth POE")
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
		
		get(NVDloginPage.class)                                                // This TC will uncheck kiosk beta flag at customer level
			.invokeLoginUrl("baseUrl")                                                 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(7);
		
		get(RMNavigationPage.class)	
			.click_edit_customer_link()
			.enter_customer_name(customer_name)
			.click_search_button()
			.wait_until(2)
			.click_edit_button()
			.wait_until(4)
			.disable_kiosk_check_box()
			.click_complete_button()
			.wait_until(3)
			.click_logout_link();
}
	
}
	


