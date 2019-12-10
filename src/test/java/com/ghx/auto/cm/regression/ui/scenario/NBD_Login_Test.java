package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Login_Test extends AbstractAutoUITest{

	@Test(priority=1, groups = {"functional"})                                         //Invalid_Username
	public void loginWithInvalidUsername(){
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("auto_buyer1@")
			.enter_password("test1235!")
			.click_login_button()
			.verify_invalid_username_message("Username is not valid.");
	}
	
	@Test(priority=2, groups = {"functional"})                                         //Invalid_Password
	public void loginWithInvalidPassword(){
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
			.enter_username("auto_buyer1@beverly.vdm")
			.enter_password("test")
			.click_login_button()
			.verify_invalid_password_message(" Username or Password is invalid.");
	}
	
	@Test(priority=3, groups = {"functional"})   										// valid username and log out
	public void loginWithValidUsername(){
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")                                                 
			.enter_username("auto_buyer1@beverly.vdm")
			.enter_password("test1235!")
			.click_login_button()
		    .click_continue_button()
		    .verify_username("Alfred Pitt");
		get(CommonUtilities.class)
			.do_log_out_from_NBD();
	}
	
	
}
