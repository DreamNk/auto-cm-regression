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
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NBDPrivacyPolicyPage;
import com.ghx.auto.cm.ui.page.NBDTermsOfUsePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class ST_NBD_Footer_Link_Test extends AbstractAutoUITest {
	
	@Test(priority=1, groups = {"functional"})                                   //Privacy Policy
	public void VerifyPrivacyPolicy() throws Throwable{
		 get(NBDLogin.class)
	     .invoke_loginurl("baseUrl")
	     .enter_username("sachin.pathak@vendormate.com")
	     .enter_password("gltd@123")
	     .click_login_button();
	     //.click_continue_button(); 
	  get(NBDPrivacyPolicyPage.class, focus_on_parent_window())
	  	.click_privacy_policy();
	  get(NBDPrivacyPolicyPage.class, focus_on_popup_window())
	    .verify_policy_text("VENDORMATE PRIVACY POLICY");
	  	focus_on_popup_window().close();
	}
	
	@Test(priority=2, groups = {"functional"})                                   //Terms of Use
	public void VerifyTermsofUse() throws Throwable{
	  get(NBDTermsOfUsePage.class, focus_on_parent_window())
	  	.click_terms_of_use_link();
	  get(NBDTermsOfUsePage.class, focus_on_popup_window())
	    .verify_terms_of_use_text("VENDORMATE TERMS OF USE");
	  focus_on_popup_window().close();
	  focus_on_parent_window();
	  get(CommonUtilities.class)
		.do_log_out_from_NBD();
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

