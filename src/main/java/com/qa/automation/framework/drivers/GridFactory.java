package com.qa.automation.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URL;

public class GridFactory {

    public static WebDriver createGridDriver(String browser, String gridUrl) {

        try {

            switch (browser.toLowerCase()) {

                case "chrome":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new ChromeOptions()
                    );

                case "firefox":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new FirefoxOptions()
                    );

                case "edge":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new EdgeOptions()
                    );

                default:
                    throw new RuntimeException("Invalid browser");
            }

        } catch (Exception e) {
            throw new RuntimeException("Grid init failed: " + e.getMessage());
        }
    }
}