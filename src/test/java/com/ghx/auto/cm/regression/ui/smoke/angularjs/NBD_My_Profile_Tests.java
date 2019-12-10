package com.ghx.auto.cm.regression.ui.smoke.angularjs;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDRootPage;
import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.core.support.excel.ExcelRow;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class NBD_My_Profile_Tests extends AbstractAutoUITest {
	
	String Username = "buyer1@ucb.vdm";
	String Current_Password = "gltd123";		


    @Test(priority=1, groups = {"functional"})                                         
    public void verifyNBDMYProfileNavigation()  {
	
	  get(AjsNBDLoginPage.class)
		.invoke_url()
		.enter_username(Username)
		.enter_password(Current_Password)
		.click_login_button()
	    .wait_until(5)
	    .click_continue_button()
	    .wait_until(5)
	    .wait_for_post_login_page_to_load();
	
	  get(AjsNBDRootPage.class)
	    .click_username_dropdown()
	    .wait_until(4)
	    .click_my_profile()
	    .wait_for_element_of_page_to_load()
	    .verify_buyer_email("buyer1@ucb.vdm")
	    .verify_buyer_first_name("Buyone")
	    .verify_buyer_last_name("Everlast");
	  
    }
	    
    
    @Test(priority=2, groups = {"functional"})                                         
    public void verifyNBDMyProfileEdit()  {
         
	   get(AjsNBDRootPage.class)
	     .click_edit_tab()
	     .wait_for_element_of_edit_page_to_load()
	     .enter_first_name("Buyer")
	     .enter_last_name("Last")
	     .click_save_button()
	     .wait_for_element_of_page_to_load()
         .verify_buyer_first_name("Buyer")
         .click_edit_tab()
          .click_edit_tab()
	     .wait_for_element_of_edit_page_to_load()
	     .enter_first_name("Buyone")
	     .enter_last_name("Everlast")
	     .click_save_button()
	     .wait_for_element_of_page_to_load();
	     
	     get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
	
	}    
	  
    }