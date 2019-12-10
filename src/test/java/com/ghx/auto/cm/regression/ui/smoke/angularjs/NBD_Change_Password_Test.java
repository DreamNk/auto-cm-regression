package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Change_Password_Test extends AbstractAutoUITest {
	
	String new_password  = "gltd@1235";    //Interchange ExistingPassword and NewPassword  on every run
	String existing_password  = "test1234!";
	
	String username = "auto_buyer4@srmc.vdm";
	String username_on_home_page = "Robin Hood";
	String tooltip_text = "Password Requirement: Must contain at least one letter (a-z or A-Z),";
	String password_not_meeting_requirement_text = "The password submitted does not meet";
	String new_and_verify_new_password_error_text = "New Password and Verify New Password must match.";
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyErrorForPasswordNotMeetingRequirement()  {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
		    .wait_until(5)
		    .click_continue_button()
		    .wait_until(5)
		    .wait_for_post_login_page_to_load();
		
		get(AjsNBDRootPage.class)
			.click_username_dropdown()
			.wait_until(5)
			.click_change_password()
			.wait_until(10)
			.verify_tooltip_text(tooltip_text)
			.enter_existing_password(new_password)
			.enter_new_password("gltd123")
			.enter_verify_new_password("gltd123")
			.click_save_password()
			.verify_error_for_password_not_meeting_requirement(password_not_meeting_requirement_text)
		 	.click_cross_sign_on_change_apssword_popup()
			.wait_until(5);

		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
    }


	@Test(priority=2, groups = {"functional"})                                         
	public void verifyErrorForDifferentNewAndVerifynewPassword()  {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
		    .wait_until(5)
			.wait_for_post_login_page_to_load();
		
		get(AjsNBDRootPage.class)
			.click_username_dropdown()
			.wait_until(5)
			.click_change_password()
			.enter_existing_password(new_password)
			.enter_new_password(existing_password)
			.enter_verify_new_password(new_password)
			.click_save_password()
			.verify_error_for_different_new_and_verifynew_password(new_and_verify_new_password_error_text)
		 	.click_cross_sign_on_change_apssword_popup()
			.wait_until(5);

		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
    }
	
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyChangePassword() {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
		    .wait_until(5)
			.wait_for_post_login_page_to_load();
		
		get(AjsNBDRootPage.class)
			.click_username_dropdown()
			.click_change_password()
			.enter_existing_password(existing_password)
			.enter_new_password(new_password)
			.enter_verify_new_password(new_password)
			.click_save_password()
			.click_ok_password();
		
		get(AjsNBDLoginPage.class)
			.enter_username(username)
			.enter_password(new_password)
			.click_login_button()
			.wait_until(7)
			.click_continue_button()
		    .wait_until(5)
			.verify_username(username_on_home_page)
			.wait_until(5);
		
		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
	}
}


