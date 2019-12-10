package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCPMLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.LoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Login_Tests  extends AbstractAutoUITest{

	@Test(priority=1, groups = {"functional"})                                         
	public void Login_With_Invalid_Username(){
		
		get(AjsCPMLoginPage.class)
			.invoke_url()                                                 
			.enter_username("anamika*!@venom")
			.enter_password("gltd123")
			.click_login_button()
			.verify_invalid_username_message("Username is not valid.");
	}
	
	@Test(priority=2, groups = {"functional"})                                         
	public void Login_With_Invalid_Password(){
		
		get(AjsCPMLoginPage.class)
			.invoke_url() 
			.enter_username("anamika*!@vendormate.com")
			.enter_password("gltd")
			.click_login_button()
			.verify_invalid_password_message(" 						Username or Password is invalid.");
	}
	
	@Test(priority=3, groups = {"functional"})                                         
	public void Login_Successful() {
		
		get(AjsCPMLoginPage.class)
			.invoke_url() 
			.enter_username("anamika*!@vendormate.com")
			.enter_password("gltd123")
			.click_continue_button()
			.verify_username(" Anamika Dutta");
		
	}
	
}	