package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Change_Password_Test extends AbstractAutoUITest {

	String NewPassword  = "gltd@1235";    //Interchange ExistingPassword and NewPassword  on every run
	String ExistingPassword  = "test@1235";
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyChangePassword() {
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
			.enter_username("auto_buyer3@beverly.vdm")
			.enter_password(ExistingPassword)
			.click_login_button()
			.click_continue_button();
			
		
		get(NBDRootPage.class)
			.click_username_dropdown();
		
		get(NBDRootPage.class)
			.click_change_password()
			.enter_existing_password(ExistingPassword)
			.enter_new_password(NewPassword)
			.enter_verify_new_password(NewPassword)
			.click_save_password()
			.click_ok_password();
			
		
		get(NBDLogin.class)
			.enter_username("auto_buyer3@beverly.vdm")
			.enter_password(NewPassword)
			.click_login_button()
			.click_continue_button()
			.wait_until(7)
			.verify_username("Notting Hill");
		

}
	@Test(priority=2, groups = {"functional"})                                         
	public void verifyErrorForSameNewAndExistingPassword() {
		
		
		get(NBDRootPage.class)
			.click_username_dropdown();
		
		get(NBDRootPage.class)
			.click_change_password()
			.enter_existing_password(NewPassword)
			.enter_new_password(NewPassword)
			.enter_verify_new_password(NewPassword)
			.click_save_password()
			.verify_same_existing_and_new_password_error("Existing Password and New Password must be different.")
		    .click_cross_sign_on_change_apssword_popup();
		
}
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyErrorForDifferentNewAndVerifynewPassword()  {
		
		get(NBDRootPage.class)
			.click_username_dropdown();
		
		get(NBDRootPage.class)
			.click_change_password()
			.enter_existing_password(NewPassword)
			.enter_new_password(ExistingPassword)
			.enter_verify_new_password(NewPassword)
			.click_save_password()
			.verify_error_for_different_new_and_verifynew_password("New Password and Verify New Password must match.")
		 	.click_cross_sign_on_change_apssword_popup();
			
	}
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyErrorForPasswordNotMeetingRequirement()  {
		
		get(NBDRootPage.class)
			.click_username_dropdown();
		
		get(NBDRootPage.class)
			.click_change_password()
			.enter_existing_password(NewPassword)
			.enter_new_password("gltd123")
			.enter_verify_new_password("gltd123")
			.click_save_password()
			.verify_error_for_password_not_meeting_requirement("The password submitted does not meet")
		 	.click_cross_sign_on_change_apssword_popup();

	    }


	@Test(priority=5, groups = {"functional"})                                         
	public void verifyErrorForIncorrectExistingPassword() {
		
		get(NBDRootPage.class)
			.click_username_dropdown();
		
		get(NBDRootPage.class)
			.click_change_password()
			.enter_existing_password("gltd123")
			.enter_new_password("test@123")
			.enter_verify_new_password("test@123")
			.click_save_password()
			.verify_error_for_wrong_existing_password("Existing Password is not")
		 	.click_cross_sign_on_change_apssword_popup();
		
		get(CommonUtilities.class)
			.do_log_out_from_NBD();

	    }

}
