package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsNVDRootPage;

import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVDSignoutTest extends AbstractAutoUITest{
	
		String Email_address = "auto_buyer5@srmc.vdm";
		String email_not_in_system = "autobuyer3@srmc.vdm";
		
		@Test(priority=1, groups = "functional")                                         
		public void VerifySevenDaysErrorMessage() {

	/*	   get(AjsNVDRootPage.class)
		       .click_on_actions_menu()
		       .click_on_signout_from_actions_menu();
		   get(AjsNVDSignoutPage.class)
		       .wait_until(5)
		       .verify_error_message("Remote sign out is available up to 7 days after you sign in at a health system kiosk or use the remote badge print feature.");
		   */} 

}
