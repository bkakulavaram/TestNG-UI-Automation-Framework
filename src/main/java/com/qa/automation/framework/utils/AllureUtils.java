package com.qa.automation.framework.utils;

import com.qa.automation.framework.drivers.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureUtils {

    public static void attachScreenshot() {

        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            System.out.println("Driver is null → screenshot skipped");
            return;
        }

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Failure Screenshot",
                new ByteArrayInputStream(screenshot)
        );
    }
}