package com.qa.automation.framework.dataProviders;


import org.testng.annotations.DataProvider;

import com.qa.automation.framework.utils.ExcelUtil;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelUtil.getTestData(
                "src/test/resources/testdata/LoginData.xlsx",
                "Sheet1"
        );
    }
}

//public class LoginDataProvider {
//
//    @DataProvider(name = "loginData")
//    public Object[][] getLoginData() {
//
//        return new Object[][] {
//                {"valid@test.com", "Test@123", true},
//                {"invalid@test.com", "wrongPass", false}
//        };
//    }
