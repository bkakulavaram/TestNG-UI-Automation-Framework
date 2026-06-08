package com.qa.automation.framework.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.framework.drivers.DriverFactory;
import com.qa.automation.framework.reports.ExtentManager;
import com.qa.automation.framework.base.BaseTest;
import org.openqa.selenium.WebDriver;
import com.qa.automation.framework.utils.ScreenshotUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getExtentReports()
                .createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();
        WebDriver driver =
                DriverFactory.getDriver();
        if (driver != null) {
            String screenshotPath =
                    ScreenshotUtil.takeScreenshot(driver, result.getName());

            test.log(Status.FAIL, result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
        } else {
            test.log(Status.FAIL, "Driver was null — screenshot skipped");
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }
}