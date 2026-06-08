package com.qa.automation.framework.context;

public class TestContext {

    private static String email;
    private static String password;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TestContext.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        TestContext.password = password;
    }
}