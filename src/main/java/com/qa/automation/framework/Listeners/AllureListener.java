package com.qa.automation.framework.Listeners;

import com.qa.automation.framework.drivers.DriverService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot() {

        return ((TakesScreenshot) DriverService.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}