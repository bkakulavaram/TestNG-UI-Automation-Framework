package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By loginLink = By.linkText("Log in");
    private final By registerLink = By.linkText("Register");
    private final By logoutLink = By.linkText("Log out");

    public LoginPage clickLogin() {
        click(loginLink);
        return new LoginPage();
    }

    public RegisterPage clickRegister() {
        click(registerLink);
        return new RegisterPage();
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(logoutLink);
    }

    public void logout() {
        click(logoutLink);
    }
}