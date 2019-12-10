package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDCompanyProfilePage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Company_Profile_Test extends AbstractAutoUITest{

	String username = "r41@ucbp1.vm";
	String password = "gltd123";
	String accuracy_information = "Accuracy Information";
	String company_information = "Company Information";
	String footer_text = "By continuing and submitting this information, you affirm that none of the responses set forth knowingly contain any untrue or incomplete statements of fact or omissions of any information that would make the above responses misleading.";
	String legal_name = "UCBP1";
	String fein = "UCBP1";
	String headquarter_city = "auburn";

	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyCompanyProfilePage(){
		
		get(AjsNVDLoginPage.class)
		    .invoke_url()
		    .wait_for_login_page_to_load()
		    .enter_username(username)
		    .enter_password(password)
			.click_login_button()
		    .click_continue_button()
		    .wait_for_element_of_home_page_to_load();
																					    
		
		get(AjsNVDCompanyProfilePage.class)
		    .click_username_dropdown()
		    .click_company_profile();
	
		get(AjsNVDCompanyProfilePage.class)
		    .verify_company_profile_page_footer_title(accuracy_information)
		    .verify_company_profile_page_footer_text(footer_text);
		
	}	
	
	    // Testcase to Verify Company Information Accordion
	
	@Test(priority=2, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordion(){
		get(AjsNVDCompanyProfilePage.class)
		    .verify_company_information_accordion_title(company_information)
		    .verify_legal_name(legal_name)
		    .verify_tax_id(fein);
		
	}
	
		// Testcase to Verify Company Information Accordion Help text
	
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyCompanyInformationAccordionHelp(){
		get(AjsNVDCompanyProfilePage.class)
			.click_company_information_help_link()
			.verify_company_information_help_text("This section contains information about your company and is used for credit scoring and supplier evaluations.")
			.click_company_information_help_popupclose();
		
	}
	
		// Testcase to Verify Company Contact Information Accordion
	
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordion(){
		get(AjsNVDCompanyProfilePage.class)
			.click_company_contact_information_accordion()
			.verify_company_contact_information_accordion_title("Company Contact Information")
			.verify_headquarter_city(headquarter_city);
		
	}
	
		// Testcase to Verify Company Contact Information Accordion Help Text
	
	@Test(priority=5, groups = {"functional"})                                         
	public void verifyCompanyContactInformationAccordionHelp(){
		get(AjsNVDCompanyProfilePage.class)
			.click_company_contact_information_help_link()
			.verify_company_contact_information_help_text("This section contains contact information about your company. This information may be different than your local business operations.")
			.click_company_information_help_popupclose();
		
			
	}
	
		// Testcase to Verify Company Principals Accordion
		
	/*@Test(priority=6, groups = {"functional"})                                         
	public void verifyCompanyPrincipalsAccordion(){
		get(AjsNVDCompanyProfilePage.class)
			.click_company_principals_accordion()
			.verify_company_principals_username("Tim Johnson")
			.verify_company_principals_email("tim.johnson@av1.vm")
								
		
	}*/
		
		
           //	Testcase to Verify Compliance Officer Accordion  
	@Test(priority=7, groups = {"functional"})                                        
	public void verifyComplianceOfficerAccordion(){
		get(AjsNVDCompanyProfilePage.class)
			.click_compliance_officer_accordion()
			.verify_compliance_officer_accordion_title("Compliance Officer")
			.verify_compliance_officer_accordion_firstname("Com")
			.verify_compliance_officer_accordion_lastname("Off")
			.verify_compliance_officer_accordion_email("com.off@co.vm");
			
	 get(AjsCommonUtilities.class)
	    .do_log_out();
	}
	
	// Test Cases to edit Company Profile details (Currently blocked due to a defect)
	
	/*@Test(priority=8, groups = {"functional"})                                
	public void addCompanyPrincipal() {
		
		
		get(AjsNVDLoginPage.class)
		    .invoke_url()
			.enter_username("r43@ucbp1.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(AjsNVDCompanyProfilePage.class)
			.click_username_dropdown()
			.click_company_profile();
	
		get(AjsNVDCompanyProfilePage.class)
			.click_company_principals_accordion()
			.click_company_principals_addbutton()
			.enter_company_principals_addbutton_enter_firstname("Karl")
			.enter_company_principals_addbutton_enter_lastname("Sagan")
			.enter_company_principals_addbutton_enter_email("karl.sagan@tesla101.vm")
			.click_company_principals_addbutton_save_button()
			.verify_company_principals_username("Karl Sagan")
			.verify_company_principals_email("karl.sagan@tesla101.vm");
	    	    
}*/
	
}