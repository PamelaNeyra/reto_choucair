@contactus
Feature: Contact Us

  Scenario: Just click on Send
    Given Navigate to Page Contact Us
    When A User clicks on Send button
    Then Application shows an error message to Send

  Scenario: Send a Message
    Given Navigate to Page Contact Us
    When A User enters values to send
    And A User clicks on Send button 2
    Then Application shows a success message

  Scenario: Send a Message without subject
    Given Navigate to Page Contact Us
    When A User enters values to send but not a subject
    And A User clicks on Send button 2
    Then Application shows an error message without a subject

  Scenario: Send a Message in blank
    Given Navigate to Page Contact Us
    When A User enters values to send but not a message
    And A User clicks on Send button 2
    Then Application shows an error message in blank
