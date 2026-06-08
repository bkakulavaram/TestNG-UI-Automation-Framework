package com.qa.automation.framework.Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.qa.automation.framework.drivers.DriverFactory.getDriver;

public class AllureListener implements ITestListener {

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshot() {

        if (getDriver() == null) {
            System.out.println("Driver is null → screenshot skipped");
            return new byte[0];
        }

        return ((TakesScreenshot) getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Capturing screenshot for: " + result.getName());
        attachScreenshot();
    }
}