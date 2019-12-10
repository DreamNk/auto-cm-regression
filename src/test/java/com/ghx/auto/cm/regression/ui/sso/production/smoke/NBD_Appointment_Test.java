package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Appointment_Test extends AbstractAutoUITest {
	
	//One Time Appointment variables---------------------------------------------------------------------
	String buyer_id = "anamikadutta1001@gmail.com";
	String buyer_password = null;
	String invitee_rep_id = "mayurghx1@gmail.com";
	String appointment_subject = "AD-Auto one time appoi";
	String edited_appointment_subject = "AD-Edited Auto one time appoi";

	// Password for Production users Sheet
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
	
	 @Test(priority = 1, groups = { "functional" })
	 public void CreateEditDeleteOneTimeAppointment() throws IOException {
	  get(SSOLoginPage.class)
	          .invoke_loginURL("prodUrl")
	          .enter_username(buyer_id);
	  		   buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_id);
	  get(SSOLoginPage.class)
	          .enter_password(buyer_password)
	          .click_login_button();
	  get(SSOCommonUtilities.class)
	          .select_option_from_solution_selector("Vendormate Credentialing");
	  get(NBDHomePage.class)
	          .wait_until(40)
	          .click_appointment_tab();
	  get(NBDAppointmentsPage.class)
	          .wait_until(5)
	          .click_add_appointment_button()
	          .select_location("VIIT-Nagpur")
	          .select_department("Accounting")
	          .select_start_date("November", "15", "2018")
	          .wait_until(3)
	          .select_end_date("November", "16", "2018")
	          .wait_until(3)
	          .select_one_time_appointment_start_time("10:00 AM")
	          .select_one_time_appointment_end_time("10:30 AM")
	          .enter_appointment_subject(appointment_subject)
	          .enter_appointment_description(appointment_subject)
	          .enter_invite_guest_email_in_searchbox(invitee_rep_id)
	          .wait_until(3);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(3);
	  get(NBDAppointmentsPage.class)
	          .check_invite_guest_checkbox()
	          .wait_until(3)
	          .click_save_appointment()
	          .wait_until(3)
	          .select_start_date_in_the_search("November", "15", "2018")
	          .wait_until(3)
	          .select_end_date("November", "16", "2019")
	          .wait_until(3)
	          .search_appointment_subject(appointment_subject)
	          .wait_until(10)
	          .select_option_from_appointment_actions_of_1st_record("Edit")
	          .wait_until(5)
	          .select_department("Endoscopy")
	          .select_start_date("November", "19", "2018")
	          .wait_until(2)
	          //.select_end_date("December", "11", "2017")
	          .select_one_time_appointment_start_time("11:00 AM")
	          .select_one_time_appointment_end_time("11:30 AM")
	          .enter_appointment_subject(edited_appointment_subject)
	          .enter_appointment_description(edited_appointment_subject)
	          .wait_until(5)
	          .click_save_appointment()
              .wait_until(3)
	          .select_start_date_in_the_search("November", "19", "2018")
	          .wait_until(3)
	          .select_end_date("November", "20", "2018")
	          .wait_until(3)
	          .search_appointment_subject(edited_appointment_subject)
	          .wait_until(4)
	          .select_option_from_appointment_actions_of_1st_record("Delete")
	          .wait_until(1)
	          .click_ok_button_on_delete_confirmation_popup()
	          .wait_until(5)
	          .select_start_date_in_the_search("November", "19", "2018")
	          .wait_until(3)
	          .select_end_date("November", "20", "2018")
	          .wait_until(3)
	          .search_appointment_subject(edited_appointment_subject)
	          .wait_until(3)
	          .verify_no_appointment_found_msg("There were no appointments found");
	}
	 
	 
	 //Recurring Appointment variables---------------------------------------------------------------------
	 String recurringAppointmentSubject = "AD-Auto recurring appoi";
	 String recurringEditedAppointmentSubject = "AD-Edited Auto recurring appoi";
	 
	 
	 @Test(priority = 2, groups = { "functional" })
	 public void CreateEditDeleteRecurringWeeklyAppointment() {

	  get(NBDHomePage.class)
	  		  .wait_until(3)
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
	          .select_start_date_from_recurring_appointmnet_popup("February", "04", "2019")
	          .click_end_date_from_recurring_appointmnet_popup("February", "06", "2019")
	          .click_done_button()
	          .select_location("VIIT-Nagpur")
	          .select_department("Accounting")
	          .select_recurring_appointment_start_time("10:00 AM")
	          .select_recurring_appointment_end_time("10:30 AM")
	          .enter_appointment_subject(recurringAppointmentSubject)
	          .enter_appointment_description(recurringAppointmentSubject)
	          .enter_invite_guest_email_in_searchbox(invitee_rep_id)
	          .wait_until(3);
	  get(SSOCommonUtilities.class)
	          .pressEnter()
	          .wait_until(3);
	  get(NBDAppointmentsPage.class)
	          .check_invite_guest_checkbox()
	          .wait_until(4)
	          .click_save_appointment()
	          .wait_until(3)
	          .select_start_date_in_the_search("February", "04", "2019")
	          .wait_until(3)
	          .select_end_date("February", "06", "2019")
	          .wait_until(3)
	          .search_appointment_subject("AD-Auto Rec")
	          .wait_until(3)
	          .select_option_from_appointment_actions_of_2nd_record("Edit")
	          .wait_until(2)
	          .click_all_future_appointments_button()
	          .wait_until(4)
	          .select_department("Endoscopy")
	          .enter_appointment_subject(recurringEditedAppointmentSubject)
	          .enter_appointment_description(recurringEditedAppointmentSubject)
	          .wait_until(3)
	          .click_save_appointment()
	          .wait_until(5)
	          .select_start_date_in_the_search("February", "04", "2019")
	          .wait_until(3)
	          .select_end_date("February", "06", "2019")
	          .wait_until(3)
	          .search_appointment_subject(recurringEditedAppointmentSubject)
	          .wait_until(3)
	          .verify_department_in_1st_searched_record("Endoscopy")
	          .verify_department_in_2nd_searched_record("Endoscopy")
	          .verify_department_in_3rd_searched_record("Endoscopy")
	          .verify_subject_in_1st_searched_record(recurringEditedAppointmentSubject)
	          .verify_subject_in_2nd_searched_record(recurringEditedAppointmentSubject)
	          .verify_subject_in_3rd_searched_record(recurringEditedAppointmentSubject)
	          .select_option_from_appointment_actions_of_2nd_record("Delete")
	          .wait_until(3)
	          .click_all_future_appointments_button()
	          .wait_until(5)
	          .select_start_date_in_the_search("February", "04", "2019")
	          .wait_until(3)
	          .select_end_date("February", "06", "2019")
	          .wait_until(3)
	          .search_appointment_subject(recurringEditedAppointmentSubject)
	          .wait_until(2)
	          .verify_no_appointment_found_msg("There were no appointments found")
	          .wait_until(2);
	  get(SSOCommonUtilities.class)
	          .select_option_from_userName_dropdown("Logout")
	          .clear_current_session();
	}


}
