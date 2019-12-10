package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Appointment_Transaction_Test extends AbstractAutoUITest{

	//Create new appointment
	String original_appointment_subject = "AD - Appointment";
	String original_location = "Atlanta";
	String original_department = "Lab";
	String original_start_month = "August";
	String original_start_date = "8";  //always select Monday
	
	String original_start_year = "2016";
	String original_end_month = "August";
	String original_end_date = "15";   //always select Monday
	String original_end_year = "2016";

   //Edit created Appointment
	String edited_appointment_subject = "Edited Appointment";
	String edited_location = "Colorado";
	String edited_department = "NICU";
	String edited_start_month = "September";
	String edited_start_date = "22";   //always select Monday
	String edited_start_year = "2016";
	String edited_end_month = "August";
	String edited_end_date = "29";     //always select Monday
	String edited_end_year = "2016";
	
	
	@Test(priority=1, groups = {"functional"})
	public void CreateOneTimeAppointment() {
		get(NBDLogin.class)
		  .invoke_loginurl("baseUrl")                                                 
		  .enter_username("auto_buyer1@tfhd.vdm")
		  .enter_password("gltd123")
		  .click_login_button()
		  .click_continue_button()
		  .wait_until(4);
		get(NBDAppointmentsPage.class)
		  .click_appointment_tab()
	      .click_add_appointment_button()
	      .select_appointment_location(original_location)
		  .select_appointment_department(original_department)
		  .enter_appointment_subject_in_add_appointment(original_appointment_subject)
		  .enter_appointment_description_in_add_appointment(original_appointment_subject)
		  .select_one_time_appointment_end_date(original_start_month, original_start_date, original_start_year)
		  .wait_until(2)
		  .select_one_time_appointment_start_date(original_start_month, original_start_date, original_start_year)
		  .select_appointment_start_time("01:00 PM")
		  .select_appointment_end_time("02:00 PM")
		  .enter_invite_guests_search_string("anaida.gillbert@av1.vm")
		  .click_filter_button_on_add_appointment()
		  .wait_until(5)
		  .click_invitee_checkbox1()
		  .click_save_appointment_button()
		  .wait_until(3)
		  .click_clear_link()
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(original_location)
		  .verify_department_name_in_result(original_department)
		  .verify_appointment_name_in_search(original_appointment_subject);
	}
	
	
	@Test(priority=2, groups = {"functional"})
	public void UpdateOneTimeAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment(edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment(edited_appointment_subject)
		  .select_one_time_appointment_end_date_digit("22")
		  .wait_until(2)
		  .select_one_time_appointment_start_date_digit("22")
		  .select_appointment_start_time("03:00 PM")
		  .select_appointment_end_time("04:00 PM")
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(2)
		  .click_clear_link()
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search(edited_appointment_subject);
	}
	
	
	@Test(priority=3, groups = {"functional"})
	public void ViewOneTimeAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("View")
		  .verify_view_appointment_header("View Appointment")
		  .click_cancel_button_on_view_appointment();
	}
	
	
	@Test(priority=4, groups = {"functional"})
	public void DeleteOneTimeAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .select_1st_edit_delete_view_appointment("Delete")
		  .click_ok_button_on_delete_appointment_popup()
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.");
		
	}
	
	

	@Test(priority=5, groups = {"functional"})
	public void CreateEverydayRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_add_appointment_button()
		  .click_recurring_appointment_radio_button()
		  .wait_until(2)
		  .select_recurring_appointment_end_date(original_end_month, original_end_date, original_end_year)
		  .select_recurring_appointment_start_date(original_start_month, original_start_date, original_start_year)
		  .select_occurrence_of_everyday_appointment("2")
		  .wait_until(2)
		  .click_done_on_recurring_appointment_popup()
		  .select_appointment_location(original_location)
		  .select_appointment_department(original_department)
		  .enter_appointment_subject_in_add_appointment(original_appointment_subject)
		  .enter_appointment_description_in_add_appointment(original_appointment_subject)
		  .select_recurring_appointment_start_time("01:00 PM")
		  .select_recurring_appointment_end_time("02:00 PM")
		  .enter_invite_guests_search_string("anaida.gillbert@av1.vm")
		  .click_filter_button_on_add_appointment()
		  .wait_until(5)
		  .click_invitee_checkbox1()
		  .click_save_appointment_button()
		  .click_clear_link()
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(original_location)
		  .verify_department_name_in_result(original_department)
		  .verify_appointment_name_in_search(original_appointment_subject);
    }
	
	@Test(priority=6, groups = {"functional"})
	public void UpdateEverydayRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .click_on_edit_only_this_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment(edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment(edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search(edited_appointment_subject);
	}
	
	@Test(priority=7, groups = {"functional"})
	public void DeleteAllFutureRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .select_2nd_edit_delete_view_appointment("Delete")
		  .click_on_delete_all_future_appointments()
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.")
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.");
		
	}
	
	@Test(priority=8, groups = {"functional"})
	public void CreateWeekdaysOnlyRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_add_appointment_button()
		  .click_recurring_appointment_radio_button()
		  .wait_until(2)
		  .select_type_of_appointment("Weekdays Only")
		  .select_monday_for_weekdays_only_appointment()
		  .select_wednesday_for_weekdays_only_appointment()
		  .select_tuesday_for_weekdays_only_appointment()
		  .uncheck_thursday_for_weekdays_only_appointment()
		  .uncheck_friday_for_weekdays_only_appointment()
		  .select_recurring_appointment_end_date("August", "10", "2016")
		  .select_recurring_appointment_start_date(original_start_month, "8", original_start_year)
		  .wait_until(2)
		  .click_done_on_recurring_appointment_popup()
		  .select_appointment_location(original_location)
		  .select_appointment_department(original_department)
		  .enter_appointment_subject_in_add_appointment(original_appointment_subject)
		  .enter_appointment_description_in_add_appointment(original_appointment_subject)
		  .select_recurring_appointment_start_time("01:00 PM")
		  .select_recurring_appointment_end_time("02:00 PM")
		  .enter_invite_guests_search_string("anaida.gillbert@av1.vm")
		  .click_filter_button_on_add_appointment()
		  .wait_until(5)
		  .click_invitee_checkbox1()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(original_location)
		  .verify_department_name_in_result(original_department)
		  .verify_appointment_name_in_search(original_appointment_subject);
    }
	
	@Test(priority=9, groups = {"functional"})
	public void UpdateOnlyThisWeekdaysAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .click_on_edit_only_this_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment(edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment(edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search(edited_appointment_subject);
	}
	
	
	@Test(priority=10, groups = {"functional"})
	public void UpdateFollowingWeekdaysAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .wait_until(4)
		  .select_2nd_edit_delete_view_appointment("Edit")
		  .click_on_edit_following_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment("Following"+edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment("Following"+edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject("Following"+edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search("Following"+edited_appointment_subject);
	}
	
	@Test(priority=11, groups = {"functional"})
	public void UpdateAllFutureWeekdaysAppointment() {
		get(NBDAppointmentsPage.class)
	      .click_clear_link()
		  .enter_appointment_subject("Following"+edited_appointment_subject)
		  .click_filter_button()
		  .wait_until(4)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .click_on_edit_all_future_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment("Future"+edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment("Future"+edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(4)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject("Future"+edited_appointment_subject)
		  .click_filter_button()
		  .wait_until(4)
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search("Future"+edited_appointment_subject);
		  }
	
	
	@Test(priority=12, groups = {"functional"})
	public void DeleteWeekdaysAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_2nd_edit_delete_view_appointment("Delete")
		  .click_on_delete_all_future_appointments()
		  .click_clear_link()
		  .wait_until(6)
		  .enter_appointment_subject("Future"+edited_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.");
		
		  }
	
	
	@Test(priority=13, groups = {"functional"})
	public void CreateWeeklyRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_add_appointment_button()
		  .click_recurring_appointment_radio_button()
		  .wait_until(2)
		  .select_type_of_appointment("Weekly")
		  .select_sunday_for_weekly_appointment()
		  .select_monday_for_weekly_appointment()
		  .select_saturday_for_weekly_appointment()
		  .uncheck_tuesday_for_weekly_appointment()
		  .uncheck_wednesday_for_weekly_appointment()
		  .uncheck_thursday_for_weekly_appointment()
		  .uncheck_friday_for_weekly_appointment()
		  .select_recurring_appointment_end_date(original_end_month, original_end_date, original_end_year)
		  .select_recurring_appointment_start_date(original_start_month, original_start_date, original_start_year)
		  .wait_until(2)
		  .click_done_on_recurring_appointment_popup()
		  .select_appointment_location(original_location)
		  .select_appointment_department(original_department)
		  .enter_appointment_subject_in_add_appointment(original_appointment_subject)
		  .enter_appointment_description_in_add_appointment(original_appointment_subject)
		  .select_recurring_appointment_start_time("01:00 PM")
		  .select_recurring_appointment_end_time("02:00 PM")
		  .enter_invite_guests_search_string("anaida.gillbert@av1.vm")
		  .click_filter_button_on_add_appointment()
		  .wait_until(5)
		  .click_invitee_checkbox1()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(original_location)
		  .verify_department_name_in_result(original_department)
		  .verify_appointment_name_in_search(original_appointment_subject);
    }
	
	@Test(priority=14, groups = {"functional"})
	public void UpdateOnlyThisWeeklyAppointment() {
		get(NBDAppointmentsPage.class)
		  .wait_until(2)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .click_on_edit_only_this_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment("OnlyThis"+edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment("OnlyThis"+edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject("OnlyThis"+edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search("OnlyThis"+edited_appointment_subject);
	}
	
	
	@Test(priority=15, groups = {"functional"})
	public void UpdateFollowingWeeklyAppointment() {
		get(NBDAppointmentsPage.class)
		  .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(original_appointment_subject)
		  .click_filter_button()
		  .wait_until(4)
		  .select_2nd_edit_delete_view_appointment("Edit")
		  .click_on_edit_following_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment("Following"+edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment("Following"+edited_appointment_subject)
		  .click_invitee_checkbox3()
		  .click_save_appointment_button()
		  .wait_until(5)
		  .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject("Following"+edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search("Following"+edited_appointment_subject);
		
		get(CommonUtilities.class)
		  .do_log_out_from_NBD();
	}
	
	
	
}