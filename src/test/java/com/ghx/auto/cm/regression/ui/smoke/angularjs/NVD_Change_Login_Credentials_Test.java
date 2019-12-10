package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsNVDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Change_Login_Credentials_Test extends AbstractAutoUITest {
	String NewPassword  = "test@123";    //Interchange ExistingPassword and NewPassword  on every run
	String ExistingPassword  = "gltd@123";
	
	String Username = "r49@ucbp1.vm";
	String CurrentUsername = "r48@ucbp1.vm";
	String NewUsername = "r50@ucbp1.vm";
	String username_on_home_page = "rep ts";
	String tooltip_text = "Password Requirement: Must contain at least one letter (a-z or A-Z),";
	String password_not_meeting_requirement_text = "The password submitted does not meet";
	String new_and_verify_new_password_error_text = "New Password and Verify New Password must match.";
	String error_please_provide_a_valid_existing = "Please provide a valid Existing";
	String error_please_provide_a_valid_email = "Please provide a valid email";
	String randomusername = "abc.vm";
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyErrorForPasswordNotMeetingRequirement()  {
		
		get(AjsNVDLoginPage.class)
			.invoke_url() 
			.enter_username(Username)
			.enter_password(ExistingPassword)
			.click_login_button()
		    .wait_until(5)
		    .click_continue_button()
		    .wait_for_element_of_home_page_to_load();
		
		
		get(AjsNVDRootPage.class)
			.click_username_dropdown()
			.wait_until(3)
			.click_change_password()
			.enter_existing_password(ExistingPassword)
			.enter_new_password(ExistingPassword)
			.enter_verify_new_password(ExistingPassword)
			.click_save_password()
			.verify_error_for_password_not_meeting_requirement(password_not_meeting_requirement_text)
			.wait_until(5)
		 	.click_cross_sign_on_change_password_popup()
		 	.wait_until(3);
		
		get(AjsNVDLoginPage.class)
		    .do_log_out_from_NVD();
		  

	    }



	@Test(priority=2, groups = {"functional"})                                         
	public void verifyErrorForDifferentNewAndVerifynewPassword()  {
		
		get(AjsNVDLoginPage.class)
		.invoke_url() 
		.enter_username(Username)
		.enter_password(ExistingPassword)
		.click_login_button()
	    .wait_until(5)
	    .click_continue_button()
	    .wait_for_element_of_home_page_to_load();
		
	    get(AjsNVDRootPage.class)
			.click_username_dropdown()
			.wait_until(3)
			.click_change_password()
			.enter_existing_password(ExistingPassword)
			.enter_new_password(NewPassword)
			.enter_verify_new_password(ExistingPassword)
			.click_save_password()
			.verify_error_for_different_new_and_verifynew_password(new_and_verify_new_password_error_text)
		 	.click_cross_sign_on_change_password_popup();
	    
	    get(AjsNVDLoginPage.class)
		    .do_log_out_from_NVD();
	    
	   }
	
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyChangePassword() {
		
	    get(AjsNVDLoginPage.class)
		    .invoke_url() 
		    .enter_username(Username)
		    .enter_password(ExistingPassword)
		    .click_login_button()
	        .wait_until(5)
	        .click_continue_button()
	        .wait_for_element_of_home_page_to_load();
		
	
		get(AjsNVDRootPage.class)
			.click_username_dropdown()
			.wait_until(3)
			.click_change_password()
			.enter_existing_password(ExistingPassword)
			.enter_new_password(NewPassword)
			.enter_verify_new_password(NewPassword)
			.click_save_password()
			.click_ok_password()
			.wait_for_login_page_to_load();
			
		
		get(AjsNVDLoginPage.class)
			.enter_username(Username)
			.enter_password(NewPassword)
			.click_login_button()
			.wait_until(7)
			.verify_username(username_on_home_page);
		
		get(AjsNVDLoginPage.class)
			.do_log_out_from_NVD();

}
 
	//Change Username
	
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyErrorOfExistingPassword() {
		
	    get(AjsNVDLoginPage.class)
		    .invoke_url() 
		    .enter_username(CurrentUsername)
		    .enter_password(ExistingPassword)
		    .click_login_button()
	        .wait_until(5)
	        .click_continue_button()
	        .wait_for_element_of_home_page_to_load();
	    
	    get(AjsNVDRootPage.class)
	       .click_username_dropdown()
	       .click_change_username()
	       .wait_until(3)
	       .enter_existing_password_to_change_username(ExistingPassword)
	       .enter_new_username(NewUsername)
	       .enter_verify_new_username(NewUsername)
	       .click_save_username()
	       .wait_until(3)
	       .verify_error_for_wrong_existing_password_while_changing_username(error_please_provide_a_valid_existing)
	       .wait_until(3)
	       .click_cancel_button_on_change_username();
	    
	    get(AjsNVDLoginPage.class)
		.do_log_out_from_NVD();
	    
	}	    
	    
	    
	    @Test(priority=5, groups = {"functional"})                                         
		public void verifyChangeUsernamePassingInvalidUsername() {
			
		    get(AjsNVDLoginPage.class)
			    .invoke_url() 
			    .enter_username(CurrentUsername)
		        .enter_password(ExistingPassword)
			    .click_login_button()
		        .wait_until(5)
		        .click_continue_button()
		        .wait_for_element_of_home_page_to_load();
		    
		    get(AjsNVDRootPage.class)
		       .click_username_dropdown()
		       .click_change_username()
		       .wait_until(3)
		       .enter_existing_password_to_change_username(ExistingPassword)
		       .enter_new_username(randomusername)
		       .enter_verify_new_username(randomusername)
		       .click_save_username()
		       .wait_until(3)
		       .verify_error_for_invalid_username(error_please_provide_a_valid_email)
		       .click_cancel_button_on_change_username();
	    
	        get(AjsNVDLoginPage.class)
		       .do_log_out_from_NVD();
     }
	    
	    @Test(priority=6, groups = {"functional"})                                         
		public void verifyChangeUsernameHappyPath() {
			
		    get(AjsNVDLoginPage.class)
			    .invoke_url() 
			    .enter_username(CurrentUsername)
		        .enter_password(ExistingPassword)
			    .click_login_button()
		        .wait_until(5)
		        .click_continue_button()
		        .wait_for_element_of_home_page_to_load();
		    
		    get(AjsNVDRootPage.class)
		       .click_username_dropdown()
		       .click_change_username()
		       .wait_until(3)
		       .enter_existing_password_to_change_username(ExistingPassword)
		       .enter_new_username(NewUsername)
		       .enter_verify_new_username(NewUsername)
		       .click_save_username()
		       .wait_until(3)
		       .click_ok_button_on_change_username()
		       .wait_until(5);
		    
		    get(AjsNVDLoginPage.class)
		       .invoke_url() 
		       .enter_username(CurrentUsername)
	           .enter_password(ExistingPassword)
		       .click_login_button()
	           .wait_until(5)
	           .click_continue_button()
	           .wait_for_element_of_home_page_to_load();
		       
	    
		    get(AjsNVDLoginPage.class)
		       .do_log_out_from_NVD();
  }
	    
	    
}
