Feature: navigation test

  @smoke
  Scenario: testing navigation step definition
    When user navigates to "Login Page" url
    And user login to the application with "Correct" credentials: "username" and "password"
    When user navigates to "Account Summary" page
    When user navigates to "Pay Bills" page
    When user navigates to "Account Activity" page
    When user navigates to "Landing Page" page
#    When user navigates to "My Money Map" page       <--- don't have this page yet
#    When user navigates to "Online Statements" page  <--- don't have this page yet
#    When user navigates to "Transfer Funds" page     <--- don't have this page yet