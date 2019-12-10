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

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.page.NBDLogin;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class ST_Appointment_Transaction_Test extends AbstractAutoUITest{

	//Create new appointment
	String original_appointment_subject = "Original Appointment (4 Nov 2015)";
	String original_location = "Tenth Floor";
	String original_department = "Lab";
	String original_start_month = "August";
	String original_start_date = "8";  //always select Monday
		
	String original_start_year = "2016";
	String original_end_month = "August";
	String original_end_date = "15";   //always select Monday
	String original_end_year = "2016";

    //Edit created Appointment
	String edited_appointment_subject = "Edited Appointment";
	String edited_location = "Third Floor";
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
	  .enter_username("sachin.pathak@vendormate.com")
	  .enter_password("gltd@123")
	  .click_login_button()
	  .wait_until(6);
	
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
	  .enter_invite_guests_search_string("sachin.pathak@bizsense.in")
	  .click_filter_button_on_add_appointment()
	  .wait_until(3)
	  .click_invitee_checkbox1()
	  .click_save_appointment_button()
	  .wait_until(25)
	  .click_clear_link()
	  .wait_until(5)
	  .enter_appointment_subject(original_appointment_subject)
	  .click_filter_button()
	  .wait_until(5)
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
	  //.click_invitee_checkbox3()
	  .click_save_appointment_button()
	  .wait_until(25)
	  .click_clear_link()
	  .enter_appointment_subject(edited_appointment_subject)
	  .click_filter_button()
	  .wait_until(3)
	  .verify_location_name_in_result(edited_location)
	  .verify_department_name_in_result(edited_department)
	  .verify_appointment_name_in_search(edited_appointment_subject);
    }
		
		
  @Test(priority=3, groups = {"functional"})
	public void ViewOneTimeAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("View")
		  .wait_until(3)
		  .verify_view_appointment_header("View Appointment")
		  .click_cancel_button_on_view_appointment();
	}
		
		
  @Test(priority=4, groups = {"functional"})
	public void DeleteOneTimeAppointment() {
		get(NBDAppointmentsPage.class)
		  .wait_until(25)
	      .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .wait_until(4)
		  .select_1st_edit_delete_view_appointment("Delete")
		  .click_ok_button_on_delete_appointment_popup()
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .wait_until(3)
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
		  .enter_appointment_subject_in_add_appointment("Everyday Recurring"+original_appointment_subject)
		  .enter_appointment_description_in_add_appointment("Everyday Recurring"+original_appointment_subject)
		  .select_recurring_appointment_start_time("01:00 PM")
		  .select_recurring_appointment_end_time("02:00 PM")
		  .enter_invite_guests_search_string("sachin.pathak@bizsense.in")
		  .click_filter_button_on_add_appointment()
		  .wait_until(5)
		  .click_invitee_checkbox1()
		  .click_save_appointment_button()
		  .wait_until(25)
	      .click_clear_link()
		  .enter_appointment_subject("Everyday Recurring"+original_appointment_subject)
		  .click_filter_button()
		  .wait_until(3)
		  .verify_location_name_in_result(original_location)
		  .verify_department_name_in_result(original_department)
		  .verify_appointment_name_in_search("Everyday Recurring"+original_appointment_subject);
  }
	
  @Test(priority=6, groups = {"functional"})
	public void UpdateEverydayRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .select_1st_edit_delete_view_appointment("Edit")
		  .click_on_edit_only_this_appointments()
		  .select_appointment_location(edited_location)
		  .select_appointment_department(edited_department)
		  .enter_appointment_subject_in_add_appointment("Everyday Recurring"+edited_appointment_subject)
		  .enter_appointment_description_in_add_appointment("Everyday Recurring"+edited_appointment_subject)
		  .click_save_appointment_button()
		  .wait_until(25)
	      .click_clear_link()
		  .wait_until(5)
		  .enter_appointment_subject("Everyday Recurring"+edited_appointment_subject)
		  .click_filter_button()
		  .verify_location_name_in_result(edited_location)
		  .verify_department_name_in_result(edited_department)
		  .verify_appointment_name_in_search("Everyday Recurring"+edited_appointment_subject);
	}
	
  @Test(priority=7, groups = {"functional"})
	public void DeleteAllFutureRecurringAppointment() {
		get(NBDAppointmentsPage.class)
		  .wait_until(25)
	      .click_clear_link()
		  .wait_until(4)
		  .enter_appointment_subject("Everyday Recurring"+original_appointment_subject)
		  .click_filter_button()
		  .wait_until(3)
		  .select_2nd_edit_delete_view_appointment("Delete")
		  .click_on_delete_all_future_appointments()
		  .enter_appointment_subject(edited_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.")
		  .enter_appointment_subject("Everyday Recurring"+original_appointment_subject)
		  .click_filter_button()
		  .verify_appointment_not_found_msg("There were no appointments found.");
		
  
       get(CommonUtilities.class)
	      .do_log_out_from_NBD();
  }
  
  /**
	 * Use this method to take screen shot after failed test case. Ensure the Suite name before executing the suite file.
	 * It will create folder based on your suite file name present in the .xml file
	 * Copy paste this method at the bottom of your each class.
	 * @param project_name = provide name of your project 
	 */
	@AfterMethod(groups = "functional")
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
	}
}
	

