Feature: 

	#When user navigates to "Login Page" url
	#And user login to the application with "Invalid" credentials: "random" and "random"
	#Then "Invalid Credentials Message" should be displayed on "Login Page"
	@B225-259
	Scenario: Login functionality (test)
		When user navigates to "Login Page" url
		And user login to the application with "Invalid" credentials: "random" and "random"
		Then "Invalid Credentials Message" should be displayed on "Login Page"