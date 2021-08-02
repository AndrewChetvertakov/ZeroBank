@smoke
Feature: Pay Bills


   Background: something
    When user navigates to "Login Page" url
    And user login to the application successfully
    And user navigates to "Pay Bills" page
    Then "Pay Bills" page title should be "Zero - Pay Bills"


  @wip
  Scenario Outline: Pay Bills tests
    When user completes pay operation "<type of operation>"
    Then "<Result>" should be displayed on "Pay Bills"
    Examples:
      | type of operation                    | Result                                  |
#      | without entering the date            | Please fill out this field message      |
#      | without entering the amount          | assert that pop up somehow?!?!?!      |
#      | without entering the amount and date | assert that pop up somehow?!?!?!       |
      | successfully                         | The payment was successfully submitted. |



#    @wip
#  When user completes pay operation "without entering the amount or date"
#    Then "Please fill out this field message" should be displayed on "Pay Bills"


#  "Amount field"  should not accept "alphabetical"  or special characters.
#  "Date field"    should not accept "alphabetical characters".

#  NOTE: . For the date input field you can just use sendKeys. No need to click on the date navigator.