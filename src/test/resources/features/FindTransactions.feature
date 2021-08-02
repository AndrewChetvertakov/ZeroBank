Feature: Find Transactions in Account Activity
 @smoke
  Scenario: Search date range
#    When user navigates to "Landing Page" page
#    And the user clicks "signInButton" tab on "Landing Page" page
   When user navigates to "Login Page" url
    And user login to the application with "Correct" credentials: "username" and "password"
    And user navigates to "Account Activity" page
    Given the user clicks "Find Transactions" tab on "Account Activity" page
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And the user clicks "Find" tab on "Account Activity" page
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
#    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And the user clicks "Find" tab on "Account Activity" page
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
#    And the results table should only not contain transactions dated "2012-09-01"

