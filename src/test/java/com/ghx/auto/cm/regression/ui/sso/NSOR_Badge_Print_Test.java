package com.ghx.auto.cm.regression.ui.sso;


import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.KioskPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditCustomerPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class NSOR_Badge_Print_Test extends AbstractAutoUITest {

	//-------RM login Credentials----
	String login_RM_id = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";	
	//-------NVD login Credentials----
		String repEmailId1 = "kamble.yuraj@gps.net";
		String repPassword1 = null; 
		String account_name = "HONBLUE INC";
	//-------NBD login Credentials----
		String buyer_id = "buyer1@hon.vdm";
		String buyer_password = null;
	
		String location = "Boston";
		String poe = "Gate1";
		String visiting_contact = "Sharon";
		String kioskSubject = "NICU";
		String kioskDepartment = "NICU";
	//Error Message at kiosk for NSOR
		String errormsg= "\"Does Not Meet Requirements.\"";
		String popupmsg="This health system requires background check screening to obtain a badge. Your current background check status is "+errormsg+" Please complete the necessary requirement(s) before attempting to badge again.";
	//NSOR=Expired, Doc Status=Pass and Out of Grace Period
		String repEmailId2="ana.glay@gps.net";
		String repPassword2 = null; 
	//NSOR=Pass, Doc status=Pass
		String repEmailId3="james.watt@gps.net";
		String repPassword3 = null;
	//NSOR Fail	
		String repEmailId4="varun.yadav@gps.net";
		String repPassword4 = null;
		//Password details
		String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
		String fileName = "GetPasswordStaging.xlsx";
		
		@Test(priority = 1, groups = { "functional" })
		public void NSORBadgePrintInsideGracePeriod() throws IOException {
		
		//Login to RM and Check NSOR In Grace Period
			
		get(SSOLoginPage.class)
	    	.invoke_loginURL("ssoUrl")
	    	.enter_username(login_RM_id)
	    	.enter_password(RM_password)
	    	.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
	    	.click_crm_support_tab()
	    	.click_crm_dashboard();
		get(RMDashLandingPage.class)
			.click_edit_customer_link();
		get(RMDashEditCustomerPage.class)
			.enter_customer_name_in_the_searchbox("HONBLUE INC")
			.click_search_button()
			.click_view_button()
			.click_manage_nsor_details_button()
			.check_nsor_checkbox()
			.click_date_picker()
			.click_next_month_icon()
			.select_next_month_date()
			.click_nsor_complete_button();
		get(RMDashLandingPage.class)
			.click_logout()
			.wait_until(6);	
		get(SSOCommonUtilities.class)
		   	.clear_current_session();
		
	
		
		//Verify NSOR_Incomplete i.e ALERT Status and Tool tip message
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")
			.wait_until(3)
			.enter_username(repEmailId1);
		repPassword1 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId1);	 
		get(SSOLoginPage.class)	
			.enter_password(repPassword1)
			.click_login_button();
		get(SSOCommonUtilities.class)
		   	.select_option_from_solution_selector("Vendormate Credentialing");
		get(NVDHomePage.class)
		   	.click_accounts_tab();
		get(NVDAccountPage.class)
		   	.enter_account_name(account_name)
		   	.click_search_button()
		   	.wait_until(3)
		    .verify_alert_status()
		 //Mouse hover code
			.mouseover_rep_access_status()
			.wait_until(2);
		get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();
		// BadgePrintFromKiosk	
		get(SSOLoginPage.class)
			 .invoke_loginURL("ssoUrl")
			 .enter_username(buyer_id);
			 buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_id);	 
		get(SSOLoginPage.class)	
			 .enter_password(buyer_password)
			 .click_login_button();
		get(SSOCommonUtilities.class)
			  .select_option_from_solution_selector("Vendormate Credentialing")
			  .wait_until(20);
		get(NBDHomePage.class)
			  .click_configure_unconfigure_signin_machine();
		get(KioskPage.class)
			   .click_here();
		get(KioskPage.class, focus_on_popup_window())
		       .wait_until(4).click_location_dropdown()
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
			   .enter_email_id(repEmailId1)
			   .click_find_your_information()
		       .enter_visiting_contact(visiting_contact)
		       .enter_purpose(kioskSubject)
		       .click_department_dropdown()
	           .wait_until(2)
	           .wait_for_text_appear(kioskDepartment)
	           .wait_until(2)
	           .click_department(kioskDepartment)
		       .click_print_badge_button();
		get(SSOCommonUtilities.class)
			   .saveFile();
			   close_popup_window();
		get(SSOCommonUtilities.class, focus_on_parent_window())
			    .wait_until(2);
		get(SSOCommonUtilities.class)
	        	.refresh_page();
		get(SSOCommonUtilities.class)
			   	.wait_until(3)
			   	.select_option_from_userName_dropdown("Logout");		
		}
		
		
		//NSOR Expired 
		@Test(priority = 2, groups = { "functional" })
		public void NSORExpiredBadgePrintInsideGracePeriod() throws IOException {
		get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.wait_until(3)
				.enter_username(repEmailId2);
		repPassword2 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId2);	 
			get(SSOLoginPage.class)
				.enter_password(repPassword2)
				.click_login_button();
		get(SSOCommonUtilities.class)
	   			.select_option_from_solution_selector("Vendormate Credentialing");
		get(NVDHomePage.class)
	   			.click_accounts_tab();
		get(NVDAccountPage.class)
	   			.enter_account_name(account_name)
	   			.click_search_button()
	   			.wait_until(3)
	   			.verify_alert_status()
	   			.mouseover_rep_access_status()
	   			.wait_until(2);
		get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");	
		get(KioskPage.class)
				.invoke_kioskURL("kioskUrl")
				.click_kiosk_link()
				.click_sign_in_button()
				.enter_email_id(repEmailId2)
				.click_find_your_information()
				.enter_visiting_contact(visiting_contact)
				.enter_purpose(kioskSubject)
				.click_department_dropdown()
		        .wait_until(2)
		        .wait_for_text_appear(kioskDepartment)
		        .wait_until(2)
		        .click_department(kioskDepartment)
				.click_print_badge_button();
		get(SSOCommonUtilities.class)
		   		.saveFile()
		   		.wait_until(5);
		  
		}	
		@Test(priority = 3, groups = { "functional" })
		public void NSORPassBadgePrintInsideGracePeriod() throws IOException {
		get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.wait_until(3)
				.enter_username(repEmailId3);
				repPassword3 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId3);	 
		get(SSOLoginPage.class)
				.enter_password(repPassword3)
				.click_login_button();
		get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing");
		get(NVDHomePage.class)
				.click_accounts_tab();
		get(NVDAccountPage.class)
				.enter_account_name(account_name)
				.click_search_button()
				.wait_until(3)
				.verify_pass_status()
				.wait_until(2);
	
		get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");
