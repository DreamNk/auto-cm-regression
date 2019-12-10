package com.ghx.auto.cm.regression.ui.sso.production.smoke;



import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class Check_Password_Production_Test extends AbstractAutoUITest{
	
	String  username = null ;
	static String Password = null;
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
	String userId[]={"mayurghx1@gmail.com","anamikadutta1001@gmail.com","meeta.buyer@gmail.com","oliva.maddison@gmail.com"};
	
	
	@Test
	 public void ExpiredPasswordTest() throws Exception  {
	
		int M = userId.length;
		System.out.println("Total Users = "+M);
		
		for(int i=0;i<M;i++) {
		username = userId[i];
		
		get(SSOLoginPage.class)
		     .invoke_loginURL("prodUrl");
		 
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
