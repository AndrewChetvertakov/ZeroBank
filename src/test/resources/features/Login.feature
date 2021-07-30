@wip
Feature: Online Banking Login Feature
    Agile story:
    Only authorized users should be able to login to the application.

  Background:
    When user navigates to "Landing Page" page
    And user navigates to "Login Page" page


  Scenario: Authorized user should be able to login to the application
    And user login to the application with correct credentials
    Then "Account Summary" page should be displayed.


  Scenario: Users with wrong username or wrong password should not be able to login.
    When user tries to login with invalid information
    Then error message Login and/or password are wrong should be displayed


  Scenario: Users with blank username or password should also not be able to login.
    When user does not enter any credentials
    Then error message Login and/or password are wrong should be displayed


#  @wip
#  Scenario: user with valid credentials should be able to login to the application
#    When user enters correct credentials : <"username"> and <"password>