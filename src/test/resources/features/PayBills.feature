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

  @smoke
  Scenario: Add a new payee under pay bills
    Given the user clicks "Add New Payee" link on "Pay Bills" page
    And the user creates new payee using following information:
      | name    | The Law Offices of Hyde, Price & Scharks |
      | address | 100 Same st, Anytown, USA, 10001         |
      | account | Checking                                 |
      | details | XYZ account                              |
    Given the user clicks "Add" tab on "Pay Bills" page
    Then "The new payee Pew was successfully created." should be displayed on "Pay Bills"

  @smoke
  Scenario: Available currencies
    Given the user accesses "Purchase Foreign Currency" tab on "Pay Bills" page
    Then "Foreign Currency DropDown" should have following currencies available:
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  @smoke
  Scenario Outline: Error message for not entering value
    Given the user accesses "Purchase Foreign Currency" tab on "Pay Bills" page
    When user tries to calculate cost "<Type of Test>"
    Then "<Result Message>" alert should appear
    Examples:
      | Type of Test                 | Result Message |
      | without entering a value     | Please, ensure that you have filled all the required fields with valid values. |
      | without selecting a currency | Please, ensure that you have filled all the required fields with valid values. |

  @smoke
  Scenario: Successful foreign currency operation
    Given the user accesses "Purchase Foreign Currency" tab on "Pay Bills" page
    When user tries to calculate cost "successfully"
    Then "Foreign currency cash was successfully purchased." should be displayed on "Pay Bills"








