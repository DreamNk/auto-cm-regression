package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.AdministrationConsolePage;
import com.ghx.auto.cm.ui.sso.page.ConnectToMailBoxPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOForgotPasswordPage;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOResetPasswordPage;
import com.ghx.auto.cm.ui.sso.page.SSOUserManagementPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Refresh_User_Test extends AbstractAutoUITest{
	
	String rmId = "gopal.rm@vendormate.com";
	String rmPassword = "Gltd123@";
	String refreshUser = "diccky.masseytest@gmail.com";
	String refreshSuccessMessage = "Success!";
	
	String gmailId="diccky.masseytest@gmail.com";
	String gmailPassowrd ="Sso!12345";
	String subject ="Password reset information for the GHX Single Sign On Application Portal";
	
	static String newPassword;
	String successText = "Your password has been updated successfully. Please login with new credentials.";
	String userName = "Diccky Massey";
	
	String filePath = "D:\\SetPassword.xlsx";
	String fileName = "SetPassword.xlsx";
	String sheetName = "Refresh User"; 
	
	@Test(priority=1, groups = {"functional"})                                        
	public void ResetPasswordUsingRefreshUser() throws IOException{
		
		// sending refresh User request 
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl")
			.wait_until(5)
			.enter_username(rmId)
			.enter_password(rmPassword)
			.click_login_button();
		
		get(SSOCommonUtilities.class)	
		.wait_until(5)
		.click_username_dropdown();
	
		get(SSOCommonUtilities.class)
    		.select_option_from_userName_dropdown("Administration Console");
	
		get(AdministrationConsolePage.class)
    		.click_user_management();
		
		get(SSOUserManagementPage.class)
			.click_refresh_user()
			.wait_until(3)
			.enter_email_to_search(refreshUser)
			.click_search_icon()
			.wait_until(15)
			.verify_searched_email(refreshUser)
			.click_reset_link()
			.wait_until(2)
			.verify_success_msg(refreshSuccessMessage);
		
		get(SSOCommonUtilities.class)	
			.wait_until(5)
			.click_username_dropdown()
			.click_logout();

		// opening mailbox for the password reset mail
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
			.click_reset_password_link(); // in gmail
		
		newPassword = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, sheetName);
		System.out.println("New Password set for User"+" - "+newPassword);
		
		get(ReadWritePasswordExcelPage.class)
			.wait_until(5)
			.write_data_excel(filePath, fileName,sheetName);
		
		//resetting password 
		get(SSOResetPasswordPage.class,focus_on_popup_window())
			.wait_until(20)
			.enter_new_password(newPassword)
			.enter_confirm_password(newPassword)
			.click_save_button()
			.wait_until(20);
			
		get(SSOLoginPage.class)
			.verify_password_reset_success_msg(successText);
		
		//login with new password
		get(SSOLoginPage.class)
			.wait_until(5)
			.enter_username(refreshUser)
			.enter_password(newPassword)
			.click_login_button();
		
		get(SSOLandingPage.class)
			.wait_until(5)
			.verify_userName(userName);
		
		get(SSOCommonUtilities.class)	
			.click_username_dropdown()
			.click_logout();
				
	}

}
