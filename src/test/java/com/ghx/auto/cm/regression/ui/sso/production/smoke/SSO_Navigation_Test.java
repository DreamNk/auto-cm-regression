package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CMRMDashboardPage;
import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.PCMBuyerDashPage;
import com.ghx.auto.cm.ui.sso.page.PCMRMDashBoardPage;
import com.ghx.auto.cm.ui.sso.page.PCMRepDashboardPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Navigation_Test extends AbstractAutoUITest{

	// Password for Production users Sheet
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
		
	String repUserName="oliva.maddison@gmail.com";
	String repPassword = null;
	String buyerUserName="meeta.buyer@gmail.com";
	String buyerPassword = null;
	String rmUserName="kshruti";
	String rmPassword = "";
	String loggedInRMName="Shruti Kamdi";
	
	@Test(priority=1, groups = {"functional"})                                        
		public void BuyerNavigationWithSSOURL() throws IOException{
			
			get(SSOLoginPage.class)
				.invoke_loginURL("prodUrl") 
				.enter_username(buyerUserName);
			buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserName);
			  get(SSOLoginPage.class)
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
			    .select_option_from_userName_dropdown("Logout")
			    .clear_current_session()
			    .wait_until(10);

		}
	
	@Test(priority=2, groups = {"functional"})                                        
		public void BuyerNavigationWithBuyerURL() throws IOException{
		
			get(SSOLoginPage.class)
				.invoke_loginURL("nbdProdUrl")                                           
				.enter_username(buyerUserName);
			buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserName);
			  get(SSOLoginPage.class)
				.enter_password(buyerPassword)
				.click_login_button();
			
			get(SSOCommonUtilities.class)
				.wait_until(3)
				.checkAccessDeniedMessage();
			get(SSOCommonUtilities.class)
				.wait_until(3)
				.select_option_from_solution_selector("Contract Manager Xpert")
				.wait_until(3);
			get(PCMBuyerDashPage.class,focus_on_popup_window())
				.wait_until(6);
				close_popup_window();
		
			get(PCMBuyerDashPage.class,focus_on_parent_window())
				.wait_until(6)
				.click_alert_pop_up_window()
				.verify_contracting_and_compliance_name()
				.wait_until(10);
				
			get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing")
				.wait_until(10)
			    .select_option_from_userName_dropdown("Logout")
			    .clear_current_session()
			    .wait_until(10);

		}
	
	@Test(priority=3, groups = {"functional"})                                        
		public void RepNavigationWithRepURL() throws IOException{
	
		get(SSOLoginPage.class)
			.invoke_loginURL("nvdProdUrl")                                           
			.enter_username(repUserName);
			repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repUserName);
	    get(SSOLoginPage.class)
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
			.wait_until(5)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5)
			.verify_userName("Oliva")
			.wait_until(5)
			.click_solution_selector()
			.wait_until(2)
		    .click_home_from_solution_selector()
		    .wait_until(10)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session()
			 .wait_until(5);

	} 
		
	@Test(priority=4, groups = {"functional"})                                        
	public void RepNavigationWithURL() throws IOException{
	
		get(SSOLoginPage.class)
			.wait_until(3)
			.invoke_loginURL("prodUrl")                                           
			.enter_username(repUserName);
		    repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repUserName);
	   get(SSOLoginPage.class)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.wait_until(8)
			.checkAccessDeniedMessage();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5);	
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
			.wait_until(3)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5)
			.verify_userName("Oliva")
			.wait_until(5)
			.click_solution_selector()
		    .click_home_from_solution_selector()
		    .wait_until(5)
		    .refresh_page();
		get(SSOCommonUtilities.class)
			.wait_until(10)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();

	} 
	

	@Test(priority=5, groups = {"functional"})                                        
		public void CPMNavigationWithSSOURL(){
		
			get(SSOLoginPage.class)
				.invoke_loginURL("prodUrl")                                           
				.enter_username(rmUserName)
				.enter_password(rmPassword)
				.click_login_button()
				.wait_until(10);
			get(SSOCommonUtilities.class)
				.select_option_from_solution_selector("Vendormate Credentialing")
				.wait_until(5);	
			
			get(CPMHomePage.class)
				.wait_until(15)
				.verify_cpm_header_text()
				.wait_until(2)
				.click_pcm_support_tab()
				.wait_until(10);
			get(PCMRMDashBoardPage.class)
				.verify_contracting_and_compliance_headrer_text()
				.click_pcm_header_switcher()
				.wait_until(3)
				.click_vendormate_credentialing_link();
			get(CPMHomePage.class)
				.verify_cpm_header_text()
				.wait_until(2)
				.click_crm_support_tab()
				.click_crm_dashboard()
				.wait_until(10);
			get(CMRMDashboardPage.class)
				.verify_RM_header_text(loggedInRMName)
				.wait_until(3)
				.click_cpm_support_link()
				.wait_until(10);
			get(SSOCommonUtilities.class)
			    .click_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
			    .click_scroll_down_from_solution_selector()
                .click_home_in_solution_selector_of_CPM_Prod()
		        .wait_until(10)
			    .select_option_from_userName_dropdown("Logout")
			    .clear_current_session();

	}
	
}
