package com.qa.automation.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            throw new RuntimeException("WebDriver is null. Cannot capture screenshot.");
        }

        try {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String dir = System.getProperty(
                    "screenshot.path",
                    "test-output/screenshots/"
            );

            Path screenshotDir = Paths.get(dir);
            Files.createDirectories(screenshotDir);

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String path = dir + testName + "_" + timestamp + ".png";

            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}