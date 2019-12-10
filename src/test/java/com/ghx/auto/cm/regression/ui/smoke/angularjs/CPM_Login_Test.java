
package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCPMLoginPage;
import com.ghx.auto.core.support.excel.ExcelRow;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class CPM_Login_Test  extends AbstractAutoUITest{

	@Test(priority=1, groups = "functional",  dataProvider = "DP1")                                         
	public void loginWithInvalidUsername(int rowNo, ExcelRow row){
		
		get(AjsCPMLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(row.get_column_string_value(1))
			.enter_password(row.get_column_string_value(2))
			.click_login_button()
			.wait_until(4)
			.verify_invalid_username_message(row.get_column_string_value(3));
	}
	
	 @DataProvider (name="DP1")
	 public Object[][] getExcelDataForInvalidUsername() {
		  Object[][] data = getExcelClient("EXCEL_CPM_LOGIN").get_multiple_rows(2, 3);
		  return data;
	}
	
	@Test(priority=2, groups = "functional",  dataProvider = "DP2")                                         
	public void loginWithInvalidPasswordOrInactiveRM(int rowNo, ExcelRow row){
		
		get(AjsCPMLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(row.get_column_string_value(1))
			.enter_password(row.get_column_string_value(2))
			.click_login_button()
			.wait_until(5)
			.verify_invalid_password_message(row.get_column_string_value(3));
	}			
	
	@DataProvider (name="DP2")
	public Object[][] getExcelDataForInvalidPassword() {
		  Object[][] data = getExcelClient("EXCEL_CPM_LOGIN").get_multiple_rows(6, 8);
		  return data;
	}
	 
	 @Test(priority=3, groups = "functional",  dataProvider = "DP3")                                         
	 public void loginWithValidRMCredential(int rowNo, ExcelRow row){
			
			get(AjsCPMLoginPage.class)
				.invoke_url()
				.wait_for_login_page_to_load()
				.enter_username(row.get_column_string_value(1))
				.enter_password(row.get_column_string_value(2))
				.click_login_button()
				.wait_until(5)
				.verify_username(row.get_column_string_value(3))
				.Do_log_out_from_cpm();
	 }
					
	 @DataProvider (name="DP3")
	 public Object[][] getExcelDataForValidCredentials() {
		  Object[][] data = getExcelClient("EXCEL_CPM_LOGIN").get_multiple_rows(12, 14);
		  return data;
	 }
		 
	 @Test(priority=4, groups = "functional",  dataProvider = "DP4")                                         
	 public void passBlankValueInUsername(int rowNo, ExcelRow row){
			
			get(AjsCPMLoginPage.class)
				.invoke_url()
				.wait_for_login_page_to_load()
				.wait_until(5)
				.enter_password(row.get_column_string_value(2))
				.click_login_button()
				.wait_until(4)
				.verify_username_is_required(row.get_column_string_value(3));
	 }
			
	 @DataProvider (name="DP4")
	 public Object[][] getExcelDataForBlankValueInUsername() {
		 Object[][] data = getExcelClient("EXCEL_CPM_LOGIN").get_multiple_rows(19, 19);
		 return data;
	 }

	 @Test(priority=5, groups = "functional",  dataProvider = "DP5")                                         
	 public void passBlankValueInPassword(int rowNo, ExcelRow row){
					
		 get(AjsCPMLoginPage.class)
			.invoke_url()
			.wait_for_login_page_to_load()
			.wait_until(10)
			.enter_username(row.get_column_string_value(1))
			.click_login_button()
			.wait_until(2)
			.verify_password_is_required(row.get_column_string_value(3));
	 }
				
	 @DataProvider (name="DP5")
	 public Object[][] getExcelDataForBlankValueInPassword() {
		 Object[][] data = getExcelClient("EXCEL_CPM_LOGIN").get_multiple_rows(20, 20);
		 return data;
		}	 
		 

		/**
		 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
		 * It will create folder based on your suite file name present in the .xml file
		 * Copy paste this method at the bottom of your each class.
		 * @param project_name = provide name of your project 
		 */
		@AfterMethod(groups = "functional")
		public void takeScreenShotForFailedTests (ITestResult result, ITestContext ctx) {
			
			String project_name = "cpm";
				
			boolean current_status = result.isSuccess();
			if(current_status == false)
				{try {	
						Date date = new Date();
						String DATE_FORMAT = "MM-dd-yyyy";
						SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
						String current_date = sdf.format(date);
						 String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
						
						String location_1 = "D:\\AutomationFiles\\";
						String location_2 = location_1 + project_name +"\\";
						String location_3 = location_2 + "screenshots\\";
						String file_location = location_3 + suiteName +" " +current_date +"\\";
						
						File main_f = new File(location_1);
						boolean f_1 = main_f.exists();
						if(f_1 == false)
						main_f.mkdir();
						
						File project_f = new File(location_2);
						boolean f_2 = project_f.exists();
						if(f_2 == false)
						project_f.mkdir();
						
						File screenshot_f = new File(location_3);
						boolean f_3 = screenshot_f.exists();
						if(f_3 == false)
						screenshot_f.mkdir();
						
						File dir = new File(file_location);
					    dir.mkdir();
					    
						String testParameter = ctx.getCurrentXmlTest().getParameter("env");
						
						boolean x = testParameter.contains("FF");
						boolean y = testParameter.contains("IE");
						boolean z = testParameter.contains("CR");
						
						String browser = null;
						if(x == true)
						browser  = "-FF";
						
						else if(y == true)
						browser  = "-IE";
						
						else if(z == true)
						browser  = "-CR";
						
					    String file_name = result.getName() + browser;
						Thread.sleep(3000);
						BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
						ImageIO.write(image, "jpg", new File(file_location + file_name + ".jpg"));
					}   catch (Throwable e) {e.printStackTrace();}
			}	
		}
}