@ui
Feature: Shopping Cart

  @cart
  Scenario: Add Blue Top product to cart

    Given user is on home page for cart test
    When user navigates to products page for cart
    And user adds Blue Top product to cart
    And user opens shopping cart
    Then Blue Top product should be displayed in cart
    And product quantity should be "1"