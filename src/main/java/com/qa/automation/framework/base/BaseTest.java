package com.qa.automation.framework.base;

import com.qa.automation.framework.config.ConfigReader;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.reports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    protected ConfigReader configReader;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        System.out.println(">>> DRIVER INIT START");

        configReader = ConfigReader.getInstance();

        DriverFactory factory = new DriverFactory();
        driver = factory.initDriver();

        DriverFactory.setDriver(driver);

        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(configReader.getBaseUrl());

        System.out.println(">>> DRIVER INIT END");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.unload();
        }
    }
}