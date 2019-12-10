package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDRootPage;
import com.ghx.auto.cm.ui.page.NBDVendorsPage;
import com.ghx.auto.cm.ui.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.page.NVDHomePage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Diversity_Transactions_Test extends AbstractAutoUITest {
	
	// Testcase to add Minority Owned Diversity in Diversity Information Accordion in NVD
	
	@Test(priority=1, groups = {"functional"})                                
	public void addMinorityOwnedDiversity() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion()
			.click_diversity_information_accordion_editbutton()
			.click_diversity_information_accordion_minority_yesradio()
			.click_diversity_information_accordion_minority_type()
			.click_diversity_information_accordion_minority_type_asian()
			.click_diversity_information_accordion_minority_agency()
			.click_diversity_information_accordion_minority_agency_chicago()
			.enter_diversity_information_accordion_minority_number("1111111111")
			.enter_diversity_information_accordion_minority_effective("01/01/2015")
			.enter_diversity_information_accordion_minority_expiration("12/12/2017")
			.click_diversity_information_accordion_minority_deletebutton()
			.click_diversity_information_accordion_minority_uploadbutton()
			.browse_file("D:\\Automation Files\\Asian - Minority.pdf");
		  
	    get(NVDCompanyProfilePage.class)
	    	.click_diversity_information_accordion_savebutton()
	    	.wait_until(10)
	    	.verify_diversity_information_accordion_title("Diversity Information")
	    	.verify_diversity_information_accordion_minority_viewtype("Asian")
	    	.verify_diversity_information_accordion_minority_viewagency("Chicago Min. Bus. Dev.Council")
	    	.verify_diversity_information_accordion_minority_viewnumber("1111111111")
	    	.verify_diversity_information_accordion_minority_vieweffective("01/01/2015")
	    	.verify_diversity_information_accordion_minority_viewexpiration("12/12/2017")
	    	.click_diversity_information_accordion_minority_viewcertificate();
	    
	    get(NVDCompanyProfilePage.class, focus_on_popup_window())
			.wait_until(5)
			.verify_diversity_information_minority_owned_certificate("Asian");
	    
	    focus_on_popup_window().close();
	    
		get(NVDCompanyProfilePage.class, focus_on_parent_window());
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
			.enter_username("chris.nolan@trinityhealth.vdm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("Tesla Pharma")
			.click_filter_button()
			.click_legal_name_link()
			.verify_vendor_details_header_text("Tesla Pharma")
			.verify_diversity_category("Minority-Owned (MBE/MWBE)?")
			.verify_diversity_type("Asian")
			.verify_diversity_agency("Chicago Min. Bus. Dev.Council")
			.verify_diversity_number("1111111111")
			.verify_diversity_expirationdate("12/12/2017")
			.switch_to_root_page();
		
		get(CommonUtilities.class)
			.do_log_out_from_NBD();
		
    }
 
	// Testcase to Update Minority Owned Diversity in Diversity Information Accordion in NVD
	
	@Test(priority=2, groups = {"functional"})                                
	public void updateMinorityOwnedDiversity() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
			.click_diversity_information_accordion()
			.click_diversity_information_accordion_editbutton()
			.click_diversity_information_accordion_minority_type()
			.click_diversity_information_accordion_minority_type_black()
			.click_diversity_information_accordion_minority_agency()
			.click_diversity_information_accordion_minority_agency_florida()
			.enter_diversity_information_accordion_minority_number("2222222222")
			.enter_diversity_information_accordion_minority_effective("01/01/2014")
			.enter_diversity_information_accordion_minority_expiration("12/12/2016")
			.click_diversity_information_accordion_minority_deletebutton()
			.click_diversity_information_accordion_minority_uploadbutton()
			.browse_file("D:\\Automation Files\\African American - Minority.pdf");
	    
	    get(NVDCompanyProfilePage.class)
	    	.click_diversity_information_accordion_savebutton()
	    	.wait_until(10)
	    	.verify_diversity_information_accordion_title("Diversity Information")
	    	.verify_diversity_information_accordion_minority_viewtype("African American/Black")
	    	.verify_diversity_information_accordion_minority_viewagency("Florida Regional Min. Bus. Council")
	    	.verify_diversity_information_accordion_minority_viewnumber("2222222222")
	    	.verify_diversity_information_accordion_minority_vieweffective("01/01/2014")
	    	.verify_diversity_information_accordion_minority_viewexpiration("12/12/2016")
	    	.click_diversity_information_accordion_minority_viewcertificate();
	    
	    get(NVDCompanyProfilePage.class, focus_on_popup_window())
			.wait_until(5)
			.verify_diversity_information_minority_owned_certificate("African American / Black");
	    
	    focus_on_popup_window().close();
		
		get(NVDCompanyProfilePage.class, focus_on_parent_window());
		
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
			.enter_username("chris.nolan@trinityhealth.vdm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("Tesla Pharma")
			.click_filter_button()
			.click_legal_name_link()
			.verify_vendor_details_header_text("Tesla Pharma")
			.verify_diversity_category("Minority-Owned (MBE/MWBE)?")
			.verify_diversity_type("African American/Black")
			.verify_diversity_agency("Florida Regional Min. Bus. Council")
			.verify_diversity_number("2222222222")
			.verify_diversity_expirationdate("12/12/2016")
			.switch_to_root_page();
		
		get(CommonUtilities.class)
			.do_log_out_from_NBD();
		
    }
	
	// Testcase to delete Minority Owned Diversity in Diversity Information Accordion in NVD
	
	@Test(priority=3, groups = {"functional"})                                
	public void deleteMinorityOwnedDiversity() {
		
		get(NVDloginPage.class)
		    .invokeLoginUrl("baseUrl")
			.enter_username("nikola.tesla@tesla101.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDRootPage.class)
		.click_user_name_dropdown()
		.click_company_profile();
	
		get(NVDCompanyProfilePage.class)
		.click_diversity_information_accordion()
		.click_diversity_information_accordion_editbutton()
		.click_diversity_information_accordion_minority_noradio()
		.click_diversity_information_accordion_savebutton()
		.wait_until(10)
		.verify_diversity_information_accordion_minority_viewnoradio("No");
		
		get(NVDRootPage.class)
		.click_user_name_dropdown()
		.click_log_out_from_NVD()
		.wait_until(20);
		
		get(NBDLogin.class)
		.invoke_loginurl("baseUrl")
		.enter_username("chris.nolan@trinityhealth.vdm")
		.enter_password("gltd123")
		.click_login_button()
		.click_continue_button();
		
		get(NBDVendorsPage.class)
		.click_vendors_tab()
		.enter_company_name_in_filter_field("Tesla Pharma")
		.click_filter_button()
		.click_legal_name_link()
		.verify_vendor_details_header_text("Tesla Pharma")
		.verify_diversity_category_not_present("Minority-Owned (MBE/MWBE)?")
		.switch_to_root_page();
		
		get(CommonUtilities.class)
		.do_log_out_from_NBD();
		
    }
    
}
