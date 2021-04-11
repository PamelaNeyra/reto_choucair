@createAccount
Feature: Create Account

  Scenario: An invalid email to create an Account
    Given Navigate to Page Sign up
    When A User enters an invalid email to create
    And A User clicks on Create an Account button
    Then Application shows an error message to create

  Scenario: An existing email
    Given Navigate to Page Sign up
    When A User enters an existing email to create
    And A User clicks on Create an Account button
    Then Application shows an error to an existing email

  Scenario: A valid email to create an Account and Error
    Given Navigate to Page Sign up
    When A User enters a valid email to create
    And A User clicks on Create an Account button
    And A User clicks on Register
    Then Application shows an error message to register

  Scenario: A valid email to create an Account
    Given Navigate to Page Sign up
    When A User enters a valid email to create
    And A User clicks on Create an Account button
    And A User enters values to register
    And A User clicks on Register
    Then Application shows the page My account