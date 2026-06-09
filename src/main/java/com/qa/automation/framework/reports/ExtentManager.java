package com.qa.automation.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static volatile ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            synchronized (ExtentManager.class) {

                if (extent == null) {

                    String path = System.getProperty(
                            "extent.report.path",
                            "test-output/report.html"
                    );

                    File file = new File(path);
                    file.getParentFile().mkdirs();

                    ExtentSparkReporter spark =
                            new ExtentSparkReporter(path);

                    extent = new ExtentReports();
                    extent.attachReporter(spark);

                    extent.setSystemInfo("Project", "UI-POM-FRAMEWORK");
                    extent.setSystemInfo("Environment",
                            System.getProperty("env", "QA"));
                }
            }
        }

        return extent;
    }
}