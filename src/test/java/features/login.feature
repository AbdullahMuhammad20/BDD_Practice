Feature: Test the login functionality

  @Sanity
  Scenario: The user need to login with valid email and valid password
    Given user open the portal and go to login page
    When  The user enter the email as "tiliwe5835@swsguide.com" and "Aa102030+++" and click on login button
    Then  The user should navigate to main the home page



    @Regression
    Scenario Outline: Login with invalid credentials
    Given  user open the portal and go to login page
    When   The user enter the email as "<userName>" and "<password>" and click on login button
    Then   Error message should appear
    Examples:
      |userName|password|
      |tiliwe58335@swsguide.com|Aa1302030+++|
      |Invalid_email@test.com|Aa102030+++|
      |Invalid_password@test.com|Aa102030+|
