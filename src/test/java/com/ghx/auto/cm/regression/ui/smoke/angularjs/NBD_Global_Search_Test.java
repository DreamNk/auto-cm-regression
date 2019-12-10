package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Global_Search_Test extends AbstractAutoUITest {
	
	String password  = "test1235!";
	String username = "auto_buyer1@srmc.vdm";
	String company_name = "Will Hospital";
	String rep_name = "Kaustabh";
	String rep_mail_id = "kaustabh@srmc.vm";

	
	@Test(priority=1, groups = {"functional"})                                   //Global company name search
	public void verifyCompanyNameGlobalSearch() {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();
	
		get(AjsNBDRootPage.class)
	  		.global_search_field("Will")
	  		.press_enter()
	  		.verify_search_results_text(company_name);
	}

	@Test(priority=2, groups = {"functional"})                                   //Global rep name search
	public void VerifyRepNameGlobalSearch() {
		
		get(AjsNBDRootPage.class)
	  		.global_search_field("Kaustabh")
	  		.press_enter()
	  		.verify_rep_name_search_results_text(rep_name);
	}
	
	@Test(priority=3, groups = {"functional"})                                   //Global rep mail id search
	public void verifyRepMailIdGlobalSearch() {
		
		get(AjsNBDRootPage.class)
	  		.global_search_field("kaustabh@srmc.vm")
	  		.press_enter()
	  		.verify_rep_mailid_search_results_text(rep_mail_id);
	  		
		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
	}
}
