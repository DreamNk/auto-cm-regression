package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CMRMDashboardPage;
import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Navigation_With_VPN_Test extends AbstractAutoUITest{
	
	  String loginRMId = "kshruti";
	  String RMPassword = "";
	  String loggedInRMName="Shruti Kamdi";	

	  @Test(priority=1, groups = {"functional"})                                        
		public void RmExchangeSupportNavigation(){
		
			get(SSOLoginPage.class)
				.invoke_loginURL("prodUrl")                                           
				.enter_username(loginRMId)
				.enter_password(RMPassword)
				.click_login_button();
			get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing")
				.wait_until(5);	
			get(CPMHomePage.class)
				.wait_until(15)
				.verify_cpm_header_text()
				.wait_until(3)
				.click_crm_support_tab()
				.click_crm_dashboard()
				.wait_until(35);
			get(CMRMDashboardPage.class)
				.verify_RM_header_text(loggedInRMName)
				.click_exchange_support_link()
				.wait_until(10);
			get(CorexExchangeSupportPage.class)
			    .verify_compare_text_on_landing_page()
				.select_option_from_solution_selector_vendormate_credentialing("Vendormate Credentialing");
		}
		
		@Test(priority=2, groups = {"functional"})                                        
		 public void RmUserManagementNavigation(){
			get(CPMHomePage.class)
				.wait_until(5)
				.click_crm_support_tab()
				.click_crm_dashboard()
				.wait_until(15);
			get(CMRMDashboardPage.class)
				.verify_RM_header_text(loggedInRMName)
				.click_user_management_link()
				.wait_until(30);
			get(CorexUserManagementPage.class)
				.verify_product_name("Users")
				.click_solution_selector()
		      	.select_option_from_solution_selector();
			get(SSOCommonUtilities.class)
		      .wait_until(10)
		      .select_option_from_userName_dropdown("Logout");
		}
		
}