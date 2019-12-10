
package com.ghx.auto.cm.regression.ui.smoke.angularjs;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNVDLoginPage;
import com.ghx.auto.core.support.excel.ExcelRow;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Login_Test extends AbstractAutoUITest {
	
	

	@Test(priority=1, groups = "functional",  dataProvider = "DP1")                                         
	public void Login_With_Invalid_Username(int rowNo, ExcelRow row){
			
				get(AjsNVDLoginPage.class)
					.invoke_url()
					.wait_for_login_page_to_load()
					.enter_username(row.get_column_string_value(1))
					.enter_password(row.get_column_string_value(2))
					.click_login_button()
					.wait_until(4)
					.verify_invalid_username_message(row.get_column_string_value(3));
				
	    }
		    @DataProvider (name="DP1")
		       public Object[][] getExcelData() {
			     Object[][] data = getExcelClient("EXCEL_NVD_LOGIN").get_single_row(8);
			     return data;
		      }
		 
	 
	
	@Test(priority=2, groups = "functional",  dataProvider = "DP3")                                         
	public void Login_Without_Username(int rowNo, ExcelRow row){
				
				get(AjsNVDLoginPage.class)
					.invoke_url()
					.wait_for_login_page_to_load()
					.enter_password(row.get_column_string_value(2))
					.click_login_button()
					.wait_until(4)
					.verify_username_req_message(row.get_column_string_value(3));
					
		}
		    @DataProvider (name="DP3")
			   public Object[][] getExcelData3() {
				 Object[][] data = getExcelClient("EXCEL_NVD_LOGIN").get_single_row(6);
			     return data;
			  }
			 
	 
	@Test(priority=3, groups = "functional",  dataProvider = "DP4")                                         
	public void Login_Without_Password(int rowNo, ExcelRow row){
					
				get(AjsNVDLoginPage.class)
					.invoke_url()
					.wait_for_login_page_to_load()
					.enter_username(row.get_column_string_value(1))
					.click_login_button()
					.wait_until(4)
					.verify_password_req_message(row.get_column_string_value(3));
					
		}
			@DataProvider (name="DP4")
			   public Object[][] getExcelData4() {
				 Object[][] data = getExcelClient("EXCEL_NVD_LOGIN").get_single_row(7);
				 return data;
			 }
			
	 
	@Test(priority=4, groups = "functional",  dataProvider = "DP5")                                         
	 public void Verify_Username_Password_Invalid_Message(int rowNo, ExcelRow row){
					
				get(AjsNVDLoginPage.class)
					.invoke_url()
					.wait_for_login_page_to_load()
					.enter_username(row.get_column_string_value(1))
					.enter_password(row.get_column_string_value(2))
					.click_login_button()
					.wait_until(4)
					.verify_invalid_password_message(row.get_column_string_value(3));
		}
		    @DataProvider (name="DP5")
			   public Object[][] getExcelData5() {
				 Object[][] data = getExcelClient("EXCEL_NVD_LOGIN").get_multiple_rows(2,5);
				 return data;
			}
	
	
	@Test(priority=5, groups = "functional", dataProvider = "DP2")                                         
	public void Login_Successful(int rowNo, ExcelRow row) {
		
				get(AjsNVDLoginPage.class)
					.invoke_url() 
					.wait_for_login_page_to_load()
					.enter_username(row.get_column_string_value(1))
					.enter_password(row.get_column_string_value(2))
					.click_login_button()
					.wait_until(4)
					.click_continue_button()
					.wait_for_element_of_home_page_to_load();
					
					get(AjsCommonUtilities.class)
				    .do_log_out();
				}
				
			 @DataProvider (name="DP2")
	  	        public Object[][] getExcelData1() {
		          Object[][] data = getExcelClient("EXCEL_NVD_LOGIN").get_multiple_rows(9,11);
		          return data;
	         }	


}



