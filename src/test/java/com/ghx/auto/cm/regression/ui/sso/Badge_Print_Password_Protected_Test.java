package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.KioskPage;
import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;

import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Badge_Print_Password_Protected_Test extends AbstractAutoUITest {
	//BadgePrintforNOAppointment //BadgePrintDailyRecurringAppointment 
	String repUserName ="rayan@gps.com";
	String repPassword="Gltd!124";
	//BadgePrintFromKisokWithPassComplianceAutoFilledOneTimeAppointment
	String repUserName1="dom@pg.com";
	String repPassword1="Gltd!124";
	//BadgePrintNAComplicanceStatus
	String repUserName2="ashish.bsen@gps.net";
	String repPassword2="Gltd!123";
	//Fail Prevent condition rep user badge print
	String repUserName3= "siddhant.incomplete@gps.net";
	String repPassword3= "Gltd!123";
	//RFPMT (Incomplete) user badge print
	String repUserName4="adersh@gps.net";
	String repPassword4="Gltd!123";
	//Appointments Details
	
	String apptSubject = "Appointment Subject added by Script";
	String apptDesc="Badge Print";	
	String accountName="Royal Perth Hospital";
	//buyer user credentials
	String buyerUserNm="buyer1@royal.com";
	String buyerPassword="Gltd!124";
	String visiting_contact="Nelson";
    String kioskSubject = "Automation Badge Print";
    String location = "Portland";
	String poe = "Gate 2";
	String department = "NICU";
	String optionForDailyRecuringApt = "Every Day";
	
	String warnMessage="Your profile for this Credentialing Program is incomplete. Please log in to Vendormate Credentialing and complete the 'Your Relationship' section.";	
	String warn_message= "Your credentialing tier has changed based on your company's activity. Additional payment is required.";
	String warnMessagePreventCondition="You are not allowed to enter into Hospital";
	
	@Test(priority=1, groups={"functional"})
	public void BadgePrintFromKisokWithNOAppointment(){
		  get(SSOLoginPage.class)
          	 .invoke_loginURL("baseUrl")
          	 .enter_username(buyerUserNm)
          	 .enter_password(buyerPassword)
          	 .click_login_button()
          	 .wait_until(20);
		  get(SSOCommonUtilities.class)
          	 .select_option_from_solution_selector("Vendormate Credentialing")
          	 .wait_until(20);
		  get(NBDHomePage.class)
		     .wait_until(3)
          	 .click_configure_unconfigure_signin_machine()
          	 .wait_until(3);
		  get(KioskPage.class)
          	 .click_here();
		  get(KioskPage.class, focus_on_popup_window())
          	.wait_until(5)
          	.click_location_dropdown()
          	.wait_until(2)
          	.wait_for_text_appear(location)
          	.wait_until(2)
          	.click_location(location)
		    .click_poe_dropdown()
        	.wait_until(2)
        	.wait_for_text_appear(poe)
        	.wait_until(2)
        	.click_location(poe)
        	.click_vendormate_credentialing_kiosk_link()
        	.click_sign_in_button()
          	.enter_email_id(repUserName)
          	.enter_password(repPassword)
          	.click_find_your_information()
          	.enter_visiting_contact(visiting_contact)
          	.enter_purpose(kioskSubject)
          	.click_department_dropdown()
          	.wait_until(2)
          	.wait_for_text_appear(department)
          	.wait_until(2)
          	.click_department(department)
          	.click_print_badge_button()
          	.wait_until(5);
		  get(SSOCommonUtilities.class)
          	.saveFile();
		  get(KioskPage.class)
		    .wait_until(5)
		    .click_return_to_sign_in_page_button();
		    close_popup_window();
		  get(SSOCommonUtilities.class, focus_on_parent_window())
          	.wait_until(2)
          	.refresh_page();
		  get(SSOCommonUtilities.class)
		    .select_option_from_userName_dropdown("Logout");
	}
          	
      
	// For this test case we have created One Time Appointment manually after 1year from date 14/03/2018 //
	@Test(priority=2, groups={"functional"})
	public void BadgePrintFromKisokWithPassComplianceAutoFilledOneTimeAppointment(){
		get(SSOLoginPage.class)
			.invoke_loginURL("baseUrl")
			.enter_username(repUserName1)
			.enter_password(repPassword1)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);
		get(NVDHomePage.class)
			.click_accounts_tab();
		get(NVDAccountPage.class)
			.enter_account_name(accountName)
			.click_search_button()
			.verify_pass_status();
		get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout");
			
/*		get(SSOLoginPage.class)
			.invoke_loginURL("baseUrl")
			.enter_username(buyerUserNm)
			.enter_password(buyerPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);
		get(NBDHomePage.class)
			.click_appointment_tab();
		get(NBDAppointmentsPage.class)
        	.click_add_appointment_button()
        	.select_location(location)
        	.select_department(department)
        	.enter_appointment_subject(apptSubject)
        	.enter_appointment_description(apptDesc)
        	.enter_invite_guest_email_in_searchbox(repUserName1)
        	.wait_until(3);
		get(SSOCommonUtilities.class)
        	.pressEnter()
        	.wait_until(5);	
		get(NBDAppointmentsPage.class)
        	.check_invite_guest_checkbox()
        	.click_save_appointment()
        	.wait_until(7);	
		 get(SSOCommonUtilities.class)
		   .select_option_from_userName_dropdown("Logout");
*/		
	
		 get(KioskPage.class)
			.invoke_kioskURL("kioskUrl")
			.click_kiosk_link()		
			.click_sign_in_button()
			.enter_email_id(repUserName1)
			.enter_password(repPassword1)
			.click_find_your_information()
			//.click_find_your_information_for_password_protected_kiosk()
          	.wait_until(5)
           	.click_print_badge_button()
          	.wait_until(10);
		  get(SSOCommonUtilities.class)
          	.saveFile();
          get(KioskPage.class)
            .wait_until(5)
  		    .click_return_to_sign_in_page_button();
        
	}

	// Daily Recurring appointment
	@Test(priority=3, groups={"functional"})
	public void BadgePrintDailyRecurringAppointment(){
		  get(SSOLoginPage.class)
		    .invoke_loginURL("baseUrl")
		    .enter_username(buyerUserNm)
		    .enter_password(buyerPassword)
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
          	.select_location(location)
          	.select_department(department)
          	.enter_appointment_subject(apptSubject)
          	.enter_appointment_description(apptDesc)
          	.enter_invite_guest_email_in_searchbox(repUserName)
          	.wait_until(3);
		  get(SSOCommonUtilities.class)
          	.pressEnter()
          	.wait_until(5);	
		  get(NBDAppointmentsPage.class)
          	.check_invite_guest_checkbox()
          	.click_save_appointment()
          	.wait_until(7);
		  get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout");
		  get(KioskPage.class)
  			.invoke_kioskURL("kioskUrl")
  			.click_kiosk_link()		
	       	.click_sign_in_button()
	       	.enter_email_id(repUserName)
          	.enter_password(repPassword)
		    //.click_find_your_information_for_password_protected_kiosk()
          	.click_find_your_information()
          	.wait_until(5)
       	    .click_print_badge_button()
      	    .wait_until(10);
	      get(SSOCommonUtilities.class)
      	    .saveFile();
          get(KioskPage.class)
            .wait_until(5)
		    .click_return_to_sign_in_page_button();
		
	}
	
	@Test(priority=4, groups={"functional"})
	public void BadgePrintNAComplicanceStatus(){
		get(KioskPage.class)
			.invoke_kioskURL("kioskUrl")
			.click_kiosk_link()		
			.click_sign_in_button()
			.enter_email_id(repUserName2)
			.enter_password(repPassword2)
			//.click_find_your_information_for_password_protected_kiosk()
			.click_find_your_information()
			.wait_until(5)
          	.enter_visiting_contact(visiting_contact)
          	.enter_purpose(kioskSubject)
          	//.select_department_dropdown(department)
          	.click_department_dropdown()
          	.wait_until(2)
          	.wait_for_text_appear(department)
          	.wait_until(2)
          	.click_department(department)
          	.click_print_badge_button()
          	.wait_until(5)
            .verify_kiosk_warn_message(warnMessage)
            .click_popup_ok_button()
            .wait_until(2)
            .click_cancel_button()
            .wait_until(2);
      			
	}
		@Test(priority=5, groups={"functional"})
	public void BadgePrintIncompleteRegisteredUser(){
		get(KioskPage.class)
			.invoke_kioskURL("kioskUrl")
			.click_kiosk_link()		
			.click_sign_in_button()
			.enter_email_id(repUserName4)
			.enter_password(repPassword4)
			//.click_find_your_information_for_password_protected_kiosk()
			.click_find_your_information()
			.wait_until(5)
			.enter_visiting_contact(visiting_contact)
			.enter_purpose(kioskSubject)
			.click_department_dropdown()
          	.wait_until(2)
          	.wait_for_text_appear(department)
          	.wait_until(2)
          	.click_department(department)
			.click_print_badge_button()
			.wait_until(5)
			.verify_kiosk_warn_message(warn_message)
			.click_popup_ok_button()
			.wait_until(5)
			.click_cancel_button();
	}
	
	@Test(priority=6, groups={"functional"})
	public void BadgePrintForFailCompliancePreventCondition(){
		get(KioskPage.class)
			.invoke_kioskURL("kioskUrl")
			.click_kiosk_link()		
			.click_sign_in_button()
			.enter_email_id(repUserName3)
			.enter_password(repPassword3)
			//.click_find_your_information_for_password_protected_kiosk()
			.click_find_your_information()
			.wait_until(5)
			.enter_visiting_contact(visiting_contact)
			.enter_purpose(kioskSubject)
			.click_department_dropdown()
          	.wait_until(2)
          	.wait_for_text_appear(department)
          	.wait_until(2)
          	.click_department(department)
			.click_print_badge_button()
			.wait_until(5)
			.verify_kiosk_warn_message(warnMessagePreventCondition)
			.click_popup_ok_button()
			.wait_until(5)
			.click_cancel_button();
		get(SSOCommonUtilities.class)
			.clear_current_session();
	}

}

