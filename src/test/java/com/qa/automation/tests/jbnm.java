package com.qa.automation.tests;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jbnm {

    @Test
    public void forceAllure() {
        Allure.step("This is a manual step");
        Assert.assertTrue(true);
    }
}
