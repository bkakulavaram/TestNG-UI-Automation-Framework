package com.qa.automation.tests;

import com.qa.automation.framework.base.BaseTest;
import com.qa.automation.framework.context.TestContext;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.pages.HomePage;
import com.qa.automation.framework.pages.LoginPage;
import com.qa.automation.framework.pages.RegisterPage;
import com.qa.automation.framework.utils.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class E2ETest extends BaseTest {



    @Test(groups = {"e2e","regression"})
    public void registerLoginFlow() {

        HomePage homePage = new HomePage();

        RegisterPage registerPage = homePage.clickRegister();

        String email = "user_" + System.currentTimeMillis() + "@test.com";
        String password = "Test@123";
        TestContext.setEmail(email);
        TestContext.setPassword(password);

        registerPage.registerUser(
                "Male",
                "John",
                "Doe",
                email,
                password
        );
         email = TestContext.getEmail();
         password = TestContext.getPassword();

         driver.findElement(By.linkText("Log out")).click();


        homePage = new HomePage(); // refresh page state

        LoginPage loginPage = homePage.clickLogin();

        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
    }
}