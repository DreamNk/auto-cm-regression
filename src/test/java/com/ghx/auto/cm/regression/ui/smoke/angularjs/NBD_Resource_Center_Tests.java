package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;


import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDResourceCenterPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Resource_Center_Tests extends AbstractAutoUITest {

	String Username = "auto_buyer1@srmc.vdm";
	String Password = "test1235!";
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyGlobalAdminResource(){
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(Username)
			.enter_password(Password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();
		
		
		get(AjsNBDResourceCenterPage.class)
			.click_resources_center_tab()
			.wait_until(5)
			.verify_if_resource_is_present_on_the_grid("Auto - Global Admin' Resource")
			.wait_until(10);
			
	}

	@Test(priority=2, groups = {"functional"})                                         
	public void verifyCustomerAdminResource(){
		
		get(AjsNBDResourceCenterPage.class, focus_on_parent_window())
			.click_customer_admin_resources_accordion()
			.wait_until(5)
			.verify_if_resource_is_present_on_the_grid("Auto - SRMC Admin Resource")
			.wait_until(10);
		
	}

	@Test(priority=3, groups = {"functional"})                                         
	public void verifyCusBuyerResource(){
		
		get(AjsNBDResourceCenterPage.class, focus_on_parent_window())
			.click_customerr_user_resources_accordion()
			.wait_until(5)
			.verify_if_resource_is_present_on_the_grid("Auto - SRMC User Resource")
			.wait_until(10);
	}
		
		
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyGlobalUserResource(){
		
		get(AjsNBDResourceCenterPage.class, focus_on_parent_window())
			.click_global_user_resources_accordion()
			.wait_until(5)
			.verify_if_resource_is_present_on_the_grid("Auto - Global Buyer Resource")
			.wait_until(10);	
	}

	@Test(priority=5, groups = {"functional"})                                         
	public void verifyDownloadAllPolicies(){
		
		get(AjsNBDResourceCenterPage.class, focus_on_parent_window())
			.click_health_system_policies_accordion()
			.select_health_system("Sachin Acknowledgement")
			.click_download_all_policies();
		
        get(AjsCommonUtilities.class)
        	.saveFile();
   
   }
	
	@Test(priority=6, groups = {"functional"})                                         
	public void verifyViewSinglePolicy(){
		
		get(AjsNBDResourceCenterPage.class, focus_on_parent_window())
			.click_resources_center_tab()
			.click_health_system_policies_accordion()
			.select_health_system("T-AD-(contract 12 month)")
			.click_view_single_policy()
			.wait_until(5);
		
        get(AjsCommonUtilities.class)
        	.saveFile();
   
		get(AjsNBDResourceCenterPage.class,focus_on_parent_window());

		get(AjsCommonUtilities.class)
		   .do_log_out_from_NBD();
  }
	
}
	


