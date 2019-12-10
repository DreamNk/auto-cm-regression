package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditUserPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVRPReportPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class RM_Dash_Navigation_Test extends AbstractAutoUITest {
	
	String login_RM_id = "kshruti";
	String RM_password = "";
	
	//Searched Rep details------------------------------------------------------------------------------
	String searchRepUserId = "mayurghx1@gmail.com";
	String repUserName = "Mayurghx";

	@Test(priority = 1, groups = { "functional" })
	public void RmNavigationFromVRPR() {
		get(SSOLoginPage.class)
		    .invoke_loginURL("prodUrl")
		    .enter_username(login_RM_id)
		    .enter_password(RM_password)
		    .click_login_button();
		get(SSOCommonUtilities.class)
		    .select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
	        .wait_until(10)
  		    .click_crm_support_tab()
		    .click_crm_dashboard();
		get(RMDashLandingPage.class)
		    .click_vrpr_report();
		get(RMDashVRPReportPage.class)
		    .enter_google_search_string(searchRepUserId)
		    .click_continue_button()
		    .click_vendordash_link_for_1st_search_record();
		get(SSOCommonUtilities.class, focus_on_popup_window())
		    .wait_until(6)
		    .verify_username(repUserName)
		    .select_option_from_userName_dropdown("Logout");
		    close_popup_window();
		
		get(RMDashVRPReportPage.class, focus_on_parent_window())
		    .click_back_button();
	}
		
		@Test(priority = 2, groups = { "functional" })
		public void RmNavigationToNVDFromEditUser() {
	    get(RMDashLandingPage.class)
	        .click_edit_user_link();
	    get(RMDashEditUserPage.class)
	        .enter_rep_email(searchRepUserId)
	        .click_search_rep_user_button()
	        .click_on_rep_id(searchRepUserId)
	        .click_vendordash_link();
	    get(SSOCommonUtilities.class, focus_on_popup_window())
	    	.wait_until(10)
	        .verify_username(repUserName)
	        .wait_until(10)
	        .select_option_from_userName_dropdown("Logout");
	        close_popup_window();
	}
		
		
		//Searched buyer details-----------------------------------------------------------------
		String search_buyer_user_id = "anamikadutta1001@gmail.com";
		String buyer_user_name = "Anamika"; 
		
		@Test(priority = 3, groups = { "functional" })
		public void RmNavigationToNBDFromEditUser() {
	    get(RMDashEditUserPage.class, focus_on_parent_window())
	        .click_cancel_button()
	        .wait_until(3)
	        .click_cancel_button()
	        .enter_buyer_email(search_buyer_user_id)
	        .click_search_buyer_user_button()
	        .click_on_buyer_id(search_buyer_user_id)
	        .click_on_buyer_id(search_buyer_user_id);
	    get(SSOCommonUtilities.class, focus_on_popup_window())
	        .verify_username(buyer_user_name)
	        .select_option_from_userName_dropdown("Logout");
	        close_popup_window();
	    get(RMDashLandingPage.class, focus_on_parent_window())
	        .click_logout();
	    get(SSOCommonUtilities.class)
	    	.clear_current_session();
		}	
}
