package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.ConnectToDatabasePage;
import com.ghx.auto.cm.ui.sso.page.ExpressRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.NetworkRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.NormalRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.RMDashSelectVCRelationshipPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVCRelationshipPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVendorSearchPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Payment_GRP_Test extends AbstractAutoUITest {

	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	//         Normal Registration                    // 
	String login_RM_id = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";
	String rep_id = "m1@reeves.com";
	String rep_password = null;
	String vendorName = "Reeves County Hospital District";
	String customerName = "Wayne Healthcare";
	String message="There are no results for the specified search criteria.";
	String VendorFein = "752301801";
	String comment = "GRP Zero - Used in Automation";

	//  	Express   Registration        // 
	String FName = "Enrique";
	String LName =  "Igelsis";
	String Phone = "123456789";
	String Email =  "en@gmail.com";
	String MinorityType = "Asian";
	String certificationAgency = "Center for Women & Enterprise";
	String certificationNumber = "12345";
	

	@Test(priority = 1, groups = { "functional" })
	public void GRPZeroPaymentForNormal() throws IOException{	
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
	    .click_accounts_tab();
	get(NVDAccountPage.class)
	    .click_search_for_accounts_tab()
	    .enter_health_system_name_in_searchbox(customerName)
	    .click_search_in_search_for_accounts_tab()
	    .click_register_button()
	    .wait_until(2)
		.click_yes_in_onsite_popup();
	get(NormalRegistrationPage.class)
	    .wait_until(8)
	    .click_normal_company_details_next_button()
	    .select_normal_company_relationship_spend_tier("$10,000 - $25,000")
	    .wait_until(2)
	    .click_normal_company_relationship_onsite_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_q1_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_q2_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_q3_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_q4_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_q5_option("No")
	    .wait_until(2)
	    .click_normal_company_relationship_phi1_option("no")
	    .wait_until(2)
        .click_normal_company_relationship_phi2_option("no")
        .wait_until(2)
	    .click_normal_company_relationship_next_button()
	    .wait_until(2)
	    .wait_until_loading_bar_to_complete()
	    .wait_until(3)
	    .select_rep_risk_question_1("Yes")
	    .wait_until(4)
	    .select_rep_risk_question_2("No")
	    .wait_until(4)
	    .select_rep_risk_question_3("No")
	    .wait_until(4)
	    .select_rep_risk_question_4("No")
	    .wait_until(4)
	    .select_rep_risk_question_5("No")
	    .wait_until(4)
	    .select_dynamic_question(1, "No")
	    .wait_until(4)
	    .select_dynamic_question(2, "No")
	    .wait_until(4)
	    .select_rep_risk_on_site_question("No")
	    .wait_until(4)
	    .select_location("Hartford")
	    .wait_until(4)
	    .select_department("Biomedical Engineering")
	    .wait_until(4)
	    .click_normal_company_relationship_next_button()
	    .wait_until_loading_bar_to_complete()
	    .click_relationship_no_radio_button()
	    .wait_until(4)
	    .click_affiliations_no_radio_button()
	    .wait_until(2)
	    .click_compensation_no_radio_button()
	    .wait_until(4)
	    .check_eula_license_aggement_checkbox()
	    .click_normal_company_relationship_next_button()
	    .wait_until(2)
		.refresh_page();
	get(NVDHomePage.class)
		.wait_until(5)	
		.click_accounts_tab();
	get(NVDAccountPage.class)
		.enter_account_name(customerName)
		.click_search_button()
	 	.verify_account_name_text(customerName);
		
	get(SSOCommonUtilities.class) 
		.select_option_from_userName_dropdown("Logout")
		.clear_current_session();
	}

	@Test(priority = 2, groups = { "functional" })
	public void verifyNormalGRPInDatabase(){
		
		get(ConnectToDatabasePage.class)
			.wait_until(10)
			.fetch_grp_payemnt_detals_from_db(rep_id);
	}	
	
	@Test(priority = 3, groups = { "functional" })
	public void deleteNormalVC(){
		
	get(SSOLoginPage.class)
		.invoke_loginURL("ssoUrl")
		.enter_username(login_RM_id)
		.enter_password(RM_password)
		.click_login_button()
		.wait_until(10);
	get(SSOCommonUtilities.class)
    	.select_option_from_solution_selector("Vendormate Credentialing");
	get(CPMHomePage.class)
		.click_crm_support_tab()
		.click_crm_dashboard()
		.wait_until(5);
	get(RMDashLandingPage.class)    
	     .click_vendor_search_link()
	     .wait_until(5);
	get(RMDashVendorSearchPage.class)                 
	 	 .enter_vendor_name(vendorName)
	 	 .click_search_Vendor()
	 	 .click_radio_button()
	 	 .click_find_vc_relation();
	get(RMDashVCRelationshipPage.class)        
		 .enter_VC_name(customerName)
		 .click_continue_button()
		 .verify_rrp_comment(comment)
		 .select_VC_radio_button()
		 .click_delete_VC_button()
		 .click_delete_button()
		 .wait_until(3);	
	 get(RMDashVendorSearchPage.class)
	 	 .click_radio_button()
		 .click_find_vc_relation();	
	 get(RMDashSelectVCRelationshipPage.class)	  
	 	.enter_VC_name(customerName)
	 	.click_continue_button()
	 	.verify_deleted_VC_search_alert()
	 	.click_return_dashboard_button();
	get (RMDashLandingPage.class) 	
		.click_logout();
	get(NetworkRegistrationPage.class)
		.clear_cookies();
	}


	@Test(priority = 4, groups = { "functional" })
	public void GRPZeroPaymentForExpress() throws IOException{
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
		  .click_accounts_tab();
	 get(NVDAccountPage.class)
		  .click_search_for_accounts_tab()
		  .enter_health_system_name_in_searchbox(customerName)
		  .click_search_in_search_for_accounts_tab()
		  .click_register_button()
		  .wait_until(2)
		  .click_no_in_onsite_popup();
	 get(NormalRegistrationPage.class)
		  .wait_until(8)
		  .click_normal_company_details_next_button()
		  .wait_until(8);
	 get(ExpressRegistrationPage.class)	
		  .select_type_of_business("Partnership")
			.wait_until(2)
			.select_normal_company_relationship_spend_tier("$10,000 - $25,000")
			.wait_until(2)
		    .click_normal_company_relationship_phi1_option("no")
		    .wait_until(2)
	        .click_normal_company_relationship_phi2_option("no")
	        .wait_until(2);
	 get(NormalRegistrationPage.class)
	        .click_normal_company_details_next_button();
	 get(ExpressRegistrationPage.class)	
			.enter_first_name(FName)
			.enter_last_name(LName)
			.enter_email(Email)
			.enter_phone(Phone)
			.wait_until(2)
			.click_contacts_next_button()
			.wait_until(5)
			.click_yes_for_minority_diversity()
			.select_minority_type_diversity(MinorityType)
			.select_certification_agency_diversity(certificationAgency)
			.enter_certication_number(certificationNumber)
			.enter_effective_date("06/15/2018")
			.wait_until(2)
	        .click_delete_uploaded_doc_diversity()
	        .wait_until(2);
		get(SSOCommonUtilities.class)
		 	.upload_file("D:\\Testing Document.docx")
		 	.wait_until(3);	
		 get(ExpressRegistrationPage.class)
		 	.enter_ethnicity_information("Express Flow")
		 	.click_diversity_details_next_button();
		 get(NormalRegistrationPage.class)
		 	.check_eula_license_aggement_checkbox()
	        .click_agreement_page_next_button()
	        .wait_until(5);
		 get(ExpressRegistrationPage.class)
		 	.click_Next_health_system_needed_button()
		 	.wait_until(3)
		 	.click_onboarding_category_save_next_button()
		 	.wait_until(3)
		 	.enter_ar_contact_mail("test@solution.net")
		 	.click_save_continue_form_button()
		 	.wait_until(3)
		 	.click_save_continue_form_button()
		 	.click_no_to_notify_customer_button()
		 	.click_close_onboardingregistration_button()
		 	.wait_until(3)
		 	.click_ok_registration_phase_popup_button()
		 	.wait_until(3);
		 get(NVDHomePage.class)
			.click_accounts_tab();
		get(NVDAccountPage.class)
			.enter_account_name(customerName)
			.click_search_button()
		 	.verify_account_name_text(customerName);
		get(SSOCommonUtilities.class) 
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session()
			.wait_until(3);
	}		
	
	@Test(priority = 5, groups = { "functional" })
	public void verifyExpressGRPInDatabase(){
		
		get(ConnectToDatabasePage.class)
			.wait_until(10)
			.fetch_grp_payemnt_detals_from_db(rep_id);
		
	}	
	
	@Test(priority = 6, groups = { "functional" })
	public void deleteExpressVC(){
		
	get(SSOLoginPage.class)
		.invoke_loginURL("ssoUrl")
		.enter_username(login_RM_id)
		.enter_password(RM_password)
		.click_login_button()
		.wait_until(10);
	get(SSOCommonUtilities.class)
    	.select_option_from_solution_selector("Vendormate Credentialing");
	get(CPMHomePage.class)
		.click_crm_support_tab()
		.click_crm_dashboard()
		.wait_until(5);
	get(RMDashLandingPage.class)    
	     .click_vendor_search_link()
	     .wait_until(5);
	get(RMDashVendorSearchPage.class)                 
	 	 .enter_vendor_name(vendorName)
	 	 .click_search_Vendor()
	 	 .click_radio_button()
	 	 .click_find_vc_relation();
	get(RMDashVCRelationshipPage.class)        
		 .enter_VC_name(customerName)
		 .click_continue_button()
		 .verify_rrp_comment(comment)
		 .select_VC_radio_button()
		 .click_delete_VC_button()
		 .click_delete_button()
		 .wait_until(3);	
	 get(RMDashVendorSearchPage.class)
	 	 .click_radio_button()
		 .click_find_vc_relation();	
	 get(RMDashSelectVCRelationshipPage.class)	  
	 	.enter_VC_name(customerName)
	 	.click_continue_button()
	 	.verify_deleted_VC_search_alert()
	 	.click_return_dashboard_button();
	get (RMDashLandingPage.class) 	
		.click_logout();
	get(SSOCommonUtilities.class)
		.clear_current_session();;
	}
	
}
