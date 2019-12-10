package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.CMRMDashboardPage;
import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.PCMBuyerDashPage;
import com.ghx.auto.cm.ui.sso.page.PCMRMDashBoardPage;
import com.ghx.auto.cm.ui.sso.page.PCMRepDashboardPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Navigation_Test extends AbstractAutoUITest{

	
	String buyerId= "buyer1@universalhomecare.vdm";
	String buyerPassword="Gltd@456";
	String repId="repone@raymond.vm"; 
	String repPassword="Gltd1235@";     
	String rmId="gopal.rm@vendormate.com";
	String rmPassword="Gltd123@";
	String loggedInRMName = "Gopal KoratanaRM";
	String repName="Automation";  
	String buyerUserName = "Ronald";
		
	@Test(priority=1, groups = {"functional"})                                        
		public void BuyerNavigationWithSSOURL(){
		
			get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")                                           
				.enter_username(buyerId)
				.enter_password(buyerPassword)
				.click_login_button();
			get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing")
				.wait_until(10);
			get(NBDHomePage.class)
				.verify_vendormate_credentialing_header_name()
				.wait_until(5);
			get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Contract Manager Xpert")
				.wait_until(10);
			get(PCMBuyerDashPage.class,focus_on_popup_window())
				.wait_until(6);
				close_popup_window();
			get(PCMBuyerDashPage.class,focus_on_parent_window())
				.wait_until(6)
				.click_alert_pop_up_window()
				.verify_contracting_and_compliance_name()
				.wait_until(5);
			get(SSOCommonUtilities.class)
			    .select_option_from_solution_selector("Vendormate Credentialing")
			    .wait_until(10)
			    .verify_userName(buyerUserName) 
				.wait_until(5)
		        .click_solution_selector()
		        .wait_until(5)
	            .click_home_from_solution_selector_in_stag()
	            .wait_until(20)
		        .select_option_from_userName_dropdown("Logout")
		        .clear_current_session();
	}
 
	
	@Test(priority=2, groups = {"functional"})                                        
		public void BuyerNavigationWithBuyerURL(){
		
			get(SSOLoginPage.class)
				.invoke_loginURL("nbdUrl")                                           
				.enter_username(buyerId)
				.enter_password(buyerPassword)
				.click_login_button();
			get(SSOCommonUtilities.class)
				.wait_until(3)
				.checkAccessDeniedMessage();
			get(SSOCommonUtilities.class)
				.wait_until(3)
				.select_option_from_solution_selector("Contract Manager Xpert")
				.wait_until(15);
			get(PCMBuyerDashPage.class,focus_on_popup_window())
				.wait_until(6);
				close_popup_window();
			get(PCMBuyerDashPage.class,focus_on_parent_window())
				.wait_until(6)
				.click_alert_pop_up_window()
				.verify_contracting_and_compliance_name()
				.wait_until(5);
			get(SSOCommonUtilities.class)
			    .select_option_from_solution_selector("Vendormate Credentialing")
			    .wait_until(10)
			    .verify_userName(buyerUserName)
			    .refresh_page();
			get(SSOCommonUtilities.class)    
				.wait_until(5)
		        .click_solution_selector()
	            .click_home_from_solution_selector_in_stag()
	            .wait_until(10)
		        .select_option_from_userName_dropdown("Logout")
		        .clear_current_session();
	}
	
	@Test(priority=3, groups = {"functional"})                                        
		public void RepNavigationWithRepURL(){
	
		get(SSOLoginPage.class)
			.invoke_loginURL("nvdUrl")                                           
			.enter_username(repId)
			.enter_password(repPassword)
			.click_login_button();
		get(NVDHomePage.class)
			.verify_vendormate_credentialing_header_name()
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Contract Manager Xpert")
			.wait_until(10);
		get(PCMRepDashboardPage.class)	
			.verify_contracting_and_compliance_name()
			.wait_until(5);
		get(SSOCommonUtilities.class)
		    .select_option_from_solution_selector("Vendormate Credentialing")
		    .wait_until(10)
		    .verify_userName(repName)
	        .click_solution_selector()
	        .wait_until(5)
	        .click_home_from_solution_selector_in_stag()
            .wait_until(5)
	        .select_option_from_userName_dropdown("Logout")
	        .clear_current_session();

} 	
	
	@Test(priority=4, groups = {"functional"})                                        
	public void RepNavigationWithSSOURL(){
	
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")                                           
			.enter_username(repId)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(10);
		get(SSOCommonUtilities.class)
			.wait_until(3)
			.checkAccessDeniedMessage();
		get(NVDHomePage.class)
			.verify_vendormate_credentialing_header_name()
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Contract Manager Xpert")
			.wait_until(10);
		get(PCMRepDashboardPage.class)	
			.wait_until(3)
			.verify_contracting_and_compliance_name()
			.wait_until(10);
		get(SSOCommonUtilities.class)
	        .select_option_from_solution_selector("Vendormate Credentialing")
	        .wait_until(5)
	        .verify_userName(repName)
            .click_solution_selector()
            .wait_until(5)
            .click_home_from_solution_selector_in_stag()
            .wait_until(5)
            .select_option_from_userName_dropdown("Logout")
            .clear_current_session();

} 
	
	@Test(priority=5, groups = {"functional"})                                        
		public void CPMNavigationWithSSOURL(){
		
			get(SSOLoginPage.class)
				.invoke_loginURL("ssoUrl")                                           
				.enter_username(rmId)
				.enter_password(rmPassword)
				.click_login_button()
				.wait_until(10);
		
			get(SSOCommonUtilities.class)
				.checkSSOLandingPageLink();		
						
			get(CPMHomePage.class)
				.verify_cpm_header_text()
				.click_pcm_support_tab()
				.wait_until(10);
			get(PCMRMDashBoardPage.class)
				.verify_contracting_and_compliance_headrer_text()
				.click_pcm_header_switcher()
				.wait_until(5)
				.click_vendormate_credentialing_link();
			get(CPMHomePage.class)
				.verify_cpm_header_text()
				.click_crm_support_tab()
				 .wait_until(5)
				.click_crm_dashboard()
				.wait_until(10);
			get(CMRMDashboardPage.class)
				.verify_RM_header_text("Gopal KoratanaRM")
				.wait_until(3)
				.click_cpm_support_link();
			get(SSOCommonUtilities.class)
		        .click_solution_selector()
		        .wait_until(10)
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
		        .click_scroll_down_from_solution_selector()
                .click_home_in_solution_selector_of_CPM_Stag()
	            .wait_until(10)
		        .select_option_from_userName_dropdown("Logout")
		        .clear_current_session();;

}

	@Test(priority=6, groups = {"functional"})                                        
	public void CPMNavigationWithURL(){
	
		get(SSOLoginPage.class)
			.invoke_loginURL("rmUrl")                                           
			.enter_username(rmId)
			.enter_password(rmPassword)
			.click_login_button();
		get(CPMHomePage.class)
			.verify_cpm_header_text()
			.click_pcm_support_tab()
			.wait_until(10);
		get(PCMRMDashBoardPage.class)
			.verify_contracting_and_compliance_headrer_text()
			.click_pcm_header_switcher()
			 .wait_until(10)
			 .click_vendormate_credentialing_link();
		get(CPMHomePage.class)
			.verify_cpm_header_text()
			.wait_until(3)
			.click_crm_support_tab()
			.wait_until(5)
			.click_crm_dashboard()
			.wait_until(10);
		get(CMRMDashboardPage.class)
			.verify_RM_header_text(loggedInRMName)
			.click_cpm_support_link()
			.wait_until(10);
		get(SSOCommonUtilities.class)
		    .click_solution_selector()
		    .wait_until(10)
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_scroll_down_from_solution_selector()
		    .click_home_in_solution_selector_of_CPM_Stag()
	        .wait_until(10)
		    .select_option_from_userName_dropdown("Logout")
		    .clear_current_session();;

}

	@Test(priority=7, groups = {"functional"})                                        
	public void RmExchangeSupportNavigation(){
	
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")                                           
			.enter_username(rmId)
			.enter_password(rmPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing");
		get(CPMHomePage.class)
			.wait_until(15)
			.verify_cpm_header_text()
			.wait_until(3)
			.click_crm_support_tab()
			.wait_until(5)
			.click_crm_dashboard()
			.wait_until(15);
		get(CMRMDashboardPage.class)
			.verify_RM_header_text(loggedInRMName)
			.click_exchange_support_link()
			.wait_until(10);
		get(CorexExchangeSupportPage.class)
		    .verify_compare_text_on_landing_page()
		    .select_option_from_solution_selector_exchange_support("Vendormate Credentialing");
		get(SSOCommonUtilities.class)	
		    .wait_until(10)
			.select_option_from_userName_dropdown("Logout");
	}

	@Test(priority=8, groups = {"functional"})                                        
	 public void RmUserManagementNavigation(){
	 
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")                                           
			.enter_username(rmId)
			.enter_password(rmPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5);	
		get(CPMHomePage.class)
			.wait_until(10)
			.verify_cpm_header_text()
			.wait_until(3)
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
			.wait_until(3)
	      	.select_option_from_solution_selector();
		get(SSOCommonUtilities.class)
	        .wait_until(10)
	        .select_option_from_userName_dropdown("Logout")
	        .clear_current_session();;
	}
	
}
