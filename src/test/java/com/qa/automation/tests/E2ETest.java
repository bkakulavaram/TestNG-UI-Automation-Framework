package com.qa.automation.tests;

import com.qa.automation.framework.base.BaseTest;
import com.qa.automation.framework.pages.HomePage;
import com.qa.automation.framework.pages.LoginPage;
import com.qa.automation.framework.pages.RegisterPage;
import com.qa.automation.framework.utils.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class E2ETest extends BaseTest {

    @Test(groups = {"e2e", "regression"})
    public void registerLoginFlow() {

        String email =
                "user_" + System.currentTimeMillis()
                        + "@test.com";

        String password = "Test@123";

        HomePage homePage = new HomePage();

        RegisterPage registerPage =
                homePage.clickRegister();

        registerPage.registerUser(
                "Male",
                "John",
                "Doe",
                email,
                password
        );

        Assert.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Registration failed"
        );

        homePage.logout();

        LoginPage loginPage =
                homePage.clickLogin();

        loginPage.login(email, password);

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed after registration"
        );
    }
}