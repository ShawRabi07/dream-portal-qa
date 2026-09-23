# Dream Portal QA Automation

## Project Overview

This project automates functional testing of the Dream Portal website using Selenium WebDriver, Java, TestNG, and the Page Object Model (POM).

The automation verifies the Home Page, Dreams Diary, and Dreams Summary pages.

## Website Under Test

Dream Portal: https://arjitnigam.github.io/myDreams/

## Technologies Used

* Java 21
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* Page Object Model (POM)
* Eclipse IDE

## Project Structure

```text
dream-portal-qa
├── src
│   ├── main
│   └── test
│       └── java
│           └── com.dreamportal
│               ├── base
│               │   └── DriverFactory.java
│               ├── pages
│               │   ├── HomePage.java
│               │   ├── DreamDiaryPage.java
│               │   └── DreamsTotalPage.java
│               └── tests
│                   ├── HomePageTest.java
│                   ├── DreamDiaryPageTest.java
│                   └── DreamsTotalPageTest.java
├── target
├── test-output
├── pom.xml
└── README.md
```

## Test Coverage

### Home Page

* Verify Home Page title
* Verify loading animation appears
* Verify loading animation disappears
* Verify main content appears after loading
* Verify "My Dreams" button appears
* Verify "My Dreams" opens the required dream pages

### Dreams Diary

* Verify page title
* Verify page heading
* Verify exactly 10 dream entries
* Verify dream types are Good or Bad
* Verify all table rows contain complete data

### Dreams Summary

* Verify page title
* Verify page heading
* Verify Good Dreams count
* Verify Bad Dreams count
* Verify Total Dreams count
* Verify Recurring Dreams count
* Verify recurring dream names

## Test Results

The test suite was executed using Maven.

```text
Tests run: 18
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

All automated tests passed successfully.

## Reporting

Test execution reports are generated under:

```text
target/surefire-reports
```

The HTML report contains the test execution results and shows:

```text
18 methods, 18 passed
```

## How to Run

### Using Eclipse

1. Import the project as a Maven project.
2. Right-click the project.
3. Select:

```text
Run As → Maven test
```

### Using Maven Command Line

Run:

```bash
mvn test
```

## Assertions

The project uses TestNG assertions such as:

* `assertEquals()`
* `assertTrue()`

These assertions verify expected page titles, headings, dream counts, dream types, table data, and navigation behavior.

## Page Object Model

The project follows the Page Object Model design pattern.

Page classes contain:

* Web element locators
* Page-specific actions
* Page-specific methods

Test classes contain:

* Test scenarios
* Test execution
* Assertions

This separation makes the automation code easier to maintain and reuse.

## Future Enhancement

An optional AI-based validation can be added to classify dream names as Good or Bad and compare the AI classification with the values displayed in the Dreams Diary.

## Author

Rabi Shaw
