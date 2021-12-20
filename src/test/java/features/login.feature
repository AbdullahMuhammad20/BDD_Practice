Feature: Test the login functionality
  Scenario: The user need to login with valid email and valid password
    Given user open the portal and go to login page
    When  The user enter the email and password and click on login button
    Then  The user should navigate to main the home page
    And   The Current URL is contain home


