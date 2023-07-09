Feature: Add three products to cart

  Scenario: Add three product to cart successfully
    Given that user open page falabella and search any product
    When user clicks on the product title and chooses to add three of the product
    Then user will confirm that it is the product and quantity chosen in the cart
