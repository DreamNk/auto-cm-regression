package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.KioskPage;
import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInAVendorPage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInHistoryPage;

import com.ghx.auto.cm.ui.sso.page.NVDBadgePrintPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;
import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditCustomerPage;

public class Badge_Print_Test extends AbstractAutoUITest{
	
	/*Important Things before running Suite
	 * Change Time zone to EST
	 * * */
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
	Date todaysDate1=new Date();
	Calendar c = Calendar.getInstance();
	String current_month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
	String systemDate = dateFormat.format(todaysDate1);
	String[] parts = systemDate.split("/"); // Month
	String current_date = parts[1]; // date
	String current_year = parts[2]; // Year
	
	//Password Set Path------------
	
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	//----------------------------------------------------------------------------
	String location = "Hudson";
	String poe = "North POE";
	String visiting_contact = "Sharon";
	
	//appointment subjects------------------------------------------------------
	String NBDsubject = "Accounting";
    String kioskSubject = "Endoscopy";
    String NVDsubject = "Human Resource";
    
    //appointment departments----------------------------------------------------
	String NBDDepartment = "Endoscopy";
	String NVDDepartment = "Cath Lab";
	String kioskDepartment = "Oncology";

	// Buyer Details for Appointment
	String buyerUserNm ="john.buyer@vendormate.com";
	String buyPassowrd =null;
	String optionForDailyRecuringApt = "Every Day";
	String month = "July";
	String date = "14";
	String year = "2018";
	String appEndDateM = "July";
	String appEndDateD = "21";
	String appEndDateY = "2018";
	String occursEveryDay = "1";
	String dailySummaryMessage = "Daily, Starts on Jul 14, 2018, Until Jul 21, 2018";

	String buyLocation = "Hudson";
	String dept = "EP Lab";
	String apptSubject = "Appointment Subject added by Script";
	String editApptSubject = "Edit Appointment Subject";

	String apptDesc = "Appointment Description added by Script";
	String editApptDesc = "Edit Appointment Description";
	String invitedReps = "repone@aurora.vm";
	String userName = "repone@aurora.vm";
	String password = null;
	String appointment = "10/26/2017 02:30AM Appointment Subje";
	String contactTitle ="Appointment MR";
	
	String todaysDate="";
	String apptLocation = "Hudson";
	String apptPOE = "North POE";
	
	String kioskUrl = "https://kiosk.vendormate.net";
	static String Id = null;
	
	String login_RMId = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";
	
	String passwordKioskDepartment = "NICU";
    String passwordKioskSubject = "NICU";
    

