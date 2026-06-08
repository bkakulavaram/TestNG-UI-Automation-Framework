package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import com.qa.automation.framework.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By loginPage= By.linkText("Log in");
    By registerPage= By.linkText("Register");
    By logoutLink = By.linkText("Log out");


    public LoginPage clickLogin(){
        click(loginPage);
        return new LoginPage();
    }

    public RegisterPage clickRegister(){
        click(registerPage);
        return new RegisterPage();
    }
    public boolean isUserLoggedIn() {
        return driver.findElement(logoutLink).isDisplayed();
    }
    public void logout() {
        click(logoutLink);
    }

}
