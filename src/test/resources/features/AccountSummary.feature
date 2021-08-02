Feature: Account summary

  @smoke @testzz
  Scenario: Account Summary Page tests
    When user navigates to "Login Page" url
    And user login to the application with "Correct" credentials: "username" and "password"
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