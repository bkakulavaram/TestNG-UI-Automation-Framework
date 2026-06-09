package com.qa.automation.framework.context;

public class TestContext {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public TestContext setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TestContext setPassword(String password) {
        this.password = password;
        return this;
    }
}