package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Company_Logo_Transactions_Tests extends AbstractAutoUITest {
	
	@Test(priority=1, groups = {"functional"})                                
	public void addCompanyLogo() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
			.click_company_logo_accordion()
			.click_company_logo_edit_button()
			.click_company_logo_browse_button()
			.browse_file("D:\\AutomationFiles\\cm\\teslalogo1.jpg")
			.wait_until(10)
			.click_company_logo_save_button()
	    	.wait_until(10)
	    	.click_company_logo_edit_button()
	    	.wait_until(10)
	    	.verify_company_logo_file_name("File Name:  teslalogo1.jpg");
	    	    
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);

	}
	
	@Test(priority=2, groups = {"functional"})                                
	public void updateCompanyLogo() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
			.click_company_logo_accordion()
			.click_company_logo_edit_button()
			.verify_company_logo_file_name("File Name:  teslalogo1.jpg")
			.click_company_logo_browse_button()
			.browse_file("D:\\Automation Files\\cm\\teslalogo2.jpg")
			.wait_until(10)
			.click_company_logo_save_button()
	    	.wait_until(10)
	    	.click_company_logo_edit_button()
	    	.wait_until(10)
	    	.verify_company_logo_file_name("File Name:  teslalogo2.jpg");
	    	    
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);

	}
	
	@Test(priority=3, groups = {"functional"})                                
	public void deleteCompanyLogo() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
			.click_company_logo_accordion()
			.click_company_logo_edit_button()
			.verify_company_logo_file_name("File Name:  teslalogo2.jpg")
			.click_company_logo_delete_button()
			.click_company_logo_delete_popup_yes_button()
			.wait_until(10)
			.click_company_logo_edit_button()
	    	.verify_company_logo_not_present("File Name:  teslalogo2.jpg");
	    	    
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);

	}
}
