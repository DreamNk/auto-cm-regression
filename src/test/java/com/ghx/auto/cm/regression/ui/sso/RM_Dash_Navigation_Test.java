package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditUserPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVRPReportPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class RM_Dash_Navigation_Test extends AbstractAutoUITest {
	
	String login_RM_id = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";
	
	//Searched Rep details------------------------------------------------------------------------------
	String searchRepUserId = "carol.lopez@egxv411.vm";
	String repUserName = "Carol";
	
	//Searched buyer details-----------------------------------------------------------------
			String searchBuyerUserId = "buyer1@sadasystem.vdm";
			String buyerUserName = "Jill"; 

	@Test(priority = 1, groups = { "functional" })
	public void RmNavigationFromVRPR() {
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
		    .click_vrpr_report();
		get(RMDashVRPReportPage.class)
		    .enter_google_search_string(searchRepUserId)
		    .click_continue_button()
		    .click_vendordash_link_for_1st_search_record();
		get(SSOCommonUtilities.class, focus_on_popup_window())
		 //   .click_continue_button() //
		    .wait_until(2)
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
	   //     .click_continue_button()  //
	        .verify_username(repUserName)
	        .select_option_from_userName_dropdown("Logout");
	        close_popup_window();
	}
		

		
		@Test(priority = 3, groups = { "functional" })
		public void RmNavigationToNBDFromEditUser() {
	    get(RMDashEditUserPage.class, focus_on_parent_window())
	        .click_cancel_button()
	        .wait_until(3)
	        .click_cancel_button()
	        .enter_buyer_email(searchBuyerUserId)
	        .click_search_buyer_user_button()
	        .click_on_buyer_id(searchBuyerUserId)
	        .click_on_buyer_id(searchBuyerUserId);
	    get(SSOCommonUtilities.class, focus_on_popup_window())
	        .verify_username(buyerUserName)
	        .select_option_from_userName_dropdown("Logout");
	        close_popup_window();
	    get(RMDashLandingPage.class, focus_on_parent_window())
	        .click_logout();
	}
		
		
}
