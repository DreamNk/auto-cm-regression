package com.ghx.auto.cm.regression.ui.smoke.angularjs;


import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDForgotPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Forgot_Password_Test extends AbstractAutoUITest {
	
	String header_of_forgot_password_popup = "Forgot your password?";
	String error_msg_for_blank_email = "Email Address should not be blank.";
	String error_msg_for_invalid_email = "Please provide a valid email address.";
	String text_of_email_sent_successfully = "Email sent successfully.";
	String error_of_emailid_not_in_system = "We can't find this email";
	
	@Test(priority=1, groups = "functional")                                         
	public void verify_forgot_password_pop_up() {

	   get(AjsNVDForgotPasswordPage.class)
	       .invoke_url()
	       .wait_for_login_page_to_load()
	       .click_forgot_password_link()
	       .verify_header_of_forgot_password_popup(header_of_forgot_password_popup)
	       .click_cancel_button();
	   } 
  
	
    @Test(priority=2, groups = "functional")                                         
	public void verify_the_cancel_button_of_pop_up() {
    
       get(AjsNVDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .click_cancel_button();
    	}
    
    @Test(priority=3, groups = "functional")                                         
   	public void verify_the_error_when_userid_field_is_blank() {
    	
    	get(AjsNVDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .enter_email_address("")
    	    .click_send_button()
    	    .verify_error_msg_for_blank_email(error_msg_for_blank_email)
    	    .click_cancel_button();
    }
    	
    @Test(priority=4, groups = "functional")                                         
   	public void verify_the_error_for_invalid_userid() {
    	
    	get(AjsNVDForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .enter_email_address("abcde.com")
    	    .click_send_button()
    	    .verify_error_msg_for_invalid_email(error_msg_for_invalid_email)
    	    .click_cancel_button();
    }	
    	
    @Test(priority=5, groups = "functional")                                         
       	public void verify_the_forgot_password_happy_path() {	
    
    	get(AjsNVDForgotPasswordPage.class)
    	     .click_forgot_password_link()
    	     .enter_email_address("r20@ucbp1.vm")
    	     .click_send_button()
    	     .verify_text_of_email_sent_successfully(text_of_email_sent_successfully)
    	     .click_ok_button();
    	     
    }
    	
    	@Test(priority=6, groups = "functional")                                         
       	public void verify_the_forgot_password_functionality_for_user_not_in_system() {
    		
    	get(AjsNVDForgotPasswordPage.class)
    		 .click_forgot_password_link()
    		 .enter_email_address("hk5791@ucbp1.vm")
        	 .click_send_button()
    	     .verify_error_of_emailid_not_in_system(error_of_emailid_not_in_system)
    		 .click_cancel_button();
    		  
    }

    	@Test(priority=7, groups = "functional")                                         
       	public void verify_the_cancel_button_on_email_success_popup() {
    		
    	get(AjsNVDForgotPasswordPage.class)
   	         .click_forgot_password_link()
   	         .enter_email_address("r20@ucbp1.vm")
   	         .click_send_button()
   	         .verify_text_of_email_sent_successfully(text_of_email_sent_successfully)
   	         .click_cancel_button_on_success_popup();
   	}

}    	