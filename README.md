# QA Automation Framework

Hybrid UI + API Test Automation Framework built with Selenium, Cucumber BDD, Rest Assured, Maven, Allure Report and GitHub Actions CI/CD.

---

# 🚀 Tech Stack

- Java 21
- Selenium 4
- Cucumber BDD
- JUnit 4
- Rest Assured
- Maven
- Allure Report
- GitHub Actions
- GitHub Pages
- WebDriverManager
- Logback

---

# 📁 Framework Architecture

- Page Object Model (POM)
- BasePage design
- WaitUtils
- ThreadLocal DriverFactory
- Config-driven execution
- Tag-based test execution
- Reusable API Client
- Screenshot on failure
- Retry / rerun support

---

# ✅ Implemented Features

## UI Automation

- Selenium UI automation
- Cucumber feature files
- Step Definitions
- Smoke test support
- Headless execution
- Chrome CI execution
- Dynamic waits
- JavaScript click support for CI stability

---

## API Automation

- GET API tests
- POST API tests
- Response validation
- JSON assertions
- Reusable API client utility

---

## Reporting

- Allure Report integration
- Cucumber HTML report
- JSON report generation
- GitHub Pages Allure publish

---

# ⚙️ CI/CD Pipeline

Implemented with GitHub Actions.

## Supported workflow executions

- all
- ui
- api
- smoke

## Features

- Automated test execution
- Maven caching
- Headless Chrome setup
- GitHub Pages deployment
- Report artifact upload

---

# ▶️ Run Tests

## Run all tests

```bash
mvn clean test
```

## Run UI tests

```bash
mvn clean test -Pui
```

## Run API tests

```bash
mvn clean test -Papi
```

---

# 📊 Allure Report

Generate local report:

```bash
allure serve target/allure-results
```

---

# 🧪 Sample Tags

```gherkin
@ui @smoke
@ui @regression
@api
```

---

# 📌 Future Improvements

- Parallel execution
- Docker + Selenium Grid
- Environment management
- JSON schema validation
- AI Failure Analyzer
- AI self-healing locators
- AI visual testing
- API request/response attachment stabilization
- Nightly regression pipeline
- Push → smoke optimization

---

# 👨‍💻 Author

MENEKŞE ERHAN
Senior QA Automation Engineer