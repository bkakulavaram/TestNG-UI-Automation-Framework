package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {



    private By maleRadio = By.id("gender-male");
    private By femaleRadio = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");
    private By registrationSuccessMessage =
            By.className("result");

    public void selectGender(String gender) {

        if (gender.equalsIgnoreCase("Male")) {
            click(maleRadio);
        } else {
            click(femaleRadio);
        }
    }

    public void registerUser(String gender, String fName, String lName, String userEmail, String pwd) {

        selectGender(gender);
        type(firstName, fName);
        type(lastName, lName);
        type(email, userEmail);
        type(password, pwd);
        type(confirmPassword, pwd);
        click(registerBtn);

    }

    public String getRegistrationMessage() {
        return driver.findElement(registrationSuccessMessage)
                .getText();
    }

}