package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.cssSelector("input[value='Log in']");
    private final By errorMessage =
            By.cssSelector(".validation-summary-errors");
    private final By logoutLink = By.linkText("Log out");

    public LoginPage login(String email, String password) {

        type(emailField, email);
        type(passwordField, password);
        click(loginButton);

        return this;
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(logoutLink);
    }

    public boolean isLoginErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}