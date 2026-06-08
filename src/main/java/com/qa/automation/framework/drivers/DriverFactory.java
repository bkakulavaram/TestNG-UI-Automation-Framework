package com.qa.automation.framework.drivers;

import com.qa.automation.framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void unload() {
        driver.remove();
    }

    public WebDriver initDriver() {
        String browser = System.getProperty("browser",
                ConfigReader.getInstance().getBrowser());

        browser = browser.toLowerCase().trim();

        System.out.println("Browser selected: " + browser);

        // 🔥 PRIORITY FIX: system property > config file
//        String browser = System.getProperty("browser",
//                ConfigReader.getInstance().getBrowser());

        WebDriver driverInstance;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverInstance = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverInstance = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driverInstance = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Invalid Browser: " + browser);
        }

        driverInstance.manage().window().maximize();
        return driverInstance;
    }
}