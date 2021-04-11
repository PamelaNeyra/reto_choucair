@login
Feature: Login

  Scenario: A valid email and an invalid password
    Given Navigate to Page Sign in
    When A User enters a valid email
    And A User enters an invalid password
    And A User clicks on Sign in button
    Then Application shows an error message

  Scenario: An email only
    Given Navigate to Page Sign in
    When A User enters an email
    And A User clicks on Sign in button
    Then Application shows an required password message

  Scenario: A password only
    Given Navigate to Page Sign in
    When A User enters a password
    And A User clicks on Sign in button
    Then Application shows an required email message

  Scenario: An invalid email and a valid password
    Given Navigate to Page Sign in
    When A User enters an invalid email
    And A User enters a valid password
    And A User clicks on Sign in button
    Then Application shows an error message

  Scenario: An invalid email and an invalid password
    Given Navigate to Page Sign in
    When A User enters an invalid email
    And A User enters an invalid password
    And A User clicks on Sign in button
    Then Application shows an error message

  Scenario: A valid email and a valid password
    Given Navigate to Page Sign in
    When A User enters a valid email
    And A User enters a valid password
    And A User clicks on Sign in button
    Then Application shows the user's account