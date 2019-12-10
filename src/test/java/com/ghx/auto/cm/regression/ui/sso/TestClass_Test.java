package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInAVendorPage;
import com.ghx.auto.cm.ui.sso.page.NVDExtrasPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOProfilePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;
import junit.framework.TestListener;

public class TestClass_Test extends AbstractAutoUITest {
	
	String GuestBadgePrintMessage = " Guest pass badges are limited to one time use. Please have this rep register with your health system for continued access.";
	String GuestBadgeNotPrintMessage = "The identified rep is registered with your health system and is not eligible for a Guest Pass Badge. Please return to the Sign-In page.";

	@Test(priority = 1, groups = { "functional" })
	 public void loginWithRepUser() {
	
	  get(SSOLoginPage.class)
	      .invoke_loginURL("baseUrl")
	      .enter_username("cc19@fakemail.net")
	      .enter_password("Gltd123@")
	      .click_login_button();
	  get(SSOCommonUtilities.class)
	      .select_option_from_userName_dropdown("Profile");
	  get(SSOProfilePage.class)
	      .verify_first_name_in_sso_profile("CC nineteen")
	      .verify_last_name_in_sso_profile("ln")
	      .verify_work_phone_in_profile("789456123")
	      .verify_emailid_in_profile("cc19@fakemail.net")
	      .verify_organization_name_in_profile("CONTROL COMPANY")
	      .verify_role_in_profile("Representative")
	      .verify_username_in_profile("cc19@fakemail.net");
	  get(SSOCommonUtilities.class)
	      .select_option_from_userName_dropdown("Logout");
	 }
	
	@Test(priority = 2, groups = { "functional" })
	 public void secondGuestPass() {
	  get(SSOLoginPage.class)
	      .invoke_loginURL("baseUrl")
	      .enter_username("CSMC_Buyer2@fakemail.net")
	      .enter_password("Gltd123@1")
	      .click_login_button();	
	  get(SSOCommonUtilities.class)
       .select_option_from_userName_dropdown("Logout")
      .clear_current_session();	   
	 }
	
	
	/* @Test(priority = 3, groups = { "functional" })
	 public void GuestPassForRegisteredUserNotPrinted() {
	  get(SSOLoginPage.class)
	      .invoke_loginURL("baseUrl")
	      .enter_username("CSMC_Buyer2@fakemail.net")
	      .enter_password("Gltd123@1")
	      .click_login_button();
	  get(SSOCommonUtilities.class)
	   .select_option_from_solution_selector("Vendormate Credentialing");
	  
	  get(NBDHomePage.class)
	   .wait_until(20)
	   .click_sign_in_a_vendor();
	   get(NBDSignInAVendorPage.class)
	  .wait_until(5)
	  .enter_corporate_email("mbiirep11@fakemail.net")
	  .enter_first_name("First name")
	  .enter_last_name("Last name")
	  .enter_phone_no("789456123")
	  .enter_company_name("New Company")	 
	  .enter_visiting_contact("Phone No")
	  .enter_contacts_Title("Contacts title")
	  .enter_purpose("Appointment") 
	  .select_location("EI Paso")	 
	  .select_poe("South Gate")	  
	  .select_department("Accounting")
	 
	  .click_print_Guest_Pass_button()
	  .wait_for_BadgeNotprint_text_appear(GuestBadgeNotPrintMessage)
	  .click_Return_To_SignIn_Page_Button()	;
	 }*/
}
	 



			
		
		
	
	

	

