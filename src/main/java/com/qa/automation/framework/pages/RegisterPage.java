package com.qa.automation.framework.pages;

import com.qa.automation.framework.base.BasePage;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By maleRadio = By.id("gender-male");
    private final By femaleRadio = By.id("gender-female");

    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");

    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");

    private final By registerButton =
            By.id("register-button");

    private final By registrationSuccessMessage =
            By.className("result");

    public RegisterPage registerUser(
            String gender,
            String firstNameValue,
            String lastNameValue,
            String emailValue,
            String passwordValue) {

        selectGender(gender);

        type(firstName, firstNameValue);
        type(lastName, lastNameValue);
        type(email, emailValue);
        type(password, passwordValue);
        type(confirmPassword, passwordValue);

        click(registerButton);

        return this;
    }

    private void selectGender(String gender) {

        if ("male".equalsIgnoreCase(gender)) {
            click(maleRadio);
        } else {
            click(femaleRadio);
        }
    }

    public boolean isRegistrationSuccessful() {
        return isDisplayed(registrationSuccessMessage);
    }

    public String getRegistrationMessage() {
        return getText(registrationSuccessMessage);
    }
}