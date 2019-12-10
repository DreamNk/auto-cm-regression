package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCPMLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsCPMResetPasswordPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsKioskLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsKioskResetPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Kiosk_Reset_Password_Test extends AbstractAutoUITest{
	

	@Test(priority=1, groups = "functional")                                         
	public void VerifyErrorMessagesOnResetPasswordPage(){              //Existing password, new password & verify new Password error messages
		
		get(AjsKioskLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username("autoreset_buyer@mhc.vdm")
			.enter_password("gltd@123")
			.click_login_button()
			.wait_until(4);
		
		get(AjsKioskResetPasswordPage.class)
		    .click_reset_button()
		    .verify_invalid_exisisting_password_error_msg("Please provide a valid Existing Password.")
		    .verify_minimum_password_requirement_error_msg_in_new_password("The password submitted does not meet the minimum password requirements detailed above.");
		    
}
	
	@Test(priority=2, groups = "functional")                                         
	public void VerifyPasswordRequirementInstructionMessage(){         
		
		get(AjsKioskLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username("autoreset_buyer@mhc.vdm")
			.enter_password("gltd@123")
			.click_login_button()
			.wait_until(4);
		
		get(AjsKioskResetPasswordPage.class)
		    .verify_password_requirement_instruction_msg("Password Requirement: Must contain at least one letter (a-z or A-Z), one special character (!, @, $, ^, *, (, ) ,_, ~, ?), at least one number (0-9) and be 8 characters long.");
	
}
	
	@Test(priority=3, groups = "functional")                                         
	public void VerifyConfirmNewPasswordErrorMessage(){
		
		get(AjsKioskLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(5)
			.enter_username("autoreset_buyer@mhc.vdm")
			.enter_password("gltd@123")
			.click_login_button()
			.wait_until(4);
		
		get(AjsKioskResetPasswordPage.class)
		    .enter_existing_password("gltd@123")
		    .enter_new_password("gltd123!")
		    .verify_new_password_error_msg("New Password and Verify New Password must match.");
}
	
}
	
	
	


