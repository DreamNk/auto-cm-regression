package com.ghx.auto.cm.regression.ui.smoke.angularjs;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.angularjs.page.AjsCommonUtilities;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDLoginPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDRepDetailsPage;
import com.ghx.auto.cm.ui.angularjs.page.AjsNBDRepsPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;



public class NBD_Reps_Test extends AbstractAutoUITest {

	String first_name = "Auto-v-Five";
	String last_name = "Three";
	String company_name = "Auto AJS V1";
	String username = "auto_buyer4@mhc.vdm";
	String password = "gltd123";
	
	
	@Test(priority=1, groups = {"functional"})	                                     
	public void VerifyFirstNameFilterInRepsTab(){
		get(AjsNBDLoginPage.class)
		.invoke_url()
		.wait_for_login_page_to_load()
		.enter_username(username)
		.enter_password(password)
		.click_login_button()
		.wait_until(4)
		.click_continue_button()
		.wait_for_post_login_page_to_load();
		
		get(AjsNBDRepsPage.class)
		   .click_reps_tab()
		   .enter_first_name(first_name);
		get(AjsCommonUtilities.class)
		   .pressEnter()
		   .wait_until(5);
		get(AjsNBDRepsPage.class)
		   .verify_first_name_1st_record(first_name);
	}
	
	@Test(priority=2, groups = {"functional"})	                                     
	public void VerifyLastNameFilterInRepsTab(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(3)
		   .enter_last_name(last_name);
		get(AjsCommonUtilities.class)
		   .pressEnter()
		   .wait_until(5);
		get(AjsNBDRepsPage.class)
		   .verify_last_name_1st_record(last_name);
	}
	
	@Test(priority=3, groups = {"functional"})	                                     
	public void VerifyCompanyFilterInRepsTab(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(3)
		   .enter_company(company_name);
		get(AjsCommonUtilities.class)
		   .pressEnter()
		   .wait_until(5);
		get(AjsNBDRepsPage.class)
		   .verify_company_name_1st_record(company_name);
	}
	
	@Test(priority=4, groups = {"functional"})	                                     
	public void VerifyPassDocumentFilter(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(5)
		   .select_document_status("PASS")
		   .wait_until(5)
		   .verify_document_1st_record("PASS");
	}
	
	@Test(priority=5, groups = {"functional"})	                                     
	public void VerifyFailDocumentFilter(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(3)
		   .select_document_status("FAIL")
		   .wait_until(5)
		   .verify_document_1st_record("FAIL");
	}
	
	@Test(priority=6, groups = {"functional"})	                                     
	public void VerifyNADocumentFilter(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(3)
		   .select_document_status("N/A")
		   .wait_until(5)
		   .verify_document_1st_record("NA");
	}
	
	@Test(priority=7, groups = {"functional"})	                                     
	public void VerifyAddAppointmentOption(){
		get(AjsNBDRepsPage.class)
		   .click_clear_button()
		   .wait_until(3)
		   .verify_add_appointment_in_select_dropdown();
	}
	
	/*@Test(priority=7, groups = {"functional"})	                                     
	public void VerifyHelpText(){
		get(AjsNBDRepsPage.class)
		   .click_help_link()
		   .verify_help_text("Help");
		get(AjsCommonUtilities.class)
		   .click_close_popup();
	}*/
	
	@Test(priority=8, groups = {"functional"})	                                     
	public void VerifyFirstNameLinkNavigatesToRepDetailsTab(){
		get(AjsNBDRepsPage.class)
		   .enter_first_name("Auto-v-one");
		get(AjsCommonUtilities.class)
		   .pressEnter()
		   .wait_until(5);
		get(AjsNBDRepsPage.class)
		   .click_first_name_1st_record();
		get(AjsNBDRepDetailsPage.class)
		   .wait_until(7)
		   .switch_to_iframe()
		   .wait_until(2)
		   .verify_rep_details("Auto-v-one Test");
	}
	
	@Test(priority=9, groups = {"functional"})	                                     
	public void VerifyInfoTab(){
		get(AjsNBDRepDetailsPage.class)
		   .wait_until(4)
		   .verify_sanction_list_title("Sanction Lists")
		   .verify_individual_title("Individual")
		   .verify_conflict_of_interest_title("Conflict of Interest")
		   .verify_sales_territory_title("Sales Territory")
		   .verify_supervisor_title("Supervisor")
		   .verify_reports_title("Reports")
		   .verify_info_notes_title("Notes");
	}
	
	@Test(priority=10, groups = {"functional"})	                                     
	public void verifyDocumentsTabofRepDetails(){
		get(AjsNBDRepDetailsPage.class)
		   .wait_until(15)
		   .click_documents_tab()
		   .wait_until(5)
		   .verify_ack_doc_title("Acknowledgments Required for Auto-v-one Test and Auto AJS V1")
		   .verify_required_doc_title("Documents Required for Auto-v-one Test and Auto AJS V1")
		   .verify_optional_doc_title("Optional documents supplied for Auto-v-one Test and Auto AJS V1");
	}
	
	@Test(priority=11, groups = {"functional"})	                                     
	public void verifyScoreCardTabofRepDetails(){
		get(AjsNBDRepDetailsPage.class)
		   .wait_until(5)
		   .click_score_card_tab()
		   .wait_until(5)
		   .verify_vendor_rep_score_card("Vendor Rep Score Card")
		   .verify_score_card_notes("Notes");
	}
	
	@Test(priority=12, groups = {"functional"})	                                     
	public void verifyProductTabofRepDetails(){
		get(AjsNBDRepDetailsPage.class)
		   .click_products_tab()
		   .wait_until(5)
		   .verify_code_no("42132205")
		   .switch_to_root_page()
		   .click_back_to_list();
	}
		  
	
		
		
	
}
