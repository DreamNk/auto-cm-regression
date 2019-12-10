package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOChangePasswordPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Change_Password_Test extends AbstractAutoUITest{
	
	String userId = "p2@cbc.net"; //p2@ohio.net user password can be changed only once in 24 hrs, if need to re-run the script then change the user 
	static String existingPassword;
	static String newPassword;
	String newPassword2 = "Watson!1234"; 
	String errorMessage = "Error! You have already changed your password recently. You cannot set a new password at this time. Please contact GHX Customer Care if you are having trouble accessing your account.";
	String filePath = "D:\\SetPassword.xlsx";
	String fileName = "SetPassword.xlsx";
	String sheetName = "Change Password"; 
	
	@Test(priority=1, groups = {"functional"})                                        
	public void ChangePasswordFromSsoPortal() throws IOException{
		
		get(SSOLoginPage.class)
			.invoke_loginURL("ssoUrl");                                           
			
		existingPassword = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, sheetName);
		System.out.println("Existing Password of User"+" - "+existingPassword);	
		
		get(SSOLoginPage.class)
			.wait_until(3)
			.enter_username(userId)
			.enter_password(existingPassword)
			.click_login_button();
		
		get(SSOCommonUtilities.class)
			.click_username_dropdown();
		
		get(SSOChangePasswordPage.class)
			.click_profile()
			.click_change_password_button();
			
		get(ReadWritePasswordExcelPage.class)
			.wait_until(5)
			.write_data_excel(filePath, fileName,sheetName);
		
		newPassword = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, sheetName);

		get(SSOChangePasswordPage.class)
			.enter_existing_password(existingPassword)
			.enter_new_password(newPassword)
			.enter_confirm_password(newPassword)
			.click_save_button()
			.wait_until(5)
			.click_relogin_button();
		System.out.println("New Password set for User"+" - "+newPassword);
		
		get(SSOLoginPage.class)
			.wait_until(15)
			.enter_username(userId)
			.enter_password(newPassword)
			.click_login_button();	
	}

	@Test(priority=2, groups = {"functional"})                                        
	public void ChangePasswordForSameUserWithin24Hours(){
		
		get(SSOCommonUtilities.class)
			.click_username_dropdown();
		
		get(SSOChangePasswordPage.class)
			.click_profile()
			.click_change_password_button()
			.enter_existing_password(newPassword)
			.enter_new_password(newPassword2)
			.enter_confirm_password(newPassword2)
			.click_save_button()
			.wait_until(5)
			//.verify_error_msg(errorMessage)
			.click_close_button();
		
		get(SSOCommonUtilities.class)
			.click_username_dropdown()
			.click_logout()
			.clear_current_session();
		
	}
}
