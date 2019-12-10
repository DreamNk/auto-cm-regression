package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDResourceCenterTab;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;



public class NVD_Resource_Center_Tab_Tests extends AbstractAutoUITest{
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyVendormateRepResource(){
		
		get(NVDloginPage.class)
		.invokeLoginUrl("baseUrl")
		.enter_username("anaida.gillbert@av1.vm")
		.enter_password("gltd123")
		.click_login_button()
		.click_continue_button()
		.wait_until(10);
		
		
		get(NVDResourceCenterTab.class)
		.click_resources_center_tab()
		.verify_if_resource_is_present_on_the_grid("Scanned PDF")
        .wait_until(5);
			
	}

	@Test(priority=2, groups = {"functional"})                                         
	public void verifyVendorAdminResource(){
		
		get(NVDResourceCenterTab.class, focus_on_parent_window())
		.click_vendor_admin_resources_accordion()
		.verify_if_resource_is_present_on_the_grid("Auto - Vendor Admin resource")
		.wait_until(5);
		
	}

	@Test(priority=3, groups = {"functional"})                                         
	public void verifyVendorRepResource(){
		
		get(NVDResourceCenterTab.class, focus_on_parent_window())
		.click_vendor_rep_resources_accordion()
		.verify_if_resource_is_present_on_the_grid("Auto - Vendor Rep resource")
		.wait_until(5);
	}
		
		
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyVendormateAdminResource(){
		
		get(NVDResourceCenterTab.class, focus_on_parent_window())
		.click_vendormate_admin_resources_accordion()
		.verify_if_resource_is_present_on_the_grid("Global Admin Resource 629")
		.wait_until(5);	
	}

	@Test(priority=5, groups = {"functional"})                                         
	public void verifyHealthSystemAccordion(){
		get(NVDResourceCenterTab.class, focus_on_parent_window())
		.click_health_system_policies_library_accordion()
		.select_health_system("Adventist Health System")
		.click_download_all_policies();
		
        get(CommonUtilities.class)
        .saveFile();
   
		get(NVDResourceCenterTab.class,focus_on_parent_window());

	get(CommonUtilities.class)
	.click_log_out_from_NVD();
  }
}
	