	@Test(priority = 1, groups = { "functional" })
	 public void BadgePrintFromNBD() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(buyerUserNm);
	          buyPassowrd =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
	  get(SSOLoginPage.class)	
	          .enter_password(buyPassowrd)
	          .click_login_button()
	          .wait_until(5);
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(20);
	  get(NBDHomePage.class)
	          .click_sign_in_a_vendor();
	  get(NBDSignInAVendorPage.class)
	          .wait_until(5)
	          .enter_corporate_email(userName)
	          .click_find_vendor_info_button()
	          .wait_until(5)
	          .enter_visiting_contact(visiting_contact)
	          .enter_purpose(NBDsubject)
	          .select_location(location)
	          .select_poe(poe)
	          .select_department(NBDDepartment)
	          .click_badge_print_button()
	          .wait_until(6);
	  get(SSOCommonUtilities.class)
	  		  .saveFile()
	          .wait_until(3)
	          .select_option_from_userName_dropdown("Logout")
	          .clear_current_session();
	  
	 }
	 
	 @Test(priority = 2, groups = { "functional" })
	 public void BadgePrintFromNVD() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(userName);
		       password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, userName);	 
	  get(SSOLoginPage.class)
	          .enter_password(password)
	          .click_login_button()
	          .wait_until(15);
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(40);
	  get(NVDHomePage.class)
	          .click_action_drop_down()
	          .click_print_badge_link()
	          .wait_until(2);
	  get(NVDBadgePrintPage.class)
	          .select_option_from_account_dropdown("Wayne Healthcare")
	          .select_location(location)
	          .select_department(NVDDepartment)
	          .select_date_of_visit(current_date)
	          .enter_visiting_contact(visiting_contact)
	          .enter_contact_title("Ok")
	          .enter_visit_details(NVDsubject)
	          .click_print_badge_button()
	          .wait_until(5);
	          //.verify_warning_message("Location 2 - print with warn");
	  get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout")
	          .clear_current_session();
 	}
	
	 // Badge Print from Kiosk - Without appointment
	 
	 @Test(priority = 3, groups = { "functional" })
	 public void BadgePrintFromKiosk() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(buyerUserNm);
	          buyPassowrd =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
	 get(SSOLoginPage.class)
	          .enter_password(buyPassowrd)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
      		.select_option_from_solution_selector("Vendormate Credentialing")
      		.wait_until(20);
	  get(NBDHomePage.class)
	          .wait_until(2)
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
	          //.select_poe(POE)
            	.click_poe_dropdown()
            	.wait_until(2)
            	.wait_for_text_appear(poe)
            	.wait_until(2)
            	.click_poe(poe)
	          .wait_until(4)
	          .click_vendormate_credentialing_kiosk_link()
	          .click_sign_in_button()
	          .enter_email_id(userName)
	          .click_find_your_information()
              .enter_visiting_contact(visiting_contact)
              .enter_purpose(kioskSubject)
              //.select_department_dropdown(kioskDepartment)
              .click_department_dropdown()
            	.wait_until(2)
            	.wait_for_text_appear(kioskDepartment)
            	.wait_until(2)
            	.click_department(kioskDepartment)
              .click_print_badge_button();
	  			System.out.print("Date : " + current_date + current_month + current_year );
	  get(SSOCommonUtilities.class)
	          .saveFile();
	          close_popup_window(); 
	  get(SSOCommonUtilities.class, focus_on_parent_window())
	          .wait_until(2)
	          .refresh_page(); 
	 }
	
	 
	 @Test(priority = 4, groups = { "functional" })
	 public void VerifyNBDBadgePrintInSignInHistory() { 
	
		 get(NBDHomePage.class)
		 	  .wait_until(2)
	          .click_signin_history()
	          .wait_until(2);
 
	  get(NBDSignInHistoryPage.class)
	  		 // .enter_signin_from_date(current_month, current_date, current_year)
	  	      .wait_until(3)
	         // .enter_signin_to_date(current_month, current_date, current_year)
	          .wait_until(2)    
	          .enter_department_name(NBDDepartment)
	          .wait_until(2)
	          
	          .enter_rep_information(userName)
	          .wait_until(5);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(2);
	
	  get(NBDSignInHistoryPage.class)
	          .verify_department_1st_record(NBDDepartment)
	          .verify_purpose_of_visit_1st_record(NBDsubject);
	 }
	   
	 @Test(priority = 5, groups = { "functional" })
	 public void VerifyNVDBadgePrintInSignInHistory() {
	  get(NBDSignInHistoryPage.class)
	          .wait_until(3)
		      .enter_department_name(NVDDepartment)
		      .wait_until(5);
      get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(3);
	  get(NBDSignInHistoryPage.class)
		      .verify_department_1st_record(NVDDepartment)
		      .verify_purpose_of_visit_1st_record(NVDsubject)
		      .verify_contact_1st_record(visiting_contact);
	 }
	 
	 @Test(priority = 6, groups = { "functional" })
	 public void VerifyKioskBadgePrintInSignInHistory() {
	  get(NBDSignInHistoryPage.class)
	          .wait_until(3)
		      .enter_department_name(kioskDepartment)
		      .wait_until(5);
	  get(SSOCommonUtilities.class)
              .pressEnter()
              .wait_until(2);
      get(NBDSignInHistoryPage.class)
		      .verify_department_1st_record(kioskDepartment)
		      .verify_purpose_of_visit_1st_record(kioskSubject);
	 }
	
	 //Sign Out of Badge Printed from NBD//
	 @Test(priority = 7, groups = { "functional" })
	   public void NBDSignOut(){	 
		get(NBDSignInHistoryPage.class)
				.enter_department_name(NBDDepartment)
	          	.enter_rep_information(userName)
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
	 
	 @Test(priority = 8, groups = { "functional" })
	   public void kioskSignOut(){ 
		get(NBDHomePage.class)
				.click_sign_in_history_tab()
				.wait_until(3);
		get(NBDSignInHistoryPage.class)
				.enter_department_name(kioskDepartment)
	          	.enter_rep_information(userName)
	          	.wait_until(5);  
	    get(SSOCommonUtilities.class)
		          .pressEnter()
		          .wait_until(4);	
	    
	    Id = get(NBDSignInHistoryPage.class).get_badge_id(Id);
	    	System.out.println(Id);
	    
		get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout")
				.wait_until(4);
		get(KioskPage.class)
		    	.invoke_kioskURL("kioskUrl")
		    	.click_kiosk_link()
				.click_sign_out_button_badging_page()
				.enter_badge_id(Id)
				.click_Sign_Out_button_signout_page()
				.verify_sign_out_message()
				.wait_until(2);
				
		 }
	 
	 //Verify Sign Out from NBD//
	 
	 @Test(priority = 9, groups = { "functional" })
	 public void verifyNBDSignOutDateTime() throws IOException{

	 	get(SSOLoginPage.class)
	 		.invoke_loginURL("ssoUrl") 
	 		.enter_username(buyerUserNm);
	 		buyPassowrd =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
		get(SSOLoginPage.class)
	 		.enter_password(buyPassowrd)
	 		.click_login_button();
	 	get(SSOCommonUtilities.class)
  			.select_option_from_solution_selector("Vendormate Credentialing")
  			.wait_until(17);
	 	get(NBDHomePage.class)
	 		.click_sign_in_history_tab()
	 		.wait_until(5);
	 	get(NBDSignInHistoryPage.class)
	 		//.enter_signin_from_date(current_month, current_date, current_year)
	 		.wait_until(3)
	 	 	//.enter_signin_to_date(current_month, current_date, current_year)
	 	 	.wait_until(3)
	 	 	.enter_department_name(NBDDepartment)
          	.enter_rep_information(userName)
          	.wait_until(5);
	 	get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	 	get(NBDSignInHistoryPage.class)
	 		.verify_sign_out_date_time()
	 		.wait_until(4);

	 }

	//Verify Sign Out from kiosk//
	 
	 @Test(priority = 10, groups = { "functional" })
	 public void verifyKioskSignOutDateTime(){
		get(NBDSignInHistoryPage.class)
			.enter_department_name(kioskDepartment)
			.enter_rep_information(userName)
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


	 // Daily Recurring appointment
		@Test(priority = 11, groups = { "functional" })
		 public void CreateRecurringDailyAppointment() throws IOException {

			 get(SSOLoginPage.class)
		     	.invoke_loginURL("ssoUrl")
		     	.enter_username(buyerUserNm);
		     	buyPassowrd =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
			get(SSOLoginPage.class)
		     	.enter_password(buyPassowrd)
		     	.click_login_button()
		     	.wait_until(7);
			 get(SSOCommonUtilities.class)
	  			.select_option_from_solution_selector("Vendormate Credentialing")
	  			.wait_until(17);
			 get(NBDHomePage.class)
		          .click_appointment_tab();
			 get(NBDAppointmentsPage.class)
		          .click_add_appointment_button()
		          .click_recurring_appointment_radio_button()
		          .select_option_from_repeats_dropdown(optionForDailyRecuringApt)
		          .click_done_button()
			 	  .select_location(buyLocation)
		          .select_department(dept)
		          .enter_appointment_subject(apptSubject)
		          .enter_appointment_description(apptDesc)
		          .enter_invite_guest_email_in_searchbox(userName)
		          .wait_until(3);
		     get(SSOCommonUtilities.class)
		          .pressEnter()
		     	  .wait_until(5);	
			 get(NBDAppointmentsPage.class)
		          .check_invite_guest_checkbox()
		          .click_save_appointment()
		          .wait_until(7);
			 
		}  
		 // Badge Print with Recurring appointment from NBD
		@Test(priority = 12, groups = { "functional" })
		   public void BadgePrintFromBuyerdashWithDailyRecurringAppt(){ 
			
			get(NBDHomePage.class)
	          .click_sign_in_a_vendor();
	        get(NBDSignInAVendorPage.class)
	         	.wait_until(5)
	         	.enter_corporate_email(userName)
	         	.click_find_vendor_info_button()
	         	.wait_until(5)
	         	.click_badge_print_button()
	         	.wait_until(6);
			get(SSOCommonUtilities.class)
	          .saveFile();
			get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout")
	          .wait_until(3);
		}
	
		 // Badge print with appointment from NVD
		
		@Test(priority = 13, groups = { "functional" })
		 public void BadgePrintFromNVDWithDailyRecurringAppt() throws IOException {
		  get(SSOLoginPage.class)
		          .invoke_loginURL("ssoUrl")
		          .enter_username(userName);
		          password = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, userName);	 
		 get(SSOLoginPage.class)
		          .enter_password(password)
		          .click_login_button()
		          .wait_until(10);
		 get(SSOCommonUtilities.class)
 			.select_option_from_solution_selector("Vendormate Credentialing")
 			.wait_until(17);
		get(NVDHomePage.class)
		          .click_action_drop_down()
		          .click_print_badge_link()
		          .wait_until(10);
		get(NVDBadgePrintPage.class)
		          .select_option_from_account_dropdown("Wayne Healthcare")
		          .wait_until(10)
		          .select_appointments()
		          .wait_until(10)
		          .enter_contact_title(contactTitle)
		          .click_print_badge_button()
		          .wait_until(15);
		  get(SSOCommonUtilities.class)
		          .select_option_from_userName_dropdown("Logout")
		          .wait_until(3);
		 }
		
		// Badge print with appointment from Kiosk
	
		@Test(priority = 14, groups = { "functional" })
		   public void BadgePrintFromKioskWithDailyRecurringAppt(){ 
			get(KioskPage.class)
	    		.invoke_kioskURL("kioskUrl")
	    		.click_kiosk_link()		
		       	.click_sign_in_button()
		       	.enter_email_id(userName)
		       	.click_find_your_information()
		       	.wait_until(4)
		       	.click_print_badge_button();
			get(SSOCommonUtilities.class)
				.saveFile();
				close_popup_window();
			} 
		
		@Test(priority = 15, groups = { "functional" })
		 public void VerifyBadgePrintWithAppointmentInSignInHistoryTab() throws IOException {

			 get(SSOLoginPage.class)
		     		.invoke_loginURL("ssoUrl")
		     		.enter_username(buyerUserNm);
			        buyPassowrd = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
			get(SSOLoginPage.class)		     		
		     		.enter_password(buyPassowrd)
		     		.click_login_button()
		     		.wait_until(10);
			 get(SSOCommonUtilities.class)
	 				.select_option_from_solution_selector("Vendormate Credentialing")
	 				.wait_until(17);
			 get(NBDHomePage.class)
			          .click_signin_history()
			          .wait_until(5);
			  get(NBDSignInHistoryPage.class)
			           .enter_department_name(dept)
			          .enter_rep_information(userName)
			          .enter_purpose_of_visit(apptSubject)
			          .wait_until(4);
			  get(SSOCommonUtilities.class)
			          .pressEnter()
			          .wait_until(4);
			  get(NBDSignInHistoryPage.class)
			          .verify_department_1st_record(dept);
			  get(SSOCommonUtilities.class)
			  		  .wait_until(2)  
			  		  .select_option_from_userName_dropdown("Logout")
			  		  .clear_current_session();
		}

	
	 }