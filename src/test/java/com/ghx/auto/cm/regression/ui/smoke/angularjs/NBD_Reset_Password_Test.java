package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsCPMResetPasswordPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Reset_Password_Test extends AbstractAutoUITest {
	
	String username = "autoreset_buyer@srmc.vdm";
	String passowrd = "test1234!";
	String Existing_Password = "test1234!";
	String New_Password = "gltd@123";
	String invalid_exisisting_password_error_msg = "Please provide a valid Existing Password.";
	String minimum_password_requirement_error_msg_in_new_password = "The password submitted does not meet the minimum password requirements detailed above.";
	String password_is_required_error_msg = "Verify password is required";
	String password_requirement_instruction_msg = "Password Requirement: Must contain at least one letter (a-z or A-Z), one special character (!, @, $, ^, *, (, ) ,_, ~, ?), at least one number (0-9) and be 8 characters long.";
	String new_password_error_msg = "New Password and Verify New Password must match.";
	
	@Test(priority=1, groups = "functional")                                         
	public void verifyErrorMessagesOnResetPasswordPage(){              //Existing password, new password & verify new Password error messages
		
		get(AjsNBDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(username)
			.enter_password(passowrd)
			.click_login_button()
			.wait_until(4);
		
		get(AjsCPMResetPasswordPage.class)
		    .click_reset_button()
		    .verify_invalid_exisisting_password_error_msg(invalid_exisisting_password_error_msg)
		    .verify_minimum_password_requirement_error_msg_in_new_password(minimum_password_requirement_error_msg_in_new_password)
		    .verify_password_is_required_error_msg(password_is_required_error_msg);
		    
}
	
	@Test(priority=2, groups = "functional")                                         
	public void verifyPasswordRequirementInstructionMessage(){         
		
		get(AjsNBDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(username)
			.enter_password(passowrd)
			.click_login_button()
			.wait_until(4);
		
		get(AjsCPMResetPasswordPage.class)
		    .verify_password_requirement_instruction_msg(password_requirement_instruction_msg);
	
}
	
	@Test(priority=3, groups = "functional")                                         
	public void verifyConfirmNewPasswordErrorMessage(){
		
		get(AjsNBDLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(username)
			.enter_password(passowrd)
			.click_login_button()
			.wait_until(4);
		
		get(AjsCPMResetPasswordPage.class)
		    .enter_existing_password(Existing_Password)
		    .enter_new_password(New_Password)
		    .verify_new_password_error_msg(new_password_error_msg);
}
	
}


