package com.ghx.auto.cm.regression.ui.smoke.production;



import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDAccountsPage;
import com.ghx.auto.cm.ui.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.page.NVDExtrasPage;
import com.ghx.auto.cm.ui.page.NVDHomePage;
import com.ghx.auto.cm.ui.page.NVDManageRepsPage;
import com.ghx.auto.cm.ui.page.NVDMyDocumentPage;
import com.ghx.auto.cm.ui.page.NVDMyProfileTabPage;
import com.ghx.auto.cm.ui.page.NVDResourceCenterTab;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class ST_NVD_Navigation_Test extends AbstractAutoUITest{
	
	
	String UserID = "parsu.nurani@vendormate.com";
	String PeerRepID = "allison.graham@vendormate.com";
	String PeerRepFirstName = "Allison";
	String PeerRepLastName = "Graham";	
	

	@Test(priority=1, groups = {"functional"})
	public void verifyCommonDocumentAlertLink() {
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username(UserID)
			.enter_password("test@123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDHomePage.class)
		    .click_common_document_alert_link()
		    .verify_common_missing_document("Secretary of State Filing")
		    .close_popup();
	}
	
	
	@Test(priority=2, groups = {"functional"})
	public void verifyAccountSpecificDocumentAlertLink(){	
		get(NVDHomePage.class)
		    .click_account_specific_document_alert()
		    .verify_account_specific_missing_document("VTC - Corporate Response to Policies")
		    .close_popup();
	}
		    
	
	@Test(priority=3, groups = {"functional"})
	public void verifyPolicyAlertLink(){	 
	    get(NVDHomePage.class)
		    .click_no_policy_alert_link()
		    .verify_policies("ABC Medical Credential Document Repository")
		    .close_popup();
	}
	    
	    
	@Test(priority=4, groups = {"functional"})
	public void verifyIncompleteRegistrationAlertLink(){
		get(NVDHomePage.class)
		    .click_incomplete_registration_alert()
		    .verify_incomplete_account("Appalachian Regional Healthcare System")
		    .click_back_to_home();
	}
	
	
	@Test(priority=5, groups = {"functional"})
	public void verifyHealthSystemAlertLink(){
		get(NVDHomePage.class)
		    .click_health_system_alert()
		    .verify_fail_account("ABC Medical Credential Document Repository")
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
			.verify_common_doc_account("Vision Test Customer")
			.click_close_popup();
	}
	
	@Test(priority=10, groups = {"functional"})
	public void verifyMyDocumentPolicies(){
		get(NVDMyDocumentPage.class)
	    	.click_view_account_link_policies()
	    	.verify_policies_account("Dale Medical Center")
	    	.click_close_popup();
	}
	    
	@Test(priority=11, groups = {"functional"})
	public void verifyMyDocumentAccountSpecificDoc(){
		get(NVDMyDocumentPage.class)	
			.click_account_specific_document_tab()
			.click_view_account_link_of_account_specific_doc_account()
			.verify_account_specific_doc_account("Vision Test Customer")
			.click_close_popup();
	}
	
	    
	@Test(priority=12, groups = {"functional"})
	public void verifyMyDocumentShareCredentialsButton(){
		get(NVDMyDocumentPage.class)
		    .click_optional_doc_tab()
			.click_share_credential_button()
			.verify_sharable_doc("Business License v2.0")
			.click_back_to_my_document_link();
	}
	    
	@Test(priority=13, groups = {"functional"})
	public void verifyActiveAccountsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
			.click_accounts_tab()
			.verify_company_status_for_second_record("Active");
	}
	
	@Test(priority=14, groups = {"functional"})
	public void verifyAccountSearchWithEnteringText(){
		get(NVDAccountsPage.class)
			.enter_account_name("Vision Test Customer")
			.click_search_button_in_manage_my_accounts()
			.verify_st_account_link("Vision Test Customer");
	}
	
	    
	
	@Test(priority=15, groups = {"functional"})
	public void verifyFailedHealthSystemsInManageMyAccountsTab(){
		get(NVDAccountsPage.class)
			.click_fail_health_system_dropdown()
			.verify_requirement_status("FAIL");
	}
	
	
	@Test(priority=16, groups = {"functional"})
	public void verifyAccountLinkIsNavigatedToAccountDetails(){
		get(NVDAccountsPage.class)
		    .click_accounts_tab()
			.click_account_link("")
			.verify_registration_URL_in_account_details("https://abcmedical.vendormate.com")
			.click_back_to_list();
	}

	@Test(priority=17, groups = {"functional"})
	public void Verify_View_Location_Link(){
		get(NVDAccountsPage.class)
	    	.click_view_location_link()
	    	.verify_location_popup("ABC Medical Vendor Company");
	    get(NVDMyDocumentPage.class)
	    	.click_close_popup();   
	}
	    
	
	@Test(priority=18, groups = {"functional"})
	public void Verify_Search_Accounts_By_State(){
		get(NVDAccountsPage.class)
			.click_search_for_accounts_accordion()
			.click_search_button_to_search_by_state_in_search_for_accounts_accordion()
			.verify_unregistered_account("Baptist Health System Inc.");
	}
	    
	@Test(priority=19, groups = {"functional"})
	public void Verify_Search_Accounts_By_Keyword(){
		get(NVDAccountsPage.class)   
			.click_search_by_keyword_radio_button()
			.wait_until(5)
			.enter_account_name_in_textbox("baptist")
			.wait_until(3)
			.click_search_button_to_search_by_keyword_in_search_for_accounts_accordion()
			.verify_unregistered_account("Baptist Health South Florida");
	}
	 
	@Test(priority=20, groups = {"functional"})
	public void verifyRepEmailAddressSearchInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.clickManageRepsTab()
			.enter_rep_mail_id_in_rep_email_address_text_box_of_access_rep_account_accordion(PeerRepID)
			.wait_until(5)
			.click_search_button_in_access_rep_accounts_accordion()
			.verify_1st_record_of_user_email_column_in_access_rep_account_accordion(PeerRepID);
	}
	    
	@Test(priority=21, groups = {"functional"})
	public void VerifyAssociatedCompaniesLinkInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.click_associated_companies_link()
			.verify_taxID_in_associated_company_popup("223890190");
		get(NVDMyDocumentPage.class)
	     	.click_close_popup();
	}   
	    
	@Test(priority=22, groups = {"functional"})
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
	   
	@Test(priority=23, groups = {"functional"})
	public void VerifyFirstNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_invite_reps_accordion()
		   .click_first_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepFirstName)
		   .verify_1st_record_in_first_name_column_of_invite_reps(PeerRepFirstName);
	}
	
	@Test(priority=24, groups = {"functional"})
	public void VerifyLastNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_last_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepLastName)
		   .verify_1st_record_in_last_name_column_of_invite_reps(PeerRepLastName);
	}
	
	@Test(priority=25, groups = {"functional"})
	public void VerifyEmailSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_email_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps("allison.graham@vendormate.com")
		   .verify_1st_record_in_email_column_of_invite_reps(PeerRepID);
	}
	
	@Test(priority=26, groups = {"functional"})
	public void VerifySearchAccountInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_search_by_account_radio_button_in_invites_reps()
		   .enter_search_string_in_account_search_textbox_of_invite_reps("Vision")
		   .wait_until(3)
		   .verify_2nd_searched_account_in_invite_reps("Vision Test Customer");
	}
	
	
	@Test(priority=27, groups = {"functional"})
	public void VerifyFirstNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_share_staff_credentials_accordion()
	    	.click_first_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Allison")
	    	.verify_1st_record_of_first_name_column_in_share_staff_credentials_accordion("Allison");
	}
	
	@Test(priority=28, groups = {"functional"})
	public void VerifyLastNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_last_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Graham")
	    	.verify_1st_record_of_last_name_column_in_share_staff_credentials_accordion("Graham");
	}
	
	@Test(priority=29, groups = {"functional"})
	public void VerifyEmailSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_email_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.wait_until(2)
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("allison.graham@vendormate.com")
	    	.verify_1st_record_of_email_column_in_share_staff_credentials_accordion("allison.graham@vendormate.com");
	}
	
	
	@Test(priority=30, groups = {"functional"})
	public void VerifyShareLinkInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
		    .click_1st_record_share_link_in_share_staff_credentials_accordion()
		    .wait_until(2)
		    .verify_sharable_document_in_share_credentials_accordion("Business License v2.0")
		    .click_back_to_share_staff_credential_link_in_share_credential_accordion();  
		}
	
	
	@Test(priority=31, groups = {"functional"})                                         
	public void verifyCompanyProfilePage(){
		get(NVDRootPage.class)
		    .click_user_name_dropdown()
		    .click_company_profile();
	
		get(NVDCompanyProfilePage.class)
		.verify_company_profile_page_footer_title("Accuracy Information")
		.verify_company_profile_page_footer_text("By continuing and submitting this information, you affirm that none of the responses set forth knowingly contain any untrue or incomplete statements of fact or omissions of any information that would make the above responses misleading.");
		
	}	
	
	    // Testcase to Verify Company Information Accordion
	
	@Test(priority=32, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordion(){
		get(NVDCompanyProfilePage.class)
		    .verify_company_information_accordion_title("Company Information")
		    .verify_legal_name("Vendormate")
		    .verify_tax_id("203141891")
		    .verify_duns_number("613172936");
		
	}
	
		// Testcase to Verify Company Information Accordion Help text
	
	@Test(priority=33, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_company_information_help_link()
			.verify_company_information_help_text("This section contains information about your company and is used for credit scoring and supplier evaluations.")
			.click_company_information_help_popupclose();
		
	}
	
		// Testcase to Verify Company Contact Information Accordion
	
	@Test(priority=34, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_contact_information_accordion()
			.verify_company_contact_information_accordion_title("Company Contact Information")
			.verify_headquarter_city("Atlanta")
			.verify_headquarter_state("Georgia")
			.verify_headquarter_zipcode("30326");
		
	}
	
		// Testcase to Verify Company Contact Information Accordion Help Text
	
	@Test(priority=35, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_company_contact_information_help_link()
			.verify_company_contact_information_help_text("This section contains contact information about your company. This information may be different than your local business operations.")
			.click_company_information_help_popupclose();
		
			
	}
	
		// Testcase to Verify Company Logo Accordion
	
	@Test(priority=36, groups = {"functional"})                                         
	public void verifyCompanyLogoAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_logo_accordion()
			.verify_company_logo_accordion_title("Company Logo")
			.verify_company_logo_text("Upload your company logo to promote your participation in our program. Your logo will be displayed on your customer's view into our application.")
			.click_company_logo_edit_button()
			.verify_company_logo_file_name("File Name:  vmLogo.jpg");
			
	
	}
		
		// Testcase to Verify Company Principals Accordion
		
	@Test(priority=37, groups = {"functional"})                                         
	public void verifyCompanyPrincipalsAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_company_principals_accordion()
			.verify_company_principals_username("Christopher McManus")
			.verify_company_principals_email("cmcmanus@ghx.com")
			.click_company_principals_addbutton()
			.verify_company_principals_addbutton_popup_title("Add Company Principal")
			.click_company_principals_addbutton_popupclose();
								
		
	}
		// Testcase to Verify Company Principals Accordion Help Text
			
	@Test(priority=38, groups = {"functional"})                                         
	public void verifyCompanyPrincipalsAccordionHelp(){
		get(NVDCompanyProfilePage.class)
		    .wait_until(2)
			.click_company_principals_help()
			.verify_company_principals_help_text("Some government regulations require screening a company's principals. Provide basic information about your company's principals, e.g., president, CEO, etc.")
			.click_company_principals_help_popupclose();					
			
	}
		// Testcase to Verify Geographic Sales Capability Accordion
			
	@Test(priority=39, groups = {"functional"})                                         
	public void verifyGeographicSalesCapabilityAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_geographic_sales_capability_accordion()
			.verify_geographic_sales_capability_accordion_title("Geographic Sales Capability")
			.verify_geographic_sales_capability_accordion_states("Alabama")
			.verify_geographic_sales_capability_accordion_countries("United States");
												
	}
		// Testcase to Verify Geographic Sales Capability Accordion Help Text
				
	@Test(priority=40, groups = {"functional"})                                         
	public void verifyGeographicSalesCapabilityAccordionHelp(){
	    get(NVDCompanyProfilePage.class)
			.click_geographic_sales_capability_accordion_help()
			.verify_geographic_sales_capability_accordion_help_text("Highlight each of the locations in the first column where your company sells or serves customers. Use CTRL CLICK to select more than one location. Click the arrow keys to add the highlighted selection to the list. Double arrows move all locations.")
			.click_geographic_sales_capability_accordion_help_popupclose();
			
	}		
			
			// Testcase to Verify Diversity Information Accordion
			
	@Test(priority=41, groups = {"functional"})                                        
	public void verifyDiversityInformationAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion()
			.verify_diversity_information_accordion_title("Diversity Information")
			.verify_no_or_yes_in_1strecord_of_diversity_information_accordion("No");
				
	}	
			
			// 	Testcase to Verify Diversity Information Accordion Help Text 
			
	@Test(priority=42, groups = {"functional"})                                        
	public void verifyDiversityInformationAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion_help()
			.verify_diversity_information_accordion_help_text("Some health systems use diversity as part of their vendor selection criteria. If your company has a certified diversity designation, please specify that here.")
			.click_company_information_help_popupclose();
										
	}
			
           //	Testcase to Verify Compliance Officer Accordion  
	@Test(priority=43, groups = {"functional"})                                        
	public void verifyComplianceOfficerAccordion(){
		get(NVDCompanyProfilePage.class)
			.click_compliance_officer_accordion()
			.verify_compliance_officer_accordion_title("Compliance Officer")
			.verify_compliance_officer_accordion_firstname("Leslie")
			.verify_compliance_officer_accordion_lastname("Bayliff")
			.verify_compliance_officer_accordion_email("lbayliff@ghx.com");
			
				
	}
			
           //	Testcase to Verify Compliance Officer Accordion Help Text
	@Test(priority=44, groups = {"functional"})                                        
	public void verifyComplianceOfficerAccordionHelp(){
		get(NVDCompanyProfilePage.class)
			.click_compliance_officer_accordion_help()
			.verify_compliance_officer_accordion_help_text("Identify your company's compliance officer. This person is responsible for compliance oversight and issue resolution.")
			.click_compliance_officer_accordion_help_popupclose();
				
    }			
			//My Profile
		
	   @Test(priority=45, groups = {"functional"})                                        
		public void verifyContactAndPersonalInformation() throws Throwable  {
			   get(NVDloginPage.class)
			    .click_username_action_dropdown();
			
			  get(NVDRootPage.class)
				.click_my_profile()
				.wait_until(5);
			get(NVDMyProfileTabPage.class)
				.verify_contact_and_personal_information("Parsu");
					
				}
					
		@Test(priority=46, groups = {"functional"})                                        
		public void verifyAddressAndInformation(){
			get(NVDMyProfileTabPage.class)
				.click_address_and_information_accordion()
				.wait_until(3)
				.verify_work_email_in_address_and_information_accordion("parsu.nurani@vendormate.com");
		}
				

		@Test(priority=47, groups = {"functional"})                                        
		public void verifyBadgePhoto(){
			get(NVDMyProfileTabPage.class)
				.click_badge_photo_accordion()
				.wait_until(5)
				.verify_badge_photo_text("Please update your photo");
		}
					
					
		@Test(priority=48, groups = {"functional"})                                        
		public void verifyProductAndService(){
			get(NVDMyProfileTabPage.class)
				.click_product_and_service_accordion()
				.wait_until(5)
				.verify_product_and_service_offering("Product & Service Offering");
					
		}


		@Test(priority=49, groups = {"functional"})                                        
		public void verifySalesTerritory(){
			get(NVDMyProfileTabPage.class)
				.click_sales_territory_accordion()
				.verify_sales_territory_help("help")
				.wait_until(3);
		}


		@Test(priority=50, groups = {"functional"})                                        
		public void verifySupervisorInformation(){
			get(NVDMyProfileTabPage.class)
				.click_supervisor_information_accordion()
				.wait_until(5)
				.verify_supervisor_information("Supervisor Information");
		}
					
					
		@Test(priority=51, groups = {"functional"})                                        
		public void verifyReferences(){
			get(NVDMyProfileTabPage.class)
				.click_references_accordion()
				.wait_until(5)
				.verify_references("References");
		}


		     // Extras Tab//			

		@Test(priority=52, groups = {"functional"})                                        
		public void verifyVendormateMobileIconInExtrasTab(){
			get(NVDExtrasPage.class)
			   .click_extras_tab()
			   .click_vendormate_mobile();
			
			get(NVDExtrasPage.class,focus_on_popup_window())
			   .verify_vendormate_mobile_page("Terms Of Use");
			   focus_on_popup_window().close();
			
			get(NVDExtrasPage.class,focus_on_parent_window());
			
		}

		@Test(priority=53, groups = {"functional"})                                        
		public void verifyVendormatePurchasePlanInExtrasTab(){
			
			get(NVDExtrasPage.class,focus_on_parent_window())
			   .click_vendormate_purchase_plans()
			   .wait_until(5);
			
			get(NVDExtrasPage.class,focus_on_popup_window())
			   .verify_vendormate_purchase_plan_page("Fee based on number of reps and risk levels");
			   focus_on_popup_window().close();
			
			get(NVDExtrasPage.class,focus_on_parent_window());
		}


		@Test(priority=54, groups = {"functional"})                                         
		public void verifyTrainingCertificationsInExtrasTab(){
			get(NVDExtrasPage.class,focus_on_parent_window())
			   .click_training_certifications()
			   .wait_until(5);
			
			get(NVDExtrasPage.class,focus_on_popup_window())
			   .verify_training_and_certifications_page("All Courses");
			   focus_on_popup_window().close();
			
			get(NVDExtrasPage.class,focus_on_parent_window());
		}


		@Test(priority=55, groups = {"functional"})                                         
		public void verifyBackgroundChecksInExtrasTab(){
			get(NVDExtrasPage.class,focus_on_parent_window())
			   .click_background_checks_and_drug_screens()
			   .wait_until(5);
		   
			get(NVDExtrasPage.class,focus_on_popup_window())
			   .verify_background_checks_page("Products and pricing");
		      focus_on_popup_window().close();
			
		   get(NVDExtrasPage.class,focus_on_parent_window());	
		}


		@Test(priority=56, groups = {"functional"})                                         
		public void verifyContactPreferencesInExtrasTab(){
			get(NVDExtrasPage.class,focus_on_parent_window())
		      .click_contact_preferences()
		      .wait_until(5);

			
			get(NVDExtrasPage.class,focus_on_popup_window())
		      .verify_contact_preferences_page("Email*");
			   focus_on_popup_window().close();
			
			get(NVDExtrasPage.class,focus_on_parent_window());
			
		}		
			@Test(priority=57, groups = {"functional"})                                         
			public void verifyVendormateRepResource(){
			
			get(NVDResourceCenterTab.class)
				.click_resources_center_tab()
			    .verify_if_resource_is_present_on_the_grid("Vendormate Support Center")
				.wait_until(3);
			}
	
			@Test(priority=58, groups = {"functional"})                                         
			public void verifyVendorAdminResource(){
				
			get(NVDResourceCenterTab.class)
				.click_vendor_admin_resources_accordion()
				.verify_if_resource_is_not_present_on_the_grid("Vendormate Admin Resource")
				.wait_until(3);
			}

			@Test(priority=59, groups = {"functional"})                                         
			public void verifyVendorRepResource(){
				
			get(NVDResourceCenterTab.class)
				.click_vendor_rep_resources_accordion()
				.verify_if_resource_is_not_present_on_the_grid("Vendormate Support Center")
				.wait_until(3);
			}
				
				
			@Test(priority=60, groups = {"functional"})                                         
			public void verifyVendormateAdminResource(){
				get(NVDResourceCenterTab.class)
				.click_vendormate_admin_resources_accordion()
				.verify_if_resource_is_present_on_the_grid("User Guide for Admins")
				.wait_until(3);
			}

			@Test(priority=61, groups = {"functional"})                                         
			public void verifyHealthSystemAccordion(){
				get(NVDResourceCenterTab.class)
				.click_health_system_policies_library_accordion()
				.verify_text_in_health_system_policies_accordion("Select Health System");
         	
			get(CommonUtilities.class)
		        .click_log_out_from_NVD();
		}
			
	/**
	 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
	 * It will create folder based on your suite file name present in the .xml file
	 * Copy paste this method at the bottom of your each class.
	 * @param project_name = provide name of your project 
	 */
	@AfterMethod(groups = "functional")
	public void takeScreenShotForFailedTests (ITestResult result, ITestContext ctx) {

		String project_name = "cm";

		boolean current_status = result.isSuccess();
		if(current_status == false)
		{try {	
			Date date = new Date();
			String DATE_FORMAT = "MM-dd-yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			String current_date = sdf.format(date);
			String suiteName = ctx.getCurrentXmlTest().getSuite().getName();

			String location_1 = "D:\\AutomationFiles\\";
			String location_2 = location_1 + project_name +"\\";
			String location_3 = location_2 + "screenshots\\";
			String file_location = location_3 + suiteName +" " +current_date +"\\";

			File main_f = new File(location_1);
			boolean f_1 = main_f.exists();
			if(f_1 == false)
				main_f.mkdir();

			File project_f = new File(location_2);
			boolean f_2 = project_f.exists();
			if(f_2 == false)
				project_f.mkdir();

			File screenshot_f = new File(location_3);
			boolean f_3 = screenshot_f.exists();
			if(f_3 == false)
				screenshot_f.mkdir();

			File dir = new File(file_location);
			dir.mkdir();

			String testParameter = ctx.getCurrentXmlTest().getParameter("env");

			boolean x = testParameter.contains("FF");
			boolean y = testParameter.contains("IE");
			boolean z = testParameter.contains("CR");

			String browser = null;
			if(x == true)
				browser  = "-FF";

			else if(y == true)
				browser  = "-IE";

			else if(z == true)
				browser  = "-CR";

			String file_name = result.getName() + browser;
			Thread.sleep(3000);
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "jpg", new File(file_location + file_name + ".jpg"));
		}   catch (Throwable e) {e.printStackTrace();}
		}	
	}
			
	}
	


				
				
				


	
	
	
	
	
	
	
	
	
	    
	    

