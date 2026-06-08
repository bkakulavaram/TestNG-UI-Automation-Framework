package com.qa.automation.framework.base;

import com.qa.automation.framework.config.ConfigReader;
import com.qa.automation.framework.drivers.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        configReader = ConfigReader.getInstance();

        DriverFactory factory = new DriverFactory();
        driver = factory.initDriver();

        DriverFactory.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(configReader.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            attachScreenshot();
        }

        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.unload();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshot() {

        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) {
            System.out.println("Driver NULL → screenshot skipped");
            return new byte[0];
        }

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}