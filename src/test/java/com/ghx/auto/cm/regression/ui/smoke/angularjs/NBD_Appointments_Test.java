package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsNBDAppointmentsPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Appointments_Test extends AbstractAutoUITest{

	String username = "auto_buyer4@mhc.vdm";
	String password = "gltd123";

	@Test(priority=1, groups = {"functional"})                                       
	public void loginSuccessful() {

		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();
		
		get(AjsNBDAppointmentsPage.class)
		    .click_appointments_tab()
		    .wait_until(6)
		    .select_year("2012")
		    .select_date(28);
	}
}
