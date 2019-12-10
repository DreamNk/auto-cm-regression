package com.ghx.auto.cm.regression.ui.sso.production.smoke;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDManageUsersPage;
import com.ghx.auto.cm.ui.sso.page.NBDMyProfilePage;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NBDResourceCenterPage;
import com.ghx.auto.cm.ui.sso.page.NBDSignInHistoryPage;
import com.ghx.auto.cm.ui.sso.page.NBDVendorsPage;
import com.ghx.auto.cm.ui.sso.page.ReadWritePasswordExcelPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_UI_Checks extends AbstractAutoUITest {

	// Password for Production users Sheet
	String filePath = "D:\\CMAutoWorkspace\\auto-cm-regression\\src\\test\\resources\\stage\\GetPasswordProduction.xlsx"; 
	String fileName = "GetPasswordProduction.xlsx";
	
	String buyer_id = "meeta.buyer@gmail.com";
	String buyer_password = null;
	String userName = "meeta.buyer@gmail.com";
	String firstName = "Meeta";
	String lastName= "Buyer";
	String contacInfo = "Contact & Personal Information";
	String workPhone = "1111111111";
	String recentVisitors = "Recent Visitors";
	String recentCompReg = "Recent Company Registrations";
	String myAppt = "My Appointments";
	String signInHistory = "Sign-In History";
	String legalName="Billing and Collections Company";
	String userSts = "Active Users";
	String signHst = "Sign-In History";
	String repFirstName = "Oliva";
	
	String repLastName= "Maddison";
	String repCompanyNm= "Billing and Collections Company";
	String phoneNo= "988764444";
	String repMailId= "oliva.maddison@gmail.com";
	String appointmentRequesterHeader = "Manage Appointment Requests";
		
	@Test(priority=1, groups = {"functional"})                                        
	public void NBDMyProfilePageChecks() throws IOException{
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl")                                           
			.enter_username(buyer_id);
		  buyer_password =	get(ReadWritePasswordExcelPage.class).read_data_excel(filePath, fileName, buyer_id);
		  get(SSOLoginPage.class)
			.enter_password(buyer_password)
			.click_login_button();
		get(SSOCommonUtilities.class)
			.wait_until(5)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(10);
	
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("My Profile")
			.wait_until(5);
		get(NBDMyProfilePage.class)
			.verify_user_id_text(userName)
			.verify_first_name_text(firstName)
			.verify_last_name_text(lastName)
			.verify_work_phone_text(workPhone)
			.click_edit_button()
			.verify_contact_and_personal_info_tab_text(contacInfo);
	}
	
	@Test(priority=2, groups = {"functional"})                                        
	public void NBDHomePageChecks(){
		get(NBDHomePage.class)
			.click_home_tab()
			.verify_recent_visitors(recentVisitors)
			.verify_recent_company_registration_text(recentCompReg)
			.verify_my_appointments_text(myAppt)
			.click_recent_visitors_link();
		get(NBDSignInHistoryPage.class)
			.verify_sign_in_history_column_text(signInHistory)
			.click_back_to_home_link();
		get(NBDHomePage.class)
			.click_appointment_tab();
		get(NBDAppointmentsPage.class)
			.verify_appointments_tab_heading();
	}
	
	@Test(priority=3, groups = {"functional"})                                        
	public void NBDVRegistrationAndVisitsChecks(){
		get(NBDHomePage.class)
		.click_home_tab()
		.verify_registration_and_visits_text()
		.verify_unpaid_vendors_link()
		.verify_vendors_registered_link()
		.verify_vendors_registered_link()
		.verify_visit_in_last_30_days_link()
		.verify_pending_appointment_link()
		.click_unpaid_vendors_link()
		.verify_reps_of_unpaid_vendors()
		.click_home_tab()
		.click_vendors_registered_link()
		.verify_vendors_tab()
		.click_home_tab()
		.click_reps_registered_link()
		.verify_reps_text_of_rep_registered_link()
		.click_home_tab()
		.click_visit_in_last_30_days_link()
		.verify_sign_in_history_text()
		.click_home_tab()
		.click_pending_appointment_link()
		.verify_pending_appt_request_text()
		.click_home_tab();
	}
	
	
	@Test(priority=4, groups = {"functional"})                                        
	public void NBDVendordsPageChecks(){
		get(NBDHomePage.class)
			.click_vendors_tab();
		get(NBDVendorsPage.class)
			.enter_legal_name(legalName);
		get(SSOCommonUtilities.class)
			.pressEnter();
		get(NBDVendorsPage.class)
			.click_legal_name_for_search()
			.verify_legal_name_text(legalName)
			.verify_export_text();
		}
	
	@Test(priority=5, groups = {"functional"})                                        
	public void NBDRepPageChecks(){
		get(NBDHomePage.class)
			.click_reps_tab()
			.wait_until(5);
		get(NBDRepsPage.class)
			.verify_reps_header_text()
			.enter_rep_first_name(repFirstName)
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.pressEnter()
			.wait_until(4);
		get(NBDRepsPage.class)
			.verify_rep_first_name(repFirstName)
			.verify_rep_last_name(repLastName)
			.verify_rep_company_name(repCompanyNm)
			.verify_rep_phone_no(phoneNo)
			.verify_email_id(repMailId);
	}
	
	
	@Test(priority=6, groups={"functional"})
	public void NBDManageUsersTab(){
		get(NBDHomePage.class)
			.click_manage_users_tab();
		get(NBDManageUsersPage.class)
			.wait_until(3)
			.verify_select_user_status(userSts)
			.enter_email_address(userName);
		get(SSOCommonUtilities.class)
			.pressEnter();
		get(NBDManageUsersPage.class)
			.verify_first_name(firstName)
			.verify_last_name(lastName)
			.verify_email_id(userName);
			//.verify_work_phone(workPhone);
	}
	
		
	@Test(priority=7, groups={"functional"})
	public void NBDSignInHistoryTab(){
		get(NBDHomePage.class)
			.click_sign_in_history_tab();
		get(NBDSignInHistoryPage.class)
			.wait_until(2)
			.verify_sign_in_history_column_text(signInHistory);
	}
	
	@Test(priority=8, groups={"functional"})
	public void NBDResourceCenterTab(){
		get(NBDHomePage.class)
			.click_resource_center_tab();
		get(NBDResourceCenterPage.class)
			.verify_global_admin_resource()
			.wait_until(2)
			.verify_admin_resource()
			.wait_until(2)
			.verify_global_user_resource()
			.wait_until(2)
			.verify_customer_admin_resource()
			.wait_until(2)
			.verify_customer_user_resource()
			.wait_until(2)
			.verify_health_system_policies()
			.wait_until(5);
	}

	@Test(priority=9, groups={"functional"})
	public void NBDActionDropDown(){
		get(NBDHomePage.class)
			.click_configure_unconfigure_signin_machine()
			.wait_until(5)
			.verify_configure_unconfigure_sign_in_text()
			.click_actions_drop_down()
			.click_add_appointment_tab()
			.wait_until(3)
			.verify_add_appointment_text()
			.click_actions_drop_down()
			.wait_until(3);			
		get(NBDVendorsPage .class)	
			.click_manage_vendor_permissions()
			.wait_until(3)
			.verify_manage_vendor_permission_text();
		get(NBDHomePage.class)	
			.click_actions_drop_down();
		get(NBDRepsPage.class)
			.click_manage_rep_permissions_tab()
			.wait_until(3)
			.verify_manage_rep_permission_text()
			.enter_first_name_in_manage_rep_permission(repFirstName);
		get(SSOCommonUtilities.class)
			.pressEnter();
		get(NBDRepsPage.class)
			.verify_have_appointment_permission_for_rep()
			.verify_first_name_in_manage_rep_permissions(repFirstName)
			.verify_last_name_in_manage_rep_permissions(repLastName)
			.verify_company_name_in_manage_rep_permissions(repCompanyNm);
		get(NBDHomePage.class)	
			.click_actions_drop_down()
			.wait_until(5);
		get(NBDAppointmentsPage.class)	
			.click_appointment_request_tab_in_actions_drop_down()
			.wait_until(3)
			.verify_appointment_requester_header(appointmentRequesterHeader)
			.wait_until(2);
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl");
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
			.wait_until(3);	
		
	}
	
	@Test(priority=10, groups={"functional"})
	public void NBDSearchForVendorsAndRep(){
		get(NBDHomePage.class)
			.wait_until(2)
			.click_search_for_vendors_and_rep()
			.enter_vendor_name(legalName);
		get(SSOCommonUtilities.class)
			.pressEnter();
		get(SSOLoginPage.class)
			.invoke_loginURL("prodUrl");
		get(SSOCommonUtilities.class)
			.select_option_from_solution_selector("Vendormate Credentialing")
		.wait_until(3);
		get(NBDHomePage.class)
			.enter_rep_first_name(repMailId)
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.pressEnter()
			.wait_until(3);
		get(NBDHomePage.class)
			.verify_rep_search_results();
		get(SSOCommonUtilities.class)
			.click_tv_icon()
			.click_close_system_status_button()
			.wait_until(3);
		get(SSOCommonUtilities.class)
			.select_option_from_userName_dropdown("Logout")
			.clear_current_session();
	}

}
