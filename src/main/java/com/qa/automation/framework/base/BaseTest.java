package com.qa.automation.framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.reports.ExtentManager;
import com.qa.automation.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    public WebDriver driver;
    protected ConfigReader configReader;
    protected ExtentReports extent;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        System.out.println(">>> DRIVER INIT START");

        configReader = ConfigReader.getInstance();

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();

        System.out.println("Driver = " + driver);

        DriverFactory.setDriver(driver);

        DriverFactory.getDriver()
                .manage()
                .window()
                .maximize();

        DriverFactory.getDriver()
                .get(configReader.getBaseUrl());

        System.out.println(">>> DRIVER INIT END");
    }

@AfterMethod(alwaysRun = true)
public void tearDown(ITestResult result) {

        extent = ExtentManager.getExtentReports();

        if (result.getStatus() == ITestResult.SUCCESS) {
            extent.createTest(result.getName()).pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extent.createTest(result.getName()).fail(result.getThrowable());
        }

    if (DriverFactory.getDriver() != null) {

        DriverFactory.getDriver().quit();

        DriverFactory.unload();
    }

        extent.flush();
    }
}