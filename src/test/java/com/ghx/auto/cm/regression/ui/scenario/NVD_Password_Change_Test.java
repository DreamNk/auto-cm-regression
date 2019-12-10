package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Password_Change_Test extends AbstractAutoUITest{
	String ExistingPassword = "gltd@123"; 						//Interchange ExistingPassword and NewPassword  on every run
	String NewPassword = "test@123";                                                   

	@Test(priority=1, groups = {"functional"})                                         
	public void verify_change_password() throws Throwable{
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("auto2@numc.vm")
			.enter_password(ExistingPassword)
			.click_login_button()
		.wait_until(10)
		.click_username_action_dropdown();
		get(NVDRootPage.class)
		.click_change_password()
		.enter_existing_password(ExistingPassword)
		.enter_new_password(NewPassword)
		.enter_verify_new_password(NewPassword)
		.click_save_password()
		.wait_until(7)
		.click_ok_password()
		.wait_until(7);
		get(NVDloginPage.class)
		.enter_username("auto1@numc.vm")
		.enter_password(NewPassword)
		.click_login_button()
		.wait_until(7)
		.verify_username("auto one");
		

}
	@Test(priority=2, groups = {"functional"})                                         
	public void verify_invalid_new_Password() throws Throwable{
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("auto2@numc.vm")
			.enter_password(NewPassword)
			.click_login_button()
		.wait_until(10)
		.click_username_action_dropdown();
		get(NVDRootPage.class)
		.click_change_password()
		.enter_existing_password(NewPassword)
		.enter_new_password(NewPassword)
		.enter_verify_new_password(NewPassword)
		.click_save_password()
		.wait_until(7)
		.verify_same_existing_and_new_password_error("Existing Password and New");
		
	}
	
	@Test(priority=3, groups = {"functional"})                                         
	public void verify_different_new_verifynew_field_password_() throws Throwable{
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("auto2@numc.vm")
			.enter_password(NewPassword)
			.click_login_button()
		.wait_until(10)
		.click_username_action_dropdown();
		get(NVDRootPage.class)
		.click_change_password()
		.enter_existing_password(NewPassword)
		.enter_new_password(ExistingPassword)
		.enter_verify_new_password(NewPassword)
		.click_save_password()
		.wait_until(7)
		.verify_error_for_different_new_and_verifynew_password("New Password and Verify");
		
	}
	
	}