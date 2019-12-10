package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.AdministrationConsolePage;
import com.ghx.auto.cm.ui.sso.page.CPMHomePage;
import com.ghx.auto.cm.ui.sso.page.ConnectToDatabasePage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportAdminPage;
import com.ghx.auto.cm.ui.sso.page.CorexExchangeSupportPage;
import com.ghx.auto.cm.ui.sso.page.CorexUserManagementPage;
import com.ghx.auto.cm.ui.sso.page.CorexUsersDashboardPage;
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
import com.ghx.auto.cm.ui.sso.page.SSOLandingPage;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.cm.ui.sso.page.SSOResetPasswordPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Payment_Coupon_Code_Test extends AbstractAutoUITest{

	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	String login_RM_id = "gopal.rm@vendormate.com";
	String RM_password = "Gltd123@";
	String rep_id = "sammy@jet.com";
	String rep_password = null;
	String vendorName = "Jefferson Regional Medical Center";
	String customerName = "Wayne Healthcare";
	String message = "There are no results for the specified search criteria.";
	String VendorFein = "710329353";
	String comment = "Coupon code -Used in Automation";
	String amount = "$750.00";
	String coupon = "discount";

	@Test(priority = 1, groups = { "functional" })
	public void PaymentGRPZero() throws IOException{	

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
	    .click_agreement_page_next_button()
	    .wait_until_loading_bar_to_complete()
	    .verify_payment_amount_billing_info_page(amount)
	    .enter_coupon_code(coupon)
	    .click_apply_coupon_button()
	    .wait_until(5)
		.refresh_page();
	get(NVDHomePage.class)
		.wait_until(5)	
		.click_accounts_tab();
	get(NVDAccountPage.class)
		.enter_account_name(customerName)
		.click_search_button()
	 	.verify_account_name_text(customerName);
		
	get(SSOCommonUtilities.class)
		.select_option_from_userName_dropdown("Logout");
	}
	
	@Test(priority = 2, groups = { "functional" })
	public void verifyInDatabase(){
		
		get(ConnectToDatabasePage.class)
			.wait_until(10)
			.fetch_coupon_code_payemnt_detals_from_db(rep_id);
		
	}	
	
	@Test(priority = 3, groups = { "functional" })
	public void deleteVC(){
		
	get(SSOLoginPage.class)
		.invoke_loginURL("rmUrl")
		.enter_username(login_RM_id)
		.enter_password(RM_password)
		.click_login_button()
		.wait_until(10);
	
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
	get(SSOCommonUtilities.class)
		.clear_current_session();
		
	}

}
