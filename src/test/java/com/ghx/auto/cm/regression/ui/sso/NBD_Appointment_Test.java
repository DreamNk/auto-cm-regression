package com.ghx.auto.cm.regression.ui.sso;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Appointment_Test extends AbstractAutoUITest {

	//Test data for 1 & 2 TC---------------------------------------------------------------------
	String buyer_id = "buyer1@universalhomecare.vdm";
	String buyer_password = null;
	String invite_rep_id = "rinny.lockhart@ghxv424.vm";
	String appointment_subject = "AD-Auto Appointment";
	String edited_appointment_subject= "AD-Edited Auto Appointment";

	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordStaging.xlsx";      
	String fileName = "GetPasswordStaging.xlsx";
	//--------------------------------------------------------------------------------------------
	String buyerUserNm = "wayne.admin@vendormate.com";
	String password =null;
	String optionForMonthlyRecuringApt = "Monthly";
	String optionForYearlyRecuringApt = "Yearly";

	String repeatByDateForMonthyApp = "SECOND";
	String repeatByDayForMonthyApp = "Saturday";
	String occursEveryDay = "2";

	String month = "July";
	String date="13";
	String year = "2019";
	String appEndDateM = "July";
	String appEndDateD = "21";
	String appEndDateY = "2018"; 

	// Variables for Daily Appointments-------------------------------------------------------------
	String dailyApptEndDate = "07/21/2018";

	String monthlySummaryMesssage = "second Saturday, Starts on Jul 13, 2019, Until Jul 13, 2019";
	String yearlysummaryMessage = "Annually on July 13, Starts on Jul 13, 2019, Until Jul 13, 2019";


	String location = "Hudson";
	String dept = "EP Lab";
	String apptSubject ="Appointment Subject added by Script";
	String editApptSubject = "Edit Appointment Subject";

	String apptDesc = "Appointment Description added by Script";
	String editApptDesc = "Edit Appointment Description";
	String invitedReps = "repone@aurora.vm";

	
	@Test(priority = 1, groups = { "functional" })
	public void CreateEditDeleteOneTimeAppointment() throws IOException {
		get(SSOLoginPage.class)
		   .invoke_loginURL("ssoUrl")
	       .enter_username(buyer_id);
		buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_id);	 
		get(SSOLoginPage.class)	
		   .enter_password(buyer_password)
		   .click_login_button();
		get(SSOCommonUtilities.class)
		   .select_option_from_solution_selector("Vendormate Credentialing");
		get(NBDHomePage.class)
		   .click_appointment_tab();
		get(NBDAppointmentsPage.class)
		   .click_add_appointment_button()
		   .select_location("Beverly Hills")
		   .select_department("Lab")
		   .select_start_date("July", "01", "2019")
		   .select_end_date("July", "02", "2019")
		   .select_one_time_appointment_start_time("10:00 AM")
		   .select_one_time_appointment_end_time("10:30 AM")
		   .enter_appointment_subject(appointment_subject)
		   .enter_appointment_description(appointment_subject)
		   .enter_invite_guest_email_in_searchbox(invite_rep_id);
       get(SSOCommonUtilities.class)
           .wait_until(5)
           .pressEnter()
           .wait_until(10);
       get(NBDAppointmentsPage.class)
           .check_invite_guest_checkbox()
           .click_save_appointment()
           .select_start_date_in_the_search("July", "01", "2019")
           .select_end_date("July", "02", "2019")
           .search_appointment_subject(appointment_subject)
           .wait_until(5)
           .select_option_from_appointment_actions_of_1st_record("Edit")
           .select_department("NICU")
           .select_start_date("July", "08", "2019")
           //.select_end_date("August", "11", "2018")
           .select_one_time_appointment_start_time("11:00 AM")
           .select_one_time_appointment_end_time("11:30 AM")
           .enter_appointment_subject(edited_appointment_subject)
           .enter_appointment_description(edited_appointment_subject)
           .wait_until(10)
           .click_save_appointment()
           .wait_until(5)
           .select_start_date_in_the_search("July", "08", "2019")
           .select_end_date("July", "10", "2019")
           .search_appointment_subject(edited_appointment_subject)
           .wait_until(3)
           .select_option_from_appointment_actions_of_1st_record("Delete")
           .wait_until(3)
           .click_ok_button_on_delete_confirmation_popup()
           .verify_no_appointment_found_msg("There were no appointments found");
           get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout");
}

    @Test(priority = 2, groups = { "functional" })
    public void CreateEditDeleteRecurringWeeklyAppointment() throws IOException {
    	get(SSOLoginPage.class)
		   .invoke_loginURL("ssoUrl")
	       .enter_username(buyer_id);
	       buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_id);	 
			get(SSOLoginPage.class)
		   .enter_password(buyer_password)
		   .click_login_button()
		   .wait_until(10);
		get(SSOCommonUtilities.class)
		   .select_option_from_solution_selector("Vendormate Credentialing")
		   .wait_until(10);
		get(NBDHomePage.class)
           .click_appointment_tab();
		get(NBDAppointmentsPage.class)
           .click_add_appointment_button()
           .click_recurring_appointment_radio_button()
           .select_option_from_repeats_dropdown("Weekly")
           .select_option_from_every_dropdown("1")
           .check_monday()
           .check_tuesday()
           .check_wednesday()
           .uncheck_sunday()
           .uncheck_thursday()
           .uncheck_friday()
           .uncheck_saturday()
           .select_start_date_from_recurring_appointmnet_popup("July", "15", "2019")
           .click_end_date_from_recurring_appointmnet_popup("July", "17", "2019")
           .click_done_button()
           .select_location("Beverly Hills")
           .select_department("Lab")
           .select_recurring_appointment_start_time("10:00 AM")
           .select_recurring_appointment_end_time("10:30 AM")
           .enter_appointment_subject(appointment_subject)
           .enter_appointment_description(appointment_subject)
           .enter_invite_guest_email_in_searchbox(invite_rep_id)
           .wait_until(3);
       get(SSOCommonUtilities.class)
           .pressEnter()
           .wait_until(5);
       get(NBDAppointmentsPage.class)
           .check_invite_guest_checkbox()
           .wait_until(8)
           .click_save_appointment()
           .select_start_date_in_the_search("July", "14", "2019")
           .select_end_date("July", "18", "2019")
           .search_appointment_subject(appointment_subject)
           .select_option_from_appointment_actions_of_2nd_record("Edit")
           .wait_until(3)
           .click_all_future_appointments_button()
           .select_department("NICU")
           .enter_appointment_subject(edited_appointment_subject)
           .enter_appointment_description(edited_appointment_subject)
           .wait_until(8)
           .click_save_appointment()
           .wait_until(2)
           .select_start_date_in_the_search("July", "14", "2019")
           .select_end_date("July", "18", "2019")
           .search_appointment_subject(edited_appointment_subject)
           .wait_until(2)
           .verify_department_in_1st_searched_record("NICU")
           .verify_department_in_2nd_searched_record("NICU")
           .verify_department_in_3rd_searched_record("NICU")
           .verify_subject_in_1st_searched_record(edited_appointment_subject)
           .verify_subject_in_2nd_searched_record(edited_appointment_subject)
           .verify_subject_in_3rd_searched_record(edited_appointment_subject)
           .select_option_from_appointment_actions_of_2nd_record("Delete")
           .wait_until(2)
           .click_all_future_appointments_button()
           .wait_until(4)
           .select_start_date_in_the_search("July", "14", "2019")
           .select_end_date("July", "18", "2019")
           .search_appointment_subject(edited_appointment_subject)
           .wait_until(2)
           .verify_no_appointment_found_msg("There were no appointments found");
       get(SSOCommonUtilities.class)
           .select_option_from_userName_dropdown("Logout")
           .wait_until(2);
    }


    @Test(priority = 3, groups = { "functional" })
    public void CreateRecurringMonthlyAppointment() throws IOException {

       get(SSOLoginPage.class)
    	   .invoke_loginURL("ssoUrl")
    	   .enter_username(buyerUserNm);
    	   password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
   		get(SSOLoginPage.class)
    	   .enter_password(password)
    	   .click_login_button()
    	   .wait_until(10);	 
       get(SSOCommonUtilities.class)
       		.select_option_from_solution_selector("Vendormate Credentialing")
       		.wait_until(10);
       get(NBDHomePage.class)
    	   .click_appointment_tab();
	 get(NBDAppointmentsPage.class)
          .click_add_appointment_button()
          .click_recurring_appointment_radio_button()
          .select_option_from_repeats_dropdown(optionForMonthlyRecuringApt)
          .click_repeat_by_radio_button()
          .select_option_from_repeat_by_date_dropdown(repeatByDateForMonthyApp)
          .select_option_from_repeat_by_day_dropdown(repeatByDayForMonthyApp)
          .select_start_date_from_recurring_appointmnet_popup(month, date, year)
          .click_end_date_from_recurring_appointmnet_popup(month,date,year)
          .verify_summary_message_for_monthly_appt(monthlySummaryMesssage)
          .click_done_button()
	 	  .select_location(location)
          .select_department(dept)
          .enter_appointment_subject(apptSubject)
          .enter_appointment_description(apptDesc)
          .enter_invite_guest_email_in_searchbox(invitedReps);
          
     get(SSOCommonUtilities.class)
          .pressEnter();
	 get(NBDAppointmentsPage.class)
          .check_invite_guest_checkbox()
          .click_save_appointment()
          .wait_until(15);
}

	@Test(priority = 4, groups = { "functional" })
	public void EditDeleteRecurringMonthlyAppointment() {
		
		get(NBDAppointmentsPage.class)
			.select_start_date_in_the_search(month,date,year)
			.select_end_date(month,date,year)
			.search_appointment_subject(apptSubject)
			.wait_until(5)
			.select_option_from_appointment_actions_of_1st_record("Edit")
			.click_all_future_appointments_button()
			.select_department("NICU")
			.enter_appointment_subject(editApptSubject)
			.enter_appointment_description(editApptDesc)
			.click_save_appointment()
			
			.select_start_date_in_the_search(month,date,year)
	        .select_end_date(month,date,year)
	        
	        .search_appointment_subject(editApptSubject)
	        .verify_department_in_1st_searched_record("NICU")
	        .verify_subject_in_1st_searched_record(editApptSubject)
	        
	        .select_option_from_appointment_actions_of_1st_record("Delete")
	        .click_all_future_appointments_button()
	        .wait_until(4)
	        .select_start_date_in_the_search(month, date, year)
	        .select_end_date(month, date, year)
	        .search_appointment_subject(editApptSubject)
	        .wait_until(2)
	        .verify_no_appointment_found_msg("There were no appointments found");
	  get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout");
		
	}

	@Test(priority = 5, groups = { "functional" })
	 public void CreateRecurringYearlyAppointment() throws IOException {

		 get(SSOLoginPage.class)
	     	.invoke_loginURL("ssoUrl")
	     	.enter_username(buyerUserNm);
		 password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyerUserNm);	 
	   		get(SSOLoginPage.class)	     	
	     	.enter_password(password)
	     	.click_login_button()
	     	.wait_until(10);	 
		 get(SSOCommonUtilities.class)
       		.select_option_from_solution_selector("Vendormate Credentialing")
       		.wait_until(10);
		 get(NBDHomePage.class)
	          .click_appointment_tab();
		 get(NBDAppointmentsPage.class)
	          .click_add_appointment_button()
	          .click_recurring_appointment_radio_button()
	          .select_option_from_repeats_dropdown(optionForYearlyRecuringApt)
	          .select_start_date_from_recurring_appointmnet_popup(month, date, year)
	          .click_end_date_from_recurring_appointmnet_popup(month,date,year)
	          .verify_yearly_summary_message(yearlysummaryMessage)
	          .click_done_button()
	          
		 	  .select_location(location)
	          .select_department(dept)
	          
	          .enter_appointment_subject(apptSubject)
	          .enter_appointment_description(apptDesc)
	          .enter_invite_guest_email_in_searchbox(invitedReps);
	          
	     get(SSOCommonUtilities.class)
	          .pressEnter();
		 get(NBDAppointmentsPage.class)
	          .check_invite_guest_checkbox()
	          .click_save_appointment()
	          .wait_until(15);
	}

	@Test(priority = 6, groups = { "functional" })
	public void EditDeleteRecurringYearlyAppointment() {
		
		get(NBDAppointmentsPage.class)
			.select_start_date_in_the_search(month,date,year)
			.select_end_date(month,date,year)
			.search_appointment_subject(apptSubject)
			.wait_until(10)
			.select_option_from_appointment_actions_of_1st_record("Edit")
			
			.click_all_future_appointments_button()
			.select_department("NICU")
			.enter_appointment_subject(editApptSubject)
			.enter_appointment_description(editApptDesc)
			.click_save_appointment()
			.wait_until(5)
			
			.select_start_date_in_the_search(month,date,year)
	        .select_end_date(month,date,year)
	        .search_appointment_subject(editApptSubject)
	        .verify_department_in_1st_searched_record("NICU")
	        .verify_subject_in_1st_searched_record(editApptSubject)
	        	        
	        .select_option_from_appointment_actions_of_1st_record("Delete")
	        .click_all_future_appointments_button()
	        .wait_until(4)
	        .select_start_date_in_the_search(month, date, year)
	        .select_end_date(month, date, year)
	        .search_appointment_subject(editApptSubject)
	        .wait_until(10)
	        .verify_no_appointment_found_msg("There were no appointments found");
	  get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout");
		
	}

 
}