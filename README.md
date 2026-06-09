# UI Automation Framework

A scalable UI Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), Data-Driven Testing, Selenium Grid, Extent Reports, and Allure Reporting.

## Tech Stack

* Java 17
* Selenium WebDriver 4
* TestNG
* Maven
* Page Object Model (POM)
* Apache POI (Excel Data Provider)
* Selenium Grid
* Extent Reports
* Allure Reports
* WebDriverManager

---

## Framework Features

### Test Design

* Page Object Model (POM)
* Reusable BasePage and BaseTest classes
* Thread-safe WebDriver management using ThreadLocal
* Environment-based configuration
* Parallel execution support
* Retry mechanism for flaky tests

### Data Management

* Excel-based test data
* Externalized configuration files
* Dynamic test data generation

### Reporting

* Extent Reports
* Allure Reports
* Automatic screenshot capture on failure
* Detailed execution logs

### Execution

* Local execution
* Cross-browser execution
* Selenium Grid execution
* Smoke, Regression and E2E suites
* Maven profile support

---

## Project Structure

```text
src
├── main
│   └── java
│       └── com.qa.automation.framework
│           ├── base
│           ├── config
│           ├── context
│           ├── drivers
│           ├── pages
│           ├── reports
│           └── utils
│
└── test
    └── java
        └── com.qa.automation.tests
            ├── LoginTest
            ├── RegisterTest
            └── E2ETest
```

---

## Test Scenarios

### Login Tests

* Valid Login
* Invalid Login
* Login Validation

### Registration Tests

* User Registration
* Dynamic Email Generation
* Registration Success Validation

### End-to-End Tests

* Register User
* Logout
* Login with Newly Created User
* Verify Successful Authentication

---

## Configuration

### QA Environment

`src/test/resources/qa.properties`

```properties
baseUrl=https://demowebshop.tricentis.com
browser=chrome
gridUrl=http://localhost:4444/wd/hub
```

---

## Maven Commands

### Run All Tests

```bash
mvn clean test
```

### Run QA Environment

```bash
mvn clean test -Denv=qa
```

### Run Smoke Suite

```bash
mvn clean test -Dgroups=smoke
```

### Run Regression Suite

```bash
mvn clean test -Dgroups=regression
```

### Run E2E Suite

```bash
mvn clean test -Dgroups=e2e
```

### Run On Selenium Grid

```bash
mvn clean test -Dgrid=true
```

---

## Generate Allure Report

Execute tests:

```bash
mvn clean test
```

Generate report:

```bash
allure serve allure-results
```

---

## Reporting

### Extent Report

```text
test-output/report.html
```

### Screenshots

```text
test-output/screenshots/
```

### Allure Results

```text
allure-results/
```

---

## Design Highlights

* Thread-safe WebDriver architecture
* Parallel execution ready
* Selenium Grid support
* Environment-driven execution
* Data-driven framework design
* Reporting integration
* Reusable page objects
* Maintainable and scalable structure

---

## Future Enhancements

* REST Assured API automation integration
* Jenkins CI/CD pipeline
* Dockerized Selenium Grid
* GitHub Actions execution
* Database validation layer
* Contract testing
* Cloud execution (BrowserStack / LambdaTest)

---

## Author

Bhargavi Reddy

Automation QA Engineer | SDET | Java | Selenium | TestNG | API Testing
