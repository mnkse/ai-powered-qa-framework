# AI-Powered QA Framework 🚀

AI-Powered QA Framework is a modern hybrid test automation framework built with Selenium, Cucumber BDD, Rest Assured, Maven, GitHub Actions, Allure Reporting, and OpenAI integration.

This framework supports both UI and API automation testing while also providing AI-assisted failure analysis for failed test scenarios.

---

# 🔥 Features

## ✅ UI Automation
- Selenium WebDriver
- Java 21
- Page Object Model (POM)
- Explicit Wait utilities
- Headless Chrome support
- Thread-safe DriverFactory
- Parallel execution support

---

## ✅ API Automation
- Rest Assured
- GET / POST API testing
- API key management with GitHub Secrets
- Hybrid UI + API execution

---

## ✅ BDD Structure
- Cucumber BDD
- Feature files
- Step Definitions
- Hooks management

---

## ✅ Reporting
- Allure Report integration
- Screenshot on failure
- GitHub Pages Allure publishing
- Cucumber HTML report

---

## ✅ CI/CD
- GitHub Actions
- Maven profiles
- Workflow Dispatch support
- UI / API / Smoke test selection
- Ubuntu runner
- Chrome Headless execution

---

# 🤖 AI-Powered Failure Analysis

This framework includes a custom AI Failure Analyzer integrated with OpenAI API.

When a test fails:
- Screenshot is captured
- Failure details are collected
- OpenAI analyzes the failure
- AI-generated recommendations are written into a markdown report

Generated report example:

```text
target/ai-analysis/ai-failure-analysis.md
```

AI analysis may include:
- Root cause detection
- Locator strategy suggestions
- Stability improvements
- CI/CD recommendations
- Synchronization improvements

---

# 🧠 Technologies Used

- Java 21
- Selenium 4
- Cucumber 7
- JUnit 4
- Rest Assured
- Maven
- GitHub Actions
- Allure Report
- OpenAI API
- Java HttpClient

---

# ⚡ Parallel Execution

Framework supports parallel execution using Maven Surefire Plugin.

```xml
<parallel>methods</parallel>
<threadCount>2</threadCount>
```

---

# 🔐 Secret Management

Sensitive data is managed securely using:
- GitHub Secrets
- Environment Variables

Example:

```powershell
$env:OPENAI_API_KEY="your-api-key"
```

---

# ▶️ Run Tests

## Run All Tests

```bash
mvn clean test
```

## Run UI Tests

```bash
mvn test -Pui
```

## Run API Tests

```bash
mvn test -Papi
```

## Run Smoke Tests

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

---

# 📊 Allure Report

Generate Allure report locally:

```bash
allure serve target/allure-results
```

GitHub Actions automatically publishes Allure reports to GitHub Pages.

---

# 📁 Project Structure

```text
src
 ├── main
 └── test
      ├── features
      ├── pages
      ├── runners
      ├── stepDefinitions
      ├── apiTests
      └── utils
```

---

# 🚀 Future Improvements

Planned enhancements:
- AI response parsing
- AI flaky test detection
- AI self-healing locators
- AI-generated test cases
- AI-powered log analysis
- Docker support
- Selenium Grid
- Jenkins pipeline
- Advanced Allure attachments
- Retry optimization
- Environment management
- JSON schema validation

---

# 👨‍💻 Author

MENEKŞE ERHAN  
Senior QA Automation Engineer