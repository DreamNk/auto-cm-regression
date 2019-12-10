package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.DataProvider;

import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.ConnectToDatabasePage;
import com.ghx.auto.cm.ui.sso.page.ConnectToMailBoxPage;
import com.ghx.auto.cm.ui.sso.page.CrMDashboardPage;
import com.ghx.auto.cm.ui.sso.page.ExpressRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.NetworkRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.NormalRegistrationPage;
import com.ghx.auto.cm.ui.sso.page.RMDashEditUserPage;
import com.ghx.auto.cm.ui.sso.page.RMDashLandingPage;
import com.ghx.auto.cm.ui.sso.page.RMDashSelectVCRelationshipPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVCRelationshipPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVRPReportPage;
import com.ghx.auto.cm.ui.sso.page.RMDashVendorSearchPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.support.excel.ExcelRow;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Registration_Test extends AbstractAutoUITest {

	String confirmYourProfile = "Step 5: Confirm Your Profile.";
	String gmailId="macro.rubbio@gmail.com";
	//String gmailId="pratiknagrale@gmail.com";
	String gmailPassowrd ="Gltd123@";
	String subject ="Vendormate Registration: Temporary Password";
	String vendormatePassword = "Gltd!123";
	//String repEmailId="macro.rubbio@gmail.com";
	String repEmailId="pratiknagrale@gmail.com";
	String vendorName="Jax Rx Inc";
	String taxId="593748930";        
	String customerName="Wayne Healthcare";
	String rmId="gopal.rm@vendormate.com";
	String rmPassword="Gltd123@";
	String message="There are no results for the specified search criteria.";
	
	// VRPR Report Data
	String vcStatus = "ACT";
	String vcCreateDate = "11/07/2017";
	String riskProfileComment = "Only spend Tier";
	String vcPaidThisTerm = "550";
	String repPaidForCredentialing = "Yes";
	String startDate = "11/07/2017";
	String endDate = "11/07/2017";
	String paymentTermStartDate = "Nov 07, 2017";
	String vcUpdatedDate = "Nov 07, 2017";
	String riskProfileAmount = "1000";
	String vcCreatedDate = "Nov 07, 2017";
	String paymentDate = "Nov 07, 2017";
	String paymentStatus = "OPYS";
	String renewalDate = "Nov 07, 2018";
	String paidByRepEmail = "macro.rubbio@gmail.com";
	String paymentSource = "RRP";
	
	// Express Data// 
	String vendormatePasswordExpress = "Gltd123@";
	String repEmailIdExpress="sam.josephg@gmail.com";
	String gmailPassowrdExpress ="Gltd!123";
	String vendorNameExpress="Jefferson Regional Medical Center";
	String taxIdExpress="710329353";
	String comment = "Express Registration";
	String FName = "Enrique";
	String LName =  "Igelsis";
	String Phone = "123456789";
	String Email =  "en@gmail.com";
	String MinorityType = "Asian";
	String certificationAgency = "Center for Women & Enterprise";
	String certificationNumber = "12345";


	//  Normal Registration         //
	@Test(priority=1, groups = {"functional"})                                         
	public void networkRegistrationForNormal(){
		get(SSOCommonUtilities.class)
			.clear_current_session();
		get(NetworkRegistrationPage.class)
			.invoke_loginURL("registrationUrl")
			.wait_until(20)
			.enter_email_address(repEmailId)
		    .click_next_button()
		    .wait_until(2)
		    .enter_federal_tax_id_in_serch_field(taxId)
		    .wait_until(2)
		    .click_search_tax_id_button()
		    .verify_prepopulated_tax_id(taxId)
		    .click_select_button()
		    .wait_until(3)
		    .click_validate_and_next_button()
			.wait_until(3)
			.verify_create_account_chevron("Create Profile")
			.wait_until(5)
			.select_salutation_from_dropdown("Mr")
			.enter_first_name("Automation")
			.enter_last_name("Rep")
			.enter_middle_name("nick")
			.enter_suffix("Dr")
			.enter_work_phone("45666666")
			.enter_job_title("Manager")
			.enter_supervisor_fname("Sam")
			.enter_supervisor_email("sam.joseph@yahoo.net")
			.enter_supervisor_lname("Joseph")
			.click_eula_checkbox()
			.click_create_account_chevron_submit_button()
			.wait_until(3)
			.verify_confirm_your_profile_text(confirmYourProfile)
			.clear_cookies();
			//close_popup_window();
		
	// to connect to mail box
		get(ConnectToMailBoxPage.class)
			.wait_until(5)
			.invoke_gmailURL("gmailUrl")
			.enter_mailId(gmailId)
			.click_next_button()
			.enter_password(gmailPassowrd)
			.click_signIn_button()
			.click_mail_Inbox_button()
			.click_mail_search_field()
			.enter_mail_subject(subject)
			.click_search_mail_button()
			.click_set_password_mail()
			.click_set_password_link();			
		get(NetworkRegistrationPage.class,focus_on_popup_window())
			.wait_until(20)		
			.enter_custom_password(vendormatePassword)
		   	.enter_confirm_password(vendormatePassword)
		   	.click_submit_password()
		   	.wait_until(20)
			.enter_health_system_name(customerName)
			.wait_until(5)
			.click_search_for_account_register_button()
			.wait_until(5)
			.click_search_for_account_popup_yes_button()
			.wait_until(5);
		get(NormalRegistrationPage.class)
			.click_normal_health_system_details_next_button()
			.wait_until(20);
		get(SSOCommonUtilities.class)    
	        	.wait_for_text_appear("Next") ;   //Wayne//
	    get(NormalRegistrationPage.class)	
	        .click_normal_company_relationship_existing_relationship_option("no")
	        .select_normal_company_relationship_spend_tier("$1001 - $1500")
	        .enter_normal_company_relationship_employee_count("5")
	        .click_normal_company_relationship_onsite_option("no")
	        .click_normal_company_relationship_q1_option("no")
	        .click_normal_company_relationship_q2_option("no")
	        .click_normal_company_relationship_q3_option("no")
	        .click_normal_company_relationship_q4_option("no")
	        .click_normal_company_relationship_q5_option("no")
	        .click_normal_company_relationship_phi1_option("no")
	        .click_normal_company_relationship_phi2_option("no")
	        .click_normal_company_relationship_next_button()
	        .wait_until(10);
	    get(SSOCommonUtilities.class)  
	        .wait_for_text_appear("Next");
	    get(NormalRegistrationPage.class)
	        .select_rep_risk_question_1("no")
	        .select_rep_risk_question_2("no")
	        .select_rep_risk_question_3("no")
	        .select_rep_risk_question_4("no")
	        .select_rep_risk_question_5("no")
	        .select_dynamic_question(1, "no")
	        .select_dynamic_question(2, "no")
	        .select_rep_risk_on_site_question("no")
	        .wait_until(10)      
	        .click_your_relationship_page_next_button()
	        .wait_until(7);
	    get(SSOCommonUtilities.class)  
	        .wait_for_text_appear("Next");  // Terms //
	    get(NormalRegistrationPage.class) 
	        .click_relationship_no_radio_button()
	        .click_affiliations_no_radio_button()
	        .click_compensation_no_radio_button()
	        .check_eula_license_aggement_checkbox()
	        .click_agreement_page_next_button()
	        .wait_until(10);
	    get(SSOCommonUtilities.class)  
	        .wait_for_text_appear("Wayne");
	    get(NormalRegistrationPage.class)
	        .enter_payment_billing_address("Main Street")
	        .enter_payment_billing_city("Chicago")
	        .select_payment_billing_state("Illinois")
	        .select_payment_billing_country("United States")
	        .enter_payment_billing_zip("23434")
	        .enter_payment_billing_email("payment.rep@payment.vm")
	        .click_payment_checkbox1()
	        .click_payment_checkbox2()
	        .click_payment_checkbox3()
	        .click_payment_checkbox4()
	        .verify_payment_amount_billing_info_page("$550.00")
	        .click_payment_charge_and_continue_button_normal()
	        .wait_until(3)
	        .click_billing_page_next_button_popup()
	        .wait_until(7)
	        .switch_to_payment_iframe()
	        .verify_payment_amount_checkout_page("$550.00")
	        .enter_payment_nameoncard("Payment Rep")
	        .enter_payment_cardnumber("341134113411347")
	        .enter_payment_verification_number("1234")
	        .select_payment_cardtype("American Express")
	        .select_payment_expirationmonth("12")
	        .select_payment_expirationyear("2020")
	        .click_payment_submit_button()
	        .wait_until(7)
	        .switch_to_root_page()
	        .click_payment_received_popup_next_button()
	        .wait_until(10);
	    get(SSOCommonUtilities.class)
	        .wait_for_text_appear("Next");  // Federal //;
		get(ExpressRegistrationPage.class)	
			.select_type_of_business("Partnership")
			.wait_until(2)
			.select_normal_company_relationship_spend_tier("$10,000 - $25,000")
			.wait_until(2)
			.enter_company_website("www.jax.net")
			.wait_until(2)
		    .click_normal_company_relationship_phi1_option("no")
		    .wait_until(2)
	        .click_normal_company_relationship_phi2_option("no")
	        .wait_until(2);
		get(NormalRegistrationPage.class)
	        .click_normal_company_details_next_button()
	        .wait_until(5);
		get(SSOCommonUtilities.class)  
	        .wait_for_text_appear("Wayne");  
		get(ExpressRegistrationPage.class)
			.enter_first_name(FName)
			.enter_phone(Phone)
			.click_contacts_next_button()
			.wait_until(3);
		get(SSOCommonUtilities.class)  	
			.wait_for_text_appear("Wayne"); 
		get(ExpressRegistrationPage.class)	
			.wait_until(3)
		 	.click_diversity_details_next_button()
		 	.wait_until(2);
		get(ExpressRegistrationPage.class)
		 	.click_Next_health_system_needed_button()
		 	.wait_until(3);
		get(SSOCommonUtilities.class)  
			.wait_for_text_appear("Learn");
		 get(ExpressRegistrationPage.class)	
	 		.wait_until(3)
		 	.click_onboarding_category_save_next_button()
		 	.wait_until(3);
		 get(SSOCommonUtilities.class)  
		 	.wait_for_text_appear("Form");
		 get(ExpressRegistrationPage.class)	
		 	.enter_ar_contact_mail("test@solution.net")
		 	.click_save_continue_form_button()
		 	.wait_until(3)
		 	.click_save_continue_form_button()
		 	.click_no_to_notify_customer_button()
		 	.click_close_onboardingregistration_button()
		 	.wait_until(3)
		 	.click_ok_registration_phase_popup_button()
		 	.wait_until(10);
		get(NVDHomePage.class)
			.click_accounts_tab();
		get(NVDAccountPage.class)
			.enter_account_name(customerName)
			.click_search_button()
		 	.verify_account_name_text(customerName);
		get(SSOCommonUtilities.class) 
			.select_option_from_userName_dropdown("Logout");
	
		
	}
	
	@Test(priority = 2, groups = { "functional" })
	public void VerifyPaymentDetalisWithDatabase() {
		get(ConnectToDatabasePage.class)
		.wait_until(10)
		.fetech_payemnt_detals_from_db();
		
	}

	@Test(priority=3, groups = {"functional"})  
	public void LogOutGmailNormal(){
		get(SSOCommonUtilities.class)
		.wait_until(2);
		close_popup_window();
	get(SSOCommonUtilities.class, focus_on_parent_window());
		
	get(ConnectToMailBoxPage.class)
		.wait_until(2)
		.click_name_selector()
		.wait_until(2)
		.click_sign_out();
	
	get(SSOCommonUtilities.class)
		.clear_current_session();
	}
		
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyPaymentDetails(){
		get(SSOLoginPage.class)
	        .invoke_loginURL("ssoUrl")
	        .enter_username(rmId)
	        .enter_password(rmPassword)
	        .click_login_button()
	        .wait_until(10);
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(5);	
		get(CPMHomePage.class)
	        .click_crm_support_tab()
	        .click_crm_dashboard()
	        .wait_until(5);
	}
	/*
		get(RMDashLandingPage.class)
			.click_vrpr_report();
		get(RMDashVRPReportPage.class)
    		.enter_google_search_string(repEmailId)
    		.click_continue_button()
    		.wait_until(5);
	get(CrMDashboardPage.class)
			.verify_vendor_vrpr(vendorName)
		    .verify_vc_status_vrpr(vcStatus)
		    .verify_vc_create_date_vrpr()
		    .verify_risk_profile_comment_vrpr(riskProfileComment)
		    .verify_vc_paid_this_term_vrpr(vcPaidThisTerm)
		    .verify_rep_paid_for_credentialing_vrpr(repPaidForCredentialing)
		    .click_back_button()
		    .wait_until(5);

	}
	
	@Test(priority = 4, groups = { "functional" })
	public void ChecksFromPaymentProfile() {
		get(CrMDashboardPage.class)
			.click_payment_profile()
			.enter_todays_date()
			.enter_end_date(endDate)
			.enter_user_email(repEmailId)
			.click_continue_button()
			.wait_until(5)
			.verify_customer_name(customerName)
			.verify_legal_name(vendorName)
			.verify_vc_status(vcStatus)
			.verify_payment_term_start_date(paymentTermStartDate)
			.verify_vc_create_date()
			.verify_vc_updated_date(vcUpdatedDate)
			//.verify_risk_profile_comment(riskProfileComment)
			.verify_risk_profile_amount(riskProfileAmount)
			.verify_payment_date(paymentDate)
			.verify_payment_status(paymentStatus)
			.verify_renewal_date(renewalDate)
			.verify_paid_by_rep_email(paidByRepEmail)
			.verify_payment_source(paymentSource)
			.click_logout_button();
	}
*/
	@Test(priority=5, groups = {"functional"})                                         
	public void deleteVC(){
		
		get (RMDashLandingPage.class)    
	      .click_vendor_search_link()
	      .wait_until(5);
	
		get (RMDashVendorSearchPage.class)                 
	 	  .enter_vendor_name(vendorName)
	 	  .click_search_Vendor()
	 	  .click_radio_button()
	 	  .click_find_vc_relation();
	
	    get (RMDashVCRelationshipPage.class)        
		  .enter_VC_name(customerName)
		  .click_continue_button()
		  .select_VC_radio_button()
		  .click_delete_VC_button()
		  .click_delete_button()
		  .wait_until(3);
	  get (RMDashVCRelationshipPage.class)	  
	 	  .click_return_dashboard_button()
	 	  .wait_until(3);
	  get (RMDashLandingPage.class) 	
		  .click_edit_user_link()
		  .wait_until(3);
	  get (RMDashEditUserPage.class) 	
		.enter_rep_email(repEmailId)
		.click_search_rep_user_button()
		.wait_until(2)
		.click_on_rep_id(repEmailId)
		.wait_until(2)
		.click_delete_user_button()
		.wait_until(2)
		.click_complete_button()
		.wait_until(3);
	  get (RMDashVendorSearchPage.class)	  
	 	  .click_log_out();
	  get(SSOCommonUtilities.class)
		 .clear_current_session();
	}
	
	//   Express Registration         //
	@Test(priority=5, groups = {"functional"})

	public void networkRegistrationForExpress(){
		
		 get(SSOCommonUtilities.class)
			.clear_current_session();
		
		get(NetworkRegistrationPage.class)
		.invoke_loginURL("registrationUrl")
		.wait_until(20)
		.enter_email_address(repEmailIdExpress)
		.wait_until(5)
	    .click_next_button()
	    .wait_until(3)
	    .enter_federal_tax_id_in_serch_field(taxIdExpress)
	    .wait_until(2)
	    .click_search_tax_id_button()
	    .verify_prepopulated_tax_id(taxIdExpress)
	    .click_select_button()
	    .wait_until(2)
	    .click_validate_and_next_button()
		.wait_until(3)
		.verify_create_account_chevron("Create Profile")
		.wait_until(5)
		.select_salutation_from_dropdown("Mr")
		.enter_first_name("Sam")
		.enter_last_name("Express")
		.enter_middle_name("Auto")
		.enter_suffix("Dr")
		.enter_work_phone("9988998877")
		.enter_job_title("Sales Manager")
		.enter_supervisor_fname("Jumble")
		.enter_supervisor_email("chavo.joseph@yahoo.net")
		.enter_supervisor_lname("Chavo")
		.click_eula_checkbox()
		.click_create_account_chevron_submit_button()
		.wait_until(3)
		.verify_confirm_your_profile_text(confirmYourProfile)
		.clear_cookies();
		close_popup_window();
	
// to connect to mail box
	get(ConnectToMailBoxPage.class)
		.wait_until(5)
		.invoke_gmailURL("gmailUrl")
		.enter_mailId(repEmailIdExpress)
		.click_next_button()
		.enter_password(gmailPassowrdExpress)
		.click_signIn_button()
		.click_mail_Inbox_button()
		.click_mail_search_field()
		.enter_mail_subject(subject)
		.click_search_mail_button()
		.click_set_password_mail()
		.click_set_password_link();			
		
	get(NetworkRegistrationPage.class,focus_on_popup_window())
		.wait_until(20)
		.enter_custom_password(vendormatePassword)
	   	.enter_confirm_password(vendormatePassword)
	   	.click_submit_password()
	   	.wait_until(20)   	
		.enter_health_system_name(customerName)
		.wait_until(5)
		.click_search_for_account_register_button()
		.wait_until(5)
		.click_search_for_account_popup_no_button()
		.wait_until(5);
	get(NormalRegistrationPage.class)
		.wait_until(8);
	get(SSOCommonUtilities.class)  
		.wait_for_text_appear("Wayne");
	get(NormalRegistrationPage.class)
		.click_normal_company_details_next_button()
		.wait_until(3);
	get(SSOCommonUtilities.class,focus_on_popup_window())
		.wait_for_text_appear("Wayne");
	get(NormalRegistrationPage.class)	
	 .enter_payment_billing_address("Main Street")
     .enter_payment_billing_city("Chicago")
     .select_payment_billing_state("Illinois")
     .select_payment_billing_country("United States")
     .enter_payment_billing_zip("23434")
     .enter_payment_billing_email("payment.rep@payment.vm")
     .click_payment_checkbox1()
     .click_payment_checkbox2()
     .click_payment_checkbox3()
     .click_payment_checkbox4()
     .verify_payment_amount_billing_info_page("$50.00")
     .click_payment_charge_and_continue_button_normal()
     .wait_until(3)
     .click_billing_page_next_button_popup()
     .wait_until(7)
     .switch_to_payment_iframe()
     .verify_payment_amount_checkout_page("$50.00")
     .enter_payment_nameoncard("Payment Rep")
     .enter_payment_cardnumber("341134113411347")
     .enter_payment_verification_number("1234")
     .select_payment_cardtype("American Express")
     .select_payment_expirationmonth("12")
     .select_payment_expirationyear("2020")
     .click_payment_submit_button()
     .wait_until(7)
     .switch_to_root_page();
	get(SSOCommonUtilities.class)  
	 	.wait_for_text_appear("Wayne"); 
	 get(ExpressRegistrationPage.class)
		.select_type_of_business("Partnership")
		.wait_until(2)
		.select_normal_company_relationship_spend_tier("$10,000 - $25,000")
		.wait_until(2)
		.click_normal_company_relationship_phi1_option("yes")
		.wait_until(2)
		.click_normal_company_relationship_phi2_option("yes")
		.wait_until(2);
	get(NormalRegistrationPage.class)
   		.click_normal_company_details_next_button();
	get(SSOCommonUtilities.class)  
   		.wait_for_text_appear("Wayne");
	get(ExpressRegistrationPage.class)
		.enter_first_name(FName)
		.enter_last_name(LName)
		.enter_email(Email)
		.enter_phone(Phone)
		.wait_until(2)
		.click_contacts_next_button()
		.wait_until(5)
		.click_yes_for_minority_diversity()
		.wait_until(5)
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
 		.click_save_continue_form_button()
 		.wait_until(3);
	get(SSOCommonUtilities.class)  
 		.wait_for_text_appear("EEO");
	get(ExpressRegistrationPage.class)	
		.click_save_continue_form_button()
		.wait_until(3)
 		.click_no_to_notify_customer_button()
 		.wait_until(3)
 		.click_close_onboardingregistration_button()
 		.wait_until(3)
 		.click_ok_registration_phase_popup_button()
 		.wait_until(5);
	get(NVDHomePage.class)
		.click_accounts_tab();
	get(NVDAccountPage.class)
		.enter_account_name(customerName)
		.click_search_button()
		.verify_account_name_text(customerName);
	get(SSOCommonUtilities.class) 
		.select_option_from_userName_dropdown("Logout")
		.wait_until(3);
	
	}
	
	@Test(priority = 6, groups = { "functional" })
	public void verifyInDatabaseExpress(){
		
		get(ConnectToDatabasePage.class)
			.wait_until(10)
			.fetch_express_payemnt_detals_from_db(repEmailIdExpress);
	
	}

	
	@Test(priority=7, groups = {"functional"})  
	public void LogOutGmailExpress(){
		get(SSOCommonUtilities.class)
		.wait_until(2);
		close_popup_window();
	get(SSOCommonUtilities.class, focus_on_parent_window());
		
	get(ConnectToMailBoxPage.class)
		.wait_until(2)
		.click_name_selector()
		.click_sign_out();
	get(SSOCommonUtilities.class)
		.clear_current_session();
	
	}
	
	@Test(priority = 8, groups = { "functional" })
	public void deleteExpressVCAndUser(){
		
	get(SSOLoginPage.class)
		.invoke_loginURL("ssoUrl")
		.enter_username(rmId)
		.enter_password(rmPassword)
		.click_login_button()
		.wait_until(10);
	get(SSOCommonUtilities.class)
    	.select_option_from_solution_selector("Vendormate Credentialing");
	get(CPMHomePage.class)
		.click_crm_support_tab()
		.click_crm_dashboard()
		.wait_until(5);
	get (RMDashLandingPage.class) 	
		.click_edit_user_link()
		.wait_until(3);
	get (RMDashEditUserPage.class) 	
		.enter_rep_email(repEmailIdExpress)
		.click_search_rep_user_button()
		.wait_until(2)
		.click_on_rep_id(repEmailIdExpress)
		.wait_until(2)
		.click_delete_user_button()
		.wait_until(2)
		.click_complete_button()
		.wait_until(3);
	get(RMDashLandingPage.class)    
	      .click_vendor_search_link()
	      .wait_until(5);
	get(RMDashVendorSearchPage.class)                 
	 	  .enter_vendor_name(vendorNameExpress)
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
	 	 .click_return_dashboard_button()
	 	 .wait_until(3);
	 get (RMDashLandingPage.class) 	
	 	 .click_logout();
	 get(SSOCommonUtilities.class)
		.clear_current_session();
	}
	
}
