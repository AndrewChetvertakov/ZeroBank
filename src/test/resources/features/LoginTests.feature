@smoke
Feature: Online Banking Login Feature
  Agile story:
  Only authorized users should be able to login to the application.

  @smoke
  Scenario: Users with wrong username or wrong password should not be able to login.
    When user navigates to "Login Page" url
    And user login to the application with "Invalid" credentials: "random" and "random"
    Then "Invalid Credentials Message" should be displayed on "Login Page"

  @smoke
  Scenario: Authorized user should be able to login to the application
    When user navigates to "Login Page" url
    And user login to the application with "Correct" credentials: "username" and "password"
    Then "Account Summary" page title should be "Zero - Account Summary"

  @smoke
  Scenario: Users with blank username or password should also not be able to login.
    When user navigates to "Login Page" url
    And user login to the application with "Blank" credentials: "" and ""
    Then "Invalid Credentials Message" should be displayed on "Login Page"