package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.NVDMyDocumentsPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Document_Alerts_Test extends AbstractAutoUITest{
	
  String rep_id = "v2@gps.net";
  String rep_password = "Gltd!124";
  
  String effectiveDate = "05/03/2013";
  String expirationDate = "05/05/2019";

   @Test(priority=1, groups = {"functional"}) 
   public void VerifyPassAlertsInNVD(){
       get(SSOLoginPage.class)
            .invoke_loginURL("ssoUrl")
            .enter_username(rep_id)
            .enter_password(rep_password)
            .click_login_button();
       get(SSOCommonUtilities.class)
            .select_option_from_solution_selector("Vendormate Credentialing");
       get(NVDHomePage.class)
            .click_common_document_alert_link()
            .click_1st_missing_doc_radio_button()
           //.select_effective_date("May", "03", "2007")
            .enter_expiration_date(expirationDate);
       get(SSOCommonUtilities.class)
            .upload_file("D:\\Testing Document.docx");
       get(NVDHomePage.class)
            .wait_until(5)
       		.click_save_button()
            .verify_right_tick_for_common_doc_alert();
       get(NVDHomePage.class)
            .click_accounts_tab();
       get(NVDAccountPage.class)
            .enter_account_name("Wayne Healthcare")
            .click_search_button()
            .verify_fails_status()
            .click_fails_status()
            .switch_to_iframe()
            .select_option_from_actions_dropdown_of_1st_doc("Upload")
            //.enter_effective_date(effectiveDate)
            .enter_expiration_date(expirationDate);
       get(SSOCommonUtilities.class)
            .upload_file("D:\\Testing Document.docx");
       get(NVDAccountPage.class)
            .click_save_and_continue_button()
            .switch_to_root_page()
            .click_back_to_list_link()
            .verify_pass_status();
       get(SSOCommonUtilities.class)
            .select_option_from_userName_dropdown("Logout")
            .clear_current_session();     
 }
  
     String buyerId = "buyer1@sadasystem.vdm";
     String buyerPassword = "Gltd1234@";
     String repFirstName = "Vella";
 /*
  *  // commenting this code as in staging it takes 15 mins to reflect
  *  
    @Test(priority=2, groups = {"functional"}) 
    public void VerifyPassAlertsInNBD(){
	   get(SSOLoginPage.class)
            .invoke_loginURL("ssoUrl")
            .enter_username(buyerId)
            .enter_password(buyerPassword)
            .click_login_button();
       get(SSOCommonUtilities.class)
            .select_option_from_solution_selector("Vendormate Credentialing");
	   get(NBDHomePage.class)
	        .click_reps_tab();
	   get(NBDRepsPage.class)
	        .enter_rep_first_name(repFirstName);
	   get(SSOCommonUtilities.class)
			   .pressEnter()
			   .wait_until(3);
	   get(NBDRepsPage.class)  
			   .verify_pass_alert();
	   get(SSOCommonUtilities.class)
	        .switch_to_root_page()
	        .select_option_from_userName_dropdown("Logout");
	 
  }
 */ 
     
   @Test(priority=3, groups = {"functional"}) 
   public void VerifyFailAlertsInNVD(){
	   get(SSOLoginPage.class)
            .invoke_loginURL("ssoUrl")
            .enter_username(rep_id)
            .enter_password(rep_password)
            .click_login_button();
       get(SSOCommonUtilities.class)
            .select_option_from_solution_selector("Vendormate Credentialing");
       get(NVDHomePage.class)
            .click_accounts_tab();
       get(NVDAccountPage.class)
            .enter_account_name("Wayne Healthcare")
            .click_search_button()
            .verify_pass_status()
            .click_pass_status()
            .switch_to_iframe()
            .select_option_from_actions_dropdown_of_1st_doc("Delete")
            .click_confirm_delete_button()
            .select_option_from_actions_dropdown_of_2nd_doc("Delete")
            .click_confirm_delete_button()
            .switch_to_root_page()
            .click_back_to_list_link()
            .verify_fails_status();
       get(SSOCommonUtilities.class)
            .select_option_from_userName_dropdown("Logout");
  
}
   // commenting this code as in staging it takes 15 mins to reflect
 /*  
   @Test(priority=4, groups = {"functional"}) 
   public void VerifyFailAlertsInNBD(){
	   get(SSOLoginPage.class)
           .invoke_loginURL("ssoUrl")
           .enter_username(buyerId)
           .enter_password(buyerPassword)
           .click_login_button();
      get(SSOCommonUtilities.class)
           .select_option_from_solution_selector("Vendormate Credentialing");
	   get(NBDHomePage.class)
	        .click_reps_tab();
	   get(NBDRepsPage.class)
	        .enter_rep_first_name(repFirstName);
	   get(SSOCommonUtilities.class)
			   .pressEnter()
			   .wait_until(3);      
	   get(NBDRepsPage.class)    
	        .verify_fail_alert();
	   get(SSOCommonUtilities.class)
	        .switch_to_root_page()
	        .select_option_from_userName_dropdown("Logout");
	 
}
 */  
}