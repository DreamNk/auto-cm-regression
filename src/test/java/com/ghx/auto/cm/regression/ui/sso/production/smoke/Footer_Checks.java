package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDPrivacyPolicyPage;
import com.ghx.auto.cm.ui.sso.page.NBDCustomerCarePage;
import com.ghx.auto.cm.ui.sso.page.NBDTermsOfUsePage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Footer_Checks extends AbstractAutoUITest{
	
	String contactName="Meeta Buyer";
	String companyName="Vendormate Partners";
	String buyerUserName="meeta.buyer@gmail.com";
	String buyerPassword = null;
	String repUserName="oliva.maddison@gmail.com";
	String repPassword = null;
	String repName = "Oliva Maddison";
	String repCompanyName="Billing and Collections Company";
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
	
	@Test(priority=1, groups={"functional"})
	public void NBDFooterChecks() throws IOException{
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl")                                           
			.enter_username(buyerUserName);
		buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserName);
			  get(SSOLoginPage.class)
			.enter_password(buyerPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.wait_until(5)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);
		get(NBDTermsOfUsePage.class)
			.wait_until(5)
			.click_terms_of_use_link();
		get(NBDTermsOfUsePage.class,focus_on_popup_window())	
			.wait_until(3)
			.verify_terms_of_use_text();
			focus_on_popup_window().close();
		get(NBDPrivacyPolicyPage.class,focus_on_parent_window())	
			.wait_until(3)
			.click_privacy_policy_link();
		get(NBDPrivacyPolicyPage.class,focus_on_popup_window())
			.wait_until(3)
			.verify_privacy_policy_text();
			focus_on_popup_window().close();
		get(NBDCustomerCarePage.class,focus_on_parent_window())
			.click_customer_care_link();
		get(NBDCustomerCarePage.class,focus_on_popup_window())
			.wait_until(3)
			.verify_customer_care_text()
			.verify_contact_name_text(contactName)
			.verify_support_company_text(companyName)
			.verify_support_email_text(buyerUserName);
		 	focus_on_popup_window().close();
		get(SSOCommonUtilities.class,focus_on_parent_window())
			.click_tv_icon()
			.click_close_system_status_button();
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();
	}


	@Test(priority=2, groups={"functional"})
	public void NVDFooterChecks() throws IOException{
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl")                                           
			.enter_username(repUserName);
			repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repUserName);
			  get(SSOLoginPage.class)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.wait_until(5)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(20);
		get(NBDTermsOfUsePage.class)
			.wait_until(5)
			.click_terms_of_use_link();
		get(NBDTermsOfUsePage.class,focus_on_popup_window())	
			.wait_until(3)
			.verify_terms_of_use_text();
			focus_on_popup_window().close();
		get(NBDPrivacyPolicyPage.class,focus_on_parent_window())	
			.wait_until(3)
			.click_privacy_policy_link();
		get(NBDPrivacyPolicyPage.class,focus_on_popup_window())
			.wait_until(3)
			.verify_privacy_policy_text();
			focus_on_popup_window().close();
		get(NBDCustomerCarePage.class,focus_on_parent_window())
			.click_customer_care_link();
		get(NBDCustomerCarePage.class,focus_on_popup_window())
			.wait_until(3)
			.verify_customer_care_text()
			.verify_contact_name_text(repName)
			.verify_support_company_text(repCompanyName)
			.verify_support_email_text(repUserName);
		 	focus_on_popup_window().close();
		get(SSOCommonUtilities.class,focus_on_parent_window())
			.click_tv_icon()
			.click_close_system_status_button();
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();
	}

}