// BadgePrintFromKiosk	
		get(KioskPage.class)
				.invoke_kioskURL("kioskUrl")
				.click_kiosk_link()
				.click_sign_in_button()
				.enter_email_id(repEmailId3)
				.click_find_your_information()
				.enter_visiting_contact(visiting_contact)
				.enter_purpose(kioskSubject)
				.click_department_dropdown()
		        .wait_until(2)
		        .wait_for_text_appear(kioskDepartment)
		        .wait_until(2)
		        .click_department(kioskDepartment)
				.click_print_badge_button();
		get(SSOCommonUtilities.class)
		   		.saveFile()
		   		.wait_until(3);
	
		}
	
	@Test(priority = 4, groups = { "functional" })
	public void NSORBadgePrintOutsideGracePeriod() throws IOException {
	
		
		//Login to RM and set NSOR out of Grace Period
		get(SSOLoginPage.class)
	    		.invoke_loginURL("ssoUrl")
	    		.enter_username(login_RM_id)
	    		.enter_password(RM_password)
	    		.click_login_button();
		get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
	    		.click_crm_support_tab()
	    		.click_crm_dashboard();
		get(RMDashLandingPage.class)
				.click_edit_customer_link();
		get(RMDashEditCustomerPage.class)
				.enter_customer_name_in_the_searchbox("HONBLUE INC")
				.click_search_button()
				.click_view_button()
				.click_manage_nsor_details_button()
				.click_date_picker()
				.select_today_date()
				.click_nsor_complete_button()
				.click_logout_link();
	//Verify NSOR_Incomplete i.e FAIL Status and Tool tip message
		get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.wait_until(3)
				.enter_username(repEmailId1);
				repPassword1 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId1);	 
		get(SSOLoginPage.class)
				.enter_password(repPassword1)
				.click_login_button();
		get(SSOCommonUtilities.class)
		   		.select_option_from_solution_selector("Vendormate Credentialing");
		get(NVDHomePage.class)
		   		.click_accounts_tab();
		get(NVDAccountPage.class)
		   		.enter_account_name(account_name)
		   		.click_search_button()
		   		.wait_until(3)
		   		.verify_fails_status()	 //Mouse hover code
		   		.mouseover_fail_rep_access_status()
		   		.wait_until(2);
		get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");
		get(KioskPage.class)
	        	.invoke_kioskURL("kioskUrl")
	        	.click_kiosk_link()
	        	.click_sign_in_button()
	        	.enter_email_id(repEmailId1)
	        	.click_find_your_information()
	        	.enter_visiting_contact(visiting_contact)
	        	.enter_purpose(kioskSubject)
	        	.click_department_dropdown()
		        .wait_until(2)
		        .wait_for_text_appear(kioskDepartment)
		        .wait_until(2)
		        .click_department(kioskDepartment)
	        	.click_print_badge_button();
	    get(KioskPage.class)
	    		.wait_until(3)
	    		.verify_kiosk_warn_message(popupmsg)
	    		.wait_until(3)
	    		.click_popup_ok_button()
	    		.wait_until(3);
	}
	    //NSOR:Expired Out of GracePeriod
	    @Test(priority = 5, groups = { "functional" })
		public void NSORExpiredBadgePrintOutsideGracePeriod() throws IOException {
	    get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.wait_until(3)
				.enter_username(repEmailId2);
				repPassword2 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId2);	 
		get(SSOLoginPage.class)
				.enter_password(repPassword2)
				.click_login_button();
	    get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing");
	    get(NVDHomePage.class)
				.click_accounts_tab();
	    get(NVDAccountPage.class)
				.enter_account_name(account_name)
				.click_search_button()
				.wait_until(3)
				.verify_fails_status()
				.mouseover_fail_rep_access_status()
				.wait_until(2);
	    get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");
	    get(KioskPage.class)
				.invoke_kioskURL("kioskUrl")
				.click_kiosk_link()
				.click_sign_in_button()
				.enter_email_id(repEmailId2)
				.click_find_your_information()
				.enter_visiting_contact(visiting_contact)
				.enter_purpose(kioskSubject)
				.click_department_dropdown()
		        .wait_until(2)
		        .wait_for_text_appear(kioskDepartment)
		        .wait_until(2)
		        .click_department(kioskDepartment)
				.click_print_badge_button();
	    get(KioskPage.class)
				.wait_until(3)
				.verify_kiosk_warn_message(popupmsg)
				.wait_until(3)
				.click_popup_ok_button()
				.wait_until(5);

	  	}
	    
	    @Test(priority = 6, groups = { "functional" })
		public void NSORFailBadgePrintOutsideGracePeriod() throws IOException {
	    get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.wait_until(3)
				.enter_username(repEmailId4);
				repPassword4 =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId4);	 
		get(SSOLoginPage.class)
				.enter_password(repPassword4)
				.click_login_button();
	    get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing");
	    get(NVDHomePage.class)
				.click_accounts_tab();
	    get(NVDAccountPage.class)
				.enter_account_name(account_name)
				.click_search_button()
				.wait_until(3)
				.verify_fails_status()
	//Mouse hover code
				.mouseover_fail_rep_access_status()
				.wait_until(2);
	    get(SSOCommonUtilities.class)
				.select_option_from_userName_dropdown("Logout");
	    get(KioskPage.class)
				.invoke_kioskURL("kioskUrl")
				.click_kiosk_link()
				.click_sign_in_button()
				.enter_email_id(repEmailId4)
				.click_find_your_information()
				.enter_visiting_contact(visiting_contact)
				.enter_purpose(kioskSubject)
				.click_department_dropdown()
		        .wait_until(2)
		        .wait_for_text_appear(kioskDepartment)
		        .wait_until(2)
		        .click_department(kioskDepartment)
				.click_print_badge_button();
	    get(KioskPage.class)
				.wait_until(3)
				.verify_kiosk_warn_message(popupmsg)
				.wait_until(3)
				.click_popup_ok_button()
				.wait_until(3);
//Login to RM and NSOR Uncheck
	    get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")
				.enter_username(login_RM_id)
				.enter_password(RM_password)
				.click_login_button();
	    get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing");
	    get(CPMHomePage.class)
				.click_crm_support_tab()
				.click_crm_dashboard();
	    get(RMDashLandingPage.class)
				.click_edit_customer_link();
	    get(RMDashEditCustomerPage.class)
				.enter_customer_name_in_the_searchbox("HONBLUE INC")
				.click_search_button()
				.click_view_button()
				.click_manage_nsor_details_button()
				.check_nsor_checkbox()
				.click_nsor_complete_button()
				.click_logout_link();
	    get(SSOCommonUtilities.class) 
	    		.clear_current_session();
	    	  	
	    }

		
}
			