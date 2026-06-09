package com.qa.automation.framework.drivers;

import com.qa.automation.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverService {

    public static void initDriver() {

        String browser = System.getProperty(
                "browser",
                ConfigReader.getInstance().getBrowser()
        );

        WebDriver driver = DriverFactory.createDriver(browser);

        driver.manage().window().maximize();

        DriverManager.setDriver(driver);
    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public static void quitDriver() {
        DriverManager.quitDriver();
    }
}