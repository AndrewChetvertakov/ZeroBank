@smoke
Feature: Find Transactions in Account Activity

  Background:
    When user navigates to "Login Page" url
    And user login to the application successfully
    And user navigates to "Account Activity" page
    Given the user clicks "Find Transactions" tab on "Account Activity" page

  @smoke
  Scenario Outline: Search date range
    When the user enters date range from "<start date>" to "<end date>"
    And the user clicks "Find" tab on "Account Activity" page
    Then results table should only show transactions dates between "<start date>" to "<end date>"
    Examples:
      | start date | end date   |
      | 2012-09-01 | 2012-09-01 |
      | 2012-09-01 | 2012-09-06 |
      | 2012-09-02 | 2012-09-06 |
      | 2012-04-07 | 2019-08-11 |

  @smoke
  Scenario Outline: Search transaction functionality
    When user selects value "<valueOfSelect>" from "Type Select" on "Account Activity" page
    When the user clicks "Find" tab on "Account Activity" page
    Then results table should show "<condition>" <amount> results under "<column>"
    Examples:
      | valueOfSelect | condition | amount | column     |
      | Any           | at least  | 1      | Deposit    |
      | Any           | at least  | 1      | Withdrawal |
      | Deposit       | at least  | 1      | Deposit    |
      | Deposit       | only      | 0      | Withdrawal |
      | Withdrawal    | at least  | 1      | Withdrawal |
      | Withdrawal    | only      | 0      | Deposit    |

