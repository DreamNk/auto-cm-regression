package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDVendorsPage;
import com.ghx.auto.cm.ui.page.NVDCompanyProfilePage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Company_Principals_Transactions_Tests extends AbstractAutoUITest {
	
	@Test(priority=1, groups = {"functional"})                                
	public void addCompanyPrincipal() {
		
		
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
			.click_company_principals_accordion()
			.click_company_principals_addbutton()
			.enter_company_principals_addbutton_enter_firstname("Karl")
			.enter_company_principals_addbutton_enter_lastname("Sagan")
			.enter_company_principals_addbutton_enter_email("karl.sagan@tesla101.vm")
			.click_company_principals_addbutton_save_button()
			.verify_company_principals_username("Karl Sagan")
			.verify_company_principals_email("karl.sagan@tesla101.vm");
	    	    
		get(NVDRootPage.class)
			.click_user_name_dropdown()
			.click_log_out_from_NVD()
			.wait_until(20);
		
		get(NBDLogin.class)
			.invoke_loginurl("baseUrl")
			.enter_username("chris.nolan@trinityhealth.vdm")
			.enter_password("gltd123")
			.click_login_button()
			.wait_until(10)
			.click_continue_button();
	
		get(NBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field("Tesla Pharma")
			.click_filter_button()
			.click_legal_name_link()
			.wait_until(10)
			.switch_to_vendors_details_iframe_()
			.click_principals_tab()
			.verify_principal_name_text("Karl Sagan")
			.switch_to_root_page();
	
		get(CommonUtilities.class)
			.do_log_out_from_NBD();

	}

}
