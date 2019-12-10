package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;
import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.sso.page.ConnectToMailBoxPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOForgotPasswordPage;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOResetPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


   // Create a sheet first in local machine D drive - 

public class SSO_Forgot_Password_Test extends AbstractAutoUITest{
	
	
	String emailAddress = "diccky.masseytest@gmail.com"; 
	String gmailId="diccky.masseytest@gmail.com"; 
	String gmailPassowrd ="Sso!12345";    
	String subject ="Password reset information for the GHX Single Sign On Application Portal";
	String gmailUrl = "gmail.com";
	String successText = "Your password has been updated successfully. Please login with new credentials.";
	String userName = "Diccky Massey";  
	
	String ldapEmailAddress = "kshruti@ghx.com";
	
	String filePath = "D:\\SetPassword.xlsx";
	String fileName = "SetPassword.xlsx";
	String sheetName = "Forgot Password"; 
	
	static String newPassword = null;
	
	@Test(priority=1, groups = {"functional"})                                        
	public void ResetPasswordUsingForgotPassword() throws IOException {
	
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")
			.click_forgot_password_link();
	
		get(SSOForgotPasswordPage.class)
			.verify_enter_email_text("Please enter your email")
			.enter_email_address(emailAddress)
			.click_next_button()
			.verify_check_your_email_text("Check your email")
			.click_back_to_login_button();
		
		// to connect to mail box
		get(ConnectToMailBoxPage.class)
			.wait_until(5)
			.invoke_gmailURL("gmailUrl")
			.enter_mailId(gmailId)
			.click_next_button()
			.enter_password(gmailPassowrd)
			.click_signIn_button()
			.click_mail_Inbox_button()
			.click_mail_search_field()
			.enter_mail_subject(subject)
			.click_search_mail_button()
			.click_set_password_mail();	
			
		get(ConnectToMailBoxPage.class)
			.click_reset_password_link()
			.wait_until(10);
	
		newPassword = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, sheetName);
		System.out.println("New Password set for User"+" - "+newPassword);
		
		get(ReadWritePasswordExcelPage.class)
		.wait_until(5)
		.write_data_excel(filePath, fileName,sheetName);
		
		
		get(SSOResetPasswordPage.class,focus_on_popup_window())
			.wait_until(20)
			.enter_new_password(newPassword)
			.enter_confirm_password(newPassword)
			.click_save_button()
			.wait_until(20);
		
		//get(SSOLoginPage.class)
		//	.verify_password_reset_success_msg(successText);
		
		get(SSOLoginPage.class)
			.wait_until(5)
			.enter_username(emailAddress)
			.enter_password(newPassword)
			.click_login_button();
		
		get(SSOLandingPage.class)
			.wait_until(5)
			.verify_userName(userName);
		
		get(SSOCommonUtilities.class)	
			.click_username_dropdown()
			.click_logout()
			.clear_current_session();
	
		get(ReadWritePasswordExcelPage.class)
			.wait_until(5)
			.write_data_excel(filePath, fileName,sheetName);
	}
/*	
	@Test(priority=2, groups = {"functional"})                                        
	public void LDAPUserSendingForgotPasswordRequest(){
	
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")
			.click_forgot_password_link()
			.wait_until(5);
	
		get(SSOForgotPasswordPage.class)
			.verify_enter_email_text("Please enter your email")
			.enter_email_address(ldapEmailAddress)
			.click_next_button()
			.verify_ldap_user_error_text("Your profile is managed in Active Directory. Please reset your password through GHX Password Management.")
			.click_password_management()
			.wait_until(10);
		get(SSOForgotPasswordPage.class,focus_on_popup_window())
			.verify_reset_pass_link("Reset your forgotten password");
			
		get(SSOForgotPasswordPage.class,focus_on_parent_window())
			.click_cancel_button();
		
		get(SSOLoginPage.class)
			.wait_until(5)
			.verify_text_in_login_page("GHX Login");
		get(SSOCommonUtilities.class)		
			.clear_current_session();
	}
*/
}
