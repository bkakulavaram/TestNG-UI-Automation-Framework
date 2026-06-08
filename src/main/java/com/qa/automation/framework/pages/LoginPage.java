package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By emailField=By.id("Email");
    By passwordField=By.id("Password");
    By loginButton=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
    By errorMsg;
    By logout=By.linkText("Log out");



    public void login(String email, String password){
        type(emailField,email);
        type(passwordField,password);
        click(loginButton);
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(logout);
    }

    public boolean isLoginErrorDisplayed() {

        return isDisplayed(errorMsg);
    }

}
