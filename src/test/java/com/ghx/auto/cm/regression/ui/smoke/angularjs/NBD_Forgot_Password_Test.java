package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDForgotPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Forgot_Password_Test extends AbstractAutoUITest {
	
	String email_address = "auto_buyer5@srmc.vdm";
	String email_not_in_system = "autobuyer3@srmc.vdm";
	String invalid_email_id = "abcde.com";
	String error_msg_for_invalid_email = "Please provide a valid email address.";
	String error_msg_for_blank_email = "Email Address should not be blank.";
	String error_of_emailid_not_in_system = "We can't find this email";
	
	@Test(priority=1, groups = "functional")                                         
	public void verifyForgotPasswordPopUp() {

	   get(AjsNBDForgotPasswordPage.class)
	       .invoke_url()
	       .wait_for_login_page_to_load()
	       .click_forgot_password_link()
	       .verify_header_of_forgot_password_popup("Forgot your password?")
	       .click_cancel_button();
	} 
	
    @Test(priority=2, groups = "functional")                                         
	public void verifyTheCancelButtonOfPopUp() {
    
    	get(AjsNBDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .click_cancel_button();
    }
    
    @Test(priority=3, groups = "functional")                                         
   	public void verifyTheErrorWhenUseridFieldIsBlank() {
    	
    	get(AjsNBDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .enter_email_address("")
    	    .click_send_button()
    	    .verify_error_msg_for_blank_email(error_msg_for_blank_email)
    	    .click_cancel_button();
    }
    	
    @Test(priority=4, groups = "functional")                                         
   	public void verifyTheErrorForInvalidUserid() {
    	
    	get(AjsNBDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .enter_email_address(invalid_email_id)
    	    .click_send_button()
    	    .verify_error_msg_for_invalid_email(error_msg_for_invalid_email)
    	    .click_cancel_button();
    }	
    	
    @Test(priority=5, groups = "functional")                                         
       	public void verifyTheForgotPasswordHappyPath() {	
    
    	get(AjsNBDForgotPasswordPage.class)
    	     .click_forgot_password_link()
    	     .enter_email_address(email_address)
    	     .click_send_button()
    	     .verify_text_of_email_sent_successfully("Email sent successfully.")
    	     .click_ok_button();
    }
    	
    	@Test(priority=6, groups = "functional")                                         
       	public void verifyTheForgotPasswordFunctionalityForUserNotInSystem() {
    		
    	get(AjsNBDForgotPasswordPage.class)
    		 .click_forgot_password_link()
    		 .enter_email_address(email_not_in_system)
        	 .click_send_button()
    	     .verify_error_of_emailid_not_in_system(error_of_emailid_not_in_system)
    		 .click_cancel_button();
    }

    	@Test(priority=7, groups = "functional")                                         
       	public void verifyTheCancelButtonOnEmailSuccessPopup() {
    		
    	get(AjsNBDForgotPasswordPage.class)
   	         .click_forgot_password_link()
   	         .enter_email_address(email_address)
   	         .click_send_button()
   	         .verify_text_of_email_sent_successfully("Email sent successfully.")
   	         .click_cancel_button_on_success_popup();
   	     
   }
}
