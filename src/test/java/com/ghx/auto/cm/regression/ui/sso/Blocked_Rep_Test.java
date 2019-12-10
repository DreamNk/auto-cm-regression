package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.KioskPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditCustomerPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Blocked_Rep_Test extends AbstractAutoUITest{
	
	//-------NBD Test Data for blocked rep TC.........
	//String baseUrl = "http:login-stg.awsdsi.ghx.com";
	String buyer_id = "buyer1@hon.vdm";
	String buyer_password = null;
	String status ="BLOCKED";
	String email="v1@gps.net";
	//String visiting_contact="Test For the Blocked rep";
	String purpose_of_visit="Badge Print for the Blocked Rep";
	String department ="Accounting";
	String popupmsg = "Rep has been blocked from this health system.";
	
	//-------NVD login Credentials----
	String repEmailId = "v1@gps.net";
	String repPassword = null; 
	String rep_FName= "James";
	String rep_LName="Warner";
	String account_name = "HONBLUE INC";
	
	//---Kiosk badge print----
	String location = "Boston";
	String poe = "Gate1";
	String visiting_contact = "Sharon";
	String kioskSubject = "NICU";
	String kioskDepartment = "NICU";
	
	String RM_id = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";
	
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	
		@Test(priority = 1, groups = { "functional" })
	public void CrMEnableLocationForBlocking(){
	get(SSOLoginPage.class)
	    .invoke_loginURL("ssoUrl")
	    .enter_username(RM_id)
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
	    .enter_customer_name_in_the_searchbox(account_name)
	    .click_search_button()
	    .click_edit_button()
	    .wait_until(3)
	    .click_configure_rep_blocking_location_link()
	    .wait_until(3)
	    .click_disable_all_location()
	    .wait_until(3)
	    .click_enable_blocking_location()
	    .click_blocking_complete_button()
	    .click_logout_link();
	get(SSOCommonUtilities.class)
	   	.clear_current_session();
	}
	
		@Test(priority = 2, groups = { "functional" })
	public void NBDBlockedRep() throws IOException {
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
			.click_reps_tab();
		get(NBDRepsPage.class)
		    .enter_rep_first_name(rep_FName)
		    .enter_rep_last_name(rep_LName)
		    .wait_until(3);
		get(SSOCommonUtilities.class)
			.wait_until(3)
	    	.pressEnter();
		get(NBDRepsPage.class)
			.wait_until(2)
            .select_option_for_actionstatus("Block")
			.enter_blockReason("Blocked by Admin Buyer")
			.click_block_btn()
			.wait_until(3);
	
		get(NBDHomePage.class)
			.click_home_tab()
			.wait_until(3)
			.click_reps_tab();
		get(NBDRepsPage.class)
			.enter_rep_first_name(rep_FName)
			.enter_rep_last_name(rep_LName)
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.wait_until(3)
			.pressEnter();
		get(NBDRepsPage.class)
			.verify_requirement_status(status);
	
		get(SSOCommonUtilities.class)
		   .select_option_from_userName_dropdown("Logout")
		   .clear_current_session();
		   
	}
	
	//NVD Rep Access Status Check for Blocked User
	@Test(priority = 3, groups = { "functional" })
	public void NVDBlockedRepCheck() throws IOException {
		get(SSOLoginPage.class)
		   .invoke_loginURL("ssoUrl")
		   .wait_until(3)
		   .enter_username(repEmailId);
		   repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId);	 
			get(SSOLoginPage.class)
		   .enter_password(repPassword)
		   .click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);
		get(NVDHomePage.class)
		   .click_accounts_tab();
		get(NVDAccountPage.class)
		   .enter_account_name(account_name)
		   .click_search_button()
		   .wait_until(3)
		   .verify_blocked_status();
		get(SSOCommonUtilities.class)
		   .select_option_from_userName_dropdown("Logout")
		   .clear_current_session();
		   
	}

	
	//NBD UnBlock the Rep
	@Test(priority = 4, groups = { "functional" })
		
	public void BadgePrintFromKioskForBLockedRep() throws IOException {	
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
           	.click_configure_unconfigure_signin_machine()
        	.wait_until(3);
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
        	.click_vendormate_credentialing_kiosk_link()
        	.click_sign_in_button()
        	.enter_email_id(repEmailId)
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
    		.wait_until(5)
    		.click_popup_ok_button();         
	    	close_popup_window();   
        get(SSOCommonUtilities.class, focus_on_parent_window())
        	.refresh_page();
		get(NBDHomePage.class)
			.wait_until(5)
			.click_reps_tab();
		get(NBDRepsPage.class)
     	   .enter_rep_first_name(rep_FName)
		   .enter_rep_last_name(rep_LName)
		   .wait_until(5);
		// .verify_email_id(repMailId);
		
		get(SSOCommonUtilities.class)
		   .pressEnter()
		   .wait_until(5);
		
		get(NBDRepsPage.class)
		   .wait_until(3)
		   .select_option_for_actionstatus("Unblock")
		   .enter_unblockReason("Unblocked by Admin Buyer")
		   .click_unblock_btn()
		   .wait_until(3)
			.wait_until(3)
			.verify_pass_alert();
		get(SSOCommonUtilities.class)
		   .wait_until(3)
		   .select_option_from_userName_dropdown("Logout"); 
	}
	
	//NVD Rep Access Status Check for UnBlocked User
		
		@Test(priority = 5, groups = { "functional" })
		
		public void NVDUnBlockedRepCheck() throws IOException {
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")
			.wait_until(3)
			.enter_username(repEmailId);
		repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId);	 
		get(SSOLoginPage.class)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);	
		get(NVDHomePage.class)
			.click_accounts_tab();
		get(NVDAccountPage.class)
			.enter_account_name(account_name)
			.click_search_button()
			.wait_until(3)
			.verify_pass_status();
		get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();
			
		}
		
		@Test(priority = 6, groups = { "functional" })
		public void CrMEnableAllLocationForBlocking(){
		get(SSOLoginPage.class)
		    .invoke_loginURL("ssoUrl")
		    .enter_username(RM_id)
		    .enter_password(RM_password)
		    .click_login_button();
		get(SSOCommonUtilities.class)
		    .select_option_from_solution_selector("Vendormate Credentialing")
		    .wait_until(20);
		get(CPMHomePage.class)
		    .click_crm_support_tab()
		    .click_crm_dashboard();
		get(RMDashLandingPage.class)
		    .click_edit_customer_link();
		get(RMDashEditCustomerPage.class)
		    .enter_customer_name_in_the_searchbox("HONBLUE INC")
		    .click_search_button()
		    .click_edit_button()
		    .wait_until(3)
		    .click_configure_rep_blocking_location_link()
		    .wait_until(3)
		    .click_enable_all_location()
		    .click_blocking_complete_button()
		    .click_logout_link();
		    get(SSOCommonUtilities.class)
		    .clear_current_session();
				
		}
}
