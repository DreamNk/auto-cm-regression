package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOProfilePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class SSO_Login_Test extends AbstractAutoUITest {

 @Test(priority = 1, groups = { "functional" })
 public void loginWithRepUser() {
  get(SSOLoginPage.class)
      .invoke_loginURL("baseUrl")
      .enter_username("anamika.dutta@jct.com")
      .enter_password("Gltd@123")
      .click_login_button();
  get(SSOCommonUtilities.class)
      .select_option_from_userName_dropdown("Profile");
  get(SSOProfilePage.class)
      .verify_first_name_in_sso_profile("Anamika")
      .verify_last_name_in_sso_profile("Dutta")
      .verify_work_phone_in_profile("1234555")
      .verify_emailid_in_profile("anamika.dutta@jct.com")
      .verify_organization_name_in_profile("Vendormate Proxy Vendor")
      .verify_role_in_profile("User")
      .verify_username_in_profile("anamika.dutta@jct.com");
  get(SSOCommonUtilities.class)
      .select_option_from_userName_dropdown("Logout");
 }

}