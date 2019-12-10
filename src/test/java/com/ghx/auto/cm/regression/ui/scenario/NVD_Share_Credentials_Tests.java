package com.ghx.auto.cm.regression.ui.scenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDShareCredentials;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Share_Credentials_Tests extends AbstractAutoUITest{

	String UserID = "anaida.gillbert@av1.vm";
	
	@Test(priority=1, groups = {"functional"})
	public void verifyShareCredentialsNormalPath() {
		
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
			.enter_username(UserID)
			.enter_password("gltd123")
			.click_login_button()
			.click_continue_button();
		
		get(NVDShareCredentials.class)
		    .click_my_document_tab()
		    .wait_until(5)
		    .click_share_credentials_button()
		    .click_select_all_checkbox()
		    .click_share_button()
		    .enter_first_name("auto")
		    .enter_last_name("one")
		    .enter_email("auto1@numc.vm")
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
}