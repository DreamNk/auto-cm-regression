package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.AdministrationConsolePage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportAdminPage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.CorexUsersDashboardPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOResetPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Account_Lock_Test extends AbstractAutoUITest{
	
	String rep_user_id = "mayurghx1@gmail.com";
	String wrong_password = "tgrtuhg";
	

	@Test(priority=1, groups = {"functional"}) 
	public void RepAccountLock(){
		get(SSOLoginPage.class)
		    .invoke_loginURL("prodUrl")
	    	.enter_username(rep_user_id)
	    	.enter_password(wrong_password)
	    	.click_login_button()
	    	.verify_username_or_password_invalid_msg("Please check your User Name and Password and try again.")
	    	.enter_username(rep_user_id)
	    	.enter_password(wrong_password)
	    	.click_login_button()
	    	.enter_username(rep_user_id)
	    	.enter_password(wrong_password)
	    	.click_login_button()
	    	.enter_username(rep_user_id)
	    	.enter_password(wrong_password)
	    	.click_login_button()
	    	.verify_error_msg_of_4th_attempt("You have made four failed log-in attempts. If you do not know your password, select 'Forgot Password?'. A fifth failed attempt will freeze your profile for 24 hours.")
	    	.enter_username(rep_user_id)
	    	.enter_password(wrong_password)
	    	.click_login_button()
	    	.verify_error_msg_of_5th_attempt("Your profile is frozen for security purposes due to five failed log-in attempts. Your profile will remain frozen for 24 hours, unless you contact Support.");
}
	
	
	String buyer_user_id = "anamikadutta1001@gmail.com";

	@Test(priority=2, groups = {"functional"}) 
	public void BuyerAccountLock(){
		get(SSOLoginPage.class)
	    .invoke_loginURL("prodUrl")
    	.enter_username(buyer_user_id)
    	.enter_password(wrong_password)
    	.click_login_button()
    	.verify_username_or_password_invalid_msg("Please check your User Name and Password and try again.")
    	.enter_username(buyer_user_id)
    	.enter_password(wrong_password)
    	.click_login_button()
    	.enter_username(buyer_user_id)
    	.enter_password(wrong_password)
    	.click_login_button()
    	.enter_username(buyer_user_id)
    	.enter_password(wrong_password)
    	.click_login_button()
    	.verify_error_msg_of_4th_attempt("You have made four failed log-in attempts. If you do not know your password, select 'Forgot Password?'. A fifth failed attempt will freeze your profile for 24 hours.")
    	.enter_username(buyer_user_id)
    	.enter_password(wrong_password)
    	.click_login_button()
    	.verify_error_msg_of_5th_attempt("Your profile is frozen for security purposes due to five failed log-in attempts. Your profile will remain frozen for 24 hours, unless you contact Support.");	
}


}
