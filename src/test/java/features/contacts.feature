Feature: Contact page features
  @Sanity @Regression
  Scenario: Make sure that the email text field is visible
    Given user open the portal and go to login page
    When  The user enter the email as "tiliwe5835@swsguide.com" and "Aa102030+++" and click on login button
    And   Clicks on contacts
    Then  Create button should be visible

  @Sanity @Regression
  Scenario: Add new contact
    Given user open the portal and go to login page
    When  The user enter the email as "tiliwe5835@swsguide.com" and "Aa102030+++" and click on login button
    And   Clicks on contacts
    And   clicks on add new Contact
    And   Fill the first name and password
    Then  A new contact should be added