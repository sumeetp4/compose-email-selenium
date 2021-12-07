# compose-email-selenium

This repository contains framework for testing compose email functionality using Selenium, Cucumber and Page Object Model.
Language used is Java and maven is used as build tool. WebDriverManager has been used for browser drivers setup.

To run the test, use the following command

mvn test -Duser=<username> -Dpass=<password>
  
Username and password can be specified in config.properties as well.
  
Local report is created in target folder.
Sharable report is created and published on https://reports.cucumber.io/reports
  

![cucumberReport](https://user-images.githubusercontent.com/29970107/144972379-6aa8b49b-db87-44c4-a148-0eb51882490d.PNG)
