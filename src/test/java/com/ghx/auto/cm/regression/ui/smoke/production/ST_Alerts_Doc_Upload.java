package com.ghx.auto.cm.regression.ui.smoke.production;


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
import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDAccountsPage;
import com.ghx.auto.cm.ui.page.NVDHomePage;
import com.ghx.auto.cm.ui.page.NVDMyDocumentPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;


public class ST_Alerts_Doc_Upload extends AbstractAutoUITest{

		
    @Test(priority = 1, groups = { "functional" })
	public void verifyUploadDocumentFromHomeTab() {

		get(NVDloginPage.class).invokeLoginUrl("baseUrl")
				.enter_username("sachin.pathak@bizsense.in")
				.enter_password("gltd@123")
				.click_login_button()
				.click_continue_button()
				.wait_until(2);
		
		get(NVDAccountsPage.class)
		        .click_accounts_tab1()
				.verify_requirement_status_of_2nd_record("FAIL");

		get(NVDHomePage.class)
		        .click_home_tab()
				.click_common_document_alert_link()
				.click_1st_radio_button_of_common_document_popup()
				.click_upload_button()
				.wait_until(5)
				.browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")

				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button()
				.close_popup()
				.wait_until(3)
				.close_popup();

		get(NVDMyDocumentPage.class)
		      .click_my_document_tab()
				.verify_green_tick_on_doc5_of_common_doc();

	}

	
	@Test(priority = 2, groups = { "functional" })
	public void verifyUploadDocumentFromCommonDocsOfMyDocumentsTab() {

		get(NVDMyDocumentPage.class)
				.click_upload_link_in_common_documents_subtab();

		get(NVDHomePage.class)
		        .click_upload_button()
                .wait_until(5)
                .browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")
				.click_save_button_in_common_docs_tab();

		get(NVDMyDocumentPage.class).wait_until(8)
				.verify_green_tick_on_doc5_of_common_doc();
	}
	
	@Test(priority = 3, groups = { "functional" })
	public void verifyUploadDocumentFromAccountSpecificDocofMyDocumentTab() {

		get(NVDMyDocumentPage.class).wait_until(3)
		        
				.click_account_specific_document_tab()
				.click_upload_link_in_account_specific_doc_subtab();

		get(NVDHomePage.class)
		        .wait_until(2)
		        .click_upload_button()
                .browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")
				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button_in_common_docs_tab();

		get(NVDMyDocumentPage.class).wait_until(8)
				.verify_green_tick_on_doc4_of_account_specific_doc();

	}
	
	
	@Test(priority = 4, groups = { "functional" })
	public void verifyPassAlert(){

		get(NVDAccountsPage.class)
		  .click_accounts_tab()
		  .wait_until(2)
		  .verify_requirement_status_of_2nd_record("PASS");
	}

	
	@Test(priority=5, groups = {"functional"})                                
	public void verifyFailAlert(){
		
		get(NVDAccountsPage.class)
		  .click_requirement_status_of_2nd_record()
		  .switch_to_docs_and_policies_iframe()
		  .select_option_for_9th_document("Delete")
		  .click_confirm_delete_button()
		  .switch_to_root_page()
		  .click_back_to_list()
		  .click_refresh_manage_accounts_icon()
		  .wait_until(4)
		  .click_refresh_requirement_status_2nd_icon()
		  .verify_requirement_status_of_2nd_record("FAIL");
	}

	
	@Test(priority=6, groups = {"functional"})                                
	public void verifyDeleteActionFromCommonDocOfMyDocumentsTab(){
		
		get(NVDMyDocumentPage.class)
		  .click_my_document_tab()
		  .click_delete_link_of_doc5_in_common_doc()
		  .click_delete_button_in_popup_common_docs()
		  .wait_until(7)
		  .verify_cross_mark_on_doc2_of_common_doc();
	}
	
	
	@Test(priority=7, groups = {"functional"})                                
	public void verifyDeleteActionFromAccountSpecificDocOfMyDocumentsTab(){
		
		get(NVDMyDocumentPage.class)
		   .click_account_specific_document_tab()
		   .click_delete_link_of_doc4_in_account_specific_doc()
		   .click_delete_button_in_popup_common_docs()
		   .wait_until(7)
		   .verify_cross_mark_on_doc1_of_account_specific_doc();
		   
		
		get(CommonUtilities.class)
		   .click_log_out_from_NVD();
	}
	
	/**
	 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
	 * It will create folder based on your suite file name present in the .xml file
	 * Copy paste this method at the bottom of your each class.
	 * @param project_name = provide name of your project 
	 */
	@AfterMethod(groups = "functional")
	public void takeScreenShotForFailedTests (ITestResult result, ITestContext ctx) {
		
		String project_name = "cm";
			
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


	
	
	



