package com.qa.automation.tests;

import com.qa.automation.framework.dataProviders.RegisterDataProvider;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.pages.HomePage;
import com.qa.automation.framework.pages.RegisterPage;
import com.qa.automation.framework.base.BaseTest;
import org.testng.Assert;
import com.qa.automation.framework.utils.RetryAnalyzer;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class,groups = { "smoke","regression"})

public class RegisterTest extends BaseTest {




    @Test(dataProvider = "registerData", dataProviderClass = RegisterDataProvider.class)
    public void registerTest(String gender, String firstName, String lastName) {

        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.clickRegister();

        String email = "user_" + System.currentTimeMillis() + "@test.com";
        String password = "Test@123";

        registerPage.registerUser(
                gender,
                firstName,
                lastName,
                email,
                password
        );
        Assert.assertEquals(
                registerPage.getRegistrationMessage(),
                "Your registration completed"
        );
    }
}