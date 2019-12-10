package com.ghx.auto.cm.regression.ui.scenario;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class NVD_Login_Test extends AbstractAutoUITest{

	@Test(priority=1, groups = {"functional"})                                         //Invalid_Username
	public void Login_With_Invalid_Username(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")                                                 
			.enter_username("anaida.gillber@")
			.enter_password("gltd123")
			.click_login_button()
			.verify_invalid_username_message("Username is not valid.");
	}
	
	@Test(priority=2, groups = {"functional"})                                         //Invalid_Password
	public void Login_With_Invalid_Password(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("anaida.gillbert@av1.vm")
			.enter_password("gltd")
			.click_login_button()
			.verify_invalid_password_message(" Username or Password is invalid.");
	}
	
	@Test(priority=3, groups = {"functional"})                                         //Login_Successful
	public void Login_Successfull() throws Throwable{
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("anaida.gillbert@av1.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button()
			//.clickUserNameActionDropdown()
			//.clickChangePassword()
			.verify_username("Anaida Gillbert");
		get(CommonUtilities.class)
          .click_log_out_from_NVD();
	}
}	
	
	