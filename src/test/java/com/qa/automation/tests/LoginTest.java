package com.qa.automation.tests;

import com.qa.automation.framework.dataProviders.LoginDataProvider;
import com.qa.automation.framework.base.BaseTest;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.pages.HomePage;
import com.qa.automation.framework.pages.LoginPage;
import com.qa.automation.framework.utils.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"smoke","regression"})

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String email, String password, String expected) {
        boolean expectedResult = Boolean.parseBoolean(String.valueOf(expected));
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(email, password);
        boolean actual = loginPage.isLoginSuccessful();
        Assert.assertEquals(actual, expectedResult);
        Assert.fail("Force failure to test screenshot");
        }
    }

