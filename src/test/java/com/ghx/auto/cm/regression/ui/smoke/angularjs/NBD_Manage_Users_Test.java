package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDManageUsersPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

//Before creating new user, delete the buyer (auto_buyer7@srmc.vdm) 
//from RM Dashboard if the test case is run more than once a day.

public class NBD_Manage_Users_Test extends AbstractAutoUITest {
	

	//Test data for filters, inactivate and activate pop up text verification and create new user test cases
	String Password  = "test1235!";
	String Username = "auto_buyer1@srmc.vdm";
	String current_date = get(AjsCommonUtilities.class).get_current_date_mm_dd_yyyy().replaceAll("/", "");
	String new_user_id = "auto_buyer" + current_date  +"@srmc.vdm"; 
	String inactivateusers_popup_text = "The selected user will be inactivated, and will no longer be able to gain access to the Vendormate system. Would you like to continue with this user inactivation?";
	String to_activate_popup_text = "Are you sure you want to activate this user?";
	String firstname = "Ralph";
	String salutation = "Mr";
	String middle_name = "Test";
	String last_name = "Pitt";
	String title = "Doctor";
	String work_phone = "2345677895";
	String cell_phone = "756756567";
	
	//Test data for edit user and inactivate user test cases
	String username = "auto_buyer4@mhc.vdm";
	String password = "gltd123";
	
			
	@Test(priority=1, groups = {"functional"})                                   //verify first name in first name column
	public void verifyFirstNameInFirstNameColumn() {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(Username)
			.enter_password(Password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();

		 get(AjsNBDManageUsersPage.class)	
		 	.click_manageusers_tab()
		 	.wait_until(10)
		 	.enter_first_name_in_filter_field("Anagha")
		 	.press_enter()
		 	.verify_first_name_text_in_firstname_column("Anagha")
		 	.click_clear_link()
		 	.wait_until(10);
	}	 
	
	@Test(priority=2, groups = {"functional"})                                   //verify last name in last name column
	public void verifyLastNameInLastNameColumn() {
		
		 get(AjsNBDManageUsersPage.class)	
		 	.enter_last_name_in_filter_field("Wagle")
		 	.press_enter()
		 	.verify_last_name_text_in_lastname_column("Wagle")
		 	.click_clear_link()
		 	.wait_until(5);
	}	 	
	 
	@Test(priority=3, groups = {"functional"})                                   //verify email id in email column
	public void verifyEmailIdInEmailColumn() {
			
		get(AjsNBDManageUsersPage.class)	
			 .enter_emailid_in_filter_field("auto_buyer6@srmc.vdm")
			 .press_enter()
			 .verify_email_id_in_email_column("auto_buyer6@srmc.vdm")
			 .click_clear_link()
			 .wait_until(5);
	}	
	
	@Test(priority=4, groups = {"functional"})                                   //verify phone number in work phone column
	public void verifyPhoneNumberInWorkPhoneColumn() {
			
		get(AjsNBDManageUsersPage.class)	 
			 .enter_work_phone_in_filter_field("5465464654")
			 .press_enter()
			 .verify_work_phone_in_workphone_column("5465464654")
			 .click_clear_link();
	}
	@Test(priority=5, groups = {"functional"})                                   //verify inactivate user pop up text
	public void verifyInactivateUserPopUpText() {
			
		get(AjsNBDManageUsersPage.class)
			 .click_manageusers_tab()
			 .wait_until(10)
			 .enter_first_name_in_filter_field("Anagha")
		 	 .press_enter()
		 	 .wait_until(10)
			 .select_from_action_dropdown("Inactivate User")
			 .verify_inactivateusers_popup_text(inactivateusers_popup_text)
			 .close_inactivateuser_popup();
	}
	
	@Test(priority=6, groups = {"functional"})                                   //verify header text on 'Create New User' form
	public void verifyHeaderTextonCreateNewUserForm() {
			
		get(AjsNBDManageUsersPage.class)
			 .click_create_new_user_button()
			 .verify_header_text_on_create_new_user_form("Create New User")
		 	 .close_create_new_user_form();
	}

	@Test(priority=7, groups = {"functional"})                                   //verify header text on 'Edit User' form
	public void verifyHeaderTextonEditUserUserForm() {
			
		get(AjsNBDManageUsersPage.class)
			.enter_first_name_in_filter_field("Anagha")
			.select_from_action_dropdown("Edit User")
		 	.verify_header_text_on_edit_user_form("Edit User")
			.close_edit_user_form();
	}
	
	@Test(priority=8, groups = {"functional"})                                    //verify activate user pop up text
	public void verifyActivateUserPopUpText() {
		
		get(AjsNBDManageUsersPage.class)
		 	.select_user_status_dropdown("Inactive Users")
		 	.wait_until(5)
		 	.enter_first_name_in_filter_field("angie")
		 	.press_enter()
		 	.wait_until(5)
		 	.select_from_action_dropdown("Activate User")
		 	.verify_inactivateusers_popup_text(to_activate_popup_text)
		 	.close_inactivateuser_popup()
		 	.click_clear_link_oninactive_users_page();
	}
	
	@Test(priority=9, groups = {"functional"})                                    //verify activate user pop up text
	public void CreateNewUser() {
		
		get(AjsNBDManageUsersPage.class)
			.wait_until(5)
			.click_create_new_user_button()
			.wait_until(5)
			.enter_emailid_in_field(new_user_id)
			.enter_firstname_in_field(firstname)
			.enter_salutation_in_field(salutation)
			.enter_middle_name_in_field(middle_name)
			.enter_last_name_field_in_field(last_name)
			.enter_title_in_field(title)
			.enter_workphone_in_field(work_phone)
			.enter_cellphone_in_field(cell_phone)
			.click_save_button()
			.wait_until(5)
			.enter_first_name_in_filter_field(firstname)
			.press_enter()
			.verify_first_name_text_in_firstname_column(firstname)
			.verify_last_name_text_in_lastname_column(last_name)
			.verify_email_id_in_email_column(new_user_id)
			.verify_work_phone_in_workphone_column(work_phone);
			
		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
	}
	
	@Test(priority=10, groups = {"functional"})                                   //verify first name in first name column
	public void EditPeerBuyer() {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(username)
			.enter_password(password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();

		 get(AjsNBDManageUsersPage.class)	
		 	.click_manageusers_tab()
		 	.wait_until(5)
		 	.enter_first_name_in_filter_field("salini")
		 	.press_enter()
		 	.verify_first_name_text_in_firstname_column("Salini")
		 	.verify_last_name_text_in_lastname_column("Paul")
		 	.verify_work_phone_in_workphone_column("789101")
		 	.select_action_from_action_dropdown("Edit User")
		 	.wait_until(8)
		 	.enter_edited_first_name("EditSalini")
		 	.enter_edited_last_name("EditPaul")
		 	.enter_edited_work_phone("123456")
		 	.click_save_button_on_edit_user()
		 	.wait_until(5)
		 	.click_clear_link()
		 	.wait_until(3)
		 	.enter_first_name_in_filter_field("EditSalini")
		 	.press_enter()
		 	.wait_until(4)
		 	.verify_first_name_text_in_firstname_column("EditSalini")
		 	.verify_last_name_text_in_lastname_column("EditPaul")
		 	.verify_work_phone_in_workphone_column("123456")
		 	.wait_until(5)
		 	.select_action_from_action_dropdown("Edit User")
		 	.wait_until(5)
		 	.enter_edited_first_name("Salini")
		 	.enter_edited_last_name("Paul")
		 	.enter_edited_work_phone("789101")
		 	.wait_until(5)
		 	.click_save_button_on_edit_user()
		 	.wait_until(5)
		 	.click_clear_link()
		 	.wait_until(3)
		 	.enter_first_name_in_filter_field("Salini")
		 	.press_enter()
		 	.wait_until(5)
		 	.verify_first_name_text_in_firstname_column("Paul")
		 	.verify_last_name_text_in_lastname_column("EditPaul")
		 	.verify_work_phone_in_workphone_column("789101");
	}
	
	
	@Test(priority=11, groups = {"functional"})                                   //verify first name in first name column
	public void VerifyInactivatationAndActivationOfPeerBuyer() {
		
		get(AjsNBDManageUsersPage.class)
		   .click_clear_link()
	       .enter_first_name_in_filter_field("Ron")
		   .press_enter()
		   .select_action_from_action_dropdown("Inactivate User")
		   .click_yes_button_in_inactive_user_popup()
		   .wait_until(5)
		   .select_user_status_dropdown("Inactive Users")
		   .wait_until(5)
		   .enter_first_name_in_filter_field("Ron")
		   .press_enter()
		   .wait_until(5)
		   .verify__first_name_text_in_inactive_user("Ron")
		   .verify_last_name_text_in_inactive_user("Buyer")
		   .verify_workphone_text_in_inactive_user("258963")
		   .select_action_in_manage_staff_inactive_user_filter("Activate User")
		   .click_yes_button_in_inactive_user_popup()
		   .wait_until(5)
		   .select_user_status_dropdown("Active Users")
		   .enter_first_name_in_filter_field("Ron")
		   .press_enter()
		   .wait_until(5)
		   .verify__first_name_text_in_inactive_user("Ron")
		   .verify_last_name_text_in_inactive_user("Buyer")
		   .verify_workphone_text_in_inactive_user("258963");
		
		get(AjsCommonUtilities.class)
		   .do_log_out_from_NBD();
	}
}
