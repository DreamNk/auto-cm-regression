package com.ghx.auto.cm.regression.ui.sso;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.sso.page.NBDAppointmentsPage;
import com.ghx.auto.cm.ui.sso.page.NBDHomePage;
import com.ghx.auto.cm.ui.sso.page.NBDManageUsersPage;
import com.ghx.auto.cm.ui.sso.page.NBDMyProfilePage;
import com.ghx.auto.cm.ui.sso.page.NBDRepsPage;
import com.ghx.auto.cm.ui.sso.page.NBDResourceCenterPage;
import com.ghx.auto.cm.ui.sso.page.NBDVendorsPage;
import com.ghx.auto.cm.ui.sso.page.SSOCommonUtilities;
import com.ghx.auto.cm.ui.sso.page.SSOLoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Tab_Checks_Test extends AbstractAutoUITest{
	
	String userId = "wayne.admin@vendormate.com";
	String password = "Gltd125!";
	String firstName = "Wayne";
	String lastName= "Admin";
	String contacInfo = "Contact & Personal Information";
	String workPhone = "4353453";
	
	String recentVisitors = "Recent Visitors";
	String recentCompReg = "Recent Company Registrations";
	String myAppt = "My Appointments";
	String signInHistory = "Sign-In History";
	String legalName="CareView Communications";
	String dbaNm = "CareView Inc";
	String userSts = "Active Users";
	String signHst = "Sign-In History";
	String manageApptReqText="Manage Appointment Requests";
	
	String repFirstName = "Automation";
	String repLastName= "Rep";
	String repCompanyNm= "RAYMOND NATHAN";
	String phoneNo= "423423";
	String repMailId= "repone@raymond.vm";
	
		
	@Test(priority=1, groups = {"functional"})                                        
	public void NBDMyProfilePageChecks(){
		get(SSOLoginPage.class)
			.invoke_loginURL("nbdUrl")                                           
			.enter_username(userId)
			.enter_password(password)
			.click_login_button();
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("My Profile");
		get(NBDMyProfilePage.class)
			.verify_user_id_text(userId)
			.verify_first_name_text(firstName)
			.verify_last_name_text(lastName)
			.verify_work_phone_text(workPhone)
			.click_edit_button()
			.wait_until(5)
			.verify_contact_and_personal_info_tab_text(contacInfo);
	}
	
	@Test(priority=2, groups = {"functional"})                                        
	public void NBDHomePageChecks(){
		get(NBDHomePage.class)
			.click_home_tab()
			.wait_until(5)
			.verify_recent_visitors(recentVisitors)
			.verify_recent_company_registration_text(recentCompReg)
			.verify_my_appointments_text(myAppt)
			.click_recent_visitors_link()
			.wait_until(5);
		
		get(NBDHomePage.class)
			.click_appointment_tab()
			.wait_until(5);
		get(NBDAppointmentsPage.class)
			.verify_appointments_tab_heading();
	}
	
	@Test(priority=3, groups = {"functional"})                                        
	public void NBDVRegistrationAndVisitsChecks(){
		get(NBDHomePage.class)
		.click_home_tab()
		.wait_until(5)
		.verify_registration_and_visits_text()
		.verify_unpaid_vendors_link()
		.verify_vendors_registered_link()
		.verify_vendors_registered_link()
		.verify_visit_in_last_30_days_link()
		.verify_pending_appointment_link()
		.click_unpaid_vendors_link()
		.wait_until(5)
		.verify_reps_of_unpaid_vendors()
		.click_home_tab()
		.wait_until(5)
		.click_vendors_registered_link()
		.verify_vendors_tab()
		.click_home_tab()
		.click_reps_registered_link()
		.verify_reps_text_of_rep_registered_link()
		.click_home_tab()
		.click_visit_in_last_30_days_link()
		.wait_until(3)
		.verify_sign_in_history_text()
		.click_home_tab()
		.wait_until(3)
		.click_pending_appointment_link()
		.verify_pending_appt_request_text()
		.wait_until(3)
		.click_home_tab()
		.wait_until(5);
	}
	
	@Test(priority=4, groups = {"functional"})                                        
	public void NBDVendordsPageChecks(){
		get(NBDHomePage.class)
			.click_vendors_tab();
		get(SSOCommonUtilities.class)
			.wait_for_text_appear("Select");
		get(NBDVendorsPage.class)
			.enter_legal_name(legalName);
		get(SSOCommonUtilities.class)
			.pressEnter();
		get(NBDVendorsPage.class)
			.click_legal_name_for_search()
			.wait_until(5)
			.verify_legal_name_text(legalName)
			.wait_until(2)
			.verify_dba_name_text(dbaNm)
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
			.wait_until(5);
		get(SSOCommonUtilities.class)
			.pressEnter();
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
			.enter_email_address(userId)
			.wait_until(5);
		get(SSOCommonUtilities.class)
			.pressEnter()
			.wait_until(5);
		get(NBDManageUsersPage.class)
			.verify_first_name(firstName)
			.verify_last_name(lastName)
			.verify_email_id(userId);
			//.verify_work_phone(workPhone);
	}
	
		
	@Test(priority=7, groups={"functional"})
	public void NBDSignInHistoryTab(){
		get(NBDHomePage.class)
			.click_sign_in_history_tab()
			.wait_until(5);
	}
	
	@Test(priority=8, groups={"functional"})
	public void NBDResourceCenterTab(){
		get(NBDHomePage.class)
			.click_resource_center_tab();
		get(NBDResourceCenterPage.class)
			.verify_global_admin_resource()
			.verify_admin_resource()
			.verify_global_user_resource()
			.verify_customer_admin_resource()
			.verify_customer_user_resource()
			.verify_health_system_policies();
	}
	
	@Test(priority=9, groups={"functional"})
	public void NBDActionDropDown(){
		get(NBDHomePage.class)
			.click_configure_unconfigure_signin_machine()
			.wait_until(5)
			.verify_configure_unconfigure_sign_in_text()
			.click_actions_drop_down()
			.wait_until(5)
			.click_add_appointment_tab()
			.verify_add_appointment_text()
			.click_actions_drop_down()
			.wait_until(5);
		get(NBDVendorsPage .class)	
			.click_manage_vendor_permissions()
			.wait_until(5)
			.verify_manage_vendor_permission_text();
		get(NBDHomePage.class)	
			.click_actions_drop_down()
			.wait_until(5);
		get(NBDRepsPage.class)
			.click_manage_rep_permissions_tab()
			.wait_until(5)
			.verify_manage_rep_permission_text()
			.enter_first_name_in_manage_rep_permission(repFirstName)
			.wait_until(5);
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
			.wait_until(5)
			.verify_appointment_requester_header(manageApptReqText)
			.wait_until(2)
			.refresh_page();
	}
	
	@Test(priority=10, groups={"functional"})
	public void NBDSearchForVendorsAndRep(){
		get(NBDHomePage.class)
			.wait_until(2)
			.click_search_for_vendors_and_rep()
			.enter_vendor_name(legalName);
		get(SSOCommonUtilities.class)
			.pressEnter()
			.wait_for_text_appear("Search");
		
		get(NBDHomePage.class)
			.enter_rep_first_name(repFirstName)
			.wait_until(2);
		get(SSOCommonUtilities.class)
			.pressEnter()
			.wait_until(2);
		get(NBDHomePage.class)
			.verify_rep_search_results()
			.click_home_tab()
			.wait_until(2);
		get(SSOCommonUtilities.class)	
			.select_option_from_userName_dropdown("Logout");
	}

}