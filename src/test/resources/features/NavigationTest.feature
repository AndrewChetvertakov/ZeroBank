Feature: navigation test
@test1
  Scenario: testing navigation step definition
    When user navigates to "Landing Page" page
    When user navigates to "Account Summary" page
    When user navigates to "Transfer Funds" page
    When user navigates to "Pay Bills" page
    When user navigates to "Account Activity" page
    When user navigates to "My Money Map" page
    When user navigates to "Online Statements" page
@Test2
  Scenario: log out test
    When user navigates to "Online Statements" page
    And user logs out of application
    Then "Landing Page" page title should be "Zero - Personal Banking - Loans - Credit Cards"
    When user navigates to "Pay Bills" page
    And user logs out of application