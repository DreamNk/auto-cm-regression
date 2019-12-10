package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;





import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDAccountsPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Account_Test extends AbstractAutoUITest{

	
	String user_name = "autor1@ajsv1.vm";
	String password = "gltd123";
	
	//search for accounts--------------------------------------------------------------------------------------
	String account = "Amerinet";
	String location = "Delhi";
	String city = "Atlanta";
	String state = "Alabama";
	
	
	
	@Test(priority=1, groups = {"functional"})
	public void verifyActiveAccountsInManageMyAccountsTab(){
		
		get(AjsNVDLoginPage.class)
		    .invoke_url()
		    .wait_until(10)
		    .enter_username(user_name)
		    .enter_password(password)
		    .click_login_button()
		    .click_continue_button();
		
		get(AjsNVDAccountsPage.class)
			.click_accounts_tab()
			.verify_company_status_for_second_record("Active");
	}
	
	    
	@Test(priority=2, groups = {"functional"})
	public void verifyIncompleteRegistrationsInManageMyAccountsTab(){
		get(AjsNVDAccountsPage.class)
			.click_accounts_tab()
			.select_account_status("Incomplete Registrations")
			.verify_incomplete_registered_account("Incomplete Registration");
	}
	
	@Test(priority=3, groups = {"functional"})
	public void verifyFailedHealthSystemsInManageMyAccountsTab(){
		get(AjsNVDAccountsPage.class)
			.select_account_status("Failed Health Systems")
			.verify_requirement_status("FAIL");
	}
	
	/*@Test(priority=5, groups = {"functional"})
	public void verifyInactiveAccountsInManageMyAccountsTab(){
		get(AjsNVDAccountsPage.class)
	    	.click_inactive_accounts_dropdown()
	    	.click_select_action_dropdown_in_inactive_accounts()
	    	.verify_activate_account_option("Activate Account");
	}*/
	
	@Test(priority=4, groups = {"functional"})
	public void verifyAccountLinkIsNavigatedToAccountDetails(){
		get(AjsNVDAccountsPage.class)
			.select_account_status("All Active Accounts")
			.click_account_link("Grace_Medical_Center")
			//.verify_registration_URL_in_account_details("gracehealthsystem.vendormate.net")
			.click_back_to_list();
	}
	
	@Test(priority=5, groups = {"functional"})
	public void verify_Requirement_Status_is_Navigated_To_Docs_And_Policies(){
		get(AjsNVDAccountsPage.class)
	    	.click_fail_requirement_status_link()
	    	.wait_until(5)
	    	//.verify_document_status_of_1st_document("Missing")
	    	.click_back_to_list();
	}
	
	@Test(priority=6, groups = {"functional"})
	public void verifyAccountSearchWithEnteringText(){
		
		get(AjsNVDAccountsPage.class)
			.enter_account_name("Grace")
			.wait_until(4)
			.click_search_button_in_manage_my_accounts()
			.verify_account_link("Grace_Medical_Center");
	}
	
	@Test(priority=7, groups = {"functional"})
	public void verify_Help_Popup(){
		get(AjsNVDAccountsPage.class)
	    	.click_help_link_in_manage_my_accounts_tab()
	    	.verify_help_popup_in_manage_my_accounts_tab()
	    	.click_close_popup();   
	}

	@Test(priority=8, groups = {"functional"})
	public void verify_View_Location_Link(){
		get(AjsNVDAccountsPage.class)
	    	.click_view_location_link_of_1st_record()
	    	.verify_location_popup("Atlanta")
	    	.click_close_popup();
	}
	    
	
	@Test(priority=9, groups = {"functional"})
	public void verify_Search_By_Health_System_Filter(){
		get(AjsNVDAccountsPage.class)
		.wait_until(4)
			.click_search_for_accounts_accordion()
			.wait_until(4)
			.enter_search_string_in_search_for_accounts_accordion(account)
			.click_serach_button_in_search_for_accounts_accordion()
			.wait_until(4)
			.verify_account_name_of_1st_record(account);
	}
	    
	@Test(priority=10, groups = {"functional"})
	public void verify_Search_By_Location_Filter(){
		get(AjsNVDAccountsPage.class)   
			.select_filter_in_search_for_accounts_accordion("Location")
			.enter_search_string_in_search_for_accounts_accordion(location)
			.click_serach_button_in_search_for_accounts_accordion()
			.wait_until(4)
			.verify_location_of_1st_record(location);
	}
	
	@Test(priority=11, groups = {"functional"})
	public void verify_Search_By_City_Filter(){
		get(AjsNVDAccountsPage.class)   
			.select_filter_in_search_for_accounts_accordion("City")
			.enter_search_string_in_search_for_accounts_accordion(city)
			.click_serach_button_in_search_for_accounts_accordion()
			.wait_until(4)
			.verify_city_of_1st_record(city);
	}
	
	@Test(priority=12, groups = {"functional"})
	public void verify_Search_By_state_Filter(){
		get(AjsNVDAccountsPage.class)   
			.select_filter_in_search_for_accounts_accordion("State")
			.enter_search_string_in_search_for_accounts_accordion(state)
			.click_serach_button_in_search_for_accounts_accordion()
			.wait_until(4)
			.verify_state_of_1st_record(state);
		
		get(AjsCommonUtilities.class)
		    .do_log_out();
	}
	
	
	
	
}
