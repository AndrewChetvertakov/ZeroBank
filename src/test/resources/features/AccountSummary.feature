Feature: Account summary

  @smoke
  Scenario: Account Summary Page tests
    When user navigates to "Landing Page" page
    And user login to the application
#    And user navigates to "Account Summary" page
    Then "Account Summary" page title should be "Zero - Account Summary"
    And Account summary page should have to following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table must have columns:
      | Account     |
      | Credit Card |
      | Balance     |