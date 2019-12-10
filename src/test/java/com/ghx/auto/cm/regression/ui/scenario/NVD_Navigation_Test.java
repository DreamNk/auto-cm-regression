package com.ghx.auto.cm.regression.ui.scenario;


import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDAccountsPage;
import com.ghx.auto.cm.ui.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.page.NVDExtrasPage;
import com.ghx.auto.cm.ui.page.NVDHomePage;
import com.ghx.auto.cm.ui.page.NVDManageRepsPage;
import com.ghx.auto.cm.ui.page.NVDMyDocumentPage;
import com.ghx.auto.cm.ui.page.NVDMyProfileTabPage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class NVD_Navigation_Test extends AbstractAutoUITest{
	
	
	String UserID = "anaida.gillbert@av1.vm";
	String PeerRepID = "autorep1@av1.vm";
	String PeerRepFirstName = "Auto";
	String PeerRepLastName = "Repone";	
	

	@Test(priority=1, groups = {"functional"})
	public void verifyCommonDocumentAlertLink() {
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username(UserID)
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		get(NVDHomePage.class)
		    .click_common_document_alert_link()
		    .verify_common_missing_document("T-AD-Auto (OPREP Sharable) - 1")
		    .close_popup();
	}
	
	
	@Test(priority=2, groups = {"functional"})
	public void verifyAccountSpecificDocumentAlertLink(){	
		get(NVDHomePage.class)
		    .click_account_specific_document_alert()
		    .verify_account_specific_missing_document("T-AD-Auto (OPREP Non Sharable) - 1")
		    .close_popup();
	}
		    
	
	@Test(priority=3, groups = {"functional"})
	public void verifyPolicyAlertLink(){	 
	    get(NVDHomePage.class)
		    .click_no_policy_alert_link()
		    .verify_policies("T-AD-Auto (Acknowledgement) - 1")
		    .click_back_to_home();
	}
	    
	    
	@Test(priority=4, groups = {"functional"})
	public void verifyIncompleteRegistrationAlertLink(){
		get(NVDHomePage.class)
		    .click_incomplete_registration_alert()
		    .verify_incomplete_account("Grace_Medical_Center")
		    .click_back_to_home();
	}
	
	
	@Test(priority=5, groups = {"functional"})
	public void verifyHealthSystemAlertLink(){
		get(NVDHomePage.class)
		    .click_health_system_alert()
		    .verify_fail_account("Tahoe Forest Health System")
		    .click_back_to_home();
	}
	

	@Test(priority=6, groups = {"functional"})
	public void verifyConnectHealthSystemAlertLink(){
		get(NVDHomePage.class)
		    .click_connect_with_new_health_system();
	    get(NVDAccountsPage.class)
		    .verify_state_name_in_text_field_of_search_for_accounts_tab("Alabama");
	    get(NVDHomePage.class)
		    .click_back_to_home();
	}
	
	
	@Test(priority=7, groups = {"functional"})
	public void verifyClearForAccessLink(){
		get(NVDHomePage.class)
		    .click_am_i_clear_for_access()
		    .verify_heder_text("Select an appointment or account")
        	.click_back_to_home();
	}
	
	
	@Test(priority=8, groups = {"functional"})
	public void verifyBadgePhotoLink(){
		get(NVDHomePage.class)
	        .click_update_badge_photo()
		    .verify_badge_photo_text("Please update your photo below. It will appear on any badge you print and will be displayed in your profile. By uploading, you certify that you have the right to distribute this photo.")
	        .click_back_to_home();
    }
	
	@Test(priority=9, groups = {"functional"})
	public void verifyMyDocumentCommonDocs(){
		get(NVDMyDocumentPage.class)
			.click_my_document_tab()
			.click_view_account_link_of_common_doc()
			.verify_common_doc_account("Tahoe Forest Health System")
			.click_close_popup();
	}
	
	@Test(priority=10, groups = {"functional"})
	public void verifyMyDocumentPolicies(){
		get(NVDMyDocumentPage.class)
	    	.click_view_account_link_policies()
	    	.verify_policies_account("Tahoe Forest Health System")
	    	.click_close_popup();
	}
	    
	@Test(priority=11, groups = {"functional"})
	public void verifyMyDocumentAccountSpecificDoc(){
		get(NVDMyDocumentPage.class)	
			.click_account_specific_document_tab()
			.click_view_account_link_of_account_specific_doc_account()
			.verify_account_specific_doc_account("Tahoe Forest Health System")
			.click_close_popup();
	}
	
	@Test(priority=12, groups = {"functional"})
	public void verifyMyDocumentOptionalDoc(){
		get(NVDMyDocumentPage.class)
	    	.click_optional_doc_tab()
	    	.wait_until(5)
	    	.click_view_account_link_optional_doc()
	    	.verify_optional_doc_account("Tahoe Forest Health System")
	    	.click_close_popup();
	}
	    
	@Test(priority=13, groups = {"functional"})
	public void verifyMyDocumentShareCredentialsButton(){
		get(NVDMyDocumentPage.class)
			.click_share_credential_button()
			.verify_sharable_doc("T-AD-Auto (OPREP Sharable) - 3")
			.click_back_to_my_document_link();
	}
	    
	@Test(priority=14, groups = {"functional"})
	public void verifyActiveAccountsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
			.click_accounts_tab()
			.verify_company_status_for_second_record("Active");
	}
	
	@Test(priority=15, groups = {"functional"})
	public void verifyAccountSearchWithEnteringText(){
		get(NVDAccountsPage.class)
			.enter_account_name("Grace")
			.wait_until(4)
			.click_search_button_in_manage_my_accounts()
			.verify_account_link("Grace_Medical_Center");
	}
	
	    
	@Test(priority=16, groups = {"functional"})
	public void verifyIncompleteRegistrationsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
			.click_accounts_tab()
			.click_incomplete_registered_account_dropdown()
			.verify_incomplete_registered_account("Incomplete Registration");
	}
	
	@Test(priority=17, groups = {"functional"})
	public void verifyFailedHealthSystemsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
			.click_fail_health_system_dropdown()
			.verify_requirement_status("FAIL");
	}
	
	@Test(priority=18, groups = {"functional"})
	public void verifyInactiveAccountsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
	    	.click_inactive_accounts_dropdown()
	    	.click_select_action_dropdown_in_inactive_accounts()
	    	.verify_activate_account_option("Activate Account");
	}
	
	@Test(priority=19, groups = {"functional"})
	public void verifyAccountLinkIsNavigatedToAccountDetails(){
		get(NVDAccountsPage.class)
			.click_all_active_accounts_dropdown()
			.click_account_link("Grace_Medical_Center")
			.verify_registration_URL_in_account_details("gracehealthsystem.vendormate.net")
			.click_back_to_list();
	}

	@Test(priority=20, groups = {"functional"})
	public void Verify_View_Location_Link(){
		get(NVDAccountsPage.class)
	    	.click_view_location_link()
	    	.verify_location_popup("atlanta 1");
	    get(NVDMyDocumentPage.class)
	    	.click_close_popup();   
	}
	    
	@Test(priority=21, groups = {"functional"})
	public void Verify_Requirement_Status_is_Navigated_To_Docs_And_Policies(){
		get(NVDAccountsPage.class)
	    	.click_fail_requirement_status_link()
	    	.wait_until(5)
	    	.verify_document_status_of_1st_document("Missing")
	    	.click_back_to_list();
	}
	
	@Test(priority=22, groups = {"functional"})
	public void Verify_Search_Accounts_By_State(){
		get(NVDAccountsPage.class)
			.click_search_for_accounts_accordion()
			.click_search_button_to_search_by_state_in_search_for_accounts_accordion()
			.verify_unregistered_account("Antelope Valley Hospital");
	}
	    
	@Test(priority=23, groups = {"functional"})
	public void Verify_Search_Accounts_By_Keyword(){
		get(NVDAccountsPage.class)   
			.click_search_by_keyword_radio_button()
			.wait_until(5)
			.enter_account_name_in_textbox("baptist")
			.wait_until(3)
			.click_search_button_to_search_by_keyword_in_search_for_accounts_accordion()
			.verify_unregistered_account("Baptist Health South Florida");
	}
	 
	@Test(priority=24, groups = {"functional"})
	public void verifyRepEmailAddressSearchInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.clickManageRepsTab()
			.enter_rep_mail_id_in_rep_email_address_text_box_of_access_rep_account_accordion(PeerRepID)
			.wait_until(5)
			.click_search_button_in_access_rep_accounts_accordion()
			.verify_1st_record_of_user_email_column_in_access_rep_account_accordion(PeerRepID);
	}
	    
	@Test(priority=25, groups = {"functional"})
	public void VerifyAssociatedCompaniesLinkInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.click_associated_companies_link()
			.verify_taxID_in_associated_company_popup("autov1");
		get(NVDMyDocumentPage.class)
	     	.click_close_popup();
	}   
	    
	@Test(priority=26, groups = {"functional"})
	public void VerifyUserEmailIsNavigatedToRepDetailsInAccessRepAccountsAccordion(){
		get(NVDManageRepsPage.class)   
			.click_show_all_radio_button_in_access_rep_accounts_accordion()
			.wait_until(6)
			.click_3rd_record_of_user_email_column_in_access_rep_account_accordion()
			.wait_until(4)
			.verify_peer_reps_accounts_details_tab_under_manage_rep_tab("Account Details")
	        .verify_peer_reps_rep_documents_tab_under_manage_rep_tab("Rep Documents")
	        .verify_peer_reps_user_profile_tab_under_manage_rep_tab("User Profile")
	        .verify_peer_reps_company_profile_tab_under_manage_rep_tab("Company Profile")
	        .verify_peer_reps_clear_for_access_tab_under_manage_rep_tab("Cleared For Access")
	        .click_back_to_list_link_in_rep_account_details_accordion();
	}
	   
	@Test(priority=27, groups = {"functional"})
	public void VerifyFirstNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_invite_reps_accordion()
		   .click_first_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepFirstName)
		   .verify_1st_record_in_first_name_column_of_invite_reps(PeerRepFirstName);
	}
	
	@Test(priority=28, groups = {"functional"})
	public void VerifyLastNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_last_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepLastName)
		   .verify_1st_record_in_last_name_column_of_invite_reps(PeerRepLastName);
	}
	
	@Test(priority=29, groups = {"functional"})
	public void VerifyEmailSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_email_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps("autorep1@")
		   .verify_1st_record_in_email_column_of_invite_reps(PeerRepID);
	}
	
	@Test(priority=30, groups = {"functional"})
	public void VerifySearchAccountInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_search_by_account_radio_button_in_invites_reps()
		   .enter_search_string_in_account_search_textbox_of_invite_reps("grace")
		   .wait_until(3)
		   .verify_1st_searched_account_in_invite_reps("Grace_Medical_Center");
	}
	
	@Test(priority=31, groups = {"functional"})
	public void VerifyInviteRep(){
		get(NVDManageRepsPage.class)
	    	.click_1strep_radio_button_in_invites_reps()
	    	.wait_until(4)
	    	.click_1st_account_checkbox_in_invites_reps()
		    .click_add_to_invitee_list_button_in_invites_reps()
	    	.verify_rep_email_in_invitee_list_of_invite_reps(PeerRepID);
	}
	
	@Test(priority=32, groups = {"functional"})
	public void VerifyFirstNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_share_staff_credentials_accordion()
	    	.click_first_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion(PeerRepFirstName)
	    	.verify_1st_record_of_first_name_column_in_share_staff_credentials_accordion(PeerRepFirstName);
	}
	
	@Test(priority=33, groups = {"functional"})
	public void VerifyLastNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_last_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion(PeerRepLastName)
	    	.verify_1st_record_of_last_name_column_in_share_staff_credentials_accordion(PeerRepLastName);
	}
	
	@Test(priority=34, groups = {"functional"})
	public void VerifyEmailSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_email_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.wait_until(2)
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("autorep1@")
	    	.verify_1st_record_of_email_column_in_share_staff_credentials_accordion(PeerRepID);
	}
	
	@Test(priority=35, groups = {"functional"})
	public void VerifyProfessionalTitleSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_professional_title_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Miss")
	    	.verify_1st_record_of_professional_title_column_in_share_staff_credentials_accordion("Miss");
		}
	
	
	@Test(priority=36, groups = {"functional"})
	public void VerifyShareLinkInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
		    .click_1st_record_share_link_in_share_staff_credentials_accordion()
		    .wait_until(2)
		    .verify_sharable_document_in_share_credentials_accordion("T-AD-Auto (OPREP Sharable)")
		    .click_back_to_share_staff_credential_link_in_share_credential_accordion();  
		}
	
	
	@Test(priority=37, groups = {"functional"})                                         
	public void verifyCompanyProfilePage(){
		get(NVDRootPage.class)
		    .click_user_name_dropdown()
		    .click_company_profile();
	
		get(NVDCompanyProfilePage.class)
		.verify_company_profile_page_footer_title("Accuracy Information")
		.verify_company_profile_page_footer_text("By continuing and submitting this information, you affirm that none of the responses set forth knowingly contain any untrue or incomplete statements of fact or omissions of any information that would make the above responses misleading.");
		
	}	
	
	    // Testcase to Verify Company Information Accordion
	
	@Test(priority=38, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordion(){
		get(NVDCompanyProfilePage.class)
		    .verify_company_information_accordion_title("Company Information")
		    .verify_legal_name("Auto Vendor 1")
		    .verify_tax_id("autov1")
		    .verify_duns_number("786786786");
		
	}
	
		// Testcase to Verify Company Information Accordion Help text
	
	@Test(priority=39, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_company_information_help_link()
			.verify_company_information_help_text("This section contains information about your company and is used for credit scoring and supplier evaluations.")
			.click_company_information_help_popupclose();
		
	}
	
		// Testcase to Verify Company Contact Information Accordion
	
	@Test(priority=40, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_contact_information_accordion()
			.verify_company_contact_information_accordion_title("Company Contact Information")
			.verify_headquarter_city("Yonkers")
			.verify_headquarter_state("New York")
			.verify_headquarter_zipcode("12121");
		
	}
	
		// Testcase to Verify Company Contact Information Accordion Help Text
	
	@Test(priority=41, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_company_contact_information_help_link()
			.verify_company_contact_information_help_text("This section contains contact information about your company. This information may be different than your local business operations.")
			.click_company_information_help_popupclose();
		
			
	}
	
		// Testcase to Verify Company Logo Accordion
	
	@Test(priority=42, groups = {"functional"})                                         
	public void verifyCompanyLogoAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_logo_accordion()
			.verify_company_logo_accordion_title("Company Logo")
			.verify_company_logo_text("Upload your company logo to promote your participation in our program. Your logo will be displayed on your customer's view into our application.")
			.click_company_logo_edit_button()
			.verify_company_logo_file_name("File Name:  AutoVendorLogo.jpg");
			
	
	}
		
		// Testcase to Verify Company Principals Accordion
		
	@Test(priority=43, groups = {"functional"})                                         
	public void verifyCompanyPrincipalsAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_principals_accordion()
			.verify_company_principals_username("Tim Johnson")
			.verify_company_principals_email("tim.johnson@av1.vm")
			.click_company_principals_addbutton()
			.verify_company_principals_addbutton_popup_title("Add Company Principal")
			.click_company_principals_addbutton_popupclose();
								
		
	}
		// Testcase to Verify Company Principals Accordion Help Text
			
	@Test(priority=44, groups = {"functional"})                                         
	public void verifyCompanyPrincipalsAccordionHelp(){
		get(NVDCompanyProfilePage.class)
		    .wait_until(2)
			.click_company_principals_help()
			.verify_company_principals_help_text("Some government regulations require screening a company's principals. Provide basic information about your company's principals, e.g., president, CEO, etc.")
			.click_company_principals_help_popupclose();					
			
	}
		// Testcase to Verify Geographic Sales Capability Accordion
			
	@Test(priority=45, groups = {"functional"})                                         
	public void verifyGeographicSalesCapabilityAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_geographic_sales_capability_accordion()
			.verify_geographic_sales_capability_accordion_title("Geographic Sales Capability")
			.verify_geographic_sales_capability_accordion_states("New York")
			.verify_geographic_sales_capability_accordion_countries("United States");
												
	}
		// Testcase to Verify Geographic Sales Capability Accordion Help Text
				
	@Test(priority=46, groups = {"functional"})                                         
	public void verifyGeographicSalesCapabilityAccordionHelp(){
	    get(NVDCompanyProfilePage.class)
			.click_geographic_sales_capability_accordion_help()
			.verify_geographic_sales_capability_accordion_help_text("Highlight each of the locations in the first column where your company sells or serves customers. Use CTRL CLICK to select more than one location. Click the arrow keys to add the highlighted selection to the list. Double arrows move all locations.")
			.click_geographic_sales_capability_accordion_help_popupclose();
			
	}		
			
			// Testcase to Verify Diversity Information Accordion
			
	@Test(priority=47, groups = {"functional"})                                        
	public void verifyDiversityInformationAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion()
			.verify_diversity_information_accordion_title("Diversity Information")
			.verify_diversity_information_accordion_womanowned_agency("Women Presidents' Educational Org. - New York")
			.verify_diversity_information_accordion_womanowned_expiration("12/31/2016")
			.click_diversity_information_accordion_womanowned_certificationview()
			.wait_until(5);
				
		get(NVDCompanyProfilePage.class, focus_on_popup_window())
			.wait_until(3)
			.verify_diversity_information_woman_owned_certificate();
		    focus_on_popup_window().close();
				
		get(NVDCompanyProfilePage.class, focus_on_parent_window())
			.verify_diversity_information_accordion_gender("Female")
			.verify_diversity_information_accordion_ethnicity("Indian");
				
	}	
			
			// 	Testcase to Verify Diversity Information Accordion Help Text 
			
	@Test(priority=48, groups = {"functional"})                                        
	public void verifyDiversityInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion_help()
			.verify_diversity_information_accordion_help_text("Some health systems use diversity as part of their vendor selection criteria. If your company has a certified diversity designation, please specify that here.")
			.click_company_information_help_popupclose();
										
	}
			
           //	Testcase to Verify Compliance Officer Accordion  
	@Test(priority=49, groups = {"functional"})                                        
	public void verifyComplianceOfficerAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_compliance_officer_accordion()
			.verify_compliance_officer_accordion_title("Compliance Officer")
			.verify_compliance_officer_accordion_firstname("Jim")
			.verify_compliance_officer_accordion_lastname("Morrison")
			.verify_compliance_officer_accordion_email("jim.morrison@av1.vm");
			
				
	}
			
           //	Testcase to Verify Compliance Officer Accordion Help Text
	@Test(priority=50, groups = {"functional"})                                        
	public void verifyComplianceOfficerAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_compliance_officer_accordion_help()
			.verify_compliance_officer_accordion_help_text("Identify your company's compliance officer. This person is responsible for compliance oversight and issue resolution.")
			.click_compliance_officer_accordion_help_popupclose();
				
    }			
			
			
	@Test(priority=51, groups = {"functional"})                                        
	public void verifyContactAndPersonalInformation() throws Throwable  {
		get(NVDloginPage.class)
			.click_username_action_dropdown();
		get(NVDRootPage.class)
			.click_my_profile()
			.wait_until(5);
		get(NVDMyProfileTabPage.class)
			.verify_contact_and_personal_information("Anaida");
				
			}
				
	@Test(priority=52, groups = {"functional"})                                        
	public void verifyAddressAndInformation(){
		get(NVDMyProfileTabPage.class)
			.click_address_and_information_accordion()
			.wait_until(3)
			.verify_work_email_in_address_and_information_accordion("anaida.gillbert@av1.vm");
	}
			
	
	@Test(priority=53, groups = {"functional"})                                        
	public void verifyBadgePhoto(){
		get(NVDMyProfileTabPage.class)
			.click_badge_photo_accordion()
			.wait_until(5)
			.verify_badge_photo_text("Please update your photo");
	}
				
				
    @Test(priority=54, groups = {"functional"})                                        
	public void verifyProductAndService(){
		get(NVDMyProfileTabPage.class)
			.click_product_and_service_accordion()
			.wait_until(5)
			.verify_product_and_service_offering("Product & Service Offering");
				
	}
	
    
	@Test(priority=55, groups = {"functional"})                                        
	public void verifySalesTerritory(){
		get(NVDMyProfileTabPage.class)
			.click_sales_territory_accordion()
			.wait_until(5)
			.verify_sales_territory("Sales Territory");
				
	}
	
	@Test(priority=56, groups = {"functional"})                                        
	public void verifySupervisorInformation(){
		get(NVDMyProfileTabPage.class)
			.click_supervisor_information_accordion()
			.wait_until(5)
			.verify_supervisor_information("Supervisor Information");
	}
				
				
	@Test(priority=57, groups = {"functional"})                                        
	public void verifyReferences(){
		get(NVDMyProfileTabPage.class)
			.click_references_accordion()
			.wait_until(5)
			.verify_references("References");
	}
				
	
	@Test(priority=58, groups = {"functional"})                                        
	public void verifyVendormateMobileIconInExtrasTab(){
		get(NVDExtrasPage.class)
		   .click_extras_tab()
		   .click_vendormate_mobile();
		
		get(NVDExtrasPage.class,focus_on_popup_window())
		   .verify_vendormate_mobile_page("Terms Of Use");
		   focus_on_popup_window().close();
		
		get(NVDExtrasPage.class,focus_on_parent_window());
		
	}
	
	@Test(priority=59, groups = {"functional"})                                        
	public void verifyVendormatePurchasePlanInExtrasTab(){
		get(NVDExtrasPage.class,focus_on_parent_window())
		   .click_vendormate_purchase_plans()
		   .wait_until(5);
		
		get(NVDExtrasPage.class,focus_on_popup_window())
		   .verify_vendormate_purchase_plan_page("Fee based on number of reps and risk levels");
		   focus_on_popup_window().close();
		
		get(NVDExtrasPage.class,focus_on_parent_window());
	}
	
	
	@Test(priority=60, groups = {"functional"})                                         
	public void verifyTrainingCertificationsInExtrasTab(){
		get(NVDExtrasPage.class,focus_on_parent_window())
		   .click_training_certifications()
		   .wait_until(5);
		
		get(NVDExtrasPage.class,focus_on_popup_window())
		   .verify_training_and_certifications_page("All Courses");
		   focus_on_popup_window().close();
		
		get(NVDExtrasPage.class,focus_on_parent_window());
	}
	
	
	@Test(priority=61, groups = {"functional"})                                         
	public void verifyBackgroundChecksInExtrasTab(){
		get(NVDExtrasPage.class,focus_on_parent_window())
		   .click_background_checks_and_drug_screens()
		   .wait_until(5);
	    
		get(NVDExtrasPage.class,focus_on_popup_window())
		   .verify_background_checks_page("Products and pricing");
	       focus_on_popup_window().close();
		
	    get(NVDExtrasPage.class,focus_on_parent_window());	
	}
	
	
	@Test(priority=62, groups = {"functional"})                                         
	public void verifyContactPreferencesInExtrasTab(){
		get(NVDExtrasPage.class,focus_on_parent_window())
	       .click_contact_preferences()
	       .wait_until(5);
	 
		
		get(NVDExtrasPage.class,focus_on_popup_window())
	       .verify_contact_preferences_page("Email*");
		   focus_on_popup_window().close();
		
		get(NVDExtrasPage.class,focus_on_parent_window());
		
		get(CommonUtilities.class)
		.click_log_out_from_NVD();
		}
	}
	


				
				
				


	
	
	
	
	
	
	
	
	
	    
	    
