package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDPrivacyPolicyPage;
import com.ghx.auto.cm.ui.sso.page.NBDCustomerCarePage;
import com.ghx.auto.cm.ui.sso.page.NBDTermsOfUsePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Footer_Test extends AbstractAutoUITest{
	
	String buyerId = "wayne.admin@vendormate.com";
	String buyerPassword = "Gltd124!";
	String repUserId= "repone@aurora.vm";
	String repPassword= "Gltd@125";
	
	@Test(priority=1, groups={"functional"})
	public void NBDFooterChecks(){
		
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")                                           
			.enter_username(buyerId)
			.enter_password(buyerPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5);
		get(NBDTermsOfUsePage.class)
			.click_terms_of_use_link();
		get(NBDTermsOfUsePage.class,focus_on_popup_window())	
			.verify_terms_of_use_text();
			focus_on_popup_window().close();
		get(NBDPrivacyPolicyPage.class,focus_on_parent_window())
			.wait_until(3)
			.click_privacy_policy_link()
			.wait_until(3);
		get(NBDPrivacyPolicyPage.class,focus_on_popup_window())
			.verify_privacy_policy_text();
			focus_on_popup_window().close();
		get(NBDCustomerCarePage.class,focus_on_parent_window())
			.wait_until(3)
			.click_customer_care_link();
		get(NBDCustomerCarePage.class,focus_on_popup_window())
			.verify_customer_care_text()
			.verify_contact_name_text("Wayne Admin")
			.verify_support_company_text("Wayne Healthcare")
			.verify_support_email_text("wayne.admin@vendormate.com");
		 	focus_on_popup_window().close();
		get(SSOCommonUtilities.class,focus_on_parent_window())
			.click_tv_icon()
			.click_close_system_status_button();
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("Logout");
	}

	@Test(priority=2, groups={"functional"})
	public void NVDFooterChecks(){
		
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")                                           
			.enter_username(repUserId)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5);
		get(NBDTermsOfUsePage.class)
			.click_terms_of_use_link();
		get(NBDTermsOfUsePage.class,focus_on_popup_window())	
			.verify_terms_of_use_text();
			focus_on_popup_window().close();
		get(NBDPrivacyPolicyPage.class,focus_on_parent_window())
			.wait_until(3)
			.click_privacy_policy_link();
		get(NBDPrivacyPolicyPage.class,focus_on_popup_window())
			.verify_privacy_policy_text();
			focus_on_popup_window().close();
		get(NBDCustomerCarePage.class,focus_on_parent_window())
			.wait_until(3)
			.click_customer_care_link();
		get(NBDCustomerCarePage.class,focus_on_popup_window())
			.wait_until(1)
			.verify_customer_care_text()
			.verify_contact_name_text("rep one")
			.verify_support_company_text("Aurora Healthcare Resources Inc")
			.verify_support_email_text("repone@aurora.vm");
		 	focus_on_popup_window().close();
		get(SSOCommonUtilities.class,focus_on_parent_window())
			.click_tv_icon()
			.click_close_system_status_button();
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("Logout");
	}

}
