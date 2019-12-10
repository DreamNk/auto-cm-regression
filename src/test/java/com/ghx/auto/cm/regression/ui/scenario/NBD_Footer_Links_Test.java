package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDPrivacyPolicyPage;
import com.ghx.auto.cm.ui.page.NBDTermsOfUsePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Footer_Links_Test extends AbstractAutoUITest {
	
	@Test(priority=1, groups = {"functional"})                                   //Privacy Policy
	public void VerifyPrivacyPolicy() throws Throwable{
		 get(NBDLogin.class)
	     .invoke_loginurl("baseUrl")
	     .enter_username("auto_buyer1@beverly.vdm")
	     .enter_password("gltd123")
	     .click_login_button()
	     .click_continue_button(); 
	  get(NBDPrivacyPolicyPage.class, focus_on_parent_window())
	  	.click_privacy_policy();
	  get(NBDPrivacyPolicyPage.class, focus_on_popup_window())
	    .verify_policy_text("VENDORMATE PRIVACY POLICY");
	  	focus_on_popup_window().close();
	}
	
	@Test(priority=2, groups = {"functional"})                                   //Terms of Use
	public void VerifyTermsofUse() throws Throwable{
	  get(NBDTermsOfUsePage.class, focus_on_parent_window())
	  	.click_terms_of_use_link();
	  get(NBDTermsOfUsePage.class, focus_on_popup_window())
	    .verify_terms_of_use_text("VENDORMATE TERMS OF USE");
	  focus_on_popup_window().close();
	  focus_on_parent_window();
	  get(CommonUtilities.class)
		.do_log_out_from_NBD();
	}

}
