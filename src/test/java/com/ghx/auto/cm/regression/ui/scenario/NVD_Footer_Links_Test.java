package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.CommonUtilities;
import com.ghx.auto.cm.ui.page.FaxCoverSheetPage;
import com.ghx.auto.cm.ui.page.NVDFooterLinksPage;
import com.ghx.auto.cm.ui.page.NVDRootPage;
import com.ghx.auto.cm.ui.page.NVDloginPage;
import com.ghx.auto.cm.ui.page.PrivacyPolicyPage;
import com.ghx.auto.cm.ui.page.SupportCenterPage;
import com.ghx.auto.cm.ui.page.TermsOfUsePage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;

public class NVD_Footer_Links_Test extends AbstractAutoUITest{
	
	@Test(priority=1, groups = {"functional"})                                         
	public void verifyPreLoginSupportCenterFooterLink(){
		get(NVDloginPage.class)
			.invokeLoginUrl("baseUrl");                                                 
		get(NVDFooterLinksPage.class)
		    .click_header_support_center_link()
	     	.wait_until(3);
		get(SupportCenterPage.class, focus_on_popup_window())
		    .wait_until(3)
		    .verify_text_on_support_center_page("healthcare provider support");
		    focus_on_popup_window().close();
		
		    }
	
	@Test(priority=2, groups = {"functional"})                                         
	public void verifyPreLoginFaxCoverSheetFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_fax_cover_sheet_link();
		get(FaxCoverSheetPage.class, focus_on_popup_window())
		    .wait_until(4)
		    .verifyFaxCoverSheetTitle();
		    focus_on_popup_window().close();
	}
	
	@Test(priority=3, groups = {"functional"})                                         
	public void verifyPreLoginPrivacyPolicyFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_privacy_policy_link();
		get(PrivacyPolicyPage.class, focus_on_popup_window())
		    .verify_text_on_privacy_policies_page("Your choices for business information");
		    focus_on_popup_window().close();
		    }
	
	
	@Test(priority=4, groups = {"functional"})                                         
	public void verifyPreLoginTermsOfUserFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_terms_of_use_link();
		get(TermsOfUsePage.class, focus_on_popup_window())
		    .verify_text_on_terms_of_use_page("1. ACCEPTANCE OF TERMS");
		    focus_on_popup_window().close();
	}
	
	@Test(priority=5, groups = {"functional"})                                         
	public void verifyPostLoginSupportCenterFooterLink(){ 
		get(NVDFooterLinksPage.class, focus_on_parent_window());
		get(NVDloginPage.class)                                                 
			.enter_username("anaida.gillbert@av1.vm")
			.enter_password("gltd123")
			.click_login_button()
		    .click_continue_button()
		    .wait_until(3);
		get(NVDFooterLinksPage.class)
	     	.click_footer_support_center_link()
     	    .wait_until(3);
	    get(SupportCenterPage.class, focus_on_popup_window())
	        .wait_until(3)
	        .verify_text_on_support_center_page("healthcare provider support");
	        focus_on_popup_window().close();
	
	    }
		
	@Test(priority=6, groups = {"functional"})                                         
	public void verifyPostLoginFaxCoverSheetFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_fax_cover_sheet_link();
		get(FaxCoverSheetPage.class, focus_on_popup_window())
		    .wait_until(4)
		    .verifyFaxCoverSheetTitle();
		    focus_on_popup_window().close();
	}
	
	@Test(priority=7, groups = {"functional"})                                         
	public void verifyPostLoginPrivacyPolicyFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_privacy_policy_link();
		get(PrivacyPolicyPage.class, focus_on_popup_window())
		    .verify_text_on_privacy_policies_page("Your choices for business information");
		    focus_on_popup_window().close();
	}
	
	
	@Test(priority=8, groups = {"functional"})                                         
	public void verifyPostLoginTermsOfUserFooterLink(){                                               
		get(NVDFooterLinksPage.class, focus_on_parent_window())
		    .click_terms_of_use_link();
		get(TermsOfUsePage.class, focus_on_popup_window())
		    .verify_text_on_terms_of_use_page("1. ACCEPTANCE OF TERMS");
		    focus_on_popup_window().close();
		    
	    get(NVDFooterLinksPage.class, focus_on_parent_window());
	    
	    get(CommonUtilities.class)
	       .click_log_out_from_NVD();
	}   
}
