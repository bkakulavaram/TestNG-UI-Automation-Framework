package com.qa.automation.framework.dataProviders;

import com.qa.automation.framework.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.File;

public class RegisterDataProvider {

    @DataProvider(name = "registerData", parallel = true)
    public Object[][] registerData() {

        String path = System.getProperty(
                "registerDataPath",
                "src/test/resources/testdata/RegisterData.xlsx"
        );

        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("Test data file not found: " + path);
        }

        return ExcelUtil.getTestData(path, "Sheet1");
    }
}