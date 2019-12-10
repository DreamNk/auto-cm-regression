package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDUnpaidVendorsPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Unpaid_Vendors_Test extends AbstractAutoUITest {
	String Password  = "test1235!";
	String Username = "auto_buyer1@srmc.vdm";
			
	@Test(priority=1, groups = {"functional"})                                   //verify first name on unpaid vendors page
	public void verifyFirstName() {
		
		get(AjsNBDLoginPage.class)
				.invoke_url() 
				.enter_username(Username)
				.enter_password(Password)
				.click_login_button()
				.wait_until(5)
				.click_continue_button()
				.wait_until(5)
				.wait_for_post_login_page_to_load();
				
		get(AjsNBDUnpaidVendorsPage.class)	
				.click_unpaid_vendors()
				.verify_unpaid_vendors_header_text("Reps of Unpaid Vendors")
				.enter_first_name_in_filter_field("Ramesh")
				.press_enter() 
				.verify_first_name_text("Ramesh")
				.wait_until(5)
				.click_clear_link();
}
			
	@Test(priority=2, groups = {"functional"})                                   //verify last name on unpaid vendors page
	public void verifyLastName() {
								
		get(AjsNBDUnpaidVendorsPage.class)
				.wait_until(5)
				.enter_last_name_in_filter_field("Aggarwal")
				.press_enter() 
				.verify_last_name_text("Aggarwal")
				.wait_until(5)
				.click_clear_link();
}
			
	@Test(priority=3, groups = {"functional"})                                   //verify company name on unpaid vendors page
	public void verifyCompanyName() {
								
		get(AjsNBDUnpaidVendorsPage.class)
				.wait_until(5)
				.enter_company_name_in_filter_field("909 Hospital")
				.press_enter() 
				.verify_company_name_text("909 Hospital")
				.click_clear_link();
				
		get(AjsCommonUtilities.class)
				.do_log_out_from_NBD();
}
}
			
