package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.cm.ui.page.RMNavigationPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class RM_Navigation_Test extends AbstractAutoUITest {

	String customer_name = "beverly";
	String username = "automation.rm@vendormate.com";
	String password = "gltd@123";
	
	/**
	* Log Into RM Dashboard and check kiosk   
	* beta flag in edit customer page & log out
	*/
	@Test(priority=1, groups = {"functional"})                                         
	public void EnableKioskBetaFlag(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")                                                 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(7);
			
		get(RMNavigationPage.class)	
			.click_edit_customer_link()
			.enter_customer_name(customer_name)
			.click_search_button()
			.wait_until(2)
			.click_edit_button()
			.wait_until(4)
			.enable_kiosk_check_box()
			.click_complete_button()
			.wait_until(3)
			.click_logout_link()
			.wait_until(3);
	}
	
	/**
	* Log Into RM Dashboard and uncheck kiosk   
	* beta flag in edit customer page & log out
	*/
	@Test(priority=2, groups = {"functional"})                                         
	public void DisableKioskBetaFlag(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")                                                 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(7);
			
		get(RMNavigationPage.class)	
			.click_edit_customer_link()
			.enter_customer_name(customer_name)
			.click_search_button()
			.wait_until(2)
			.click_edit_button()
			.wait_until(4)
			.disable_kiosk_check_box()
			.click_complete_button()
			.wait_until(3)
			.click_logout_link();
	}
	
}
	
	
	
	
