package com.ghx.auto.cm.regression.ui.sso.production.smoke;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.KioskPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInAVendorPage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.sso.page.NVDBadgePrintPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditCustomerPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Badge_Print_Test extends AbstractAutoUITest{
	
	
	// Pre-condition is Required Password check box should be Checked at Customer level //
	
	String todays_date = "1"; //Change the date before execution
	
	//---------------------------------------------------------------------------
	String rep_id = "mayurghx1@gmail.com";
	String rep_password = "Gltd!124";
	String buyer_id = "anamikadutta1001@gmail.com";
	String buyer_password = "Gltd!124";
	String login_RMId = "kshruti";
	String RM_password = "GHXPass1213";
	String location = "Boston";
	String POE = "Gate 2";
	String visiting_contact = "Sharon";
	
	//appointment subjects-------------------------------------------------------
	String NBD_subject = "NBD-Prod No Appointment";
    String kiosk_subject = "Kiosk-Prod No Appointment";
    String NVD_subject = "NVD-Prod No Appointment";
    
    //appointment departments----------------------------------------------------
	String NBD_department = "Accounting";
	String NVD_department = "Endoscopy";
	String kiosk_department = "Human Resource";
	
	String kioskProdUrl = "https://kiosk.vendormate.com";
	static String Id = null;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
	Date todaysDate1=new Date();
	Calendar c = Calendar.getInstance();
	String current_month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
	String systemDate = dateFormat.format(todaysDate1);
	String[] parts = systemDate.split("/"); // Month
	String current_date = parts[1]; // date
	String current_year = parts[2]; // Year
	
	

	 @Test(priority = 1, groups = { "functional" })
	 public void BadgePrintFromNBD() {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("prodUrl")
	          .enter_username(buyer_id)
	          .enter_password(buyer_password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(20);

	  get(NBDHomePage.class)
	          //.click_continue_button()
	          .click_sign_in_a_vendor();
	  	  
	  get(NBDSignInAVendorPage.class)
	          .wait_until(20)
	          .enter_corporate_email(rep_id)
	          .click_find_vendor_info_button()
	          .wait_until(6)
	          .enter_visiting_contact(visiting_contact)
	          .enter_purpose(NBD_subject)
	          .select_location(location)
	          .select_poe(POE)
	          .select_department(NBD_department)
	          .click_badge_print_button()
	          .wait_until(30);
	  get(SSOCommonUtilities.class)
	          .saveFile()
	          .wait_until(5)
	          .select_option_from_userName_dropdown("Logout")
	          .clear_current_session();
	  
	 }
	 
	 		
	 @Test(priority = 2, groups = { "functional" })
	 public void BadgePrintFromNVD() {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("prodUrl")
	          .enter_username(rep_id)
	          .enter_password(rep_password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(10);
	  get(NVDHomePage.class)
	          .click_action_drop_down()
	          .click_print_badge_link()
	          .wait_until(2);
	  get(NVDBadgePrintPage.class)
	          .select_option_from_account_dropdown("Vendormate Partners")
	          .select_location(location)
	          .select_department(NVD_department)
	          .wait_until(3)
	          .select_date_of_visit(current_date)
	          .enter_visiting_contact(visiting_contact)
	          .enter_contact_title("Ok")
	          .enter_visit_details(NVD_subject)
	          .wait_until(10)
	          .click_print_badge_button()
	          .wait_until(15);
	          //.verify_warning_message("Location 2 - print with warn");
	  
	  get(SSOCommonUtilities.class)
	          //.saveFile()
	          .select_option_from_userName_dropdown("Logout")
	          .clear_current_session();
	 }

	 @Test(priority = 3, groups = { "functional" })
	 public void BadgePrintFromKioskWithRequiredPassword() {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("prodUrl")
	          .enter_username(buyer_id)
	          .enter_password(buyer_password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(20);
	  get(NBDHomePage.class)
	          .wait_until(3)
	          .click_configure_unconfigure_signin_machine();
	  get(KioskPage.class)
	          .click_here();
	  get(KioskPage.class, focus_on_popup_window())
              .wait_until(4)
	          //.select_location(location)
              .click_location_dropdown()
              .wait_until(2)
              .wait_for_text_appear(location)
              .wait_until(2)
              .click_location(location)
	         // .select_poe(POE)
              .click_poe_dropdown()
              .wait_until(2)
              .wait_for_text_appear(POE)
              .wait_until(2)
              .click_location(POE)
	          .click_vendormate_credentialing_kiosk_link()
	          .click_sign_in_button()
	          .enter_email_id(rep_id)
	          .enter_password(rep_password)
	          //.click_find_your_information_for_password_protected_kiosk()
	          .click_find_your_information()
	          .wait_until(5)
              .enter_visiting_contact(visiting_contact)
              .enter_purpose(kiosk_subject)
              //.select_department_dropdown(kiosk_department)
              .click_department_dropdown()
              .wait_until(2)
              .wait_for_text_appear(kiosk_department)
              .wait_until(2)
              .click_department(kiosk_department)
             .click_print_badge_button()
              .wait_until(10);
	  get(SSOCommonUtilities.class)
	          .saveFile();
	  get(KioskPage.class)
	         // .verify_warn_message("Location 2 - print with warn");
	     .wait_until(5);
	          close_popup_window();
	  get(SSOCommonUtilities.class, focus_on_parent_window())
	          .wait_until(4)
	          .refresh_page(); 
	  get(SSOCommonUtilities.class)
	  		  .select_option_from_userName_dropdown("Logout");
	  	
 	 }
		          
	 @Test(priority = 4, groups = { "functional" })
	 public void BadgePrintFromKioskWithoutPassword() {

		 get(SSOLoginPage.class)
		    .invoke_loginURL("prodUrl")
		    .enter_username(login_RMId)
		    .enter_password(RM_password)
		    .click_login_button()
		    .wait_until(3);
		get(SSOCommonUtilities.class)
		    .select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
	        .wait_until(10)
		    .click_crm_support_tab()
		    .click_crm_dashboard();
		get(RMDashLandingPage.class)
		    .click_edit_customer_link();
		get(RMDashEditCustomerPage.class)
		    .enter_customer_name_in_the_searchbox("Vendormate Partners")
		    .click_search_button()
		    .click_edit_button()
		    .wait_until(5)
		    .uncheck_password_required()
		    .wait_until(10)
		    .click_complete_button();
		get(RMDashLandingPage.class)
		    .click_logout()
		    .wait_until(6);
	
	  get(SSOLoginPage.class)
	          .invoke_loginURL("prodUrl")
	          .enter_username(buyer_id)
	          .enter_password(buyer_password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(20);
	  get(NBDHomePage.class)
	          .wait_until(3)
	          .click_configure_unconfigure_signin_machine();
	  get(KioskPage.class)
	          .click_here();
	  get(KioskPage.class, focus_on_popup_window())
              .wait_until(8)
              .click_unconfigure_button()  
              .wait_until(5);
              close_popup_window();
	  get(KioskPage.class, focus_on_parent_window())
              .click_here();
	  get(KioskPage.class, focus_on_popup_window())
	          //.select_location(location)
	          .click_location_dropdown()
              .wait_until(2)
              .wait_for_text_appear(location)
              .wait_until(2)
              .click_location(location)
	          //.select_poe(POE)
              .click_poe_dropdown()
              .wait_until(2)
              .wait_for_text_appear(POE)
              .wait_until(2)
              .click_location(POE)
	          .click_vendormate_credentialing_kiosk_link()
	          .click_sign_in_button()
	          .enter_email_id(rep_id)
	          .click_find_your_information()
	          .wait_until(5)
              .enter_visiting_contact(visiting_contact)
              .enter_purpose(kiosk_subject)
              //.select_department_dropdown(kiosk_department)
              .click_department_dropdown()
              .wait_until(2)
              .wait_for_text_appear(kiosk_department)
              .wait_until(2)
              .click_department(kiosk_department)
              .click_print_badge_button()
              .wait_until(10);
	  get(SSOCommonUtilities.class)
	          .saveFile();
	  get(KioskPage.class)
	  		  .wait_until(4);
	         // .verify_warn_message("Location 2 - print with warn");
	          close_popup_window();
	  get(SSOCommonUtilities.class, focus_on_parent_window())
	          .wait_until(4)
      		  .refresh_page();        
	 
	 }
	
	 
	 @Test(priority = 5, groups = { "functional" })
	 public void VerifyNBDBadgePrintInSignInHistory() {
	  get(NBDHomePage.class)
	          .click_signin_history()
	          .wait_until(10);
	  get(NBDSignInHistoryPage.class)
	  		  .enter_signin_from_date(current_month, current_date, current_year)
	  		  .wait_until(3)
	  		  .enter_signin_to_date(current_month, current_date, current_year)
	  		  .wait_until(2) 
		      .enter_department_name(NBD_department)
              .enter_rep_information(rep_id)
              .wait_until(3);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(5);
	  get(NBDSignInHistoryPage.class)
	          .verify_department_1st_record(NBD_department)
	          .verify_purpose_of_visit_1st_record(NBD_subject);
	 }
	   
	 @Test(priority = 6, groups = { "functional" })
	 public void VerifyNVDBadgePrintInSignInHistory() {
		 get(NBDSignInHistoryPage.class)
	          .wait_until(3)
		      .enter_department_name(NVD_department)
		      .wait_until(3);
      get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(5);
	  get(NBDSignInHistoryPage.class)
		      .verify_department_1st_record(NVD_department)
		      .verify_purpose_of_visit_1st_record(NVD_subject)
		      .verify_contact_1st_record(visiting_contact);
	 }
	  
	 @Test(priority = 7, groups = { "functional" })
	 public void VerifyKioskBadgePrintInSignInHistory() {
	  get(NBDSignInHistoryPage.class)
		      .wait_until(3)
		      .enter_department_name(kiosk_department)
		      .wait_until(3);
	  get(SSOCommonUtilities.class)
              .pressEnter()
	          .wait_until(5);
      get(NBDSignInHistoryPage.class)
		      .verify_department_1st_record(kiosk_department)
		      .verify_purpose_of_visit_1st_record(kiosk_subject)
		      .wait_until(3);
	 }
	
	  
	 @Test(priority = 8, groups = { "functional" })
	   public void NBDSignOut(){	 
		get(NBDSignInHistoryPage.class)
				.enter_department_name(NBD_department)
	          	.wait_until(5); 
	    get(SSOCommonUtilities.class)
		          .pressEnter()
		          .wait_until(4);
	    
		Id = get(NBDSignInHistoryPage.class).get_badge_id(Id);
			System.out.println(Id);
			
		get(NBDHomePage.class)
				.click_sign_in_a_vendor();	
		get(NBDSignInAVendorPage.class)
				.enter_badge_id(Id)
				.click_sign_out()
				.verify_sign_out_message()
				.wait_until(2);
		 }  

	 // Sign Out of Badge Printed from Kiosk//
	 
	 @Test(priority = 9, groups = { "functional" })
	   public void kioskSignOut(){ 
		get(NBDHomePage.class)
				.click_sign_in_history_tab()
				.wait_until(3);
		get(NBDSignInHistoryPage.class)
		 		.enter_signin_from_date(current_month, current_date, current_year)
		 		.wait_until(3)
		 		.enter_signin_to_date(current_month, current_date, current_year)
		 		.wait_until(2)
		 		.enter_department_name(kiosk_department)
	          	.enter_rep_information(rep_id)
	          	.wait_until(5);  
	    get(SSOCommonUtilities.class)
		          .pressEnter()
		          .wait_until(4);	
	    
	    Id = get(NBDSignInHistoryPage.class).get_badge_id(Id);
	    System.out.println(Id);
	    
		get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");
		get(KioskPage.class)
		    	.invoke_kioskURL("kioskProdUrl")
		    	.wait_until(4)
				.click_sign_out_button_badging_page()
				.enter_badge_id(Id)
				.click_Sign_Out_button_signout_page()
				.verify_sign_out_message()
				.wait_until(2);
			//	.click_cancel_button();
		 }
	 
	 //Verify Sign Out from NBD//
	 
	 @Test(priority = 10, groups = { "functional" })
	 public void verifyNBDSignOutDateTime(){

	 	get(SSOLoginPage.class)
	 		.invoke_loginURL("prodUrl") 
	 		.enter_username(buyer_id)
	 		.enter_password(buyer_password)
	 		.click_login_button();
	 	get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(17);
	 	get(NBDHomePage.class) 
	 		.click_sign_in_history_tab()
	 		.wait_until(5);
	 	get(NBDSignInHistoryPage.class)
	 		.enter_signin_from_date(current_month, current_date, current_year)
	 		.wait_until(3)
	 		.enter_signin_to_date(current_month, current_date, current_year)
 			.wait_until(2)
	 		.enter_department_name(NBD_department)
        	.enter_rep_information(rep_id)
        	.wait_until(5);
	 	get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	 	get(NBDSignInHistoryPage.class)
	 		.verify_sign_out_date_time()
	 		.wait_until(4);

	 }

	//Verify Sign Out from kiosk//
	 
	 @Test(priority = 11, groups = { "functional" })
	 public void verifyKioskSignOutDateTime(){
		get(NBDSignInHistoryPage.class)
			.enter_department_name(kiosk_department)
			.enter_rep_information(rep_id)
			.wait_until(5);
	 	get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
		 get(NBDSignInHistoryPage.class)					
		 	.verify_sign_out_date_time();
		 get(SSOCommonUtilities.class)
		 	.wait_until(2)  
		 	.select_option_from_userName_dropdown("Logout")
		 	.clear_current_session();
		 
	 }
	
	 @Test(priority = 12, groups = { "functional" })
	 public void CheckPasswordRequiredCheckbox() {
		 get(SSOLoginPage.class)
		    .invoke_loginURL("prodUrl")
		    .enter_username(login_RMId)
		    .enter_password(RM_password)
		    .click_login_button();
		get(SSOCommonUtilities.class)
		    .select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
	        .wait_until(10)
		    .click_crm_support_tab()
		    .click_crm_dashboard();
		get(RMDashLandingPage.class)
		    .click_edit_customer_link();
		get(RMDashEditCustomerPage.class)
		    .enter_customer_name_in_the_searchbox("Vendormate Partners")
		    .click_search_button()
		    .click_edit_button()
		    .wait_until(5)
		    .check_password_required()
		    .wait_until(10)
		    .click_complete_button();
		get(RMDashLandingPage.class)
	        .click_logout();
		get(SSOCommonUtilities.class) 
			.clear_current_session();
}

}