package com.qa.automation.framework.Listeners;

import com.aventstack.extentreports.*;
import com.qa.automation.framework.drivers.DriverManager;
import com.qa.automation.framework.reports.ExtentManager;
import com.qa.automation.framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentManager.getExtentReports()
                .createTest(result.getName());

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = extentTest.get();

        WebDriver driver = DriverManager.getDriver();

        test.log(Status.FAIL, result.getThrowable());

        if (driver != null) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                test.log(Status.WARNING, "Screenshot attach failed");
            }
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }
}