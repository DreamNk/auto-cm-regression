package com.ghx.auto.cm.regression.ui.smoke.production;

import java.awt.AWTException;
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
import com.ghx.auto.cm.ui.page.NVDShareCredentials;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class ST_NVD_Share_Credentials_Test extends AbstractAutoUITest {

	@Test(priority=1, groups = {"functional"})
	public void verifyShareCredentialsNormalPath() {
		
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username("sachin.pathak@bizsense.in")
			.enter_password("gltd@123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDShareCredentials.class)
		    .click_my_document_tab()
		    .wait_until(5)
		    .click_share_credentials_button()
		    .click_select_all_checkbox()
		    .click_share_button()
		    .enter_first_name("hk")
		    .enter_last_name("k")
		    .enter_email("hridayesh.karamkar@viitonline.com")
		    .click_final_share_button()
		    .verify_confirmation_message("Credentials Have Been Sent")
		    .click_ok_button();
	
  }
	@Test(priority=2, groups = {"functional"})
	public void DownloadDocumentsAsZipFiles() throws AWTException {
		
		get(NVDShareCredentials.class)
		    .click_back_button()
		    .click_download_button();
		
		/*get(CommonUtilities.class)
		.saveFile();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);*/
	}
	
	
	@Test(priority=3, groups = {"functional"})
	public void DownloadCredentialsAsZipFiles() throws AWTException {
		
		get(NVDShareCredentials.class)
			.click_share_button()
		    .click_download_credentials_link();
		
		/*get(CommonUtilities.class)
		.saveFile();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);*/
	
   
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
	
