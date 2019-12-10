package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Change_Login_Credentials_Tests extends AbstractAutoUITest{
	String NewUsername =  "auto3@numc.vm";
	String ExistingUsername = "auto2@numc.vm";                   //Interchange ExistingUsername and NewUsername  on every run
	
	// Test cases for changing username from NVD.
	
	
	@Test(priority=1, groups = {"functional"})                                        
	public void verify_change_username() throws Throwable{
		
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username(ExistingUsername)
			.enter_password("gltd@123")
			.click_login_button()
			.click_continue_button()
		.wait_until(10)
		.click_username_action_dropdown();
		
		get(NVDRootPage.class)
		.click_change_username()
		.enter_existing_password_to_change_username("gltd@123")
		.enter_new_username(NewUsername)
		.enter_verify_new_username(NewUsername)
		.click_save_username()
		.click_ok_username()
		.wait_until(7);
		
		get(NVDloginPage.class)
		.enter_username(NewUsername)
		.enter_password("gltd@123")
		.click_login_button()
		.click_continue_button()
	    .wait_until(7)
	    .verify_username("auto three");
	
		
	}
	
	
	
	@Test(priority=2, groups = {"functional"})                                        
	public void verify_error_of_wrong_password_in_username_change() throws Throwable{
		
		get(NVDloginPage.class)
		.click_username_action_dropdown();
		
		get(NVDRootPage.class)
		.click_change_username()
		.enter_existing_password_to_change_username("gltd@1123")
		.enter_new_username(ExistingUsername)
		.enter_verify_new_username(ExistingUsername)
		.click_save_username()
		.verify_error_for_wrong_password_to_change_username("Please provide")
		.wait_until(3)
		.click_close_button_of_username_popup();
	
	}


	
	@Test(priority=3, groups = {"functional"})                                         
	public void verify_error_of_same_existing_username_and_new_username() throws Throwable{
		
		get(NVDloginPage.class)
		.click_username_action_dropdown();
		
		get(NVDRootPage.class)
		.click_change_username()
		.enter_existing_password_to_change_username("gltd@123")
		.enter_new_username(NewUsername)
		.enter_verify_new_username(NewUsername)
		.click_save_username()
		.wait_until(3)
		.verify_error_for_same_existing_and_new_username("Existing Username and New")
		.click_close_button_of_username_popup();
	
	}

	
	@Test(priority=4, groups = {"functional"})                                        
	public void verify_error_of_mismatch_in_new_username_and_verify_new_username() throws Throwable{
		
		get(NVDloginPage.class)
		.click_username_action_dropdown();
		
		get(NVDRootPage.class)
		.click_change_username()
		.enter_existing_password_to_change_username("gltd@123")
		.enter_new_username(ExistingUsername)
		.enter_verify_new_username("auto@numc.vm")
		.click_save_username()
		.wait_until(3)
		.verify_error_for_new_username_and_verify_new_username_mismatch("New Username and")
		.click_close_button_of_username_popup();
		
		get(CommonUtilities.class)
		.click_log_out_from_NVD();
		
		
	
	}






// Test cases for changing password from NVD.

	String ExistingPassword = "gltd@123";        //Interchange ExistingPassword and NewPassword  on every run
	String NewPassword = "test@123";	
	
	@Test(priority=5, groups = {"functional"})                                         
public void verify_change_password() throws Throwable{
	
	get(NVDloginPage.class)
		.invokeLoginUrl("baseUrl")
		.enter_username("auto5@numc.vm")
		.enter_password(ExistingPassword)
		.click_login_button()
	.wait_until(5)
	.click_continue_button()
	.click_username_action_dropdown();
	
	get(NVDRootPage.class)
	.click_change_password()
	.enter_existing_password(ExistingPassword)
	.enter_new_password(NewPassword)
	.enter_verify_new_password(NewPassword)
	.click_save_password()
	.wait_until(7)
	.click_ok_password()
	.wait_until(3);
	
	get(NVDloginPage.class)
	.enter_username("auto5@numc.vm")
	.enter_password(NewPassword)
	.click_login_button()
	.click_continue_button()
	.wait_until(5)
	.verify_username("auto five");
	

}
@Test(priority=6, groups = {"functional"})                                         
public void verify_error_for_same_new_and_existing_Password() throws Throwable{
	
	
	get(NVDloginPage.class)
	.click_username_action_dropdown();
	
	get(NVDRootPage.class)
	.click_change_password()
	.enter_existing_password(NewPassword)
	.enter_new_password(NewPassword)
	.enter_verify_new_password(NewPassword)
	.click_save_password()
	.wait_until(3)
	.verify_same_existing_and_new_password_error("Existing Password and New")
	.click_close_button_of_password_popup();
	
}

@Test(priority=7, groups = {"functional"})                                         
public void verify_error_for_different_new_and_verifynew_password() throws Throwable{
	
	get(NVDloginPage.class)
	.click_username_action_dropdown();
	
	get(NVDRootPage.class)
	.click_change_password()
	.enter_existing_password(NewPassword)
	.enter_new_password(ExistingPassword)
	.enter_verify_new_password(NewPassword)
	.click_save_password()
	.wait_until(7)
	.verify_error_for_different_new_and_verifynew_password("New Password and Verify")
	.click_close_button_of_password_popup();
	
}

@Test(priority=8, groups = {"functional"})                                         
public void verify_error_for_password_not_meeting_requirement() throws Throwable{
	
	get(NVDloginPage.class)
	.click_username_action_dropdown();
	
	get(NVDRootPage.class)
	.click_change_password()
	.enter_existing_password(NewPassword)
	.enter_new_password("gltd123")
	.enter_verify_new_password("gltd123")
	.click_save_password()
	.verify_error_for_password_not_meeting_requirement("The password submitted does not")
	.click_close_button_of_password_popup();

    }


@Test(priority=9, groups = {"functional"})                                         
public void verify_error_for_incorrect_existing_password() throws Throwable{
	
	get(NVDloginPage.class)
	.click_username_action_dropdown();
	
	get(NVDRootPage.class)
	.click_change_password()
	.enter_existing_password("gltd123")
	.enter_new_password("test@123")
	.enter_verify_new_password("test@123")
	.click_save_password()
	.verify_error_for_wrong_existing_password("Existing Password is not")
	.click_close_button_of_password_popup();
	
	get(CommonUtilities.class)
	.click_log_out_from_NVD();

    }

}







