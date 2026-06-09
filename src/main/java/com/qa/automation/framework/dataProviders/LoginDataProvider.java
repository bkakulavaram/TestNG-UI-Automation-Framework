package com.qa.automation.framework.dataProviders;

import com.qa.automation.framework.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData",parallel = true)
    public Object[][] loginData() {

        String path = System.getProperty(
                "loginDataPath",
                "src/test/resources/testdata/LoginData.xlsx"
        );

        return ExcelUtil.getTestData(path, "Sheet1");
    }
}