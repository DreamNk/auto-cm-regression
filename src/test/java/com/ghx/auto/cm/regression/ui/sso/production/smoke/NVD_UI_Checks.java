package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NVDAccountPage;
import com.ghx.auto.cm.ui.sso.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.sso.page.NVDExtrasPage;
import com.ghx.auto.cm.ui.sso.page.NVDHomePage;
import com.ghx.auto.cm.ui.sso.page.NVDManageRepsPage;
import com.ghx.auto.cm.ui.sso.page.NVDMyDocumentsPage;
import com.ghx.auto.cm.ui.sso.page.NVDMyProfilePage;
import com.ghx.auto.cm.ui.sso.page.NVDReportsPage;
import com.ghx.auto.cm.ui.sso.page.NVDResourceCenterPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_UI_Checks extends AbstractAutoUITest{
	
	//Password for Production users Sheet
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
	
	String accountSpecificDoc = "Individual Confidentiality & Non-Disclosure Statement";
	String badgePhoto = "Badge Photo";
	String shareCredentials = "Share Credentials";
	
	String repEmailId ="oliva.maddison@gmail.com";
	String repPassword=null;
	String repFirstName="Oliva";
	String repLastName="Maddison";
	String inviteRepMailId ="billing.collectionsinc@gmail.com";
	String inviteRepFName="Billing";
	String inviteRepLName="Collections";
	
	String legalName="Billing and Collections Company";
	String taxId="906144040";
	String streetAddress="111 Baker Rd NW";
	String city="Huntsville";
	String comPrincipalName="Darlaupdate Reyes";
	String comPrincipalEmail="darla.reyes@testuser.com";
	
	String assCompany="Billing and Collections Company#@#c0100035a26000035a29";
	String repAssComName = "Billing and Collections Company#@#c0100035a26000035a29";
	
	String adminResourceDoc = "User Guide";
	String repResourceDoc="Rep Registration Guide";
	
	String accountName="Vendormate Partners";
	String companyStatus ="Complete";
	String networkStatus="Incomplete";
	String companyDoc = "Hepatitis A"; // QA Testing - OPREP Document
	
	
	@Test(priority=1, groups = {"functional"})                                        
	public void NVDHomePageChecks() throws IOException{
	
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl") 
			.wait_until(3)
			.enter_username(repEmailId);
		repPassword =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, repEmailId);
		  get(SSOLoginPage.class)
			.enter_password(repPassword)
			.click_login_button();
		get(SSOCommonUtilities.class)
        	.select_option_from_solution_selector("Vendormate Credentialing")
        	.wait_until(25);
		get(NVDHomePage.class)
			.click_common_document_alert_link()
			.verify_common_missing_document()
			.click_common_alert_close_button()
			.verify_no_incomplete_reg_alerts()
			.verify_health_system_alert()
			.verify_connect_with_new_health_system()
			.verify_logged_in_user_name(repFirstName)
			.click_am_i_cleared_for_access()
			.verify_view_access_status_text()
			.wait_until(2)
			.click_back_to_home_link()
			.wait_until(3);
	
	}
	@Test(priority=2, groups = {"functional"})                                        
		public void NVDBadgePhotoChecks(){
		
		get(NVDHomePage.class)
			.click_update_badge_photo();
		get(NVDMyProfilePage.class)
			.click_edit_button();
		get(SSOCommonUtilities.class)
         	.upload_file("D:\\MSDhoni.jpg")
			.wait_until(10);
		get(NVDMyProfilePage.class)
			.click_save_button()
			.wait_until(10)
			.click_edit_button()
			.wait_until(5)
			.click_delete_button()
			.wait_until(5)
			.click_delete_popup_window()
			.wait_until(10)
			.click_back_to_home_link();
	}

	@Test(priority=3, groups = {"functional"})
	public void NVDMyProfilePageChecks(){
		
		 get(SSOCommonUtilities.class)
		 	.select_option_from_userName_dropdown("My Profile");
		 get(NVDMyProfilePage.class)
		 	.verify_contact_and_personal_info_text()
		 	.verify_first_name_text(repFirstName)
		 	.verify_last_name_text(repLastName)
		 	.click_address_and_info_tab()
		 	.verify_address_abd_info_text()
		 	.verify_email_id(repEmailId)
		 	.click_badge_photo_tab()
		 	.verify_badge_photo_text()
		 	//.click_product_and_service_tab()
		 	.wait_until(3)
		 	//.verify_product_and_service_text()
		 	.click_sales_territory_tab()
		 	.verify_sales_territory_text()
		 	.click_supervisor_tab()
		 	.verify_supervisor_text()
		 	.click_reference_tab()
		 	.verify_reference_text();
		}
	
	@Test(priority=4, groups = {"functional"})
	public void NVDCompanyProfilePageChecks(){
		
		get(SSOCommonUtilities.class)
	 		.select_option_from_userName_dropdown("Company Profile");
		get(NVDCompanyProfilePage.class)
			.verify_company_info_text()
			.verify_legal_name_of_business_text(legalName)
			.verify_tax_id_text(taxId)
			.click_contact_info_tab()
			.verify_contact_info_text()
			.verify_street_address_text(streetAddress)
			.verify_city_text(city)
			.click_company_logo_tab()
			.verify_company_logo_text()
			.click_company_principal_tab()
			.verify_company_principal_text()
			.verify_company_principal_username_text(comPrincipalName)
			.verify_company_principal_email_text(comPrincipalEmail)
			.click_geographical_sales_tab()
			.verify_geographical_sales_text()
			.click_diversity_info_tab()
			.verify_diversity_info_text()
			.verify_diversity_gender_text()
			.verify_diversity_ehtnicity_text()
			.click_compliane_officer_tab()
			.verify_compliane_officer_text();
		}

	@Test(priority=5, groups = {"functional"})
	public void NVDAccountsPageChecks(){
		get(NVDHomePage.class)
			.click_accounts_tab()
			.verify_accounts_tab_text();
		get(NVDAccountPage.class)
			.verify_account_name_text(accountName)
			.verify_company_credentialing_status_text(companyStatus)
			.click_search_for_accounts_tab()
			.verify_search_for_accounts_text()
			.verify_account_details_text();
	} 
	
	@Test(priority=6, groups = {"functional"})
	public void NVDManageRepsPageChecks(){
		get(NVDHomePage.class)
			.click_manage_reps_tab();			
		get(NVDManageRepsPage.class)
			.verify_access_rep_accounts_text()
			.click_invite_reps_tab()
			.wait_until(2)
			.verify_invite_rep_mail_id(inviteRepMailId)
			.verify_invite_rep_first_name(inviteRepFName)
			.verify_invite_rep_last_name(inviteRepLName)
			.verify_account_name(accountName)
			.click_share_staff_credentials_tab()
			.verify_share_staff_credentials_text()
			.click_share_credentials_link()
			.wait_until(5)
			.click_back_to_share_staff_link()
			.wait_until(5)
			//.click_rep_account_details_tab()
			//.wait_until(5)
			.verify_rep_account_details_text();
	}
	
	@Test(priority=7, groups = {"functional"})
	public void NVDResourceCenterPageChecks(){
		get(NVDHomePage.class)
			.click_resource_center_tab();
		get(NVDResourceCenterPage.class)
			.click_admin_resources_vendor()
			.click_associate_companies_name()
			.verify_associate_companies_text(assCompany)
			.click_rep_resources_vendor()
			.click_rep_associate_companies_name()
			.verify_rep_associate_companies_text(repAssComName)
			.click_admin_resources_global()
			.verify_admin_resources_global(adminResourceDoc)
			.click_rep_resources_global()
			.verify_rep_resources_global(repResourceDoc)
			.click_health_system_policies_library();
			
	}
	
	@Test(priority=8, groups = {"functional"})
	public void NVDReportrPageChecks(){
		get(NVDHomePage.class)
			.click_report_tab();
		get(NVDReportsPage.class)
			.wait_until(3)
			.click_standard_report()
			.wait_until(3)
			.click_share_my_credentials_report()
			.wait_until(2)
			.verify_from_date()
			.verify_toDate()
			.verify_no_credentials_share_message()
			.click_back_to_reports_link()
			.click_share_staff_my_credentials_report_link()
			.verify_from_date()
			.verify_toDate()
			.click_back_to_reports_link();
	}
	
	@Test(priority=9, groups = {"functional"})
	public void NVDMyDocumentsPageChecks(){
		get(NVDHomePage.class)
			.click_my_document_tab();
		get(NVDMyDocumentsPage.class)
			.click_common_documents_tab_subtab()
			.verify_common_document_opvc_sharable(companyDoc)
			.click_account_specific_documents_subtab()
			.veirfy_account_specific_document_text(accountSpecificDoc)
			.verify_share_credentials_button(shareCredentials);
	}
	
	@Test(priority=10, groups = {"functional"})
	public void NVDActionDropDownChecks(){
		get(NVDHomePage.class)
			.click_action_drop_down()
			.verify_share_my_credentials_link()
			.click_view_access_status_link()
			.verify_view_access_status_text()
			.click_print_badge_link()
			.verify_view_access_status_text()
			.click_request_appointment_link()
			//.verify_request_appointment_text()
			.click_view_request_link();		
	}
	
	@Test(priority=11, groups = {"functional"})
	public void NVDExtrasPageChecks(){
		get(NVDHomePage.class)
			.click_extras_tab();
		get(NVDExtrasPage.class)
			.click_vendormate_credentialing_mobile()
			.wait_until(5);
		get(NVDExtrasPage.class , focus_on_popup_window())
			.wait_until(5)
			.verify_vendormate_credentialing_mobile_text();
		get(SSOCommonUtilities.class)
			.close_popup_window();	
		get(NVDExtrasPage.class , focus_on_parent_window());
	}	
	
	@Test(priority=12, groups = {"functional"})
	public void NVDHelpLinkChecks(){
		get(NVDHomePage.class)
			.click_help_link()
			.wait_until(10);
		get(NVDExtrasPage.class,focus_on_popup_window())
			.verify_vendormate_credentialing_text();
			close_popup_window();
		get(NVDHomePage.class , focus_on_parent_window());
		get(SSOCommonUtilities.class)
			.click_tv_icon()
			.wait_until(5)
			.click_close_system_status_button()
			.wait_until(5);
		get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();		
	}	
}
