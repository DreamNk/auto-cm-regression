package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NVDRequestAppointmentPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class RIA_Test extends AbstractAutoUITest {
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	
	String rep_user_id = "r2@egxv150.vm";
	String password = null;
	String account_name = "Universal Home Care Inc";
	String location = "New Jersey";                             //  Beverly Hills/Alaska- Changed because of Old appt with Pending status in NBD  //
	String department = "NICU";
	String one_time_subject = "AD-RIA-OTA 5";
	String recurring_appointment_subject = "AD-RIA-RA 5";
	String app_date = "05";
	String app_month = "November";
	String app_year = "2018";
	String recurring_app_end_date = "07";
	String recurring_app_end_month = "November";
	String recurring_app_end_year = "2018";
	//------------------------------------------------------
	String buyer_user_id = "buyer5@universalhomecare.vdm";
	String buyer_password = null;
	String vendor_name = "HAWAII CHEMICAL COMPANY LIMITED";

	 @Test(priority = 1, groups = { "functional" })
	 public void CreateOneTimeRIA() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(rep_user_id);
	          password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_user_id);	 
	  get(SSOLoginPage.class)	
	          .enter_password(password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(10);
	  get(NVDRequestAppointmentPage.class)
	          .click_actions()
	          .wait_until(2)
	          .click_options_from_action("Request Appointment")
	          .wait_until(6)
	          .select_start_date_for_one_time_appointment(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_for_one_time_appointment(app_month, app_date, app_year)
	          .wait_until(2)
	          .select_an_account(account_name)
	          .select_requested_staff("Jeff Walker")
	          .select_location(location)
	          .select_department(department)
	          .enter_appointment_subject(one_time_subject)
	          .enter_appointment_description(one_time_subject)
	          .click_send_appointment_button()
	          .click_ok_RIA_successfully_created_button()
	          .click_actions()
	          .wait_until(2)
	          .click_options_from_action("View Requests")
	          .wait_until(2)
	          .enter_account_name_in_searchbox(account_name)
	          .wait_until(2)
	          .enter_appointment_location(location)
	          .wait_until(2)
	          .enter_subject_in_searchbox(one_time_subject)
	          .wait_until(3)
	          .select_start_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	  get(NVDRequestAppointmentPage.class)
	          .verify_account_name(account_name)
	          .verify_department_name(department)
	          .verify_location_name(location)
	          .verify_subject(one_time_subject)
	          .wait_until(4);
	  get(SSOCommonUtilities.class)
              .select_option_from_userName_dropdown("Logout")
              .clear_current_session();
	 }
	
	 @Test(priority = 2, groups = { "functional" })
     public void AcceptOneTimeRIARequestInNBD() throws IOException {
	  get(SSOLoginPage.class)
             .invoke_loginURL("ssoUrl")
             .enter_username(buyer_user_id);
	         buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_user_id);	 
	  get(SSOLoginPage.class)	
             .enter_password(buyer_password)
             .click_login_button()
             .wait_until(10);
      get(SSOCommonUtilities.class)
             .select_option_from_solution_selector("Vendormate Credentialing")
             .wait_until(20);
      get(NBDHomePage.class)
             .wait_until(10)
             .click_appointment_tab();
      get(NBDAppointmentsPage.class)
             .wait_until(10)
             .click_appointment_request_tab()
             .select_option_from_status_dropdown("Pending")
             .wait_until(4)
             .enter_subject_in_RIA_searchbox(one_time_subject)
             .wait_until(4)
             .enter_location_in_RIA_searchbox(location)
             .wait_until(4)
             .select_start_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4)
             .select_end_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4);
	  get(SSOCommonUtilities.class)
             .pressEnter();
      get(NBDAppointmentsPage.class)
             .wait_until(4)
             .click_checkbox_for_1st_RIA_request()
             .Select_option_from_RIA_actions_dropdown("accept")
             .click_yes_on_accept_appointment_popup()
             .wait_until(4)
             .select_option_from_status_dropdown("Accepted")
             .wait_until(4)
             .enter_subject_in_RIA_searchbox(one_time_subject)
             .wait_until(4)
             .enter_location_in_RIA_searchbox(location)
             .wait_until(4)
             .select_start_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4)
             .select_end_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4);
      get(SSOCommonUtilities.class)
             .pressEnter()
             .wait_until(4);
      get(NBDAppointmentsPage.class)
             .verify_subject_In_RIA_Search_Result_Record1(one_time_subject)
             .verify_company_name_in_RIA_Search_Result_Record1(vendor_name)
             .verify_department_name_in_RIA_search_Result_Record1(department);

	  get(SSOCommonUtilities.class)
             .select_option_from_userName_dropdown("Logout")
             .clear_current_session();
             
}
	 
	 @Test(priority = 3, groups = { "functional" })
	 public void VerifyAcceptedOneTimeAppointmentRequestInNVD() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(rep_user_id);
	          password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_user_id);	 
	  get(SSOLoginPage.class)	
	          .enter_password(password)
	          .click_login_button()
	          .wait_until(10);
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing")
	          .wait_until(10);
	  get(NVDRequestAppointmentPage.class)
	          .click_actions()
	          .wait_until(3)
	          .click_options_from_action("View Requests")
	          .wait_until(4)
	          .select_options_from_request_status_dropdown("Accepted")
	          .wait_until(5)
	   		  .enter_account_name_in_searchbox(account_name)
	   		  .wait_until(3)
	   		  .enter_appointment_location(location)
	   		  .wait_until(3)
	          .enter_subject_in_searchbox(one_time_subject)
	          .wait_until(3)
	          .select_start_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	  get(NVDRequestAppointmentPage.class)
	          .verify_account_name(account_name)
	          .verify_department_name(department)
	          .verify_location_name(location)
	          .verify_subject(one_time_subject);
	  get(SSOCommonUtilities.class)
              .select_option_from_userName_dropdown("Logout")
              .clear_current_session();
	 }
	
	 
	 @Test(priority = 4, groups = { "functional" })
	 public void CreateRecurringRIA() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(rep_user_id);
	          password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_user_id);	 
      get(SSOLoginPage.class)	
	          .enter_password(password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing");
	
	  get(NVDRequestAppointmentPage.class)
	          .click_actions()
	          .wait_until(2)
	          .click_options_from_action("Request Appointment")
	          .wait_until(2)
	          .click_recurring_appointment_radio_button()
	          .select_option_from_repeats_dropdown("Weekly")
	          .uncheck_sunday()
	          .check_monday()
	          .check_tuesday()
	          .check_wednesday()
	          .uncheck_thursday()
	          .uncheck_friday()
	          .uncheck_saturday()
	          .select_start_date_for_recurring_appointment(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_for_recurring_appointment(recurring_app_end_month, recurring_app_end_date, recurring_app_end_year)
	          .wait_until(4)
	          .click_done_button()
	          .wait_until(2)
	          .select_an_account(account_name)
	          .select_requested_staff("Jeff Walker")
	          .select_location(location)
	          .select_department(department)
	          .enter_appointment_subject(recurring_appointment_subject)
	          .enter_appointment_description(recurring_appointment_subject)
	          .click_send_appointment_button()
	          .click_ok_RIA_successfully_created_button()
	          .click_actions()
	          .wait_until(2)
	          .click_options_from_action("View Requests")
	          .wait_until(2)
	          .enter_account_name_in_searchbox(account_name)
	          .enter_subject_in_searchbox(recurring_appointment_subject)
	          .select_start_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_from_search_field(recurring_app_end_month, recurring_app_end_date, recurring_app_end_year)
	          .enter_appointment_location(location)
	          .wait_until(4);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	  get(NVDRequestAppointmentPage.class)
	          .verify_account_name(account_name)
	          .verify_department_name(department)
	          .verify_location_name(location)
	          .verify_subject(recurring_appointment_subject);
	  get(SSOCommonUtilities.class)
              .select_option_from_userName_dropdown("Logout");
	 }
	 
	 @Test(priority = 5, groups = { "functional" })
     public void AcceptRecurringRIARequestInNBD() throws IOException {
	  get(SSOLoginPage.class)
             .invoke_loginURL("ssoUrl")
             .enter_username(buyer_user_id);
             buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_user_id);	 
	  get(SSOLoginPage.class)	
             .enter_password(buyer_password)
             .click_login_button();
      get(SSOCommonUtilities.class)
             .select_option_from_solution_selector("Vendormate Credentialing");
      get(NBDHomePage.class)
             .wait_until(10)
             .click_appointment_tab();
      get(NBDAppointmentsPage.class)
             .wait_until(10)
             .click_appointment_request_tab()
             .select_option_from_status_dropdown("Pending")
             .wait_until(4)
             .enter_subject_in_RIA_searchbox(recurring_appointment_subject)
             .select_start_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4)
             .select_end_date_for_RIA_request(recurring_app_end_month, recurring_app_end_date, recurring_app_end_year)
             .enter_location_in_RIA_searchbox(location)
             .wait_until(4);
	  get(SSOCommonUtilities.class)
             .pressEnter();
      get(NBDAppointmentsPage.class)
             .wait_until(4)
             .click_checkbox_for_1st_RIA_request()
             .Select_option_from_RIA_actions_dropdown("accept")
             .click_yes_on_accept_appointment_popup()
             .wait_until(4)
             .select_option_from_status_dropdown("Accepted")
             .wait_until(4)
             .enter_subject_in_RIA_searchbox(recurring_appointment_subject)
             .select_start_date_for_RIA_request(app_month, app_date, app_year)
             .wait_until(4)
             .select_end_date_for_RIA_request(recurring_app_end_month, recurring_app_end_date, recurring_app_end_year)
             .enter_location_in_RIA_searchbox(location)
             .wait_until(4);
      get(SSOCommonUtilities.class)
             .pressEnter()
             .wait_until(4);
      get(NBDAppointmentsPage.class)
             .verify_subject_In_RIA_Search_Result_Record1(recurring_appointment_subject)
             .verify_company_name_in_RIA_Search_Result_Record1(vendor_name)
             .verify_department_name_in_RIA_search_Result_Record1(department);

	  get(SSOCommonUtilities.class)
             .select_option_from_userName_dropdown("Logout")
             .clear_current_session();
             
}
	 
	 @Test(priority = 6, groups = { "functional" })
	 public void VerifyAcceptedAppointmentRequestInNVD() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("ssoUrl")
	          .enter_username(rep_user_id);
	          password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, rep_user_id);	 
	  get(SSOLoginPage.class)	
	          .enter_password(password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing");
	
	  get(NVDRequestAppointmentPage.class)
	          .click_actions()
	          .wait_until(3)
	          .click_options_from_action("View Requests")
	          .wait_until(10)
	          .select_options_from_request_status_dropdown("Accepted")
	          .wait_until(5)
	          .enter_account_name_in_searchbox(account_name)
	          .wait_until(2)
	          .enter_appointment_location(location)
	          .wait_until(2)
	          .enter_subject_in_searchbox(recurring_appointment_subject)
	          .select_start_date_from_search_field(app_month, app_date, app_year)
	          .wait_until(4)
	          .select_end_date_from_search_field(recurring_app_end_month, recurring_app_end_date, recurring_app_end_year)
	          .enter_appointment_location(location)
	          .wait_until(4);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(4);
	  get(NVDRequestAppointmentPage.class)
	          .verify_account_name(account_name)
	          .verify_department_name(department)
	          .verify_location_name(location)
	          .verify_subject(recurring_appointment_subject);
	  get(SSOCommonUtilities.class)
              .select_option_from_userName_dropdown("Logout")
              .clear_current_session();
	 }

}
