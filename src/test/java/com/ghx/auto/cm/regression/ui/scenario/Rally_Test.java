package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.cm.ui.page.RallyAttachment;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Rally_Test extends AbstractAutoUITest{

	
	@Test(priority=1, groups = {"functional"})                                       
	public void Rally(){
		get(NVDloginPage.class)
		  .invokeLoginUrl("baseUrl");  
		get(RallyAttachment.class)
	   	  .enter_user_id("anamika.dutta@vendormate.com")
	   	  .enter_password("AnamikaAnamika")
	   	  .click_sign_in_button()
	   	  .click_project_dropdown()
	   	  .click_vision_option()
	   	  .wait_until(10)
	   	  .click_search_icon()
	   	  .enter_user_story_number("US7720")
	   	  .press_enter()
	   	  .click_acctachment_1();
	   	  
	
	}
		  
}
