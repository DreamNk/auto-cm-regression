/*
 * Copyright (c) 2015 Global Healthcare Exchange, LLC. All rights reserved.
 */

package com.ghx.auto.cm.regression.ui.scenario;

import org.testng.annotations.Test;

import com.ghx.auto.cm.ui.page.LoginPage;
import com.ghx.auto.core.ui.test.AbstractAutoUITest;



public class Login_Test extends AbstractAutoUITest {

    @Test(groups = {"functional"})
    public void successfulLogin() {
    	 get(LoginPage.class)
			.doLogin();
    }

}
