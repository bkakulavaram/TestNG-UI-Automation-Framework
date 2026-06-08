package com.qa.automation.framework.dataProviders;

import org.testng.annotations.DataProvider;
import com.qa.automation.framework.utils.ExcelUtil;


public class RegisterDataProvider {
    @DataProvider(name = "registerData")
    public Object[][] registerData() {

        return ExcelUtil.getTestData(
                "src/test/resources/testdata/RegisterData.xlsx",
                "Sheet1"
        );
    }
//    @DataProvider(name = "registerData")
//    public Object[][] registerData() {
//
//        return new Object[][] {
//                {"Male", "John", "Doe"},
//                {"Female", "Jane", "Smith"}
//        };
//    }
}