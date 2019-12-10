package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDResetPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

       
public class NVD_Reset_Password_Test extends AbstractAutoUITest{

	String username = "r17@ucbp1.vm";
	String existing_password = "gltd123";      //This password is not the actual login password
    String new_password = "test@123";
    String random_password = "test123!";
    String invalid_existing_password_error_msg = "Existing password is not correct.";
    String password_requirement_instruction_msg = "Password Requirement: Must contain at least one letter (a-z or A-Z), one special character (!, @, $, ^, *, (, ) ,_, ~, ?), at least one number (0-9) and be 8 characters long.";
    String new_password_error_msg = "New Password and Verify New Password must match.";
	

	@Test(priority=1, groups = "functional")                                         
	public void VerifyErrorMessagesOnResetPasswordPage(){              //new password & verify new Password not matching error messages
		
		get(AjsNVDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
			.wait_until(4);
		
		get(AjsNVDResetPasswordPage.class)
		    .enter_existing_password(existing_password)
		    .enter_new_password(new_password)
		    .enter_verify_new_password(new_password)
		    .click_reset_button();
		  //  .verify_invalid_existing_password_error_msg(invalid_existing_password_error_msg);
		    
}
	
	@Test(priority=2, groups = "functional")                                         
	public void VerifyPasswordRequirementInstructionMessage(){         
		
		get(AjsNVDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
			.wait_until(4);
		
		get(AjsNVDResetPasswordPage.class)
		    .verify_password_requirement_instruction_msg(password_requirement_instruction_msg);
	
}
	
	@Test(priority=3, groups = "functional")                                         
	public void VerifyConfirmNewPasswordErrorMessage(){
		
		get(AjsNVDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username(username)
			.enter_password(existing_password)
			.click_login_button()
			.wait_until(4);
		
		get(AjsNVDResetPasswordPage.class)
		    .enter_existing_password(existing_password)
		    .enter_new_password(new_password)
		    .enter_verify_new_password(random_password)
		    .verify_new_password_error_msg(new_password_error_msg);
   

	}
}	
