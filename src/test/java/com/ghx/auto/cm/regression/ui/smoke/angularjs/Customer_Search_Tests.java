package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsCustomerSearchPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Customer_Search_Tests extends AbstractAutoUITest {
	String valid_string_error_mesg = "Please enter a valid search string.";
	String modj_error_mesg = "Special characters are not allowed.";
	String no_records_found_error_mesg = "No records found. Please use a different search criteria.";
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyValidStringErrorMesg(){
		
		get(AjsCustomerSearchPage.class)
			.invoke_search_url()
			.click_search_button()
			.verify_valid_string_error_mesg(valid_string_error_mesg);
		
}
		
	@Test(priority=2, groups = {"functional"})                                         
	public void verifyModJErrorMesg(){
			
		get(AjsCustomerSearchPage.class)
			.enter_text_in_text_field("[]")
			.click_search_button()
			.verify_modj_error_mesg(modj_error_mesg);
			
}
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyNoRecordsFoundErrorMesg(){
			
		get(AjsCustomerSearchPage.class)
			.enter_text_in_text_field("srmc")
			.click_search_button()
			.verify_no_records_found_error_mesg(no_records_found_error_mesg);
		
				
}
}