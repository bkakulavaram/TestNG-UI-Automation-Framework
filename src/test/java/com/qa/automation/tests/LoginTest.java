package com.qa.automation.tests;

import com.qa.automation.framework.base.BaseTest;
import com.qa.automation.framework.dataProviders.LoginDataProvider;
import com.qa.automation.framework.pages.HomePage;
import com.qa.automation.framework.pages.LoginPage;
import com.qa.automation.framework.utils.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(
        retryAnalyzer = RetryAnalyzer.class,
        groups = {"smoke", "regression"}
)
public class LoginTest extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = LoginDataProvider.class
    )
    public void loginTest(
            String email,
            String password,
            String expected) {

        boolean expectedResult =
                Boolean.parseBoolean(expected);

        LoginPage loginPage =
                new HomePage().clickLogin();

        boolean actualResult =
                loginPage.login(email, password)
                        .isLoginSuccessful();

        System.out.println("Login Success: " + actualResult);


        System.out.println(
                "User: " + email +
                        " Expected: " + expectedResult +
                        " Actual: " + actualResult
        );

        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Login validation failed for user: " + email
        );
    }
}