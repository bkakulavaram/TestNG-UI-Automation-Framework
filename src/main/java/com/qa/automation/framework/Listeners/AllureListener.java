package com.qa.automation.framework.Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.qa.automation.framework.drivers.DriverFactory.getDriver;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Listener triggered for failure: " + result.getName());
        saveScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot() {

        try {
            WebDriver driver = getDriver();

            if (driver == null) {
                System.out.println("❌ Driver is NULL in listener");
                return new byte[0];
            }

            if (!(driver instanceof TakesScreenshot)) {
                System.out.println("❌ Driver does not support screenshots");
                return new byte[0];
            }

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            System.out.println("✅ Screenshot captured: " + screenshot.length + " bytes");

            return screenshot;

        } catch (Exception e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
            return new byte[0];
        }
    }
}