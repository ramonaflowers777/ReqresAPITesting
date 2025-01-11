
# Reqres API Testing with REST Assured & Selenium (Aquality, TestNG)

## Overview
This project automates testin g for the Reqres API using REST Assured and follows BDD (Cucumber). It also integrates Selenium (Aquality), TestNG.

The API tests validate:

✔ User login with valid and invalid credentials

✔ Fetching users using GET requests

✔ User creation via POST requests
## Tech Stack

* Java 17+ (Test Automation)
* REST Assured (API Testing)
* TestNG (Test Execution & Assertions)
*  Cucumber (BDD) (Behavior-Driven Testing)
*  Maven (Dependency Management)

## Set up & Execution
**1.Prerequisites**
* Java 17+
* Maven
* Postman(Optional for API validation)

**2.Clone Repository**

git clone https://github.com/ramonaflowers777/ReqresAPITesting.git

**3.Install Dependencies**
- mvn clean install

**4.Run API Tests**
- You can run TestRunner class in src/test/java/runners

## API Utility:Request Handling

This project includes a utility class (ApiUtils) to manage API requests, ensuring clean and reusable code.

✔ Centralized request creation for cleaner test cases.

✔ Reusability in multiple tests (e.g., login, user creation).

## Best Practices Followed
✔ Reusable API Utility (ApiUtils) for request handling.

✔ Parameterized Tests using Cucumber Examples.

✔ BDD-Driven Feature Files for structured test cases.

✔ TestNG Assertions for validation.


