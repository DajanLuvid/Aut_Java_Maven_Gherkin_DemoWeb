# Web Automation with Java and POM

This project is an example of web automation using **Java** and the **Page Object Model (POM)** design pattern. The goal is to validate the login and purchase flow on the **Swag Labs** page, applying best practices in code organization and automated test definition.

## Technologies Used
- **Java**: Main programming language  
- **Maven**: Dependency management and project execution  
- **JUnit**: Test framework and assertions  
- **Gherkin (Cucumber)**: Human-readable definition of test scenarios  
- **Page Object Model (POM)**: Design pattern to separate business logic and UI elements  

## Test Scenario (Gherkin)

```gherkin
Feature: Swag Labs Page
  AS a user I WANT to log in with my credentials SO THAT I can make purchases

  Scenario Outline: Reach the shopping cart
    Given The user is on the Swag Labs Home
    When They enter their user credentials
      And Access the shopping page
      And Select the product "<product1>"
      And Select the product "<product2>"
      And Deselect the product "<product3>"
      And Click on the option "<page2name>"
    Then They access the page with the title "<page2title>"
```

## Project Structure

- src/test/java → Contains automated tests
- src/main/java → Classes with the Page Object Model (POM)
- pom.xml → Project configuration and dependencies

## How to Run the Tests

- Clone this repository
- Install dependencies with Maven

mvn clean install

- Run the tests

mvn test


This example demonstrates how to combine BDD with Gherkin and the POM design pattern to keep web automation projects scalable and maintainable.
