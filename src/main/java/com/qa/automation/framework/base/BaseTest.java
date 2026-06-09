package com.qa.automation.framework.base;

import com.qa.automation.framework.config.ConfigReader;
import com.qa.automation.framework.drivers.DriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ConfigReader configReader;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        configReader = ConfigReader.getInstance();

        DriverService.initDriver();

        DriverService.getDriver()
                .get(configReader.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverService.quitDriver();
    }
}