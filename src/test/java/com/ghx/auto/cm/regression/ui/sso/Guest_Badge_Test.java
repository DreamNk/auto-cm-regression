package com.ghx.auto.cm.regression.ui.sso;

import com.ghx.auto.core.ui.test.AbstractAutoUITest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDGuestPassPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
	import com.ghx.auto.cm.ui.sso.page.NBDSignInAVendorPage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
	import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
	import com.ghx.auto.core.ui.test.AbstractAutoUITest;

	
	public class Guest_Badge_Test extends AbstractAutoUITest {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date todaysDate1=new Date();
		Calendar c = Calendar.getInstance();
		String current_month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		String systemDate = dateFormat.format(todaysDate1);
		String[] parts = systemDate.split("/"); // Month
		String current_date = parts[1]; // date
		String current_year = parts[2]; // Year
	
	 String guest1=null;
	 String guest2=null;
	 //Guest Badge "guestunknownuser28@test.net";
	 String guestUnknownUserName2= "guestuser27@test.net";
	 String filePath = "D:\\SetPassword.xlsx";      
	 String fileName = "SetPassword.xlsx";
	 String buyerUserName = "buyer1@royal.com";
	 String buyerPassword ="Gltd!124" ;
	 String firstName = "Guest"; 
	 String lastName = "User";
	 String phoneNumber = "123456";
	 String companyName = "South Carolina"; 
	 String visiting_contact = "Hannah";
	 String NBDsubject = "Badge Print from NBD";
	 String location = "Portland";
	 String poe = "Gate 2";
	 String NBDDepartment = "NICU";
	 String badgeRuleNotEnforceReason = "Automation Guest Pass without Enforcing Badge Rules";
	 String guestBadgeReason = "Automation Guest Pass";
	 String guestBadgeLimitMessage = " Guest pass badges are limited to one time use. Please have this rep register with your health system for continued access."; 
	 String guestBadgeNotPrintMessage = "The identified rep is registered with your health system and is not eligible for a Guest Pass Badge. Please return to the Sign-In page.";
	 
	 
	
	 @Test(priority=1, groups={"functional"})
	
	 public void GuestBadgePrintWithoutEnforcingBadgeRules() throws IOException{
	   get(SSOLoginPage.class)
	            .invoke_loginURL("baseUrl")
	            .enter_username(buyerUserName)
	            .enter_password(buyerPassword)
	            .click_login_button()
	            .wait_until(20);
	   get(SSOCommonUtilities.class)
	            .select_option_from_solution_selector("Vendormate Credentialing")
	            .wait_until(20);
	   get(NBDHomePage.class)
	           .click_sign_in_a_vendor();
	   get(NBDSignInAVendorPage.class)
	           .wait_until(5);
	   
	   guest1 = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, "guestUser1");	
	   
	   get(NBDSignInAVendorPage.class)
	           .enter_corporate_email(guest1+"@test.net")
	           .wait_until(5)
	           .click_find_vendor_info_button()
	           .wait_until(5)
	           .enter_first_name(firstName)
	           .enter_last_name(lastName)
	           .enter_phone_no(phoneNumber)
	           .enter_company_name(companyName)
	           .enter_visiting_contact(visiting_contact)
	           .enter_purpose(NBDsubject)
	           .select_location(location)
	           .select_poe(poe)
	           .select_department(NBDDepartment)
	           .click_unchek_enforce_rule()
	           .enter_reason_for_enforcing_badge_rule(badgeRuleNotEnforceReason)
	          .click_print_guest_pass_button()
	           .wait_until(10);
	     get(NBDGuestPassPage.class)
	            .click_print_guest_badge_button(); 
	     get(SSOCommonUtilities.class)
	       .saveFile()
	       .wait_until(5);
	    get(ReadWritePasswordExcelPage.class)
			.wait_until(5)
			.write_data_excel(filePath, fileName, "guestUser1");
	    }
	
	 
	 @Test(priority=2,groups={"functional"})
	 public void VerifyGuestBadgeWithoutEnforcingRulesInSginInHistory(){
		  get(NBDHomePage.class)
	            .wait_until(10)
	            .click_signin_history()
	            .wait_until(2);
	      get(NBDSignInHistoryPage.class)
	    	 .enter_signin_from_date(current_month, current_date, current_year)
	    	 .wait_until(5)   
	         .enter_department_name(NBDDepartment)
	         .wait_until(5)   
	         .enter_rep_information(guest1+"@test.net");         
	      get(SSOCommonUtilities.class)
	         .pressEnter()
	         .wait_until(5);
	      get(NBDSignInHistoryPage.class)
	          .wait_until(2)
	         .verify_guest_message("Guest Pass")
	         .wait_until(2)
	         .verify_guest_badge_print_reason(badgeRuleNotEnforceReason)
	         .wait_until(5);
	 }
	 
	
	 @Test(priority=3, groups={"functional"})
	 public void GuestBadgePrintForUnknownUser() throws IOException{
		 get(NBDHomePage.class)
         	.click_sign_in_a_vendor();
		 get(NBDSignInAVendorPage.class)
	         .wait_until(10);
	  guest2 = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, "guestUser2");
	   get(NBDSignInAVendorPage.class)
	         .enter_corporate_email(guest2+"@test.net")
	         .wait_until(5)
	         .click_find_vendor_info_button()
	         .wait_until(3)
	         .enter_first_name(firstName)
	         .wait_until(3)
	         .enter_last_name(lastName)
	         .enter_phone_no(phoneNumber)
	         .enter_company_name(companyName)
	         .enter_visiting_contact(visiting_contact)
	         .enter_purpose(NBDsubject)
	         .select_location(location)
	         .select_poe(poe)
	         .select_department(NBDDepartment)
	         .click_print_guest_pass_button();
	   get(NBDGuestPassPage.class)     
	         .enter_reason_for_guest_badge(guestBadgeReason)
	         .wait_until(10)
	         .click_print_guest_badge_button();
	    get(SSOCommonUtilities.class)
	    	.saveFile()
	    	.wait_until(10);
	 }
	
	 @Test(priority=4,groups={"functional"})
	 public void VerifyGuestBadgeInSignInHistory(){
		  get(NBDHomePage.class)
	          .click_signin_history()
	          .wait_until(5);
	      get(NBDSignInHistoryPage.class)
	    	 .enter_signin_from_date(current_month, current_date, current_year)
	    	 .wait_until(3)   
	         .enter_department_name(NBDDepartment)
	         .wait_until(2)   
	         .enter_rep_information(guest2+"@test.net");         
	      get(SSOCommonUtilities.class)
	         .pressEnter()
	         .wait_until(3);
	      get(NBDSignInHistoryPage.class)
	         .verify_guest_message("Guest Pass")
	         .wait_until(2)
	         .verify_guest_badge_print_reason(guestBadgeReason)
	         .wait_until(3);
	 }
	 
	 
	 @Test(priority=5, groups={"functional"})
	 public void PreventGuestBadgeForUnknownUserForSecondTime() throws IOException{
		 get(NBDHomePage.class)
      		.click_sign_in_a_vendor();
		 get(NBDSignInAVendorPage.class)
	        .wait_until(5)
	        .enter_corporate_email(guest2+"@test.net")
	        .click_find_vendor_info_button()
	        .enter_first_name(firstName)
	        .enter_last_name(lastName)
	        .enter_phone_no(phoneNumber)
	        .enter_company_name(companyName)
	        .enter_visiting_contact(visiting_contact)
	        .enter_purpose(NBDsubject)
	        .select_location(location)
	        .select_poe(poe)
	        .select_department(NBDDepartment)
	       .click_print_guest_pass_button();
	  get(NBDGuestPassPage.class)
	       .click_resaon_for_printing_guest_badge()
	       .enter_reason_for_guest_badge(guestBadgeReason)
	       .click_print_guest_badge_button()
	       .verify_limited_guest_badge_message(guestBadgeLimitMessage)
	       .click_return_to_signIn_page_button()
	       .wait_until(5);
	  get(ReadWritePasswordExcelPage.class)
		.wait_until(5)
		.write_data_excel(filePath, fileName, "guestUser2");
	 
	 }
	 
	  @Test(priority = 6, groups = { "functional" })
	   public void GuestBadgeForUnregisteredUserInHeathSystemForSecondTime() {
	 
	   get(NBDSignInAVendorPage.class)
	      .wait_until(5)
	      .enter_corporate_email("ana.glay@gps.net")
	      .click_find_vendor_info_button()
	      .enter_first_name("Ana")
	      .enter_last_name("Glay")
	      .enter_phone_no(phoneNumber)
	      .enter_company_name(companyName)
	      .enter_visiting_contact(visiting_contact)
	      .enter_purpose(NBDsubject)
	      .select_location(location)
	      .select_poe(poe)
	      .select_department(NBDDepartment)
	      .click_print_guest_pass_button();
	   get(NBDGuestPassPage.class)    
	      .enter_reason_for_guest_badge(guestBadgeReason)
	      .wait_until(6)
	      .click_print_guest_badge_button()
	      .verify_limited_guest_badge_message(guestBadgeLimitMessage)
	      .click_return_to_signIn_page_button();
	   }
	 
	  @Test(priority = 7, groups = { "functional" })
	   public void PreventGuestBadgeForRegisteredUserInHealthSystem(){        
	    get(NBDSignInAVendorPage.class)
	        .wait_until(5)
	        .enter_corporate_email("rayan@gps.com")
	        .click_find_vendor_info_button()  
	        .enter_visiting_contact(visiting_contact)
	        .enter_purpose(NBDsubject) 
	        .select_location(location)  
	        .select_poe(poe)   
	        .select_department(NBDDepartment)
	        .click_print_guest_pass_button();
	    get(NBDGuestPassPage.class) 
	        .verify_for_guest_pass_not_printed_error_message(guestBadgeNotPrintMessage)
	        .click_return_to_signIn_page_button();
	    get(SSOCommonUtilities.class)
	      .wait_until(3)
	       .select_option_from_userName_dropdown("Logout");
	   }
	
	}

