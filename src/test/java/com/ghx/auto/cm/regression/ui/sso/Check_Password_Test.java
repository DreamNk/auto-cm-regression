package com.ghx.auto.cm.regression.ui.sso;



import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Check_Password_Test extends AbstractAutoUITest{
	
	String  username = null ;
	static String Password = null;
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx"; 
	   
	String fileName = "GetPasswordStaging.xlsx";
	String userId[]={"v2@gps.net","carol.lopez@egxv411.vm","repone@aurora.vm","rayan@gps.com","dom@pg.com",
			"ashish.bsen@gps.net","siddhant.incomplete@gps.net","adersh@gps.net","v1@gps.net","kamble.yuraj@gps.net","ana.glay@gps.net",
			"james.watt@gps.net","varun.yadav@gps.net","rinny.lockhart@ghxv424.vm","r2@egxv150.vm","m1@reeves.com","sammy@jet.com","rep0@verill.net",
			"anamika.dutta@jct.com","buyer1@sadasystem.vdm","buyer1@universalhomecare.vdm","wayne.admin@vendormate.com","john.buyer@vendormate.com",
			"buyer1@royal.com","buyer1@hon.vdm","buyer5@universalhomecare.vdm"};
	

	 
	
	@Test
	 public void ExpiredPasswordTest() throws Exception  {
	
		int M = userId.length;
		System.out.println("Total Users = "+M);
		
		for(int i=0;i<M;i++) {
		username = userId[i];
		
		get(SSOLoginPage.class)
		     .invoke_loginURL("ssoUrl");
		 
		  Password = get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, username);	
		 
		  get(SSOLoginPage.class)     
		      .enter_username(username)
		      .enter_password(Password)
		      .click_login_button()
		      .wait_until(5)
		  	  .verify_password_expired_or_not(filePath, fileName, username);
		
		  get(SSOCommonUtilities.class)
		    .wait_until(10)
		    .select_option_from_userName_dropdown("Logout")
		    .clear_current_session();
		
		}
		
		
	}	
	
}
