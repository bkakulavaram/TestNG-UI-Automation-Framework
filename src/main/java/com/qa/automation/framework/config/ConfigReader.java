package com.qa.automation.framework.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static volatile ConfigReader instance;
    private final Properties properties = new Properties();

    private ConfigReader() {

        String env = System.getProperty("env", "qa");

        String fileName = env + ".properties";

        try (InputStream fis =
                     getClass().getClassLoader().getResourceAsStream(fileName)) {

            if (fis == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            properties.load(fis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static ConfigReader getInstance() {

        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }

        return instance;
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getGridUrl() {
        return properties.getProperty("gridUrl", "http://localhost:4444/wd/hub");
    }
}