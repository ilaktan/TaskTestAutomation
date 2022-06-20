#Instructions



#### Codes and Tests Prepared by:
**Ilhami Aktan**

*QA Test Automation Engineer / Test Engineer*

aktanilhami@gmail.com

https://github.com/ilaktan


------------
•  I built my framework using Java Programming Language.

•  Dependencies were installed into the pom

•  I build Tool: Maven

•  My Test Framework: Cucumber BBD (with Junit  Assertions)

•  Inside the Cucumber runner, I used glues to connect feature files to step definitions.

•  I added the report plugin to Cucumber Runner to generate a Json and HTML report.

•  I have an utilities package, which contains utility classes such as Generic Functions and Configuration Reader.

•  I am using Page Object Modelling to enhance test maintenance and reduce code duplication.

•  I am using Cucumber and Gherkin language for non-technical people to understand what is going on in testing.

•  I used a Cucumber Scenario outline, and an example feature.

•  I have created my test cases in the feature files as-is.

•  In the Feature folder, I store my feature files separately, and it helps in the usability of the codes.

•  I use hook class as pre-and post-test implementations.

•  In the Generic Functions class I put some methods which I am using in my test scripts.

•  In the Common Methods class I put some methods which are related with application.

•  I added a screenshot interface; when the scenario fails, it takes a screenshot.

•  For assertions/verifications, to compare expected and actual results I utilize Junit assertions.

•  I also use tags for tests that I want to run in bulk.

•  My framework is easy to maintain. I know where to go and how to fix it to run test scripts correctly.


--------------




####System Requirements:
-Java 8+ SDK

####Step1;
-Clone the project from GitHub or download the project from file

####Step2;
-Test RUN

----------------


## Test RUN

### Run option 1;
Go **src -> test > java > Chetwood > runners > CukesRunner and RUN**

To run all Scenarios, use @wip tag in the CukesRunner class/Cucumber Options

To generate "HTML Maven Cucumber Report" ;

### Run option 2;
Open Maven right side panel > Double Click Project's Lifecycle > Click "verify"

### Run option 3;
Run from command line invoke mvn clean verify


## Test Reports Locations
1- When you run my project, Cucumber will create automatically online report link.
You can click the link with in the 24 hours and check the all test steps and status. I added a sample screenshot at Project level.

2- Cucumber HTML Plugin Reports
**target -> cucumber-html-reports > overview-steps.html** 
(Right Click and Open in any Browser )


Link Sample:
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/1ec76144-a894-483a-8e14-1ef05999c00c │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │

Process finished with exit code -1

-----------------

## Cucumber Test
## Feature:
### 1-User is testing Interest and amount calculation functionality.

## Scenarios:
### 1-User on the LiveLend website homepage
### 2-User is testing borrow amount slider functionality
### 3-User is testing loan term slider functionality
### 4-User is testing Get my Quote button


Note:

To see which browser and URL , see the (TaskTestAutomation -> configuration.properties ) file

Users can switch the browser from Chrome to another browser in this file -> configuration.properties

To run separately this scenario, use the @test tag in the CukesRunner class/Cucumber Options



------------

2022 June&reg;

aktanilhami@gmail.com

###End

------------