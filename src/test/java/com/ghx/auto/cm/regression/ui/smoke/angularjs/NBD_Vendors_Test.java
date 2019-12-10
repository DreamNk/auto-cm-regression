package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;
import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDVendorsPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NBD_Vendors_Test extends AbstractAutoUITest {
	String Password  = "test1235!";
	String Username = "auto_buyer1@srmc.vdm";
	String company_name = "Will Hospital";
	String info_tax_id_text = "vendor132";
	String docs_acknowledgements_req_for_text = "Acknowledgments Required for Will Hospital";
	String scorecard_text = "Notes entered here";
	String principal_name_text = "Contact Officer  / Compliance Officer";
	String contacts_principal_name_text = "Principal Test";
	String rep_name_text = "Das, Kaustabh";
	String gs1_key_name_text = "GS1 key";
	
	
	@Test(priority=1, groups = {"functional"})                                   //verify vendor details page
	public void verifyVendorDetailsPage() {
		
		get(AjsNBDLoginPage.class)
			.invoke_url() 
			.enter_username(Username)
			.enter_password(Password)
			.click_login_button()
			.wait_until(5)
			.click_continue_button()
			.wait_until(5)
			.wait_for_post_login_page_to_load();
			
		get(AjsNBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field(company_name)
			.wait_until(5)
			.press_enter()
			.click_legal_name_link()
			.wait_until(5)
			.verify_vendor_details_header_text(company_name)
			.switch_to_root_page();

	}
				
	@Test(priority=2, groups = {"functional"})                                   //Back to list
	public void verifyBackToList() {
				
		get(AjsNBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field(company_name)
			.press_enter()
			.click_legal_name_link()
			.wait_until(5)
			.click_back_to_list_link()
			.verify_vendors_registered_header_text("Vendors");

	}
	
	@Test(priority=3, groups = {"functional"})                                   //clear button
	public void verifyClearButtonFunctionality() {

		get(AjsNBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field(company_name)
			.press_enter()
			.click_clear_link();

	}
	
	@Test(priority=4, groups = {"functional"})                                   //doing business as
	public void verifyDoingBusinessAs() {

		get(AjsNBDVendorsPage.class)
			.click_vendors_tab()
			.enter_doing_business_as_in_filter_field("hospitality of makon")
			.press_enter()
			.click_doing_business_as_name_link()
			.wait_until(5)
			.verify_dba_on_vendor_details_page("hospitality of makon");
	}

		/*@Test(priority=16, groups = {"functional"})                                   //verify fail on vendors page	
			public void verifyFailOptionFromDocumentsDropDown() {

				get(AjsNBDVendorsPage.class)
					.click_vendors_tab()
					.click_fail_option_from_documents_dropdown()
					.verify_fail_text_in_documents_column("FAIL");
			}*/

		/*@Test(priority=17, groups = {"functional"})                                   //verify pass on vendors page	
			public void verifyPassOptionFromDocumentsDropDown() {

				get(AjsNBDVendorsPage.class)
					.click_pass_option_from_documents_dropdown()
					.verify_pass_text_in_documents_column("PASS");
			}*/

	@Test(priority=5, groups = {"functional"})                                   //verify na on vendors page	
	public void verifyNAOptionFromDocumentsDropDown() {

		get(AjsNBDVendorsPage.class)
			.click_na_option_from_documents_dropdown()
			.verify_na_text_in_documents_column("N/A");
	}

		/*@Test(priority=19, groups = {"functional"})                                   //verify alert on vendors page	
			public void verifyAlertOptionFromDocumentsDropDown() {

				get(AjsNBDVendorsPage.class)
					.click_alert_option_from_documents_dropdown()
					.verify_alert_text_in_documents_column("ALERT");
			}*/

		/*@Test(priority=20, groups = {"functional"})                                   //verify add appointment on vendors page	
			public void verifyAddAppointmentOptionFromDocumentsDropDown() {

				get(AjsNBDVendorsPage.class)
					.click_vendors_tab()
					.click_add_appointment_option_from_action_dropdown()
					.verify_add_appointment_accordian_text("Add Appointment");
			}*/

	@Test(priority=6, groups = {"functional"})                                   //Info tab
	public void verifyInfoTab() {

		get(AjsNBDVendorsPage.class)
			.click_vendors_tab()
			.enter_company_name_in_filter_field(company_name)
			.press_enter()
			.click_legal_name_link()
			.switch_to_vendors_details_iframe_()
			.verify_info_tax_id_text(info_tax_id_text);
	}

	@Test(priority=7, groups = {"functional"})                                   //documents tab
	public void verifyDocumentsTab() {

		get(AjsNBDVendorsPage.class)
			.click_documents_tab()
			.verify_docs_acknowledgements_req_for_text(docs_acknowledgements_req_for_text);
	}

	@Test(priority=8, groups = {"functional"})                                   //score card tab
	public void verifyScoreCardsTab() {

		get(AjsNBDVendorsPage.class)
			.click_scorecard_tab()
			.verify_scorecard_text(scorecard_text);
	}

	@Test(priority=9, groups = {"functional"})                                   //principals tab
	public void verifyPrincipalsTab() {

		get(AjsNBDVendorsPage.class)
			.click_principals_tab()
			.verify_principal_name_text(principal_name_text);
	}

	@Test(priority=10, groups = {"functional"})                                   //contacts tab
	public void verifyContactsTab() {

		get(AjsNBDVendorsPage.class)
			.click_contacts_tab()
			.verify_contacts_principal_name_text(contacts_principal_name_text);
	}
		
	@Test(priority=11, groups = {"functional"})                                   //reps tab
	public void verifyRepsTab() {

		get(AjsNBDVendorsPage.class)
			.click_reps_tab()
			.verify_rep_name_text(rep_name_text)
			.wait_until(5);

	}
	
	@Test(priority=12, groups = {"functional"})                                   //GS1 keys tab
	public void verifyGS1KeysTab() {

		get(AjsNBDVendorsPage.class)
			.click_gs1_keys_tab()
			.verify_gs1_key_name_text(gs1_key_name_text)
			.switch_to_root_page();


		get(AjsCommonUtilities.class)
			.do_log_out_from_NBD();
	}
}

