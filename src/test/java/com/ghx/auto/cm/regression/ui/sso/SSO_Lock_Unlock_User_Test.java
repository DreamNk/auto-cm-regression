package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.AdministrationConsolePage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOUserManagementPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Lock_Unlock_User_Test extends AbstractAutoUITest {
	
	String emailAddress = "rep0@verill.net";
	String incorrectPass = "dfdfd";
	String password = "Test!12345";
	String userName = "Rep Zero";
	
	String rmId = "gopal.rm@vendormate.com";
	String rmPassword = "Gltd123@";
	
	String successMessage = "Success! User unlocked";
	
	@Test(priority=1, groups = {"functional"}) 
	public void UserAccountLock(){
		get(SSOLoginPage.class)
		    .invoke_loginURL("ssoUrl")
			.enter_username(emailAddress)
			.enter_password(incorrectPass)
			.click_login_button()
			.verify_username_or_password_invalid_msg("Please check your User Name and Password and try again.")
			.enter_username(emailAddress)
			.enter_password(incorrectPass)
			.click_login_button()
			.enter_username(emailAddress)
			.enter_password(incorrectPass)
			.click_login_button()
			.enter_username(emailAddress)
			.enter_password(incorrectPass)
			.click_login_button()
			.wait_until(10)
			.verify_error_msg_of_4th_attempt("You have made four failed log-in attempts. If you do not know your password, select Forgot Password?. A fifth failed attempt will freeze your profile for 30 minutes.")
			.enter_username(emailAddress)
			.enter_password(incorrectPass)
			.click_login_button()
			.wait_until(10)
			.verify_error_msg_of_5th_attempt("Due to 5 failed login attempts, your profile will remain locked for 30 minutes unless you contact Customer Care.");

	}
	
	@Test(priority=2, groups = {"functional"}) 
	public void UserAccountUnlock(){
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
		    .enter_userId_and_search(emailAddress)
		    .verify_userId_in_search_result(emailAddress)
		    .click_unlock_user_icon()
		    .verify_user_unclock_successfully_msg(successMessage);
		
		get(SSOCommonUtilities.class)	
			.wait_until(5)
			.click_username_dropdown()
			.click_logout();
	}
	
	@Test(priority=3, groups = {"functional"}) 
	public void UnlockedUserLoginWithOldPassword(){
		get(SSOLoginPage.class)
		    .invoke_loginURL("ssoUrl")
		    .wait_until(5)
			.enter_username(emailAddress)
			.enter_password(password)
			.click_login_button();
		
		get(SSOLandingPage.class)
	    	.verify_userName(userName);
		
		get(SSOCommonUtilities.class)	
			.wait_until(5)
			.click_username_dropdown()
			.click_logout();
	}
}
