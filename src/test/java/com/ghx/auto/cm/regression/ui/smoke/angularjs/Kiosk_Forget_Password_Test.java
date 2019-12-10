package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsKioskForgotPasswordPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDForgotPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Kiosk_Forget_Password_Test extends AbstractAutoUITest {
	
	
	String Email_address = "autoforgotpassword_buyer@mhc.vdm";
	String email_not_in_system = "autobuyer3@srmc.vdm";
	
	@Test(priority=1, groups = "functional")                                         
	public void verify_forgot_password_pop_up() {

	   get(AjsKioskForgotPasswordPage.class)
	       .invoke_url()
	       .wait_for_login_page_to_load()
	       .click_forgot_password_link()
	       .wait_until(4)
	       .verify_header_of_forgot_password_popup("Forgot your password?")
	       .click_cancel_button();
	   } 
  
	
    @Test(priority=2, groups = "functional")                                         
	public void verify_the_cancel_button_of_pop_up() {
    
    	get(AjsKioskForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .wait_until(4)
    	    .click_cancel_button();
    	}
    
    @Test(priority=3, groups = "functional")                                         
   	public void verify_the_error_when_userid_field_is_blank() {
    	
    	get(AjsKioskForgotPasswordPage.class)
    	    .click_forgot_password_link()
    	    .enter_email_address("")
    	    .click_send_button()
    	    .wait_until(4)
    	    .verify_error_msg_for_blank_email("Email Address should not be blank.")
    	    .click_cancel_button();
    }
    	
    @Test(priority=4, groups = "functional")                                         
   	public void verify_the_error_for_invalid_userid() {
    	
    	get(AjsKioskForgotPasswordPage.class)
    	    .wait_until(4)
    	    .click_forgot_password_link()
    	    .enter_email_address("abcde.com")
    	    .click_send_button()
    	    .wait_until(4)
    	    .verify_error_msg_for_invalid_email("Please provide a valid email address.")
    	    .click_cancel_button();
    }	
    	
    @Test(priority=5, groups = "functional")                                         
       	public void verify_the_forgot_password_happy_path() {	
    
    	get(AjsKioskForgotPasswordPage.class)
    	     .click_forgot_password_link()
    	     .enter_email_address(Email_address)
    	     .click_send_button()
    	     .wait_until(4)
    	     .verify_text_of_email_sent_successfully("Email sent successfully.")
    	     .click_ok_button();
    	     
    }
    	
    	@Test(priority=6, groups = "functional")                                         
       	public void verify_the_forgot_password_functionality_for_user_not_in_system() {
    		
    	get(AjsKioskForgotPasswordPage.class)
    		 .click_forgot_password_link()
    		 .enter_email_address(email_not_in_system)
        	 .click_send_button()
        	 .wait_until(4)
    	     .verify_error_of_emailid_not_in_system("We can't find this email")
    		 .click_cancel_button();
    		  
    }

    	@Test(priority=7, groups = "functional")                                         
       	public void verify_the_cancel_button_on_email_success_popup() {
    		
    	get(AjsKioskForgotPasswordPage.class)
   	         .click_forgot_password_link()
   	         .enter_email_address(Email_address)
   	         .click_send_button()
   	         .wait_until(4)
   	         .verify_text_of_email_sent_successfully("Email sent successfully.")
   	         .click_cancel_button_on_success_popup();
   	     
   }
    		


}
	
	
	


