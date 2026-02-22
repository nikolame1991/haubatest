🛠️ Hauba.rs - Selenium Automation Project

Automated tests for https://www.hauba.rs/ using Java, Selenium WebDriver, TestNG, and Page Object Model (POM).

This project demonstrates how to automate functionalities on the Hauba.rs website using a modular, maintainable, and readable test architecture.

💡 Contents

📌 Project Description

🧪 Automated Scenarios

🧱 Technologies

🗂️ Project Structure

🚀 How to Run

🔍 Reports

🤝 Contributing

📄 License

📌 Project Description

This project automatically tests the main functionalities of the Hauba.rs website — including vehicle search, filters, navigation, and element verification on pages. The goal is to build a stable and scalable test framework that can expand as the website requirements grow.

🧪 Automated Scenarios

Tests cover the following:

✔️ Launch browser and open Hauba.rs
✔️ Verify homepage title
✔️ Fill search filters (brand, model, price, year, etc.)
✔️ Click the Search button
✔️ Verify the URL with search parameters
✔️ Validate results on the page
✔️ Negative tests (e.g., no results)

🧱 Technologies
Technology	Version / Tool
Java	11+
Selenium WebDriver	Latest
TestNG	Latest
Maven	Latest
Page Object Model	Design Pattern
WebDriverManager	Manages browser drivers
IntelliJ / VS Code	Recommended IDE
🗂️ Project Structure
📦 hauba-automation
├── 📁 src
│   ├── 📁 main
│   │   └── 📁 java
│   │       └── 📁 pages
│   │           ├── BasePage.java         # Base class for all Page Object classes
│   │           ├── HomePage.java         # Logic for homepage interactions
│   │           └── ResultsPage.java      # Logic for search results page
│   ├── 📁 test
│       └── 📁 java
│           └── tests
│               ├── BaseTest.java        # Setup and teardown browser
│               ├── SearchTest.java      # Search and filter tests
│               └── ValidationTest.java  # Results verification and negative tests
├── 📄 pom.xml                            # Maven configuration and dependencies
├── 📄 testng.xml                         # TestNG configuration
└── 📄 README.md
🚀 How to Run

Clone the repository

git clone https://github.com/<your_username>/hauba-automation.git

Go into the project folder

cd hauba-automation

Run tests via Maven

mvn clean test

Alternatively — from IntelliJ / VS Code

Open the project in your IDE

Run testng.xml

🔍 Reports

After running the tests, reports are available at:

/target/surefire-reports

You can also use additional tools like Allure Reports or Extent Reports for a visual representation of test results.

🤝 Contributing

If you want to improve this project:

Fork the repository

Create a new branch (feature/xxx)

Make your changes

Submit a pull request

📄 License

This project is licensed under the MIT License.
