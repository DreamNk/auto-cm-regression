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

import com.ghx.auto.cm.ui.page.NVDManageRepsPage;
import com.ghx.auto.cm.ui.page.NVDMyDocumentPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class sample extends AbstractAutoUITest{
	

	/**
	 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
	 * It will create folder based on your suite file name present in the .xml file
	 * Copy paste this method at the bottom of your each class.
	 * @param project_name = provide name of your project 
	 */
	/*@AfterMethod(groups = "functional")
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
	}*/

		
		
		String UserID = "parsu.nurani@vendormate.com";
		String PeerRepID = "allison.graham@vendormate.com";
		String PeerRepFirstName = "Allison";
		String PeerRepLastName = "Graham";	
		

		@Test(priority=1, groups = {"functional"})
		public void verifyCommonDocumentAlertLink() {
			get(NVDloginPage.class)
				.invokeLoginUrl("baseUrl")
				.enter_username(UserID)
				.enter_password("test@123")
				.click_login_button();
		}
	
	@Test(priority=24, groups = {"functional"})
	public void verifyRepEmailAddressSearchInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.wait_until(4)
		    .clickManageRepsTab()
			.enter_rep_mail_id_in_rep_email_address_text_box_of_access_rep_account_accordion(PeerRepID)
			.wait_until(5)
			.click_search_button_in_access_rep_accounts_accordion()
			.verify_1st_record_of_user_email_column_in_access_rep_account_accordion(PeerRepID);
	}
	    
	@Test(priority=25, groups = {"functional"})
	public void VerifyAssociatedCompaniesLinkInAccessRepsAccounts(){
		get(NVDManageRepsPage.class)   
			.click_associated_companies_link()
			.verify_taxID_in_associated_company_popup("223890190");
		get(NVDMyDocumentPage.class)
	     	.click_close_popup();
	}   
	    
	@Test(priority=26, groups = {"functional"})
	public void VerifyUserEmailIsNavigatedToRepDetailsInAccessRepAccountsAccordion(){
		get(NVDManageRepsPage.class)   
		 .click_show_all_radio_button_in_access_rep_accounts_accordion()
		 .wait_until(6)
		 .click_3rd_record_of_user_email_column_in_access_rep_account_accordion()
		 .wait_until(4)
		 .verify_peer_reps_accounts_details_tab_under_manage_rep_tab("Account Details")
	         .verify_peer_reps_rep_documents_tab_under_manage_rep_tab("Rep Documents")
	         .verify_peer_reps_user_profile_tab_under_manage_rep_tab("User Profile")
	         .verify_peer_reps_company_profile_tab_under_manage_rep_tab("Company Profile")
	         .verify_peer_reps_clear_for_access_tab_under_manage_rep_tab("Cleared For Access")
	         .click_back_to_list_link_in_rep_account_details_accordion();
	}
	   
	@Test(priority=27, groups = {"functional"})
	public void VerifyFirstNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_invite_reps_accordion()
		   .click_first_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepFirstName)
		   .verify_1st_record_in_first_name_column_of_invite_reps(PeerRepFirstName);
	}
	
	@Test(priority=28, groups = {"functional"})
	public void VerifyLastNameSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_last_name_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps(PeerRepLastName)
		   .verify_1st_record_in_last_name_column_of_invite_reps(PeerRepLastName);
	}
	
	@Test(priority=29, groups = {"functional"})
	public void VerifyEmailSearchInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_email_option_from_rep_search_dropdown_in_invites_reps()
		   .wait_until(2)
		   .enter_search_string_in_search_term_text_box_of_invite_reps("allison.graham@vendormate.com")
		   .verify_1st_record_in_email_column_of_invite_reps(PeerRepID);
	}
	
	@Test(priority=30, groups = {"functional"})
	public void VerifySearchAccountInInviteRep(){
		get(NVDManageRepsPage.class)
		   .click_search_by_account_radio_button_in_invites_reps()
		   .enter_search_string_in_account_search_textbox_of_invite_reps("Vision")
		   .wait_until(3)
		   .verify_2nd_searched_account_in_invite_reps("Vision Test Customer");
	}
	
	/*@Test(priority=31, groups = {"functional"})
	public void VerifyInviteRep(){
		get(NVDManageRepsPage.class)
	    	.click_1strep_radio_button_in_invites_reps()
	    	.wait_until(4)
	    	.click_1st_account_checkbox_in_invites_reps()
		    .click_add_to_invitee_list_button_in_invites_reps()
	    	.verify_rep_email_in_invitee_list_of_invite_reps(PeerRepID);
	}*/
	
	@Test(priority=32, groups = {"functional"})
	public void VerifyFirstNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_share_staff_credentials_accordion()
	    	.click_first_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Parsu")
	    	.verify_1st_record_of_first_name_column_in_share_staff_credentials_accordion("Parsu");
	}
	
	@Test(priority=33, groups = {"functional"})
	public void VerifyLastNameSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_last_name_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Nurani")
	    	.verify_1st_record_of_last_name_column_in_share_staff_credentials_accordion("Nurani");
	}
	
	@Test(priority=34, groups = {"functional"})
	public void VerifyEmailSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_email_option_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.wait_until(2)
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("parsu.nurani@vendormate.com")
	    	.verify_1st_record_of_email_column_in_share_staff_credentials_accordion("parsu.nurani@vendormate.com");
	}
	
	@Test(priority=35, groups = {"functional"})
	public void VerifyProfessionalTitleSearchInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
	    	.click_professional_title_from_rep_search_dropdown_in_share_staff_credentials_accordion()
	    	.enter_search_string_in_search_term_textbox_of_share_staff_credentials_accordion("Director of Software Development")
	    	.verify_1st_record_of_professional_title_column_in_share_staff_credentials_accordion("Director of Software Development");
		}
	
	
	@Test(priority=36, groups = {"functional"})
	public void VerifyShareLinkInShareStaffCredentials(){
		get(NVDManageRepsPage.class)
		    .click_1st_record_share_link_in_share_staff_credentials_accordion()
		    .wait_until(2)
		    .verify_sharable_document_in_share_credentials_accordion("Business License v2.0")
		    .click_back_to_share_staff_credential_link_in_share_credential_accordion();  
		}
	}

