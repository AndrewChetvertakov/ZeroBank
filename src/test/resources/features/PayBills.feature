@smoke
Feature: Pay Bills Functionalities Tests

  Background: User logs in and navigates to Pay Bills tab
    When user navigates to "Login Page" url
    And user login to the application successfully
    And user navigates to "Pay Bills" page
    Then "Pay Bills" page title should be "Zero - Pay Bills"

  @smoke
  Scenario Outline: Pay Bills negative tests
    When user completes pay operation "<type of operation>"
    Then "Please fill out this field." message should pop up on "Pay Bills" page
    Examples:
      | type of operation                    |
      | without entering the date            |
      | without entering the amount          |
      | without entering the amount and date |
      | entering date as text                |

  @smoke
  Scenario: Pay Bills positive tests
    When user completes pay operation "successfully"
    Then "The payment was successfully submitted." should be displayed on "Pay Bills"

#  "Amount field"  should not accept "alphabetical"  or special characters. <== it very well accepts alphabet
#  "Date field"    should not accept "alphabetical characters".