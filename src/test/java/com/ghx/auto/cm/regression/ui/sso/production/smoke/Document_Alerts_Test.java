package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Document_Alerts_Test extends AbstractAutoUITest{
	
	
	  String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	  String fileName = "GetPasswordProduction.xlsx";
	  
	  String rep_Id = "mayurghx1@gmail.com";
	  String rep_password = null;

	  
	   @Test(priority=1, groups = {"functional"}) 
	   public void VerifyFailAlertsInNVD() throws IOException{
		   get(SSOLoginPage.class)
	            .invoke_loginURL("prodUrl")
	            .enter_username(rep_Id);
	            rep_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_Id);
	      	  get(SSOLoginPage.class)
	            .enter_password(rep_password)
	            .click_login_button();
	       get(SSOCommonUtilities.class)
	            .select_option_from_solution_selector("Vendormate Credentialing");
	            //.click_continue_button();
	       get(NVDHomePage.class)
	            .wait_until(40)
	            .click_accounts_tab()
	            .wait_until(5);
	       get(NVDAccountPage.class)
	            .enter_account_name("Vendormate")
	            .click_search_button()
	            .verify_pass_status()
	            .click_pass_status()
	            .switch_to_iframe()
	            .select_option_from_actions_dropdown_of_4th_doc("Delete")
	            .wait_until(35)
	            .click_confirm_delete_button()
	            .select_option_from_actions_dropdown_of_4th_doc("Delete")
	            .wait_until(35)
	            .click_confirm_delete_button()
	            .switch_to_root_page()
	            .click_back_to_list_link()
	            .verify_fails_status();
	       get(SSOCommonUtilities.class)
	            .select_option_from_userName_dropdown("Logout");
	  
	}
	   
	   @Test(priority=2, groups = {"functional"}) 
	   public void VerifyFailAlertsInNBD() throws IOException{
		   get(SSOLoginPage.class)
                .invoke_loginURL("prodUrl")
                .enter_username(buyerId);
		   buyerId =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerId);
  	      	  get(SSOLoginPage.class)
                .enter_password(buyerId)
                .click_login_button();
           get(SSOCommonUtilities.class)
                .select_option_from_solution_selector("Vendormate Credentialing");
	       get(NBDHomePage.class)
	            .wait_until(40)
	            .click_reps_tab();
	       get(NBDRepsPage.class)
	            .wait_until(4)
	            .enter_rep_first_name(repFirstName)
	            .enter_rep_last_name(repLastName);
	       get(SSOCommonUtilities.class)
	            .pressEnter()
	            .wait_until(3);
	       get(NBDRepsPage.class)
	            .verify_fail_alert();
	       get(SSOCommonUtilities.class)
	            .select_option_from_userName_dropdown("Logout");
		 
	}
	  
	 @Test(priority=3, groups = {"functional"}) 
	   public void VerifyPassAlertsInNVD() throws IOException{
	       get(SSOLoginPage.class)
	            .invoke_loginURL("prodUrl")
	            .enter_username(rep_Id);
	             rep_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_Id);
	       get(SSOLoginPage.class)
	            .enter_password(rep_password)
	            .click_login_button();
	       get(SSOCommonUtilities.class)
	            .wait_until(3)
	            .select_option_from_solution_selector("Vendormate Credentialing");
	           // .click_continue_button();
	       get(NVDHomePage.class)
	            .wait_until(20)
	            .click_common_document_alert_link()
	            .click_1st_missing_doc_radio_button();
	       get(SSOCommonUtilities.class)
	            .upload_file("C:\\Users\\anamika.dutta\\Documents\\Files\\Testing.docx")
	            .wait_until(5);
	       
	       get(NVDHomePage.class)
	            .click_save_button();
	       get(NVDHomePage.class)
	            .wait_until(10)
	            .click_accounts_tab();
	       get(NVDAccountPage.class)
                .wait_until(7)
	            .enter_account_name("Vendormate")
	            .click_search_button()
	            .verify_fails_status()
	            .click_fails_status()
	            .switch_to_iframe()
	            .select_option_from_actions_dropdown_of_1st_doc("Upload")
	            .click_continue_button();
	       get(SSOCommonUtilities.class)
	            .upload_file("C:\\Users\\anamika.dutta\\Documents\\Files\\Testing.docx");
	       get(NVDAccountPage.class)
	            .wait_until(5)
	            .click_save_and_continue_button()
	            .wait_until(5)

	            .switch_to_root_page()
	            .click_back_to_list_link()
	            .verify_pass_status();
	       get(SSOCommonUtilities.class)
	            .select_option_from_userName_dropdown("Logout");     
	 }

	   
	     String buyerId = "anamikadutta1001@gmail.com";
	     String buyerPassword = null;
	     String repFirstName = "Mayurghx";
	     String repLastName = "mmm";
	 
	    @Test(priority=4, groups = {"functional"}) 
	    public void VerifyPassAlertsInNBD() throws IOException{
		   get(SSOLoginPage.class)
	            .invoke_loginURL("prodUrl")
	            .enter_username(buyerId);
		   buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerId);
	      get(SSOLoginPage.class)
	            .enter_password(buyerPassword)
	            .click_login_button();
	       get(SSOCommonUtilities.class)
	            .select_option_from_solution_selector("Vendormate Credentialing");
		   get(NBDHomePage.class)
		        .wait_until(20)
		        .click_reps_tab();
		   get(NBDRepsPage.class)
		        .wait_until(2)
		        .enter_rep_first_name(repFirstName)
		        .enter_rep_last_name(repLastName);
		   get(SSOCommonUtilities.class)
		        .wait_until(3)
		        .pressEnter();
		   get(NBDRepsPage.class)
	            .wait_until(3)
		        .verify_pass_alert();
		   get(SSOCommonUtilities.class)
		        .select_option_from_userName_dropdown("Logout");
		 
	 }
	 
	
	   
	}

