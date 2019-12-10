package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.NormalRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Provider_Document_Test extends AbstractAutoUITest {
		  String rep_id = "carol.lopez@egxv411.vm";
		  String rep_password = null;
		  String repFirstName = "Carol";
		  String buyerName = "Ronald Wright";
		  String buyerId = "buyer1@universalhomecare.vdm";
		  String buyerPassword = null;
		  String effectiveDate = "05/03/2017";
		  String expirationDate = "05/05/2020";
		  String updatedexpirationDate = "05/05/2022";
		  String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
		  String fileName = "GetPasswordStaging.xlsx";
		  
		  @Test(priority=1, groups = {"functional"}) 
		   public void VerifyFailedProviderDocumentInNVD() throws IOException{
		       get(SSOLoginPage.class)
		            .invoke_loginURL("ssoUrl")
		            .enter_username(rep_id);
		     rep_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_id);
		     get(SSOLoginPage.class)
		            .enter_password(rep_password)
		            .click_login_button();
		       get(SSOCommonUtilities.class)
		            .select_option_from_solution_selector("Vendormate Credentialing");
		       get(NVDHomePage.class)
		       	   .wait_until(10)
		           .click_account_specific_doc_alert_link()
		           .verify_account_specific_doc_status("Missing")
		           .click_close_popup()
		           .wait_until(3);
		       get(NVDHomePage.class)
		            .click_accounts_tab()
		            .wait_until(3);
		       get(NVDAccountPage.class)
		            .enter_account_name("Universal Home Care Inc")
		            .click_search_button()
		            .wait_until(3)
		          	.verify_fails_status();
		       get(SSOCommonUtilities.class)
		            .select_option_from_userName_dropdown("Logout")
		            .clear_current_session();     
		
		 }
		   
		   
		    @Test(priority=2, groups = {"functional"}) 
		    public void UploadProviderDocumentFromNBD() throws IOException{
			   get(SSOLoginPage.class)
		            .invoke_loginURL("ssoUrl")
		            .enter_username(buyerId);
		            buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerId);
				     get(SSOLoginPage.class)
		            .enter_password(buyerPassword)
		            .click_login_button();
		       get(SSOCommonUtilities.class)
		            .select_option_from_solution_selector("Vendormate Credentialing");
			   get(NBDHomePage.class)
			   		.wait_until(10)
			        .click_reps_tab();
			   get(NBDRepsPage.class)
			        .enter_rep_first_name(repFirstName);
			   get(SSOCommonUtilities.class)
					   .pressEnter()
					   .wait_until(3);
			   get(NBDRepsPage.class)  
					   .verify_fail_alert()
					   .click_requirement_status_link();
			   get(NBDRepsPage.class)
			   			.switch_to_iframe()
			   			.wait_until(10);
			   get(SSOCommonUtilities.class)
	   					.wait_for_text_appear(repFirstName);
			   get(NBDRepsPage.class)
			   			.verify_doc_status("Missing")
			   			.select_option_from_actions_for_provider_doc("Upload")
			   			.wait_until(3)
			   			.enter_effective_date(effectiveDate)
			   			.enter_expiration_date(expirationDate)
			   			.select_acknowledgment_check_box();
			   get(SSOCommonUtilities.class)
			   			.upload_file("D:\\MSDhoni.jpg");
			   get(SSOCommonUtilities.class)
			   			.wait_until(3)
						.wait_for_text_appear("Expiration");
			   get(NBDRepsPage.class)
			   			.click_save_and_continue_button()
			   			.wait_until(5)
			   			.verify_doc_verification_status("Verified")
			   			.verify_doc_updated_by_name(buyerName)
			   			.select_option_from_actions_for_provider_doc("Update")
			   			.wait_until(3)
			   			.enter_expiration_date(updatedexpirationDate)
						.click_save_and_continue_button()
						.wait_until(5)
			   			.verify_doc_status("Complete")
			   			.verify_doc_verification_status("Verified")
			   			.verify_doc_updated_by_name(buyerName)
			   			.select_option_from_actions_for_provider_doc("View");
			   get(NBDRepsPage.class,focus_on_popup_window())
					     .wait_until(10);
			   		focus_on_popup_window().close();	
			   get(SSOCommonUtilities.class,focus_on_parent_window())
				        .switch_to_root_page();		
			   get(NBDRepsPage.class)			
			   			.click_back_to_list_link()
			   			.wait_until(7);
			   get(SSOCommonUtilities.class)
			   		.select_option_from_userName_dropdown("Logout")
			   		.clear_current_session();  
			   
		    }	   
			  
		    @Test(priority=3, groups = {"functional"}) 
			   public void VerifyPassedProviderDocumentInNVD() throws IOException{
			       get(SSOLoginPage.class)
			            .invoke_loginURL("ssoUrl")
			            .enter_username(rep_id);
			            rep_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_id);
					     get(SSOLoginPage.class)
			            .enter_password(rep_password)
			            .click_login_button();
			       get(SSOCommonUtilities.class)
			            .select_option_from_solution_selector("Vendormate Credentialing");
			       get(NVDHomePage.class)
			       		.wait_until(5)
			       		.click_accounts_tab()
			       		.wait_until(3);
			       get(NVDAccountPage.class)
			            .enter_account_name("Universal Home Care Inc")
			            .click_search_button()
			            .wait_until(3)
			          	.verify_pass_status()
			          	.click_pass_status()
			          	.switch_to_iframe()
			          	.wait_until(10)
			          	.verify_provider_doc_status("Completed")
			          	.select_option_from_actions_dropdown_of_2nd_doc("View");
			       get(NVDAccountPage.class,focus_on_popup_window())
			       		.wait_until(10);
			       focus_on_popup_window().close();	
			       get(NVDAccountPage.class,focus_on_parent_window())
			       		.switch_to_root_page()
			       		.click_back_to_list_link()
			       		.wait_until(10);
			       get(SSOCommonUtilities.class)
			            .select_option_from_userName_dropdown("Logout")
			            .clear_current_session();  
			 }
		      
			    @Test(priority=4, groups = {"functional"}) 
			    public void DeleteProviderDocumentFromNBD() throws IOException{
				   get(SSOLoginPage.class)
			            .invoke_loginURL("ssoUrl")
			            .enter_username(buyerId);
				   buyerPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerId);
				     get(SSOLoginPage.class)
			            .enter_password(buyerPassword)
			            .click_login_button();
			       get(SSOCommonUtilities.class)
			            .select_option_from_solution_selector("Vendormate Credentialing");
				   get(NBDHomePage.class)
				   		.wait_until(10)
				   		.click_reps_tab();
				   get(NBDRepsPage.class)
				        .enter_rep_first_name(repFirstName);
				   get(SSOCommonUtilities.class)
						   .pressEnter()
						   .wait_until(3);
				   get(NBDRepsPage.class)  
				   			.click_requirement_status_link();
				   get(NBDRepsPage.class)
				   			.switch_to_iframe()
				   			.wait_until(10);
				   get(SSOCommonUtilities.class)
		   					.wait_for_text_appear(repFirstName);
				   get(NBDRepsPage.class)
				   			.select_option_from_actions_for_provider_doc("Delete")
				   			.wait_until(3)
				   			.click_confirm_delete_button()
				   			.wait_until(5)
				   			.click_info_tab()
				   			.wait_until(5)
				   			.click_doc_tab()
				   			.wait_until(7)
				   			.verify_doc_status("Missing");
				   get(SSOCommonUtilities.class)
					        .switch_to_root_page();		
				   get(NBDRepsPage.class)			
				   			.click_back_to_list_link()
				   			.wait_until(7);
				   get(SSOCommonUtilities.class)
				   		.select_option_from_userName_dropdown("Logout")
				   		.clear_current_session();  
			   
		    }		

}
