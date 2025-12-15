# QA User API Automation

This repository contains an **API test automation project** created to practice  
**REST API testing, negative scenarios, mock server usage, and basic CI/CD integration**  
from a **Junior QA / Test Automation Engineer** perspective.

The project is designed to run **independently of a real backend** by using a mock server,  
making it reliable and suitable for learning CI-based test execution.

---

## 🧪 Project Scope

The test suite covers **basic CRUD operations** and **negative test scenarios**  
for a simple User API.

### Covered Scenarios
- Create a user
- Get user by ID
- Get all users
- Update user
- Delete user
- Invalid ID scenarios (400)
- User not found scenarios (404)

All tests focus on validating **HTTP status codes and API behavior**,  
not backend implementation details.

---

## 🛠 Technologies Used

- **Java 17**
- **RestAssured** – API test automation
- **JUnit 5** – Test framework
- **Maven** – Build and dependency management
- **JSON Server** – Mock REST API
- **GitHub Actions** – CI pipeline

---

## 📁 Project Structure

```text
qa-user-api-automation
├── automation
│   ├── src
│   │   └── test
│   │       └── java
│   │           └── com.gulsenem.api
│   │               ├── base
│   │               │   └── BaseTest.java
│   │               ├── helpers
│   │               │   ├── ApiTestAssertions.java
│   │               │   └── UserTestHelper.java
│   │               └── users
│   │                   ├── CreateUserTest.java
│   │                   ├── GetUsersTest.java
│   │                   ├── GetUserInvalidIdTest.java
│   │                   ├── GetUserNotFoundTest.java
│   │                   ├── UpdateUserTest.java
│   │                   └── DeleteUserTest.java
│   └── pom.xml
│
├── mock
│   └── db.json
│
├── .github
│   └── workflows
│       └── api-tests.yml
│
└── README.md

🔎 Structure Overview

base: Common RestAssured configuration

helpers: Reusable helper methods and shared assertions

users: Test classes grouped by API behavior

mock: JSON Server based mock API

.github/workflows: GitHub Actions CI configuration

🧠 Design Approach
🔹 BaseTest

Centralizes RestAssured configuration

Avoids repeating base URL and headers in every test

Keeps test classes clean and consistent

🔹 Shared Assertions

Common HTTP assertions (such as 400 and 404) are placed in
ApiTestAssertions to:

Reduce code duplication

Improve readability

Make tests easier to maintain

🔹 Mock Server

A JSON-based mock server is used to:

Practice API testing without a real backend

Keep test data predictable

Allow tests to run in CI without environment dependencies

🚀 How to Run Tests Locally
Prerequisites

Java 17+

Maven

Node.js

Steps
# Install mock server dependencies
cd mock
npm install

# Start mock server
npx json-server --watch db.json --port 3000

Open a new terminal:
cd automation
mvn test

🤖 CI / CD Pipeline

This project includes a GitHub Actions workflow that automatically:

Checks out the repository

Sets up Java and Node.js

Installs mock server dependencies

Starts the mock server

Runs API tests

This helps practice basic CI concepts as a junior QA engineer.

🎯 QA Learning Focus

This project is built to improve skills in:

API test automation fundamentals

HTTP status code validation

Negative test scenarios

Clean and maintainable test structure

CI-ready test execution

It reflects a learning-oriented QA automation approach.

👩‍💻 Author

Gülsenem Güven
Junior QA / Test Automation Engineer

GitHub: https://github.com/gulsenemguvenn