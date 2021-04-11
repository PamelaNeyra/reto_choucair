@purchaseorder
Feature: Purchase Order

  Scenario: A Purchase order
    Given Navigate to Page Shop
    When A User Sign in
    And A User adds an item to cart
    And A User proceeds to checkout
    Then Application shows a message about the order