# 🚀 UI Automation Framework 

A **scalable, production-ready UI Automation Framework** built using **Java + Selenium WebDriver + TestNG + Maven**, designed with real-world **enterprise SDET architecture principles**.

This project demonstrates **clean automation design, parallel execution, distributed testing readiness, CI/CD compatibility, and professional reporting standards (Extent + Allure)**.

---

## 🧠 What This Project Demonstrates 

✔ Scalable automation framework architecture  
✔ Thread-safe execution using `ThreadLocal WebDriver`  
✔ Selenium Grid support for distributed execution  
✔ Page Object Model (POM) with reusable base layers  
✔ Data-driven testing using Apache POI (Excel integration)  
✔ Retry mechanism for flaky test handling  
✔ Parallel execution support (TestNG)  
✔ Environment-driven configuration (QA/Stage/Prod ready)  
✔ Dual reporting: Extent Reports + Allure Reports  
✔ Screenshot capture on failure (auto-attached to reports)  
✔ CI/CD-ready Maven structure  
✔ Clean separation of concerns (Framework / Tests / Utils / Drivers)  

---

## 🏗️ Tech Stack

- Java 17+
- Selenium WebDriver 4
- TestNG
- Maven
- Apache POI (Excel Data Provider)
- WebDriverManager
- Selenium Grid
- Extent Reports
- Allure Reports
- Git / GitHub (CI/CD Ready)


## 📁 Framework Architecture


---
src
├── main/java/com/qa/automation/framework

│ ├── base → BasePage, BaseTest

│ ├── config → ConfigReader (environment-based config)

│ ├── drivers → DriverFactory, DriverManager, GridFactory

│ ├── pages → Page Object Model classes

│ ├── listeners → TestNG & Extent listeners

│ ├── reports → Extent Report manager

│ └── utils → Utilities (Excel, Screenshot, Retry, Allure)

│

└── test/java/com/qa/automation/tests

├── LoginTest

├── RegisterTest

└── E2ETest


---

## ⚙️ Core Design Principles

### 🔹 Thread-Safe Execution
- Uses `ThreadLocal<WebDriver>` for isolated sessions
- Enables parallel execution without session conflicts

### 🔹 Environment-Based Execution
```bash
-Denv=qa
```
Supports:

QA

Staging

Production

🔹 Grid + Local Execution

Local browser execution (Chrome / Firefox / Edge)

Selenium Grid support (distributed execution ready)

🔹 Page Object Model (POM)

Clean separation of UI locators and actions

Reusable page methods

Reduces duplication and improves maintainability

🔹 Data-Driven Testing

Excel-based test data using Apache POI

Externalized test datasets

Supports multiple scenarios per test

🔹 Retry Mechanism

Automatic retry for flaky tests (TestNG RetryAnalyzer)

Improves CI stability

🔹 Reporting Strategy


📊 Extent Reports

Step-level execution logs
Screenshots on failure
HTML dashboard (/test-output/report.html)

📊 Allure Reports

CI/CD-friendly reporting
Screenshot attachments
Execution history tracking



🧪 Test Coverage



🔐 Login Module
Valid login validation
Invalid login validation
Assertion-based verification


🧾 Registration Module
Dynamic user registration
Data-driven input support
Success message validation


🔁 End-to-End Flow
User registration
Logout
Login with created user
Full workflow validation




⚙️ Maven Execution Commands




▶ Run all tests

mvn clean test

▶ Run QA environment

mvn clean test -Denv=qa

▶ Run Smoke tests

mvn clean test -Dgroups=smoke

▶ Run Regression tests

mvn clean test -Dgroups=regression

▶ Run E2E tests

mvn clean test -Dgroups=e2e

▶ Run with Selenium Grid

mvn clean test -Dgrid=true




📊 Reports




Extent Report

/test-output/report.html




<img width="1903" height="874" alt="image" src="https://github.com/user-attachments/assets/1ee6c180-1b80-4d0e-bfa0-be16b11b6f09" />





Allure Report

allure serve allure-results




<img width="858" height="447" alt="image" src="https://github.com/user-attachments/assets/049c20d9-9a7b-4709-bc7f-51aaa79dc0db" />




Screenshots

/test-output/screenshots/




🧱 CI/CD Ready Design




This framework is structured for integration with:

Jenkins Pipelines
GitHub Actions
Dockerized Selenium Grid
Kubernetes test execution
Cloud execution (BrowserStack / LambdaTest ready)



🔮 Future Enhancements



REST Assured API automation integration
Dockerized Selenium Grid setup
GitHub Actions CI pipeline
Kubernetes distributed execution
Database validation layer
Contract testing integration
Central logging + observability (ELK/Prometheus)
Cloud execution scaling layer



👨‍💻 Author

Bhargavi Reddy

SDET / QA Automation Engineer

Skills: Java • Selenium • TestNG • API Testing • CI/CD • Automation Framework Design

