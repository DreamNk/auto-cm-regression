package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDAccountsPage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Renewal_Date_Test extends AbstractAutoUITest{
	
	
    @Test(priority=1, groups = {"functional"})
	public void Verify_Renewal_Date_Is_visible_for_Normal_ACT_VC() throws Throwable{
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("autorep1@av2r9.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		get(NVDAccountsPage.class)
		    .wait_until(10)
	 	    .click_accounts_tab()
		    .verify_renewal_date_in_1st_row("Jun 24, 2016");
		    
    }
	
    @Test(priority=2, groups = {"functional"})
	public void Verify_Renewal_Date_is_visible_for_Express_ACT_VC() throws Throwable{
		get(NVDAccountsPage.class)
		    .verify_renewal_date_in_2nd_row("Jun 24, 2016");
    }
    
    @Test(priority=3, groups = {"functional"})
	public void Verify_Renewal_Date_is_Blank_for_RFPMT_VC() throws Throwable{
		get(NVDAccountsPage.class)
		    .verify_renewal_date_in_3rd_row("");
    }
    
    @Test(priority=4, groups = {"functional"})
	public void Verify_Renewal_Date_is_Visible_In_Failed_Health_Systems_Search_Result() throws Throwable{
		get(NVDAccountsPage.class)
		    .click_fail_health_system_dropdown()
		    .verify_renewal_date_in_1st_row("Jun 24, 2016");
    }
    
    @Test(priority=5, groups = {"functional"})
   	public void Verify_Renewal_Date_is_Not_Visible_In_Inactive_Accounts_Search_Result() throws Throwable{
   		get(NVDAccountsPage.class)
   		    .click_inactive_accounts_dropdown()
   		    .verify_renewal_date_not_present("Renewal Date");
    }
    
    
    @Test(priority=6, groups = {"functional"})
	public void Verify_Renewal_Date_is_not_visible_for_Vendor_Having_GRP() throws Throwable{
    	get(CommonUtilities.class)
	        .click_log_out_from_NVD();
	    get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("autorep1@av1r9.vm")
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		get(NVDAccountsPage.class)
		    .wait_until(10)
	 	    .click_accounts_tab()
	 	    .verify_renewal_date_not_present("Renewal Date");
		    
    }
    
    @Test(priority=7, groups = {"functional"})
   	public void Verify_Renewal_Date_is_not_visible_If_Rep_Instance_is_Inactivated() throws Throwable{
   	    get(CommonUtilities.class)
   	        .click_log_out_from_NVD();
   	    get(NVDloginPage.class)
   	        .wait_until(5)
   			.invokeLoginUrl("baseUrl")
   			.enter_username("autorep2@av2r9.vm")
   			.enter_password("gltd123")
   			.click_login_button()
   			.click_continue_button();
   		get(NVDAccountsPage.class)
   		    .wait_until(10)
   	 	    .click_accounts_tab()
   	 	    .click_select_action_of_2nd_row_in_all_active_accounts()
   	 	    .click_inactivate_account_option()
   	 	    .wait_until(5)
   	 	    .click_yes_button_on_activate_or_inactivate_account_popup()
   	 	    .click_inactive_accounts_dropdown()
   	 	    .verify_renewal_date_not_present("Renewal Date");
    }
    
    @Test(priority=8, groups = {"functional"})
   	public void Verify_Renewal_Date_is_visible_If_Rep_Instance_is_Reactivated() throws Throwable{
    	get(NVDAccountsPage.class)
    	    .click_select_action_of_1st_row_in_inactive_accounts()
    	    .click_activate_account_option()
    	    .click_yes_button_on_activate_or_inactivate_account_popup()
    	    .click_all_active_accounts_dropdown()
    	    .verify_renewal_date_in_2nd_row("Jun 24, 2016");
    }
    
    @Test(priority=9, groups = {"functional"})
   	public void Verify_Renewal_Date_is_visible_For_A_Rep_With_RepFullyPaidFlag_False() throws Throwable{
    	get(NVDAccountsPage.class)
            .verify_renewal_date_in_1st_row("Jun 24, 2016");
    	
    	get(CommonUtilities.class)
	        .click_log_out_from_NVD();
    }
   
}
