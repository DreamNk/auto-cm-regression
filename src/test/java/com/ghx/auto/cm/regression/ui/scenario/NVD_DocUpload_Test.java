package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.NVDAccountsPage;
import com.ghx.auto.cm.ui.page.NVDHomePage;
import com.ghx.auto.cm.ui.page.NVDMyDocumentPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

import java.awt.AWTException;
public class NVD_DocUpload_Test extends AbstractAutoUITest{

		
	@Test(priority = 1, groups = { "functional" })
	public void verifyUploadDocumentFromHomeTab() {

		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl")
				.enter_username("autorep1@av3.vm")
				.enter_password("gltd123")
				.click_login_button()
				.click_continue_button()
				.wait_until(2);
		
		get(NVDAccountsPage.class).click_accounts_tab1()
				.verify_requirement_status_of_1st_record("FAIL");

		get(NVDHomePage.class).click_home_tab()
				.click_common_document_alert_link()
				.click_1st_radio_button_of_common_document_popup()
				.wait_until(5)
				.click_upload_button()
				.wait_until(5)
				.browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")

				.click_effetive_date_button()
				.select_effective_date("2023", "3")
				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button()
				.close_popup().wait_until(3)
				.close_popup();

		get(NVDMyDocumentPage.class).click_my_document_tab()
				.verify_green_tick_on_doc2_of_common_doc();

	}

	
	@Test(priority = 2, groups = { "functional" })
	public void verifyUploadDocumentFromCommonDocsOfMyDocumentsTab() {

		get(NVDMyDocumentPage.class)
				.click_upload_link_in_common_documents_subtab()
				.wait_until(5);

		get(NVDHomePage.class)
		        .click_upload_button()
                .wait_until(5)
                .browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")
                .click_effetive_date_button().select_effective_date("2023", "3")
				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button();

		get(NVDMyDocumentPage.class).wait_until(8)
				.verify_green_tick_on_doc1_of_common_doc();
	}

	
	@Test(priority = 3, groups = { "functional" })
	public void verifyUploadDocumentFromAccountSpecificDocofMyDocumentTab() {

		get(NVDMyDocumentPage.class).wait_until(3)
				.click_account_specific_document_tab()
				.click_upload_link_in_account_specific_doc_subtab();

		get(NVDHomePage.class)
		        .wait_until(4)
		        .click_upload_button()
                .browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")
                .click_effetive_date_button().select_effective_date("2023", "3")
				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button();

		get(NVDMyDocumentPage.class).wait_until(8)
				.verify_green_tick_on_doc2_of_account_specific_doc();

		get(NVDMyDocumentPage.class)
				.click_upload_link_in_account_specific_doc_subtab()
				.click_continue_button_on_caution_popup();

		get(NVDHomePage.class)
		        .wait_until(4)
		        .click_upload_button()
				.browse_file("D:\\AutomationFiles\\cm\\Anamika.docx")
				.click_effetive_date_button()
				.select_effective_date("2023", "3")
				.click_expiration_date_button()
				.select_expiration_date("2024", "3")
				.click_save_button();

		get(NVDMyDocumentPage.class)
		        .wait_until(8)
				.verify_green_tick_on_doc1_of_account_specific_doc();
	}
	
	
	@Test(priority = 4, groups = { "functional" })
	public void verifyPassAlert(){

		get(NVDAccountsPage.class)
			.click_accounts_tab()
			.wait_until(2)
			.verify_requirement_status_of_1st_record("PASS");
	}

	
	@Test(priority=5, groups = {"functional"})                                
	public void verifyFailAlert(){
		
		get(NVDAccountsPage.class)
		  .click_requirement_status_of_1st_record()
		  .wait_until(15)
		  .switch_to_docs_and_policies_iframe()
		  .select_delete_option_for_1st_document()
		  .click_confirm_delete_button()
		  .switch_to_root_page()
		  .click_back_to_list()
		  .click_refresh_manage_accounts_icon()
		  .wait_until(4)
		  .click_refresh_requirement_status_1st_icon()
		  .verify_requirement_status_of_1st_record("FAIL");
	}

	
	@Test(priority=6, groups = {"functional"})                                
	public void verifyDeleteActionFromCommonDocOfMyDocumentsTab(){
		
		get(NVDMyDocumentPage.class)
		  .click_my_document_tab()
		  .click_delete_link_of_doc1_in_common_doc()
		  .click_delete_button_in_popup_common_docs()
		  .wait_until(7)
		  .verify_cross_mark_on_doc2_of_common_doc();
	}
	
	
	@Test(priority=7, groups = {"functional"})                                
	public void verifyDeleteActionFromAccountSpecificDocOfMyDocumentsTab(){
		
		get(NVDMyDocumentPage.class)
		   .click_account_specific_document_tab()
		   .click_delete_link_of_doc1_in_account_specific_doc()
		   .click_delete_button_in_popup_common_docs()
		   .wait_until(7)
		   .verify_cross_mark_on_doc1_of_account_specific_doc()
		   .click_delete_link_of_doc2_in_account_specific_doc()
		   .click_delete_button_in_popup_common_docs()
		   .wait_until(7)
		   .verify_cross_mark_on_doc2_of_account_specific_doc();
		
		get(CommonUtilities.class)
		   .click_log_out_from_NVD();
	}
	
	
	
}


	
	
	

